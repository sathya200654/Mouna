package androidx.wear.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.unit.Dp;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ToggleChip.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aß\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152 \b\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010!\u001aÜ\u0001\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00152 \b\u0002\u0010#\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2 \b\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0017\u001a\u00020$2\b\b\u0002\u0010\u0019\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010&\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006'"}, d2 = {"ICON_SPACING", "Landroidx/compose/ui/unit/Dp;", "F", "TOGGLE_CONTROL_HEIGHT", "TOGGLE_CONTROL_SPACING", "TOGGLE_CONTROL_WIDTH", "SplitToggleChip", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", Constants.ScionAnalytics.PARAM_LABEL, "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "onClick", "Lkotlin/Function0;", "toggleControl", "Landroidx/compose/foundation/layout/BoxScope;", "modifier", "Landroidx/compose/ui/Modifier;", "secondaryLabel", "colors", "Landroidx/wear/compose/material/SplitToggleChipColors;", "enabled", "checkedInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "clickInteractionSource", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "shape", "Landroidx/compose/ui/graphics/Shape;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/wear/compose/material/SplitToggleChipColors;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;III)V", "ToggleChip", "appIcon", "Landroidx/wear/compose/material/ToggleChipColors;", "interactionSource", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/wear/compose/material/ToggleChipColors;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;III)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToggleChipKt {
    private static final float TOGGLE_CONTROL_HEIGHT;
    private static final float TOGGLE_CONTROL_WIDTH;
    private static final float TOGGLE_CONTROL_SPACING = Dp.constructor-impl(4);
    private static final float ICON_SPACING = Dp.constructor-impl(6);

    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:104:0x012f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0132  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:111:0x0141  */
    /* JADX WARN: Code duplicated, block: B:113:0x0145  */
    /* JADX WARN: Code duplicated, block: B:115:0x014d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0150  */
    /* JADX WARN: Code duplicated, block: B:119:0x0157  */
    /* JADX WARN: Code duplicated, block: B:122:0x015f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0163  */
    /* JADX WARN: Code duplicated, block: B:127:0x016e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:130:0x0175  */
    /* JADX WARN: Code duplicated, block: B:133:0x0185  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:141:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:154:0x01da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:155:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:158:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:159:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:161:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:162:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:165:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:166:0x022e  */
    /* JADX WARN: Code duplicated, block: B:168:0x0234  */
    /* JADX WARN: Code duplicated, block: B:169:0x0236  */
    /* JADX WARN: Code duplicated, block: B:171:0x023a  */
    /* JADX WARN: Code duplicated, block: B:172:0x023c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0242  */
    /* JADX WARN: Code duplicated, block: B:176:0x024b  */
    /* JADX WARN: Code duplicated, block: B:179:0x0251  */
    /* JADX WARN: Code duplicated, block: B:180:0x026e  */
    /* JADX WARN: Code duplicated, block: B:183:0x0285  */
    /* JADX WARN: Code duplicated, block: B:186:0x0375  */
    /* JADX WARN: Code duplicated, block: B:190:0x0388  */
    /* JADX WARN: Code duplicated, block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:68:0x00be  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:93:0x0106  */
    /* JADX WARN: Code duplicated, block: B:94:0x0109  */
    /* JADX WARN: Code duplicated, block: B:99:0x0118  */
    public static final void ToggleChip(final boolean z, final Function1<? super Boolean, Unit> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5, ToggleChipColors toggleChipColors, boolean z2, MutableInteractionSource mutableInteractionSource, PaddingValues paddingValues, Shape shape, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function6;
        int i10;
        int i11;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        int i12;
        ToggleChipColors toggleChipColors2;
        int i13;
        int i14;
        int i15;
        int i16;
        MutableInteractionSource mutableInteractionSource2;
        int i17;
        int i18;
        PaddingValues paddingValues2;
        int i19;
        int i20;
        Modifier modifier3;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function8;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function9;
        Composer composer2;
        int i21;
        ToggleChipColors toggleChipColorsM861toggleChipColorsr6VPBpI;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues contentPadding;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource4;
        int i22;
        int i23;
        final ToggleChipColors toggleChipColors3;
        boolean z4;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function10;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function11;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource5;
        final PaddingValues paddingValues3;
        Composer composer3;
        final boolean z5;
        final Modifier modifier4;
        final ToggleChipColors toggleChipColors4;
        final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function12;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function13;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i24;
        Composer composerStartRestartGroup = composer.startRestartGroup(67184165);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ToggleChip)P(1,8,6,11,7!1,9!1,4,5)115@6233L18,119@6443L6,124@6635L40,125@6711L10,129@6827L36,137@7126L50,141@7291L49,142@7376L10,162@8028L32,120@6496L1566:ToggleChip.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) == 0) {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            if ((i3 & 4) != 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i4 |= i5;
            }
            if ((i3 & 8) != 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= 196608;
                    function6 = function4;
                } else {
                    function6 = function4;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    function7 = function5;
                } else {
                    function7 = function5;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        toggleChipColors2 = toggleChipColors;
                        if (composerStartRestartGroup.changed(toggleChipColors2)) {
                            i24 = 8388608;
                        }
                        i4 |= i24;
                    } else {
                        toggleChipColors2 = toggleChipColors;
                    }
                    i24 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i24;
                } else {
                    toggleChipColors2 = toggleChipColors;
                }
                i13 = i3 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        int i25 = i4;
                        if (composerStartRestartGroup.changed(z2)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i15 = i25 | i14;
                    }
                    i16 = i3 & 512;
                    if (i16 != 0) {
                        i16 = i16;
                        i17 = i15 | 805306368;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        if ((i & 805306368) == 0) {
                            mutableInteractionSource2 = mutableInteractionSource;
                            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i15 |= i18;
                        } else {
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        i17 = i15;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                            paddingValues2 = paddingValues;
                            int i26 = composerStartRestartGroup.changed(paddingValues2) ? 4 : 2;
                            i19 = i2 | i26;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        i19 = i2 | i26;
                    } else {
                        paddingValues2 = paddingValues;
                        i19 = i2;
                    }
                    if ((i2 & 48) != 0) {
                        i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
                    }
                    i20 = i19;
                    if ((i17 & 306783379) != 306783378 && (i20 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer3 = composerStartRestartGroup;
                        mutableInteractionSource5 = mutableInteractionSource2;
                        function12 = function6;
                        function13 = function7;
                        toggleChipColors4 = toggleChipColors2;
                        paddingValues3 = paddingValues2;
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = shape;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            } else {
                                function8 = function6;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            } else {
                                function9 = function7;
                            }
                            if ((i3 & 128) != 0) {
                                i21 = i16;
                                toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                                composer2 = composerStartRestartGroup;
                                i17 &= -29360129;
                            } else {
                                composer2 = composerStartRestartGroup;
                                i21 = i16;
                                toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                            }
                            if (i13 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i21 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                                contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                                i20 &= -15;
                            } else {
                                contentPadding = paddingValues;
                            }
                            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                                paddingValues2 = contentPadding;
                                shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                                i22 = i17;
                                i23 = i20 & (-113);
                                z4 = z3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                function11 = function9;
                                toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                                function10 = function8;
                            } else {
                                shape2 = shape;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                paddingValues2 = contentPadding;
                                i22 = i17;
                                i23 = i20;
                                toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                                z4 = z3;
                                function10 = function8;
                                function11 = function9;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 128) != 0) {
                                i17 &= -29360129;
                            }
                            if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                                i20 &= -15;
                            }
                            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                                i20 &= -113;
                            }
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                            function10 = function6;
                            function11 = function7;
                            toggleChipColors3 = toggleChipColors2;
                            mutableInteractionSource4 = mutableInteractionSource6;
                            z4 = z2;
                            shape2 = shape;
                            modifier3 = modifier2;
                            i22 = i17;
                            i23 = i20;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                        }
                        int i27 = i22 << 3;
                        int i28 = ((i22 >> 24) & 14) | (i27 & 112) | ((i22 >> 15) & 896);
                        PaddingValues paddingValues4 = paddingValues2;
                        int i29 = i22;
                        shape3 = shape2;
                        boolean z6 = z4;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifier5 = modifier3;
                        paddingValues3 = paddingValues4;
                        Composer composer4 = composer2;
                        composer3 = composer4;
                        int i30 = i23 << 3;
                        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function14 = function10;
                        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function15 = function11;
                        ToggleChipColors toggleChipColors5 = toggleChipColors3;
                        androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i28), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i28), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i28), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i28), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final Modifier invoke(boolean z7, boolean z8, Composer composer5, int i31) {
                                composer5.startReplaceGroup(1422134181);
                                ComposerKt.sourceInformation(composer5, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1422134181, i31, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                                }
                                Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z7, z8, composer5, i31 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer5.endReplaceGroup();
                                return modifierPaint$default;
                            }
                        }, z6, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer4, 0, 7), composer3, (i29 & 14) | 24576 | (i29 & 112) | (i27 & 1879048192), ((i29 >> 27) & 14) | 14380032 | (i30 & 112) | (i30 & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z6;
                        modifier4 = modifier5;
                        toggleChipColors4 = toggleChipColors5;
                        function12 = function14;
                        function13 = function15;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i31) {
                                ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i15 = i4;
                i16 = i3 & 512;
                if (i16 != 0) {
                    i16 = i16;
                    i17 = i15 | 805306368;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i & 805306368) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i15 |= i18;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i17 = i15;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                        }
                        i19 = i2 | i26;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    i19 = i2 | i26;
                } else {
                    paddingValues2 = paddingValues;
                    i19 = i2;
                }
                if ((i2 & 48) != 0) {
                    i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
                }
                i20 = i19;
                if ((i17 & 306783379) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                    }
                    int i210 = i22 << 3;
                    int i211 = ((i22 >> 24) & 14) | (i210 & 112) | ((i22 >> 15) & 896);
                    PaddingValues paddingValues5 = paddingValues2;
                    int i212 = i22;
                    shape3 = shape2;
                    boolean z7 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifier6 = modifier3;
                    paddingValues3 = paddingValues5;
                    Composer composer5 = composer2;
                    composer3 = composer5;
                    int i31 = i23 << 3;
                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function16 = function10;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function17 = function11;
                    ToggleChipColors toggleChipColors6 = toggleChipColors3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i211), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i211), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final Modifier invoke(boolean z8, boolean z9, Composer composer6, int i32) {
                            composer6.startReplaceGroup(1422134181);
                            ComposerKt.sourceInformation(composer6, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1422134181, i32, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                            }
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z8, z9, composer6, i32 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer6.endReplaceGroup();
                            return modifierPaint$default;
                        }
                    }, z7, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7), composer3, (i212 & 14) | 24576 | (i212 & 112) | (i210 & 1879048192), ((i212 >> 27) & 14) | 14380032 | (i31 & 112) | (i31 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z7;
                    modifier4 = modifier6;
                    toggleChipColors4 = toggleChipColors6;
                    function12 = function16;
                    function13 = function17;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                    }
                    int i213 = i22 << 3;
                    int i214 = ((i22 >> 24) & 14) | (i213 & 112) | ((i22 >> 15) & 896);
                    PaddingValues paddingValues6 = paddingValues2;
                    int i215 = i22;
                    shape3 = shape2;
                    boolean z8 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifier7 = modifier3;
                    paddingValues3 = paddingValues6;
                    Composer composer6 = composer2;
                    composer3 = composer6;
                    int i32 = i23 << 3;
                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function18 = function10;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function19 = function11;
                    ToggleChipColors toggleChipColors7 = toggleChipColors3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i214), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i214), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i214), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i214), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final Modifier invoke(boolean z9, boolean z10, Composer composer7, int i33) {
                            composer7.startReplaceGroup(1422134181);
                            ComposerKt.sourceInformation(composer7, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1422134181, i33, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                            }
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z9, z10, composer7, i33 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer7.endReplaceGroup();
                            return modifierPaint$default;
                        }
                    }, z8, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer6, 0, 7), composer3, (i215 & 14) | 24576 | (i215 & 112) | (i213 & 1879048192), ((i215 >> 27) & 14) | 14380032 | (i32 & 112) | (i32 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z8;
                    modifier4 = modifier7;
                    toggleChipColors4 = toggleChipColors7;
                    function12 = function18;
                    function13 = function19;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer7, int i33) {
                            ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer7, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i4 |= 24576;
            modifier2 = modifier;
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= 196608;
                function6 = function4;
            } else {
                function6 = function4;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    toggleChipColors2 = toggleChipColors;
                    if (composerStartRestartGroup.changed(toggleChipColors2)) {
                        i24 = 8388608;
                    }
                    i4 |= i24;
                } else {
                    toggleChipColors2 = toggleChipColors;
                }
                i24 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i24;
            } else {
                toggleChipColors2 = toggleChipColors;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    int i216 = i4;
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i15 = i216 | i14;
                }
                i16 = i3 & 512;
                if (i16 != 0) {
                    i16 = i16;
                    i17 = i15 | 805306368;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i & 805306368) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i15 |= i18;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i17 = i15;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                        }
                        i19 = i2 | i26;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    i19 = i2 | i26;
                } else {
                    paddingValues2 = paddingValues;
                    i19 = i2;
                }
                if ((i2 & 48) != 0) {
                    i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
                }
                i20 = i19;
                if ((i17 & 306783379) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                    }
                    int i217 = i22 << 3;
                    int i218 = ((i22 >> 24) & 14) | (i217 & 112) | ((i22 >> 15) & 896);
                    PaddingValues paddingValues7 = paddingValues2;
                    int i219 = i22;
                    shape3 = shape2;
                    boolean z9 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifier8 = modifier3;
                    paddingValues3 = paddingValues7;
                    Composer composer7 = composer2;
                    composer3 = composer7;
                    int i33 = i23 << 3;
                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function110 = function10;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function111 = function11;
                    ToggleChipColors toggleChipColors8 = toggleChipColors3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i218), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i218), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i218), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i218), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final Modifier invoke(boolean z10, boolean z11, Composer composer8, int i34) {
                            composer8.startReplaceGroup(1422134181);
                            ComposerKt.sourceInformation(composer8, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1422134181, i34, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                            }
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z10, z11, composer8, i34 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer8.endReplaceGroup();
                            return modifierPaint$default;
                        }
                    }, z9, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer7, 0, 7), composer3, (i219 & 14) | 24576 | (i219 & 112) | (i217 & 1879048192), ((i219 >> 27) & 14) | 14380032 | (i33 & 112) | (i33 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z9;
                    modifier4 = modifier8;
                    toggleChipColors4 = toggleChipColors8;
                    function12 = function110;
                    function13 = function111;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                    }
                    int i2110 = i22 << 3;
                    int i2111 = ((i22 >> 24) & 14) | (i2110 & 112) | ((i22 >> 15) & 896);
                    PaddingValues paddingValues8 = paddingValues2;
                    int i2112 = i22;
                    shape3 = shape2;
                    boolean z10 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifier9 = modifier3;
                    paddingValues3 = paddingValues8;
                    Composer composer8 = composer2;
                    composer3 = composer8;
                    int i34 = i23 << 3;
                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function112 = function10;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function113 = function11;
                    ToggleChipColors toggleChipColors9 = toggleChipColors3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i2111), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2111), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i2111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final Modifier invoke(boolean z11, boolean z12, Composer composer9, int i35) {
                            composer9.startReplaceGroup(1422134181);
                            ComposerKt.sourceInformation(composer9, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1422134181, i35, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                            }
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z11, z12, composer9, i35 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer9.endReplaceGroup();
                            return modifierPaint$default;
                        }
                    }, z10, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer8, 0, 7), composer3, (i2112 & 14) | 24576 | (i2112 & 112) | (i2110 & 1879048192), ((i2112 >> 27) & 14) | 14380032 | (i34 & 112) | (i34 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z10;
                    modifier4 = modifier9;
                    toggleChipColors4 = toggleChipColors9;
                    function12 = function112;
                    function13 = function113;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer9, int i35) {
                            ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer9, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i4 |= 100663296;
            i15 = i4;
            i16 = i3 & 512;
            if (i16 != 0) {
                i16 = i16;
                i17 = i15 | 805306368;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if ((i & 805306368) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i15 |= i18;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                i17 = i15;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                    }
                    i19 = i2 | i26;
                } else {
                    paddingValues2 = paddingValues;
                }
                i19 = i2 | i26;
            } else {
                paddingValues2 = paddingValues;
                i19 = i2;
            }
            if ((i2 & 48) != 0) {
                i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
            }
            i20 = i19;
            if ((i17 & 306783379) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                }
                int i2113 = i22 << 3;
                int i2114 = ((i22 >> 24) & 14) | (i2113 & 112) | ((i22 >> 15) & 896);
                PaddingValues paddingValues9 = paddingValues2;
                int i2115 = i22;
                shape3 = shape2;
                boolean z11 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifier10 = modifier3;
                paddingValues3 = paddingValues9;
                Composer composer9 = composer2;
                composer3 = composer9;
                int i35 = i23 << 3;
                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function114 = function10;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function115 = function11;
                ToggleChipColors toggleChipColors10 = toggleChipColors3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2114), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i2114), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2114), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i2114), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final Modifier invoke(boolean z12, boolean z13, Composer composer10, int i36) {
                        composer10.startReplaceGroup(1422134181);
                        ComposerKt.sourceInformation(composer10, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1422134181, i36, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                        }
                        Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z12, z13, composer10, i36 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer10.endReplaceGroup();
                        return modifierPaint$default;
                    }
                }, z11, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer9, 0, 7), composer3, (i2115 & 14) | 24576 | (i2115 & 112) | (i2113 & 1879048192), ((i2115 >> 27) & 14) | 14380032 | (i35 & 112) | (i35 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z11;
                modifier4 = modifier10;
                toggleChipColors4 = toggleChipColors10;
                function12 = function114;
                function13 = function115;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                }
                int i2116 = i22 << 3;
                int i2117 = ((i22 >> 24) & 14) | (i2116 & 112) | ((i22 >> 15) & 896);
                PaddingValues paddingValues10 = paddingValues2;
                int i2118 = i22;
                shape3 = shape2;
                boolean z12 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifier11 = modifier3;
                paddingValues3 = paddingValues10;
                Composer composer10 = composer2;
                composer3 = composer10;
                int i36 = i23 << 3;
                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function116 = function10;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function117 = function11;
                ToggleChipColors toggleChipColors11 = toggleChipColors3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i2117), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2117), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i2117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final Modifier invoke(boolean z13, boolean z14, Composer composer11, int i37) {
                        composer11.startReplaceGroup(1422134181);
                        ComposerKt.sourceInformation(composer11, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1422134181, i37, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                        }
                        Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z13, z14, composer11, i37 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer11.endReplaceGroup();
                        return modifierPaint$default;
                    }
                }, z12, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer10, 0, 7), composer3, (i2118 & 14) | 24576 | (i2118 & 112) | (i2116 & 1879048192), ((i2118 >> 27) & 14) | 14380032 | (i36 & 112) | (i36 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z12;
                modifier4 = modifier11;
                toggleChipColors4 = toggleChipColors11;
                function12 = function116;
                function13 = function117;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer11, int i37) {
                        ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer11, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 48;
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i4 |= i5;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
            } else {
                i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i4 |= i6;
        }
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= 196608;
                function6 = function4;
            } else {
                function6 = function4;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function7 = function5;
            } else {
                function7 = function5;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    toggleChipColors2 = toggleChipColors;
                    if (composerStartRestartGroup.changed(toggleChipColors2)) {
                        i24 = 8388608;
                    }
                    i4 |= i24;
                } else {
                    toggleChipColors2 = toggleChipColors;
                }
                i24 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i24;
            } else {
                toggleChipColors2 = toggleChipColors;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    int i2119 = i4;
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i15 = i2119 | i14;
                }
                i16 = i3 & 512;
                if (i16 != 0) {
                    i16 = i16;
                    i17 = i15 | 805306368;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i & 805306368) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i15 |= i18;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i17 = i15;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                        }
                        i19 = i2 | i26;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    i19 = i2 | i26;
                } else {
                    paddingValues2 = paddingValues;
                    i19 = i2;
                }
                if ((i2 & 48) != 0) {
                    i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
                }
                i20 = i19;
                if ((i17 & 306783379) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                    }
                    int i21110 = i22 << 3;
                    int i21111 = ((i22 >> 24) & 14) | (i21110 & 112) | ((i22 >> 15) & 896);
                    PaddingValues paddingValues11 = paddingValues2;
                    int i21112 = i22;
                    shape3 = shape2;
                    boolean z13 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifier12 = modifier3;
                    paddingValues3 = paddingValues11;
                    Composer composer11 = composer2;
                    composer3 = composer11;
                    int i37 = i23 << 3;
                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function118 = function10;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function119 = function11;
                    ToggleChipColors toggleChipColors12 = toggleChipColors3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i21111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i21111), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i21111), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i21111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final Modifier invoke(boolean z14, boolean z15, Composer composer12, int i38) {
                            composer12.startReplaceGroup(1422134181);
                            ComposerKt.sourceInformation(composer12, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1422134181, i38, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                            }
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z14, z15, composer12, i38 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer12.endReplaceGroup();
                            return modifierPaint$default;
                        }
                    }, z13, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer11, 0, 7), composer3, (i21112 & 14) | 24576 | (i21112 & 112) | (i21110 & 1879048192), ((i21112 >> 27) & 14) | 14380032 | (i37 & 112) | (i37 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z13;
                    modifier4 = modifier12;
                    toggleChipColors4 = toggleChipColors12;
                    function12 = function118;
                    function13 = function119;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        } else {
                            function8 = function6;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        } else {
                            function9 = function7;
                        }
                        if ((i3 & 128) != 0) {
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            composer2 = composerStartRestartGroup;
                            i21 = i16;
                            toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i21 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i20 &= -15;
                        } else {
                            contentPadding = paddingValues;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            paddingValues2 = contentPadding;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            i22 = i17;
                            i23 = i20 & (-113);
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            function11 = function9;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            function10 = function8;
                        } else {
                            shape2 = shape;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            paddingValues2 = contentPadding;
                            i22 = i17;
                            i23 = i20;
                            toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                            z4 = z3;
                            function10 = function8;
                            function11 = function9;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                    }
                    int i21113 = i22 << 3;
                    int i21114 = ((i22 >> 24) & 14) | (i21113 & 112) | ((i22 >> 15) & 896);
                    PaddingValues paddingValues12 = paddingValues2;
                    int i21115 = i22;
                    shape3 = shape2;
                    boolean z14 = z4;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifier13 = modifier3;
                    paddingValues3 = paddingValues12;
                    Composer composer12 = composer2;
                    composer3 = composer12;
                    int i38 = i23 << 3;
                    Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function1110 = function10;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function1111 = function11;
                    ToggleChipColors toggleChipColors13 = toggleChipColors3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i21114), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i21114), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i21114), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i21114), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final Modifier invoke(boolean z15, boolean z16, Composer composer13, int i39) {
                            composer13.startReplaceGroup(1422134181);
                            ComposerKt.sourceInformation(composer13, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1422134181, i39, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                            }
                            Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z15, z16, composer13, i39 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer13.endReplaceGroup();
                            return modifierPaint$default;
                        }
                    }, z14, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer12, 0, 7), composer3, (i21115 & 14) | 24576 | (i21115 & 112) | (i21113 & 1879048192), ((i21115 >> 27) & 14) | 14380032 | (i38 & 112) | (i38 & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z14;
                    modifier4 = modifier13;
                    toggleChipColors4 = toggleChipColors13;
                    function12 = function1110;
                    function13 = function1111;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer13, int i39) {
                            ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer13, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i4 |= 100663296;
            i15 = i4;
            i16 = i3 & 512;
            if (i16 != 0) {
                i16 = i16;
                i17 = i15 | 805306368;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if ((i & 805306368) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i15 |= i18;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                i17 = i15;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                    }
                    i19 = i2 | i26;
                } else {
                    paddingValues2 = paddingValues;
                }
                i19 = i2 | i26;
            } else {
                paddingValues2 = paddingValues;
                i19 = i2;
            }
            if ((i2 & 48) != 0) {
                i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
            }
            i20 = i19;
            if ((i17 & 306783379) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                }
                int i21116 = i22 << 3;
                int i21117 = ((i22 >> 24) & 14) | (i21116 & 112) | ((i22 >> 15) & 896);
                PaddingValues paddingValues13 = paddingValues2;
                int i21118 = i22;
                shape3 = shape2;
                boolean z15 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifier14 = modifier3;
                paddingValues3 = paddingValues13;
                Composer composer13 = composer2;
                composer3 = composer13;
                int i39 = i23 << 3;
                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function1112 = function10;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function1113 = function11;
                ToggleChipColors toggleChipColors14 = toggleChipColors3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i21117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i21117), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i21117), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i21117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final Modifier invoke(boolean z16, boolean z17, Composer composer14, int i310) {
                        composer14.startReplaceGroup(1422134181);
                        ComposerKt.sourceInformation(composer14, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1422134181, i310, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                        }
                        Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z16, z17, composer14, i310 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer14.endReplaceGroup();
                        return modifierPaint$default;
                    }
                }, z15, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer13, 0, 7), composer3, (i21118 & 14) | 24576 | (i21118 & 112) | (i21116 & 1879048192), ((i21118 >> 27) & 14) | 14380032 | (i39 & 112) | (i39 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z15;
                modifier4 = modifier14;
                toggleChipColors4 = toggleChipColors14;
                function12 = function1112;
                function13 = function1113;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                }
                int i21119 = i22 << 3;
                int i211110 = ((i22 >> 24) & 14) | (i21119 & 112) | ((i22 >> 15) & 896);
                PaddingValues paddingValues14 = paddingValues2;
                int i211111 = i22;
                shape3 = shape2;
                boolean z16 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifier15 = modifier3;
                paddingValues3 = paddingValues14;
                Composer composer14 = composer2;
                composer3 = composer14;
                int i310 = i23 << 3;
                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function1114 = function10;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function1115 = function11;
                ToggleChipColors toggleChipColors15 = toggleChipColors3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211110), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i211110), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211110), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i211110), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final Modifier invoke(boolean z17, boolean z18, Composer composer15, int i311) {
                        composer15.startReplaceGroup(1422134181);
                        ComposerKt.sourceInformation(composer15, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1422134181, i311, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                        }
                        Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z17, z18, composer15, i311 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer15.endReplaceGroup();
                        return modifierPaint$default;
                    }
                }, z16, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer14, 0, 7), composer3, (i211111 & 14) | 24576 | (i211111 & 112) | (i21119 & 1879048192), ((i211111 >> 27) & 14) | 14380032 | (i310 & 112) | (i310 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z16;
                modifier4 = modifier15;
                toggleChipColors4 = toggleChipColors15;
                function12 = function1114;
                function13 = function1115;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer15, int i311) {
                        ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer15, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i9 = i3 & 32;
        if (i9 != 0) {
            i4 |= 196608;
            function6 = function4;
        } else {
            function6 = function4;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 64;
        if (i11 != 0) {
            i4 |= 1572864;
            function7 = function5;
        } else {
            function7 = function5;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i4 |= i12;
            }
        }
        if ((i & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                toggleChipColors2 = toggleChipColors;
                if (composerStartRestartGroup.changed(toggleChipColors2)) {
                    i24 = 8388608;
                }
                i4 |= i24;
            } else {
                toggleChipColors2 = toggleChipColors;
            }
            i24 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i4 |= i24;
        } else {
            toggleChipColors2 = toggleChipColors;
        }
        i13 = i3 & 256;
        if (i13 != 0) {
            if ((i & 100663296) == 0) {
                int i21120 = i4;
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i15 = i21120 | i14;
            }
            i16 = i3 & 512;
            if (i16 != 0) {
                i16 = i16;
                i17 = i15 | 805306368;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if ((i & 805306368) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i15 |= i18;
                } else {
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                i17 = i15;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                    }
                    i19 = i2 | i26;
                } else {
                    paddingValues2 = paddingValues;
                }
                i19 = i2 | i26;
            } else {
                paddingValues2 = paddingValues;
                i19 = i2;
            }
            if ((i2 & 48) != 0) {
                i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
            }
            i20 = i19;
            if ((i17 & 306783379) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                }
                int i211112 = i22 << 3;
                int i211113 = ((i22 >> 24) & 14) | (i211112 & 112) | ((i22 >> 15) & 896);
                PaddingValues paddingValues15 = paddingValues2;
                int i211114 = i22;
                shape3 = shape2;
                boolean z17 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifier16 = modifier3;
                paddingValues3 = paddingValues15;
                Composer composer15 = composer2;
                composer3 = composer15;
                int i311 = i23 << 3;
                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function1116 = function10;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function1117 = function11;
                ToggleChipColors toggleChipColors16 = toggleChipColors3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211113), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i211113), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211113), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i211113), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final Modifier invoke(boolean z18, boolean z19, Composer composer16, int i312) {
                        composer16.startReplaceGroup(1422134181);
                        ComposerKt.sourceInformation(composer16, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1422134181, i312, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                        }
                        Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z18, z19, composer16, i312 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer16.endReplaceGroup();
                        return modifierPaint$default;
                    }
                }, z17, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer15, 0, 7), composer3, (i211114 & 14) | 24576 | (i211114 & 112) | (i211112 & 1879048192), ((i211114 >> 27) & 14) | 14380032 | (i311 & 112) | (i311 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z17;
                modifier4 = modifier16;
                toggleChipColors4 = toggleChipColors16;
                function12 = function1116;
                function13 = function1117;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    } else {
                        function8 = function6;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    } else {
                        function9 = function7;
                    }
                    if ((i3 & 128) != 0) {
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        composer2 = composerStartRestartGroup;
                        i21 = i16;
                        toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i21 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i20 &= -15;
                    } else {
                        contentPadding = paddingValues;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        paddingValues2 = contentPadding;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        i22 = i17;
                        i23 = i20 & (-113);
                        z4 = z3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function11 = function9;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        function10 = function8;
                    } else {
                        shape2 = shape;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        paddingValues2 = contentPadding;
                        i22 = i17;
                        i23 = i20;
                        toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                        z4 = z3;
                        function10 = function8;
                        function11 = function9;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
                }
                int i211115 = i22 << 3;
                int i211116 = ((i22 >> 24) & 14) | (i211115 & 112) | ((i22 >> 15) & 896);
                PaddingValues paddingValues16 = paddingValues2;
                int i211117 = i22;
                shape3 = shape2;
                boolean z18 = z4;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifier17 = modifier3;
                paddingValues3 = paddingValues16;
                Composer composer16 = composer2;
                composer3 = composer16;
                int i312 = i23 << 3;
                Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function1118 = function10;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function1119 = function11;
                ToggleChipColors toggleChipColors17 = toggleChipColors3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211116), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i211116), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211116), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i211116), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final Modifier invoke(boolean z19, boolean z110, Composer composer17, int i313) {
                        composer17.startReplaceGroup(1422134181);
                        ComposerKt.sourceInformation(composer17, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1422134181, i313, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                        }
                        Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z19, z110, composer17, i313 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer17.endReplaceGroup();
                        return modifierPaint$default;
                    }
                }, z18, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer16, 0, 7), composer3, (i211117 & 14) | 24576 | (i211117 & 112) | (i211115 & 1879048192), ((i211117 >> 27) & 14) | 14380032 | (i312 & 112) | (i312 & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z18;
                modifier4 = modifier17;
                toggleChipColors4 = toggleChipColors17;
                function12 = function1118;
                function13 = function1119;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer17, int i313) {
                        ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer17, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 100663296;
        i15 = i4;
        i16 = i3 & 512;
        if (i16 != 0) {
            i16 = i16;
            i17 = i15 | 805306368;
            mutableInteractionSource2 = mutableInteractionSource;
        } else {
            if ((i & 805306368) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i15 |= i18;
            } else {
                mutableInteractionSource2 = mutableInteractionSource;
            }
            i17 = i15;
        }
        if ((i2 & 6) == 0) {
            if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                }
                i19 = i2 | i26;
            } else {
                paddingValues2 = paddingValues;
            }
            i19 = i2 | i26;
        } else {
            paddingValues2 = paddingValues;
            i19 = i2;
        }
        if ((i2 & 48) != 0) {
            i19 |= ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0 || !composerStartRestartGroup.changed(shape)) ? 16 : 32;
        }
        i20 = i19;
        if ((i17 & 306783379) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i11 != 0) {
                    function9 = null;
                } else {
                    function9 = function7;
                }
                if ((i3 & 128) != 0) {
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    composer2 = composerStartRestartGroup;
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i21 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i20 &= -15;
                } else {
                    contentPadding = paddingValues;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    paddingValues2 = contentPadding;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    i22 = i17;
                    i23 = i20 & (-113);
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function11 = function9;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    function10 = function8;
                } else {
                    shape2 = shape;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    paddingValues2 = contentPadding;
                    i22 = i17;
                    i23 = i20;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    z4 = z3;
                    function10 = function8;
                    function11 = function9;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i11 != 0) {
                    function9 = null;
                } else {
                    function9 = function7;
                }
                if ((i3 & 128) != 0) {
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    composer2 = composerStartRestartGroup;
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i21 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i20 &= -15;
                } else {
                    contentPadding = paddingValues;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    paddingValues2 = contentPadding;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    i22 = i17;
                    i23 = i20 & (-113);
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function11 = function9;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    function10 = function8;
                } else {
                    shape2 = shape;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    paddingValues2 = contentPadding;
                    i22 = i17;
                    i23 = i20;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    z4 = z3;
                    function10 = function8;
                    function11 = function9;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
            }
            int i211118 = i22 << 3;
            int i211119 = ((i22 >> 24) & 14) | (i211118 & 112) | ((i22 >> 15) & 896);
            PaddingValues paddingValues17 = paddingValues2;
            int i2111110 = i22;
            shape3 = shape2;
            boolean z19 = z4;
            mutableInteractionSource5 = mutableInteractionSource4;
            Modifier modifier18 = modifier3;
            paddingValues3 = paddingValues17;
            Composer composer17 = composer2;
            composer3 = composer17;
            int i313 = i23 << 3;
            Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function11110 = function10;
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function11111 = function11;
            ToggleChipColors toggleChipColors18 = toggleChipColors3;
            androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211119), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i211119), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i211119), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i211119), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final Modifier invoke(boolean z110, boolean z111, Composer composer18, int i314) {
                    composer18.startReplaceGroup(1422134181);
                    ComposerKt.sourceInformation(composer18, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1422134181, i314, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                    }
                    Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z110, z111, composer18, i314 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer18.endReplaceGroup();
                    return modifierPaint$default;
                }
            }, z19, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer17, 0, 7), composer3, (i2111110 & 14) | 24576 | (i2111110 & 112) | (i211118 & 1879048192), ((i2111110 >> 27) & 14) | 14380032 | (i313 & 112) | (i313 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z19;
            modifier4 = modifier18;
            toggleChipColors4 = toggleChipColors18;
            function12 = function11110;
            function13 = function11111;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i11 != 0) {
                    function9 = null;
                } else {
                    function9 = function7;
                }
                if ((i3 & 128) != 0) {
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    composer2 = composerStartRestartGroup;
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i21 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i20 &= -15;
                } else {
                    contentPadding = paddingValues;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    paddingValues2 = contentPadding;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    i22 = i17;
                    i23 = i20 & (-113);
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function11 = function9;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    function10 = function8;
                } else {
                    shape2 = shape;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    paddingValues2 = contentPadding;
                    i22 = i17;
                    i23 = i20;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    z4 = z3;
                    function10 = function8;
                    function11 = function9;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    function8 = null;
                } else {
                    function8 = function6;
                }
                if (i11 != 0) {
                    function9 = null;
                } else {
                    function9 = function7;
                }
                if ((i3 & 128) != 0) {
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = ToggleChipDefaults.INSTANCE.m861toggleChipColorsr6VPBpI(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, null, composerStartRestartGroup, 0, 0, 2047);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    composer2 = composerStartRestartGroup;
                    i21 = i16;
                    toggleChipColorsM861toggleChipColorsr6VPBpI = toggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i21 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i20 &= -15;
                } else {
                    contentPadding = paddingValues;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    paddingValues2 = contentPadding;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    i22 = i17;
                    i23 = i20 & (-113);
                    z4 = z3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function11 = function9;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    function10 = function8;
                } else {
                    shape2 = shape;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    paddingValues2 = contentPadding;
                    i22 = i17;
                    i23 = i20;
                    toggleChipColors3 = toggleChipColorsM861toggleChipColorsr6VPBpI;
                    z4 = z3;
                    function10 = function8;
                    function11 = function9;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(67184165, i22, i23, "androidx.wear.compose.material.ToggleChip (ToggleChip.kt:120)");
            }
            int i2111111 = i22 << 3;
            int i2111112 = ((i22 >> 24) & 14) | (i2111111 & 112) | ((i22 >> 15) & 896);
            PaddingValues paddingValues18 = paddingValues2;
            int i2111113 = i22;
            shape3 = shape2;
            boolean z110 = z4;
            mutableInteractionSource5 = mutableInteractionSource4;
            Modifier modifier19 = modifier3;
            paddingValues3 = paddingValues18;
            Composer composer18 = composer2;
            composer3 = composer18;
            int i314 = i23 << 3;
            Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function11112 = function10;
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function11113 = function11;
            ToggleChipColors toggleChipColors19 = toggleChipColors3;
            androidx.wear.compose.materialcore.ToggleButtonKt.m941ToggleButtonULFYh8(z, function1, ProvidersKt.provideScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2111112), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), ProvidersKt.provideContent(toggleChipColors3.toggleControlColor(z4, z, composer2, i2111112), function2), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(toggleChipColors3.contentColor(z4, z, composer2, i2111112), function10), ProvidersKt.provideNullableScopeContent(toggleChipColors3.secondaryContentColor(z4, z, composer2, i2111112), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function11), new Function4<Boolean, Boolean, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final Modifier invoke(boolean z111, boolean z112, Composer composer19, int i315) {
                    composer19.startReplaceGroup(1422134181);
                    ComposerKt.sourceInformation(composer19, "CP(1)146@7509L86:ToggleChip.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1422134181, i315, -1, "androidx.wear.compose.material.ToggleChip.<anonymous> (ToggleChip.kt:146)");
                    }
                    Modifier modifierPaint$default = PainterModifierKt.paint$default(Modifier.Companion, (Painter) toggleChipColors3.background(z111, z112, composer19, i315 & 126).getValue(), false, (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 54, (Object) null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer19.endReplaceGroup();
                    return modifierPaint$default;
                }
            }, z110, mutableInteractionSource5, paddingValues3, shape3, TOGGLE_CONTROL_WIDTH, TOGGLE_CONTROL_HEIGHT, Dp.constructor-impl(0), TOGGLE_CONTROL_SPACING, ICON_SPACING, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer18, 0, 7), composer3, (i2111113 & 14) | 24576 | (i2111113 & 112) | (i2111111 & 1879048192), ((i2111113 >> 27) & 14) | 14380032 | (i314 & 112) | (i314 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z110;
            modifier4 = modifier19;
            toggleChipColors4 = toggleChipColors19;
            function12 = function11112;
            function13 = function11113;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.ToggleChip.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer19, int i315) {
                    ToggleChipKt.ToggleChip(z, function1, function3, function2, modifier4, function12, function13, toggleChipColors4, z5, mutableInteractionSource5, paddingValues3, shape3, composer19, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0126  */
    /* JADX WARN: Code duplicated, block: B:102:0x012a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0134  */
    /* JADX WARN: Code duplicated, block: B:105:0x0137  */
    /* JADX WARN: Code duplicated, block: B:107:0x013c  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:112:0x014d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0151  */
    /* JADX WARN: Code duplicated, block: B:116:0x015b  */
    /* JADX WARN: Code duplicated, block: B:117:0x015e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0163  */
    /* JADX WARN: Code duplicated, block: B:122:0x016d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0171  */
    /* JADX WARN: Code duplicated, block: B:126:0x0179  */
    /* JADX WARN: Code duplicated, block: B:127:0x017c  */
    /* JADX WARN: Code duplicated, block: B:130:0x0183  */
    /* JADX WARN: Code duplicated, block: B:133:0x0189  */
    /* JADX WARN: Code duplicated, block: B:135:0x018d  */
    /* JADX WARN: Code duplicated, block: B:138:0x0198 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:140:0x019d  */
    /* JADX WARN: Code duplicated, block: B:143:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:149:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:164:0x0203 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x0205  */
    /* JADX WARN: Code duplicated, block: B:166:0x020a  */
    /* JADX WARN: Code duplicated, block: B:168:0x020d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0210  */
    /* JADX WARN: Code duplicated, block: B:172:0x0216  */
    /* JADX WARN: Code duplicated, block: B:173:0x024a  */
    /* JADX WARN: Code duplicated, block: B:175:0x0254  */
    /* JADX WARN: Code duplicated, block: B:176:0x0256  */
    /* JADX WARN: Code duplicated, block: B:178:0x025a  */
    /* JADX WARN: Code duplicated, block: B:179:0x025c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0260  */
    /* JADX WARN: Code duplicated, block: B:182:0x0262  */
    /* JADX WARN: Code duplicated, block: B:185:0x0268  */
    /* JADX WARN: Code duplicated, block: B:186:0x0271  */
    /* JADX WARN: Code duplicated, block: B:189:0x0279  */
    /* JADX WARN: Code duplicated, block: B:190:0x028d  */
    /* JADX WARN: Code duplicated, block: B:194:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:197:0x0385  */
    /* JADX WARN: Code duplicated, block: B:201:0x039a  */
    /* JADX WARN: Code duplicated, block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    public static final void SplitToggleChip(final boolean z, final Function1<? super Boolean, Unit> function1, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function0<Unit> function0, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Modifier modifier, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5, SplitToggleChipColors splitToggleChipColors, boolean z2, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, PaddingValues paddingValues, Shape shape, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Modifier modifier2;
        int i10;
        int i11;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function6;
        int i12;
        SplitToggleChipColors splitToggleChipColors2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        PaddingValues paddingValues2;
        int i22;
        Modifier modifier3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function7;
        int i23;
        int i24;
        int i25;
        Composer composer2;
        final SplitToggleChipColors splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        PaddingValues contentPadding;
        int i26;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource5;
        int i27;
        MutableInteractionSource mutableInteractionSource6;
        boolean z4;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function8;
        Composer composer3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource7;
        final PaddingValues paddingValues3;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource8;
        final Modifier modifier4;
        final SplitToggleChipColors splitToggleChipColors3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i28;
        Composer composerStartRestartGroup = composer.startRestartGroup(895645118);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SplitToggleChip)P(!1,8,6,9,12,7,10,3,5)247@12938L23,252@13222L6,257@13419L31,258@13486L10,263@13630L56,271@13959L40,272@14035L10,288@14587L32,253@13275L1346:ToggleChip.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) == 0) {
            if ((i & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            i5 = 128;
            if ((i3 & 4) != 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            if ((i3 & 8) != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i4 |= i7;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= 196608;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    function6 = function5;
                } else {
                    function6 = function5;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        splitToggleChipColors2 = splitToggleChipColors;
                        if (composerStartRestartGroup.changed(splitToggleChipColors2)) {
                            i28 = 8388608;
                        }
                        i4 |= i28;
                    } else {
                        splitToggleChipColors2 = splitToggleChipColors;
                    }
                    i28 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i28;
                } else {
                    splitToggleChipColors2 = splitToggleChipColors;
                }
                i13 = i3 & 256;
                if (i13 != 0) {
                    if ((i & 100663296) == 0) {
                        int i29 = i4;
                        if (composerStartRestartGroup.changed(z2)) {
                            i14 = 67108864;
                        } else {
                            i14 = 33554432;
                        }
                        i15 = i29 | i14;
                    }
                    i16 = i3 & 512;
                    if (i16 != 0) {
                        i16 = i16;
                        i17 = i15 | 805306368;
                    } else {
                        if ((i & 805306368) != 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i18 = 536870912;
                            } else {
                                i18 = 268435456;
                            }
                            i15 |= i18;
                        }
                        i17 = i15;
                    }
                    i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                    if (i19 != 0) {
                        i20 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i21 = 4;
                        } else {
                            i21 = 2;
                        }
                        i20 = i2 | i21;
                    } else {
                        i20 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                            paddingValues2 = paddingValues;
                            int i30 = composerStartRestartGroup.changed(paddingValues2) ? 32 : 16;
                            i20 |= i30;
                        } else {
                            paddingValues2 = paddingValues;
                        }
                        i20 |= i30;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    if ((i2 & 384) != 0) {
                        if ((i3 & 4096) == 0 && composerStartRestartGroup.changed(shape)) {
                            i5 = 256;
                        }
                        i20 |= i5;
                    }
                    i22 = i20;
                    if ((i17 & 306783379) != 306783378 && (i22 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.skipToGroupEnd();
                        z5 = z2;
                        mutableInteractionSource7 = mutableInteractionSource2;
                        composer3 = composerStartRestartGroup;
                        modifier4 = modifier2;
                        function9 = function6;
                        splitToggleChipColors3 = splitToggleChipColors2;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource8 = mutableInteractionSource;
                        shape3 = shape;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i11 != 0) {
                                function7 = null;
                            } else {
                                function7 = function6;
                            }
                            if ((i3 & 128) != 0) {
                                i25 = i16;
                                i24 = i19;
                                i23 = i22;
                                splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                                composer2 = composerStartRestartGroup;
                                i17 &= -29360129;
                            } else {
                                i23 = i22;
                                i24 = i19;
                                i25 = i16;
                                composer2 = composerStartRestartGroup;
                                splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                            }
                            if (i13 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i25 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if (i24 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                                contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                                i26 = i23 & (-113);
                            } else {
                                contentPadding = paddingValues;
                                i26 = i23;
                            }
                            if ((i3 & 4096) != 0) {
                                i26 &= -897;
                                shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                            } else {
                                shape2 = shape;
                            }
                            mutableInteractionSource5 = mutableInteractionSource3;
                            i27 = i26;
                            mutableInteractionSource6 = mutableInteractionSource4;
                            z4 = z3;
                            function8 = function7;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 128) != 0) {
                                i17 &= -29360129;
                            }
                            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                                i22 &= -113;
                            }
                            if ((i3 & 4096) != 0) {
                                i22 &= -897;
                            }
                            mutableInteractionSource5 = mutableInteractionSource;
                            shape2 = shape;
                            i27 = i22;
                            modifier3 = modifier2;
                            function8 = function6;
                            z4 = z2;
                            mutableInteractionSource6 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                            contentPadding = paddingValues2;
                            i17 = i17;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                        }
                        int i31 = i17 >> 24;
                        int i32 = i31 & 14;
                        int i33 = i32 | ((i17 >> 18) & 112);
                        MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource5;
                        Composer composer4 = composer2;
                        int i34 = i27 << 6;
                        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function10 = function8;
                        SplitToggleChipColors splitToggleChipColors4 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                        composer3 = composer4;
                        Modifier modifier5 = modifier3;
                        androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i33), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i32 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i33), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z6, boolean z7, Composer composer5, int i35) {
                                composer5.startReplaceGroup(-766370740);
                                ComposerKt.sourceInformation(composer5, "C275@14143L36:ToggleChip.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-766370740, i35, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                                }
                                State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer5, i35 & 14);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer5.endReplaceGroup();
                                return stateBackgroundColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z6, boolean z7, Composer composer5, int i35) {
                                composer5.startReplaceGroup(1329464811);
                                ComposerKt.sourceInformation(composer5, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1329464811, i35, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                                }
                                State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer5, i35 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer5.endReplaceGroup();
                                return stateSplitBackgroundOverlay;
                            }
                        }, z4, mutableInteractionSource9, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer4, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i34 & 57344) | (i34 & 896) | i32 | 196608 | (i31 & 112) | (i34 & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z5 = z4;
                        mutableInteractionSource7 = mutableInteractionSource6;
                        paddingValues3 = contentPadding;
                        shape3 = shape2;
                        mutableInteractionSource8 = mutableInteractionSource9;
                        modifier4 = modifier5;
                        splitToggleChipColors3 = splitToggleChipColors4;
                        function9 = function10;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer5, int i35) {
                                ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i15 = i4;
                i16 = i3 & 512;
                if (i16 != 0) {
                    i16 = i16;
                    i17 = i15 | 805306368;
                } else {
                    if ((i & 805306368) != 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                }
                i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                if (i19 != 0) {
                    i20 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i21 = 4;
                    } else {
                        i21 = 2;
                    }
                    i20 = i2 | i21;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                        }
                        i20 |= i30;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    i20 |= i30;
                } else {
                    paddingValues2 = paddingValues;
                }
                if ((i2 & 384) != 0) {
                    if ((i3 & 4096) == 0) {
                        i5 = 256;
                    }
                    i20 |= i5;
                }
                i22 = i20;
                if ((i17 & 306783379) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    } else {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                    }
                    int i35 = i17 >> 24;
                    int i36 = i35 & 14;
                    int i37 = i36 | ((i17 >> 18) & 112);
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource5;
                    Composer composer5 = composer2;
                    int i38 = i27 << 6;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function11 = function8;
                    SplitToggleChipColors splitToggleChipColors5 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                    composer3 = composer5;
                    Modifier modifier6 = modifier3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i37), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i36 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i37), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer6, int i39) {
                            composer6.startReplaceGroup(-766370740);
                            ComposerKt.sourceInformation(composer6, "C275@14143L36:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-766370740, i39, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                            }
                            State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer6, i39 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer6.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer6, int i39) {
                            composer6.startReplaceGroup(1329464811);
                            ComposerKt.sourceInformation(composer6, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1329464811, i39, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                            }
                            State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer6, i39 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer6.endReplaceGroup();
                            return stateSplitBackgroundOverlay;
                        }
                    }, z4, mutableInteractionSource10, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i38 & 57344) | (i38 & 896) | i36 | 196608 | (i35 & 112) | (i38 & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    mutableInteractionSource7 = mutableInteractionSource6;
                    paddingValues3 = contentPadding;
                    shape3 = shape2;
                    mutableInteractionSource8 = mutableInteractionSource10;
                    modifier4 = modifier6;
                    splitToggleChipColors3 = splitToggleChipColors5;
                    function9 = function11;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    } else {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                    }
                    int i39 = i17 >> 24;
                    int i310 = i39 & 14;
                    int i311 = i310 | ((i17 >> 18) & 112);
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource5;
                    Composer composer6 = composer2;
                    int i312 = i27 << 6;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function12 = function8;
                    SplitToggleChipColors splitToggleChipColors6 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                    composer3 = composer6;
                    Modifier modifier7 = modifier3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i311), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i310 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i311), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer7, int i313) {
                            composer7.startReplaceGroup(-766370740);
                            ComposerKt.sourceInformation(composer7, "C275@14143L36:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-766370740, i313, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                            }
                            State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer7, i313 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer7.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer7, int i313) {
                            composer7.startReplaceGroup(1329464811);
                            ComposerKt.sourceInformation(composer7, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1329464811, i313, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                            }
                            State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer7, i313 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer7.endReplaceGroup();
                            return stateSplitBackgroundOverlay;
                        }
                    }, z4, mutableInteractionSource11, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer6, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i312 & 57344) | (i312 & 896) | i310 | 196608 | (i39 & 112) | (i312 & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    mutableInteractionSource7 = mutableInteractionSource6;
                    paddingValues3 = contentPadding;
                    shape3 = shape2;
                    mutableInteractionSource8 = mutableInteractionSource11;
                    modifier4 = modifier7;
                    splitToggleChipColors3 = splitToggleChipColors6;
                    function9 = function12;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer7, int i313) {
                            ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer7, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i4 |= 3072;
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= 196608;
                modifier2 = modifier;
            } else {
                modifier2 = modifier;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function6 = function5;
            } else {
                function6 = function5;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    splitToggleChipColors2 = splitToggleChipColors;
                    if (composerStartRestartGroup.changed(splitToggleChipColors2)) {
                        i28 = 8388608;
                    }
                    i4 |= i28;
                } else {
                    splitToggleChipColors2 = splitToggleChipColors;
                }
                i28 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i28;
            } else {
                splitToggleChipColors2 = splitToggleChipColors;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    int i210 = i4;
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i15 = i210 | i14;
                }
                i16 = i3 & 512;
                if (i16 != 0) {
                    i16 = i16;
                    i17 = i15 | 805306368;
                } else {
                    if ((i & 805306368) != 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                }
                i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                if (i19 != 0) {
                    i20 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i21 = 4;
                    } else {
                        i21 = 2;
                    }
                    i20 = i2 | i21;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                        }
                        i20 |= i30;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    i20 |= i30;
                } else {
                    paddingValues2 = paddingValues;
                }
                if ((i2 & 384) != 0) {
                    if ((i3 & 4096) == 0) {
                        i5 = 256;
                    }
                    i20 |= i5;
                }
                i22 = i20;
                if ((i17 & 306783379) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    } else {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                    }
                    int i313 = i17 >> 24;
                    int i314 = i313 & 14;
                    int i315 = i314 | ((i17 >> 18) & 112);
                    MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource5;
                    Composer composer7 = composer2;
                    int i316 = i27 << 6;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function13 = function8;
                    SplitToggleChipColors splitToggleChipColors7 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                    composer3 = composer7;
                    Modifier modifier8 = modifier3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i315), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i314 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i315), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer8, int i317) {
                            composer8.startReplaceGroup(-766370740);
                            ComposerKt.sourceInformation(composer8, "C275@14143L36:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-766370740, i317, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                            }
                            State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer8, i317 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer8.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer8, int i317) {
                            composer8.startReplaceGroup(1329464811);
                            ComposerKt.sourceInformation(composer8, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1329464811, i317, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                            }
                            State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer8, i317 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer8.endReplaceGroup();
                            return stateSplitBackgroundOverlay;
                        }
                    }, z4, mutableInteractionSource12, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer7, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i316 & 57344) | (i316 & 896) | i314 | 196608 | (i313 & 112) | (i316 & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    mutableInteractionSource7 = mutableInteractionSource6;
                    paddingValues3 = contentPadding;
                    shape3 = shape2;
                    mutableInteractionSource8 = mutableInteractionSource12;
                    modifier4 = modifier8;
                    splitToggleChipColors3 = splitToggleChipColors7;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    } else {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                    }
                    int i317 = i17 >> 24;
                    int i318 = i317 & 14;
                    int i319 = i318 | ((i17 >> 18) & 112);
                    MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource5;
                    Composer composer8 = composer2;
                    int i3110 = i27 << 6;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function14 = function8;
                    SplitToggleChipColors splitToggleChipColors8 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                    composer3 = composer8;
                    Modifier modifier9 = modifier3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i319), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i318 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i319), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer9, int i3111) {
                            composer9.startReplaceGroup(-766370740);
                            ComposerKt.sourceInformation(composer9, "C275@14143L36:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-766370740, i3111, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                            }
                            State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer9, i3111 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer9.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer9, int i3111) {
                            composer9.startReplaceGroup(1329464811);
                            ComposerKt.sourceInformation(composer9, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1329464811, i3111, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                            }
                            State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer9, i3111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer9.endReplaceGroup();
                            return stateSplitBackgroundOverlay;
                        }
                    }, z4, mutableInteractionSource13, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer8, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i3110 & 57344) | (i3110 & 896) | i318 | 196608 | (i317 & 112) | (i3110 & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    mutableInteractionSource7 = mutableInteractionSource6;
                    paddingValues3 = contentPadding;
                    shape3 = shape2;
                    mutableInteractionSource8 = mutableInteractionSource13;
                    modifier4 = modifier9;
                    splitToggleChipColors3 = splitToggleChipColors8;
                    function9 = function14;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer9, int i3111) {
                            ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer9, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i4 |= 100663296;
            i15 = i4;
            i16 = i3 & 512;
            if (i16 != 0) {
                i16 = i16;
                i17 = i15 | 805306368;
            } else {
                if ((i & 805306368) != 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i15 |= i18;
                }
                i17 = i15;
            }
            i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
            if (i19 != 0) {
                i20 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i21 = 4;
                } else {
                    i21 = 2;
                }
                i20 = i2 | i21;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                    }
                    i20 |= i30;
                } else {
                    paddingValues2 = paddingValues;
                }
                i20 |= i30;
            } else {
                paddingValues2 = paddingValues;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4096) == 0) {
                    i5 = 256;
                }
                i20 |= i5;
            }
            i22 = i20;
            if ((i17 & 306783379) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                }
                int i3111 = i17 >> 24;
                int i3112 = i3111 & 14;
                int i3113 = i3112 | ((i17 >> 18) & 112);
                MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource5;
                Composer composer9 = composer2;
                int i3114 = i27 << 6;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function15 = function8;
                SplitToggleChipColors splitToggleChipColors9 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                composer3 = composer9;
                Modifier modifier10 = modifier3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i3113), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i3112 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i3113), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer10, int i3115) {
                        composer10.startReplaceGroup(-766370740);
                        ComposerKt.sourceInformation(composer10, "C275@14143L36:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-766370740, i3115, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                        }
                        State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer10, i3115 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer10.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer10, int i3115) {
                        composer10.startReplaceGroup(1329464811);
                        ComposerKt.sourceInformation(composer10, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1329464811, i3115, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                        }
                        State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer10, i3115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer10.endReplaceGroup();
                        return stateSplitBackgroundOverlay;
                    }
                }, z4, mutableInteractionSource14, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer9, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i3114 & 57344) | (i3114 & 896) | i3112 | 196608 | (i3111 & 112) | (i3114 & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                mutableInteractionSource7 = mutableInteractionSource6;
                paddingValues3 = contentPadding;
                shape3 = shape2;
                mutableInteractionSource8 = mutableInteractionSource14;
                modifier4 = modifier10;
                splitToggleChipColors3 = splitToggleChipColors9;
                function9 = function15;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                }
                int i3115 = i17 >> 24;
                int i3116 = i3115 & 14;
                int i3117 = i3116 | ((i17 >> 18) & 112);
                MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource5;
                Composer composer10 = composer2;
                int i3118 = i27 << 6;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function16 = function8;
                SplitToggleChipColors splitToggleChipColors10 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                composer3 = composer10;
                Modifier modifier11 = modifier3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i3117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i3116 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i3117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer11, int i3119) {
                        composer11.startReplaceGroup(-766370740);
                        ComposerKt.sourceInformation(composer11, "C275@14143L36:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-766370740, i3119, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                        }
                        State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer11, i3119 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer11.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer11, int i3119) {
                        composer11.startReplaceGroup(1329464811);
                        ComposerKt.sourceInformation(composer11, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1329464811, i3119, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                        }
                        State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer11, i3119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer11.endReplaceGroup();
                        return stateSplitBackgroundOverlay;
                    }
                }, z4, mutableInteractionSource15, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer10, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i3118 & 57344) | (i3118 & 896) | i3116 | 196608 | (i3115 & 112) | (i3118 & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                mutableInteractionSource7 = mutableInteractionSource6;
                paddingValues3 = contentPadding;
                shape3 = shape2;
                mutableInteractionSource8 = mutableInteractionSource15;
                modifier4 = modifier11;
                splitToggleChipColors3 = splitToggleChipColors10;
                function9 = function16;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer11, int i3119) {
                        ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer11, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 48;
        i5 = 128;
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 256;
            } else {
                i6 = 128;
            }
            i4 |= i6;
        }
        if ((i3 & 8) != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i4 |= i7;
            }
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= 196608;
                modifier2 = modifier;
            } else {
                modifier2 = modifier;
                if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function6 = function5;
            } else {
                function6 = function5;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    splitToggleChipColors2 = splitToggleChipColors;
                    if (composerStartRestartGroup.changed(splitToggleChipColors2)) {
                        i28 = 8388608;
                    }
                    i4 |= i28;
                } else {
                    splitToggleChipColors2 = splitToggleChipColors;
                }
                i28 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i28;
            } else {
                splitToggleChipColors2 = splitToggleChipColors;
            }
            i13 = i3 & 256;
            if (i13 != 0) {
                if ((i & 100663296) == 0) {
                    int i211 = i4;
                    if (composerStartRestartGroup.changed(z2)) {
                        i14 = 67108864;
                    } else {
                        i14 = 33554432;
                    }
                    i15 = i211 | i14;
                }
                i16 = i3 & 512;
                if (i16 != 0) {
                    i16 = i16;
                    i17 = i15 | 805306368;
                } else {
                    if ((i & 805306368) != 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i18 = 536870912;
                        } else {
                            i18 = 268435456;
                        }
                        i15 |= i18;
                    }
                    i17 = i15;
                }
                i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
                if (i19 != 0) {
                    i20 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i21 = 4;
                    } else {
                        i21 = 2;
                    }
                    i20 = i2 | i21;
                } else {
                    i20 = i2;
                }
                if ((i2 & 48) == 0) {
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                        paddingValues2 = paddingValues;
                        if (composerStartRestartGroup.changed(paddingValues2)) {
                        }
                        i20 |= i30;
                    } else {
                        paddingValues2 = paddingValues;
                    }
                    i20 |= i30;
                } else {
                    paddingValues2 = paddingValues;
                }
                if ((i2 & 384) != 0) {
                    if ((i3 & 4096) == 0) {
                        i5 = 256;
                    }
                    i20 |= i5;
                }
                i22 = i20;
                if ((i17 & 306783379) != 306783378) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    } else {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                    }
                    int i3119 = i17 >> 24;
                    int i31110 = i3119 & 14;
                    int i31111 = i31110 | ((i17 >> 18) & 112);
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource5;
                    Composer composer11 = composer2;
                    int i31112 = i27 << 6;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function17 = function8;
                    SplitToggleChipColors splitToggleChipColors11 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                    composer3 = composer11;
                    Modifier modifier12 = modifier3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i31111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i31110 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i31111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer12, int i31113) {
                            composer12.startReplaceGroup(-766370740);
                            ComposerKt.sourceInformation(composer12, "C275@14143L36:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-766370740, i31113, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                            }
                            State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer12, i31113 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer12.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer12, int i31113) {
                            composer12.startReplaceGroup(1329464811);
                            ComposerKt.sourceInformation(composer12, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1329464811, i31113, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                            }
                            State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer12, i31113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer12.endReplaceGroup();
                            return stateSplitBackgroundOverlay;
                        }
                    }, z4, mutableInteractionSource16, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer11, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i31112 & 57344) | (i31112 & 896) | i31110 | 196608 | (i3119 & 112) | (i31112 & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    mutableInteractionSource7 = mutableInteractionSource6;
                    paddingValues3 = contentPadding;
                    shape3 = shape2;
                    mutableInteractionSource8 = mutableInteractionSource16;
                    modifier4 = modifier12;
                    splitToggleChipColors3 = splitToggleChipColors11;
                    function9 = function17;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    } else {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i11 != 0) {
                            function7 = null;
                        } else {
                            function7 = function6;
                        }
                        if ((i3 & 128) != 0) {
                            i25 = i16;
                            i24 = i19;
                            i23 = i22;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                            composer2 = composerStartRestartGroup;
                            i17 &= -29360129;
                        } else {
                            i23 = i22;
                            i24 = i19;
                            i25 = i16;
                            composer2 = composerStartRestartGroup;
                            splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                        }
                        if (i13 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i25 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if (i24 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                            contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                            i26 = i23 & (-113);
                        } else {
                            contentPadding = paddingValues;
                            i26 = i23;
                        }
                        if ((i3 & 4096) != 0) {
                            i26 &= -897;
                            shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                        } else {
                            shape2 = shape;
                        }
                        mutableInteractionSource5 = mutableInteractionSource3;
                        i27 = i26;
                        mutableInteractionSource6 = mutableInteractionSource4;
                        z4 = z3;
                        function8 = function7;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                    }
                    int i31113 = i17 >> 24;
                    int i31114 = i31113 & 14;
                    int i31115 = i31114 | ((i17 >> 18) & 112);
                    MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource5;
                    Composer composer12 = composer2;
                    int i31116 = i27 << 6;
                    Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function18 = function8;
                    SplitToggleChipColors splitToggleChipColors12 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                    composer3 = composer12;
                    Modifier modifier13 = modifier3;
                    androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i31115), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i31114 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i31115), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer13, int i31117) {
                            composer13.startReplaceGroup(-766370740);
                            ComposerKt.sourceInformation(composer13, "C275@14143L36:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-766370740, i31117, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                            }
                            State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer13, i31117 & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer13.endReplaceGroup();
                            return stateBackgroundColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z6, boolean z7, Composer composer13, int i31117) {
                            composer13.startReplaceGroup(1329464811);
                            ComposerKt.sourceInformation(composer13, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1329464811, i31117, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                            }
                            State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer13, i31117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer13.endReplaceGroup();
                            return stateSplitBackgroundOverlay;
                        }
                    }, z4, mutableInteractionSource17, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer12, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i31116 & 57344) | (i31116 & 896) | i31114 | 196608 | (i31113 & 112) | (i31116 & 7168));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z5 = z4;
                    mutableInteractionSource7 = mutableInteractionSource6;
                    paddingValues3 = contentPadding;
                    shape3 = shape2;
                    mutableInteractionSource8 = mutableInteractionSource17;
                    modifier4 = modifier13;
                    splitToggleChipColors3 = splitToggleChipColors12;
                    function9 = function18;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer13, int i31117) {
                            ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer13, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                }
            }
            i4 |= 100663296;
            i15 = i4;
            i16 = i3 & 512;
            if (i16 != 0) {
                i16 = i16;
                i17 = i15 | 805306368;
            } else {
                if ((i & 805306368) != 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i15 |= i18;
                }
                i17 = i15;
            }
            i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
            if (i19 != 0) {
                i20 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i21 = 4;
                } else {
                    i21 = 2;
                }
                i20 = i2 | i21;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                    }
                    i20 |= i30;
                } else {
                    paddingValues2 = paddingValues;
                }
                i20 |= i30;
            } else {
                paddingValues2 = paddingValues;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4096) == 0) {
                    i5 = 256;
                }
                i20 |= i5;
            }
            i22 = i20;
            if ((i17 & 306783379) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                }
                int i31117 = i17 >> 24;
                int i31118 = i31117 & 14;
                int i31119 = i31118 | ((i17 >> 18) & 112);
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource5;
                Composer composer13 = composer2;
                int i311110 = i27 << 6;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function19 = function8;
                SplitToggleChipColors splitToggleChipColors13 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                composer3 = composer13;
                Modifier modifier14 = modifier3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i31119), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i31118 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i31119), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer14, int i311111) {
                        composer14.startReplaceGroup(-766370740);
                        ComposerKt.sourceInformation(composer14, "C275@14143L36:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-766370740, i311111, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                        }
                        State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer14, i311111 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer14.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer14, int i311111) {
                        composer14.startReplaceGroup(1329464811);
                        ComposerKt.sourceInformation(composer14, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1329464811, i311111, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                        }
                        State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer14, i311111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer14.endReplaceGroup();
                        return stateSplitBackgroundOverlay;
                    }
                }, z4, mutableInteractionSource18, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer13, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i311110 & 57344) | (i311110 & 896) | i31118 | 196608 | (i31117 & 112) | (i311110 & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                mutableInteractionSource7 = mutableInteractionSource6;
                paddingValues3 = contentPadding;
                shape3 = shape2;
                mutableInteractionSource8 = mutableInteractionSource18;
                modifier4 = modifier14;
                splitToggleChipColors3 = splitToggleChipColors13;
                function9 = function19;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                }
                int i311111 = i17 >> 24;
                int i311112 = i311111 & 14;
                int i311113 = i311112 | ((i17 >> 18) & 112);
                MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource5;
                Composer composer14 = composer2;
                int i311114 = i27 << 6;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function110 = function8;
                SplitToggleChipColors splitToggleChipColors14 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                composer3 = composer14;
                Modifier modifier15 = modifier3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i311113), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i311112 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i311113), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer15, int i311115) {
                        composer15.startReplaceGroup(-766370740);
                        ComposerKt.sourceInformation(composer15, "C275@14143L36:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-766370740, i311115, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                        }
                        State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer15, i311115 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer15.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer15, int i311115) {
                        composer15.startReplaceGroup(1329464811);
                        ComposerKt.sourceInformation(composer15, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1329464811, i311115, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                        }
                        State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer15, i311115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer15.endReplaceGroup();
                        return stateSplitBackgroundOverlay;
                    }
                }, z4, mutableInteractionSource19, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer14, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i311114 & 57344) | (i311114 & 896) | i311112 | 196608 | (i311111 & 112) | (i311114 & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                mutableInteractionSource7 = mutableInteractionSource6;
                paddingValues3 = contentPadding;
                shape3 = shape2;
                mutableInteractionSource8 = mutableInteractionSource19;
                modifier4 = modifier15;
                splitToggleChipColors3 = splitToggleChipColors14;
                function9 = function110;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer15, int i311115) {
                        ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer15, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 3072;
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i4 |= i8;
        }
        i9 = i3 & 32;
        if (i9 != 0) {
            i4 |= 196608;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changed(modifier2)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 64;
        if (i11 != 0) {
            i4 |= 1572864;
            function6 = function5;
        } else {
            function6 = function5;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i4 |= i12;
            }
        }
        if ((i & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                splitToggleChipColors2 = splitToggleChipColors;
                if (composerStartRestartGroup.changed(splitToggleChipColors2)) {
                    i28 = 8388608;
                }
                i4 |= i28;
            } else {
                splitToggleChipColors2 = splitToggleChipColors;
            }
            i28 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i4 |= i28;
        } else {
            splitToggleChipColors2 = splitToggleChipColors;
        }
        i13 = i3 & 256;
        if (i13 != 0) {
            if ((i & 100663296) == 0) {
                int i212 = i4;
                if (composerStartRestartGroup.changed(z2)) {
                    i14 = 67108864;
                } else {
                    i14 = 33554432;
                }
                i15 = i212 | i14;
            }
            i16 = i3 & 512;
            if (i16 != 0) {
                i16 = i16;
                i17 = i15 | 805306368;
            } else {
                if ((i & 805306368) != 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i18 = 536870912;
                    } else {
                        i18 = 268435456;
                    }
                    i15 |= i18;
                }
                i17 = i15;
            }
            i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
            if (i19 != 0) {
                i20 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i21 = 4;
                } else {
                    i21 = 2;
                }
                i20 = i2 | i21;
            } else {
                i20 = i2;
            }
            if ((i2 & 48) == 0) {
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                    paddingValues2 = paddingValues;
                    if (composerStartRestartGroup.changed(paddingValues2)) {
                    }
                    i20 |= i30;
                } else {
                    paddingValues2 = paddingValues;
                }
                i20 |= i30;
            } else {
                paddingValues2 = paddingValues;
            }
            if ((i2 & 384) != 0) {
                if ((i3 & 4096) == 0) {
                    i5 = 256;
                }
                i20 |= i5;
            }
            i22 = i20;
            if ((i17 & 306783379) != 306783378) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                }
                int i311115 = i17 >> 24;
                int i311116 = i311115 & 14;
                int i311117 = i311116 | ((i17 >> 18) & 112);
                MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource5;
                Composer composer15 = composer2;
                int i311118 = i27 << 6;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function111 = function8;
                SplitToggleChipColors splitToggleChipColors15 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                composer3 = composer15;
                Modifier modifier16 = modifier3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i311117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i311116 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i311117), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer16, int i311119) {
                        composer16.startReplaceGroup(-766370740);
                        ComposerKt.sourceInformation(composer16, "C275@14143L36:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-766370740, i311119, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                        }
                        State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer16, i311119 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer16.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer16, int i311119) {
                        composer16.startReplaceGroup(1329464811);
                        ComposerKt.sourceInformation(composer16, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1329464811, i311119, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                        }
                        State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer16, i311119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer16.endReplaceGroup();
                        return stateSplitBackgroundOverlay;
                    }
                }, z4, mutableInteractionSource110, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer15, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i311118 & 57344) | (i311118 & 896) | i311116 | 196608 | (i311115 & 112) | (i311118 & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                mutableInteractionSource7 = mutableInteractionSource6;
                paddingValues3 = contentPadding;
                shape3 = shape2;
                mutableInteractionSource8 = mutableInteractionSource110;
                modifier4 = modifier16;
                splitToggleChipColors3 = splitToggleChipColors15;
                function9 = function111;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i11 != 0) {
                        function7 = null;
                    } else {
                        function7 = function6;
                    }
                    if ((i3 & 128) != 0) {
                        i25 = i16;
                        i24 = i19;
                        i23 = i22;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                        composer2 = composerStartRestartGroup;
                        i17 &= -29360129;
                    } else {
                        i23 = i22;
                        i24 = i19;
                        i25 = i16;
                        composer2 = composerStartRestartGroup;
                        splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                    }
                    if (i13 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i25 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if (i24 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                        contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                        i26 = i23 & (-113);
                    } else {
                        contentPadding = paddingValues;
                        i26 = i23;
                    }
                    if ((i3 & 4096) != 0) {
                        i26 &= -897;
                        shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                    } else {
                        shape2 = shape;
                    }
                    mutableInteractionSource5 = mutableInteractionSource3;
                    i27 = i26;
                    mutableInteractionSource6 = mutableInteractionSource4;
                    z4 = z3;
                    function8 = function7;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
                }
                int i311119 = i17 >> 24;
                int i3111110 = i311119 & 14;
                int i3111111 = i3111110 | ((i17 >> 18) & 112);
                MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource5;
                Composer composer16 = composer2;
                int i3111112 = i27 << 6;
                Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function112 = function8;
                SplitToggleChipColors splitToggleChipColors16 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
                composer3 = composer16;
                Modifier modifier17 = modifier3;
                androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i3111111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i3111110 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i3111111), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer17, int i3111113) {
                        composer17.startReplaceGroup(-766370740);
                        ComposerKt.sourceInformation(composer17, "C275@14143L36:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-766370740, i3111113, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                        }
                        State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer17, i3111113 & 14);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer17.endReplaceGroup();
                        return stateBackgroundColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z6, boolean z7, Composer composer17, int i3111113) {
                        composer17.startReplaceGroup(1329464811);
                        ComposerKt.sourceInformation(composer17, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1329464811, i3111113, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                        }
                        State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer17, i3111113 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer17.endReplaceGroup();
                        return stateSplitBackgroundOverlay;
                    }
                }, z4, mutableInteractionSource111, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer16, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i3111112 & 57344) | (i3111112 & 896) | i3111110 | 196608 | (i311119 & 112) | (i3111112 & 7168));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z4;
                mutableInteractionSource7 = mutableInteractionSource6;
                paddingValues3 = contentPadding;
                shape3 = shape2;
                mutableInteractionSource8 = mutableInteractionSource111;
                modifier4 = modifier17;
                splitToggleChipColors3 = splitToggleChipColors16;
                function9 = function112;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer17, int i3111113) {
                        ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer17, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
            }
        }
        i4 |= 100663296;
        i15 = i4;
        i16 = i3 & 512;
        if (i16 != 0) {
            i16 = i16;
            i17 = i15 | 805306368;
        } else {
            if ((i & 805306368) != 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i18 = 536870912;
                } else {
                    i18 = 268435456;
                }
                i15 |= i18;
            }
            i17 = i15;
        }
        i19 = i3 & UserMetadata.MAX_ATTRIBUTE_SIZE;
        if (i19 != 0) {
            i20 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                i21 = 4;
            } else {
                i21 = 2;
            }
            i20 = i2 | i21;
        } else {
            i20 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) == 0) {
                paddingValues2 = paddingValues;
                if (composerStartRestartGroup.changed(paddingValues2)) {
                }
                i20 |= i30;
            } else {
                paddingValues2 = paddingValues;
            }
            i20 |= i30;
        } else {
            paddingValues2 = paddingValues;
        }
        if ((i2 & 384) != 0) {
            if ((i3 & 4096) == 0) {
                i5 = 256;
            }
            i20 |= i5;
        }
        i22 = i20;
        if ((i17 & 306783379) != 306783378) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i11 != 0) {
                    function7 = null;
                } else {
                    function7 = function6;
                }
                if ((i3 & 128) != 0) {
                    i25 = i16;
                    i24 = i19;
                    i23 = i22;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    i23 = i22;
                    i24 = i19;
                    i25 = i16;
                    composer2 = composerStartRestartGroup;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i25 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i24 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i26 = i23 & (-113);
                } else {
                    contentPadding = paddingValues;
                    i26 = i23;
                }
                if ((i3 & 4096) != 0) {
                    i26 &= -897;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                } else {
                    shape2 = shape;
                }
                mutableInteractionSource5 = mutableInteractionSource3;
                i27 = i26;
                mutableInteractionSource6 = mutableInteractionSource4;
                z4 = z3;
                function8 = function7;
            } else {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i11 != 0) {
                    function7 = null;
                } else {
                    function7 = function6;
                }
                if ((i3 & 128) != 0) {
                    i25 = i16;
                    i24 = i19;
                    i23 = i22;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    i23 = i22;
                    i24 = i19;
                    i25 = i16;
                    composer2 = composerStartRestartGroup;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i25 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i24 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i26 = i23 & (-113);
                } else {
                    contentPadding = paddingValues;
                    i26 = i23;
                }
                if ((i3 & 4096) != 0) {
                    i26 &= -897;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                } else {
                    shape2 = shape;
                }
                mutableInteractionSource5 = mutableInteractionSource3;
                i27 = i26;
                mutableInteractionSource6 = mutableInteractionSource4;
                z4 = z3;
                function8 = function7;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
            }
            int i3111113 = i17 >> 24;
            int i3111114 = i3111113 & 14;
            int i3111115 = i3111114 | ((i17 >> 18) & 112);
            MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource5;
            Composer composer17 = composer2;
            int i3111116 = i27 << 6;
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function113 = function8;
            SplitToggleChipColors splitToggleChipColors17 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
            composer3 = composer17;
            Modifier modifier18 = modifier3;
            androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i3111115), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i3111114 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i3111115), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z6, boolean z7, Composer composer18, int i3111117) {
                    composer18.startReplaceGroup(-766370740);
                    ComposerKt.sourceInformation(composer18, "C275@14143L36:ToggleChip.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-766370740, i3111117, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                    }
                    State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer18, i3111117 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer18.endReplaceGroup();
                    return stateBackgroundColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z6, boolean z7, Composer composer18, int i3111117) {
                    composer18.startReplaceGroup(1329464811);
                    ComposerKt.sourceInformation(composer18, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329464811, i3111117, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                    }
                    State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer18, i3111117 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer18.endReplaceGroup();
                    return stateSplitBackgroundOverlay;
                }
            }, z4, mutableInteractionSource112, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer17, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i3111116 & 57344) | (i3111116 & 896) | i3111114 | 196608 | (i3111113 & 112) | (i3111116 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z4;
            mutableInteractionSource7 = mutableInteractionSource6;
            paddingValues3 = contentPadding;
            shape3 = shape2;
            mutableInteractionSource8 = mutableInteractionSource112;
            modifier4 = modifier18;
            splitToggleChipColors3 = splitToggleChipColors17;
            function9 = function113;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i11 != 0) {
                    function7 = null;
                } else {
                    function7 = function6;
                }
                if ((i3 & 128) != 0) {
                    i25 = i16;
                    i24 = i19;
                    i23 = i22;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    i23 = i22;
                    i24 = i19;
                    i25 = i16;
                    composer2 = composerStartRestartGroup;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i25 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i24 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i26 = i23 & (-113);
                } else {
                    contentPadding = paddingValues;
                    i26 = i23;
                }
                if ((i3 & 4096) != 0) {
                    i26 &= -897;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                } else {
                    shape2 = shape;
                }
                mutableInteractionSource5 = mutableInteractionSource3;
                i27 = i26;
                mutableInteractionSource6 = mutableInteractionSource4;
                z4 = z3;
                function8 = function7;
            } else {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i11 != 0) {
                    function7 = null;
                } else {
                    function7 = function6;
                }
                if ((i3 & 128) != 0) {
                    i25 = i16;
                    i24 = i19;
                    i23 = i22;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = ToggleChipDefaults.INSTANCE.m860splitToggleChipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 63);
                    composer2 = composerStartRestartGroup;
                    i17 &= -29360129;
                } else {
                    i23 = i22;
                    i24 = i19;
                    i25 = i16;
                    composer2 = composerStartRestartGroup;
                    splitToggleChipColorsM860splitToggleChipColors5tl4gsc = splitToggleChipColors2;
                }
                if (i13 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i25 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if (i24 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0) {
                    contentPadding = ToggleChipDefaults.INSTANCE.getContentPadding();
                    i26 = i23 & (-113);
                } else {
                    contentPadding = paddingValues;
                    i26 = i23;
                }
                if ((i3 & 4096) != 0) {
                    i26 &= -897;
                    shape2 = (Shape) MaterialTheme.INSTANCE.getShapes(composer2, 6).getLarge();
                } else {
                    shape2 = shape;
                }
                mutableInteractionSource5 = mutableInteractionSource3;
                i27 = i26;
                mutableInteractionSource6 = mutableInteractionSource4;
                z4 = z3;
                function8 = function7;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(895645118, i17, i27, "androidx.wear.compose.material.SplitToggleChip (ToggleChip.kt:253)");
            }
            int i3111117 = i17 >> 24;
            int i3111118 = i3111117 & 14;
            int i3111119 = i3111118 | ((i17 >> 18) & 112);
            MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource5;
            Composer composer18 = composer2;
            int i31111110 = i27 << 6;
            Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function114 = function8;
            SplitToggleChipColors splitToggleChipColors18 = splitToggleChipColorsM860splitToggleChipColors5tl4gsc;
            composer3 = composer18;
            Modifier modifier19 = modifier3;
            androidx.wear.compose.materialcore.ToggleButtonKt.m939SplitToggleButtonA819N5k(z, function1, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.contentColor(z4, composer2, i3111119), MaterialTheme.INSTANCE.getTypography(composer2, 6).getButton(), function3), function0, ProvidersKt.provideScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.toggleControlColor(z4, z, composer2, i3111118 | ((i17 << 3) & 112) | ((i17 >> 15) & 896)), function4), null, IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, ToggleChipDefaults.INSTANCE.m858getHeightD9Ej5fM(), 1, (Object) null), IntrinsicSize.Min), ProvidersKt.provideNullableScopeContent(splitToggleChipColorsM860splitToggleChipColors5tl4gsc.secondaryContentColor(z4, composer2, i3111119), MaterialTheme.INSTANCE.getTypography(composer2, 6).getCaption2(), function8), new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z6, boolean z7, Composer composer19, int i31111111) {
                    composer19.startReplaceGroup(-766370740);
                    ComposerKt.sourceInformation(composer19, "C275@14143L36:ToggleChip.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-766370740, i31111111, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:275)");
                    }
                    State<Color> stateBackgroundColor = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.backgroundColor(z6, composer19, i31111111 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer19.endReplaceGroup();
                    return stateBackgroundColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z6, boolean z7, Composer composer19, int i31111111) {
                    composer19.startReplaceGroup(1329464811);
                    ComposerKt.sourceInformation(composer19, "CP(1)277@14251L98:ToggleChip.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1329464811, i31111111, -1, "androidx.wear.compose.material.SplitToggleChip.<anonymous> (ToggleChip.kt:277)");
                    }
                    State<Color> stateSplitBackgroundOverlay = splitToggleChipColorsM860splitToggleChipColors5tl4gsc.splitBackgroundOverlay(z6, z7, composer19, i31111111 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer19.endReplaceGroup();
                    return stateSplitBackgroundOverlay;
                }
            }, z4, mutableInteractionSource113, mutableInteractionSource6, contentPadding, shape2, Dp.constructor-impl(0), RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer18, 0, 7), composer3, (i17 & 14) | 196608 | (i17 & 112) | (i17 & 7168), (i31111110 & 57344) | (i31111110 & 896) | i3111118 | 196608 | (i3111117 & 112) | (i31111110 & 7168));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z4;
            mutableInteractionSource7 = mutableInteractionSource6;
            paddingValues3 = contentPadding;
            shape3 = shape2;
            mutableInteractionSource8 = mutableInteractionSource113;
            modifier4 = modifier19;
            splitToggleChipColors3 = splitToggleChipColors18;
            function9 = function114;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleChipKt.SplitToggleChip.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer19, int i31111111) {
                    ToggleChipKt.SplitToggleChip(z, function1, function3, function0, function4, modifier4, function9, splitToggleChipColors3, z5, mutableInteractionSource8, mutableInteractionSource7, paddingValues3, shape3, composer19, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                }
            });
        }
    }

    static {
        float f = 24;
        TOGGLE_CONTROL_HEIGHT = Dp.constructor-impl(f);
        TOGGLE_CONTROL_WIDTH = Dp.constructor-impl(f);
    }
}
