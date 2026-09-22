package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration;
import androidx.wear.compose.materialcore.FunctionDrawBox;
import androidx.wear.compose.materialcore.FunctionDrawThumb;
import androidx.wear.compose.materialcore.SelectionControlsKt;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ToggleControl.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aW\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00142\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001aQ\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020!2\b\b\u0002\u0010\u0019\u001a\u00020\u00142\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010#2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010$\u001aW\u0010%\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020&2\b\b\u0002\u0010\u0019\u001a\u00020\u00142\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010'\u001a\u001e\u0010(\u001a\u00020\u0012*\u00020)2\u0006\u0010*\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a.\u0010-\u001a\u00020\u0012*\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"BOX_CORNER", "Landroidx/compose/ui/unit/Dp;", "F", "BOX_RADIUS", "BOX_SIZE", "BOX_STROKE", "COLOR_ANIMATION_SPEC", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/graphics/Color;", "HEIGHT", "PROGRESS_ANIMATION_SPEC", "Landroidx/compose/animation/core/TweenSpec;", "", "SWITCH_THUMB_RADIUS", "SWITCH_TRACK_HEIGHT", "SWITCH_TRACK_LENGTH", "WIDTH", "Checkbox", "", "checked", "", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/wear/compose/material/CheckboxColors;", "enabled", "onCheckedChange", "Lkotlin/Function1;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLandroidx/compose/ui/Modifier;Landroidx/wear/compose/material/CheckboxColors;ZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "RadioButton", "selected", "Landroidx/wear/compose/material/RadioButtonColors;", "onClick", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/wear/compose/material/RadioButtonColors;ZLkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Switch", "Landroidx/wear/compose/material/SwitchColors;", "(ZLandroidx/compose/ui/Modifier;Landroidx/wear/compose/material/SwitchColors;ZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "drawBox-4WTKRHQ", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;J)V", "drawThumb", "progress", "isRtl", "drawThumb-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFZ)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ToggleControlKt {
    private static final float BOX_RADIUS;
    private static final float BOX_STROKE;
    private static final float HEIGHT;
    private static final float SWITCH_TRACK_LENGTH;
    private static final float WIDTH;
    private static final float BOX_CORNER = Dp.constructor-impl(3);
    private static final float BOX_SIZE = Dp.constructor-impl(18);
    private static final float SWITCH_TRACK_HEIGHT = Dp.constructor-impl(10);
    private static final float SWITCH_THUMB_RADIUS = Dp.constructor-impl(7);
    private static final AnimationSpec<Color> COLOR_ANIMATION_SPEC = AnimationSpecKt.tween(250, 0, AnimationKt.getSTANDARD_IN());
    private static final TweenSpec<Float> PROGRESS_ANIMATION_SPEC = AnimationSpecKt.tween(250, 0, AnimationKt.getSTANDARD_IN());

    /* JADX INFO: Access modifiers changed from: private */
    public static final int RadioButton$lambda$0(boolean z) {
        if (z) {
            return 250;
        }
        return AnimationKt.RAPID;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:100:0x0129  */
    /* JADX WARN: Code duplicated, block: B:104:0x0136  */
    /* JADX WARN: Code duplicated, block: B:107:0x0194  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:77:0x00da  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x0116  */
    /* JADX WARN: Code duplicated, block: B:92:0x011b  */
    /* JADX WARN: Code duplicated, block: B:93:0x011d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0122  */
    /* JADX WARN: Code duplicated, block: B:97:0x0124  */
    public static final void Checkbox(final boolean z, Modifier modifier, CheckboxColors checkboxColors, boolean z2, Function1<? super Boolean, Unit> function1, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) throws NoWhenBranchMatchedException {
        boolean z3;
        int i3;
        Modifier modifier2;
        CheckboxColors checkboxColors2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        Function1<? super Boolean, Unit> function2;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        Modifier modifier3;
        Composer composer2;
        final CheckboxColors checkboxColorsM531colorsro_MJ88;
        boolean z5;
        Function1<? super Boolean, Unit> function3;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        Function1<? super Boolean, Unit> function4;
        final CheckboxColors checkboxColors3;
        final Modifier modifier4;
        final Function1<? super Boolean, Unit> function5;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-548934211);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Checkbox)P(!1,4!2,5)64@3050L8,90@3882L32,68@3235L681:ToggleControl.kt#gj9v0t");
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
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    checkboxColors2 = checkboxColors;
                    int i12 = composerStartRestartGroup.changed(checkboxColors2) ? 256 : 128;
                    i3 |= i12;
                } else {
                    checkboxColors2 = checkboxColors;
                }
                i3 |= i12;
            } else {
                checkboxColors2 = checkboxColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function2 = function1;
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
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
                        if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if ((i2 & 4) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                    i3 &= -897;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                                }
                                if (i4 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                if (i6 != 0) {
                                    function3 = null;
                                } else {
                                    function3 = function1;
                                }
                                mutableInteractionSource3 = i8 == 0 ? mutableInteractionSource : null;
                                i10 = i3;
                                function4 = function3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                i10 = i3;
                                modifier3 = modifier2;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                                z5 = z4;
                                function4 = function2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                composer2 = composerStartRestartGroup;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                            }
                            AnonymousClass1 anonymousClass1 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                                @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                                /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                                public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f, boolean z7) {
                                    ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                                }
                            };
                            int i13 = i10;
                            TweenSpec<Float> tweenSpec = PROGRESS_ANIMATION_SPEC;
                            Composer composer3 = composer2;
                            float f = WIDTH;
                            float f2 = HEIGHT;
                            Indication indicationM745rippleOrFallbackImplementation9IZ8Weo = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer3, 0, 7);
                            int i14 = (i13 & 14) | 918552576 | (i13 & 112);
                            int i15 = i13 << 3;
                            Function1<? super Boolean, Unit> function6 = function4;
                            Modifier modifier5 = modifier3;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            boolean z7 = z5;
                            SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier5, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer4, int i16) {
                                    composer4.startReplaceGroup(466974542);
                                    ComposerKt.sourceInformation(composer4, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(466974542, i16, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                    }
                                    State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z8, z9, composer4, i16 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer4.endReplaceGroup();
                                    return stateBoxColor;
                                }
                            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer4, int i16) {
                                    composer4.startReplaceGroup(-494650673);
                                    ComposerKt.sourceInformation(composer4, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-494650673, i16, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                    }
                                    State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z8, z9, composer4, i16 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer4.endReplaceGroup();
                                    return stateCheckmarkColor;
                                }
                            }, z7, function6, mutableInteractionSource5, tweenSpec, anonymousClass1, f, f2, indicationM745rippleOrFallbackImplementation9IZ8Weo, composer3, i14 | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 6, 0);
                            z4 = z7;
                            composerStartRestartGroup = composer3;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                            modifier4 = modifier5;
                            function5 = function6;
                            mutableInteractionSource4 = mutableInteractionSource5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            checkboxColors3 = checkboxColors2;
                            function5 = function2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        z6 = z4;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                                public final void invoke(Composer composer4, int i16) throws NoWhenBranchMatchedException {
                                    ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass2 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f3, boolean z8) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i16 = i10;
                        TweenSpec<Float> tweenSpec2 = PROGRESS_ANIMATION_SPEC;
                        Composer composer4 = composer2;
                        float f3 = WIDTH;
                        float f4 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo2 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer4, 0, 7);
                        int i17 = (i16 & 14) | 918552576 | (i16 & 112);
                        int i18 = i16 << 3;
                        Function1<? super Boolean, Unit> function7 = function4;
                        Modifier modifier6 = modifier3;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                        boolean z8 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier6, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer5, int i19) {
                                composer5.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer5, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i19, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z9, z10, composer5, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer5.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer5, int i19) {
                                composer5.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer5, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i19, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z9, z10, composer5, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer5.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z8, function7, mutableInteractionSource6, tweenSpec2, anonymousClass2, f3, f4, indicationM745rippleOrFallbackImplementation9IZ8Weo2, composer4, i17 | (57344 & i18) | (458752 & i18) | (i18 & 3670016), 6, 0);
                        z4 = z8;
                        composerStartRestartGroup = composer4;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier6;
                        function5 = function7;
                        mutableInteractionSource4 = mutableInteractionSource6;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass3 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f5, boolean z9) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i19 = i10;
                        TweenSpec<Float> tweenSpec3 = PROGRESS_ANIMATION_SPEC;
                        Composer composer5 = composer2;
                        float f5 = WIDTH;
                        float f6 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo3 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer5, 0, 7);
                        int i110 = (i19 & 14) | 918552576 | (i19 & 112);
                        int i111 = i19 << 3;
                        Function1<? super Boolean, Unit> function8 = function4;
                        Modifier modifier7 = modifier3;
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                        boolean z9 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier7, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer6, int i112) {
                                composer6.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer6, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i112, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z10, z11, composer6, i112 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer6.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer6, int i112) {
                                composer6.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer6, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i112, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z10, z11, composer6, i112 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer6.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z9, function8, mutableInteractionSource7, tweenSpec3, anonymousClass3, f5, f6, indicationM745rippleOrFallbackImplementation9IZ8Weo3, composer5, i110 | (57344 & i111) | (458752 & i111) | (i111 & 3670016), 6, 0);
                        z4 = z9;
                        composerStartRestartGroup = composer5;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier7;
                        function5 = function8;
                        mutableInteractionSource4 = mutableInteractionSource7;
                    }
                    z6 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer6, int i112) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer6, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function2 = function1;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass4 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f7, boolean z10) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i112 = i10;
                        TweenSpec<Float> tweenSpec4 = PROGRESS_ANIMATION_SPEC;
                        Composer composer6 = composer2;
                        float f7 = WIDTH;
                        float f8 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo4 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer6, 0, 7);
                        int i113 = (i112 & 14) | 918552576 | (i112 & 112);
                        int i114 = i112 << 3;
                        Function1<? super Boolean, Unit> function9 = function4;
                        Modifier modifier8 = modifier3;
                        MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                        boolean z10 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier8, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer7, int i115) {
                                composer7.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer7, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i115, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z11, z12, composer7, i115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer7.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer7, int i115) {
                                composer7.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer7, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i115, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z11, z12, composer7, i115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer7.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z10, function9, mutableInteractionSource8, tweenSpec4, anonymousClass4, f7, f8, indicationM745rippleOrFallbackImplementation9IZ8Weo4, composer6, i113 | (57344 & i114) | (458752 & i114) | (i114 & 3670016), 6, 0);
                        z4 = z10;
                        composerStartRestartGroup = composer6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier8;
                        function5 = function9;
                        mutableInteractionSource4 = mutableInteractionSource8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass5 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f9, boolean z11) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i115 = i10;
                        TweenSpec<Float> tweenSpec5 = PROGRESS_ANIMATION_SPEC;
                        Composer composer7 = composer2;
                        float f9 = WIDTH;
                        float f10 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo5 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer7, 0, 7);
                        int i116 = (i115 & 14) | 918552576 | (i115 & 112);
                        int i117 = i115 << 3;
                        Function1<? super Boolean, Unit> function10 = function4;
                        Modifier modifier9 = modifier3;
                        MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                        boolean z11 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier9, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer8, int i118) {
                                composer8.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer8, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i118, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z12, z13, composer8, i118 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer8.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer8, int i118) {
                                composer8.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer8, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i118, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z12, z13, composer8, i118 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer8.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z11, function10, mutableInteractionSource9, tweenSpec5, anonymousClass5, f9, f10, indicationM745rippleOrFallbackImplementation9IZ8Weo5, composer7, i116 | (57344 & i117) | (458752 & i117) | (i117 & 3670016), 6, 0);
                        z4 = z11;
                        composerStartRestartGroup = composer7;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier9;
                        function5 = function10;
                        mutableInteractionSource4 = mutableInteractionSource9;
                    }
                    z6 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer8, int i118) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer8, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass6 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f11, boolean z12) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i118 = i10;
                    TweenSpec<Float> tweenSpec6 = PROGRESS_ANIMATION_SPEC;
                    Composer composer8 = composer2;
                    float f11 = WIDTH;
                    float f12 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo6 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer8, 0, 7);
                    int i119 = (i118 & 14) | 918552576 | (i118 & 112);
                    int i1110 = i118 << 3;
                    Function1<? super Boolean, Unit> function11 = function4;
                    Modifier modifier10 = modifier3;
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                    boolean z12 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier10, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer9, int i1111) {
                            composer9.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer9, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i1111, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z13, z14, composer9, i1111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer9.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer9, int i1111) {
                            composer9.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer9, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i1111, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z13, z14, composer9, i1111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer9.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z12, function11, mutableInteractionSource10, tweenSpec6, anonymousClass6, f11, f12, indicationM745rippleOrFallbackImplementation9IZ8Weo6, composer8, i119 | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016), 6, 0);
                    z4 = z12;
                    composerStartRestartGroup = composer8;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier10;
                    function5 = function11;
                    mutableInteractionSource4 = mutableInteractionSource10;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass7 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f13, boolean z13) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i1111 = i10;
                    TweenSpec<Float> tweenSpec7 = PROGRESS_ANIMATION_SPEC;
                    Composer composer9 = composer2;
                    float f13 = WIDTH;
                    float f14 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo7 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer9, 0, 7);
                    int i1112 = (i1111 & 14) | 918552576 | (i1111 & 112);
                    int i1113 = i1111 << 3;
                    Function1<? super Boolean, Unit> function12 = function4;
                    Modifier modifier11 = modifier3;
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
                    boolean z13 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier11, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer10, int i1114) {
                            composer10.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer10, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i1114, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z14, z15, composer10, i1114 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer10.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer10, int i1114) {
                            composer10.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer10, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i1114, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z14, z15, composer10, i1114 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer10.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z13, function12, mutableInteractionSource11, tweenSpec7, anonymousClass7, f13, f14, indicationM745rippleOrFallbackImplementation9IZ8Weo7, composer9, i1112 | (57344 & i1113) | (458752 & i1113) | (i1113 & 3670016), 6, 0);
                    z4 = z13;
                    composerStartRestartGroup = composer9;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier11;
                    function5 = function12;
                    mutableInteractionSource4 = mutableInteractionSource11;
                }
                z6 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer10, int i1114) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer10, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass8 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f15, boolean z14) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i1114 = i10;
                        TweenSpec<Float> tweenSpec8 = PROGRESS_ANIMATION_SPEC;
                        Composer composer10 = composer2;
                        float f15 = WIDTH;
                        float f16 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo8 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer10, 0, 7);
                        int i1115 = (i1114 & 14) | 918552576 | (i1114 & 112);
                        int i1116 = i1114 << 3;
                        Function1<? super Boolean, Unit> function13 = function4;
                        Modifier modifier12 = modifier3;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
                        boolean z14 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier12, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer11, int i1117) {
                                composer11.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer11, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i1117, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z15, z16, composer11, i1117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer11.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer11, int i1117) {
                                composer11.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer11, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i1117, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z15, z16, composer11, i1117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer11.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z14, function13, mutableInteractionSource12, tweenSpec8, anonymousClass8, f15, f16, indicationM745rippleOrFallbackImplementation9IZ8Weo8, composer10, i1115 | (57344 & i1116) | (458752 & i1116) | (i1116 & 3670016), 6, 0);
                        z4 = z14;
                        composerStartRestartGroup = composer10;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier12;
                        function5 = function13;
                        mutableInteractionSource4 = mutableInteractionSource12;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass9 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f17, boolean z15) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i1117 = i10;
                        TweenSpec<Float> tweenSpec9 = PROGRESS_ANIMATION_SPEC;
                        Composer composer11 = composer2;
                        float f17 = WIDTH;
                        float f18 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo9 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer11, 0, 7);
                        int i1118 = (i1117 & 14) | 918552576 | (i1117 & 112);
                        int i1119 = i1117 << 3;
                        Function1<? super Boolean, Unit> function14 = function4;
                        Modifier modifier13 = modifier3;
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource3;
                        boolean z15 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier13, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer12, int i11110) {
                                composer12.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer12, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i11110, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z16, z17, composer12, i11110 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer12.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer12, int i11110) {
                                composer12.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer12, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i11110, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z16, z17, composer12, i11110 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer12.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z15, function14, mutableInteractionSource13, tweenSpec9, anonymousClass9, f17, f18, indicationM745rippleOrFallbackImplementation9IZ8Weo9, composer11, i1118 | (57344 & i1119) | (458752 & i1119) | (i1119 & 3670016), 6, 0);
                        z4 = z15;
                        composerStartRestartGroup = composer11;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier13;
                        function5 = function14;
                        mutableInteractionSource4 = mutableInteractionSource13;
                    }
                    z6 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer12, int i11110) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer12, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass10 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f19, boolean z16) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i11110 = i10;
                    TweenSpec<Float> tweenSpec10 = PROGRESS_ANIMATION_SPEC;
                    Composer composer12 = composer2;
                    float f19 = WIDTH;
                    float f110 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo10 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer12, 0, 7);
                    int i11111 = (i11110 & 14) | 918552576 | (i11110 & 112);
                    int i11112 = i11110 << 3;
                    Function1<? super Boolean, Unit> function15 = function4;
                    Modifier modifier14 = modifier3;
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource3;
                    boolean z16 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier14, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer13, int i11113) {
                            composer13.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer13, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i11113, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z17, z18, composer13, i11113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer13.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer13, int i11113) {
                            composer13.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer13, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i11113, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z17, z18, composer13, i11113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer13.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z16, function15, mutableInteractionSource14, tweenSpec10, anonymousClass10, f19, f110, indicationM745rippleOrFallbackImplementation9IZ8Weo10, composer12, i11111 | (57344 & i11112) | (458752 & i11112) | (i11112 & 3670016), 6, 0);
                    z4 = z16;
                    composerStartRestartGroup = composer12;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier14;
                    function5 = function15;
                    mutableInteractionSource4 = mutableInteractionSource14;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass11 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f111, boolean z17) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i11113 = i10;
                    TweenSpec<Float> tweenSpec11 = PROGRESS_ANIMATION_SPEC;
                    Composer composer13 = composer2;
                    float f111 = WIDTH;
                    float f112 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo11 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer13, 0, 7);
                    int i11114 = (i11113 & 14) | 918552576 | (i11113 & 112);
                    int i11115 = i11113 << 3;
                    Function1<? super Boolean, Unit> function16 = function4;
                    Modifier modifier15 = modifier3;
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource3;
                    boolean z17 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier15, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer14, int i11116) {
                            composer14.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer14, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i11116, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z18, z19, composer14, i11116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer14.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer14, int i11116) {
                            composer14.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer14, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i11116, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z18, z19, composer14, i11116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer14.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z17, function16, mutableInteractionSource15, tweenSpec11, anonymousClass11, f111, f112, indicationM745rippleOrFallbackImplementation9IZ8Weo11, composer13, i11114 | (57344 & i11115) | (458752 & i11115) | (i11115 & 3670016), 6, 0);
                    z4 = z17;
                    composerStartRestartGroup = composer13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier15;
                    function5 = function16;
                    mutableInteractionSource4 = mutableInteractionSource15;
                }
                z6 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer14, int i11116) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer14, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass12 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f113, boolean z18) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i11116 = i10;
                    TweenSpec<Float> tweenSpec12 = PROGRESS_ANIMATION_SPEC;
                    Composer composer14 = composer2;
                    float f113 = WIDTH;
                    float f114 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo12 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer14, 0, 7);
                    int i11117 = (i11116 & 14) | 918552576 | (i11116 & 112);
                    int i11118 = i11116 << 3;
                    Function1<? super Boolean, Unit> function17 = function4;
                    Modifier modifier16 = modifier3;
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource3;
                    boolean z18 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier16, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer15, int i11119) {
                            composer15.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer15, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i11119, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z19, z110, composer15, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer15.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer15, int i11119) {
                            composer15.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer15, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i11119, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z19, z110, composer15, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer15.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z18, function17, mutableInteractionSource16, tweenSpec12, anonymousClass12, f113, f114, indicationM745rippleOrFallbackImplementation9IZ8Weo12, composer14, i11117 | (57344 & i11118) | (458752 & i11118) | (i11118 & 3670016), 6, 0);
                    z4 = z18;
                    composerStartRestartGroup = composer14;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier16;
                    function5 = function17;
                    mutableInteractionSource4 = mutableInteractionSource16;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass13 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f115, boolean z19) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i11119 = i10;
                    TweenSpec<Float> tweenSpec13 = PROGRESS_ANIMATION_SPEC;
                    Composer composer15 = composer2;
                    float f115 = WIDTH;
                    float f116 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo13 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer15, 0, 7);
                    int i111110 = (i11119 & 14) | 918552576 | (i11119 & 112);
                    int i111111 = i11119 << 3;
                    Function1<? super Boolean, Unit> function18 = function4;
                    Modifier modifier17 = modifier3;
                    MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource3;
                    boolean z19 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier17, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer16, int i111112) {
                            composer16.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer16, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i111112, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z110, z111, composer16, i111112 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer16.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer16, int i111112) {
                            composer16.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer16, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i111112, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z110, z111, composer16, i111112 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer16.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z19, function18, mutableInteractionSource17, tweenSpec13, anonymousClass13, f115, f116, indicationM745rippleOrFallbackImplementation9IZ8Weo13, composer15, i111110 | (57344 & i111111) | (458752 & i111111) | (i111111 & 3670016), 6, 0);
                    z4 = z19;
                    composerStartRestartGroup = composer15;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier17;
                    function5 = function18;
                    mutableInteractionSource4 = mutableInteractionSource17;
                }
                z6 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer16, int i111112) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer16, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass14 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f117, boolean z110) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i111112 = i10;
                TweenSpec<Float> tweenSpec14 = PROGRESS_ANIMATION_SPEC;
                Composer composer16 = composer2;
                float f117 = WIDTH;
                float f118 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo14 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer16, 0, 7);
                int i111113 = (i111112 & 14) | 918552576 | (i111112 & 112);
                int i111114 = i111112 << 3;
                Function1<? super Boolean, Unit> function19 = function4;
                Modifier modifier18 = modifier3;
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource3;
                boolean z110 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier18, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer17, int i111115) {
                        composer17.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer17, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i111115, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z111, z112, composer17, i111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer17.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer17, int i111115) {
                        composer17.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer17, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i111115, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z111, z112, composer17, i111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer17.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z110, function19, mutableInteractionSource18, tweenSpec14, anonymousClass14, f117, f118, indicationM745rippleOrFallbackImplementation9IZ8Weo14, composer16, i111113 | (57344 & i111114) | (458752 & i111114) | (i111114 & 3670016), 6, 0);
                z4 = z110;
                composerStartRestartGroup = composer16;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier18;
                function5 = function19;
                mutableInteractionSource4 = mutableInteractionSource18;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass15 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f119, boolean z111) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i111115 = i10;
                TweenSpec<Float> tweenSpec15 = PROGRESS_ANIMATION_SPEC;
                Composer composer17 = composer2;
                float f119 = WIDTH;
                float f1110 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo15 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer17, 0, 7);
                int i111116 = (i111115 & 14) | 918552576 | (i111115 & 112);
                int i111117 = i111115 << 3;
                Function1<? super Boolean, Unit> function110 = function4;
                Modifier modifier19 = modifier3;
                MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource3;
                boolean z111 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier19, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer18, int i111118) {
                        composer18.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer18, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i111118, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z112, z113, composer18, i111118 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer18.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer18, int i111118) {
                        composer18.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer18, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i111118, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z112, z113, composer18, i111118 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer18.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z111, function110, mutableInteractionSource19, tweenSpec15, anonymousClass15, f119, f1110, indicationM745rippleOrFallbackImplementation9IZ8Weo15, composer17, i111116 | (57344 & i111117) | (458752 & i111117) | (i111117 & 3670016), 6, 0);
                z4 = z111;
                composerStartRestartGroup = composer17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier19;
                function5 = function110;
                mutableInteractionSource4 = mutableInteractionSource19;
            }
            z6 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer18, int i111118) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer18, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                checkboxColors2 = checkboxColors;
                if (composerStartRestartGroup.changed(checkboxColors2)) {
                }
                i3 |= i12;
            } else {
                checkboxColors2 = checkboxColors;
            }
            i3 |= i12;
        } else {
            checkboxColors2 = checkboxColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass16 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f1111, boolean z112) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i111118 = i10;
                        TweenSpec<Float> tweenSpec16 = PROGRESS_ANIMATION_SPEC;
                        Composer composer18 = composer2;
                        float f1111 = WIDTH;
                        float f1112 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo16 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer18, 0, 7);
                        int i111119 = (i111118 & 14) | 918552576 | (i111118 & 112);
                        int i1111110 = i111118 << 3;
                        Function1<? super Boolean, Unit> function111 = function4;
                        Modifier modifier110 = modifier3;
                        MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource3;
                        boolean z112 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer19, int i1111111) {
                                composer19.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer19, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i1111111, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z113, z114, composer19, i1111111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer19.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer19, int i1111111) {
                                composer19.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer19, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i1111111, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z113, z114, composer19, i1111111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer19.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z112, function111, mutableInteractionSource110, tweenSpec16, anonymousClass16, f1111, f1112, indicationM745rippleOrFallbackImplementation9IZ8Weo16, composer18, i111119 | (57344 & i1111110) | (458752 & i1111110) | (i1111110 & 3670016), 6, 0);
                        z4 = z112;
                        composerStartRestartGroup = composer18;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier110;
                        function5 = function111;
                        mutableInteractionSource4 = mutableInteractionSource110;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                        }
                        AnonymousClass1 anonymousClass17 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                            @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                            /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                            public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f1113, boolean z113) {
                                ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                            }
                        };
                        int i1111111 = i10;
                        TweenSpec<Float> tweenSpec17 = PROGRESS_ANIMATION_SPEC;
                        Composer composer19 = composer2;
                        float f1113 = WIDTH;
                        float f1114 = HEIGHT;
                        Indication indicationM745rippleOrFallbackImplementation9IZ8Weo17 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer19, 0, 7);
                        int i1111112 = (i1111111 & 14) | 918552576 | (i1111111 & 112);
                        int i1111113 = i1111111 << 3;
                        Function1<? super Boolean, Unit> function112 = function4;
                        Modifier modifier111 = modifier3;
                        MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource3;
                        boolean z113 = z5;
                        SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer110, int i1111114) {
                                composer110.startReplaceGroup(466974542);
                                ComposerKt.sourceInformation(composer110, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(466974542, i1111114, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                                }
                                State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z114, z115, composer110, i1111114 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer110.endReplaceGroup();
                                return stateBoxColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer110, int i1111114) {
                                composer110.startReplaceGroup(-494650673);
                                ComposerKt.sourceInformation(composer110, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-494650673, i1111114, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                                }
                                State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z114, z115, composer110, i1111114 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer110.endReplaceGroup();
                                return stateCheckmarkColor;
                            }
                        }, z113, function112, mutableInteractionSource111, tweenSpec17, anonymousClass17, f1113, f1114, indicationM745rippleOrFallbackImplementation9IZ8Weo17, composer19, i1111112 | (57344 & i1111113) | (458752 & i1111113) | (i1111113 & 3670016), 6, 0);
                        z4 = z113;
                        composerStartRestartGroup = composer19;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                        modifier4 = modifier111;
                        function5 = function112;
                        mutableInteractionSource4 = mutableInteractionSource111;
                    }
                    z6 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer110, int i1111114) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer110, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass18 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f1115, boolean z114) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i1111114 = i10;
                    TweenSpec<Float> tweenSpec18 = PROGRESS_ANIMATION_SPEC;
                    Composer composer110 = composer2;
                    float f1115 = WIDTH;
                    float f1116 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo18 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer110, 0, 7);
                    int i1111115 = (i1111114 & 14) | 918552576 | (i1111114 & 112);
                    int i1111116 = i1111114 << 3;
                    Function1<? super Boolean, Unit> function113 = function4;
                    Modifier modifier112 = modifier3;
                    MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource3;
                    boolean z114 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer111, int i1111117) {
                            composer111.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer111, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i1111117, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z115, z116, composer111, i1111117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer111.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer111, int i1111117) {
                            composer111.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer111, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i1111117, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z115, z116, composer111, i1111117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer111.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z114, function113, mutableInteractionSource112, tweenSpec18, anonymousClass18, f1115, f1116, indicationM745rippleOrFallbackImplementation9IZ8Weo18, composer110, i1111115 | (57344 & i1111116) | (458752 & i1111116) | (i1111116 & 3670016), 6, 0);
                    z4 = z114;
                    composerStartRestartGroup = composer110;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier112;
                    function5 = function113;
                    mutableInteractionSource4 = mutableInteractionSource112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass19 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f1117, boolean z115) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i1111117 = i10;
                    TweenSpec<Float> tweenSpec19 = PROGRESS_ANIMATION_SPEC;
                    Composer composer111 = composer2;
                    float f1117 = WIDTH;
                    float f1118 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo19 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer111, 0, 7);
                    int i1111118 = (i1111117 & 14) | 918552576 | (i1111117 & 112);
                    int i1111119 = i1111117 << 3;
                    Function1<? super Boolean, Unit> function114 = function4;
                    Modifier modifier113 = modifier3;
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource3;
                    boolean z115 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier113, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer112, int i11111110) {
                            composer112.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer112, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i11111110, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z116, z117, composer112, i11111110 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer112.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer112, int i11111110) {
                            composer112.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer112, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i11111110, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z116, z117, composer112, i11111110 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer112.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z115, function114, mutableInteractionSource113, tweenSpec19, anonymousClass19, f1117, f1118, indicationM745rippleOrFallbackImplementation9IZ8Weo19, composer111, i1111118 | (57344 & i1111119) | (458752 & i1111119) | (i1111119 & 3670016), 6, 0);
                    z4 = z115;
                    composerStartRestartGroup = composer111;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier113;
                    function5 = function114;
                    mutableInteractionSource4 = mutableInteractionSource113;
                }
                z6 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer112, int i11111110) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer112, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass110 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f1119, boolean z116) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i11111110 = i10;
                    TweenSpec<Float> tweenSpec110 = PROGRESS_ANIMATION_SPEC;
                    Composer composer112 = composer2;
                    float f1119 = WIDTH;
                    float f11110 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo110 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer112, 0, 7);
                    int i11111111 = (i11111110 & 14) | 918552576 | (i11111110 & 112);
                    int i11111112 = i11111110 << 3;
                    Function1<? super Boolean, Unit> function115 = function4;
                    Modifier modifier114 = modifier3;
                    MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource3;
                    boolean z116 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier114, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer113, int i11111113) {
                            composer113.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer113, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i11111113, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z117, z118, composer113, i11111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer113.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer113, int i11111113) {
                            composer113.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer113, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i11111113, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z117, z118, composer113, i11111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer113.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z116, function115, mutableInteractionSource114, tweenSpec110, anonymousClass110, f1119, f11110, indicationM745rippleOrFallbackImplementation9IZ8Weo110, composer112, i11111111 | (57344 & i11111112) | (458752 & i11111112) | (i11111112 & 3670016), 6, 0);
                    z4 = z116;
                    composerStartRestartGroup = composer112;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier114;
                    function5 = function115;
                    mutableInteractionSource4 = mutableInteractionSource114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass111 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f11111, boolean z117) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i11111113 = i10;
                    TweenSpec<Float> tweenSpec111 = PROGRESS_ANIMATION_SPEC;
                    Composer composer113 = composer2;
                    float f11111 = WIDTH;
                    float f11112 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo111 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer113, 0, 7);
                    int i11111114 = (i11111113 & 14) | 918552576 | (i11111113 & 112);
                    int i11111115 = i11111113 << 3;
                    Function1<? super Boolean, Unit> function116 = function4;
                    Modifier modifier115 = modifier3;
                    MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource3;
                    boolean z117 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier115, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer114, int i11111116) {
                            composer114.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer114, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i11111116, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z118, z119, composer114, i11111116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer114.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer114, int i11111116) {
                            composer114.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer114, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i11111116, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z118, z119, composer114, i11111116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer114.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z117, function116, mutableInteractionSource115, tweenSpec111, anonymousClass111, f11111, f11112, indicationM745rippleOrFallbackImplementation9IZ8Weo111, composer113, i11111114 | (57344 & i11111115) | (458752 & i11111115) | (i11111115 & 3670016), 6, 0);
                    z4 = z117;
                    composerStartRestartGroup = composer113;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier115;
                    function5 = function116;
                    mutableInteractionSource4 = mutableInteractionSource115;
                }
                z6 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer114, int i11111116) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer114, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass112 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f11113, boolean z118) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i11111116 = i10;
                TweenSpec<Float> tweenSpec112 = PROGRESS_ANIMATION_SPEC;
                Composer composer114 = composer2;
                float f11113 = WIDTH;
                float f11114 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo112 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer114, 0, 7);
                int i11111117 = (i11111116 & 14) | 918552576 | (i11111116 & 112);
                int i11111118 = i11111116 << 3;
                Function1<? super Boolean, Unit> function117 = function4;
                Modifier modifier116 = modifier3;
                MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource3;
                boolean z118 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier116, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer115, int i11111119) {
                        composer115.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer115, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i11111119, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z119, z1110, composer115, i11111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer115.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer115, int i11111119) {
                        composer115.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer115, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i11111119, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z119, z1110, composer115, i11111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer115.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z118, function117, mutableInteractionSource116, tweenSpec112, anonymousClass112, f11113, f11114, indicationM745rippleOrFallbackImplementation9IZ8Weo112, composer114, i11111117 | (57344 & i11111118) | (458752 & i11111118) | (i11111118 & 3670016), 6, 0);
                z4 = z118;
                composerStartRestartGroup = composer114;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier116;
                function5 = function117;
                mutableInteractionSource4 = mutableInteractionSource116;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass113 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f11115, boolean z119) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i11111119 = i10;
                TweenSpec<Float> tweenSpec113 = PROGRESS_ANIMATION_SPEC;
                Composer composer115 = composer2;
                float f11115 = WIDTH;
                float f11116 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo113 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer115, 0, 7);
                int i111111110 = (i11111119 & 14) | 918552576 | (i11111119 & 112);
                int i111111111 = i11111119 << 3;
                Function1<? super Boolean, Unit> function118 = function4;
                Modifier modifier117 = modifier3;
                MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource3;
                boolean z119 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier117, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer116, int i111111112) {
                        composer116.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer116, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i111111112, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1110, z1111, composer116, i111111112 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer116.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer116, int i111111112) {
                        composer116.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer116, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i111111112, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1110, z1111, composer116, i111111112 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer116.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z119, function118, mutableInteractionSource117, tweenSpec113, anonymousClass113, f11115, f11116, indicationM745rippleOrFallbackImplementation9IZ8Weo113, composer115, i111111110 | (57344 & i111111111) | (458752 & i111111111) | (i111111111 & 3670016), 6, 0);
                z4 = z119;
                composerStartRestartGroup = composer115;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier117;
                function5 = function118;
                mutableInteractionSource4 = mutableInteractionSource117;
            }
            z6 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer116, int i111111112) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer116, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass114 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f11117, boolean z1110) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i111111112 = i10;
                    TweenSpec<Float> tweenSpec114 = PROGRESS_ANIMATION_SPEC;
                    Composer composer116 = composer2;
                    float f11117 = WIDTH;
                    float f11118 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo114 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer116, 0, 7);
                    int i111111113 = (i111111112 & 14) | 918552576 | (i111111112 & 112);
                    int i111111114 = i111111112 << 3;
                    Function1<? super Boolean, Unit> function119 = function4;
                    Modifier modifier118 = modifier3;
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource3;
                    boolean z1110 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier118, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer117, int i111111115) {
                            composer117.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer117, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i111111115, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1111, z1112, composer117, i111111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer117.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer117, int i111111115) {
                            composer117.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer117, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i111111115, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1111, z1112, composer117, i111111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer117.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z1110, function119, mutableInteractionSource118, tweenSpec114, anonymousClass114, f11117, f11118, indicationM745rippleOrFallbackImplementation9IZ8Weo114, composer116, i111111113 | (57344 & i111111114) | (458752 & i111111114) | (i111111114 & 3670016), 6, 0);
                    z4 = z1110;
                    composerStartRestartGroup = composer116;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier118;
                    function5 = function119;
                    mutableInteractionSource4 = mutableInteractionSource118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                    }
                    AnonymousClass1 anonymousClass115 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                        @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                        /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                        public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f11119, boolean z1111) {
                            ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                        }
                    };
                    int i111111115 = i10;
                    TweenSpec<Float> tweenSpec115 = PROGRESS_ANIMATION_SPEC;
                    Composer composer117 = composer2;
                    float f11119 = WIDTH;
                    float f111110 = HEIGHT;
                    Indication indicationM745rippleOrFallbackImplementation9IZ8Weo115 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer117, 0, 7);
                    int i111111116 = (i111111115 & 14) | 918552576 | (i111111115 & 112);
                    int i111111117 = i111111115 << 3;
                    Function1<? super Boolean, Unit> function1110 = function4;
                    Modifier modifier119 = modifier3;
                    MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource3;
                    boolean z1111 = z5;
                    SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier119, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer118, int i111111118) {
                            composer118.startReplaceGroup(466974542);
                            ComposerKt.sourceInformation(composer118, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(466974542, i111111118, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                            }
                            State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1112, z1113, composer118, i111111118 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer118.endReplaceGroup();
                            return stateBoxColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer118, int i111111118) {
                            composer118.startReplaceGroup(-494650673);
                            ComposerKt.sourceInformation(composer118, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-494650673, i111111118, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                            }
                            State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1112, z1113, composer118, i111111118 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer118.endReplaceGroup();
                            return stateCheckmarkColor;
                        }
                    }, z1111, function1110, mutableInteractionSource119, tweenSpec115, anonymousClass115, f11119, f111110, indicationM745rippleOrFallbackImplementation9IZ8Weo115, composer117, i111111116 | (57344 & i111111117) | (458752 & i111111117) | (i111111117 & 3670016), 6, 0);
                    z4 = z1111;
                    composerStartRestartGroup = composer117;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                    modifier4 = modifier119;
                    function5 = function1110;
                    mutableInteractionSource4 = mutableInteractionSource119;
                }
                z6 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer118, int i111111118) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer118, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass116 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f111111, boolean z1112) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i111111118 = i10;
                TweenSpec<Float> tweenSpec116 = PROGRESS_ANIMATION_SPEC;
                Composer composer118 = composer2;
                float f111111 = WIDTH;
                float f111112 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo116 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer118, 0, 7);
                int i111111119 = (i111111118 & 14) | 918552576 | (i111111118 & 112);
                int i1111111110 = i111111118 << 3;
                Function1<? super Boolean, Unit> function1111 = function4;
                Modifier modifier1110 = modifier3;
                MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource3;
                boolean z1112 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier1110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer119, int i1111111111) {
                        composer119.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer119, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i1111111111, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1113, z1114, composer119, i1111111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer119.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer119, int i1111111111) {
                        composer119.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer119, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i1111111111, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1113, z1114, composer119, i1111111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer119.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z1112, function1111, mutableInteractionSource1110, tweenSpec116, anonymousClass116, f111111, f111112, indicationM745rippleOrFallbackImplementation9IZ8Weo116, composer118, i111111119 | (57344 & i1111111110) | (458752 & i1111111110) | (i1111111110 & 3670016), 6, 0);
                z4 = z1112;
                composerStartRestartGroup = composer118;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier1110;
                function5 = function1111;
                mutableInteractionSource4 = mutableInteractionSource1110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass117 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f111113, boolean z1113) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i1111111111 = i10;
                TweenSpec<Float> tweenSpec117 = PROGRESS_ANIMATION_SPEC;
                Composer composer119 = composer2;
                float f111113 = WIDTH;
                float f111114 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo117 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer119, 0, 7);
                int i1111111112 = (i1111111111 & 14) | 918552576 | (i1111111111 & 112);
                int i1111111113 = i1111111111 << 3;
                Function1<? super Boolean, Unit> function1112 = function4;
                Modifier modifier1111 = modifier3;
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource3;
                boolean z1113 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier1111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer1110, int i1111111114) {
                        composer1110.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer1110, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i1111111114, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1114, z1115, composer1110, i1111111114 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1110.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer1110, int i1111111114) {
                        composer1110.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer1110, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i1111111114, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1114, z1115, composer1110, i1111111114 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1110.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z1113, function1112, mutableInteractionSource1111, tweenSpec117, anonymousClass117, f111113, f111114, indicationM745rippleOrFallbackImplementation9IZ8Weo117, composer119, i1111111112 | (57344 & i1111111113) | (458752 & i1111111113) | (i1111111113 & 3670016), 6, 0);
                z4 = z1113;
                composerStartRestartGroup = composer119;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier1111;
                function5 = function1112;
                mutableInteractionSource4 = mutableInteractionSource1111;
            }
            z6 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer1110, int i1111111114) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer1110, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function1;
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
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass118 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f111115, boolean z1114) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i1111111114 = i10;
                TweenSpec<Float> tweenSpec118 = PROGRESS_ANIMATION_SPEC;
                Composer composer1110 = composer2;
                float f111115 = WIDTH;
                float f111116 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo118 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer1110, 0, 7);
                int i1111111115 = (i1111111114 & 14) | 918552576 | (i1111111114 & 112);
                int i1111111116 = i1111111114 << 3;
                Function1<? super Boolean, Unit> function1113 = function4;
                Modifier modifier1112 = modifier3;
                MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource3;
                boolean z1114 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier1112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer1111, int i1111111117) {
                        composer1111.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer1111, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i1111111117, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1115, z1116, composer1111, i1111111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1111.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer1111, int i1111111117) {
                        composer1111.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer1111, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i1111111117, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1115, z1116, composer1111, i1111111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1111.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z1114, function1113, mutableInteractionSource1112, tweenSpec118, anonymousClass118, f111115, f111116, indicationM745rippleOrFallbackImplementation9IZ8Weo118, composer1110, i1111111115 | (57344 & i1111111116) | (458752 & i1111111116) | (i1111111116 & 3670016), 6, 0);
                z4 = z1114;
                composerStartRestartGroup = composer1110;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier1112;
                function5 = function1113;
                mutableInteractionSource4 = mutableInteractionSource1112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
                }
                AnonymousClass1 anonymousClass119 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                    @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                    /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                    public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f111117, boolean z1115) {
                        ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                    }
                };
                int i1111111117 = i10;
                TweenSpec<Float> tweenSpec119 = PROGRESS_ANIMATION_SPEC;
                Composer composer1111 = composer2;
                float f111117 = WIDTH;
                float f111118 = HEIGHT;
                Indication indicationM745rippleOrFallbackImplementation9IZ8Weo119 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer1111, 0, 7);
                int i1111111118 = (i1111111117 & 14) | 918552576 | (i1111111117 & 112);
                int i1111111119 = i1111111117 << 3;
                Function1<? super Boolean, Unit> function1114 = function4;
                Modifier modifier1113 = modifier3;
                MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource3;
                boolean z1115 = z5;
                SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier1113, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer1112, int i11111111110) {
                        composer1112.startReplaceGroup(466974542);
                        ComposerKt.sourceInformation(composer1112, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466974542, i11111111110, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                        }
                        State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1116, z1117, composer1112, i11111111110 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1112.endReplaceGroup();
                        return stateBoxColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer1112, int i11111111110) {
                        composer1112.startReplaceGroup(-494650673);
                        ComposerKt.sourceInformation(composer1112, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-494650673, i11111111110, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                        }
                        State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1116, z1117, composer1112, i11111111110 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1112.endReplaceGroup();
                        return stateCheckmarkColor;
                    }
                }, z1115, function1114, mutableInteractionSource1113, tweenSpec119, anonymousClass119, f111117, f111118, indicationM745rippleOrFallbackImplementation9IZ8Weo119, composer1111, i1111111118 | (57344 & i1111111119) | (458752 & i1111111119) | (i1111111119 & 3670016), 6, 0);
                z4 = z1115;
                composerStartRestartGroup = composer1111;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                checkboxColors3 = checkboxColorsM531colorsro_MJ88;
                modifier4 = modifier1113;
                function5 = function1114;
                mutableInteractionSource4 = mutableInteractionSource1113;
            }
            z6 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer1112, int i11111111110) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer1112, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
            }
            AnonymousClass1 anonymousClass1110 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f111119, boolean z1116) {
                    ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                }
            };
            int i11111111110 = i10;
            TweenSpec<Float> tweenSpec1110 = PROGRESS_ANIMATION_SPEC;
            Composer composer1112 = composer2;
            float f111119 = WIDTH;
            float f1111110 = HEIGHT;
            Indication indicationM745rippleOrFallbackImplementation9IZ8Weo1110 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer1112, 0, 7);
            int i11111111111 = (i11111111110 & 14) | 918552576 | (i11111111110 & 112);
            int i11111111112 = i11111111110 << 3;
            Function1<? super Boolean, Unit> function1115 = function4;
            Modifier modifier1114 = modifier3;
            MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource3;
            boolean z1116 = z5;
            SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier1114, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer1113, int i11111111113) {
                    composer1113.startReplaceGroup(466974542);
                    ComposerKt.sourceInformation(composer1113, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(466974542, i11111111113, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                    }
                    State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1117, z1118, composer1113, i11111111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1113.endReplaceGroup();
                    return stateBoxColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer1113, int i11111111113) {
                    composer1113.startReplaceGroup(-494650673);
                    ComposerKt.sourceInformation(composer1113, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-494650673, i11111111113, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                    }
                    State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1117, z1118, composer1113, i11111111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1113.endReplaceGroup();
                    return stateCheckmarkColor;
                }
            }, z1116, function1115, mutableInteractionSource1114, tweenSpec1110, anonymousClass1110, f111119, f1111110, indicationM745rippleOrFallbackImplementation9IZ8Weo1110, composer1112, i11111111111 | (57344 & i11111111112) | (458752 & i11111111112) | (i11111111112 & 3670016), 6, 0);
            z4 = z1116;
            composerStartRestartGroup = composer1112;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors3 = checkboxColorsM531colorsro_MJ88;
            modifier4 = modifier1114;
            function5 = function1115;
            mutableInteractionSource4 = mutableInteractionSource1114;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = CheckboxDefaults.INSTANCE.m531colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    checkboxColorsM531colorsro_MJ88 = checkboxColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-548934211, i10, -1, "androidx.wear.compose.material.Checkbox (ToggleControl.kt:68)");
            }
            AnonymousClass1 anonymousClass1111 = new FunctionDrawBox() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.1
                @Override // androidx.wear.compose.materialcore.FunctionDrawBox
                /* JADX INFO: renamed from: invoke-RPmYEkk, reason: not valid java name */
                public final void mo866invokeRPmYEkk(DrawScope drawScope, long j, float f1111111, boolean z1117) {
                    ToggleControlKt.m864drawBox4WTKRHQ(drawScope, j);
                }
            };
            int i11111111113 = i10;
            TweenSpec<Float> tweenSpec1111 = PROGRESS_ANIMATION_SPEC;
            Composer composer1113 = composer2;
            float f1111111 = WIDTH;
            float f1111112 = HEIGHT;
            Indication indicationM745rippleOrFallbackImplementation9IZ8Weo1111 = RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer1113, 0, 7);
            int i11111111114 = (i11111111113 & 14) | 918552576 | (i11111111113 & 112);
            int i11111111115 = i11111111113 << 3;
            Function1<? super Boolean, Unit> function1116 = function4;
            Modifier modifier1115 = modifier3;
            MutableInteractionSource mutableInteractionSource1115 = mutableInteractionSource3;
            boolean z1117 = z5;
            SelectionControlsKt.m916Checkboxw41Enmo(z3, modifier1115, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer1114, int i11111111116) {
                    composer1114.startReplaceGroup(466974542);
                    ComposerKt.sourceInformation(composer1114, "CP(1)72@3349L84:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(466974542, i11111111116, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:72)");
                    }
                    State<Color> stateBoxColor = checkboxColorsM531colorsro_MJ88.boxColor(z1118, z1119, composer1114, i11111111116 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1114.endReplaceGroup();
                    return stateBoxColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.3
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer1114, int i11111111116) {
                    composer1114.startReplaceGroup(-494650673);
                    ComposerKt.sourceInformation(composer1114, "CP(1)78@3503L90:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-494650673, i11111111116, -1, "androidx.wear.compose.material.Checkbox.<anonymous> (ToggleControl.kt:78)");
                    }
                    State<Color> stateCheckmarkColor = checkboxColorsM531colorsro_MJ88.checkmarkColor(z1118, z1119, composer1114, i11111111116 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1114.endReplaceGroup();
                    return stateCheckmarkColor;
                }
            }, z1117, function1116, mutableInteractionSource1115, tweenSpec1111, anonymousClass1111, f1111111, f1111112, indicationM745rippleOrFallbackImplementation9IZ8Weo1111, composer1113, i11111111114 | (57344 & i11111111115) | (458752 & i11111111115) | (i11111111115 & 3670016), 6, 0);
            z4 = z1117;
            composerStartRestartGroup = composer1113;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            checkboxColors3 = checkboxColorsM531colorsro_MJ88;
            modifier4 = modifier1115;
            function5 = function1116;
            mutableInteractionSource4 = mutableInteractionSource1115;
        }
        z6 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Checkbox.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final void invoke(Composer composer1114, int i11111111116) throws NoWhenBranchMatchedException {
                    ToggleControlKt.Checkbox(z, modifier4, checkboxColors3, z6, function5, mutableInteractionSource4, composer1114, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:103:0x013a  */
    /* JADX WARN: Code duplicated, block: B:106:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:89:0x011a  */
    /* JADX WARN: Code duplicated, block: B:91:0x011f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0121  */
    /* JADX WARN: Code duplicated, block: B:95:0x0126  */
    /* JADX WARN: Code duplicated, block: B:96:0x0128  */
    /* JADX WARN: Code duplicated, block: B:99:0x012d  */
    public static final void Switch(final boolean z, Modifier modifier, SwitchColors switchColors, boolean z2, Function1<? super Boolean, Unit> function1, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) throws NoWhenBranchMatchedException {
        boolean z3;
        int i3;
        Modifier modifier2;
        SwitchColors switchColors2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        Function1<? super Boolean, Unit> function2;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        Modifier modifier3;
        Composer composer2;
        final SwitchColors switchColorsM841colorsro_MJ88;
        boolean z5;
        Function1<? super Boolean, Unit> function3;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        Function1<? super Boolean, Unit> function4;
        final SwitchColors switchColors3;
        final Modifier modifier4;
        final boolean z6;
        final Function1<? super Boolean, Unit> function5;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2004492389);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Switch)P(!1,4!2,5)118@5287L8,160@6582L32,122@5472L1144:ToggleControl.kt#gj9v0t");
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
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    switchColors2 = switchColors;
                    int i12 = composerStartRestartGroup.changed(switchColors2) ? 256 : 128;
                    i3 |= i12;
                } else {
                    switchColors2 = switchColors;
                }
                i3 |= i12;
            } else {
                switchColors2 = switchColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function2 = function1;
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
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
                        if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if ((i2 & 4) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                    i3 &= -897;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    switchColorsM841colorsro_MJ88 = switchColors2;
                                }
                                if (i4 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                if (i6 != 0) {
                                    function3 = null;
                                } else {
                                    function3 = function1;
                                }
                                mutableInteractionSource3 = i8 == 0 ? mutableInteractionSource : null;
                                i10 = i3;
                                function4 = function3;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                i10 = i3;
                                modifier3 = modifier2;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                                z5 = z4;
                                function4 = function2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                composer2 = composerStartRestartGroup;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                            }
                            int i13 = i10;
                            int i14 = i13 >> 3;
                            Function1<? super Boolean, Unit> function6 = function4;
                            boolean z7 = z5;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            Modifier modifier5 = modifier3;
                            SelectionControlsKt.m918SwitchZ7GKWWo(modifier5, z3, z7, function6, mutableInteractionSource5, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer3, int i15) {
                                    composer3.startReplaceGroup(861972192);
                                    ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(861972192, i15, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                    }
                                    State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z8, z9, composer3, i15 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return stateTrackColor;
                                }
                            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer3, int i15) {
                                    composer3.startReplaceGroup(-951820511);
                                    ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-951820511, i15, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                    }
                                    State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z8, z9, composer3, i15 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return stateTrackColor;
                                }
                            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer3, int i15) {
                                    composer3.startReplaceGroup(1529354082);
                                    ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1529354082, i15, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                    }
                                    State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z8, z9, composer3, i15 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return stateThumbColor;
                                }
                            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer3, int i15) {
                                    composer3.startReplaceGroup(-284438621);
                                    ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-284438621, i15, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                    }
                                    State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z8, z9, composer3, i15 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer3.endReplaceGroup();
                                    return stateThumbColor;
                                }
                            }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                                @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                                /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                                public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z8) {
                                    ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z8);
                                }
                            }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i14 & 57344) | (i14 & 14) | 805306368 | ((i13 << 3) & 112) | (i14 & 896) | (i14 & 7168), 28086);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            switchColors3 = switchColorsM841colorsro_MJ88;
                            modifier4 = modifier5;
                            z6 = z7;
                            function5 = function6;
                            mutableInteractionSource4 = mutableInteractionSource5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            switchColors3 = switchColors2;
                            z6 = z4;
                            function5 = function2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = composerStartRestartGroup;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                                public final void invoke(Composer composer3, int i15) throws NoWhenBranchMatchedException {
                                    ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i15 = i10;
                        int i16 = i15 >> 3;
                        Function1<? super Boolean, Unit> function7 = function4;
                        boolean z8 = z5;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                        Modifier modifier6 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier6, z3, z8, function7, mutableInteractionSource6, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer3, int i17) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i17, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z9, z10, composer3, i17 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer3, int i17) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i17, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z9, z10, composer3, i17 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer3, int i17) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i17, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z9, z10, composer3, i17 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer3, int i17) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i17, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z9, z10, composer3, i17 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z9) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z9);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i16 & 57344) | (i16 & 14) | 805306368 | ((i15 << 3) & 112) | (i16 & 896) | (i16 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier6;
                        z6 = z8;
                        function5 = function7;
                        mutableInteractionSource4 = mutableInteractionSource6;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i17 = i10;
                        int i18 = i17 >> 3;
                        Function1<? super Boolean, Unit> function8 = function4;
                        boolean z9 = z5;
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                        Modifier modifier7 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier7, z3, z9, function8, mutableInteractionSource7, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer3, int i19) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i19, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z10, z11, composer3, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer3, int i19) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i19, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z10, z11, composer3, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer3, int i19) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i19, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z10, z11, composer3, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer3, int i19) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i19, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z10, z11, composer3, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z10) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z10);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i18 & 57344) | (i18 & 14) | 805306368 | ((i17 << 3) & 112) | (i18 & 896) | (i18 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier7;
                        z6 = z9;
                        function5 = function8;
                        mutableInteractionSource4 = mutableInteractionSource7;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer3, int i19) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function2 = function1;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i19 = i10;
                        int i110 = i19 >> 3;
                        Function1<? super Boolean, Unit> function9 = function4;
                        boolean z10 = z5;
                        MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                        Modifier modifier8 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier8, z3, z10, function9, mutableInteractionSource8, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer3, int i111) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z11, z12, composer3, i111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer3, int i111) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z11, z12, composer3, i111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer3, int i111) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z11, z12, composer3, i111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer3, int i111) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z11, z12, composer3, i111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z11) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z11);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i110 & 57344) | (i110 & 14) | 805306368 | ((i19 << 3) & 112) | (i110 & 896) | (i110 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier8;
                        z6 = z10;
                        function5 = function9;
                        mutableInteractionSource4 = mutableInteractionSource8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i111 = i10;
                        int i112 = i111 >> 3;
                        Function1<? super Boolean, Unit> function10 = function4;
                        boolean z11 = z5;
                        MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                        Modifier modifier9 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier9, z3, z11, function10, mutableInteractionSource9, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer3, int i113) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z12, z13, composer3, i113 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer3, int i113) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z12, z13, composer3, i113 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer3, int i113) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z12, z13, composer3, i113 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer3, int i113) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z12, z13, composer3, i113 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z12) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z12);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i112 & 57344) | (i112 & 14) | 805306368 | ((i111 << 3) & 112) | (i112 & 896) | (i112 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier9;
                        z6 = z11;
                        function5 = function10;
                        mutableInteractionSource4 = mutableInteractionSource9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer3, int i113) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i113 = i10;
                    int i114 = i113 >> 3;
                    Function1<? super Boolean, Unit> function11 = function4;
                    boolean z12 = z5;
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                    Modifier modifier10 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier10, z3, z12, function11, mutableInteractionSource10, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer3, int i115) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z13, z14, composer3, i115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer3, int i115) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z13, z14, composer3, i115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer3, int i115) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z13, z14, composer3, i115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer3, int i115) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z13, z14, composer3, i115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z13) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z13);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i114 & 57344) | (i114 & 14) | 805306368 | ((i113 << 3) & 112) | (i114 & 896) | (i114 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier10;
                    z6 = z12;
                    function5 = function11;
                    mutableInteractionSource4 = mutableInteractionSource10;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i115 = i10;
                    int i116 = i115 >> 3;
                    Function1<? super Boolean, Unit> function12 = function4;
                    boolean z13 = z5;
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
                    Modifier modifier11 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier11, z3, z13, function12, mutableInteractionSource11, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer3, int i117) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z14, z15, composer3, i117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer3, int i117) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z14, z15, composer3, i117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer3, int i117) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z14, z15, composer3, i117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer3, int i117) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z14, z15, composer3, i117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z14) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z14);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i116 & 57344) | (i116 & 14) | 805306368 | ((i115 << 3) & 112) | (i116 & 896) | (i116 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier11;
                    z6 = z13;
                    function5 = function12;
                    mutableInteractionSource4 = mutableInteractionSource11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer3, int i117) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i117 = i10;
                        int i118 = i117 >> 3;
                        Function1<? super Boolean, Unit> function13 = function4;
                        boolean z14 = z5;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
                        Modifier modifier12 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier12, z3, z14, function13, mutableInteractionSource12, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer3, int i119) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z15, z16, composer3, i119 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer3, int i119) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z15, z16, composer3, i119 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer3, int i119) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z15, z16, composer3, i119 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer3, int i119) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z15, z16, composer3, i119 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z15) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z15);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i118 & 57344) | (i118 & 14) | 805306368 | ((i117 << 3) & 112) | (i118 & 896) | (i118 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier12;
                        z6 = z14;
                        function5 = function13;
                        mutableInteractionSource4 = mutableInteractionSource12;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i119 = i10;
                        int i1110 = i119 >> 3;
                        Function1<? super Boolean, Unit> function14 = function4;
                        boolean z15 = z5;
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource3;
                        Modifier modifier13 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier13, z3, z15, function14, mutableInteractionSource13, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer3, int i1111) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i1111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z16, z17, composer3, i1111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer3, int i1111) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i1111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z16, z17, composer3, i1111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer3, int i1111) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i1111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z16, z17, composer3, i1111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer3, int i1111) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i1111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z16, z17, composer3, i1111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z16) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z16);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1110 & 57344) | (i1110 & 14) | 805306368 | ((i119 << 3) & 112) | (i1110 & 896) | (i1110 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier13;
                        z6 = z15;
                        function5 = function14;
                        mutableInteractionSource4 = mutableInteractionSource13;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer3, int i1111) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i1111 = i10;
                    int i1112 = i1111 >> 3;
                    Function1<? super Boolean, Unit> function15 = function4;
                    boolean z16 = z5;
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource3;
                    Modifier modifier14 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier14, z3, z16, function15, mutableInteractionSource14, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer3, int i1113) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i1113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z17, z18, composer3, i1113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer3, int i1113) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i1113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z17, z18, composer3, i1113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer3, int i1113) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i1113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z17, z18, composer3, i1113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer3, int i1113) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i1113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z17, z18, composer3, i1113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z17) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z17);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1112 & 57344) | (i1112 & 14) | 805306368 | ((i1111 << 3) & 112) | (i1112 & 896) | (i1112 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier14;
                    z6 = z16;
                    function5 = function15;
                    mutableInteractionSource4 = mutableInteractionSource14;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i1113 = i10;
                    int i1114 = i1113 >> 3;
                    Function1<? super Boolean, Unit> function16 = function4;
                    boolean z17 = z5;
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource3;
                    Modifier modifier15 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier15, z3, z17, function16, mutableInteractionSource15, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer3, int i1115) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i1115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z18, z19, composer3, i1115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer3, int i1115) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i1115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z18, z19, composer3, i1115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer3, int i1115) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i1115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z18, z19, composer3, i1115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer3, int i1115) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i1115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z18, z19, composer3, i1115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z18) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z18);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1114 & 57344) | (i1114 & 14) | 805306368 | ((i1113 << 3) & 112) | (i1114 & 896) | (i1114 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier15;
                    z6 = z17;
                    function5 = function16;
                    mutableInteractionSource4 = mutableInteractionSource15;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer3, int i1115) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i1115 = i10;
                    int i1116 = i1115 >> 3;
                    Function1<? super Boolean, Unit> function17 = function4;
                    boolean z18 = z5;
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource3;
                    Modifier modifier16 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier16, z3, z18, function17, mutableInteractionSource16, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer3, int i1117) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i1117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z19, z110, composer3, i1117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer3, int i1117) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i1117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z19, z110, composer3, i1117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer3, int i1117) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i1117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z19, z110, composer3, i1117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer3, int i1117) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i1117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z19, z110, composer3, i1117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z19) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z19);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1116 & 57344) | (i1116 & 14) | 805306368 | ((i1115 << 3) & 112) | (i1116 & 896) | (i1116 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier16;
                    z6 = z18;
                    function5 = function17;
                    mutableInteractionSource4 = mutableInteractionSource16;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i1117 = i10;
                    int i1118 = i1117 >> 3;
                    Function1<? super Boolean, Unit> function18 = function4;
                    boolean z19 = z5;
                    MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource3;
                    Modifier modifier17 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier17, z3, z19, function18, mutableInteractionSource17, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer3, int i1119) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i1119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z110, z111, composer3, i1119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer3, int i1119) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i1119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z110, z111, composer3, i1119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer3, int i1119) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i1119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z110, z111, composer3, i1119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer3, int i1119) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i1119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z110, z111, composer3, i1119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z110) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z110);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1118 & 57344) | (i1118 & 14) | 805306368 | ((i1117 << 3) & 112) | (i1118 & 896) | (i1118 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier17;
                    z6 = z19;
                    function5 = function18;
                    mutableInteractionSource4 = mutableInteractionSource17;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer3, int i1119) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i1119 = i10;
                int i11110 = i1119 >> 3;
                Function1<? super Boolean, Unit> function19 = function4;
                boolean z110 = z5;
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource3;
                Modifier modifier18 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier18, z3, z110, function19, mutableInteractionSource18, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer3, int i11111) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i11111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z111, z112, composer3, i11111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer3, int i11111) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i11111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z111, z112, composer3, i11111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer3, int i11111) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i11111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z111, z112, composer3, i11111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer3, int i11111) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i11111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z111, z112, composer3, i11111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z111) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z111);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11110 & 57344) | (i11110 & 14) | 805306368 | ((i1119 << 3) & 112) | (i11110 & 896) | (i11110 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier18;
                z6 = z110;
                function5 = function19;
                mutableInteractionSource4 = mutableInteractionSource18;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i11111 = i10;
                int i11112 = i11111 >> 3;
                Function1<? super Boolean, Unit> function110 = function4;
                boolean z111 = z5;
                MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource3;
                Modifier modifier19 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier19, z3, z111, function110, mutableInteractionSource19, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer3, int i11113) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i11113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z112, z113, composer3, i11113 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer3, int i11113) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i11113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z112, z113, composer3, i11113 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer3, int i11113) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i11113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z112, z113, composer3, i11113 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer3, int i11113) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i11113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z112, z113, composer3, i11113 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z112) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z112);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11112 & 57344) | (i11112 & 14) | 805306368 | ((i11111 << 3) & 112) | (i11112 & 896) | (i11112 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier19;
                z6 = z111;
                function5 = function110;
                mutableInteractionSource4 = mutableInteractionSource19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer3, int i11113) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                switchColors2 = switchColors;
                if (composerStartRestartGroup.changed(switchColors2)) {
                }
                i3 |= i12;
            } else {
                switchColors2 = switchColors;
            }
            i3 |= i12;
        } else {
            switchColors2 = switchColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i11113 = i10;
                        int i11114 = i11113 >> 3;
                        Function1<? super Boolean, Unit> function111 = function4;
                        boolean z112 = z5;
                        MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource3;
                        Modifier modifier110 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier110, z3, z112, function111, mutableInteractionSource110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer3, int i11115) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i11115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z113, z114, composer3, i11115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer3, int i11115) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i11115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z113, z114, composer3, i11115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer3, int i11115) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i11115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z113, z114, composer3, i11115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer3, int i11115) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i11115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z113, z114, composer3, i11115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z113) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z113);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11114 & 57344) | (i11114 & 14) | 805306368 | ((i11113 << 3) & 112) | (i11114 & 896) | (i11114 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier110;
                        z6 = z112;
                        function5 = function111;
                        mutableInteractionSource4 = mutableInteractionSource110;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                switchColorsM841colorsro_MJ88 = switchColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function3 = null;
                            } else {
                                function3 = function1;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function4 = function3;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                        }
                        int i11115 = i10;
                        int i11116 = i11115 >> 3;
                        Function1<? super Boolean, Unit> function112 = function4;
                        boolean z113 = z5;
                        MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource3;
                        Modifier modifier111 = modifier3;
                        SelectionControlsKt.m918SwitchZ7GKWWo(modifier111, z3, z113, function112, mutableInteractionSource111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer3, int i11117) {
                                composer3.startReplaceGroup(861972192);
                                ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(861972192, i11117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z114, z115, composer3, i11117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer3, int i11117) {
                                composer3.startReplaceGroup(-951820511);
                                ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951820511, i11117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                                }
                                State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z114, z115, composer3, i11117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateTrackColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer3, int i11117) {
                                composer3.startReplaceGroup(1529354082);
                                ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1529354082, i11117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z114, z115, composer3, i11117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer3, int i11117) {
                                composer3.startReplaceGroup(-284438621);
                                ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-284438621, i11117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                                }
                                State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z114, z115, composer3, i11117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceGroup();
                                return stateThumbColor;
                            }
                        }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                            @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                            /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                            public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z114) {
                                ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z114);
                            }
                        }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11116 & 57344) | (i11116 & 14) | 805306368 | ((i11115 << 3) & 112) | (i11116 & 896) | (i11116 & 7168), 28086);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        switchColors3 = switchColorsM841colorsro_MJ88;
                        modifier4 = modifier111;
                        z6 = z113;
                        function5 = function112;
                        mutableInteractionSource4 = mutableInteractionSource111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer3, int i11117) throws NoWhenBranchMatchedException {
                                ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i11117 = i10;
                    int i11118 = i11117 >> 3;
                    Function1<? super Boolean, Unit> function113 = function4;
                    boolean z114 = z5;
                    MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource3;
                    Modifier modifier112 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier112, z3, z114, function113, mutableInteractionSource112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer3, int i11119) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i11119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z115, z116, composer3, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer3, int i11119) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i11119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z115, z116, composer3, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer3, int i11119) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i11119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z115, z116, composer3, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer3, int i11119) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i11119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z115, z116, composer3, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z115) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z115);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11118 & 57344) | (i11118 & 14) | 805306368 | ((i11117 << 3) & 112) | (i11118 & 896) | (i11118 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier112;
                    z6 = z114;
                    function5 = function113;
                    mutableInteractionSource4 = mutableInteractionSource112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i11119 = i10;
                    int i111110 = i11119 >> 3;
                    Function1<? super Boolean, Unit> function114 = function4;
                    boolean z115 = z5;
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource3;
                    Modifier modifier113 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier113, z3, z115, function114, mutableInteractionSource113, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer3, int i111111) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z116, z117, composer3, i111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer3, int i111111) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z116, z117, composer3, i111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer3, int i111111) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z116, z117, composer3, i111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer3, int i111111) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z116, z117, composer3, i111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z116) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z116);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i111110 & 57344) | (i111110 & 14) | 805306368 | ((i11119 << 3) & 112) | (i111110 & 896) | (i111110 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier113;
                    z6 = z115;
                    function5 = function114;
                    mutableInteractionSource4 = mutableInteractionSource113;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer3, int i111111) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function2 = function1;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i111111 = i10;
                    int i111112 = i111111 >> 3;
                    Function1<? super Boolean, Unit> function115 = function4;
                    boolean z116 = z5;
                    MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource3;
                    Modifier modifier114 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier114, z3, z116, function115, mutableInteractionSource114, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer3, int i111113) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z117, z118, composer3, i111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer3, int i111113) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z117, z118, composer3, i111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer3, int i111113) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z117, z118, composer3, i111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer3, int i111113) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z117, z118, composer3, i111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z117) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z117);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i111112 & 57344) | (i111112 & 14) | 805306368 | ((i111111 << 3) & 112) | (i111112 & 896) | (i111112 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier114;
                    z6 = z116;
                    function5 = function115;
                    mutableInteractionSource4 = mutableInteractionSource114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i111113 = i10;
                    int i111114 = i111113 >> 3;
                    Function1<? super Boolean, Unit> function116 = function4;
                    boolean z117 = z5;
                    MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource3;
                    Modifier modifier115 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier115, z3, z117, function116, mutableInteractionSource115, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer3, int i111115) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z118, z119, composer3, i111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer3, int i111115) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z118, z119, composer3, i111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer3, int i111115) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z118, z119, composer3, i111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer3, int i111115) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z118, z119, composer3, i111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z118) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z118);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i111114 & 57344) | (i111114 & 14) | 805306368 | ((i111113 << 3) & 112) | (i111114 & 896) | (i111114 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier115;
                    z6 = z117;
                    function5 = function116;
                    mutableInteractionSource4 = mutableInteractionSource115;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer3, int i111115) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i111115 = i10;
                int i111116 = i111115 >> 3;
                Function1<? super Boolean, Unit> function117 = function4;
                boolean z118 = z5;
                MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource3;
                Modifier modifier116 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier116, z3, z118, function117, mutableInteractionSource116, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer3, int i111117) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z119, z1110, composer3, i111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer3, int i111117) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z119, z1110, composer3, i111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer3, int i111117) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z119, z1110, composer3, i111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer3, int i111117) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z119, z1110, composer3, i111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z119) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z119);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i111116 & 57344) | (i111116 & 14) | 805306368 | ((i111115 << 3) & 112) | (i111116 & 896) | (i111116 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier116;
                z6 = z118;
                function5 = function117;
                mutableInteractionSource4 = mutableInteractionSource116;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i111117 = i10;
                int i111118 = i111117 >> 3;
                Function1<? super Boolean, Unit> function118 = function4;
                boolean z119 = z5;
                MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource3;
                Modifier modifier117 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier117, z3, z119, function118, mutableInteractionSource117, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer3, int i111119) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1110, z1111, composer3, i111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer3, int i111119) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1110, z1111, composer3, i111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer3, int i111119) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1110, z1111, composer3, i111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer3, int i111119) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1110, z1111, composer3, i111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1110) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1110);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i111118 & 57344) | (i111118 & 14) | 805306368 | ((i111117 << 3) & 112) | (i111118 & 896) | (i111118 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier117;
                z6 = z119;
                function5 = function118;
                mutableInteractionSource4 = mutableInteractionSource117;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer3, int i111119) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i111119 = i10;
                    int i1111110 = i111119 >> 3;
                    Function1<? super Boolean, Unit> function119 = function4;
                    boolean z1110 = z5;
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource3;
                    Modifier modifier118 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier118, z3, z1110, function119, mutableInteractionSource118, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer3, int i1111111) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i1111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1111, z1112, composer3, i1111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer3, int i1111111) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i1111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1111, z1112, composer3, i1111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer3, int i1111111) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i1111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1111, z1112, composer3, i1111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer3, int i1111111) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i1111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1111, z1112, composer3, i1111111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1111) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1111);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1111110 & 57344) | (i1111110 & 14) | 805306368 | ((i111119 << 3) & 112) | (i1111110 & 896) | (i1111110 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier118;
                    z6 = z1110;
                    function5 = function119;
                    mutableInteractionSource4 = mutableInteractionSource118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            switchColorsM841colorsro_MJ88 = switchColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function3 = null;
                        } else {
                            function3 = function1;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function4 = function3;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                    }
                    int i1111111 = i10;
                    int i1111112 = i1111111 >> 3;
                    Function1<? super Boolean, Unit> function1110 = function4;
                    boolean z1111 = z5;
                    MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource3;
                    Modifier modifier119 = modifier3;
                    SelectionControlsKt.m918SwitchZ7GKWWo(modifier119, z3, z1111, function1110, mutableInteractionSource119, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer3, int i1111113) {
                            composer3.startReplaceGroup(861972192);
                            ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861972192, i1111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1112, z1113, composer3, i1111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer3, int i1111113) {
                            composer3.startReplaceGroup(-951820511);
                            ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951820511, i1111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                            }
                            State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1112, z1113, composer3, i1111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateTrackColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer3, int i1111113) {
                            composer3.startReplaceGroup(1529354082);
                            ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1529354082, i1111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1112, z1113, composer3, i1111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer3, int i1111113) {
                            composer3.startReplaceGroup(-284438621);
                            ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-284438621, i1111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                            }
                            State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1112, z1113, composer3, i1111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceGroup();
                            return stateThumbColor;
                        }
                    }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                        @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                        /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                        public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1112) {
                            ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1112);
                        }
                    }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1111112 & 57344) | (i1111112 & 14) | 805306368 | ((i1111111 << 3) & 112) | (i1111112 & 896) | (i1111112 & 7168), 28086);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    switchColors3 = switchColorsM841colorsro_MJ88;
                    modifier4 = modifier119;
                    z6 = z1111;
                    function5 = function1110;
                    mutableInteractionSource4 = mutableInteractionSource119;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer3, int i1111113) throws NoWhenBranchMatchedException {
                            ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i1111113 = i10;
                int i1111114 = i1111113 >> 3;
                Function1<? super Boolean, Unit> function1111 = function4;
                boolean z1112 = z5;
                MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource3;
                Modifier modifier1110 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier1110, z3, z1112, function1111, mutableInteractionSource1110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer3, int i1111115) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i1111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1113, z1114, composer3, i1111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer3, int i1111115) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i1111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1113, z1114, composer3, i1111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer3, int i1111115) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i1111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1113, z1114, composer3, i1111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer3, int i1111115) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i1111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1113, z1114, composer3, i1111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1113) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1113);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1111114 & 57344) | (i1111114 & 14) | 805306368 | ((i1111113 << 3) & 112) | (i1111114 & 896) | (i1111114 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier1110;
                z6 = z1112;
                function5 = function1111;
                mutableInteractionSource4 = mutableInteractionSource1110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i1111115 = i10;
                int i1111116 = i1111115 >> 3;
                Function1<? super Boolean, Unit> function1112 = function4;
                boolean z1113 = z5;
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource3;
                Modifier modifier1111 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier1111, z3, z1113, function1112, mutableInteractionSource1111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer3, int i1111117) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i1111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1114, z1115, composer3, i1111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer3, int i1111117) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i1111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1114, z1115, composer3, i1111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer3, int i1111117) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i1111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1114, z1115, composer3, i1111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer3, int i1111117) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i1111117, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1114, z1115, composer3, i1111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1114) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1114);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1111116 & 57344) | (i1111116 & 14) | 805306368 | ((i1111115 << 3) & 112) | (i1111116 & 896) | (i1111116 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier1111;
                z6 = z1113;
                function5 = function1112;
                mutableInteractionSource4 = mutableInteractionSource1111;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer3, int i1111117) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        function2 = function1;
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
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i1111117 = i10;
                int i1111118 = i1111117 >> 3;
                Function1<? super Boolean, Unit> function1113 = function4;
                boolean z1114 = z5;
                MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource3;
                Modifier modifier1112 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier1112, z3, z1114, function1113, mutableInteractionSource1112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer3, int i1111119) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i1111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1115, z1116, composer3, i1111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer3, int i1111119) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i1111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1115, z1116, composer3, i1111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer3, int i1111119) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i1111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1115, z1116, composer3, i1111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer3, int i1111119) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i1111119, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1115, z1116, composer3, i1111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1115) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1115);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i1111118 & 57344) | (i1111118 & 14) | 805306368 | ((i1111117 << 3) & 112) | (i1111118 & 896) | (i1111118 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier1112;
                z6 = z1114;
                function5 = function1113;
                mutableInteractionSource4 = mutableInteractionSource1112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        switchColorsM841colorsro_MJ88 = switchColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function3 = null;
                    } else {
                        function3 = function1;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function4 = function3;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
                }
                int i1111119 = i10;
                int i11111110 = i1111119 >> 3;
                Function1<? super Boolean, Unit> function1114 = function4;
                boolean z1115 = z5;
                MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource3;
                Modifier modifier1113 = modifier3;
                SelectionControlsKt.m918SwitchZ7GKWWo(modifier1113, z3, z1115, function1114, mutableInteractionSource1113, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer3, int i11111111) {
                        composer3.startReplaceGroup(861972192);
                        ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(861972192, i11111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1116, z1117, composer3, i11111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer3, int i11111111) {
                        composer3.startReplaceGroup(-951820511);
                        ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951820511, i11111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                        }
                        State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1116, z1117, composer3, i11111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateTrackColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer3, int i11111111) {
                        composer3.startReplaceGroup(1529354082);
                        ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1529354082, i11111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1116, z1117, composer3, i11111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer3, int i11111111) {
                        composer3.startReplaceGroup(-284438621);
                        ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-284438621, i11111111, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                        }
                        State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1116, z1117, composer3, i11111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return stateThumbColor;
                    }
                }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                    @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                    /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                    public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1116) {
                        ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1116);
                    }
                }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11111110 & 57344) | (i11111110 & 14) | 805306368 | ((i1111119 << 3) & 112) | (i11111110 & 896) | (i11111110 & 7168), 28086);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                switchColors3 = switchColorsM841colorsro_MJ88;
                modifier4 = modifier1113;
                z6 = z1115;
                function5 = function1114;
                mutableInteractionSource4 = mutableInteractionSource1113;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer3, int i11111111) throws NoWhenBranchMatchedException {
                        ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = switchColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = switchColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
            }
            int i11111111 = i10;
            int i11111112 = i11111111 >> 3;
            Function1<? super Boolean, Unit> function1115 = function4;
            boolean z1116 = z5;
            MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource3;
            Modifier modifier1114 = modifier3;
            SelectionControlsKt.m918SwitchZ7GKWWo(modifier1114, z3, z1116, function1115, mutableInteractionSource1114, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer3, int i11111113) {
                    composer3.startReplaceGroup(861972192);
                    ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(861972192, i11111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                    }
                    State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1117, z1118, composer3, i11111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateTrackColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer3, int i11111113) {
                    composer3.startReplaceGroup(-951820511);
                    ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-951820511, i11111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                    }
                    State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1117, z1118, composer3, i11111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateTrackColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer3, int i11111113) {
                    composer3.startReplaceGroup(1529354082);
                    ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1529354082, i11111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                    }
                    State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1117, z1118, composer3, i11111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateThumbColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer3, int i11111113) {
                    composer3.startReplaceGroup(-284438621);
                    ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-284438621, i11111113, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                    }
                    State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1117, z1118, composer3, i11111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateThumbColor;
                }
            }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1117) {
                    ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1117);
                }
            }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11111112 & 57344) | (i11111112 & 14) | 805306368 | ((i11111111 << 3) & 112) | (i11111112 & 896) | (i11111112 & 7168), 28086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            switchColors3 = switchColorsM841colorsro_MJ88;
            modifier4 = modifier1114;
            z6 = z1116;
            function5 = function1115;
            mutableInteractionSource4 = mutableInteractionSource1114;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = switchColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = SwitchDefaults.INSTANCE.m841colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    switchColorsM841colorsro_MJ88 = switchColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function4 = function3;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004492389, i10, -1, "androidx.wear.compose.material.Switch (ToggleControl.kt:122)");
            }
            int i11111113 = i10;
            int i11111114 = i11111113 >> 3;
            Function1<? super Boolean, Unit> function1116 = function4;
            boolean z1117 = z5;
            MutableInteractionSource mutableInteractionSource1115 = mutableInteractionSource3;
            Modifier modifier1115 = modifier3;
            SelectionControlsKt.m918SwitchZ7GKWWo(modifier1115, z3, z1117, function1116, mutableInteractionSource1115, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer3, int i11111115) {
                    composer3.startReplaceGroup(861972192);
                    ComposerKt.sourceInformation(composer3, "CP(1)129@5695L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(861972192, i11111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:129)");
                    }
                    State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1118, z1119, composer3, i11111115 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateTrackColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer3, int i11111115) {
                    composer3.startReplaceGroup(-951820511);
                    ComposerKt.sourceInformation(composer3, "CP(1)135@5853L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-951820511, i11111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:135)");
                    }
                    State<Color> stateTrackColor = switchColorsM841colorsro_MJ88.trackColor(z1118, z1119, composer3, i11111115 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateTrackColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.3
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer3, int i11111115) {
                    composer3.startReplaceGroup(1529354082);
                    ComposerKt.sourceInformation(composer3, "CP(1)141@6005L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1529354082, i11111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:141)");
                    }
                    State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1118, z1119, composer3, i11111115 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateThumbColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.4
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer3, int i11111115) {
                    composer3.startReplaceGroup(-284438621);
                    ComposerKt.sourceInformation(composer3, "CP(1)147@6161L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-284438621, i11111115, -1, "androidx.wear.compose.material.Switch.<anonymous> (ToggleControl.kt:147)");
                    }
                    State<Color> stateThumbColor = switchColorsM841colorsro_MJ88.thumbColor(z1118, z1119, composer3, i11111115 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceGroup();
                    return stateThumbColor;
                }
            }, SWITCH_TRACK_LENGTH, SWITCH_TRACK_HEIGHT, new FunctionDrawThumb() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.5
                @Override // androidx.wear.compose.materialcore.FunctionDrawThumb
                /* JADX INFO: renamed from: invoke-wffgcV4, reason: not valid java name */
                public final void mo867invokewffgcV4(DrawScope drawScope, long j, float f, long j2, boolean z1118) {
                    ToggleControlKt.m865drawThumbRPmYEkk(drawScope, j, f, z1118);
                }
            }, PROGRESS_ANIMATION_SPEC, WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer2, (i11111114 & 57344) | (i11111114 & 14) | 805306368 | ((i11111113 << 3) & 112) | (i11111114 & 896) | (i11111114 & 7168), 28086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            switchColors3 = switchColorsM841colorsro_MJ88;
            modifier4 = modifier1115;
            z6 = z1117;
            function5 = function1116;
            mutableInteractionSource4 = mutableInteractionSource1115;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.Switch.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final void invoke(Composer composer3, int i11111115) throws NoWhenBranchMatchedException {
                    ToggleControlKt.Switch(z, modifier4, switchColors3, z6, function5, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:103:0x0138  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:110:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:89:0x0118  */
    /* JADX WARN: Code duplicated, block: B:91:0x011d  */
    /* JADX WARN: Code duplicated, block: B:92:0x011f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0124  */
    /* JADX WARN: Code duplicated, block: B:96:0x0126  */
    /* JADX WARN: Code duplicated, block: B:99:0x012b  */
    public static final void RadioButton(final boolean z, Modifier modifier, RadioButtonColors radioButtonColors, boolean z2, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) throws NoWhenBranchMatchedException {
        boolean z3;
        int i3;
        Modifier modifier2;
        RadioButtonColors radioButtonColors2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        Function0<Unit> function1;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        int i9;
        Modifier modifier3;
        Composer composer2;
        final RadioButtonColors radioButtonColorsM739colorsro_MJ88;
        boolean z5;
        Function0<Unit> function2;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        Function0<Unit> function3;
        Composer composer3;
        final RadioButtonColors radioButtonColors3;
        final Modifier modifier4;
        final boolean z6;
        final Function0<Unit> function4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(288531062);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RadioButton)P(5,3!2,4)188@8047L8,216@8909L32,192@8217L726:ToggleControl.kt#gj9v0t");
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
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    radioButtonColors2 = radioButtonColors;
                    int i12 = composerStartRestartGroup.changed(radioButtonColors2) ? 256 : 128;
                    i3 |= i12;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                i3 |= i12;
            } else {
                radioButtonColors2 = radioButtonColors;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function1 = function0;
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
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
                        if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i11 != 0) {
                                    modifier3 = (Modifier) Modifier.Companion;
                                } else {
                                    modifier3 = modifier2;
                                }
                                if ((i2 & 4) != 0) {
                                    composer2 = composerStartRestartGroup;
                                    radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                    i3 &= -897;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                                }
                                if (i4 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                if (i6 != 0) {
                                    function2 = null;
                                } else {
                                    function2 = function0;
                                }
                                mutableInteractionSource3 = i8 == 0 ? mutableInteractionSource : null;
                                i10 = i3;
                                function3 = function2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                i10 = i3;
                                modifier3 = modifier2;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                                z5 = z4;
                                function3 = function1;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                composer2 = composerStartRestartGroup;
                            }
                            composer2.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                            }
                            int i13 = i10;
                            int i14 = i13 >> 3;
                            int i15 = i13 << 3;
                            Composer composer4 = composer2;
                            Function0<Unit> function5 = function3;
                            boolean z7 = z5;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            Modifier modifier5 = modifier3;
                            SelectionControlsKt.m917RadioButtonq3QzNKE(modifier5, z3, z7, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer5, int i16) {
                                    composer5.startReplaceGroup(375016918);
                                    ComposerKt.sourceInformation(composer5, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(375016918, i16, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                    }
                                    State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z8, z9, composer5, i16 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer5.endReplaceGroup();
                                    return stateRingColor;
                                }
                            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                                {
                                    super(4);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                                }

                                public final State<Color> invoke(boolean z8, boolean z9, Composer composer5, int i16) {
                                    composer5.startReplaceGroup(-40309899);
                                    ComposerKt.sourceInformation(composer5, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-40309899, i16, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                    }
                                    State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z8, z9, composer5, i16 & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer5.endReplaceGroup();
                                    return stateDotColor;
                                }
                            }, function5, mutableInteractionSource5, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                                @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                                public final int invoke(boolean z8) {
                                    return ToggleControlKt.RadioButton$lambda$0(z8);
                                }
                            }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer4, (i14 & 896) | (i14 & 14) | 918552576 | (i15 & 112) | (458752 & i15) | (3670016 & i15), 438);
                            composer3 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                            modifier4 = modifier5;
                            z6 = z7;
                            function4 = function5;
                            mutableInteractionSource4 = mutableInteractionSource5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            radioButtonColors3 = radioButtonColors2;
                            z6 = z4;
                            function4 = function1;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer3 = composerStartRestartGroup;
                        }
                        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                                public final void invoke(Composer composer5, int i16) throws NoWhenBranchMatchedException {
                                    ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 196608;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i16 = i10;
                        int i17 = i16 >> 3;
                        int i18 = i16 << 3;
                        Composer composer5 = composer2;
                        Function0<Unit> function6 = function3;
                        boolean z8 = z5;
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                        Modifier modifier6 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier6, z3, z8, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer6, int i19) {
                                composer6.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer6, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i19, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z9, z10, composer6, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer6.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z9, boolean z10, Composer composer6, int i19) {
                                composer6.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer6, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i19, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z9, z10, composer6, i19 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer6.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function6, mutableInteractionSource6, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z9) {
                                return ToggleControlKt.RadioButton$lambda$0(z9);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer5, (i17 & 896) | (i17 & 14) | 918552576 | (i18 & 112) | (458752 & i18) | (3670016 & i18), 438);
                        composer3 = composer5;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier6;
                        z6 = z8;
                        function4 = function6;
                        mutableInteractionSource4 = mutableInteractionSource6;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i19 = i10;
                        int i110 = i19 >> 3;
                        int i111 = i19 << 3;
                        Composer composer6 = composer2;
                        Function0<Unit> function7 = function3;
                        boolean z9 = z5;
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                        Modifier modifier7 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier7, z3, z9, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer7, int i112) {
                                composer7.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer7, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i112, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z10, z11, composer7, i112 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer7.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z10, boolean z11, Composer composer7, int i112) {
                                composer7.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer7, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i112, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z10, z11, composer7, i112 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer7.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function7, mutableInteractionSource7, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z10) {
                                return ToggleControlKt.RadioButton$lambda$0(z10);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer6, (i110 & 896) | (i110 & 14) | 918552576 | (i111 & 112) | (458752 & i111) | (3670016 & i111), 438);
                        composer3 = composer6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier7;
                        z6 = z9;
                        function4 = function7;
                        mutableInteractionSource4 = mutableInteractionSource7;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer7, int i112) throws NoWhenBranchMatchedException {
                                ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer7, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function1 = function0;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i112 = i10;
                        int i113 = i112 >> 3;
                        int i114 = i112 << 3;
                        Composer composer7 = composer2;
                        Function0<Unit> function8 = function3;
                        boolean z10 = z5;
                        MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                        Modifier modifier8 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier8, z3, z10, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer8, int i115) {
                                composer8.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer8, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i115, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z11, z12, composer8, i115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer8.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z11, boolean z12, Composer composer8, int i115) {
                                composer8.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer8, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i115, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z11, z12, composer8, i115 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer8.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function8, mutableInteractionSource8, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z11) {
                                return ToggleControlKt.RadioButton$lambda$0(z11);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer7, (i113 & 896) | (i113 & 14) | 918552576 | (i114 & 112) | (458752 & i114) | (3670016 & i114), 438);
                        composer3 = composer7;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier8;
                        z6 = z10;
                        function4 = function8;
                        mutableInteractionSource4 = mutableInteractionSource8;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i115 = i10;
                        int i116 = i115 >> 3;
                        int i117 = i115 << 3;
                        Composer composer8 = composer2;
                        Function0<Unit> function9 = function3;
                        boolean z11 = z5;
                        MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                        Modifier modifier9 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier9, z3, z11, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer9, int i118) {
                                composer9.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer9, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i118, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z12, z13, composer9, i118 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer9.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z12, boolean z13, Composer composer9, int i118) {
                                composer9.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer9, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i118, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z12, z13, composer9, i118 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer9.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function9, mutableInteractionSource9, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z12) {
                                return ToggleControlKt.RadioButton$lambda$0(z12);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer8, (i116 & 896) | (i116 & 14) | 918552576 | (i117 & 112) | (458752 & i117) | (3670016 & i117), 438);
                        composer3 = composer8;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier9;
                        z6 = z11;
                        function4 = function9;
                        mutableInteractionSource4 = mutableInteractionSource9;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer9, int i118) throws NoWhenBranchMatchedException {
                                ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer9, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i118 = i10;
                    int i119 = i118 >> 3;
                    int i1110 = i118 << 3;
                    Composer composer9 = composer2;
                    Function0<Unit> function10 = function3;
                    boolean z12 = z5;
                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                    Modifier modifier10 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier10, z3, z12, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer10, int i1111) {
                            composer10.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer10, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i1111, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z13, z14, composer10, i1111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer10.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z13, boolean z14, Composer composer10, int i1111) {
                            composer10.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer10, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i1111, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z13, z14, composer10, i1111 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer10.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function10, mutableInteractionSource10, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z13) {
                            return ToggleControlKt.RadioButton$lambda$0(z13);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer9, (i119 & 896) | (i119 & 14) | 918552576 | (i1110 & 112) | (458752 & i1110) | (3670016 & i1110), 438);
                    composer3 = composer9;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier10;
                    z6 = z12;
                    function4 = function10;
                    mutableInteractionSource4 = mutableInteractionSource10;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i1111 = i10;
                    int i1112 = i1111 >> 3;
                    int i1113 = i1111 << 3;
                    Composer composer10 = composer2;
                    Function0<Unit> function11 = function3;
                    boolean z13 = z5;
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
                    Modifier modifier11 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier11, z3, z13, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer11, int i1114) {
                            composer11.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer11, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i1114, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z14, z15, composer11, i1114 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer11.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z14, boolean z15, Composer composer11, int i1114) {
                            composer11.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer11, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i1114, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z14, z15, composer11, i1114 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer11.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function11, mutableInteractionSource11, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z14) {
                            return ToggleControlKt.RadioButton$lambda$0(z14);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer10, (i1112 & 896) | (i1112 & 14) | 918552576 | (i1113 & 112) | (458752 & i1113) | (3670016 & i1113), 438);
                    composer3 = composer10;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier11;
                    z6 = z13;
                    function4 = function11;
                    mutableInteractionSource4 = mutableInteractionSource11;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer11, int i1114) throws NoWhenBranchMatchedException {
                            ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer11, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            z4 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i1114 = i10;
                        int i1115 = i1114 >> 3;
                        int i1116 = i1114 << 3;
                        Composer composer11 = composer2;
                        Function0<Unit> function12 = function3;
                        boolean z14 = z5;
                        MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
                        Modifier modifier12 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier12, z3, z14, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer12, int i1117) {
                                composer12.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer12, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i1117, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z15, z16, composer12, i1117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer12.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z15, boolean z16, Composer composer12, int i1117) {
                                composer12.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer12, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i1117, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z15, z16, composer12, i1117 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer12.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function12, mutableInteractionSource12, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z15) {
                                return ToggleControlKt.RadioButton$lambda$0(z15);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer11, (i1115 & 896) | (i1115 & 14) | 918552576 | (i1116 & 112) | (458752 & i1116) | (3670016 & i1116), 438);
                        composer3 = composer11;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier12;
                        z6 = z14;
                        function4 = function12;
                        mutableInteractionSource4 = mutableInteractionSource12;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i1117 = i10;
                        int i1118 = i1117 >> 3;
                        int i1119 = i1117 << 3;
                        Composer composer12 = composer2;
                        Function0<Unit> function13 = function3;
                        boolean z15 = z5;
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource3;
                        Modifier modifier13 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier13, z3, z15, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer13, int i11110) {
                                composer13.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer13, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i11110, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z16, z17, composer13, i11110 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer13.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z16, boolean z17, Composer composer13, int i11110) {
                                composer13.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer13, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i11110, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z16, z17, composer13, i11110 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer13.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function13, mutableInteractionSource13, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z16) {
                                return ToggleControlKt.RadioButton$lambda$0(z16);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer12, (i1118 & 896) | (i1118 & 14) | 918552576 | (i1119 & 112) | (458752 & i1119) | (3670016 & i1119), 438);
                        composer3 = composer12;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier13;
                        z6 = z15;
                        function4 = function13;
                        mutableInteractionSource4 = mutableInteractionSource13;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer13, int i11110) throws NoWhenBranchMatchedException {
                                ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer13, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i11110 = i10;
                    int i11111 = i11110 >> 3;
                    int i11112 = i11110 << 3;
                    Composer composer13 = composer2;
                    Function0<Unit> function14 = function3;
                    boolean z16 = z5;
                    MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource3;
                    Modifier modifier14 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier14, z3, z16, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer14, int i11113) {
                            composer14.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer14, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i11113, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z17, z18, composer14, i11113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer14.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z17, boolean z18, Composer composer14, int i11113) {
                            composer14.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer14, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i11113, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z17, z18, composer14, i11113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer14.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function14, mutableInteractionSource14, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z17) {
                            return ToggleControlKt.RadioButton$lambda$0(z17);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer13, (i11111 & 896) | (i11111 & 14) | 918552576 | (i11112 & 112) | (458752 & i11112) | (3670016 & i11112), 438);
                    composer3 = composer13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier14;
                    z6 = z16;
                    function4 = function14;
                    mutableInteractionSource4 = mutableInteractionSource14;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i11113 = i10;
                    int i11114 = i11113 >> 3;
                    int i11115 = i11113 << 3;
                    Composer composer14 = composer2;
                    Function0<Unit> function15 = function3;
                    boolean z17 = z5;
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource3;
                    Modifier modifier15 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier15, z3, z17, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer15, int i11116) {
                            composer15.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer15, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i11116, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z18, z19, composer15, i11116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer15.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z18, boolean z19, Composer composer15, int i11116) {
                            composer15.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer15, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i11116, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z18, z19, composer15, i11116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer15.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function15, mutableInteractionSource15, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z18) {
                            return ToggleControlKt.RadioButton$lambda$0(z18);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer14, (i11114 & 896) | (i11114 & 14) | 918552576 | (i11115 & 112) | (458752 & i11115) | (3670016 & i11115), 438);
                    composer3 = composer14;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier15;
                    z6 = z17;
                    function4 = function15;
                    mutableInteractionSource4 = mutableInteractionSource15;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer15, int i11116) throws NoWhenBranchMatchedException {
                            ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer15, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function1 = function0;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i11116 = i10;
                    int i11117 = i11116 >> 3;
                    int i11118 = i11116 << 3;
                    Composer composer15 = composer2;
                    Function0<Unit> function16 = function3;
                    boolean z18 = z5;
                    MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource3;
                    Modifier modifier16 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier16, z3, z18, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer16, int i11119) {
                            composer16.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer16, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i11119, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z19, z110, composer16, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer16.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z19, boolean z110, Composer composer16, int i11119) {
                            composer16.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer16, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i11119, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z19, z110, composer16, i11119 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer16.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function16, mutableInteractionSource16, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z19) {
                            return ToggleControlKt.RadioButton$lambda$0(z19);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer15, (i11117 & 896) | (i11117 & 14) | 918552576 | (i11118 & 112) | (458752 & i11118) | (3670016 & i11118), 438);
                    composer3 = composer15;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier16;
                    z6 = z18;
                    function4 = function16;
                    mutableInteractionSource4 = mutableInteractionSource16;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i11119 = i10;
                    int i111110 = i11119 >> 3;
                    int i111111 = i11119 << 3;
                    Composer composer16 = composer2;
                    Function0<Unit> function17 = function3;
                    boolean z19 = z5;
                    MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource3;
                    Modifier modifier17 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier17, z3, z19, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer17, int i111112) {
                            composer17.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer17, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i111112, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z110, z111, composer17, i111112 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer17.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z110, boolean z111, Composer composer17, int i111112) {
                            composer17.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer17, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i111112, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z110, z111, composer17, i111112 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer17.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function17, mutableInteractionSource17, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z110) {
                            return ToggleControlKt.RadioButton$lambda$0(z110);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer16, (i111110 & 896) | (i111110 & 14) | 918552576 | (i111111 & 112) | (458752 & i111111) | (3670016 & i111111), 438);
                    composer3 = composer16;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier17;
                    z6 = z19;
                    function4 = function17;
                    mutableInteractionSource4 = mutableInteractionSource17;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer17, int i111112) throws NoWhenBranchMatchedException {
                            ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer17, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i111112 = i10;
                int i111113 = i111112 >> 3;
                int i111114 = i111112 << 3;
                Composer composer17 = composer2;
                Function0<Unit> function18 = function3;
                boolean z110 = z5;
                MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource3;
                Modifier modifier18 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier18, z3, z110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer18, int i111115) {
                        composer18.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer18, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i111115, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z111, z112, composer18, i111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer18.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z111, boolean z112, Composer composer18, int i111115) {
                        composer18.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer18, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i111115, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z111, z112, composer18, i111115 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer18.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function18, mutableInteractionSource18, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z111) {
                        return ToggleControlKt.RadioButton$lambda$0(z111);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer17, (i111113 & 896) | (i111113 & 14) | 918552576 | (i111114 & 112) | (458752 & i111114) | (3670016 & i111114), 438);
                composer3 = composer17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier18;
                z6 = z110;
                function4 = function18;
                mutableInteractionSource4 = mutableInteractionSource18;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i111115 = i10;
                int i111116 = i111115 >> 3;
                int i111117 = i111115 << 3;
                Composer composer18 = composer2;
                Function0<Unit> function19 = function3;
                boolean z111 = z5;
                MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource3;
                Modifier modifier19 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier19, z3, z111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer19, int i111118) {
                        composer19.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer19, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i111118, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z112, z113, composer19, i111118 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer19.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z112, boolean z113, Composer composer19, int i111118) {
                        composer19.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer19, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i111118, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z112, z113, composer19, i111118 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer19.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function19, mutableInteractionSource19, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z112) {
                        return ToggleControlKt.RadioButton$lambda$0(z112);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer18, (i111116 & 896) | (i111116 & 14) | 918552576 | (i111117 & 112) | (458752 & i111117) | (3670016 & i111117), 438);
                composer3 = composer18;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier19;
                z6 = z111;
                function4 = function19;
                mutableInteractionSource4 = mutableInteractionSource19;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer19, int i111118) throws NoWhenBranchMatchedException {
                        ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer19, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                radioButtonColors2 = radioButtonColors;
                if (composerStartRestartGroup.changed(radioButtonColors2)) {
                }
                i3 |= i12;
            } else {
                radioButtonColors2 = radioButtonColors;
            }
            i3 |= i12;
        } else {
            radioButtonColors2 = radioButtonColors;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
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
                    if ((74899 & i3) == 74898) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i111118 = i10;
                        int i111119 = i111118 >> 3;
                        int i1111110 = i111118 << 3;
                        Composer composer19 = composer2;
                        Function0<Unit> function110 = function3;
                        boolean z112 = z5;
                        MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource3;
                        Modifier modifier110 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier110, z3, z112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer110, int i1111111) {
                                composer110.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer110, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i1111111, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z113, z114, composer110, i1111111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer110.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z113, boolean z114, Composer composer110, int i1111111) {
                                composer110.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer110, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i1111111, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z113, z114, composer110, i1111111 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer110.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function110, mutableInteractionSource110, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z113) {
                                return ToggleControlKt.RadioButton$lambda$0(z113);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer19, (i111119 & 896) | (i111119 & 14) | 918552576 | (i1111110 & 112) | (458752 & i1111110) | (3670016 & i1111110), 438);
                        composer3 = composer19;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier110;
                        z6 = z112;
                        function4 = function110;
                        mutableInteractionSource4 = mutableInteractionSource110;
                    } else {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        } else {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if ((i2 & 4) != 0) {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                                i3 &= -897;
                            } else {
                                composer2 = composerStartRestartGroup;
                                radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                function2 = null;
                            } else {
                                function2 = function0;
                            }
                            if (i8 == 0) {
                            }
                            i10 = i3;
                            function3 = function2;
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                        }
                        int i1111111 = i10;
                        int i1111112 = i1111111 >> 3;
                        int i1111113 = i1111111 << 3;
                        Composer composer110 = composer2;
                        Function0<Unit> function111 = function3;
                        boolean z113 = z5;
                        MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource3;
                        Modifier modifier111 = modifier3;
                        SelectionControlsKt.m917RadioButtonq3QzNKE(modifier111, z3, z113, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer111, int i1111114) {
                                composer111.startReplaceGroup(375016918);
                                ComposerKt.sourceInformation(composer111, "C197@8361L87:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(375016918, i1111114, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                                }
                                State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z114, z115, composer111, i1111114 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer111.endReplaceGroup();
                                return stateRingColor;
                            }
                        }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                            {
                                super(4);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                            }

                            public final State<Color> invoke(boolean z114, boolean z115, Composer composer111, int i1111114) {
                                composer111.startReplaceGroup(-40309899);
                                ComposerKt.sourceInformation(composer111, "C203@8513L86:ToggleControl.kt#gj9v0t");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-40309899, i1111114, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                                }
                                State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z114, z115, composer111, i1111114 & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer111.endReplaceGroup();
                                return stateDotColor;
                            }
                        }, function111, mutableInteractionSource111, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                            @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                            public final int invoke(boolean z114) {
                                return ToggleControlKt.RadioButton$lambda$0(z114);
                            }
                        }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer110, (i1111112 & 896) | (i1111112 & 14) | 918552576 | (i1111113 & 112) | (458752 & i1111113) | (3670016 & i1111113), 438);
                        composer3 = composer110;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                        modifier4 = modifier111;
                        z6 = z113;
                        function4 = function111;
                        mutableInteractionSource4 = mutableInteractionSource111;
                    }
                    scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                            public final void invoke(Composer composer111, int i1111114) throws NoWhenBranchMatchedException {
                                ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer111, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i1111114 = i10;
                    int i1111115 = i1111114 >> 3;
                    int i1111116 = i1111114 << 3;
                    Composer composer111 = composer2;
                    Function0<Unit> function112 = function3;
                    boolean z114 = z5;
                    MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource3;
                    Modifier modifier112 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier112, z3, z114, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer112, int i1111117) {
                            composer112.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer112, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i1111117, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z115, z116, composer112, i1111117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer112.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z115, boolean z116, Composer composer112, int i1111117) {
                            composer112.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer112, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i1111117, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z115, z116, composer112, i1111117 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer112.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function112, mutableInteractionSource112, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z115) {
                            return ToggleControlKt.RadioButton$lambda$0(z115);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer111, (i1111115 & 896) | (i1111115 & 14) | 918552576 | (i1111116 & 112) | (458752 & i1111116) | (3670016 & i1111116), 438);
                    composer3 = composer111;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier112;
                    z6 = z114;
                    function4 = function112;
                    mutableInteractionSource4 = mutableInteractionSource112;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i1111117 = i10;
                    int i1111118 = i1111117 >> 3;
                    int i1111119 = i1111117 << 3;
                    Composer composer112 = composer2;
                    Function0<Unit> function113 = function3;
                    boolean z115 = z5;
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource3;
                    Modifier modifier113 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier113, z3, z115, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer113, int i11111110) {
                            composer113.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer113, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i11111110, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z116, z117, composer113, i11111110 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer113.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z116, boolean z117, Composer composer113, int i11111110) {
                            composer113.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer113, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i11111110, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z116, z117, composer113, i11111110 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer113.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function113, mutableInteractionSource113, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z116) {
                            return ToggleControlKt.RadioButton$lambda$0(z116);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer112, (i1111118 & 896) | (i1111118 & 14) | 918552576 | (i1111119 & 112) | (458752 & i1111119) | (3670016 & i1111119), 438);
                    composer3 = composer112;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier113;
                    z6 = z115;
                    function4 = function113;
                    mutableInteractionSource4 = mutableInteractionSource113;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer113, int i11111110) throws NoWhenBranchMatchedException {
                            ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer113, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function1 = function0;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i11111110 = i10;
                    int i11111111 = i11111110 >> 3;
                    int i11111112 = i11111110 << 3;
                    Composer composer113 = composer2;
                    Function0<Unit> function114 = function3;
                    boolean z116 = z5;
                    MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource3;
                    Modifier modifier114 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier114, z3, z116, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer114, int i11111113) {
                            composer114.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer114, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i11111113, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z117, z118, composer114, i11111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer114.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z117, boolean z118, Composer composer114, int i11111113) {
                            composer114.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer114, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i11111113, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z117, z118, composer114, i11111113 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer114.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function114, mutableInteractionSource114, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z117) {
                            return ToggleControlKt.RadioButton$lambda$0(z117);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer113, (i11111111 & 896) | (i11111111 & 14) | 918552576 | (i11111112 & 112) | (458752 & i11111112) | (3670016 & i11111112), 438);
                    composer3 = composer113;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier114;
                    z6 = z116;
                    function4 = function114;
                    mutableInteractionSource4 = mutableInteractionSource114;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i11111113 = i10;
                    int i11111114 = i11111113 >> 3;
                    int i11111115 = i11111113 << 3;
                    Composer composer114 = composer2;
                    Function0<Unit> function115 = function3;
                    boolean z117 = z5;
                    MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource3;
                    Modifier modifier115 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier115, z3, z117, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer115, int i11111116) {
                            composer115.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer115, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i11111116, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z118, z119, composer115, i11111116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer115.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z118, boolean z119, Composer composer115, int i11111116) {
                            composer115.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer115, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i11111116, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z118, z119, composer115, i11111116 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer115.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function115, mutableInteractionSource115, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z118) {
                            return ToggleControlKt.RadioButton$lambda$0(z118);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer114, (i11111114 & 896) | (i11111114 & 14) | 918552576 | (i11111115 & 112) | (458752 & i11111115) | (3670016 & i11111115), 438);
                    composer3 = composer114;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier115;
                    z6 = z117;
                    function4 = function115;
                    mutableInteractionSource4 = mutableInteractionSource115;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer115, int i11111116) throws NoWhenBranchMatchedException {
                            ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer115, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i11111116 = i10;
                int i11111117 = i11111116 >> 3;
                int i11111118 = i11111116 << 3;
                Composer composer115 = composer2;
                Function0<Unit> function116 = function3;
                boolean z118 = z5;
                MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource3;
                Modifier modifier116 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier116, z3, z118, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer116, int i11111119) {
                        composer116.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer116, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i11111119, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z119, z1110, composer116, i11111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer116.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z119, boolean z1110, Composer composer116, int i11111119) {
                        composer116.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer116, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i11111119, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z119, z1110, composer116, i11111119 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer116.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function116, mutableInteractionSource116, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z119) {
                        return ToggleControlKt.RadioButton$lambda$0(z119);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer115, (i11111117 & 896) | (i11111117 & 14) | 918552576 | (i11111118 & 112) | (458752 & i11111118) | (3670016 & i11111118), 438);
                composer3 = composer115;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier116;
                z6 = z118;
                function4 = function116;
                mutableInteractionSource4 = mutableInteractionSource116;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i11111119 = i10;
                int i111111110 = i11111119 >> 3;
                int i111111111 = i11111119 << 3;
                Composer composer116 = composer2;
                Function0<Unit> function117 = function3;
                boolean z119 = z5;
                MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource3;
                Modifier modifier117 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier117, z3, z119, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer117, int i111111112) {
                        composer117.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer117, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i111111112, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1110, z1111, composer117, i111111112 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer117.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1110, boolean z1111, Composer composer117, int i111111112) {
                        composer117.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer117, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i111111112, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1110, z1111, composer117, i111111112 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer117.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function117, mutableInteractionSource117, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z1110) {
                        return ToggleControlKt.RadioButton$lambda$0(z1110);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer116, (i111111110 & 896) | (i111111110 & 14) | 918552576 | (i111111111 & 112) | (458752 & i111111111) | (3670016 & i111111111), 438);
                composer3 = composer116;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier117;
                z6 = z119;
                function4 = function117;
                mutableInteractionSource4 = mutableInteractionSource117;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer117, int i111111112) throws NoWhenBranchMatchedException {
                        ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer117, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        z4 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
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
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i111111112 = i10;
                    int i111111113 = i111111112 >> 3;
                    int i111111114 = i111111112 << 3;
                    Composer composer117 = composer2;
                    Function0<Unit> function118 = function3;
                    boolean z1110 = z5;
                    MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource3;
                    Modifier modifier118 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier118, z3, z1110, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer118, int i111111115) {
                            composer118.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer118, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i111111115, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1111, z1112, composer118, i111111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer118.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1111, boolean z1112, Composer composer118, int i111111115) {
                            composer118.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer118, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i111111115, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1111, z1112, composer118, i111111115 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer118.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function118, mutableInteractionSource118, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z1111) {
                            return ToggleControlKt.RadioButton$lambda$0(z1111);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer117, (i111111113 & 896) | (i111111113 & 14) | 918552576 | (i111111114 & 112) | (458752 & i111111114) | (3670016 & i111111114), 438);
                    composer3 = composer117;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier118;
                    z6 = z1110;
                    function4 = function118;
                    mutableInteractionSource4 = mutableInteractionSource118;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    } else {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                            i3 &= -897;
                        } else {
                            composer2 = composerStartRestartGroup;
                            radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            function2 = null;
                        } else {
                            function2 = function0;
                        }
                        if (i8 == 0) {
                        }
                        i10 = i3;
                        function3 = function2;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                    }
                    int i111111115 = i10;
                    int i111111116 = i111111115 >> 3;
                    int i111111117 = i111111115 << 3;
                    Composer composer118 = composer2;
                    Function0<Unit> function119 = function3;
                    boolean z1111 = z5;
                    MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource3;
                    Modifier modifier119 = modifier3;
                    SelectionControlsKt.m917RadioButtonq3QzNKE(modifier119, z3, z1111, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer119, int i111111118) {
                            composer119.startReplaceGroup(375016918);
                            ComposerKt.sourceInformation(composer119, "C197@8361L87:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(375016918, i111111118, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                            }
                            State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1112, z1113, composer119, i111111118 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer119.endReplaceGroup();
                            return stateRingColor;
                        }
                    }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                        {
                            super(4);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                        }

                        public final State<Color> invoke(boolean z1112, boolean z1113, Composer composer119, int i111111118) {
                            composer119.startReplaceGroup(-40309899);
                            ComposerKt.sourceInformation(composer119, "C203@8513L86:ToggleControl.kt#gj9v0t");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-40309899, i111111118, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                            }
                            State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1112, z1113, composer119, i111111118 & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer119.endReplaceGroup();
                            return stateDotColor;
                        }
                    }, function119, mutableInteractionSource119, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                        @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                        public final int invoke(boolean z1112) {
                            return ToggleControlKt.RadioButton$lambda$0(z1112);
                        }
                    }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer118, (i111111116 & 896) | (i111111116 & 14) | 918552576 | (i111111117 & 112) | (458752 & i111111117) | (3670016 & i111111117), 438);
                    composer3 = composer118;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                    modifier4 = modifier119;
                    z6 = z1111;
                    function4 = function119;
                    mutableInteractionSource4 = mutableInteractionSource119;
                }
                scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                        public final void invoke(Composer composer119, int i111111118) throws NoWhenBranchMatchedException {
                            ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer119, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i111111118 = i10;
                int i111111119 = i111111118 >> 3;
                int i1111111110 = i111111118 << 3;
                Composer composer119 = composer2;
                Function0<Unit> function1110 = function3;
                boolean z1112 = z5;
                MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource3;
                Modifier modifier1110 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier1110, z3, z1112, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer1110, int i1111111111) {
                        composer1110.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer1110, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i1111111111, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1113, z1114, composer1110, i1111111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1110.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1113, boolean z1114, Composer composer1110, int i1111111111) {
                        composer1110.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer1110, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i1111111111, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1113, z1114, composer1110, i1111111111 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1110.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function1110, mutableInteractionSource1110, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z1113) {
                        return ToggleControlKt.RadioButton$lambda$0(z1113);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer119, (i111111119 & 896) | (i111111119 & 14) | 918552576 | (i1111111110 & 112) | (458752 & i1111111110) | (3670016 & i1111111110), 438);
                composer3 = composer119;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier1110;
                z6 = z1112;
                function4 = function1110;
                mutableInteractionSource4 = mutableInteractionSource1110;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i1111111111 = i10;
                int i1111111112 = i1111111111 >> 3;
                int i1111111113 = i1111111111 << 3;
                Composer composer1110 = composer2;
                Function0<Unit> function1111 = function3;
                boolean z1113 = z5;
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource3;
                Modifier modifier1111 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier1111, z3, z1113, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer1111, int i1111111114) {
                        composer1111.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer1111, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i1111111114, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1114, z1115, composer1111, i1111111114 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1111.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1114, boolean z1115, Composer composer1111, int i1111111114) {
                        composer1111.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer1111, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i1111111114, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1114, z1115, composer1111, i1111111114 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1111.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function1111, mutableInteractionSource1111, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z1114) {
                        return ToggleControlKt.RadioButton$lambda$0(z1114);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer1110, (i1111111112 & 896) | (i1111111112 & 14) | 918552576 | (i1111111113 & 112) | (458752 & i1111111113) | (3670016 & i1111111113), 438);
                composer3 = composer1110;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier1111;
                z6 = z1113;
                function4 = function1111;
                mutableInteractionSource4 = mutableInteractionSource1111;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer1111, int i1111111114) throws NoWhenBranchMatchedException {
                        ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer1111, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        function1 = function0;
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
            if ((74899 & i3) == 74898) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i1111111114 = i10;
                int i1111111115 = i1111111114 >> 3;
                int i1111111116 = i1111111114 << 3;
                Composer composer1111 = composer2;
                Function0<Unit> function1112 = function3;
                boolean z1114 = z5;
                MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource3;
                Modifier modifier1112 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier1112, z3, z1114, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer1112, int i1111111117) {
                        composer1112.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer1112, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i1111111117, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1115, z1116, composer1112, i1111111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1112.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1115, boolean z1116, Composer composer1112, int i1111111117) {
                        composer1112.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer1112, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i1111111117, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1115, z1116, composer1112, i1111111117 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1112.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function1112, mutableInteractionSource1112, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z1115) {
                        return ToggleControlKt.RadioButton$lambda$0(z1115);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer1111, (i1111111115 & 896) | (i1111111115 & 14) | 918552576 | (i1111111116 & 112) | (458752 & i1111111116) | (3670016 & i1111111116), 438);
                composer3 = composer1111;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier1112;
                z6 = z1114;
                function4 = function1112;
                mutableInteractionSource4 = mutableInteractionSource1112;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                        i3 &= -897;
                    } else {
                        composer2 = composerStartRestartGroup;
                        radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        function2 = null;
                    } else {
                        function2 = function0;
                    }
                    if (i8 == 0) {
                    }
                    i10 = i3;
                    function3 = function2;
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
                }
                int i1111111117 = i10;
                int i1111111118 = i1111111117 >> 3;
                int i1111111119 = i1111111117 << 3;
                Composer composer1112 = composer2;
                Function0<Unit> function1113 = function3;
                boolean z1115 = z5;
                MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource3;
                Modifier modifier1113 = modifier3;
                SelectionControlsKt.m917RadioButtonq3QzNKE(modifier1113, z3, z1115, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer1113, int i11111111110) {
                        composer1113.startReplaceGroup(375016918);
                        ComposerKt.sourceInformation(composer1113, "C197@8361L87:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(375016918, i11111111110, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                        }
                        State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1116, z1117, composer1113, i11111111110 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1113.endReplaceGroup();
                        return stateRingColor;
                    }
                }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                    {
                        super(4);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                    }

                    public final State<Color> invoke(boolean z1116, boolean z1117, Composer composer1113, int i11111111110) {
                        composer1113.startReplaceGroup(-40309899);
                        ComposerKt.sourceInformation(composer1113, "C203@8513L86:ToggleControl.kt#gj9v0t");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-40309899, i11111111110, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                        }
                        State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1116, z1117, composer1113, i11111111110 & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer1113.endReplaceGroup();
                        return stateDotColor;
                    }
                }, function1113, mutableInteractionSource1113, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                    @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                    public final int invoke(boolean z1116) {
                        return ToggleControlKt.RadioButton$lambda$0(z1116);
                    }
                }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer1112, (i1111111118 & 896) | (i1111111118 & 14) | 918552576 | (i1111111119 & 112) | (458752 & i1111111119) | (3670016 & i1111111119), 438);
                composer3 = composer1112;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
                modifier4 = modifier1113;
                z6 = z1115;
                function4 = function1113;
                mutableInteractionSource4 = mutableInteractionSource1113;
            }
            scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                    public final void invoke(Composer composer1113, int i11111111110) throws NoWhenBranchMatchedException {
                        ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer1113, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function3 = function2;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function3 = function2;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
            }
            int i11111111110 = i10;
            int i11111111111 = i11111111110 >> 3;
            int i11111111112 = i11111111110 << 3;
            Composer composer1113 = composer2;
            Function0<Unit> function1114 = function3;
            boolean z1116 = z5;
            MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource3;
            Modifier modifier1114 = modifier3;
            SelectionControlsKt.m917RadioButtonq3QzNKE(modifier1114, z3, z1116, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer1114, int i11111111113) {
                    composer1114.startReplaceGroup(375016918);
                    ComposerKt.sourceInformation(composer1114, "C197@8361L87:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(375016918, i11111111113, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                    }
                    State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1117, z1118, composer1114, i11111111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1114.endReplaceGroup();
                    return stateRingColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1117, boolean z1118, Composer composer1114, int i11111111113) {
                    composer1114.startReplaceGroup(-40309899);
                    ComposerKt.sourceInformation(composer1114, "C203@8513L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-40309899, i11111111113, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                    }
                    State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1117, z1118, composer1114, i11111111113 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1114.endReplaceGroup();
                    return stateDotColor;
                }
            }, function1114, mutableInteractionSource1114, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                public final int invoke(boolean z1117) {
                    return ToggleControlKt.RadioButton$lambda$0(z1117);
                }
            }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer1113, (i11111111111 & 896) | (i11111111111 & 14) | 918552576 | (i11111111112 & 112) | (458752 & i11111111112) | (3670016 & i11111111112), 438);
            composer3 = composer1113;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
            modifier4 = modifier1114;
            z6 = z1116;
            function4 = function1114;
            mutableInteractionSource4 = mutableInteractionSource1114;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function3 = function2;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 4) != 0) {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = RadioButtonDefaults.INSTANCE.m739colorsro_MJ88(0L, 0L, 0L, 0L, composer2, 24576, 15);
                    i3 &= -897;
                } else {
                    composer2 = composerStartRestartGroup;
                    radioButtonColorsM739colorsro_MJ88 = radioButtonColors2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    function2 = null;
                } else {
                    function2 = function0;
                }
                if (i8 == 0) {
                }
                i10 = i3;
                function3 = function2;
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(288531062, i10, -1, "androidx.wear.compose.material.RadioButton (ToggleControl.kt:192)");
            }
            int i11111111113 = i10;
            int i11111111114 = i11111111113 >> 3;
            int i11111111115 = i11111111113 << 3;
            Composer composer1114 = composer2;
            Function0<Unit> function1115 = function3;
            boolean z1117 = z5;
            MutableInteractionSource mutableInteractionSource1115 = mutableInteractionSource3;
            Modifier modifier1115 = modifier3;
            SelectionControlsKt.m917RadioButtonq3QzNKE(modifier1115, z3, z1117, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.1
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer1115, int i11111111116) {
                    composer1115.startReplaceGroup(375016918);
                    ComposerKt.sourceInformation(composer1115, "C197@8361L87:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(375016918, i11111111116, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:197)");
                    }
                    State<Color> stateRingColor = radioButtonColorsM739colorsro_MJ88.ringColor(z1118, z1119, composer1115, i11111111116 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1115.endReplaceGroup();
                    return stateRingColor;
                }
            }, new Function4<Boolean, Boolean, Composer, Integer, State<? extends Color>>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.2
                {
                    super(4);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), (Composer) obj3, ((Number) obj4).intValue());
                }

                public final State<Color> invoke(boolean z1118, boolean z1119, Composer composer1115, int i11111111116) {
                    composer1115.startReplaceGroup(-40309899);
                    ComposerKt.sourceInformation(composer1115, "C203@8513L86:ToggleControl.kt#gj9v0t");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-40309899, i11111111116, -1, "androidx.wear.compose.material.RadioButton.<anonymous> (ToggleControl.kt:203)");
                    }
                    State<Color> stateDotColor = radioButtonColorsM739colorsro_MJ88.dotColor(z1118, z1119, composer1115, i11111111116 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer1115.endReplaceGroup();
                    return stateDotColor;
                }
            }, function1115, mutableInteractionSource1115, new FunctionDotRadiusProgressDuration() { // from class: androidx.wear.compose.material.ToggleControlKt$$ExternalSyntheticLambda0
                @Override // androidx.wear.compose.materialcore.FunctionDotRadiusProgressDuration
                public final int invoke(boolean z1118) {
                    return ToggleControlKt.RadioButton$lambda$0(z1118);
                }
            }, AnimationKt.RAPID, 75, AnimationKt.getSTANDARD_IN(), WIDTH, HEIGHT, RippleKt.m745rippleOrFallbackImplementation9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), composer1114, (i11111111114 & 896) | (i11111111114 & 14) | 918552576 | (i11111111115 & 112) | (458752 & i11111111115) | (3670016 & i11111111115), 438);
            composer3 = composer1114;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            radioButtonColors3 = radioButtonColorsM739colorsro_MJ88;
            modifier4 = modifier1115;
            z6 = z1117;
            function4 = function1115;
            mutableInteractionSource4 = mutableInteractionSource1115;
        }
        scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ToggleControlKt.RadioButton.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws NoWhenBranchMatchedException {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
                public final void invoke(Composer composer1115, int i11111111116) throws NoWhenBranchMatchedException {
                    ToggleControlKt.RadioButton(z, modifier4, radioButtonColors3, z6, function4, mutableInteractionSource4, composer1115, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawBox-4WTKRHQ, reason: not valid java name */
    public static final void m864drawBox4WTKRHQ(DrawScope drawScope, long j) {
        float f = drawScope.toPx-0680j_4(BOX_CORNER);
        float f2 = drawScope.toPx-0680j_4(BOX_STROKE);
        float f3 = f2 / 2.0f;
        float f4 = drawScope.toPx-0680j_4(BOX_RADIUS);
        float f5 = f + f3;
        float f6 = drawScope.toPx-0680j_4(BOX_SIZE) - f2;
        DrawScope.drawRoundRect-u-Aw5IA$default(drawScope, j, OffsetKt.Offset(f5, f5), SizeKt.Size(f6, f6), CornerRadiusKt.CornerRadius$default(f4 - f3, 0.0f, 2, (Object) null), new Stroke(f2, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), 0.0f, (ColorFilter) null, 0, 224, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawThumb-RPmYEkk, reason: not valid java name */
    public static final void m865drawThumbRPmYEkk(DrawScope drawScope, long j, float f, boolean z) {
        float f2 = drawScope.toPx-0680j_4(SWITCH_THUMB_RADIUS);
        float f3 = drawScope.toPx-0680j_4(SWITCH_TRACK_LENGTH);
        DrawScope.drawCircle-VaOC9Bg$default(drawScope, j, f2, OffsetKt.Offset(MathHelpersKt.lerp(z ? f3 - f2 : f2, z ? f2 : f3 - f2, f), Offset.getY-impl(drawScope.getCenter-F1C5BW0())), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getSrc-0nO6VwU(), 56, (Object) null);
    }

    static {
        float f = 2;
        BOX_STROKE = Dp.constructor-impl(f);
        BOX_RADIUS = Dp.constructor-impl(f);
        float f2 = 24;
        SWITCH_TRACK_LENGTH = Dp.constructor-impl(f2);
        WIDTH = Dp.constructor-impl(f2);
        HEIGHT = Dp.constructor-impl(f2);
    }
}
