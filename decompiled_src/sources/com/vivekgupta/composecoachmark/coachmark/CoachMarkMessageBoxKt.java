package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoachMarkMessageBox.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ah\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"CoachMarkMessageBox", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "messageBoxWidth", "Landroidx/compose/ui/unit/Dp;", "messageBoxHeight", "contentColor", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CoachMarkMessageBox-tb54SUI", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/ui/unit/Dp;Landroidx/compose/ui/unit/Dp;JLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "composecoachmark_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoachMarkMessageBoxKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0143  */
    /* JADX WARN: Code duplicated, block: B:101:0x014a  */
    /* JADX WARN: Code duplicated, block: B:103:0x014d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0150  */
    /* JADX WARN: Code duplicated, block: B:107:0x0153  */
    /* JADX WARN: Code duplicated, block: B:108:0x015d  */
    /* JADX WARN: Code duplicated, block: B:112:0x016e  */
    /* JADX WARN: Code duplicated, block: B:114:0x0179  */
    /* JADX WARN: Code duplicated, block: B:115:0x0184  */
    /* JADX WARN: Code duplicated, block: B:118:0x0196  */
    /* JADX WARN: Code duplicated, block: B:119:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:122:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:127:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x007a  */
    /* JADX WARN: Code duplicated, block: B:43:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00be  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:75:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:83:0x0101  */
    /* JADX WARN: Code duplicated, block: B:85:0x0108  */
    /* JADX WARN: Code duplicated, block: B:92:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x0123  */
    /* JADX WARN: Code duplicated, block: B:94:0x0128  */
    /* JADX WARN: Code duplicated, block: B:97:0x012f  */
    /* JADX WARN: Code duplicated, block: B:98:0x013f  */
    /* JADX INFO: renamed from: CoachMarkMessageBox-tb54SUI, reason: not valid java name */
    public static final void m2238CoachMarkMessageBoxtb54SUI(Modifier modifier, Shape shape, long j, Dp dp, Dp dp2, long j2, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        final int i3;
        Shape ellipseMessageShape;
        long j3;
        int i4;
        Dp dp3;
        int i5;
        int i6;
        Dp dp4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        long j4;
        long j5;
        Dp dp5;
        Dp dp6;
        Shape shape2;
        long j6;
        Modifier modifierHeight;
        Modifier modifierWidth;
        Composer composer2;
        final Modifier modifier3;
        final Dp dp7;
        final Dp dp8;
        final Shape shape3;
        final long j7;
        final long j8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-180950365);
        int i12 = i2 & 1;
        if (i12 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                ellipseMessageShape = shape;
                int i13 = composerStartRestartGroup.changed(ellipseMessageShape) ? 32 : 16;
                i3 |= i13;
            } else {
                ellipseMessageShape = shape;
            }
            i3 |= i13;
        } else {
            ellipseMessageShape = shape;
        }
        int i14 = i2 & 4;
        if (i14 == 0) {
            if ((i & 896) == 0) {
                j3 = j;
                i3 |= composerStartRestartGroup.changed(j3) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    dp3 = dp;
                    if (composerStartRestartGroup.changed(dp3)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((57344 & i) == 0) {
                        dp4 = dp2;
                        if (composerStartRestartGroup.changed(dp4)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= 196608;
                        i9 = i12;
                    } else {
                        i9 = i12;
                        if ((i & 458752) == 0) {
                            if (composerStartRestartGroup.changed(j2)) {
                                i10 = 131072;
                            } else {
                                i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i10;
                        }
                    }
                    if ((i2 & 64) != 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        if (composerStartRestartGroup.changed(function2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 2995931) == 599186 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            } else {
                                modifier2 = modifier;
                            }
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                                ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                            }
                            if (i14 != 0) {
                                j4 = Color.Companion.getWhite-0d7_KjU();
                            } else {
                                j4 = j3;
                            }
                            if (i4 != 0) {
                                dp3 = null;
                            }
                            if (i6 != 0) {
                                dp4 = null;
                            }
                            if (i8 != 0) {
                                j5 = Color.Companion.getBlack-0d7_KjU();
                            } else {
                                j5 = j2;
                            }
                            dp5 = dp3;
                            dp6 = dp4;
                            shape2 = ellipseMessageShape;
                            j6 = j4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            modifier2 = modifier;
                            j5 = j2;
                            dp5 = dp3;
                            dp6 = dp4;
                            shape2 = ellipseMessageShape;
                            j6 = j3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                        }
                        if (dp6 == null) {
                            modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                        } else {
                            modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                        }
                        Modifier modifierThen = modifier2.then(modifierHeight);
                        if (dp5 == null) {
                            modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                        } else {
                            modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.Surface-F-jzlyU(modifierThen.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                                }
                                function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        dp7 = dp5;
                        dp8 = dp6;
                        shape3 = shape2;
                        j7 = j6;
                        j8 = j5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        composer2 = composerStartRestartGroup;
                        shape3 = ellipseMessageShape;
                        j7 = j3;
                        dp7 = dp3;
                        dp8 = dp4;
                        modifier3 = modifier;
                        j8 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                        }
                    });
                }
                i3 |= 24576;
                dp4 = dp2;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= 196608;
                    i9 = i12;
                } else {
                    i9 = i12;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    } else {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                    }
                    if (dp6 == null) {
                        modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                    } else {
                        modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                    }
                    Modifier modifierThen2 = modifier2.then(modifierHeight);
                    if (dp5 == null) {
                        modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                    } else {
                        modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.Surface-F-jzlyU(modifierThen2.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                            }
                            function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    dp7 = dp5;
                    dp8 = dp6;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    } else {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                    }
                    if (dp6 == null) {
                        modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                    } else {
                        modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                    }
                    Modifier modifierThen3 = modifier2.then(modifierHeight);
                    if (dp5 == null) {
                        modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                    } else {
                        modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.Surface-F-jzlyU(modifierThen3.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                            }
                            function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    dp7 = dp5;
                    dp8 = dp6;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            dp3 = dp;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    dp4 = dp2;
                    if (composerStartRestartGroup.changed(dp4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= 196608;
                    i9 = i12;
                } else {
                    i9 = i12;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    } else {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                    }
                    if (dp6 == null) {
                        modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                    } else {
                        modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                    }
                    Modifier modifierThen4 = modifier2.then(modifierHeight);
                    if (dp5 == null) {
                        modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                    } else {
                        modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.Surface-F-jzlyU(modifierThen4.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                            }
                            function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    dp7 = dp5;
                    dp8 = dp6;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    } else {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                    }
                    if (dp6 == null) {
                        modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                    } else {
                        modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                    }
                    Modifier modifierThen5 = modifier2.then(modifierHeight);
                    if (dp5 == null) {
                        modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                    } else {
                        modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.Surface-F-jzlyU(modifierThen5.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                            }
                            function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    dp7 = dp5;
                    dp8 = dp6;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            dp4 = dp2;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= 196608;
                i9 = i12;
            } else {
                i9 = i12;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                } else {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                }
                if (dp6 == null) {
                    modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                } else {
                    modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                }
                Modifier modifierThen6 = modifier2.then(modifierHeight);
                if (dp5 == null) {
                    modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                } else {
                    modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.Surface-F-jzlyU(modifierThen6.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                        }
                        function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                dp7 = dp5;
                dp8 = dp6;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                } else {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                }
                if (dp6 == null) {
                    modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                } else {
                    modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                }
                Modifier modifierThen7 = modifier2.then(modifierHeight);
                if (dp5 == null) {
                    modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                } else {
                    modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.Surface-F-jzlyU(modifierThen7.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                        }
                        function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                dp7 = dp5;
                dp8 = dp6;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i15) {
                    CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        j3 = j;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                dp3 = dp;
                if (composerStartRestartGroup.changed(dp3)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((57344 & i) == 0) {
                    dp4 = dp2;
                    if (composerStartRestartGroup.changed(dp4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= 196608;
                    i9 = i12;
                } else {
                    i9 = i12;
                    if ((i & 458752) == 0) {
                        if (composerStartRestartGroup.changed(j2)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i3 & 2995931) == 599186) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    } else {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                    }
                    if (dp6 == null) {
                        modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                    } else {
                        modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                    }
                    Modifier modifierThen8 = modifier2.then(modifierHeight);
                    if (dp5 == null) {
                        modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                    } else {
                        modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.Surface-F-jzlyU(modifierThen8.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                            }
                            function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    dp7 = dp5;
                    dp8 = dp6;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    } else {
                        if (i9 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        } else {
                            modifier2 = modifier;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                        }
                        if (i14 != 0) {
                            j4 = Color.Companion.getWhite-0d7_KjU();
                        } else {
                            j4 = j3;
                        }
                        if (i4 != 0) {
                            dp3 = null;
                        }
                        if (i6 != 0) {
                            dp4 = null;
                        }
                        if (i8 != 0) {
                            j5 = Color.Companion.getBlack-0d7_KjU();
                        } else {
                            j5 = j2;
                        }
                        dp5 = dp3;
                        dp6 = dp4;
                        shape2 = ellipseMessageShape;
                        j6 = j4;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                    }
                    if (dp6 == null) {
                        modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                    } else {
                        modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                    }
                    Modifier modifierThen9 = modifier2.then(modifierHeight);
                    if (dp5 == null) {
                        modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                    } else {
                        modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.Surface-F-jzlyU(modifierThen9.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            if ((i15 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                            }
                            function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    dp7 = dp5;
                    dp8 = dp6;
                    shape3 = shape2;
                    j7 = j6;
                    j8 = j5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 24576;
            dp4 = dp2;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= 196608;
                i9 = i12;
            } else {
                i9 = i12;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                } else {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                }
                if (dp6 == null) {
                    modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                } else {
                    modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                }
                Modifier modifierThen10 = modifier2.then(modifierHeight);
                if (dp5 == null) {
                    modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                } else {
                    modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.Surface-F-jzlyU(modifierThen10.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                        }
                        function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                dp7 = dp5;
                dp8 = dp6;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                } else {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                }
                if (dp6 == null) {
                    modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                } else {
                    modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                }
                Modifier modifierThen11 = modifier2.then(modifierHeight);
                if (dp5 == null) {
                    modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                } else {
                    modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.Surface-F-jzlyU(modifierThen11.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                        }
                        function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                dp7 = dp5;
                dp8 = dp6;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i15) {
                    CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        dp3 = dp;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((57344 & i) == 0) {
                dp4 = dp2;
                if (composerStartRestartGroup.changed(dp4)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= 196608;
                i9 = i12;
            } else {
                i9 = i12;
                if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(j2)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i3 & 2995931) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                } else {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                }
                if (dp6 == null) {
                    modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                } else {
                    modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                }
                Modifier modifierThen12 = modifier2.then(modifierHeight);
                if (dp5 == null) {
                    modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                } else {
                    modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.Surface-F-jzlyU(modifierThen12.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                        }
                        function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                dp7 = dp5;
                dp8 = dp6;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                } else {
                    if (i9 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    } else {
                        modifier2 = modifier;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                    }
                    if (i14 != 0) {
                        j4 = Color.Companion.getWhite-0d7_KjU();
                    } else {
                        j4 = j3;
                    }
                    if (i4 != 0) {
                        dp3 = null;
                    }
                    if (i6 != 0) {
                        dp4 = null;
                    }
                    if (i8 != 0) {
                        j5 = Color.Companion.getBlack-0d7_KjU();
                    } else {
                        j5 = j2;
                    }
                    dp5 = dp3;
                    dp6 = dp4;
                    shape2 = ellipseMessageShape;
                    j6 = j4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
                }
                if (dp6 == null) {
                    modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
                } else {
                    modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
                }
                Modifier modifierThen13 = modifier2.then(modifierHeight);
                if (dp5 == null) {
                    modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
                } else {
                    modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.Surface-F-jzlyU(modifierThen13.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        if ((i15 & 11) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                        }
                        function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                dp7 = dp5;
                dp8 = dp6;
                shape3 = shape2;
                j7 = j6;
                j8 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i15) {
                    CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 24576;
        dp4 = dp2;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= 196608;
            i9 = i12;
        } else {
            i9 = i12;
            if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(j2)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i10;
            }
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(function2)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i3 & 2995931) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                }
                if (i14 != 0) {
                    j4 = Color.Companion.getWhite-0d7_KjU();
                } else {
                    j4 = j3;
                }
                if (i4 != 0) {
                    dp3 = null;
                }
                if (i6 != 0) {
                    dp4 = null;
                }
                if (i8 != 0) {
                    j5 = Color.Companion.getBlack-0d7_KjU();
                } else {
                    j5 = j2;
                }
                dp5 = dp3;
                dp6 = dp4;
                shape2 = ellipseMessageShape;
                j6 = j4;
            } else {
                if (i9 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                }
                if (i14 != 0) {
                    j4 = Color.Companion.getWhite-0d7_KjU();
                } else {
                    j4 = j3;
                }
                if (i4 != 0) {
                    dp3 = null;
                }
                if (i6 != 0) {
                    dp4 = null;
                }
                if (i8 != 0) {
                    j5 = Color.Companion.getBlack-0d7_KjU();
                } else {
                    j5 = j2;
                }
                dp5 = dp3;
                dp6 = dp4;
                shape2 = ellipseMessageShape;
                j6 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
            }
            if (dp6 == null) {
                modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
            } else {
                modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
            }
            Modifier modifierThen14 = modifier2.then(modifierHeight);
            if (dp5 == null) {
                modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
            } else {
                modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.Surface-F-jzlyU(modifierThen14.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i15) {
                    if ((i15 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                    }
                    function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            dp7 = dp5;
            dp8 = dp6;
            shape3 = shape2;
            j7 = j6;
            j8 = j5;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                }
                if (i14 != 0) {
                    j4 = Color.Companion.getWhite-0d7_KjU();
                } else {
                    j4 = j3;
                }
                if (i4 != 0) {
                    dp3 = null;
                }
                if (i6 != 0) {
                    dp4 = null;
                }
                if (i8 != 0) {
                    j5 = Color.Companion.getBlack-0d7_KjU();
                } else {
                    j5 = j2;
                }
                dp5 = dp3;
                dp6 = dp4;
                shape2 = ellipseMessageShape;
                j6 = j4;
            } else {
                if (i9 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                } else {
                    modifier2 = modifier;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    ellipseMessageShape = new EllipseMessageShape(0.0f, 1, null);
                }
                if (i14 != 0) {
                    j4 = Color.Companion.getWhite-0d7_KjU();
                } else {
                    j4 = j3;
                }
                if (i4 != 0) {
                    dp3 = null;
                }
                if (i6 != 0) {
                    dp4 = null;
                }
                if (i8 != 0) {
                    j5 = Color.Companion.getBlack-0d7_KjU();
                } else {
                    j5 = j2;
                }
                dp5 = dp3;
                dp6 = dp4;
                shape2 = ellipseMessageShape;
                j6 = j4;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-180950365, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox (CoachMarkMessageBox.kt:18)");
            }
            if (dp6 == null) {
                modifierHeight = IntrinsicKt.height(Modifier.Companion, IntrinsicSize.Min);
            } else {
                modifierHeight = SizeKt.height-3ABfNKs(Modifier.Companion, dp6.unbox-impl());
            }
            Modifier modifierThen15 = modifier2.then(modifierHeight);
            if (dp5 == null) {
                modifierWidth = IntrinsicKt.width(Modifier.Companion, IntrinsicSize.Max);
            } else {
                modifierWidth = SizeKt.width-3ABfNKs(Modifier.Companion, dp5.unbox-impl());
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.Surface-F-jzlyU(modifierThen15.then(modifierWidth), shape2, j6, j5, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -932620577, true, new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i15) {
                    if ((i15 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-932620577, i15, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBox.<anonymous> (CoachMarkMessageBox.kt:42)");
                    }
                    function2.invoke(composer3, Integer.valueOf((i3 >> 18) & 14));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, (i3 & 112) | 1572864 | (i3 & 896) | ((i3 >> 6) & 7168), 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            dp7 = dp5;
            dp8 = dp6;
            shape3 = shape2;
            j7 = j6;
            j8 = j5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkMessageBoxKt$CoachMarkMessageBox$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i15) {
                CoachMarkMessageBoxKt.m2238CoachMarkMessageBoxtb54SUI(modifier3, shape3, j7, dp7, dp8, j8, function2, composer3, i | 1, i2);
            }
        });
    }
}
