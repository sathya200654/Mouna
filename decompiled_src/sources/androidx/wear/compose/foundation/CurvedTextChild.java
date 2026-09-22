package androidx.wear.compose.foundation;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BasicCurvedText.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0013\b\u0002\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\r\u0010\u001e\u001a\u00020\u001fH\u0017¢\u0006\u0002\u0010 J*\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0016H\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0016J\f\u0010-\u001a\u00020\u001f*\u00020.H\u0016J\u001a\u0010/\u001a\u00020\u001f*\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0016J\f\u00104\u001a\u00020\u001f*\u000205H\u0016R\u000e\u0010\r\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\t¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/wear/compose/foundation/CurvedTextChild;", "Landroidx/wear/compose/foundation/CurvedChild;", "text", "", "clockwise", "", "style", "Lkotlin/Function0;", "Landroidx/wear/compose/foundation/CurvedTextStyle;", "Landroidx/compose/runtime/Composable;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function2;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "actualStyle", "getClockwise", "()Z", "delegate", "Landroidx/wear/compose/foundation/CurvedTextDelegate;", "getOverflow-gIe3tQ8", "()I", "I", "parentSweepRadians", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "getStyle", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getText", "()Ljava/lang/String;", "SubComposition", "", "(Landroidx/compose/runtime/Composer;I)V", "doAngularPosition", "parentStartAngleRadians", "centerOffset", "Landroidx/compose/ui/geometry/Offset;", "doAngularPosition-0AR0LA0", "(FFJ)F", "doEstimateThickness", "maxRadius", "doRadialPosition", "Landroidx/wear/compose/foundation/PartialLayoutInfo;", "parentOuterRadius", "parentThickness", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "initializeMeasure", "Landroidx/wear/compose/foundation/CurvedMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeIfNeeded", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "compose-foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CurvedTextChild extends CurvedChild {
    public static final int $stable = 8;
    private CurvedTextStyle actualStyle;
    private final boolean clockwise;
    private CurvedTextDelegate delegate;
    private final int overflow;
    private float parentSweepRadians;
    private Placeable placeable;
    private final Function2<Composer, Integer, CurvedTextStyle> style;
    private final String text;

    public /* synthetic */ CurvedTextChild(String str, boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, function2, i);
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getClockwise() {
        return this.clockwise;
    }

    public /* synthetic */ CurvedTextChild(String str, boolean z, AnonymousClass1 anonymousClass1, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? new Function2<Composer, Integer, CurvedTextStyle>() { // from class: androidx.wear.compose.foundation.CurvedTextChild.1
            public final CurvedTextStyle invoke(Composer composer, int i3) {
                composer.startReplaceGroup(1499601625);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1499601625, i3, -1, "androidx.wear.compose.foundation.CurvedTextChild.<init>.<anonymous> (BasicCurvedText.kt:113)");
                }
                CurvedTextStyle curvedTextStyle = new CurvedTextStyle(0L, 0L, 0L, null, null, null, null, 127, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return curvedTextStyle;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((Composer) obj, ((Number) obj2).intValue());
            }
        } : anonymousClass1, i, null);
    }

    public final Function2<Composer, Integer, CurvedTextStyle> getStyle() {
        return this.style;
    }

    /* JADX INFO: renamed from: getOverflow-gIe3tQ8, reason: not valid java name and from getter */
    public final int getOverflow() {
        return this.overflow;
    }

    private CurvedTextChild(String str, boolean z, Function2<? super Composer, ? super Integer, CurvedTextStyle> function2, int i) {
        this.text = str;
        this.clockwise = z;
        this.style = function2;
        this.overflow = i;
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void SubComposition(Composer composer, final int i) {
        int i2;
        CurvedTextDelegate curvedTextDelegate;
        Composer composerStartRestartGroup = composer.startRestartGroup(-420677569);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SubComposition)124@5247L7,126@5346L33,127@5397L174,135@5658L29,135@5635L53:BasicCurvedText.kt#m5emhl");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-420677569, i2, -1, "androidx.wear.compose.foundation.CurvedTextChild.SubComposition (BasicCurvedText.kt:123)");
            }
            this.actualStyle = CurvedTextStyleKt.getDefaultCurvedTextStyles().plus((CurvedTextStyle) this.style.invoke(composerStartRestartGroup, 0));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1736330164, "CC(remember):BasicCurvedText.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new CurvedTextDelegate();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            CurvedTextDelegate curvedTextDelegate2 = (CurvedTextDelegate) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            this.delegate = curvedTextDelegate2;
            if (curvedTextDelegate2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delegate");
                curvedTextDelegate = null;
            } else {
                curvedTextDelegate = curvedTextDelegate2;
            }
            CurvedTextStyle curvedTextStyle = this.actualStyle;
            if (curvedTextStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
                curvedTextStyle = null;
            }
            FontFamily fontFamily = curvedTextStyle.getFontFamily();
            CurvedTextStyle curvedTextStyle2 = this.actualStyle;
            if (curvedTextStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
                curvedTextStyle2 = null;
            }
            FontWeight fontWeight = curvedTextStyle2.getFontWeight();
            CurvedTextStyle curvedTextStyle3 = this.actualStyle;
            if (curvedTextStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
                curvedTextStyle3 = null;
            }
            FontStyle fontStyle = curvedTextStyle3.getFontStyle();
            CurvedTextStyle curvedTextStyle4 = this.actualStyle;
            if (curvedTextStyle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
                curvedTextStyle4 = null;
            }
            curvedTextDelegate.m358UpdateFontIfNeededSyNm_b8(fontFamily, fontWeight, fontStyle, curvedTextStyle4.getFontSynthesis(), composerStartRestartGroup, 0);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1736340144, "CC(remember):BasicCurvedText.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.foundation.CurvedTextChild$SubComposition$2$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.this$0.getText());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(SemanticsModifierKt.semantics$default(modifier, false, (Function1) objRememberedValue2, 1, (Object) null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedTextChild.SubComposition.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CurvedTextChild.this.SubComposition(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void initializeMeasure(CurvedMeasureScope curvedMeasureScope, Iterator<? extends Measurable> it) {
        CurvedTextDelegate curvedTextDelegate = this.delegate;
        CurvedTextDelegate curvedTextDelegate2 = null;
        if (curvedTextDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
            curvedTextDelegate = null;
        }
        String str = this.text;
        boolean z = this.clockwise;
        CurvedTextStyle curvedTextStyle = this.actualStyle;
        if (curvedTextStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
            curvedTextStyle = null;
        }
        curvedTextDelegate.updateIfNeeded(str, z, curvedMeasureScope.m330toPxR2X_6o(curvedTextStyle.getFontSize()));
        CurvedTextDelegate curvedTextDelegate3 = this.delegate;
        if (curvedTextDelegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
            curvedTextDelegate3 = null;
        }
        int iRoundToInt = MathKt.roundToInt(curvedTextDelegate3.getTextHeight());
        float fSqrt = 2 * ((float) Math.sqrt(iRoundToInt * (curvedMeasureScope.getRadius() - (iRoundToInt / 4))));
        CurvedTextDelegate curvedTextDelegate4 = this.delegate;
        if (curvedTextDelegate4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        } else {
            curvedTextDelegate2 = curvedTextDelegate4;
        }
        int iRoundToInt2 = MathKt.roundToInt(RangesKt.coerceAtMost(curvedTextDelegate2.getTextWidth(), fSqrt));
        this.placeable = it.next().measure-BRTryo0(ConstraintsKt.Constraints(iRoundToInt2, iRoundToInt2, iRoundToInt, iRoundToInt));
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public float doEstimateThickness(float maxRadius) {
        CurvedTextDelegate curvedTextDelegate = this.delegate;
        if (curvedTextDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
            curvedTextDelegate = null;
        }
        return curvedTextDelegate.getTextHeight();
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public PartialLayoutInfo doRadialPosition(float parentOuterRadius, float parentThickness) {
        CurvedTextDelegate curvedTextDelegate = this.delegate;
        CurvedTextDelegate curvedTextDelegate2 = null;
        if (curvedTextDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
            curvedTextDelegate = null;
        }
        float baseLinePosition = parentOuterRadius - curvedTextDelegate.getBaseLinePosition();
        CurvedTextDelegate curvedTextDelegate3 = this.delegate;
        if (curvedTextDelegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
            curvedTextDelegate3 = null;
        }
        float textWidth = curvedTextDelegate3.getTextWidth() / baseLinePosition;
        CurvedTextDelegate curvedTextDelegate4 = this.delegate;
        if (curvedTextDelegate4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        } else {
            curvedTextDelegate2 = curvedTextDelegate4;
        }
        return new PartialLayoutInfo(textWidth, parentOuterRadius, curvedTextDelegate2.getTextHeight(), baseLinePosition);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    /* JADX INFO: renamed from: doAngularPosition-0AR0LA0 */
    public float mo234doAngularPosition0AR0LA0(float parentStartAngleRadians, float parentSweepRadians, long centerOffset) {
        this.parentSweepRadians = parentSweepRadians;
        return super.mo234doAngularPosition0AR0LA0(parentStartAngleRadians, parentSweepRadians, centerOffset);
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void draw(DrawScope drawScope) {
        CurvedTextDelegate curvedTextDelegate;
        CurvedTextDelegate curvedTextDelegate2 = this.delegate;
        CurvedTextStyle curvedTextStyle = null;
        if (curvedTextDelegate2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
            curvedTextDelegate = null;
        } else {
            curvedTextDelegate = curvedTextDelegate2;
        }
        CurvedLayoutInfo layoutInfo$compose_foundation_release = getLayoutInfo$compose_foundation_release();
        Intrinsics.checkNotNull(layoutInfo$compose_foundation_release);
        float f = this.parentSweepRadians;
        int i = this.overflow;
        CurvedTextStyle curvedTextStyle2 = this.actualStyle;
        if (curvedTextStyle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
            curvedTextStyle2 = null;
        }
        long color = curvedTextStyle2.getColor();
        CurvedTextStyle curvedTextStyle3 = this.actualStyle;
        if (curvedTextStyle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualStyle");
        } else {
            curvedTextStyle = curvedTextStyle3;
        }
        curvedTextDelegate.m359doDrawmWnK_ns(drawScope, layoutInfo$compose_foundation_release, f, i, color, curvedTextStyle.getBackground());
    }

    @Override // androidx.wear.compose.foundation.CurvedChild
    public void placeIfNeeded(Placeable.PlacementScope placementScope) {
        Placeable placeable = this.placeable;
        if (placeable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("placeable");
            placeable = null;
        }
        CurvedLayoutInfo layoutInfo$compose_foundation_release = getLayoutInfo$compose_foundation_release();
        Intrinsics.checkNotNull(layoutInfo$compose_foundation_release);
        CurvedComposableKt.place(placementScope, placeable, layoutInfo$compose_foundation_release, this.parentSweepRadians, false);
    }
}
