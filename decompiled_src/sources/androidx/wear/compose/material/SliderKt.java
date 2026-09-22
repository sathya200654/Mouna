package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.materialcore.RangeDefaults;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0018\u001a(\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\u001b\u001a&\u0010\u001c\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a.\u0010#\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020\u0001*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+²\u0006\n\u0010$\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"InlineSlider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "steps", "", "decreaseIcon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "increaseIcon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "segmented", "colors", "Landroidx/wear/compose/material/InlineSliderColors;", "(FLkotlin/jvm/functions/Function1;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ZLandroidx/wear/compose/material/InlineSliderColors;Landroidx/compose/runtime/Composer;II)V", "valueProgression", "Lkotlin/ranges/IntProgression;", "(ILkotlin/jvm/functions/Function1;Lkotlin/ranges/IntProgression;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZZLandroidx/wear/compose/material/InlineSliderColors;Landroidx/compose/runtime/Composer;II)V", "InlineSliderButtonContent", "content", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "drawProgressBarSeparator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "position", "drawProgressBarSeparator-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "drawSelectedProgressBar", "valueRatio", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "drawSelectedProgressBar-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/unit/LayoutDirection;)V", "drawUnselectedProgressBar", "drawUnselectedProgressBar-RPmYEkk", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SliderKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0113  */
    /* JADX WARN: Code duplicated, block: B:103:0x011b  */
    /* JADX WARN: Code duplicated, block: B:104:0x011e  */
    /* JADX WARN: Code duplicated, block: B:107:0x0125  */
    /* JADX WARN: Code duplicated, block: B:110:0x0133  */
    /* JADX WARN: Code duplicated, block: B:114:0x0146  */
    /* JADX WARN: Code duplicated, block: B:116:0x014f  */
    /* JADX WARN: Code duplicated, block: B:129:0x017d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x017f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0184  */
    /* JADX WARN: Code duplicated, block: B:133:0x0187  */
    /* JADX WARN: Code duplicated, block: B:134:0x018a  */
    /* JADX WARN: Code duplicated, block: B:137:0x0190  */
    /* JADX WARN: Code duplicated, block: B:140:0x019f  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:151:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:153:0x0200  */
    /* JADX WARN: Code duplicated, block: B:155:0x020d  */
    /* JADX WARN: Code duplicated, block: B:156:0x020f  */
    /* JADX WARN: Code duplicated, block: B:159:0x021c  */
    /* JADX WARN: Code duplicated, block: B:161:0x0222  */
    /* JADX WARN: Code duplicated, block: B:167:0x0230  */
    /* JADX WARN: Code duplicated, block: B:168:0x0232  */
    /* JADX WARN: Code duplicated, block: B:171:0x023a  */
    /* JADX WARN: Code duplicated, block: B:173:0x0242  */
    /* JADX WARN: Code duplicated, block: B:176:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:179:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:180:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:183:0x0305  */
    /* JADX WARN: Code duplicated, block: B:185:0x0313  */
    /* JADX WARN: Code duplicated, block: B:188:0x0340  */
    /* JADX WARN: Code duplicated, block: B:189:0x0345  */
    /* JADX WARN: Code duplicated, block: B:192:0x0355  */
    /* JADX WARN: Code duplicated, block: B:193:0x0357  */
    /* JADX WARN: Code duplicated, block: B:196:0x035d  */
    /* JADX WARN: Code duplicated, block: B:198:0x0363  */
    /* JADX WARN: Code duplicated, block: B:204:0x036e  */
    /* JADX WARN: Code duplicated, block: B:205:0x0370  */
    /* JADX WARN: Code duplicated, block: B:208:0x0378  */
    /* JADX WARN: Code duplicated, block: B:209:0x037a  */
    /* JADX WARN: Code duplicated, block: B:212:0x0382  */
    /* JADX WARN: Code duplicated, block: B:216:0x038d  */
    /* JADX WARN: Code duplicated, block: B:219:0x0437  */
    /* JADX WARN: Code duplicated, block: B:222:0x0443  */
    /* JADX WARN: Code duplicated, block: B:223:0x0447  */
    /* JADX WARN: Code duplicated, block: B:226:0x046c  */
    /* JADX WARN: Code duplicated, block: B:228:0x047a  */
    /* JADX WARN: Code duplicated, block: B:231:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:234:0x04af  */
    /* JADX WARN: Code duplicated, block: B:236:0x04b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:238:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:241:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:243:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:246:0x0621  */
    /* JADX WARN: Code duplicated, block: B:248:0x0629  */
    /* JADX WARN: Code duplicated, block: B:251:0x06a9  */
    /* JADX WARN: Code duplicated, block: B:255:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:257:0x06d1  */
    /* JADX WARN: Code duplicated, block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:93:0x0100  */
    /* JADX WARN: Code duplicated, block: B:96:0x0107  */
    /* JADX WARN: Code duplicated, block: B:99:0x010f  */
    public static final void InlineSlider(final float f, final Function1<? super Float, Unit> function1, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, boolean z2, InlineSliderColors inlineSliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        int i10;
        boolean z3;
        int i11;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        boolean z4;
        InlineSliderColors inlineSliderColors2;
        Composer composer2;
        Modifier modifier3;
        boolean z5;
        int i12;
        InlineSliderColors inlineSliderColorsM606colorsoq7We08;
        int i13;
        boolean z6;
        boolean z7;
        int i14;
        boolean z8;
        boolean z9;
        Object objRememberedValue;
        final int iIntValue;
        boolean z10;
        int currentCompositeKeyHash;
        Function0 constructor;
        int i15;
        Composer composer3;
        Function2 setCompositeKeyHash;
        int i16;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Object objRememberedValue2;
        int i17;
        final Function1 function4;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Composer composer4;
        Function2 setCompositeKeyHash2;
        final boolean z15;
        final boolean z16;
        boolean zChanged;
        Object objRememberedValue3;
        boolean zChanged2;
        Object objRememberedValue4;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final boolean z17;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        final boolean z18;
        final InlineSliderColors inlineSliderColors3;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(-195446886);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InlineSlider)P(8,5,7,1,3,4,2,9,6)104@5005L8,108@5100L176,126@5601L6,115@5281L4030:Slider.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) == 0) {
            if ((i2 & 48) == 0) {
                i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
            }
            if ((i3 & 4) != 0) {
                i4 |= 384;
            } else if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i4 |= i5;
            }
            if ((i3 & 8) != 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i4 |= i6;
            }
            if ((i3 & 16) != 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            i8 = i3 & 32;
            if (i8 != 0) {
                if ((196608 & i2) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i9;
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                    z3 = z;
                } else {
                    z3 = z;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                }
                if ((i2 & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                        if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                            i18 = 8388608;
                        }
                        i4 |= i18;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    }
                    i18 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i18;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        z4 = z2;
                        int i19 = composerStartRestartGroup.changed(z4) ? 67108864 : 33554432;
                        i4 |= i19;
                    } else {
                        z4 = z2;
                    }
                    i4 |= i19;
                } else {
                    z4 = z2;
                }
                if ((i2 & 805306368) == 0) {
                    if ((i3 & 512) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        int i20 = composerStartRestartGroup.changed(inlineSliderColors2) ? 536870912 : 268435456;
                        i4 |= i20;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i20;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 306783379) == 306783378 || !composer2.getSkipping()) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0 || composer2.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i10 != 0) {
                            z5 = true;
                        } else {
                            z5 = z;
                        }
                        if ((i3 & 128) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                            i4 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            if (i <= 8) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            i4 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i12 = i4 & (-1879048193);
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        } else {
                            i12 = i4;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                        }
                    } else {
                        composer2.skipToGroupEnd();
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        if ((i3 & 256) != 0) {
                            i4 &= -234881025;
                        }
                        if ((i3 & 512) != 0) {
                            i4 &= -1879048193;
                        }
                        z5 = z;
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        modifier3 = modifier2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
                    }
                    if (i < 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
                    i13 = i12 & 14;
                    if (i13 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = z4;
                    int i21 = (i12 & 29360128) ^ 12582912;
                    boolean z19 = ((i21 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
                    i14 = i12 & 896;
                    if (i14 == 256) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z19 | z8;
                    objRememberedValue = composer2.rememberedValue();
                    if (!z9 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    iIntValue = ((Number) objRememberedValue).intValue();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    z10 = z5;
                    Modifier modifier5 = modifier3;
                    Modifier modifierClip = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierClip);
                    constructor = ComposeUiNode.Companion.getConstructor();
                    i15 = i12;
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    composer3 = Updater.constructor-impl(composer2);
                    Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
                    if (z7) {
                        i16 = i + 1;
                    } else {
                        i16 = 1;
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
                    boolean zChanged3 = composer2.changed(iIntValue);
                    if (i14 == 256) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    boolean z20 = zChanged3 | z11 | ((i21 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
                    if (i13 == 4) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    boolean z21 = z20 | z12;
                    if ((i15 & 112) == 32) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    z14 = z21 | z13;
                    objRememberedValue2 = composer2.rememberedValue();
                    if (!z14 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        final ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRangeRangeTo;
                        i17 = iIntValue;
                        objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(int i22) {
                                float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i22, i, closedFloatingPointRange3);
                                if (fCalculateCurrentStepValue == f) {
                                    return;
                                }
                                function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        i17 = iIntValue;
                    }
                    function4 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i22 = (i15 >> 18) & 14;
                    int i23 = i22 | 48 | ((i15 >> 21) & 896);
                    State<Color> stateBarColor = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i23);
                    State<Color> stateBarColor2 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i23);
                    int i24 = i22 | ((i15 >> 24) & 112);
                    State<Color> stateBackgroundColor = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i24);
                    Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Modifier modifier6 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifier6);
                    constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    composer4 = Updater.constructor-impl(composer2);
                    Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
                    if (z10 || i17 >= i + 1) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    if (z10 || i17 <= 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
                    zChanged = composer2.changed(function4);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged || objRememberedValue3 == Composer.Companion.getEmpty()) {
                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m797invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m797invoke() {
                                function4.invoke(-1);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i25) {
                            ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                            if ((i25 & 3) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(818544754, i25, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                            }
                            SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 224640);
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i24).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                    State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
                    Modifier modifierClip2 = ClipKt.clip(RowScope.weight$default(rowScope, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                    float fInlineSlider$lambda$7$lambda$6$lambda$4 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState);
                    CompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip2, stateBarColor, stateBarColor2, stateBackgroundColor, i16, fInlineSlider$lambda$7$lambda$6$lambda$4, (LayoutDirection) objConsume, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                        public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                            SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                        }
                    }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                        public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                            SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                        }
                    }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                        public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                            SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                        }
                    }), composer2, 0);
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i24).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
                    zChanged2 = composer2.changed(function4);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!zChanged2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                        objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m801invoke();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m801invoke() {
                                function4.invoke(1);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    function5 = function3;
                    androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i25) {
                            ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                            if ((i25 & 3) == 2 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(397854043, i25, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                            }
                            SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 224640);
                    composer2 = composer2;
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
                    z17 = z10;
                    closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                    z18 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    modifier4 = modifier5;
                } else {
                    composer2.skipToGroupEnd();
                    ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRangeRangeTo;
                    inlineSliderColors3 = inlineSliderColors2;
                    closedFloatingPointRange2 = closedFloatingPointRange4;
                    function5 = function3;
                    z18 = z4;
                    z17 = z3;
                    modifier4 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function2<? super Composer, ? super Integer, Unit> function6 = function5;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer5, int i25) {
                            SliderKt.InlineSlider(f, function1, i, function2, function6, modifier4, z17, closedFloatingPointRange2, z18, inlineSliderColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 196608;
            modifier2 = modifier;
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
                z3 = z;
            } else {
                z3 = z;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
            }
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                        i18 = 8388608;
                    }
                    i4 |= i18;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i18 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i18;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                    }
                    i4 |= i19;
                } else {
                    z4 = z2;
                }
                i4 |= i19;
            } else {
                z4 = z2;
            }
            if ((i2 & 805306368) == 0) {
                if ((i3 & 512) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i20;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i20;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 306783379) == 306783378) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
                }
                if (i < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
                i13 = i12 & 14;
                if (i13 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = z4;
                int i25 = (i12 & 29360128) ^ 12582912;
                boolean z110 = ((i25 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
                i14 = i12 & 896;
                if (i14 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z110 | z8;
                objRememberedValue = composer2.rememberedValue();
                if (!z9) {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                }
                iIntValue = ((Number) objRememberedValue).intValue();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                z10 = z5;
                Modifier modifier7 = modifier3;
                Modifier modifierClip3 = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierClip3);
                constructor = ComposeUiNode.Companion.getConstructor();
                i15 = i12;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer3 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
                if (z7) {
                    i16 = i + 1;
                } else {
                    i16 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
                boolean zChanged4 = composer2.changed(iIntValue);
                if (i14 == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z22 = zChanged4 | z11 | ((i25 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
                if (i13 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z23 = z22 | z12;
                if ((i15 & 112) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z23 | z13;
                objRememberedValue2 = composer2.rememberedValue();
                if (z14) {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i26) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i26, i, closedFloatingPointRange5);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange6 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i26) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i26, i, closedFloatingPointRange6);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                function4 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i26 = (i15 >> 18) & 14;
                int i27 = i26 | 48 | ((i15 >> 21) & 896);
                State<Color> stateBarColor3 = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i27);
                State<Color> stateBarColor4 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i27);
                int i28 = i26 | ((i15 >> 24) & 112);
                State<Color> stateBackgroundColor2 = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i28);
                Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                Modifier modifier8 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor2.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifier8);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
                if (z10) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                if (z10) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
                zChanged = composer2.changed(function4);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i29) {
                        ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                        if ((i29 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(818544754, i29, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                        }
                        SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i28).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                State stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
                Modifier modifierClip4 = ClipKt.clip(RowScope.weight$default(rowScope2, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                float fInlineSlider$lambda$7$lambda$6$lambda$5 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState2);
                CompositionLocal localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume2 = composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip4, stateBarColor3, stateBarColor4, stateBackgroundColor2, i16, fInlineSlider$lambda$7$lambda$6$lambda$5, (LayoutDirection) objConsume2, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                    public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                        SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                    }
                }), composer2, 0);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i28).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
                zChanged2 = composer2.changed(function4);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                function5 = function3;
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i29) {
                        ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                        if ((i29 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(397854043, i29, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                        }
                        SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                composer2 = composer2;
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
                z17 = z10;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                z18 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                modifier4 = modifier7;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
                }
                if (i < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
                i13 = i12 & 14;
                if (i13 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = z4;
                int i29 = (i12 & 29360128) ^ 12582912;
                boolean z111 = ((i29 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
                i14 = i12 & 896;
                if (i14 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z111 | z8;
                objRememberedValue = composer2.rememberedValue();
                if (!z9) {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                }
                iIntValue = ((Number) objRememberedValue).intValue();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                z10 = z5;
                Modifier modifier9 = modifier3;
                Modifier modifierClip5 = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierClip5);
                constructor = ComposeUiNode.Companion.getConstructor();
                i15 = i12;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer3 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
                if (z7) {
                    i16 = i + 1;
                } else {
                    i16 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
                boolean zChanged5 = composer2.changed(iIntValue);
                if (i14 == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z24 = zChanged5 | z11 | ((i29 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
                if (i13 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z25 = z24 | z12;
                if ((i15 & 112) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z25 | z13;
                objRememberedValue2 = composer2.rememberedValue();
                if (z14) {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange7 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i210) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i210, i, closedFloatingPointRange7);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange8 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i210) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i210, i, closedFloatingPointRange8);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                function4 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i210 = (i15 >> 18) & 14;
                int i211 = i210 | 48 | ((i15 >> 21) & 896);
                State<Color> stateBarColor5 = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i211);
                State<Color> stateBarColor6 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i211);
                int i212 = i210 | ((i15 >> 24) & 112);
                State<Color> stateBackgroundColor3 = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i212);
                Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal start3 = Arrangement.INSTANCE.getStart();
                Modifier modifier10 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor3.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(start3, centerVertically3, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifier10);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
                if (z10) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                if (z10) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
                zChanged = composer2.changed(function4);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i213) {
                        ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                        if ((i213 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(818544754, i213, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                        }
                        SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i212).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                State stateAnimateFloatAsState3 = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
                Modifier modifierClip6 = ClipKt.clip(RowScope.weight$default(rowScope3, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                float fInlineSlider$lambda$7$lambda$6$lambda$6 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState3);
                CompositionLocal localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume3 = composer2.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip6, stateBarColor5, stateBarColor6, stateBackgroundColor3, i16, fInlineSlider$lambda$7$lambda$6$lambda$6, (LayoutDirection) objConsume3, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                    public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                        SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                    }
                }), composer2, 0);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i212).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
                zChanged2 = composer2.changed(function4);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                function5 = function3;
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i213) {
                        ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                        if ((i213 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(397854043, i213, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                        }
                        SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                composer2 = composer2;
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
                z17 = z10;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                z18 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                modifier4 = modifier9;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function2<? super Composer, ? super Integer, Unit> function7 = function5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i213) {
                        SliderKt.InlineSlider(f, function1, i, function2, function7, modifier4, z17, closedFloatingPointRange2, z18, inlineSliderColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 48;
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i4 |= i5;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
            } else {
                i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i4 |= i6;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i4 |= i7;
        }
        i8 = i3 & 32;
        if (i8 != 0) {
            if ((196608 & i2) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i9;
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
                z3 = z;
            } else {
                z3 = z;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
            }
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                    if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                        i18 = 8388608;
                    }
                    i4 |= i18;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                }
                i18 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i18;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                    }
                    i4 |= i19;
                } else {
                    z4 = z2;
                }
                i4 |= i19;
            } else {
                z4 = z2;
            }
            if ((i2 & 805306368) == 0) {
                if ((i3 & 512) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i20;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i20;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 306783379) == 306783378) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
                }
                if (i < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
                i13 = i12 & 14;
                if (i13 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = z4;
                int i213 = (i12 & 29360128) ^ 12582912;
                boolean z112 = ((i213 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
                i14 = i12 & 896;
                if (i14 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z112 | z8;
                objRememberedValue = composer2.rememberedValue();
                if (!z9) {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                }
                iIntValue = ((Number) objRememberedValue).intValue();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                z10 = z5;
                Modifier modifier11 = modifier3;
                Modifier modifierClip7 = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer2, modifierClip7);
                constructor = ComposeUiNode.Companion.getConstructor();
                i15 = i12;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer3 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
                if (z7) {
                    i16 = i + 1;
                } else {
                    i16 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
                boolean zChanged6 = composer2.changed(iIntValue);
                if (i14 == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z26 = zChanged6 | z11 | ((i213 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
                if (i13 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z27 = z26 | z12;
                if ((i15 & 112) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z27 | z13;
                objRememberedValue2 = composer2.rememberedValue();
                if (z14) {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange9 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i214) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i214, i, closedFloatingPointRange9);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange10 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i214) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i214, i, closedFloatingPointRange10);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                function4 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i214 = (i15 >> 18) & 14;
                int i215 = i214 | 48 | ((i15 >> 21) & 896);
                State<Color> stateBarColor7 = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i215);
                State<Color> stateBarColor8 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i215);
                int i216 = i214 | ((i15 >> 24) & 112);
                State<Color> stateBackgroundColor4 = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i216);
                Alignment.Vertical centerVertically4 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal start4 = Arrangement.INSTANCE.getStart();
                Modifier modifier12 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor4.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(start4, centerVertically4, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer2, modifier12);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
                if (z10) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                if (z10) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
                zChanged = composer2.changed(function4);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i217) {
                        ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                        if ((i217 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(818544754, i217, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                        }
                        SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i216).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                State stateAnimateFloatAsState4 = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
                Modifier modifierClip8 = ClipKt.clip(RowScope.weight$default(rowScope4, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                float fInlineSlider$lambda$7$lambda$6$lambda$7 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState4);
                CompositionLocal localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume4 = composer2.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip8, stateBarColor7, stateBarColor8, stateBackgroundColor4, i16, fInlineSlider$lambda$7$lambda$6$lambda$7, (LayoutDirection) objConsume4, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                    public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                        SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                    }
                }), composer2, 0);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i216).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
                zChanged2 = composer2.changed(function4);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                function5 = function3;
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i217) {
                        ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                        if ((i217 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(397854043, i217, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                        }
                        SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                composer2 = composer2;
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
                z17 = z10;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                z18 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                modifier4 = modifier11;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                } else {
                    if (i8 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        z5 = true;
                    } else {
                        z5 = z;
                    }
                    if ((i3 & 128) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                        i4 &= -29360129;
                    }
                    if ((i3 & 256) != 0) {
                        if (i <= 8) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i12 = i4 & (-1879048193);
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    } else {
                        i12 = i4;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
                }
                if (i < 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
                i13 = i12 & 14;
                if (i13 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                z7 = z4;
                int i217 = (i12 & 29360128) ^ 12582912;
                boolean z113 = ((i217 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
                i14 = i12 & 896;
                if (i14 == 256) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z113 | z8;
                objRememberedValue = composer2.rememberedValue();
                if (!z9) {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                    composer2.updateRememberedValue(objRememberedValue);
                }
                iIntValue = ((Number) objRememberedValue).intValue();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                z10 = z5;
                Modifier modifier13 = modifier3;
                Modifier modifierClip9 = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer2, modifierClip9);
                constructor = ComposeUiNode.Companion.getConstructor();
                i15 = i12;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer3 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
                if (z7) {
                    i16 = i + 1;
                } else {
                    i16 = 1;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
                boolean zChanged7 = composer2.changed(iIntValue);
                if (i14 == 256) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                boolean z28 = zChanged7 | z11 | ((i217 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
                if (i13 == 4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                boolean z29 = z28 | z12;
                if ((i15 & 112) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                z14 = z29 | z13;
                objRememberedValue2 = composer2.rememberedValue();
                if (z14) {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange11 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i218) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i218, i, closedFloatingPointRange11);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                } else {
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange12 = closedFloatingPointRangeRangeTo;
                    i17 = iIntValue;
                    objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i218) {
                            float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i218, i, closedFloatingPointRange12);
                            if (fCalculateCurrentStepValue == f) {
                                return;
                            }
                            function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                function4 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i218 = (i15 >> 18) & 14;
                int i219 = i218 | 48 | ((i15 >> 21) & 896);
                State<Color> stateBarColor9 = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i219);
                State<Color> stateBarColor10 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i219);
                int i2110 = i218 | ((i15 >> 24) & 112);
                State<Color> stateBackgroundColor5 = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i2110);
                Alignment.Vertical centerVertically5 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal start5 = Arrangement.INSTANCE.getStart();
                Modifier modifier14 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor5.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(start5, centerVertically5, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composer2, modifier14);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                composer4 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer4, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer4, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer4.getInserting()) {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer4, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                RowScope rowScope5 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
                if (z10) {
                    z15 = false;
                } else {
                    z15 = false;
                }
                if (z10) {
                    z16 = false;
                } else {
                    z16 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
                zChanged = composer2.changed(function4);
                objRememberedValue3 = composer2.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m797invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m797invoke() {
                            function4.invoke(-1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i2111) {
                        ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                        if ((i2111 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(818544754, i2111, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                        }
                        SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i2110).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                State stateAnimateFloatAsState5 = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
                Modifier modifierClip10 = ClipKt.clip(RowScope.weight$default(rowScope5, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
                float fInlineSlider$lambda$7$lambda$6$lambda$8 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState5);
                CompositionLocal localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume5 = composer2.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip10, stateBarColor9, stateBarColor10, stateBackgroundColor5, i16, fInlineSlider$lambda$7$lambda$6$lambda$8, (LayoutDirection) objConsume5, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                    public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                        SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                    }
                }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                    public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                        SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                    }
                }), composer2, 0);
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i2110).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
                ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
                zChanged2 = composer2.changed(function4);
                objRememberedValue4 = composer2.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m801invoke();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m801invoke() {
                            function4.invoke(1);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                function5 = function3;
                androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i2111) {
                        ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                        if ((i2111 & 3) == 2 && composer5.getSkipping()) {
                            composer5.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(397854043, i2111, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                        }
                        SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 224640);
                composer2 = composer2;
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
                z17 = z10;
                closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
                z18 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                modifier4 = modifier13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function2<? super Composer, ? super Integer, Unit> function8 = function5;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer5, int i2111) {
                        SliderKt.InlineSlider(f, function1, i, function2, function8, modifier4, z17, closedFloatingPointRange2, z18, inlineSliderColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 196608;
        modifier2 = modifier;
        i10 = i3 & 64;
        if (i10 != 0) {
            i4 |= 1572864;
            z3 = z;
        } else {
            z3 = z;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
        }
        if ((i2 & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
                if (composerStartRestartGroup.changed(closedFloatingPointRangeRangeTo)) {
                    i18 = 8388608;
                }
                i4 |= i18;
            } else {
                closedFloatingPointRangeRangeTo = closedFloatingPointRange;
            }
            i18 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i4 |= i18;
        } else {
            closedFloatingPointRangeRangeTo = closedFloatingPointRange;
        }
        if ((i2 & 100663296) == 0) {
            if ((i3 & 256) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                }
                i4 |= i19;
            } else {
                z4 = z2;
            }
            i4 |= i19;
        } else {
            z4 = z2;
        }
        if ((i2 & 805306368) == 0) {
            if ((i3 & 512) == 0) {
                inlineSliderColors2 = inlineSliderColors;
                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                }
                i4 |= i20;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            i4 |= i20;
        } else {
            inlineSliderColors2 = inlineSliderColors;
        }
        composer2 = composerStartRestartGroup;
        if ((i4 & 306783379) == 306783378) {
            composer2.startDefaults();
            if ((i2 & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if ((i3 & 128) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                    i4 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    if (i <= 8) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i4 &= -234881025;
                }
                if ((i3 & 512) != 0) {
                    i12 = i4 & (-1879048193);
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    i12 = i4;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if ((i3 & 128) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                    i4 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    if (i <= 8) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i4 &= -234881025;
                }
                if ((i3 & 512) != 0) {
                    i12 = i4 & (-1879048193);
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    i12 = i4;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
            }
            if (i < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
            i13 = i12 & 14;
            if (i13 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = z4;
            int i2111 = (i12 & 29360128) ^ 12582912;
            boolean z114 = ((i2111 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
            i14 = i12 & 896;
            if (i14 == 256) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z114 | z8;
            objRememberedValue = composer2.rememberedValue();
            if (!z9) {
                objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                composer2.updateRememberedValue(objRememberedValue);
            }
            iIntValue = ((Number) objRememberedValue).intValue();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            z10 = z5;
            Modifier modifier15 = modifier3;
            Modifier modifierClip11 = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composer2, modifierClip11);
            constructor = ComposeUiNode.Companion.getConstructor();
            i15 = i12;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer3 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
            if (z7) {
                i16 = i + 1;
            } else {
                i16 = 1;
            }
            ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged8 = composer2.changed(iIntValue);
            if (i14 == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z210 = zChanged8 | z11 | ((i2111 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
            if (i13 == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean z211 = z210 | z12;
            if ((i15 & 112) == 32) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = z211 | z13;
            objRememberedValue2 = composer2.rememberedValue();
            if (z14) {
                final ClosedFloatingPointRange<Float> closedFloatingPointRange13 = closedFloatingPointRangeRangeTo;
                i17 = iIntValue;
                objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2112) {
                        float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i2112, i, closedFloatingPointRange13);
                        if (fCalculateCurrentStepValue == f) {
                            return;
                        }
                        function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                final ClosedFloatingPointRange<Float> closedFloatingPointRange14 = closedFloatingPointRangeRangeTo;
                i17 = iIntValue;
                objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2112) {
                        float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i2112, i, closedFloatingPointRange14);
                        if (fCalculateCurrentStepValue == f) {
                            return;
                        }
                        function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            function4 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i2112 = (i15 >> 18) & 14;
            int i2113 = i2112 | 48 | ((i15 >> 21) & 896);
            State<Color> stateBarColor11 = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i2113);
            State<Color> stateBarColor12 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i2113);
            int i2114 = i2112 | ((i15 >> 24) & 112);
            State<Color> stateBackgroundColor6 = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i2114);
            Alignment.Vertical centerVertically6 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal start6 = Arrangement.INSTANCE.getStart();
            Modifier modifier16 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor6.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(start6, centerVertically6, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composer2, modifier16);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer4.getInserting()) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier12, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope6 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
            if (z10) {
                z15 = false;
            } else {
                z15 = false;
            }
            if (z10) {
                z16 = false;
            } else {
                z16 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
            zChanged = composer2.changed(function4);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m797invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m797invoke() {
                        function4.invoke(-1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m797invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m797invoke() {
                        function4.invoke(-1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i2115) {
                    ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                    if ((i2115 & 3) == 2 && composer5.getSkipping()) {
                        composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(818544754, i2115, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                    }
                    SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 224640);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i2114).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
            State stateAnimateFloatAsState6 = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
            Modifier modifierClip12 = ClipKt.clip(RowScope.weight$default(rowScope6, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
            float fInlineSlider$lambda$7$lambda$6$lambda$9 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState6);
            CompositionLocal localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume6 = composer2.consume(localLayoutDirection6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip12, stateBarColor11, stateBarColor12, stateBackgroundColor6, i16, fInlineSlider$lambda$7$lambda$6$lambda$9, (LayoutDirection) objConsume6, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                    SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                }
            }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                    SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                }
            }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                    SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                }
            }), composer2, 0);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i2114).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
            zChanged2 = composer2.changed(function4);
            objRememberedValue4 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m801invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m801invoke() {
                        function4.invoke(1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m801invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m801invoke() {
                        function4.invoke(1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            function5 = function3;
            androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i2115) {
                    ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                    if ((i2115 & 3) == 2 && composer5.getSkipping()) {
                        composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(397854043, i2115, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                    }
                    SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 224640);
            composer2 = composer2;
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
            z17 = z10;
            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
            z18 = z7;
            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            modifier4 = modifier15;
        } else {
            composer2.startDefaults();
            if ((i2 & 1) != 0) {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if ((i3 & 128) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                    i4 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    if (i <= 8) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i4 &= -234881025;
                }
                if ((i3 & 512) != 0) {
                    i12 = i4 & (-1879048193);
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    i12 = i4;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                }
            } else {
                if (i8 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    z5 = true;
                } else {
                    z5 = z;
                }
                if ((i3 & 128) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, i + 1);
                    i4 &= -29360129;
                }
                if ((i3 & 256) != 0) {
                    if (i <= 8) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i4 &= -234881025;
                }
                if ((i3 & 512) != 0) {
                    i12 = i4 & (-1879048193);
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                } else {
                    i12 = i4;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-195446886, i12, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:105)");
            }
            if (i < 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            ComposerKt.sourceInformationMarkerStart(composer2, 1813579883, "CC(remember):Slider.kt#9igjgp");
            i13 = i12 & 14;
            if (i13 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            z7 = z4;
            int i2115 = (i12 & 29360128) ^ 12582912;
            boolean z115 = ((i2115 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i12 & 12582912) == 8388608) | z6;
            i14 = i12 & 896;
            if (i14 == 256) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z115 | z8;
            objRememberedValue = composer2.rememberedValue();
            if (!z9) {
                objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Integer.valueOf(RangeDefaults.INSTANCE.snapValueToStep(f, closedFloatingPointRangeRangeTo, i));
                composer2.updateRememberedValue(objRememberedValue);
            }
            iIntValue = ((Number) objRememberedValue).intValue();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            z10 = z5;
            Modifier modifier17 = modifier3;
            Modifier modifierClip13 = ClipKt.clip(SizeKt.height-3ABfNKs(RangeDefaultsKt.rangeSemantics(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), f, z10, function1, closedFloatingPointRangeRangeTo, i), InlineSliderDefaults.INSTANCE.m612getSliderHeightD9Ej5fM$compose_material_release()), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
            ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap13 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composer2, modifierClip13);
            constructor = ComposeUiNode.Companion.getConstructor();
            i15 = i12;
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            composer3 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier13, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 1544367121, "C131@5729L208,136@5976L23,137@6040L24,138@6102L24,140@6136L3169:Slider.kt#gj9v0t");
            if (z7) {
                i16 = i + 1;
            } else {
                i16 = 1;
            }
            ComposerKt.sourceInformationMarkerStart(composer2, -88729430, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged9 = composer2.changed(iIntValue);
            if (i14 == 256) {
                z11 = true;
            } else {
                z11 = false;
            }
            boolean z212 = zChanged9 | z11 | ((i2115 <= 8388608 && composer2.changed(closedFloatingPointRangeRangeTo)) || (i15 & 12582912) == 8388608);
            if (i13 == 4) {
                z12 = true;
            } else {
                z12 = false;
            }
            boolean z213 = z212 | z12;
            if ((i15 & 112) == 32) {
                z13 = true;
            } else {
                z13 = false;
            }
            z14 = z213 | z13;
            objRememberedValue2 = composer2.rememberedValue();
            if (z14) {
                final ClosedFloatingPointRange<Float> closedFloatingPointRange15 = closedFloatingPointRangeRangeTo;
                i17 = iIntValue;
                objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2116) {
                        float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i2116, i, closedFloatingPointRange15);
                        if (fCalculateCurrentStepValue == f) {
                            return;
                        }
                        function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            } else {
                final ClosedFloatingPointRange<Float> closedFloatingPointRange16 = closedFloatingPointRangeRangeTo;
                i17 = iIntValue;
                objRememberedValue2 = (Function1) new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$updateValue$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i2116) {
                        float fCalculateCurrentStepValue = RangeDefaults.INSTANCE.calculateCurrentStepValue(iIntValue + i2116, i, closedFloatingPointRange16);
                        if (fCalculateCurrentStepValue == f) {
                            return;
                        }
                        function1.invoke(Float.valueOf(fCalculateCurrentStepValue));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            function4 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i2116 = (i15 >> 18) & 14;
            int i2117 = i2116 | 48 | ((i15 >> 21) & 896);
            State<Color> stateBarColor13 = inlineSliderColorsM606colorsoq7We08.barColor(z10, true, composer2, i2117);
            State<Color> stateBarColor14 = inlineSliderColorsM606colorsoq7We08.barColor(z10, false, composer2, i2117);
            int i2118 = i2116 | ((i15 >> 24) & 112);
            State<Color> stateBackgroundColor7 = inlineSliderColorsM606colorsoq7We08.backgroundColor(z10, composer2, i2118);
            Alignment.Vertical centerVertically7 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal start7 = Arrangement.INSTANCE.getStart();
            Modifier modifier18 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Color) stateBackgroundColor7.getValue()).unbox-impl(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(start7, centerVertically7, composer2, 54);
            ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap14 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composer2, modifier18);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            composer4 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer4.getInserting()) {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer4.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer4, modifierMaterializeModifier14, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope7 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1392231370, "C152@6633L19,156@6905L66,150@6538L447,163@7167L20,159@6999L209,166@7240L66,173@7567L6,180@7971L7,168@7320L1296,197@8798L20,193@8630L209,202@8948L18,206@9215L66,200@8853L442:Slider.kt#gj9v0t");
            if (z10) {
                z15 = false;
            } else {
                z15 = false;
            }
            if (z10) {
                z16 = false;
            } else {
                z16 = false;
            }
            ComposerKt.sourceInformationMarkerStart(composer2, -1707473940, "CC(remember):Slider.kt#9igjgp");
            zChanged = composer2.changed(function4);
            objRememberedValue3 = composer2.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m797invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m797invoke() {
                        function4.invoke(-1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m797invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m797invoke() {
                        function4.invoke(-1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z16, (Function0) objRememberedValue3, Alignment.Companion.getCenterStart(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 0.0f, 0.0f, 14, (Object) null), ComposableLambdaKt.rememberComposableLambda(818544754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i2119) {
                    ComposerKt.sourceInformation(composer5, "C156@6907L62:Slider.kt#gj9v0t");
                    if ((i2119 & 3) == 2 && composer5.getSkipping()) {
                        composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(818544754, i2119, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:156)");
                    }
                    SliderKt.InlineSliderButtonContent(z16, function2, composer5, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 224640);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i2118).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
            State stateAnimateFloatAsState7 = AnimateAsStateKt.animateFloatAsState(i17 / (i + 1), (AnimationSpec) null, 0.0f, (String) null, (Function1) null, composer2, 0, 30);
            Modifier modifierClip14 = ClipKt.clip(RowScope.weight$default(rowScope7, SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, InlineSliderDefaults.INSTANCE.m608getBarMarginD9Ej5fM$compose_material_release(), 0.0f, 2, (Object) null), InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 1.0f, false, 2, (Object) null), MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall());
            float fInlineSlider$lambda$7$lambda$6$lambda$10 = InlineSlider$lambda$7$lambda$6$lambda$4(stateAnimateFloatAsState7);
            CompositionLocal localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume7 = composer2.consume(localLayoutDirection7);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            BoxKt.Box(androidx.wear.compose.materialcore.SliderKt.drawProgressBar(modifierClip14, stateBarColor13, stateBarColor14, stateBackgroundColor7, i16, fInlineSlider$lambda$7$lambda$6$lambda$10, (LayoutDirection) objConsume7, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m798invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                public final void m798invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                    SliderKt.m795drawSelectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                }
            }, new Function4<Color, Float, LayoutDirection, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    m799invokeIv8Zu3U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (LayoutDirection) obj3, (DrawScope) obj4);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-Iv8Zu3U, reason: not valid java name */
                public final void m799invokeIv8Zu3U(long j, float f2, LayoutDirection layoutDirection, DrawScope drawScope) {
                    SliderKt.m796drawUnselectedProgressBarRPmYEkk(drawScope, j, f2, layoutDirection);
                }
            }, new Function3<Color, Float, DrawScope, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$5
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m800invokeek8zF_U(((Color) obj).unbox-impl(), ((Number) obj2).floatValue(), (DrawScope) obj3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke-ek8zF_U, reason: not valid java name */
                public final void m800invokeek8zF_U(long j, float f2, DrawScope drawScope) {
                    SliderKt.m794drawProgressBarSeparatorbw27NRU(drawScope, j, f2);
                }
            }), composer2, 0);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.width-3ABfNKs(Modifier.Companion, InlineSliderDefaults.INSTANCE.m613getSpacersWidthD9Ej5fM$compose_material_release()), 0.0f, 1, (Object) null), ((Color) inlineSliderColorsM606colorsoq7We08.spacerColor(z10, composer2, i2118).getValue()).unbox-impl(), (Shape) null, 2, (Object) null), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1707399861, "CC(remember):Slider.kt#9igjgp");
            zChanged2 = composer2.changed(function4);
            objRememberedValue4 = composer2.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m801invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m801invoke() {
                        function4.invoke(1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m801invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m801invoke() {
                        function4.invoke(1);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            function5 = function3;
            androidx.wear.compose.materialcore.SliderKt.m932InlineSliderButtonhGBTI10(z15, (Function0) objRememberedValue4, Alignment.Companion.getCenterEnd(), InlineSliderDefaults.INSTANCE.m610getControlSizeD9Ej5fM$compose_material_release(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, InlineSliderDefaults.INSTANCE.m611getOuterHorizontalMarginD9Ej5fM$compose_material_release(), 0.0f, 11, (Object) null), ComposableLambdaKt.rememberComposableLambda(397854043, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$2$1$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i2119) {
                    ComposerKt.sourceInformation(composer5, "C206@9217L62:Slider.kt#gj9v0t");
                    if ((i2119 & 3) == 2 && composer5.getSkipping()) {
                        composer5.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(397854043, i2119, -1, "androidx.wear.compose.material.InlineSlider.<anonymous>.<anonymous>.<anonymous> (Slider.kt:206)");
                    }
                    SliderKt.InlineSliderButtonContent(z15, function5, composer5, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 224640);
            composer2 = composer2;
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
            z17 = z10;
            closedFloatingPointRange2 = closedFloatingPointRangeRangeTo;
            z18 = z7;
            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            modifier4 = modifier17;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function9 = function5;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer5, int i2119) {
                    SliderKt.InlineSlider(f, function1, i, function2, function9, modifier4, z17, closedFloatingPointRange2, z18, inlineSliderColors3, composer5, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0117  */
    /* JADX WARN: Code duplicated, block: B:106:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x0137  */
    /* JADX WARN: Code duplicated, block: B:118:0x0159 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x015b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0160  */
    /* JADX WARN: Code duplicated, block: B:122:0x0163  */
    /* JADX WARN: Code duplicated, block: B:123:0x0166  */
    /* JADX WARN: Code duplicated, block: B:126:0x016b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0173  */
    /* JADX WARN: Code duplicated, block: B:129:0x0176  */
    /* JADX WARN: Code duplicated, block: B:131:0x017d  */
    /* JADX WARN: Code duplicated, block: B:134:0x0184  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:141:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:144:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:146:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:149:0x022e  */
    /* JADX WARN: Code duplicated, block: B:153:0x023f  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:88:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:93:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:95:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:96:0x0102  */
    /* JADX WARN: Code duplicated, block: B:99:0x0109  */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x0127, please report this as an issue */
    public static final void InlineSlider(final int i, final Function1<? super Integer, Unit> function1, IntProgression intProgression, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z, boolean z2, InlineSliderColors inlineSliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        IntProgression intProgression2;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i6;
        int i7;
        Modifier modifier2;
        int i8;
        int i9;
        boolean z3;
        int i10;
        boolean z4;
        InlineSliderColors inlineSliderColors2;
        Composer composer2;
        Modifier modifier3;
        boolean z5;
        int i11;
        boolean z6;
        Modifier modifier4;
        boolean z7;
        InlineSliderColors inlineSliderColorsM606colorsoq7We08;
        boolean z8;
        boolean z9;
        boolean z10;
        Object objRememberedValue;
        final Modifier modifier5;
        final boolean z11;
        final boolean z12;
        final InlineSliderColors inlineSliderColors3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1552268373);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InlineSlider)P(7,5,8,1,3,4,2,6)264@12221L8,268@12310L34,266@12239L433:Slider.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 4) == 0) {
            if ((i2 & 384) == 0) {
                intProgression2 = intProgression;
                i4 |= composerStartRestartGroup.changedInstance(intProgression2) ? 256 : 128;
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 3072) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i4 |= i5;
                }
                if ((i3 & 16) != 0) {
                    if ((i2 & 24576) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i6 = 16384;
                        } else {
                            i6 = 8192;
                        }
                        i4 |= i6;
                    }
                    i7 = i3 & 32;
                    if (i7 != 0) {
                        if ((196608 & i2) == 0) {
                            modifier2 = modifier;
                            if (composerStartRestartGroup.changed(modifier2)) {
                                i8 = 131072;
                            } else {
                                i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i4 |= i8;
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            if ((1572864 & i2) == 0) {
                                z3 = z;
                                if (composerStartRestartGroup.changed(z3)) {
                                    i10 = 1048576;
                                } else {
                                    i10 = 524288;
                                }
                                i4 |= i10;
                            }
                            if ((12582912 & i2) == 0) {
                                if ((i3 & 128) == 0) {
                                    z4 = z2;
                                    if (composerStartRestartGroup.changed(z4)) {
                                        i12 = 8388608;
                                    }
                                    i4 |= i12;
                                } else {
                                    z4 = z2;
                                }
                                i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                                i4 |= i12;
                            } else {
                                z4 = z2;
                            }
                            if ((i2 & 100663296) == 0) {
                                if ((i3 & 256) == 0) {
                                    inlineSliderColors2 = inlineSliderColors;
                                    int i13 = composerStartRestartGroup.changed(inlineSliderColors2) ? 67108864 : 33554432;
                                    i4 |= i13;
                                } else {
                                    inlineSliderColors2 = inlineSliderColors;
                                }
                                i4 |= i13;
                            } else {
                                inlineSliderColors2 = inlineSliderColors;
                            }
                            composer2 = composerStartRestartGroup;
                            if ((i4 & 38347923) == 38347922 || !composer2.getSkipping()) {
                                composer2.startDefaults();
                                if ((i2 & 1) != 0 || composer2.getDefaultsInvalid()) {
                                    if (i7 != 0) {
                                        modifier3 = (Modifier) Modifier.Companion;
                                    } else {
                                        modifier3 = modifier2;
                                    }
                                    if (i9 != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = z3;
                                    }
                                    if ((i3 & 128) != 0) {
                                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        i11 = i4 & (-29360129);
                                        z6 = z9;
                                    } else {
                                        i11 = i4;
                                        z6 = z4;
                                    }
                                    if ((i3 & 256) != 0) {
                                        modifier4 = modifier3;
                                        z7 = z6;
                                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                        z8 = z5;
                                        i4 = i11 & (-234881025);
                                    } else {
                                        modifier4 = modifier3;
                                        z7 = z6;
                                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                        z8 = z5;
                                        i4 = i11;
                                    }
                                } else {
                                    composer2.skipToGroupEnd();
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i4 &= -234881025;
                                    }
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    modifier4 = modifier2;
                                    z8 = z3;
                                    z7 = z4;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                                }
                                float f = i;
                                int iStepsNumber = RangeDefaultsKt.stepsNumber(intProgression2);
                                ClosedFloatingPointRange closedFloatingPointRangeRangeTo = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                                z10 = (i4 & 112) == 32;
                                objRememberedValue = composer2.rememberedValue();
                                if (!z10 || objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke(((Number) obj).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(float f2) {
                                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f2)));
                                        }
                                    };
                                    composer2.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                int i14 = 4193280 & i4;
                                int i15 = i4 << 3;
                                InlineSlider(f, (Function1) objRememberedValue, iStepsNumber, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo, z7, inlineSliderColorsM606colorsoq7We08, composer2, i14 | (234881024 & i15) | (i15 & 1879048192), 0);
                                composer2 = composer2;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier5 = modifier4;
                                z11 = z8;
                                z12 = z7;
                                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                            } else {
                                composer2.skipToGroupEnd();
                                inlineSliderColors3 = inlineSliderColors2;
                                modifier5 = modifier2;
                                z11 = z3;
                                z12 = z4;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                final IntProgression intProgression3 = intProgression2;
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i16) {
                                        SliderKt.InlineSlider(i, function1, intProgression3, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                            }
                        }
                        i4 |= 1572864;
                        z3 = z;
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                z4 = z2;
                                if (composerStartRestartGroup.changed(z4)) {
                                    i12 = 8388608;
                                }
                                i4 |= i12;
                            } else {
                                z4 = z2;
                            }
                            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & 256) == 0) {
                                inlineSliderColors2 = inlineSliderColors;
                                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                                }
                                i4 |= i13;
                            } else {
                                inlineSliderColors2 = inlineSliderColors;
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        composer2 = composerStartRestartGroup;
                        if ((i4 & 38347923) == 38347922) {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f2 = i;
                            int iStepsNumber2 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo2 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f3) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f3)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f3) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f3)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i16 = 4193280 & i4;
                            int i17 = i4 << 3;
                            InlineSlider(f2, (Function1) objRememberedValue, iStepsNumber2, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo2, z7, inlineSliderColorsM606colorsoq7We08, composer2, i16 | (234881024 & i17) | (i17 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        } else {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f3 = i;
                            int iStepsNumber3 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo3 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f4) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f4)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f4) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f4)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i18 = 4193280 & i4;
                            int i19 = i4 << 3;
                            InlineSlider(f3, (Function1) objRememberedValue, iStepsNumber3, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo3, z7, inlineSliderColorsM606colorsoq7We08, composer2, i18 | (234881024 & i19) | (i19 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final IntProgression intProgression4 = intProgression2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i110) {
                                    SliderKt.InlineSlider(i, function1, intProgression4, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                        }
                    }
                    i4 |= 196608;
                    modifier2 = modifier;
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        if ((1572864 & i2) == 0) {
                            z3 = z;
                            if (composerStartRestartGroup.changed(z3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i4 |= i10;
                        }
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                z4 = z2;
                                if (composerStartRestartGroup.changed(z4)) {
                                    i12 = 8388608;
                                }
                                i4 |= i12;
                            } else {
                                z4 = z2;
                            }
                            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & 256) == 0) {
                                inlineSliderColors2 = inlineSliderColors;
                                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                                }
                                i4 |= i13;
                            } else {
                                inlineSliderColors2 = inlineSliderColors;
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        composer2 = composerStartRestartGroup;
                        if ((i4 & 38347923) == 38347922) {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f4 = i;
                            int iStepsNumber4 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo4 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f5) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f5)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f5) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f5)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i110 = 4193280 & i4;
                            int i111 = i4 << 3;
                            InlineSlider(f4, (Function1) objRememberedValue, iStepsNumber4, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo4, z7, inlineSliderColorsM606colorsoq7We08, composer2, i110 | (234881024 & i111) | (i111 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        } else {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f5 = i;
                            int iStepsNumber5 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo5 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f6) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f6)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f6) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f6)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i112 = 4193280 & i4;
                            int i113 = i4 << 3;
                            InlineSlider(f5, (Function1) objRememberedValue, iStepsNumber5, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo5, z7, inlineSliderColorsM606colorsoq7We08, composer2, i112 | (234881024 & i113) | (i113 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final IntProgression intProgression5 = intProgression2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i114) {
                                    SliderKt.InlineSlider(i, function1, intProgression5, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                        }
                    }
                    i4 |= 1572864;
                    z3 = z;
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f6 = i;
                        int iStepsNumber6 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo6 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f7) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f7)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f7) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f7)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i114 = 4193280 & i4;
                        int i115 = i4 << 3;
                        InlineSlider(f6, (Function1) objRememberedValue, iStepsNumber6, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo6, z7, inlineSliderColorsM606colorsoq7We08, composer2, i114 | (234881024 & i115) | (i115 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f7 = i;
                        int iStepsNumber7 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo7 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f8) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f8)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f8) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f8)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i116 = 4193280 & i4;
                        int i117 = i4 << 3;
                        InlineSlider(f7, (Function1) objRememberedValue, iStepsNumber7, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo7, z7, inlineSliderColorsM606colorsoq7We08, composer2, i116 | (234881024 & i117) | (i117 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression6 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i118) {
                                SliderKt.InlineSlider(i, function1, intProgression6, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 24576;
                function5 = function3;
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        modifier2 = modifier;
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i8 = 131072;
                        } else {
                            i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        if ((1572864 & i2) == 0) {
                            z3 = z;
                            if (composerStartRestartGroup.changed(z3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i4 |= i10;
                        }
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                z4 = z2;
                                if (composerStartRestartGroup.changed(z4)) {
                                    i12 = 8388608;
                                }
                                i4 |= i12;
                            } else {
                                z4 = z2;
                            }
                            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & 256) == 0) {
                                inlineSliderColors2 = inlineSliderColors;
                                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                                }
                                i4 |= i13;
                            } else {
                                inlineSliderColors2 = inlineSliderColors;
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        composer2 = composerStartRestartGroup;
                        if ((i4 & 38347923) == 38347922) {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f8 = i;
                            int iStepsNumber8 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo8 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f9) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f9)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f9) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f9)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i118 = 4193280 & i4;
                            int i119 = i4 << 3;
                            InlineSlider(f8, (Function1) objRememberedValue, iStepsNumber8, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo8, z7, inlineSliderColorsM606colorsoq7We08, composer2, i118 | (234881024 & i119) | (i119 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        } else {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f9 = i;
                            int iStepsNumber9 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo9 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f10) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f10)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f10) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f10)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i1110 = 4193280 & i4;
                            int i1111 = i4 << 3;
                            InlineSlider(f9, (Function1) objRememberedValue, iStepsNumber9, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo9, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1110 | (234881024 & i1111) | (i1111 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final IntProgression intProgression7 = intProgression2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i1112) {
                                    SliderKt.InlineSlider(i, function1, intProgression7, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                        }
                    }
                    i4 |= 1572864;
                    z3 = z;
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f10 = i;
                        int iStepsNumber10 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo10 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1112 = 4193280 & i4;
                        int i1113 = i4 << 3;
                        InlineSlider(f10, (Function1) objRememberedValue, iStepsNumber10, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo10, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1112 | (234881024 & i1113) | (i1113 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f11 = i;
                        int iStepsNumber11 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo11 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f12) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f12)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f12) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f12)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1114 = 4193280 & i4;
                        int i1115 = i4 << 3;
                        InlineSlider(f11, (Function1) objRememberedValue, iStepsNumber11, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1114 | (234881024 & i1115) | (i1115 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression8 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i1116) {
                                SliderKt.InlineSlider(i, function1, intProgression8, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 196608;
                modifier2 = modifier;
                i9 = i3 & 64;
                if (i9 != 0) {
                    if ((1572864 & i2) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f12 = i;
                        int iStepsNumber12 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo12 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f13) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f13)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f13) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f13)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1116 = 4193280 & i4;
                        int i1117 = i4 << 3;
                        InlineSlider(f12, (Function1) objRememberedValue, iStepsNumber12, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo12, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1116 | (234881024 & i1117) | (i1117 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f13 = i;
                        int iStepsNumber13 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo13 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f14) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f14)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f14) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f14)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1118 = 4193280 & i4;
                        int i1119 = i4 << 3;
                        InlineSlider(f13, (Function1) objRememberedValue, iStepsNumber13, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo13, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1118 | (234881024 & i1119) | (i1119 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression9 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i11110) {
                                SliderKt.InlineSlider(i, function1, intProgression9, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z3 = z;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f14 = i;
                    int iStepsNumber14 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo14 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f15) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f15)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f15) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f15)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i11110 = 4193280 & i4;
                    int i11111 = i4 << 3;
                    InlineSlider(f14, (Function1) objRememberedValue, iStepsNumber14, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo14, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11110 | (234881024 & i11111) | (i11111 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f15 = i;
                    int iStepsNumber15 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo15 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f16) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f16)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f16) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f16)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i11112 = 4193280 & i4;
                    int i11113 = i4 << 3;
                    InlineSlider(f15, (Function1) objRememberedValue, iStepsNumber15, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo15, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11112 | (234881024 & i11113) | (i11113 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression10 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11114) {
                            SliderKt.InlineSlider(i, function1, intProgression10, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 3072;
            function4 = function2;
            if ((i3 & 16) != 0) {
                if ((i2 & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        modifier2 = modifier;
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i8 = 131072;
                        } else {
                            i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        if ((1572864 & i2) == 0) {
                            z3 = z;
                            if (composerStartRestartGroup.changed(z3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i4 |= i10;
                        }
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                z4 = z2;
                                if (composerStartRestartGroup.changed(z4)) {
                                    i12 = 8388608;
                                }
                                i4 |= i12;
                            } else {
                                z4 = z2;
                            }
                            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & 256) == 0) {
                                inlineSliderColors2 = inlineSliderColors;
                                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                                }
                                i4 |= i13;
                            } else {
                                inlineSliderColors2 = inlineSliderColors;
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        composer2 = composerStartRestartGroup;
                        if ((i4 & 38347923) == 38347922) {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f16 = i;
                            int iStepsNumber16 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo16 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f17) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f17)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f17) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f17)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i11114 = 4193280 & i4;
                            int i11115 = i4 << 3;
                            InlineSlider(f16, (Function1) objRememberedValue, iStepsNumber16, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo16, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11114 | (234881024 & i11115) | (i11115 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        } else {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f17 = i;
                            int iStepsNumber17 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo17 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f18) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f18)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f18) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f18)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i11116 = 4193280 & i4;
                            int i11117 = i4 << 3;
                            InlineSlider(f17, (Function1) objRememberedValue, iStepsNumber17, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo17, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11116 | (234881024 & i11117) | (i11117 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final IntProgression intProgression11 = intProgression2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i11118) {
                                    SliderKt.InlineSlider(i, function1, intProgression11, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                        }
                    }
                    i4 |= 1572864;
                    z3 = z;
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f18 = i;
                        int iStepsNumber18 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo18 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f19) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f19)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f19) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f19)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i11118 = 4193280 & i4;
                        int i11119 = i4 << 3;
                        InlineSlider(f18, (Function1) objRememberedValue, iStepsNumber18, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo18, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11118 | (234881024 & i11119) | (i11119 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f19 = i;
                        int iStepsNumber19 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo19 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f110) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f110)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f110) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f110)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111110 = 4193280 & i4;
                        int i111111 = i4 << 3;
                        InlineSlider(f19, (Function1) objRememberedValue, iStepsNumber19, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo19, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111110 | (234881024 & i111111) | (i111111 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression12 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i111112) {
                                SliderKt.InlineSlider(i, function1, intProgression12, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 196608;
                modifier2 = modifier;
                i9 = i3 & 64;
                if (i9 != 0) {
                    if ((1572864 & i2) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f110 = i;
                        int iStepsNumber110 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo110 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f111) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f111)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f111) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f111)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111112 = 4193280 & i4;
                        int i111113 = i4 << 3;
                        InlineSlider(f110, (Function1) objRememberedValue, iStepsNumber110, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo110, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111112 | (234881024 & i111113) | (i111113 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f111 = i;
                        int iStepsNumber111 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo111 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f112) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f112)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f112) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f112)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111114 = 4193280 & i4;
                        int i111115 = i4 << 3;
                        InlineSlider(f111, (Function1) objRememberedValue, iStepsNumber111, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111114 | (234881024 & i111115) | (i111115 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression13 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i111116) {
                                SliderKt.InlineSlider(i, function1, intProgression13, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z3 = z;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f112 = i;
                    int iStepsNumber112 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo112 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f113) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f113)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f113) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f113)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111116 = 4193280 & i4;
                    int i111117 = i4 << 3;
                    InlineSlider(f112, (Function1) objRememberedValue, iStepsNumber112, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo112, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111116 | (234881024 & i111117) | (i111117 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f113 = i;
                    int iStepsNumber113 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo113 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f114) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f114)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f114) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f114)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111118 = 4193280 & i4;
                    int i111119 = i4 << 3;
                    InlineSlider(f113, (Function1) objRememberedValue, iStepsNumber113, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo113, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111118 | (234881024 & i111119) | (i111119 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression14 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i1111110) {
                            SliderKt.InlineSlider(i, function1, intProgression14, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 24576;
            function5 = function3;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 131072;
                    } else {
                        i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    if ((1572864 & i2) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f114 = i;
                        int iStepsNumber114 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo114 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f115) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f115)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f115) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f115)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1111110 = 4193280 & i4;
                        int i1111111 = i4 << 3;
                        InlineSlider(f114, (Function1) objRememberedValue, iStepsNumber114, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo114, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111110 | (234881024 & i1111111) | (i1111111 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f115 = i;
                        int iStepsNumber115 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo115 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f116) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f116)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f116) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f116)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1111112 = 4193280 & i4;
                        int i1111113 = i4 << 3;
                        InlineSlider(f115, (Function1) objRememberedValue, iStepsNumber115, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo115, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111112 | (234881024 & i1111113) | (i1111113 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression15 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i1111114) {
                                SliderKt.InlineSlider(i, function1, intProgression15, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z3 = z;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f116 = i;
                    int iStepsNumber116 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo116 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f117) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f117)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f117) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f117)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111114 = 4193280 & i4;
                    int i1111115 = i4 << 3;
                    InlineSlider(f116, (Function1) objRememberedValue, iStepsNumber116, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo116, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111114 | (234881024 & i1111115) | (i1111115 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f117 = i;
                    int iStepsNumber117 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo117 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f118) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f118)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f118) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f118)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111116 = 4193280 & i4;
                    int i1111117 = i4 << 3;
                    InlineSlider(f117, (Function1) objRememberedValue, iStepsNumber117, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo117, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111116 | (234881024 & i1111117) | (i1111117 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression16 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i1111118) {
                            SliderKt.InlineSlider(i, function1, intProgression16, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 196608;
            modifier2 = modifier;
            i9 = i3 & 64;
            if (i9 != 0) {
                if ((1572864 & i2) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f118 = i;
                    int iStepsNumber118 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo118 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f119) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f119)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f119) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f119)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111118 = 4193280 & i4;
                    int i1111119 = i4 << 3;
                    InlineSlider(f118, (Function1) objRememberedValue, iStepsNumber118, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo118, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111118 | (234881024 & i1111119) | (i1111119 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f119 = i;
                    int iStepsNumber119 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo119 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f1110) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f1110)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f1110) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f1110)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i11111110 = 4193280 & i4;
                    int i11111111 = i4 << 3;
                    InlineSlider(f119, (Function1) objRememberedValue, iStepsNumber119, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo119, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111110 | (234881024 & i11111111) | (i11111111 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression17 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11111112) {
                            SliderKt.InlineSlider(i, function1, intProgression17, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 1572864;
            z3 = z;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i12 = 8388608;
                    }
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i12;
            } else {
                z4 = z2;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i13;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 38347923) == 38347922) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f1110 = i;
                int iStepsNumber1110 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo1110 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111112 = 4193280 & i4;
                int i11111113 = i4 << 3;
                InlineSlider(f1110, (Function1) objRememberedValue, iStepsNumber1110, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1110, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111112 | (234881024 & i11111113) | (i11111113 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f1111 = i;
                int iStepsNumber1111 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo1111 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1112) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1112)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1112) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1112)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111114 = 4193280 & i4;
                int i11111115 = i4 << 3;
                InlineSlider(f1111, (Function1) objRememberedValue, iStepsNumber1111, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1111, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111114 | (234881024 & i11111115) | (i11111115 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final IntProgression intProgression18 = intProgression2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i11111116) {
                        SliderKt.InlineSlider(i, function1, intProgression18, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 384;
        intProgression2 = intProgression;
        if ((i3 & 8) != 0) {
            if ((i2 & 3072) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i4 |= i5;
            }
            if ((i3 & 16) != 0) {
                if ((i2 & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    if ((196608 & i2) == 0) {
                        modifier2 = modifier;
                        if (composerStartRestartGroup.changed(modifier2)) {
                            i8 = 131072;
                        } else {
                            i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        if ((1572864 & i2) == 0) {
                            z3 = z;
                            if (composerStartRestartGroup.changed(z3)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i4 |= i10;
                        }
                        if ((12582912 & i2) == 0) {
                            if ((i3 & 128) == 0) {
                                z4 = z2;
                                if (composerStartRestartGroup.changed(z4)) {
                                    i12 = 8388608;
                                }
                                i4 |= i12;
                            } else {
                                z4 = z2;
                            }
                            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & 256) == 0) {
                                inlineSliderColors2 = inlineSliderColors;
                                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                                }
                                i4 |= i13;
                            } else {
                                inlineSliderColors2 = inlineSliderColors;
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        composer2 = composerStartRestartGroup;
                        if ((i4 & 38347923) == 38347922) {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f1112 = i;
                            int iStepsNumber1112 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo1112 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f1113) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1113)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f1113) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1113)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i11111116 = 4193280 & i4;
                            int i11111117 = i4 << 3;
                            InlineSlider(f1112, (Function1) objRememberedValue, iStepsNumber1112, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1112, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111116 | (234881024 & i11111117) | (i11111117 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        } else {
                            composer2.startDefaults();
                            if ((i2 & 1) != 0) {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            } else {
                                if (i7 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if (i9 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z3;
                                }
                                if ((i3 & 128) != 0) {
                                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                        z9 = true;
                                    } else {
                                        z9 = false;
                                    }
                                    i11 = i4 & (-29360129);
                                    z6 = z9;
                                } else {
                                    i11 = i4;
                                    z6 = z4;
                                }
                                if ((i3 & 256) != 0) {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                    z8 = z5;
                                    i4 = i11 & (-234881025);
                                } else {
                                    modifier4 = modifier3;
                                    z7 = z6;
                                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                    z8 = z5;
                                    i4 = i11;
                                }
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                            }
                            float f1113 = i;
                            int iStepsNumber1113 = RangeDefaultsKt.stepsNumber(intProgression2);
                            ClosedFloatingPointRange closedFloatingPointRangeRangeTo1113 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                            if ((i4 & 112) == 32) {
                            }
                            objRememberedValue = composer2.rememberedValue();
                            if (!z10) {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f1114) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1114)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            } else {
                                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f1114) {
                                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1114)));
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            int i11111118 = 4193280 & i4;
                            int i11111119 = i4 << 3;
                            InlineSlider(f1113, (Function1) objRememberedValue, iStepsNumber1113, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1113, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111118 | (234881024 & i11111119) | (i11111119 & 1879048192), 0);
                            composer2 = composer2;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier5 = modifier4;
                            z11 = z8;
                            z12 = z7;
                            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final IntProgression intProgression19 = intProgression2;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i111111110) {
                                    SliderKt.InlineSlider(i, function1, intProgression19, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                        }
                    }
                    i4 |= 1572864;
                    z3 = z;
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f1114 = i;
                        int iStepsNumber1114 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo1114 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1115) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1115)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1115) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1115)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111111110 = 4193280 & i4;
                        int i111111111 = i4 << 3;
                        InlineSlider(f1114, (Function1) objRememberedValue, iStepsNumber1114, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1114, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111110 | (234881024 & i111111111) | (i111111111 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f1115 = i;
                        int iStepsNumber1115 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo1115 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1116) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1116)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1116) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1116)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111111112 = 4193280 & i4;
                        int i111111113 = i4 << 3;
                        InlineSlider(f1115, (Function1) objRememberedValue, iStepsNumber1115, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1115, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111112 | (234881024 & i111111113) | (i111111113 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression110 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i111111114) {
                                SliderKt.InlineSlider(i, function1, intProgression110, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 196608;
                modifier2 = modifier;
                i9 = i3 & 64;
                if (i9 != 0) {
                    if ((1572864 & i2) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f1116 = i;
                        int iStepsNumber1116 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo1116 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1117) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1117)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1117) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1117)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111111114 = 4193280 & i4;
                        int i111111115 = i4 << 3;
                        InlineSlider(f1116, (Function1) objRememberedValue, iStepsNumber1116, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1116, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111114 | (234881024 & i111111115) | (i111111115 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f1117 = i;
                        int iStepsNumber1117 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo1117 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1118) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1118)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f1118) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f1118)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111111116 = 4193280 & i4;
                        int i111111117 = i4 << 3;
                        InlineSlider(f1117, (Function1) objRememberedValue, iStepsNumber1117, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1117, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111116 | (234881024 & i111111117) | (i111111117 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression111 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i111111118) {
                                SliderKt.InlineSlider(i, function1, intProgression111, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z3 = z;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f1118 = i;
                    int iStepsNumber1118 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo1118 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f1119) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f1119)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f1119) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f1119)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111111118 = 4193280 & i4;
                    int i111111119 = i4 << 3;
                    InlineSlider(f1118, (Function1) objRememberedValue, iStepsNumber1118, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1118, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111118 | (234881024 & i111111119) | (i111111119 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f1119 = i;
                    int iStepsNumber1119 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo1119 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11110) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11110)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11110) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11110)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111111110 = 4193280 & i4;
                    int i1111111111 = i4 << 3;
                    InlineSlider(f1119, (Function1) objRememberedValue, iStepsNumber1119, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1119, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111110 | (234881024 & i1111111111) | (i1111111111 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression112 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i1111111112) {
                            SliderKt.InlineSlider(i, function1, intProgression112, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 24576;
            function5 = function3;
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 131072;
                    } else {
                        i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    if ((1572864 & i2) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f11110 = i;
                        int iStepsNumber11110 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo11110 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11111) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11111)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11111) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11111)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1111111112 = 4193280 & i4;
                        int i1111111113 = i4 << 3;
                        InlineSlider(f11110, (Function1) objRememberedValue, iStepsNumber11110, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11110, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111112 | (234881024 & i1111111113) | (i1111111113 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f11111 = i;
                        int iStepsNumber11111 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo11111 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11112) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11112)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11112) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11112)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i1111111114 = 4193280 & i4;
                        int i1111111115 = i4 << 3;
                        InlineSlider(f11111, (Function1) objRememberedValue, iStepsNumber11111, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11111, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111114 | (234881024 & i1111111115) | (i1111111115 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression113 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i1111111116) {
                                SliderKt.InlineSlider(i, function1, intProgression113, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z3 = z;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f11112 = i;
                    int iStepsNumber11112 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo11112 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11113) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11113)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11113) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11113)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111111116 = 4193280 & i4;
                    int i1111111117 = i4 << 3;
                    InlineSlider(f11112, (Function1) objRememberedValue, iStepsNumber11112, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11112, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111116 | (234881024 & i1111111117) | (i1111111117 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f11113 = i;
                    int iStepsNumber11113 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo11113 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11114) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11114)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11114) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11114)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111111118 = 4193280 & i4;
                    int i1111111119 = i4 << 3;
                    InlineSlider(f11113, (Function1) objRememberedValue, iStepsNumber11113, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11113, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111118 | (234881024 & i1111111119) | (i1111111119 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression114 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11111111110) {
                            SliderKt.InlineSlider(i, function1, intProgression114, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 196608;
            modifier2 = modifier;
            i9 = i3 & 64;
            if (i9 != 0) {
                if ((1572864 & i2) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f11114 = i;
                    int iStepsNumber11114 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo11114 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11115) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11115)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11115) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11115)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i11111111110 = 4193280 & i4;
                    int i11111111111 = i4 << 3;
                    InlineSlider(f11114, (Function1) objRememberedValue, iStepsNumber11114, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11114, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111110 | (234881024 & i11111111111) | (i11111111111 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f11115 = i;
                    int iStepsNumber11115 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo11115 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11116) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11116)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f11116) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f11116)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i11111111112 = 4193280 & i4;
                    int i11111111113 = i4 << 3;
                    InlineSlider(f11115, (Function1) objRememberedValue, iStepsNumber11115, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11115, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111112 | (234881024 & i11111111113) | (i11111111113 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression115 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11111111114) {
                            SliderKt.InlineSlider(i, function1, intProgression115, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 1572864;
            z3 = z;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i12 = 8388608;
                    }
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i12;
            } else {
                z4 = z2;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i13;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 38347923) == 38347922) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f11116 = i;
                int iStepsNumber11116 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo11116 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f11117) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f11117)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f11117) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f11117)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111111114 = 4193280 & i4;
                int i11111111115 = i4 << 3;
                InlineSlider(f11116, (Function1) objRememberedValue, iStepsNumber11116, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11116, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111114 | (234881024 & i11111111115) | (i11111111115 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f11117 = i;
                int iStepsNumber11117 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo11117 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f11118) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f11118)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f11118) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f11118)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111111116 = 4193280 & i4;
                int i11111111117 = i4 << 3;
                InlineSlider(f11117, (Function1) objRememberedValue, iStepsNumber11117, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11117, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111116 | (234881024 & i11111111117) | (i11111111117 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final IntProgression intProgression116 = intProgression2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i11111111118) {
                        SliderKt.InlineSlider(i, function1, intProgression116, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 3072;
        function4 = function2;
        if ((i3 & 16) != 0) {
            if ((i2 & 24576) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                if ((196608 & i2) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i8 = 131072;
                    } else {
                        i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    if ((1572864 & i2) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i12 = 8388608;
                            }
                            i4 |= i12;
                        } else {
                            z4 = z2;
                        }
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    if ((i2 & 100663296) == 0) {
                        if ((i3 & 256) == 0) {
                            inlineSliderColors2 = inlineSliderColors;
                            if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                            }
                            i4 |= i13;
                        } else {
                            inlineSliderColors2 = inlineSliderColors;
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    composer2 = composerStartRestartGroup;
                    if ((i4 & 38347923) == 38347922) {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f11118 = i;
                        int iStepsNumber11118 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo11118 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11119) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11119)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f11119) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f11119)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i11111111118 = 4193280 & i4;
                        int i11111111119 = i4 << 3;
                        InlineSlider(f11118, (Function1) objRememberedValue, iStepsNumber11118, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11118, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111118 | (234881024 & i11111111119) | (i11111111119 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    } else {
                        composer2.startDefaults();
                        if ((i2 & 1) != 0) {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        } else {
                            if (i7 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i9 != 0) {
                                z5 = true;
                            } else {
                                z5 = z3;
                            }
                            if ((i3 & 128) != 0) {
                                if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                i11 = i4 & (-29360129);
                                z6 = z9;
                            } else {
                                i11 = i4;
                                z6 = z4;
                            }
                            if ((i3 & 256) != 0) {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                                z8 = z5;
                                i4 = i11 & (-234881025);
                            } else {
                                modifier4 = modifier3;
                                z7 = z6;
                                inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                                z8 = z5;
                                i4 = i11;
                            }
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                        }
                        float f11119 = i;
                        int iStepsNumber11119 = RangeDefaultsKt.stepsNumber(intProgression2);
                        ClosedFloatingPointRange closedFloatingPointRangeRangeTo11119 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                        ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                        if ((i4 & 112) == 32) {
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f111110) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f111110)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).floatValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(float f111110) {
                                    function1.invoke(Integer.valueOf(MathKt.roundToInt(f111110)));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        int i111111111110 = 4193280 & i4;
                        int i111111111111 = i4 << 3;
                        InlineSlider(f11119, (Function1) objRememberedValue, iStepsNumber11119, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo11119, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111111110 | (234881024 & i111111111111) | (i111111111111 & 1879048192), 0);
                        composer2 = composer2;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier5 = modifier4;
                        z11 = z8;
                        z12 = z7;
                        inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final IntProgression intProgression117 = intProgression2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i111111111112) {
                                SliderKt.InlineSlider(i, function1, intProgression117, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z3 = z;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f111110 = i;
                    int iStepsNumber111110 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo111110 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111111) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111111)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111111) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111111)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111111111112 = 4193280 & i4;
                    int i111111111113 = i4 << 3;
                    InlineSlider(f111110, (Function1) objRememberedValue, iStepsNumber111110, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111110, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111111112 | (234881024 & i111111111113) | (i111111111113 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f111111 = i;
                    int iStepsNumber111111 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo111111 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111112) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111112)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111112) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111112)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111111111114 = 4193280 & i4;
                    int i111111111115 = i4 << 3;
                    InlineSlider(f111111, (Function1) objRememberedValue, iStepsNumber111111, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111111, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111111114 | (234881024 & i111111111115) | (i111111111115 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression118 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i111111111116) {
                            SliderKt.InlineSlider(i, function1, intProgression118, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 196608;
            modifier2 = modifier;
            i9 = i3 & 64;
            if (i9 != 0) {
                if ((1572864 & i2) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f111112 = i;
                    int iStepsNumber111112 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo111112 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111113) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111113)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111113) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111113)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111111111116 = 4193280 & i4;
                    int i111111111117 = i4 << 3;
                    InlineSlider(f111112, (Function1) objRememberedValue, iStepsNumber111112, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111112, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111111116 | (234881024 & i111111111117) | (i111111111117 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f111113 = i;
                    int iStepsNumber111113 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo111113 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111114) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111114)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111114) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111114)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i111111111118 = 4193280 & i4;
                    int i111111111119 = i4 << 3;
                    InlineSlider(f111113, (Function1) objRememberedValue, iStepsNumber111113, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111113, z7, inlineSliderColorsM606colorsoq7We08, composer2, i111111111118 | (234881024 & i111111111119) | (i111111111119 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression119 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i1111111111110) {
                            SliderKt.InlineSlider(i, function1, intProgression119, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 1572864;
            z3 = z;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i12 = 8388608;
                    }
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i12;
            } else {
                z4 = z2;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i13;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 38347923) == 38347922) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f111114 = i;
                int iStepsNumber111114 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo111114 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f111115) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f111115)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f111115) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f111115)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i1111111111110 = 4193280 & i4;
                int i1111111111111 = i4 << 3;
                InlineSlider(f111114, (Function1) objRememberedValue, iStepsNumber111114, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111114, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111111110 | (234881024 & i1111111111111) | (i1111111111111 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f111115 = i;
                int iStepsNumber111115 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo111115 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f111116) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f111116)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f111116) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f111116)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i1111111111112 = 4193280 & i4;
                int i1111111111113 = i4 << 3;
                InlineSlider(f111115, (Function1) objRememberedValue, iStepsNumber111115, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111115, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111111112 | (234881024 & i1111111111113) | (i1111111111113 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final IntProgression intProgression1110 = intProgression2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i1111111111114) {
                        SliderKt.InlineSlider(i, function1, intProgression1110, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 24576;
        function5 = function3;
        i7 = i3 & 32;
        if (i7 != 0) {
            if ((196608 & i2) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i8 = 131072;
                } else {
                    i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                if ((1572864 & i2) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i12 = 8388608;
                        }
                        i4 |= i12;
                    } else {
                        z4 = z2;
                    }
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                if ((i2 & 100663296) == 0) {
                    if ((i3 & 256) == 0) {
                        inlineSliderColors2 = inlineSliderColors;
                        if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                        }
                        i4 |= i13;
                    } else {
                        inlineSliderColors2 = inlineSliderColors;
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                composer2 = composerStartRestartGroup;
                if ((i4 & 38347923) == 38347922) {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f111116 = i;
                    int iStepsNumber111116 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo111116 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111117) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111117)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111117) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111117)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111111111114 = 4193280 & i4;
                    int i1111111111115 = i4 << 3;
                    InlineSlider(f111116, (Function1) objRememberedValue, iStepsNumber111116, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111116, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111111114 | (234881024 & i1111111111115) | (i1111111111115 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                } else {
                    composer2.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    } else {
                        if (i7 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i9 != 0) {
                            z5 = true;
                        } else {
                            z5 = z3;
                        }
                        if ((i3 & 128) != 0) {
                            if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            i11 = i4 & (-29360129);
                            z6 = z9;
                        } else {
                            i11 = i4;
                            z6 = z4;
                        }
                        if ((i3 & 256) != 0) {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                            z8 = z5;
                            i4 = i11 & (-234881025);
                        } else {
                            modifier4 = modifier3;
                            z7 = z6;
                            inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                            z8 = z5;
                            i4 = i11;
                        }
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                    }
                    float f111117 = i;
                    int iStepsNumber111117 = RangeDefaultsKt.stepsNumber(intProgression2);
                    ClosedFloatingPointRange closedFloatingPointRangeRangeTo111117 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                    if ((i4 & 112) == 32) {
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z10) {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111118) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111118)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float f111118) {
                                function1.invoke(Integer.valueOf(MathKt.roundToInt(f111118)));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    int i1111111111116 = 4193280 & i4;
                    int i1111111111117 = i4 << 3;
                    InlineSlider(f111117, (Function1) objRememberedValue, iStepsNumber111117, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111117, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111111116 | (234881024 & i1111111111117) | (i1111111111117 & 1879048192), 0);
                    composer2 = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    z11 = z8;
                    z12 = z7;
                    inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final IntProgression intProgression1111 = intProgression2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i1111111111118) {
                            SliderKt.InlineSlider(i, function1, intProgression1111, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 1572864;
            z3 = z;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i12 = 8388608;
                    }
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i12;
            } else {
                z4 = z2;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i13;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 38347923) == 38347922) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f111118 = i;
                int iStepsNumber111118 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo111118 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f111119) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f111119)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f111119) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f111119)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i1111111111118 = 4193280 & i4;
                int i1111111111119 = i4 << 3;
                InlineSlider(f111118, (Function1) objRememberedValue, iStepsNumber111118, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111118, z7, inlineSliderColorsM606colorsoq7We08, composer2, i1111111111118 | (234881024 & i1111111111119) | (i1111111111119 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f111119 = i;
                int iStepsNumber111119 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo111119 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111110) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111110)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111110) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111110)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111111111110 = 4193280 & i4;
                int i11111111111111 = i4 << 3;
                InlineSlider(f111119, (Function1) objRememberedValue, iStepsNumber111119, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo111119, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111111110 | (234881024 & i11111111111111) | (i11111111111111 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final IntProgression intProgression1112 = intProgression2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i11111111111112) {
                        SliderKt.InlineSlider(i, function1, intProgression1112, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 196608;
        modifier2 = modifier;
        i9 = i3 & 64;
        if (i9 != 0) {
            if ((1572864 & i2) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i12 = 8388608;
                    }
                    i4 |= i12;
                } else {
                    z4 = z2;
                }
                i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i12;
            } else {
                z4 = z2;
            }
            if ((i2 & 100663296) == 0) {
                if ((i3 & 256) == 0) {
                    inlineSliderColors2 = inlineSliderColors;
                    if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                    }
                    i4 |= i13;
                } else {
                    inlineSliderColors2 = inlineSliderColors;
                }
                i4 |= i13;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            composer2 = composerStartRestartGroup;
            if ((i4 & 38347923) == 38347922) {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f1111110 = i;
                int iStepsNumber1111110 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo1111110 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111111) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111111)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111111) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111111)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111111111112 = 4193280 & i4;
                int i11111111111113 = i4 << 3;
                InlineSlider(f1111110, (Function1) objRememberedValue, iStepsNumber1111110, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1111110, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111111112 | (234881024 & i11111111111113) | (i11111111111113 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            } else {
                composer2.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                } else {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i9 != 0) {
                        z5 = true;
                    } else {
                        z5 = z3;
                    }
                    if ((i3 & 128) != 0) {
                        if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        i11 = i4 & (-29360129);
                        z6 = z9;
                    } else {
                        i11 = i4;
                        z6 = z4;
                    }
                    if ((i3 & 256) != 0) {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                        z8 = z5;
                        i4 = i11 & (-234881025);
                    } else {
                        modifier4 = modifier3;
                        z7 = z6;
                        inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                        z8 = z5;
                        i4 = i11;
                    }
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
                }
                float f1111111 = i;
                int iStepsNumber1111111 = RangeDefaultsKt.stepsNumber(intProgression2);
                ClosedFloatingPointRange closedFloatingPointRangeRangeTo1111111 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
                ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
                if ((i4 & 112) == 32) {
                }
                objRememberedValue = composer2.rememberedValue();
                if (!z10) {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111112) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111112)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f1111112) {
                            function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111112)));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                int i11111111111114 = 4193280 & i4;
                int i11111111111115 = i4 << 3;
                InlineSlider(f1111111, (Function1) objRememberedValue, iStepsNumber1111111, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1111111, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111111114 | (234881024 & i11111111111115) | (i11111111111115 & 1879048192), 0);
                composer2 = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                z11 = z8;
                z12 = z7;
                inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final IntProgression intProgression1113 = intProgression2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i11111111111116) {
                        SliderKt.InlineSlider(i, function1, intProgression1113, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 1572864;
        z3 = z;
        if ((12582912 & i2) == 0) {
            if ((i3 & 128) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i12 = 8388608;
                }
                i4 |= i12;
            } else {
                z4 = z2;
            }
            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i4 |= i12;
        } else {
            z4 = z2;
        }
        if ((i2 & 100663296) == 0) {
            if ((i3 & 256) == 0) {
                inlineSliderColors2 = inlineSliderColors;
                if (composerStartRestartGroup.changed(inlineSliderColors2)) {
                }
                i4 |= i13;
            } else {
                inlineSliderColors2 = inlineSliderColors;
            }
            i4 |= i13;
        } else {
            inlineSliderColors2 = inlineSliderColors;
        }
        composer2 = composerStartRestartGroup;
        if ((i4 & 38347923) == 38347922) {
            composer2.startDefaults();
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((i3 & 128) != 0) {
                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i11 = i4 & (-29360129);
                    z6 = z9;
                } else {
                    i11 = i4;
                    z6 = z4;
                }
                if ((i3 & 256) != 0) {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    z8 = z5;
                    i4 = i11 & (-234881025);
                } else {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                    z8 = z5;
                    i4 = i11;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((i3 & 128) != 0) {
                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i11 = i4 & (-29360129);
                    z6 = z9;
                } else {
                    i11 = i4;
                    z6 = z4;
                }
                if ((i3 & 256) != 0) {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    z8 = z5;
                    i4 = i11 & (-234881025);
                } else {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                    z8 = z5;
                    i4 = i11;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
            }
            float f1111112 = i;
            int iStepsNumber1111112 = RangeDefaultsKt.stepsNumber(intProgression2);
            ClosedFloatingPointRange closedFloatingPointRangeRangeTo1111112 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
            if ((i4 & 112) == 32) {
            }
            objRememberedValue = composer2.rememberedValue();
            if (!z10) {
                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f1111113) {
                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111113)));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f1111113) {
                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111113)));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i11111111111116 = 4193280 & i4;
            int i11111111111117 = i4 << 3;
            InlineSlider(f1111112, (Function1) objRememberedValue, iStepsNumber1111112, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1111112, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111111116 | (234881024 & i11111111111117) | (i11111111111117 & 1879048192), 0);
            composer2 = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z11 = z8;
            z12 = z7;
            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
        } else {
            composer2.startDefaults();
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((i3 & 128) != 0) {
                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i11 = i4 & (-29360129);
                    z6 = z9;
                } else {
                    i11 = i4;
                    z6 = z4;
                }
                if ((i3 & 256) != 0) {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    z8 = z5;
                    i4 = i11 & (-234881025);
                } else {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                    z8 = z5;
                    i4 = i11;
                }
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i9 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if ((i3 & 128) != 0) {
                    if (RangeDefaultsKt.stepsNumber(intProgression2) <= 8) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    i11 = i4 & (-29360129);
                    z6 = z9;
                } else {
                    i11 = i4;
                    z6 = z4;
                }
                if ((i3 & 256) != 0) {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = InlineSliderDefaults.INSTANCE.m606colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 100663296, Constants.MAX_HOST_LENGTH);
                    z8 = z5;
                    i4 = i11 & (-234881025);
                } else {
                    modifier4 = modifier3;
                    z7 = z6;
                    inlineSliderColorsM606colorsoq7We08 = inlineSliderColors2;
                    z8 = z5;
                    i4 = i11;
                }
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552268373, i4, -1, "androidx.wear.compose.material.InlineSlider (Slider.kt:265)");
            }
            float f1111113 = i;
            int iStepsNumber1111113 = RangeDefaultsKt.stepsNumber(intProgression2);
            ClosedFloatingPointRange closedFloatingPointRangeRangeTo1111113 = RangesKt.rangeTo(intProgression2.getFirst(), intProgression2.getLast());
            ComposerKt.sourceInformationMarkerStart(composer2, 1813810461, "CC(remember):Slider.kt#9igjgp");
            if ((i4 & 112) == 32) {
            }
            objRememberedValue = composer2.rememberedValue();
            if (!z10) {
                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f1111114) {
                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111114)));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<Float, Unit>() { // from class: androidx.wear.compose.material.SliderKt$InlineSlider$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f1111114) {
                        function1.invoke(Integer.valueOf(MathKt.roundToInt(f1111114)));
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            int i11111111111118 = 4193280 & i4;
            int i11111111111119 = i4 << 3;
            InlineSlider(f1111113, (Function1) objRememberedValue, iStepsNumber1111113, function4, function5, modifier4, z8, closedFloatingPointRangeRangeTo1111113, z7, inlineSliderColorsM606colorsoq7We08, composer2, i11111111111118 | (234881024 & i11111111111119) | (i11111111111119 & 1879048192), 0);
            composer2 = composer2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            z11 = z8;
            z12 = z7;
            inlineSliderColors3 = inlineSliderColorsM606colorsoq7We08;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final IntProgression intProgression1114 = intProgression2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSlider.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i111111111111110) {
                    SliderKt.InlineSlider(i, function1, intProgression1114, function2, function3, modifier5, z11, z12, inlineSliderColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawSelectedProgressBar-RPmYEkk, reason: not valid java name */
    public static final void m795drawSelectedProgressBarRPmYEkk(DrawScope drawScope, long j, float f, LayoutDirection layoutDirection) {
        float f2 = 2;
        DrawScope.drawLine-NGM6Ib0$default(drawScope, j, OffsetKt.Offset(((Number) androidx.wear.compose.materialcore.SliderKt.directedValue(layoutDirection, Float.valueOf(0.0f), Float.valueOf(Size.getWidth-impl(drawScope.getSize-NH-jbRc()) * (1 - f)))).floatValue(), Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / f2), OffsetKt.Offset(((Number) androidx.wear.compose.materialcore.SliderKt.directedValue(layoutDirection, Float.valueOf(Size.getWidth-impl(drawScope.getSize-NH-jbRc()) * f), Float.valueOf(Size.getWidth-impl(drawScope.getSize-NH-jbRc())))).floatValue(), Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / f2), drawScope.toPx-0680j_4(InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawUnselectedProgressBar-RPmYEkk, reason: not valid java name */
    public static final void m796drawUnselectedProgressBarRPmYEkk(DrawScope drawScope, long j, float f, LayoutDirection layoutDirection) {
        float f2 = 2;
        DrawScope.drawLine-NGM6Ib0$default(drawScope, j, OffsetKt.Offset(((Number) androidx.wear.compose.materialcore.SliderKt.directedValue(layoutDirection, Float.valueOf(Size.getWidth-impl(drawScope.getSize-NH-jbRc()) * f), Float.valueOf(0.0f))).floatValue(), Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / f2), OffsetKt.Offset(((Number) androidx.wear.compose.materialcore.SliderKt.directedValue(layoutDirection, Float.valueOf(Size.getWidth-impl(drawScope.getSize-NH-jbRc())), Float.valueOf(Size.getWidth-impl(drawScope.getSize-NH-jbRc()) * (1 - f)))).floatValue(), Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / f2), drawScope.toPx-0680j_4(InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()), 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawProgressBarSeparator-bw27NRU, reason: not valid java name */
    public static final void m794drawProgressBarSeparatorbw27NRU(DrawScope drawScope, long j, float f) {
        float f2 = 2;
        DrawScope.drawLine-NGM6Ib0$default(drawScope, j, OffsetKt.Offset(f, (Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / f2) - (drawScope.toPx-0680j_4(InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()) / f2)), OffsetKt.Offset(f, (Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / f2) + (drawScope.toPx-0680j_4(InlineSliderDefaults.INSTANCE.m607getBarHeightD9Ej5fM$compose_material_release()) / f2)), drawScope.toPx-0680j_4(InlineSliderDefaults.INSTANCE.m609getBarSeparatorWidthD9Ej5fM$compose_material_release()), 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InlineSliderButtonContent(final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        float disabled;
        Composer composerStartRestartGroup = composer.startRestartGroup(466984089);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InlineSliderButtonContent)P(1)490@20343L155:Slider.kt#gj9v0t");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(466984089, i2, -1, "androidx.wear.compose.material.InlineSliderButtonContent (Slider.kt:490)");
            }
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-550253677);
                ComposerKt.sourceInformation(composerStartRestartGroup, "492@20439L7");
                CompositionLocal localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContentAlpha2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                disabled = ((Number) objConsume).floatValue();
            } else {
                composerStartRestartGroup.startReplaceGroup(-550252844);
                ComposerKt.sourceInformation(composerStartRestartGroup, "492@20465L8");
                disabled = ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(localContentAlpha.provides(Float.valueOf(disabled)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.SliderKt.InlineSliderButtonContent.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    SliderKt.InlineSliderButtonContent(z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final float InlineSlider$lambda$7$lambda$6$lambda$4(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }
}
