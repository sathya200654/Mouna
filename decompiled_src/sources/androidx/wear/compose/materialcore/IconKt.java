package androidx.wear.compose.materialcore;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "getDefaultIconSizeModifier", "()Landroidx/compose/ui/Modifier;", "Icon", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-Bx497Mc", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;I)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: Icon-Bx497Mc, reason: not valid java name */
    public static final void m909IconBx497Mc(final Painter painter, final String str, final Modifier modifier, final long j, Composer composer, final int i) {
        int i2;
        Modifier modifierSemantics$default;
        Composer composerStartRestartGroup = composer.startRestartGroup(1506380550);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Icon)P(2!,3:c#ui.graphics.Color)58@2339L94,69@2659L253:Icon.kt#f7tims");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1506380550, i3, -1, "androidx.wear.compose.materialcore.Icon (Icon.kt:57)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -936014375, "CC(remember):Icon.kt#9igjgp");
            boolean z = false;
            Object[] objArr = (i3 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objArr == true || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = Color.equals-impl0(j, Color.Companion.getUnspecified-0d7_KjU()) ? null : ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, j, 0, 2, (Object) null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                z = false;
            }
            ColorFilter colorFilter = (ColorFilter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(-936010589);
            ComposerKt.sourceInformation(composerStartRestartGroup, "62@2515L103");
            if (str != null) {
                Modifier modifier2 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -936008734, "CC(remember):Icon.kt#9igjgp");
                boolean z2 = (i3 & 112) == 32 ? true : z;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.materialcore.IconKt$Icon$semantics$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getImage-o7Vup1c());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, z, (Function1) objRememberedValue2, 1, (Object) null);
            } else {
                modifierSemantics$default = Modifier.Companion;
            }
            composerStartRestartGroup.endReplaceGroup();
            BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier), painter), painter, false, (Alignment) null, ContentScale.Companion.getFit(), 0.0f, colorFilter, 22, (Object) null).then(modifierSemantics$default), composerStartRestartGroup, z ? 1 : 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.IconKt$Icon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    IconKt.m909IconBx497Mc(painter, str, modifier, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier modifier2;
        if (Size.equals-impl0(painter.getIntrinsicSize-NH-jbRc(), Size.Companion.getUnspecified-NH-jbRc()) || m910isInfiniteuvyYCjk(painter.getIntrinsicSize-NH-jbRc())) {
            modifier2 = DefaultIconSizeModifier;
        } else {
            modifier2 = (Modifier) Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    /* JADX INFO: renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    public static final boolean m910isInfiniteuvyYCjk(long j) {
        return Float.isInfinite(Size.getWidth-impl(j)) && Float.isInfinite(Size.getHeight-impl(j));
    }

    public static final Modifier getDefaultIconSizeModifier() {
        return DefaultIconSizeModifier;
    }
}
