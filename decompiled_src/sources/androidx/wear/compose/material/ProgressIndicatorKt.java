package androidx.wear.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aX\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a6\u0010\u0011\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a6\u0010\u0019\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0018\u001a\u001f\u0010\u001b\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005H\u0082\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 ²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010\u000e\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "startAngle", "", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "trackColor", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "CircularProgressIndicator-pc5RIQQ", "(Landroidx/compose/ui/Modifier;FJJFLandroidx/compose/runtime/Composer;II)V", "progress", "endAngle", "CircularProgressIndicator-xWeB9-s", "(FLandroidx/compose/ui/Modifier;FFJJFLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "sweep", "color", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-42QJj7c", "minus", "Landroidx/compose/ui/geometry/Size;", "offset", "minus-TmRCtEA", "(JF)J", "compose-material_release", "currentRotation", "", "baseRotation", "startProgressAngle"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProgressIndicatorKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0120  */
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:103:0x0126  */
    /* JADX WARN: Code duplicated, block: B:106:0x012b  */
    /* JADX WARN: Code duplicated, block: B:109:0x0133  */
    /* JADX WARN: Code duplicated, block: B:110:0x013f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0145  */
    /* JADX WARN: Code duplicated, block: B:114:0x0165  */
    /* JADX WARN: Code duplicated, block: B:116:0x0168  */
    /* JADX WARN: Code duplicated, block: B:117:0x0171  */
    /* JADX WARN: Code duplicated, block: B:121:0x017d  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:125:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:128:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:130:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:136:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:144:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:146:0x0200  */
    /* JADX WARN: Code duplicated, block: B:152:0x0212  */
    /* JADX WARN: Code duplicated, block: B:154:0x0218  */
    /* JADX WARN: Code duplicated, block: B:160:0x0226  */
    /* JADX WARN: Code duplicated, block: B:164:0x0233  */
    /* JADX WARN: Code duplicated, block: B:167:0x0262  */
    /* JADX WARN: Code duplicated, block: B:171:0x0271  */
    /* JADX WARN: Code duplicated, block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0065  */
    /* JADX WARN: Code duplicated, block: B:39:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0080  */
    /* JADX WARN: Code duplicated, block: B:50:0x0086  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0093  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:98:0x0119 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x011b  */
    /* JADX INFO: renamed from: CircularProgressIndicator-xWeB9-s, reason: not valid java name */
    public static final void m733CircularProgressIndicatorxWeB9s(final float f, Modifier modifier, float f2, float f3, long j, long j2, float f4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        float f5;
        int i5;
        float f6;
        long j3;
        int i6;
        float fM731getStrokeWidthD9Ej5fM;
        int i7;
        Modifier modifier3;
        float f7;
        long primary;
        long j4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Object objRememberedValue;
        long j5;
        long j6;
        final float f8;
        final long j7;
        final long j8;
        final float f9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(644242391);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)P(3,2,4!1,1:c#ui.graphics.Color,6:c#ui.graphics.Color,5:c#ui.unit.Dp)86@4847L6,87@4901L6,98@5378L827,92@5129L1082:ProgressIndicator.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    f5 = f2;
                    if (composerStartRestartGroup.changed(f5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        f6 = f3;
                        if (composerStartRestartGroup.changed(f6)) {
                            i10 = RecyclerView.ItemAnimator.FLAG_MOVED;
                        }
                        i3 |= i10;
                    } else {
                        f6 = f3;
                    }
                    i10 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    i3 |= i10;
                } else {
                    f6 = f3;
                }
                if ((i & 24576) != 0) {
                    if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j)) {
                        i9 = 8192;
                    } else {
                        i9 = 16384;
                    }
                    i3 |= i9;
                }
                if ((i & 196608) == 0) {
                    j3 = j2;
                    if ((i2 & 32) == 0 || !composerStartRestartGroup.changed(j3)) {
                        i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    } else {
                        i8 = 131072;
                    }
                    i3 |= i8;
                } else {
                    j3 = j2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    fM731getStrokeWidthD9Ej5fM = f4;
                } else {
                    fM731getStrokeWidthD9Ej5fM = f4;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(fM731getStrokeWidthD9Ej5fM)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                if ((i3 & 599187) == 599186 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            f7 = 270.0f;
                        } else {
                            f7 = f5;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            f6 = f7;
                        }
                        if ((i2 & 16) != 0) {
                            primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                            i3 &= -57345;
                        } else {
                            primary = j;
                        }
                        if ((i2 & 32) != 0) {
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            i3 &= -458753;
                        } else {
                            j3 = j3;
                        }
                        if (i6 != 0) {
                            fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                        }
                        j4 = primary;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        modifier3 = modifier2;
                        f7 = f5;
                        j4 = j;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
                    }
                    Modifier modifierFocusable$default = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((i3 & 896) == 256) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z5 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
                    if ((i3 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z6 = z5 | z2;
                    if ((3670016 & i3) == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = z6 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue == Composer.Companion.getEmpty()) {
                        final float f10 = f7;
                        final long j9 = j4;
                        final float f11 = f6;
                        final long j10 = j3;
                        final float f12 = fM731getStrokeWidthD9Ej5fM;
                        j5 = j10;
                        j6 = j9;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                float f13 = 360;
                                final float f14 = 360.0f - ((((f10 - f11) % f13) + f13) % f13);
                                final float fFloatValue = f14 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                                final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f12), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                                final float f15 = f10;
                                final long j11 = j10;
                                final long j12 = j9;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f15, f14, j11, stroke);
                                        ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f15, fFloatValue, j12, stroke);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        j6 = j4;
                        j5 = j3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f8 = f7;
                    j7 = j5;
                    j8 = j6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f8 = f5;
                    j7 = j3;
                    j8 = j;
                }
                f9 = fM731getStrokeWidthD9Ej5fM;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final float f13 = f6;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i12) {
                            ProgressIndicatorKt.m733CircularProgressIndicatorxWeB9s(f, modifier4, f8, f13, j8, j7, f9, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            f5 = f2;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    f6 = f3;
                    if (composerStartRestartGroup.changed(f6)) {
                        i10 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i10;
                } else {
                    f6 = f3;
                }
                i10 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i10;
            } else {
                f6 = f3;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    i9 = 8192;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i & 196608) == 0) {
                j3 = j2;
                if ((i2 & 32) == 0) {
                    i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                } else {
                    i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                fM731getStrokeWidthD9Ej5fM = f4;
            } else {
                fM731getStrokeWidthD9Ej5fM = f4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM731getStrokeWidthD9Ej5fM)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i3 & 599187) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
                }
                Modifier modifierFocusable$default2 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z7 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z8 = z7 | z2;
                if ((3670016 & i3) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z8 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    final float f14 = f7;
                    final long j11 = j4;
                    final float f15 = f6;
                    final long j12 = j3;
                    final float f16 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j12;
                    j6 = j11;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f17 = 360;
                            final float f18 = 360.0f - ((((f14 - f15) % f17) + f17) % f17);
                            final float fFloatValue = f18 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f16), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f19 = f14;
                            final long j13 = j12;
                            final long j14 = j11;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f19, f18, j13, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f19, fFloatValue, j14, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final float f17 = f7;
                    final long j13 = j4;
                    final float f18 = f6;
                    final long j14 = j3;
                    final float f19 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j14;
                    j6 = j13;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f110 = 360;
                            final float f111 = 360.0f - ((((f17 - f18) % f110) + f110) % f110);
                            final float fFloatValue = f111 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f19), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f112 = f17;
                            final long j15 = j14;
                            final long j16 = j13;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f112, f111, j15, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f112, fFloatValue, j16, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default2, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f8 = f7;
                j7 = j5;
                j8 = j6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
                }
                Modifier modifierFocusable$default3 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z9 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z10 = z9 | z2;
                if ((3670016 & i3) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z10 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    final float f110 = f7;
                    final long j15 = j4;
                    final float f111 = f6;
                    final long j16 = j3;
                    final float f112 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j16;
                    j6 = j15;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f113 = 360;
                            final float f114 = 360.0f - ((((f110 - f111) % f113) + f113) % f113);
                            final float fFloatValue = f114 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f112), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f115 = f110;
                            final long j17 = j16;
                            final long j18 = j15;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f115, f114, j17, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f115, fFloatValue, j18, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final float f113 = f7;
                    final long j17 = j4;
                    final float f114 = f6;
                    final long j18 = j3;
                    final float f115 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j18;
                    j6 = j17;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f116 = 360;
                            final float f117 = 360.0f - ((((f113 - f114) % f116) + f116) % f116);
                            final float fFloatValue = f117 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f115), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f118 = f113;
                            final long j19 = j18;
                            final long j110 = j17;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f118, f117, j19, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f118, fFloatValue, j110, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f8 = f7;
                j7 = j5;
                j8 = j6;
            }
            f9 = fM731getStrokeWidthD9Ej5fM;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier3;
                final float f116 = f6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        ProgressIndicatorKt.m733CircularProgressIndicatorxWeB9s(f, modifier5, f8, f116, j8, j7, f9, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                f5 = f2;
                if (composerStartRestartGroup.changed(f5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    f6 = f3;
                    if (composerStartRestartGroup.changed(f6)) {
                        i10 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i10;
                } else {
                    f6 = f3;
                }
                i10 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i10;
            } else {
                f6 = f3;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    i9 = 8192;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i & 196608) == 0) {
                j3 = j2;
                if ((i2 & 32) == 0) {
                    i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                } else {
                    i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i8;
            } else {
                j3 = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                fM731getStrokeWidthD9Ej5fM = f4;
            } else {
                fM731getStrokeWidthD9Ej5fM = f4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(fM731getStrokeWidthD9Ej5fM)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            if ((i3 & 599187) == 599186) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
                }
                Modifier modifierFocusable$default4 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z11 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z12 = z11 | z2;
                if ((3670016 & i3) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z12 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    final float f117 = f7;
                    final long j19 = j4;
                    final float f118 = f6;
                    final long j110 = j3;
                    final float f119 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j110;
                    j6 = j19;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f1110 = 360;
                            final float f1111 = 360.0f - ((((f117 - f118) % f1110) + f1110) % f1110);
                            final float fFloatValue = f1111 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f119), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f1112 = f117;
                            final long j111 = j110;
                            final long j112 = j19;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f1112, f1111, j111, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f1112, fFloatValue, j112, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final float f1110 = f7;
                    final long j111 = j4;
                    final float f1111 = f6;
                    final long j112 = j3;
                    final float f1112 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j112;
                    j6 = j111;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f1113 = 360;
                            final float f1114 = 360.0f - ((((f1110 - f1111) % f1113) + f1113) % f1113);
                            final float fFloatValue = f1114 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f1112), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f1115 = f1110;
                            final long j113 = j112;
                            final long j114 = j111;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f1115, f1114, j113, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f1115, fFloatValue, j114, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default4, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f8 = f7;
                j7 = j5;
                j8 = j6;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                } else {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        f7 = 270.0f;
                    } else {
                        f7 = f5;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        f6 = f7;
                    }
                    if ((i2 & 16) != 0) {
                        primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                        i3 &= -57345;
                    } else {
                        primary = j;
                    }
                    if ((i2 & 32) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -458753;
                    } else {
                        j3 = j3;
                    }
                    if (i6 != 0) {
                        fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                    }
                    j4 = primary;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
                }
                Modifier modifierFocusable$default5 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i3 & 896) == 256) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z13 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
                if ((i3 & 14) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z14 = z13 | z2;
                if ((3670016 & i3) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z14 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z4) {
                    final float f1113 = f7;
                    final long j113 = j4;
                    final float f1114 = f6;
                    final long j114 = j3;
                    final float f1115 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j114;
                    j6 = j113;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f1116 = 360;
                            final float f1117 = 360.0f - ((((f1113 - f1114) % f1116) + f1116) % f1116);
                            final float fFloatValue = f1117 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f1115), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f1118 = f1113;
                            final long j115 = j114;
                            final long j116 = j113;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f1118, f1117, j115, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f1118, fFloatValue, j116, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    final float f1116 = f7;
                    final long j115 = j4;
                    final float f1117 = f6;
                    final long j116 = j3;
                    final float f1118 = fM731getStrokeWidthD9Ej5fM;
                    j5 = j116;
                    j6 = j115;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            float f1119 = 360;
                            final float f11110 = 360.0f - ((((f1116 - f1117) % f1119) + f1119) % f1119);
                            final float fFloatValue = f11110 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f1118), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            final float f11111 = f1116;
                            final long j117 = j116;
                            final long j118 = j115;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f11111, f11110, j117, stroke);
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f11111, fFloatValue, j118, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default5, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f8 = f7;
                j7 = j5;
                j8 = j6;
            }
            f9 = fM731getStrokeWidthD9Ej5fM;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier3;
                final float f1119 = f6;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        ProgressIndicatorKt.m733CircularProgressIndicatorxWeB9s(f, modifier6, f8, f1119, j8, j7, f9, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        f5 = f2;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                f6 = f3;
                if (composerStartRestartGroup.changed(f6)) {
                    i10 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i10;
            } else {
                f6 = f3;
            }
            i10 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i10;
        } else {
            f6 = f3;
        }
        if ((i & 24576) != 0) {
            if ((i2 & 16) == 0) {
                i9 = 8192;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((i & 196608) == 0) {
            j3 = j2;
            if ((i2 & 32) == 0) {
                i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            } else {
                i8 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i3 |= i8;
        } else {
            j3 = j2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            fM731getStrokeWidthD9Ej5fM = f4;
        } else {
            fM731getStrokeWidthD9Ej5fM = f4;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(fM731getStrokeWidthD9Ej5fM)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        if ((i3 & 599187) == 599186) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f7 = 270.0f;
                } else {
                    f7 = f5;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    f6 = f7;
                }
                if ((i2 & 16) != 0) {
                    primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                    i3 &= -57345;
                } else {
                    primary = j;
                }
                if ((i2 & 32) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -458753;
                } else {
                    j3 = j3;
                }
                if (i6 != 0) {
                    fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                }
                j4 = primary;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f7 = 270.0f;
                } else {
                    f7 = f5;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    f6 = f7;
                }
                if ((i2 & 16) != 0) {
                    primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                    i3 &= -57345;
                } else {
                    primary = j;
                }
                if ((i2 & 32) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -458753;
                } else {
                    j3 = j3;
                }
                if (i6 != 0) {
                    fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                }
                j4 = primary;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
            }
            Modifier modifierFocusable$default6 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z = true;
            } else {
                z = false;
            }
            boolean z15 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z16 = z15 | z2;
            if ((3670016 & i3) == 1048576) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = z16 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4) {
                final float f11110 = f7;
                final long j117 = j4;
                final float f11111 = f6;
                final long j118 = j3;
                final float f11112 = fM731getStrokeWidthD9Ej5fM;
                j5 = j118;
                j6 = j117;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        float f11113 = 360;
                        final float f11114 = 360.0f - ((((f11110 - f11111) % f11113) + f11113) % f11113);
                        final float fFloatValue = f11114 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f11112), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        final float f11115 = f11110;
                        final long j119 = j118;
                        final long j1110 = j117;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f11115, f11114, j119, stroke);
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f11115, fFloatValue, j1110, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final float f11113 = f7;
                final long j119 = j4;
                final float f11114 = f6;
                final long j1110 = j3;
                final float f11115 = fM731getStrokeWidthD9Ej5fM;
                j5 = j1110;
                j6 = j119;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        float f11116 = 360;
                        final float f11117 = 360.0f - ((((f11113 - f11114) % f11116) + f11116) % f11116);
                        final float fFloatValue = f11117 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f11115), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        final float f11118 = f11113;
                        final long j1111 = j1110;
                        final long j1112 = j119;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f11118, f11117, j1111, stroke);
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f11118, fFloatValue, j1112, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default6, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f8 = f7;
            j7 = j5;
            j8 = j6;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f7 = 270.0f;
                } else {
                    f7 = f5;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    f6 = f7;
                }
                if ((i2 & 16) != 0) {
                    primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                    i3 &= -57345;
                } else {
                    primary = j;
                }
                if ((i2 & 32) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -458753;
                } else {
                    j3 = j3;
                }
                if (i6 != 0) {
                    fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                }
                j4 = primary;
            } else {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    f7 = 270.0f;
                } else {
                    f7 = f5;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    f6 = f7;
                }
                if ((i2 & 16) != 0) {
                    primary = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getPrimary();
                    i3 &= -57345;
                } else {
                    primary = j;
                }
                if ((i2 & 32) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -458753;
                } else {
                    j3 = j3;
                }
                if (i6 != 0) {
                    fM731getStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m731getStrokeWidthD9Ej5fM();
                }
                j4 = primary;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(644242391, i3, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:89)");
            }
            Modifier modifierFocusable$default7 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics$default(modifier3, Math.round(100 * f) / 100.0f, (ClosedFloatingPointRange) null, 0, 6, (Object) null), ProgressIndicatorDefaults.INSTANCE.m727x22647636()), false, (MutableInteractionSource) null, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1792072195, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i3 & 896) == 256) {
                z = true;
            } else {
                z = false;
            }
            boolean z17 = z | ((((i3 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(f6)) || (i3 & 3072) == 2048);
            if ((i3 & 14) == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z18 = z17 | z2;
            if ((3670016 & i3) == 1048576) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = z18 | z3 | ((((458752 & i3) ^ 196608) <= 131072 && composerStartRestartGroup.changed(j3)) || (i3 & 196608) == 131072) | ((((57344 & i3) ^ 24576) <= 16384 && composerStartRestartGroup.changed(j4)) || (i3 & 24576) == 16384);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z4) {
                final float f11116 = f7;
                final long j1111 = j4;
                final float f11117 = f6;
                final long j1112 = j3;
                final float f11118 = fM731getStrokeWidthD9Ej5fM;
                j5 = j1112;
                j6 = j1111;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        float f11119 = 360;
                        final float f111110 = 360.0f - ((((f11116 - f11117) % f11119) + f11119) % f11119);
                        final float fFloatValue = f111110 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f11118), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        final float f111111 = f11116;
                        final long j1113 = j1112;
                        final long j1114 = j1111;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f111111, f111110, j1113, stroke);
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f111111, fFloatValue, j1114, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                final float f11119 = f7;
                final long j1113 = j4;
                final float f111110 = f6;
                final long j1114 = j3;
                final float f111111 = fM731getStrokeWidthD9Ej5fM;
                j5 = j1114;
                j6 = j1113;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        float f111112 = 360;
                        final float f111113 = 360.0f - ((((f11119 - f111110) % f111112) + f111112) % f111112);
                        final float fFloatValue = f111113 * ((Number) RangesKt.coerceIn(Float.valueOf(f), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(f111111), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        final float f111114 = f11119;
                        final long j1115 = j1114;
                        final long j1116 = j1113;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f111114, f111113, j1115, stroke);
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, f111114, fFloatValue, j1116, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default7, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f8 = f7;
            j7 = j5;
            j8 = j6;
        }
        f9 = fM731getStrokeWidthD9Ej5fM;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final float f11120 = f6;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i12) {
                    ProgressIndicatorKt.m733CircularProgressIndicatorxWeB9s(f, modifier7, f8, f11120, j8, j7, f9, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:103:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:109:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:111:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:117:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:121:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:124:0x0317  */
    /* JADX WARN: Code duplicated, block: B:128:0x0327  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:86:0x011f  */
    /* JADX WARN: Code duplicated, block: B:87:0x012e  */
    /* JADX WARN: Code duplicated, block: B:90:0x013f  */
    /* JADX WARN: Code duplicated, block: B:93:0x0287  */
    /* JADX WARN: Code duplicated, block: B:94:0x028a  */
    /* JADX WARN: Code duplicated, block: B:97:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:98:0x02a3  */
    /* JADX INFO: renamed from: CircularProgressIndicator-pc5RIQQ, reason: not valid java name */
    public static final void m732CircularProgressIndicatorpc5RIQQ(Modifier modifier, float f, long j, long j2, float f2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f3;
        long j3;
        int i4;
        float f4;
        int i5;
        final Modifier modifier3;
        long onBackground;
        int i6;
        final float f5;
        long j4;
        long j5;
        final float fM730getIndeterminateStrokeWidthD9Ej5fM;
        final long j6;
        final State stateAnimateValue;
        final State stateAnimateFloat;
        final State stateAnimateFloat2;
        final State stateAnimateFloat3;
        boolean z;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        final long j7;
        final long j8;
        final float f6;
        final float f7;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(576911639);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularProgressIndicator)P(1,2,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.unit.Dp)148@7619L6,149@7678L6,153@7800L28,155@7958L278,167@8351L230,178@8699L346,190@9088L355,210@9748L879,204@9568L1060:ProgressIndicator.kt#gj9v0t");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                f3 = f;
                i3 |= composerStartRestartGroup.changed(f3) ? 32 : 16;
            }
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0 || !composerStartRestartGroup.changed(j)) {
                    i8 = 128;
                } else {
                    i8 = 256;
                }
                i3 |= i8;
            }
            if ((i & 3072) == 0) {
                j3 = j2;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j3)) {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                } else {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i7;
            } else {
                j3 = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    f4 = f2;
                    if (composerStartRestartGroup.changed(f4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i10 != 0) {
                            f3 = 270.0f;
                        }
                        if ((i2 & 4) != 0) {
                            onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                            i3 &= -897;
                        } else {
                            onBackground = j;
                        }
                        if ((i2 & 8) != 0) {
                            j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                            i6 = i3;
                            f5 = f3;
                            j4 = j3;
                            j5 = onBackground;
                        } else {
                            i6 = i3;
                            f5 = f3;
                            j4 = j3;
                            j5 = onBackground;
                            fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        modifier3 = modifier2;
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                        j5 = j;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
                    }
                    InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
                    j6 = j4;
                    boolean z4 = true;
                    stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                    stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                            keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                            keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                        }
                    }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                            keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                            keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                        }
                    }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier modifierFocusable$default = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((57344 & i6) == 16384) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean zChanged = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
                    if ((i6 & 112) == 32) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean zChanged2 = zChanged | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
                    if ((((i6 & 896) ^ 384) > 256 || !composerStartRestartGroup.changed(j5)) && (i6 & 384) != 256) {
                    }
                    z3 = zChanged2 | z4;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue == Composer.Companion.getEmpty()) {
                        j7 = j5;
                        objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                                final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                                float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                                final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                                final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                                final long j10 = j6;
                                final long j11 = j7;
                                final State<Float> state = stateAnimateFloat3;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        DrawScope drawScope = (DrawScope) contentDrawScope;
                                        ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                        ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                    }
                                });
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        j7 = j5;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j8 = j6;
                    f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
                    f7 = f5;
                    j9 = j7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    f7 = f3;
                    j8 = j3;
                    f6 = f4;
                    j9 = j;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            ProgressIndicatorKt.m732CircularProgressIndicatorpc5RIQQ(modifier3, f7, j9, j8, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            f4 = f2;
            if ((i3 & 9363) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
                j6 = j4;
                boolean z5 = true;
                stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition2, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition2, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier modifierFocusable$default2 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((57344 & i6) == 16384) {
                    z = true;
                } else {
                    z = false;
                }
                boolean zChanged3 = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
                if ((i6 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean zChanged4 = zChanged3 | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
                z5 = ((i6 & 896) ^ 384) > 256 ? false : false;
                z3 = zChanged4 | z5;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default2, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j6;
                f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
                f7 = f5;
                j9 = j7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition3 = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
                j6 = j4;
                boolean z6 = true;
                stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition3, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition3, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier modifierFocusable$default3 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((57344 & i6) == 16384) {
                    z = true;
                } else {
                    z = false;
                }
                boolean zChanged5 = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
                if ((i6 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean zChanged6 = zChanged5 | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
                if (((i6 & 896) ^ 384) > 256) {
                }
                z3 = zChanged6 | z6;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default3, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j6;
                f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
                f7 = f5;
                j9 = j7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        ProgressIndicatorKt.m732CircularProgressIndicatorpc5RIQQ(modifier3, f7, j9, j8, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        f3 = f;
        if ((i & 384) != 0) {
            if ((i2 & 4) == 0) {
                i8 = 128;
            } else {
                i8 = 128;
            }
            i3 |= i8;
        }
        if ((i & 3072) == 0) {
            j3 = j2;
            if ((i2 & 8) == 0) {
                i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            } else {
                i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i3 |= i7;
        } else {
            j3 = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                f4 = f2;
                if (composerStartRestartGroup.changed(f4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((i3 & 9363) == 9362) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition4 = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
                j6 = j4;
                boolean z7 = true;
                stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition4, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition4, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier modifierFocusable$default4 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((57344 & i6) == 16384) {
                    z = true;
                } else {
                    z = false;
                }
                boolean zChanged7 = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
                if ((i6 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean zChanged8 = zChanged7 | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
                if (((i6 & 896) ^ 384) > 256) {
                }
                z3 = zChanged8 | z7;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default4, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j6;
                f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
                f7 = f5;
                j9 = j7;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                } else {
                    if (i9 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i10 != 0) {
                        f3 = 270.0f;
                    }
                    if ((i2 & 4) != 0) {
                        onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                        i3 &= -897;
                    } else {
                        onBackground = j;
                    }
                    if ((i2 & 8) != 0) {
                        j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                    } else {
                        i6 = i3;
                        f5 = f3;
                        j4 = j3;
                        j5 = onBackground;
                        fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
                }
                InfiniteTransition infiniteTransitionRememberInfiniteTransition5 = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
                j6 = j4;
                boolean z8 = true;
                stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition5, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition5, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition5, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition5, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                        keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                        keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                    }
                }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier modifierFocusable$default5 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((57344 & i6) == 16384) {
                    z = true;
                } else {
                    z = false;
                }
                boolean zChanged9 = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
                if ((i6 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean zChanged10 = zChanged9 | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
                if (((i6 & 896) ^ 384) > 256) {
                }
                z3 = zChanged10 | z8;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    j7 = j5;
                    objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                            float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                            final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                            final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                            final long j10 = j6;
                            final long j11 = j7;
                            final State<Float> state = stateAnimateFloat3;
                            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    DrawScope drawScope = (DrawScope) contentDrawScope;
                                    ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                    ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                                }
                            });
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default5, (Function1) objRememberedValue), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j8 = j6;
                f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
                f7 = f5;
                j9 = j7;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        ProgressIndicatorKt.m732CircularProgressIndicatorpc5RIQQ(modifier3, f7, j9, j8, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        f4 = f2;
        if ((i3 & 9363) == 9362) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    f3 = 270.0f;
                }
                if ((i2 & 4) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i3 &= -897;
                } else {
                    onBackground = j;
                }
                if ((i2 & 8) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                } else {
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                    fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    f3 = 270.0f;
                }
                if ((i2 & 4) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i3 &= -897;
                } else {
                    onBackground = j;
                }
                if ((i2 & 8) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                } else {
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                    fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition6 = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
            j6 = j4;
            boolean z9 = true;
            stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition6, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition6, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition6, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                    keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                    keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                }
            }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition6, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                    keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                    keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                }
            }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifierFocusable$default6 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((57344 & i6) == 16384) {
                z = true;
            } else {
                z = false;
            }
            boolean zChanged11 = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
            if ((i6 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean zChanged12 = zChanged11 | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
            if (((i6 & 896) ^ 384) > 256) {
            }
            z3 = zChanged12 | z9;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3) {
                j7 = j5;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                        final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                        final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                        final long j10 = j6;
                        final long j11 = j7;
                        final State<Float> state = stateAnimateFloat3;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                j7 = j5;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                        final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                        final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                        final long j10 = j6;
                        final long j11 = j7;
                        final State<Float> state = stateAnimateFloat3;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default6, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j8 = j6;
            f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
            f7 = f5;
            j9 = j7;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    f3 = 270.0f;
                }
                if ((i2 & 4) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i3 &= -897;
                } else {
                    onBackground = j;
                }
                if ((i2 & 8) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                } else {
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                    fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                }
            } else {
                if (i9 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i10 != 0) {
                    f3 = 270.0f;
                }
                if ((i2 & 4) != 0) {
                    onBackground = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground();
                    i3 &= -897;
                } else {
                    onBackground = j;
                }
                if ((i2 & 8) != 0) {
                    j3 = Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnBackground(), 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM730getIndeterminateStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m730getIndeterminateStrokeWidthD9Ej5fM();
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                } else {
                    i6 = i3;
                    f5 = f3;
                    j4 = j3;
                    j5 = onBackground;
                    fM730getIndeterminateStrokeWidthD9Ej5fM = f4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(576911639, i6, -1, "androidx.wear.compose.material.CircularProgressIndicator (ProgressIndicator.kt:152)");
            }
            InfiniteTransition infiniteTransitionRememberInfiniteTransition7 = InfiniteTransitionKt.rememberInfiniteTransition((String) null, composerStartRestartGroup, 0, 1);
            j6 = j4;
            boolean z10 = true;
            stateAnimateValue = InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition7, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
            stateAnimateFloat = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition7, 0.0f, 286.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ProgressIndicatorDefaults.RotationDuration, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            stateAnimateFloat2 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition7, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                    keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 0), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                    keyframesSpecConfig.at(Float.valueOf(290.0f), 666);
                }
            }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            stateAnimateFloat3 = InfiniteTransitionKt.animateFloat(infiniteTransitionRememberInfiniteTransition7, 0.0f, 290.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startProgressAngle$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    keyframesSpecConfig.setDurationMillis(ProgressIndicatorDefaults.RotationDuration);
                    keyframesSpecConfig.using(keyframesSpecConfig.at(Float.valueOf(0.0f), 666), ProgressIndicatorDefaults.INSTANCE.getCircularEasing$compose_material_release());
                    keyframesSpecConfig.at(Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                }
            }), (RepeatMode) null, 0L, 6, (Object) null), (String) null, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifierFocusable$default7 = FocusableKt.focusable$default(SizeKt.size-3ABfNKs(ProgressSemanticsKt.progressSemantics(modifier3), ProgressIndicatorDefaults.INSTANCE.m729x1ee816d3()), false, (MutableInteractionSource) null, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1791932303, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((57344 & i6) == 16384) {
                z = true;
            } else {
                z = false;
            }
            boolean zChanged13 = z | composerStartRestartGroup.changed(stateAnimateValue) | composerStartRestartGroup.changed(stateAnimateFloat2) | composerStartRestartGroup.changed(stateAnimateFloat3);
            if ((i6 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean zChanged14 = zChanged13 | z2 | composerStartRestartGroup.changed(stateAnimateFloat) | ((((i6 & 7168) ^ 3072) <= 2048 && composerStartRestartGroup.changed(j6)) || (i6 & 3072) == 2048);
            if (((i6 & 896) ^ 384) > 256) {
            }
            z3 = zChanged14 | z10;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3) {
                j7 = j5;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                        final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                        final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                        final long j10 = j6;
                        final long j11 = j7;
                        final State<Float> state = stateAnimateFloat3;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                j7 = j5;
                objRememberedValue = (Function1) new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                        final Stroke stroke = new Stroke(cacheDrawScope.toPx-0680j_4(fM730getIndeterminateStrokeWidthD9Ej5fM), 0.0f, StrokeCap.Companion.getRound-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null);
                        float fCircularProgressIndicator_pc5RIQQ$lambda$1 = (ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$1(stateAnimateValue) * 216.0f) % 360.0f;
                        final float fAbs = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$3(stateAnimateFloat2) - ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(stateAnimateFloat3));
                        final float fCircularProgressIndicator_pc5RIQQ$lambda$2 = ((f5 + fCircularProgressIndicator_pc5RIQQ$lambda$1) + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$2(stateAnimateFloat)) % 360.0f;
                        final long j10 = j6;
                        final long j11 = j7;
                        final State<Float> state = stateAnimateFloat3;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                DrawScope drawScope = (DrawScope) contentDrawScope;
                                ProgressIndicatorKt.m736drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j10, stroke);
                                ProgressIndicatorKt.m737drawIndeterminateCircularIndicator42QJj7c(drawScope, fCircularProgressIndicator_pc5RIQQ$lambda$2 + ProgressIndicatorKt.CircularProgressIndicator_pc5RIQQ$lambda$4(state), fAbs, j11, stroke);
                            }
                        });
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(DrawModifierKt.drawWithCache(modifierFocusable$default7, (Function1) objRememberedValue), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j8 = j6;
            f6 = fM730getIndeterminateStrokeWidthD9Ej5fM;
            f7 = f5;
            j9 = j7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    ProgressIndicatorKt.m732CircularProgressIndicatorpc5RIQQ(modifier3, f7, j9, j8, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m736drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float fMin = Math.min(Size.getWidth-impl(drawScope.getSize-NH-jbRc()), Size.getHeight-impl(drawScope.getSize-NH-jbRc()));
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float f4 = fMin - (f3 * width);
        DrawScope.drawArc-yD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(((Size.getWidth-impl(drawScope.getSize-NH-jbRc()) - fMin) / f3) + width, width + ((Size.getHeight-impl(drawScope.getSize-NH-jbRc()) - fMin) / f3)), androidx.compose.ui.geometry.SizeKt.Size(f4, f4), 0.0f, (DrawStyle) stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: drawIndeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m737drawIndeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m736drawCircularIndicator42QJj7c(drawScope, f, Math.max(f2, 0.1f), j, stroke);
    }

    /* JADX INFO: renamed from: minus-TmRCtEA, reason: not valid java name */
    private static final long m738minusTmRCtEA(long j, float f) {
        return androidx.compose.ui.geometry.SizeKt.Size(Size.getWidth-impl(j) - f, Size.getHeight-impl(j) - f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CircularProgressIndicator_pc5RIQQ$lambda$1(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_pc5RIQQ$lambda$2(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_pc5RIQQ$lambda$3(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CircularProgressIndicator_pc5RIQQ$lambda$4(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }
}
