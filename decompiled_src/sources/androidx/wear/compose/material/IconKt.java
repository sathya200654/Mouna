package androidx.wear.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000e\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0011\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconKt {
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0077  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:68:0x0102  */
    /* JADX WARN: Code duplicated, block: B:71:0x0127  */
    /* JADX WARN: Code duplicated, block: B:75:0x0132  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m604Iconww6aTOc(final ImageVector imageVector, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        Modifier modifier2;
        long j2;
        Modifier modifier3;
        long j3;
        Modifier modifier4;
        final Modifier modifier5;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1097004402);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)P(1!,3:c#ui.graphics.Color)46@1983L7,46@2022L7,49@2063L34,48@2039L163:Icon.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(imageVector) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                j2 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                } else {
                    i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i4;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j5 = ((Color) objConsume).unbox-impl();
                        CompositionLocal localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -7169;
                        modifier4 = modifier3;
                        j3 = Color.copy-wmQWz5c$default(j5, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    } else {
                        j3 = j2;
                        modifier4 = modifier3;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    j3 = j2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1097004402, i3, -1, "androidx.wear.compose.material.Icon (Icon.kt:47)");
                }
                m603Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i3 & 14), str2, modifier4, j3, composerStartRestartGroup, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j4 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.IconKt$Icon$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        IconKt.m604Iconww6aTOc(imageVector, str, modifier5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            j2 = j;
            if ((i2 & 8) == 0) {
                i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            } else {
                i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i3 |= i4;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j6 = ((Color) objConsume3).unbox-impl();
                    CompositionLocal localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localContentAlpha2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j6, ((Number) objConsume4).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j7 = ((Color) objConsume5).unbox-impl();
                    CompositionLocal localContentAlpha3 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localContentAlpha3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j7, ((Number) objConsume6).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097004402, i3, -1, "androidx.wear.compose.material.Icon (Icon.kt:47)");
            }
            m603Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i3 & 14), str2, modifier4, j3, composerStartRestartGroup, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j4 = j3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor4 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localContentColor4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j8 = ((Color) objConsume7).unbox-impl();
                    CompositionLocal localContentAlpha4 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localContentAlpha4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j8, ((Number) objConsume8).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor5 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localContentColor5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j9 = ((Color) objConsume9).unbox-impl();
                    CompositionLocal localContentAlpha5 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localContentAlpha5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j9, ((Number) objConsume10).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097004402, i3, -1, "androidx.wear.compose.material.Icon (Icon.kt:47)");
            }
            m603Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, composerStartRestartGroup, i3 & 14), str2, modifier4, j3, composerStartRestartGroup, VectorPainter.$stable | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j4 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.IconKt$Icon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    IconKt.m604Iconww6aTOc(imageVector, str, modifier5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:70:0x0106  */
    /* JADX WARN: Code duplicated, block: B:73:0x011e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0126  */
    /* JADX WARN: Code duplicated, block: B:78:0x014a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0155  */
    /* JADX WARN: Code duplicated, block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m602Iconww6aTOc(final ImageBitmap imageBitmap, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        int i3;
        String str2;
        Modifier modifier2;
        long j2;
        Modifier modifier3;
        int i4;
        Modifier modifier4;
        long j3;
        boolean zChanged;
        Object objRememberedValue;
        final Modifier modifier5;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i5;
        Composer composerStartRestartGroup = composer.startRestartGroup(1793743366);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)P(!,3:c#ui.graphics.Color)74@3071L7,74@3110L7,76@3141L42,77@3188L136:Icon.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(imageBitmap) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    j2 = j;
                    if (composerStartRestartGroup.changed(j2)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i5;
                } else {
                    j2 = j;
                }
                i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i5;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j5 = ((Color) objConsume).unbox-impl();
                        CompositionLocal localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i4 = i3 & (-7169);
                        modifier4 = modifier3;
                        j3 = Color.copy-wmQWz5c$default(j5, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    } else {
                        i4 = i3;
                        modifier4 = modifier3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1793743366, i4, -1, "androidx.wear.compose.material.Icon (Icon.kt:75)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920179228, "CC(remember):Icon.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(imageBitmap);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                        BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                        composerStartRestartGroup.updateRememberedValue(bitmapPainter);
                        objRememberedValue = bitmapPainter;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m603Iconww6aTOc((Painter) objRememberedValue, str2, modifier4, j3, composerStartRestartGroup, i4 & 8176, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier5 = modifier4;
                    j4 = j3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    i4 = i3;
                    modifier4 = modifier2;
                }
                j3 = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1793743366, i4, -1, "androidx.wear.compose.material.Icon (Icon.kt:75)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920179228, "CC(remember):Icon.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(imageBitmap);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    BitmapPainter bitmapPainter2 = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                    composerStartRestartGroup.updateRememberedValue(bitmapPainter2);
                    objRememberedValue = bitmapPainter2;
                } else {
                    BitmapPainter bitmapPainter3 = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                    composerStartRestartGroup.updateRememberedValue(bitmapPainter3);
                    objRememberedValue = bitmapPainter3;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m603Iconww6aTOc((Painter) objRememberedValue, str2, modifier4, j3, composerStartRestartGroup, i4 & 8176, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j4 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.IconKt$Icon$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        IconKt.m602Iconww6aTOc(imageBitmap, str, modifier5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i5;
            } else {
                j2 = j;
            }
            i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i5;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j6 = ((Color) objConsume3).unbox-impl();
                    CompositionLocal localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localContentAlpha2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 = i3 & (-7169);
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j6, ((Number) objConsume4).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    i4 = i3;
                    modifier4 = modifier3;
                    j3 = j2;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j7 = ((Color) objConsume5).unbox-impl();
                    CompositionLocal localContentAlpha3 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localContentAlpha3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 = i3 & (-7169);
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j7, ((Number) objConsume6).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    i4 = i3;
                    modifier4 = modifier3;
                    j3 = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1793743366, i4, -1, "androidx.wear.compose.material.Icon (Icon.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920179228, "CC(remember):Icon.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(imageBitmap);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                BitmapPainter bitmapPainter4 = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                composerStartRestartGroup.updateRememberedValue(bitmapPainter4);
                objRememberedValue = bitmapPainter4;
            } else {
                BitmapPainter bitmapPainter5 = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                composerStartRestartGroup.updateRememberedValue(bitmapPainter5);
                objRememberedValue = bitmapPainter5;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m603Iconww6aTOc((Painter) objRememberedValue, str2, modifier4, j3, composerStartRestartGroup, i4 & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j4 = j3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor4 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localContentColor4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j8 = ((Color) objConsume7).unbox-impl();
                    CompositionLocal localContentAlpha4 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localContentAlpha4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 = i3 & (-7169);
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j8, ((Number) objConsume8).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    i4 = i3;
                    modifier4 = modifier3;
                    j3 = j2;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor5 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localContentColor5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j9 = ((Color) objConsume9).unbox-impl();
                    CompositionLocal localContentAlpha5 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localContentAlpha5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 = i3 & (-7169);
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j9, ((Number) objConsume10).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    i4 = i3;
                    modifier4 = modifier3;
                    j3 = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1793743366, i4, -1, "androidx.wear.compose.material.Icon (Icon.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1920179228, "CC(remember):Icon.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(imageBitmap);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                BitmapPainter bitmapPainter6 = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                composerStartRestartGroup.updateRememberedValue(bitmapPainter6);
                objRememberedValue = bitmapPainter6;
            } else {
                BitmapPainter bitmapPainter7 = new BitmapPainter(imageBitmap, 0L, 0L, 6, (DefaultConstructorMarker) null);
                composerStartRestartGroup.updateRememberedValue(bitmapPainter7);
                objRememberedValue = bitmapPainter7;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m603Iconww6aTOc((Painter) objRememberedValue, str2, modifier4, j3, composerStartRestartGroup, i4 & 8176, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j4 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.IconKt$Icon$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    IconKt.m602Iconww6aTOc(imageBitmap, str, modifier5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:68:0x0107  */
    /* JADX WARN: Code duplicated, block: B:71:0x0119  */
    /* JADX WARN: Code duplicated, block: B:75:0x0124  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m603Iconww6aTOc(final Painter painter, final String str, Modifier modifier, long j, Composer composer, final int i, final int i2) {
        Painter painter2;
        int i3;
        String str2;
        Modifier modifier2;
        long j2;
        Modifier modifier3;
        long j3;
        Modifier modifier4;
        final Modifier modifier5;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-100365115);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)P(2!,3:c#ui.graphics.Color)103@4191L7,103@4230L7,106@4341L136:Icon.kt#gj9v0t");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            painter2 = painter;
        } else if ((i & 6) == 0) {
            painter2 = painter;
            i3 = (composerStartRestartGroup.changedInstance(painter2) ? 4 : 2) | i;
        } else {
            painter2 = painter;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            str2 = str;
        } else {
            str2 = str;
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                j2 = j;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(j2)) {
                    i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                } else {
                    i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i4;
            } else {
                j2 = j;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if ((i2 & 8) != 0) {
                        CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j5 = ((Color) objConsume).unbox-impl();
                        CompositionLocal localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localContentAlpha);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i3 &= -7169;
                        modifier4 = modifier3;
                        j3 = Color.copy-wmQWz5c$default(j5, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    } else {
                        j3 = j2;
                        modifier4 = modifier3;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    j3 = j2;
                    modifier4 = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-100365115, i3, -1, "androidx.wear.compose.material.Icon (Icon.kt:104)");
                }
                androidx.wear.compose.materialcore.IconKt.m909IconBx497Mc(painter2, str2, modifier4, j3, composerStartRestartGroup, i3 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier5 = modifier4;
                j4 = j3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier2;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.IconKt$Icon$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        IconKt.m603Iconww6aTOc(painter, str, modifier5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            j2 = j;
            if ((i2 & 8) == 0) {
                i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            } else {
                i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i3 |= i4;
        } else {
            j2 = j;
        }
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor2 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j6 = ((Color) objConsume3).unbox-impl();
                    CompositionLocal localContentAlpha2 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localContentAlpha2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j6, ((Number) objConsume4).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor3 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume5 = composerStartRestartGroup.consume(localContentColor3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j7 = ((Color) objConsume5).unbox-impl();
                    CompositionLocal localContentAlpha3 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localContentAlpha3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j7, ((Number) objConsume6).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-100365115, i3, -1, "androidx.wear.compose.material.Icon (Icon.kt:104)");
            }
            androidx.wear.compose.materialcore.IconKt.m909IconBx497Mc(painter2, str2, modifier4, j3, composerStartRestartGroup, i3 & 8190);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j4 = j3;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor4 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localContentColor4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j8 = ((Color) objConsume7).unbox-impl();
                    CompositionLocal localContentAlpha4 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume8 = composerStartRestartGroup.consume(localContentAlpha4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j8, ((Number) objConsume8).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if ((i2 & 8) != 0) {
                    CompositionLocal localContentColor5 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume9 = composerStartRestartGroup.consume(localContentColor5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j9 = ((Color) objConsume9).unbox-impl();
                    CompositionLocal localContentAlpha5 = ContentAlphaKt.getLocalContentAlpha();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localContentAlpha5);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i3 &= -7169;
                    modifier4 = modifier3;
                    j3 = Color.copy-wmQWz5c$default(j9, ((Number) objConsume10).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                } else {
                    j3 = j2;
                    modifier4 = modifier3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-100365115, i3, -1, "androidx.wear.compose.material.Icon (Icon.kt:104)");
            }
            androidx.wear.compose.materialcore.IconKt.m909IconBx497Mc(painter2, str2, modifier4, j3, composerStartRestartGroup, i3 & 8190);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier5 = modifier4;
            j4 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.IconKt$Icon$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    IconKt.m603Iconww6aTOc(painter, str, modifier5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
