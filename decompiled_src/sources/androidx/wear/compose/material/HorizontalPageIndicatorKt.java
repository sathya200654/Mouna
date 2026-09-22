package androidx.wear.compose.material;

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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.CurvedComposableKt;
import androidx.wear.compose.foundation.CurvedDirection;
import androidx.wear.compose.foundation.CurvedLayoutKt;
import androidx.wear.compose.foundation.CurvedScope;
import androidx.wear.compose.materialcore.BoundsLimiterKt;
import androidx.wear.compose.materialcore.PagesState;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HorizontalPageIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u001aT\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\u00062\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\n\u001a`\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\\\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\u00062\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0002\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u008e\u0002"}, d2 = {"CurvedPageIndicator", "", "pagesOnScreen", "", "indicatorFactory", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "spacerLeft", "Lkotlin/Function0;", "spacerRight", "(ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "HorizontalPageIndicator", "pageIndicatorState", "Landroidx/wear/compose/material/PageIndicatorState;", "modifier", "Landroidx/compose/ui/Modifier;", "indicatorStyle", "Landroidx/wear/compose/material/PageIndicatorStyle;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "indicatorSize", "Landroidx/compose/ui/unit/Dp;", "spacing", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "HorizontalPageIndicator-TB1-hms", "(Landroidx/wear/compose/material/PageIndicatorState;Landroidx/compose/ui/Modifier;IJJFFLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "LinearPageIndicator", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "compose-material_release", "containerSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class HorizontalPageIndicatorKt {
    /* JADX WARN: Code duplicated, block: B:115:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0159  */
    /* JADX WARN: Code duplicated, block: B:119:0x0163  */
    /* JADX WARN: Code duplicated, block: B:122:0x0170  */
    /* JADX WARN: Code duplicated, block: B:125:0x0182  */
    /* JADX WARN: Code duplicated, block: B:126:0x0197  */
    /* JADX WARN: Code duplicated, block: B:128:0x019a  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:134:0x01af  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:141:0x0219  */
    /* JADX WARN: Code duplicated, block: B:143:0x0221  */
    /* JADX WARN: Code duplicated, block: B:146:0x0278  */
    /* JADX WARN: Code duplicated, block: B:147:0x029f  */
    /* JADX WARN: Code duplicated, block: B:149:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:151:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:154:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:155:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:158:0x0300  */
    /* JADX WARN: Code duplicated, block: B:159:0x0302  */
    /* JADX WARN: Code duplicated, block: B:162:0x030f  */
    /* JADX WARN: Code duplicated, block: B:164:0x0317  */
    /* JADX WARN: Code duplicated, block: B:167:0x0337  */
    /* JADX WARN: Code duplicated, block: B:169:0x033f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0361  */
    /* JADX WARN: Code duplicated, block: B:174:0x039f  */
    /* JADX WARN: Code duplicated, block: B:177:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:181:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:51:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:97:0x011d  */
    /* JADX WARN: Code duplicated, block: B:99:0x012a  */
    /* JADX INFO: renamed from: HorizontalPageIndicator-TB1-hms, reason: not valid java name */
    public static final void m598HorizontalPageIndicatorTB1hms(final PageIndicatorState pageIndicatorState, Modifier modifier, int i, long j, long j2, float f, float f2, Shape shape, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int iM619style2LWCLk;
        long onBackground;
        long j3;
        int i5;
        float f3;
        int i6;
        int i7;
        int i8;
        Shape shape2;
        long j4;
        long j5;
        final float f4;
        final Shape shape3;
        final long j6;
        final long j7;
        final float f5;
        final int iMin;
        boolean zChanged;
        Object objRememberedValue;
        final float f6;
        final Function3 function3RememberComposableLambda;
        final Function2 function2RememberComposableLambda;
        final Function2 function2RememberComposableLambda2;
        Composer composer2;
        Object objRememberedValue2;
        final MutableState mutableState;
        boolean z;
        boolean z2;
        boolean zChanged2;
        Object objRememberedValue3;
        final Function1 function1;
        boolean zChanged3;
        Object objRememberedValue4;
        Object objRememberedValue5;
        final float f7;
        final Modifier modifier3;
        final int i9;
        final Shape shape4;
        final long j8;
        final float f8;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(457373461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPageIndicator)P(4,3,2:androidx.wear.compose.material.PageIndicatorStyle,5:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.unit.Dp,6:c#ui.unit.Dp)98@4648L7,99@4698L6,120@5781L173,128@6084L1014,155@7133L173,162@7341L175:HorizontalPageIndicator.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = ((i2 & 8) == 0 ? composerStartRestartGroup.changed(pageIndicatorState) : composerStartRestartGroup.changedInstance(pageIndicatorState) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0) {
                    iM619style2LWCLk = i;
                    int i13 = composerStartRestartGroup.changed(iM619style2LWCLk) ? 256 : 128;
                    i4 |= i13;
                } else {
                    iM619style2LWCLk = i;
                }
                i4 |= i13;
            } else {
                iM619style2LWCLk = i;
            }
            if ((i2 & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    onBackground = j;
                    if (composerStartRestartGroup.changed(onBackground)) {
                        i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i4 |= i11;
                } else {
                    onBackground = j;
                }
                i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i4 |= i11;
            } else {
                onBackground = j;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    j3 = j2;
                    int i14 = composerStartRestartGroup.changed(j3) ? 16384 : 8192;
                    i4 |= i14;
                } else {
                    j3 = j2;
                }
                i4 |= i14;
            } else {
                j3 = j2;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                i4 |= 196608;
                f3 = f;
            } else {
                f3 = f;
                if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changed(f3)) {
                        i6 = 131072;
                    } else {
                        i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i6;
                }
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                        i10 = 8388608;
                    }
                    i4 |= i10;
                } else {
                    shape2 = shape;
                }
                i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                i4 |= i10;
            } else {
                shape2 = shape;
            }
            if ((i4 & 4793491) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i12 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        iM619style2LWCLk = PageIndicatorDefaults.INSTANCE.m619style2LWCLk(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 8) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i4 &= -7169;
                    }
                    j4 = onBackground;
                    if ((i3 & 16) != 0) {
                        j5 = Color.copy-wmQWz5c$default(j4, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i4 &= -57345;
                    } else {
                        j5 = j3;
                    }
                    if (i5 != 0) {
                        f3 = Dp.constructor-impl(6);
                    }
                    if (i7 != 0) {
                        f4 = Dp.constructor-impl(4);
                    } else {
                        f4 = f2;
                    }
                    if ((i3 & 128) != 0) {
                        shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                        i4 &= -29360129;
                    }
                    shape3 = shape2;
                    j6 = j5;
                    j7 = j4;
                    f5 = f3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                    }
                    f4 = f2;
                    f5 = f3;
                    shape3 = shape2;
                    j7 = onBackground;
                    j6 = j3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(457373461, i4, -1, "androidx.wear.compose.material.HorizontalPageIndicator (HorizontalPageIndicator.kt:104)");
                }
                int selectedPage = (int) (pageIndicatorState.getSelectedPage() + pageIndicatorState.getPageOffset());
                final float selectedPage2 = (pageIndicatorState.getSelectedPage() + pageIndicatorState.getPageOffset()) - selectedPage;
                final float f9 = Dp.constructor-impl(f4 / 2);
                final float f10 = Dp.constructor-impl(f5 + f4);
                iMin = Integer.min(PageIndicatorDefaults.INSTANCE.getMaxNumberOfIndicators$compose_material_release(), pageIndicatorState.getPageCount());
                int pageCount = pageIndicatorState.getPageCount();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1114038200, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(pageCount);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new PagesState(pageIndicatorState.getPageCount(), iMin);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final PagesState pagesState = (PagesState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                pagesState.recalculateState(selectedPage, selectedPage2);
                Function3<Integer, Composer, Integer, Unit> function3 = new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$indicatorFactory$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i15, Composer composer3, int i16) {
                        int i17;
                        ComposerKt.sourceInformation(composer3, "C131@6258L834:HorizontalPageIndicator.kt#gj9v0t");
                        if ((i16 & 6) == 0) {
                            i17 = i16 | (composer3.changed(i15) ? 4 : 2);
                        } else {
                            i17 = i16;
                        }
                        if ((i17 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2069325977, i17, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:131)");
                            }
                            Modifier modifier4 = SizeKt.size-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, f9, 0.0f, 2, (Object) null), f5);
                            PagesState pagesState2 = pagesState;
                            Shape shape5 = shape3;
                            long j10 = j6;
                            long j11 = j7;
                            float f11 = selectedPage2;
                            ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier4);
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer composer4 = Updater.constructor-impl(composer3);
                            Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -866105075, "C136@6413L669:HorizontalPageIndicator.kt#gj9v0t");
                            BoxKt.Box(BackgroundKt.background-bw27NRU$default(AlphaKt.alpha(ClipKt.clip(ScaleKt.scale(boxScope.align(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter()), pagesState2.sizeRatio(i15)), shape5), pagesState2.alpha(i15)), ColorKt.lerp-jxsXWHM(j10, j11, pagesState2.calculateSelectedRatio(i15, f11)), (Shape) null, 2, (Object) null), composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                };
                f6 = f5;
                function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2069325977, true, function3, composerStartRestartGroup, 54);
                function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-922620824, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$spacerLeft$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        ComposerKt.sourceInformation(composer3, "C156@7143L157:HorizontalPageIndicator.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-922620824, i15, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:156)");
                            }
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(pagesState.getLeftSpacerSizeRatio() * f10)), f6), composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54);
                function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-853767171, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$spacerRight$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        ComposerKt.sourceInformation(composer3, "C163@7351L159:HorizontalPageIndicator.kt#gj9v0t");
                        if ((i15 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-853767171, i15, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:163)");
                            }
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(pagesState.getSmoothProgress() * f10)), f6), composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54);
                if (PageIndicatorStyle.m623equalsimpl0(iM619style2LWCLk, PageIndicatorStyle.INSTANCE.m628getLinearwm_g0bU())) {
                    composerStartRestartGroup.startReplaceGroup(-173654991);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "173@7597L254");
                    LinearPageIndicator(modifier2, iMin, function3RememberComposableLambda, function2RememberComposableLambda, function2RememberComposableLambda2, composerStartRestartGroup, ((i4 >> 3) & 14) | 28032);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    if (PageIndicatorStyle.m623equalsimpl0(iM619style2LWCLk, PageIndicatorStyle.INSTANCE.m627getCurvedwm_g0bU())) {
                        composer2.startReplaceGroup(-173306241);
                        ComposerKt.sourceInformation(composer2, "182@7934L41,184@8029L270,193@8357L482,208@9011L22,208@9035L270,204@8853L452");
                        ComposerKt.sourceInformationMarkerStart(composer2, -1113969436, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                        objRememberedValue2 = composer2.rememberedValue();
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1113966167, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                        if ((458752 & i4) == 131072) {
                            z = true;
                        } else {
                            z = false;
                        }
                        int i15 = i4;
                        if ((3670016 & i4) == 1048576) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        zChanged2 = z2 | z | composer2.changed(iMin);
                        objRememberedValue3 = composer2.rememberedValue();
                        if (!zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                            objRememberedValue3 = (Function1) new Function1<Density, IntSize>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsSize$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return IntSize.box-impl(m601invokeYEO4UFw((Density) obj));
                                }

                                /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
                                public final long m601invokeYEO4UFw(Density density) {
                                    return IntSizeKt.IntSize(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 + f4)) * iMin), RangesKt.coerceAtLeast(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 * 2))), 0));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        function1 = (Function1) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1113955459, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                        zChanged3 = composer2.changed(function1);
                        objRememberedValue4 = composer2.rememberedValue();
                        if (!zChanged3 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                            objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsOffset$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return IntOffset.box-impl(m600invokeBjo55l4((Density) obj));
                                }

                                /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                                public final long m600invokeBjo55l4(Density density) {
                                    long j10 = ((IntSize) function1.invoke(density)).unbox-impl();
                                    return IntOffsetKt.IntOffset((IntSize.getWidth-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getWidth-impl(j10)) / 2, IntSize.getHeight-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getHeight-impl(j10));
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function2 = (Function1) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1113934991, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                        objRememberedValue5 = composer2.rememberedValue();
                        if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                            objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    m599invokeozmzZPI(((IntSize) obj).unbox-impl());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m599invokeozmzZPI(long j10) {
                                    HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$3(mutableState, j10);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        BoundsLimiterKt.BoundsLimiter(function2, function1, modifier2, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(-1218316761, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxScope boxScope, Composer composer3, int i16) {
                                ComposerKt.sourceInformation(composer3, "C210@9054L237:HorizontalPageIndicator.kt#gj9v0t");
                                if ((i16 & 17) != 16 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1218316761, i16, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:210)");
                                    }
                                    HorizontalPageIndicatorKt.CurvedPageIndicator(iMin, function3RememberComposableLambda, function2RememberComposableLambda, function2RememberComposableLambda2, composer3, 3504);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composer2, 54), composer2, ((i15 << 3) & 896) | 27648, 0);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-171939513);
                        composer2.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f7 = f4;
                modifier3 = modifier2;
                i9 = iM619style2LWCLk;
                shape4 = shape3;
                j8 = j6;
                f8 = f6;
                j9 = j7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                i9 = iM619style2LWCLk;
                j8 = j3;
                f8 = f3;
                long j10 = onBackground;
                f7 = f2;
                shape4 = shape2;
                j9 = j10;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i16) {
                        HorizontalPageIndicatorKt.m598HorizontalPageIndicatorTB1hms(pageIndicatorState, modifier3, i9, j9, j8, f8, f7, shape4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                iM619style2LWCLk = i;
                if (composerStartRestartGroup.changed(iM619style2LWCLk)) {
                }
                i4 |= i13;
            } else {
                iM619style2LWCLk = i;
            }
            i4 |= i13;
        } else {
            iM619style2LWCLk = i;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                onBackground = j;
                if (composerStartRestartGroup.changed(onBackground)) {
                    i11 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i4 |= i11;
            } else {
                onBackground = j;
            }
            i11 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i4 |= i11;
        } else {
            onBackground = j;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i4 |= i14;
            } else {
                j3 = j2;
            }
            i4 |= i14;
        } else {
            j3 = j2;
        }
        i5 = i3 & 32;
        if (i5 != 0) {
            i4 |= 196608;
            f3 = f;
        } else {
            f3 = f;
            if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changed(f3)) {
                    i6 = 131072;
                } else {
                    i6 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i6;
            }
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (composerStartRestartGroup.changed(f2)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        if ((i2 & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                    i10 = 8388608;
                }
                i4 |= i10;
            } else {
                shape2 = shape;
            }
            i10 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            i4 |= i10;
        } else {
            shape2 = shape;
        }
        if ((i4 & 4793491) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    iM619style2LWCLk = PageIndicatorDefaults.INSTANCE.m619style2LWCLk(composerStartRestartGroup, 6);
                }
                if ((i3 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i4 &= -7169;
                }
                j4 = onBackground;
                if ((i3 & 16) != 0) {
                    j5 = Color.copy-wmQWz5c$default(j4, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i4 &= -57345;
                } else {
                    j5 = j3;
                }
                if (i5 != 0) {
                    f3 = Dp.constructor-impl(6);
                }
                if (i7 != 0) {
                    f4 = Dp.constructor-impl(4);
                } else {
                    f4 = f2;
                }
                if ((i3 & 128) != 0) {
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    i4 &= -29360129;
                }
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                f5 = f3;
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    iM619style2LWCLk = PageIndicatorDefaults.INSTANCE.m619style2LWCLk(composerStartRestartGroup, 6);
                }
                if ((i3 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i4 &= -7169;
                }
                j4 = onBackground;
                if ((i3 & 16) != 0) {
                    j5 = Color.copy-wmQWz5c$default(j4, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i4 &= -57345;
                } else {
                    j5 = j3;
                }
                if (i5 != 0) {
                    f3 = Dp.constructor-impl(6);
                }
                if (i7 != 0) {
                    f4 = Dp.constructor-impl(4);
                } else {
                    f4 = f2;
                }
                if ((i3 & 128) != 0) {
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    i4 &= -29360129;
                }
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                f5 = f3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(457373461, i4, -1, "androidx.wear.compose.material.HorizontalPageIndicator (HorizontalPageIndicator.kt:104)");
            }
            int selectedPage3 = (int) (pageIndicatorState.getSelectedPage() + pageIndicatorState.getPageOffset());
            final float selectedPage4 = (pageIndicatorState.getSelectedPage() + pageIndicatorState.getPageOffset()) - selectedPage3;
            final float f11 = Dp.constructor-impl(f4 / 2);
            final float f12 = Dp.constructor-impl(f5 + f4);
            iMin = Integer.min(PageIndicatorDefaults.INSTANCE.getMaxNumberOfIndicators$compose_material_release(), pageIndicatorState.getPageCount());
            int pageCount2 = pageIndicatorState.getPageCount();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1114038200, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(pageCount2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new PagesState(pageIndicatorState.getPageCount(), iMin);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new PagesState(pageIndicatorState.getPageCount(), iMin);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PagesState pagesState2 = (PagesState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            pagesState2.recalculateState(selectedPage3, selectedPage4);
            Function3<Integer, Composer, Integer, Unit> function4 = new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$indicatorFactory$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16, Composer composer3, int i17) {
                    int i18;
                    ComposerKt.sourceInformation(composer3, "C131@6258L834:HorizontalPageIndicator.kt#gj9v0t");
                    if ((i17 & 6) == 0) {
                        i18 = i17 | (composer3.changed(i16) ? 4 : 2);
                    } else {
                        i18 = i17;
                    }
                    if ((i18 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2069325977, i18, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:131)");
                        }
                        Modifier modifier4 = SizeKt.size-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, f11, 0.0f, 2, (Object) null), f5);
                        PagesState pagesState3 = pagesState2;
                        Shape shape5 = shape3;
                        long j11 = j6;
                        long j12 = j7;
                        float f13 = selectedPage4;
                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier4);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composer4 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -866105075, "C136@6413L669:HorizontalPageIndicator.kt#gj9v0t");
                        BoxKt.Box(BackgroundKt.background-bw27NRU$default(AlphaKt.alpha(ClipKt.clip(ScaleKt.scale(boxScope.align(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter()), pagesState3.sizeRatio(i16)), shape5), pagesState3.alpha(i16)), ColorKt.lerp-jxsXWHM(j11, j12, pagesState3.calculateSelectedRatio(i16, f13)), (Shape) null, 2, (Object) null), composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            };
            f6 = f5;
            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2069325977, true, function4, composerStartRestartGroup, 54);
            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-922620824, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$spacerLeft$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i16) {
                    ComposerKt.sourceInformation(composer3, "C156@7143L157:HorizontalPageIndicator.kt#gj9v0t");
                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-922620824, i16, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:156)");
                        }
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(pagesState2.getLeftSpacerSizeRatio() * f12)), f6), composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54);
            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-853767171, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$spacerRight$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i16) {
                    ComposerKt.sourceInformation(composer3, "C163@7351L159:HorizontalPageIndicator.kt#gj9v0t");
                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-853767171, i16, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:163)");
                        }
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(pagesState2.getSmoothProgress() * f12)), f6), composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54);
            if (PageIndicatorStyle.m623equalsimpl0(iM619style2LWCLk, PageIndicatorStyle.INSTANCE.m628getLinearwm_g0bU())) {
                composerStartRestartGroup.startReplaceGroup(-173654991);
                ComposerKt.sourceInformation(composerStartRestartGroup, "173@7597L254");
                LinearPageIndicator(modifier2, iMin, function3RememberComposableLambda, function2RememberComposableLambda, function2RememberComposableLambda2, composerStartRestartGroup, ((i4 >> 3) & 14) | 28032);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (PageIndicatorStyle.m623equalsimpl0(iM619style2LWCLk, PageIndicatorStyle.INSTANCE.m627getCurvedwm_g0bU())) {
                    composer2.startReplaceGroup(-173306241);
                    ComposerKt.sourceInformation(composer2, "182@7934L41,184@8029L270,193@8357L482,208@9011L22,208@9035L270,204@8853L452");
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113969436, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113966167, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    if ((458752 & i4) == 131072) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i16 = i4;
                    if ((3670016 & i4) == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | z | composer2.changed(iMin);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = (Function1) new Function1<Density, IntSize>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsSize$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntSize.box-impl(m601invokeYEO4UFw((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
                            public final long m601invokeYEO4UFw(Density density) {
                                return IntSizeKt.IntSize(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 + f4)) * iMin), RangesKt.coerceAtLeast(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 * 2))), 0));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = (Function1) new Function1<Density, IntSize>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsSize$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntSize.box-impl(m601invokeYEO4UFw((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
                            public final long m601invokeYEO4UFw(Density density) {
                                return IntSizeKt.IntSize(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 + f4)) * iMin), RangesKt.coerceAtLeast(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 * 2))), 0));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113955459, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    zChanged3 = composer2.changed(function1);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsOffset$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntOffset.box-impl(m600invokeBjo55l4((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m600invokeBjo55l4(Density density) {
                                long j11 = ((IntSize) function1.invoke(density)).unbox-impl();
                                return IntOffsetKt.IntOffset((IntSize.getWidth-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getWidth-impl(j11)) / 2, IntSize.getHeight-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getHeight-impl(j11));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsOffset$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntOffset.box-impl(m600invokeBjo55l4((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m600invokeBjo55l4(Density density) {
                                long j11 = ((IntSize) function1.invoke(density)).unbox-impl();
                                return IntOffsetKt.IntOffset((IntSize.getWidth-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getWidth-impl(j11)) / 2, IntSize.getHeight-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getHeight-impl(j11));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function5 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113934991, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m599invokeozmzZPI(((IntSize) obj).unbox-impl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m599invokeozmzZPI(long j11) {
                                HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$3(mutableState, j11);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoundsLimiterKt.BoundsLimiter(function5, function1, modifier2, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(-1218316761, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxScope boxScope, Composer composer3, int i17) {
                            ComposerKt.sourceInformation(composer3, "C210@9054L237:HorizontalPageIndicator.kt#gj9v0t");
                            if ((i17 & 17) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1218316761, i17, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:210)");
                                }
                                HorizontalPageIndicatorKt.CurvedPageIndicator(iMin, function3RememberComposableLambda, function2RememberComposableLambda, function2RememberComposableLambda2, composer3, 3504);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composer2, 54), composer2, ((i16 << 3) & 896) | 27648, 0);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-171939513);
                    composer2.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f7 = f4;
            modifier3 = modifier2;
            i9 = iM619style2LWCLk;
            shape4 = shape3;
            j8 = j6;
            f8 = f6;
            j9 = j7;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    iM619style2LWCLk = PageIndicatorDefaults.INSTANCE.m619style2LWCLk(composerStartRestartGroup, 6);
                }
                if ((i3 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i4 &= -7169;
                }
                j4 = onBackground;
                if ((i3 & 16) != 0) {
                    j5 = Color.copy-wmQWz5c$default(j4, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i4 &= -57345;
                } else {
                    j5 = j3;
                }
                if (i5 != 0) {
                    f3 = Dp.constructor-impl(6);
                }
                if (i7 != 0) {
                    f4 = Dp.constructor-impl(4);
                } else {
                    f4 = f2;
                }
                if ((i3 & 128) != 0) {
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    i4 &= -29360129;
                }
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                f5 = f3;
            } else {
                if (i12 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    iM619style2LWCLk = PageIndicatorDefaults.INSTANCE.m619style2LWCLk(composerStartRestartGroup, 6);
                }
                if ((i3 & 8) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i4 &= -7169;
                }
                j4 = onBackground;
                if ((i3 & 16) != 0) {
                    j5 = Color.copy-wmQWz5c$default(j4, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i4 &= -57345;
                } else {
                    j5 = j3;
                }
                if (i5 != 0) {
                    f3 = Dp.constructor-impl(6);
                }
                if (i7 != 0) {
                    f4 = Dp.constructor-impl(4);
                } else {
                    f4 = f2;
                }
                if ((i3 & 128) != 0) {
                    shape2 = (Shape) RoundedCornerShapeKt.getCircleShape();
                    i4 &= -29360129;
                }
                shape3 = shape2;
                j6 = j5;
                j7 = j4;
                f5 = f3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(457373461, i4, -1, "androidx.wear.compose.material.HorizontalPageIndicator (HorizontalPageIndicator.kt:104)");
            }
            int selectedPage5 = (int) (pageIndicatorState.getSelectedPage() + pageIndicatorState.getPageOffset());
            final float selectedPage6 = (pageIndicatorState.getSelectedPage() + pageIndicatorState.getPageOffset()) - selectedPage5;
            final float f13 = Dp.constructor-impl(f4 / 2);
            final float f14 = Dp.constructor-impl(f5 + f4);
            iMin = Integer.min(PageIndicatorDefaults.INSTANCE.getMaxNumberOfIndicators$compose_material_release(), pageIndicatorState.getPageCount());
            int pageCount3 = pageIndicatorState.getPageCount();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1114038200, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(pageCount3);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new PagesState(pageIndicatorState.getPageCount(), iMin);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new PagesState(pageIndicatorState.getPageCount(), iMin);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final PagesState pagesState3 = (PagesState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            pagesState3.recalculateState(selectedPage5, selectedPage6);
            Function3<Integer, Composer, Integer, Unit> function6 = new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$indicatorFactory$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i17, Composer composer3, int i18) {
                    int i19;
                    ComposerKt.sourceInformation(composer3, "C131@6258L834:HorizontalPageIndicator.kt#gj9v0t");
                    if ((i18 & 6) == 0) {
                        i19 = i18 | (composer3.changed(i17) ? 4 : 2);
                    } else {
                        i19 = i18;
                    }
                    if ((i19 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2069325977, i19, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:131)");
                        }
                        Modifier modifier4 = SizeKt.size-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, f13, 0.0f, 2, (Object) null), f5);
                        PagesState pagesState4 = pagesState3;
                        Shape shape5 = shape3;
                        long j11 = j6;
                        long j12 = j7;
                        float f15 = selectedPage6;
                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifier4);
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer composer4 = Updater.constructor-impl(composer3);
                        Updater.set-impl(composer4, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer4, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (composer4.getInserting() || !Intrinsics.areEqual(composer4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer4.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer4, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -866105075, "C136@6413L669:HorizontalPageIndicator.kt#gj9v0t");
                        BoxKt.Box(BackgroundKt.background-bw27NRU$default(AlphaKt.alpha(ClipKt.clip(ScaleKt.scale(boxScope.align(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter()), pagesState4.sizeRatio(i17)), shape5), pagesState4.alpha(i17)), ColorKt.lerp-jxsXWHM(j11, j12, pagesState4.calculateSelectedRatio(i17, f15)), (Shape) null, 2, (Object) null), composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            };
            f6 = f5;
            function3RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2069325977, true, function6, composerStartRestartGroup, 54);
            function2RememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-922620824, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$spacerLeft$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C156@7143L157:HorizontalPageIndicator.kt#gj9v0t");
                    if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-922620824, i17, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:156)");
                        }
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(pagesState3.getLeftSpacerSizeRatio() * f14)), f6), composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54);
            function2RememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-853767171, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$spacerRight$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C163@7351L159:HorizontalPageIndicator.kt#gj9v0t");
                    if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-853767171, i17, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:163)");
                        }
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(pagesState3.getSmoothProgress() * f14)), f6), composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54);
            if (PageIndicatorStyle.m623equalsimpl0(iM619style2LWCLk, PageIndicatorStyle.INSTANCE.m628getLinearwm_g0bU())) {
                composerStartRestartGroup.startReplaceGroup(-173654991);
                ComposerKt.sourceInformation(composerStartRestartGroup, "173@7597L254");
                LinearPageIndicator(modifier2, iMin, function3RememberComposableLambda, function2RememberComposableLambda, function2RememberComposableLambda2, composerStartRestartGroup, ((i4 >> 3) & 14) | 28032);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (PageIndicatorStyle.m623equalsimpl0(iM619style2LWCLk, PageIndicatorStyle.INSTANCE.m627getCurvedwm_g0bU())) {
                    composer2.startReplaceGroup(-173306241);
                    ComposerKt.sourceInformation(composer2, "182@7934L41,184@8029L270,193@8357L482,208@9011L22,208@9035L270,204@8853L452");
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113969436, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113966167, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    if ((458752 & i4) == 131072) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i17 = i4;
                    if ((3670016 & i4) == 1048576) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zChanged2 = z2 | z | composer2.changed(iMin);
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue3 = (Function1) new Function1<Density, IntSize>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsSize$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntSize.box-impl(m601invokeYEO4UFw((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
                            public final long m601invokeYEO4UFw(Density density) {
                                return IntSizeKt.IntSize(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 + f4)) * iMin), RangesKt.coerceAtLeast(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 * 2))), 0));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = (Function1) new Function1<Density, IntSize>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsSize$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntSize.box-impl(m601invokeYEO4UFw((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
                            public final long m601invokeYEO4UFw(Density density) {
                                return IntSizeKt.IntSize(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 + f4)) * iMin), RangesKt.coerceAtLeast(MathKt.roundToInt(density.toPx-0680j_4(Dp.constructor-impl(f6 * 2))), 0));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113955459, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    zChanged3 = composer2.changed(function1);
                    objRememberedValue4 = composer2.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsOffset$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntOffset.box-impl(m600invokeBjo55l4((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m600invokeBjo55l4(Density density) {
                                long j11 = ((IntSize) function1.invoke(density)).unbox-impl();
                                return IntOffsetKt.IntOffset((IntSize.getWidth-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getWidth-impl(j11)) / 2, IntSize.getHeight-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getHeight-impl(j11));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$boundsOffset$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntOffset.box-impl(m600invokeBjo55l4((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m600invokeBjo55l4(Density density) {
                                long j11 = ((IntSize) function1.invoke(density)).unbox-impl();
                                return IntOffsetKt.IntOffset((IntSize.getWidth-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getWidth-impl(j11)) / 2, IntSize.getHeight-impl(HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$2(mutableState)) - IntSize.getHeight-impl(j11));
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    Function1 function7 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1113934991, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
                    objRememberedValue5 = composer2.rememberedValue();
                    if (objRememberedValue5 == Composer.Companion.getEmpty()) {
                        objRememberedValue5 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m599invokeozmzZPI(((IntSize) obj).unbox-impl());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m599invokeozmzZPI(long j11) {
                                HorizontalPageIndicatorKt.HorizontalPageIndicator_TB1_hms$lambda$3(mutableState, j11);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    BoundsLimiterKt.BoundsLimiter(function7, function1, modifier2, (Function1) objRememberedValue5, ComposableLambdaKt.rememberComposableLambda(-1218316761, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxScope boxScope, Composer composer3, int i18) {
                            ComposerKt.sourceInformation(composer3, "C210@9054L237:HorizontalPageIndicator.kt#gj9v0t");
                            if ((i18 & 17) != 16 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1218316761, i18, -1, "androidx.wear.compose.material.HorizontalPageIndicator.<anonymous> (HorizontalPageIndicator.kt:210)");
                                }
                                HorizontalPageIndicatorKt.CurvedPageIndicator(iMin, function3RememberComposableLambda, function2RememberComposableLambda, function2RememberComposableLambda2, composer3, 3504);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composer2, 54), composer2, ((i17 << 3) & 896) | 27648, 0);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-171939513);
                    composer2.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f7 = f4;
            modifier3 = modifier2;
            i9 = iM619style2LWCLk;
            shape4 = shape3;
            j8 = j6;
            f8 = f6;
            j9 = j7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$HorizontalPageIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i18) {
                    HorizontalPageIndicatorKt.m598HorizontalPageIndicatorTB1hms(pageIndicatorState, modifier3, i9, j9, j8, f8, f7, shape4, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long HorizontalPageIndicator_TB1_hms$lambda$2(MutableState<IntSize> mutableState) {
        return ((IntSize) ((State) mutableState).getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalPageIndicator_TB1_hms$lambda$3(MutableState<IntSize> mutableState, long j) {
        mutableState.setValue(IntSize.box-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LinearPageIndicator(final Modifier modifier, final int i, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1359893031);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LinearPageIndicator)P(1,2)287@11008L451:HorizontalPageIndicator.kt#gj9v0t");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
        }
        if ((i3 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1359893031, i3, -1, "androidx.wear.compose.material.LinearPageIndicator (HorizontalPageIndicator.kt:286)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2100719262, "C288@11057L396:HorizontalPageIndicator.kt#gj9v0t");
            Modifier modifierAlign = boxScope.align(modifier, Alignment.Companion.getBottomCenter());
            Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical bottom = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, bottom, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int i4 = 0;
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2097357635, "C294@11307L12,298@11430L13:HorizontalPageIndicator.kt#gj9v0t");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            composerStartRestartGroup.startReplaceGroup(-1872005203);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*296@11381L22");
            if (i >= 0) {
                while (true) {
                    function3.invoke(Integer.valueOf(i4), composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 112));
                    if (i4 == i) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            composerStartRestartGroup.endReplaceGroup();
            function4.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt.LinearPageIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i5) {
                    HorizontalPageIndicatorKt.LinearPageIndicator(modifier, i, function3, function2, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CurvedPageIndicator(final int i, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1662205270);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CurvedPageIndicator)P(1)315@11880L316,310@11669L527:HorizontalPageIndicator.kt#gj9v0t");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1662205270, i3, -1, "androidx.wear.compose.material.CurvedPageIndicator (HorizontalPageIndicator.kt:309)");
            }
            Modifier modifier = Modifier.Companion;
            int iM293getReversedgmlPZk4 = CurvedDirection.Angular.INSTANCE.m293getReversedgmlPZk4();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1469938022, "CC(remember):HorizontalPageIndicator.kt#9igjgp");
            boolean z = ((i3 & 14) == 4) | ((i3 & 896) == 256) | ((i3 & 112) == 32) | ((i3 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = (Function1) new Function1<CurvedScope, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$CurvedPageIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((CurvedScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(CurvedScope curvedScope) {
                        final Function2<Composer, Integer, Unit> function5 = function2;
                        CurvedComposableKt.m281curvedComposableE6nutXQ$default(curvedScope, null, 0.0f, ComposableLambdaKt.composableLambdaInstance(1744470016, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$CurvedPageIndicator$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxScope boxScope, Composer composer2, int i4) {
                                ComposerKt.sourceInformation(composer2, "C318@11970L12:HorizontalPageIndicator.kt#gj9v0t");
                                if ((i4 & 17) == 16 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1744470016, i4, -1, "androidx.wear.compose.material.CurvedPageIndicator.<anonymous>.<anonymous>.<anonymous> (HorizontalPageIndicator.kt:318)");
                                }
                                function5.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 3, null);
                        if (i >= 0) {
                            final int i4 = 0;
                            while (true) {
                                final Function3<Integer, Composer, Integer, Unit> function6 = function3;
                                CurvedComposableKt.m281curvedComposableE6nutXQ$default(curvedScope, null, 0.0f, ComposableLambdaKt.composableLambdaInstance(-1356814366, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$CurvedPageIndicator$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(BoxScope boxScope, Composer composer2, int i5) {
                                        ComposerKt.sourceInformation(composer2, "C322@12081L22:HorizontalPageIndicator.kt#gj9v0t");
                                        if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1356814366, i5, -1, "androidx.wear.compose.material.CurvedPageIndicator.<anonymous>.<anonymous>.<anonymous> (HorizontalPageIndicator.kt:322)");
                                        }
                                        function6.invoke(Integer.valueOf(i4), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), 3, null);
                                if (i4 == i) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                        }
                        final Function2<Composer, Integer, Unit> function7 = function4;
                        CurvedComposableKt.m281curvedComposableE6nutXQ$default(curvedScope, null, 0.0f, ComposableLambdaKt.composableLambdaInstance(-1031079689, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt$CurvedPageIndicator$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(BoxScope boxScope, Composer composer2, int i5) {
                                ComposerKt.sourceInformation(composer2, "C326@12167L13:HorizontalPageIndicator.kt#gj9v0t");
                                if ((i5 & 17) == 16 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1031079689, i5, -1, "androidx.wear.compose.material.CurvedPageIndicator.<anonymous>.<anonymous>.<anonymous> (HorizontalPageIndicator.kt:326)");
                                }
                                function7.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 3, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier, 90.0f, 0.0f, null, iM293getReversedgmlPZk4, (Function1) objRememberedValue, composerStartRestartGroup, 54, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.HorizontalPageIndicatorKt.CurvedPageIndicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    HorizontalPageIndicatorKt.CurvedPageIndicator(i, function3, function2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }
}
