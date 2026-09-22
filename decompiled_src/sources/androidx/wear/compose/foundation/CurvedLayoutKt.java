package androidx.wear.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.protobuf.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CurvedLayout.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0004\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u001b\u001a,\u0010\u001c\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00050\rH\u0000\u001a\f\u0010 \u001a\u00020\u0005*\u00020\u0005H\u0000\u001a\f\u0010!\u001a\u00020\u0005*\u00020\u0005H\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"CurvedLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "anchor", "", "anchorType", "Landroidx/wear/compose/foundation/AnchorType;", "radialAlignment", "Landroidx/wear/compose/foundation/CurvedAlignment$Radial;", "angularDirection", "Landroidx/wear/compose/foundation/CurvedDirection$Angular;", "contentBuilder", "Lkotlin/Function1;", "Landroidx/wear/compose/foundation/CurvedScope;", "Lkotlin/ExtensionFunctionType;", "CurvedLayout-z6uKIlA", "(Landroidx/compose/ui/Modifier;FFLandroidx/wear/compose/foundation/CurvedAlignment$Radial;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "initialCurvedLayoutDirection", "Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "angular", "initialCurvedLayoutDirection-XMJfWBM", "(ILandroidx/compose/runtime/Composer;I)Landroidx/wear/compose/foundation/CurvedLayoutDirection;", "offsetFromDistanceAndAngle", "Landroidx/compose/ui/geometry/Offset;", "distance", "angle", "(FF)J", "sumOf", "T", "", "selector", "toDegrees", "toRadians", "compose-foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CurvedLayoutKt {
    public static final float toDegrees(float f) {
        return (f * 180.0f) / 3.1415927f;
    }

    public static final float toRadians(float f) {
        return (f * 3.1415927f) / 180.0f;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0163  */
    /* JADX WARN: Code duplicated, block: B:101:0x0165  */
    /* JADX WARN: Code duplicated, block: B:104:0x016e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0176  */
    /* JADX WARN: Code duplicated, block: B:109:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:112:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:116:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:118:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:121:0x0228  */
    /* JADX WARN: Code duplicated, block: B:124:0x0233  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:91:0x0127  */
    /* JADX WARN: Code duplicated, block: B:93:0x012f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0159  */
    /* JADX WARN: Code duplicated, block: B:97:0x015b  */
    /* JADX INFO: renamed from: CurvedLayout-z6uKIlA, reason: not valid java name */
    public static final void m321CurvedLayoutz6uKIlA(Modifier modifier, float f, float f2, CurvedAlignment.Radial radial, int i, final Function1<? super CurvedScope, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        final float f3;
        int i5;
        final float fM221getCenterIUldqTk;
        int i6;
        int i7;
        CurvedAlignment.Radial radial2;
        int i8;
        int i9;
        int iM292getNormalgmlPZk4;
        int i10;
        int i11;
        Modifier modifier3;
        final CurvedLayoutDirection curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM;
        final CurvedRowChild curvedRowChild;
        boolean zChanged;
        Object objRememberedValue;
        boolean z;
        boolean z2;
        boolean z3;
        MeasurePolicy measurePolicyRememberedValue;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        final float f4;
        final int i12;
        final float f5;
        final CurvedAlignment.Radial radial3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1074057563);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CurvedLayout)P(4!1,1:androidx.wear.compose.foundation.AnchorType,5:androidx.wear.compose.foundation.CurvedAlignment.Radial,2:androidx.wear.compose.foundation.CurvedDirection.Angular)109@4416L46,117@4881L81,125@5045L1661,116@4829L1877:CurvedLayout.kt#m5emhl");
        int i13 = i3 & 1;
        if (i13 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i14 = i3 & 2;
        if (i14 == 0) {
            if ((i2 & 48) == 0) {
                f3 = f;
                i4 |= composerStartRestartGroup.changed(f3) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    fM221getCenterIUldqTk = f2;
                    if (composerStartRestartGroup.changed(fM221getCenterIUldqTk)) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    if ((i2 & 3072) == 0) {
                        radial2 = radial;
                        if (composerStartRestartGroup.changed(radial2)) {
                            i8 = RecyclerView.ItemAnimator.FLAG_MOVED;
                        } else {
                            i8 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 16;
                    if (i9 != 0) {
                        if ((i2 & 24576) == 0) {
                            iM292getNormalgmlPZk4 = i;
                            if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                                i10 = 16384;
                            } else {
                                i10 = 8192;
                            }
                            i4 |= i10;
                        }
                        if ((i3 & 32) != 0) {
                            i4 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i11 = 131072;
                            } else {
                                i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i4 |= i11;
                        }
                        if ((i4 & 74899) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            if (i13 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i14 != 0) {
                                f3 = 270.0f;
                            }
                            if (i5 != 0) {
                                fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                            }
                            DefaultConstructorMarker defaultConstructorMarker = null;
                            if (i7 != 0) {
                                radial2 = null;
                            }
                            if (i9 != 0) {
                                iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                            }
                            curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                            curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(curvedRowChild);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ContentDrawScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ContentDrawScope contentDrawScope) {
                                        curvedRowChild.draw((DrawScope) contentDrawScope);
                                        contentDrawScope.drawContent();
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierDrawWithContent = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                            boolean zChanged2 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                            if ((i4 & 112) == 32) {
                                z = true;
                            } else {
                                z = false;
                            }
                            boolean z4 = zChanged2 | z;
                            if ((i4 & 896) == 256) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z3 = z4 | z2;
                            measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3 || measurePolicyRememberedValue == Composer.Companion.getEmpty()) {
                                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                        if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                            throw new IllegalArgumentException("either height or width should be bounded".toString());
                                        }
                                        boolean z5 = Constraints.getHasBoundedWidth-impl(j);
                                        int i15 = Reader.READ_DONE;
                                        int i16 = z5 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                        if (Constraints.getHasBoundedHeight-impl(j)) {
                                            i15 = Constraints.getMaxHeight-impl(j);
                                        }
                                        int iMin = Math.min(i16, i15);
                                        float f6 = iMin / 2.0f;
                                        CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                        CurvedRowChild curvedRowChild2 = curvedRowChild;
                                        Iterator<? extends Measurable> it = list.iterator();
                                        curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                        if (it.hasNext()) {
                                            throw new IllegalArgumentException("unused measurable".toString());
                                        }
                                        curvedRowChild.estimateThickness(f6);
                                        CurvedRowChild curvedRowChild3 = curvedRowChild;
                                        curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                        float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                        curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                        final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                        return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                curvedRowChild4.placeIfNeeded(placementScope);
                                            }
                                        }, 4, (Object) null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent);
                            constructor = ComposeUiNode.Companion.getConstructor();
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
                            composer2 = Updater.constructor-impl(composerStartRestartGroup);
                            Updater.set-impl(composer2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                            curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                        }
                        f4 = f3;
                        i12 = iM292getNormalgmlPZk4;
                        f5 = fM221getCenterIUldqTk;
                        radial3 = radial2;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i15) {
                                    CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier4, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                        }
                    }
                    i4 |= 24576;
                    iM292getNormalgmlPZk4 = i;
                    if ((i3 & 32) != 0) {
                        i4 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i11 = 131072;
                        } else {
                            i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i11;
                    }
                    if ((i4 & 74899) == 74898) {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker2 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker2);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent2 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged3 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z5 = zChanged3 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z5 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z6 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z6 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z6 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z6 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent2);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker3 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker3);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent3 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged4 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z6 = zChanged4 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z6 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z7 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z7 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z7 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z7 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy3 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent3);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f4 = f3;
                    i12 = iM292getNormalgmlPZk4;
                    f5 = fM221getCenterIUldqTk;
                    radial3 = radial2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier5 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier5, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 3072;
                radial2 = radial;
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((i2 & 24576) == 0) {
                        iM292getNormalgmlPZk4 = i;
                        if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    if ((i3 & 32) != 0) {
                        i4 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i11 = 131072;
                        } else {
                            i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i11;
                    }
                    if ((i4 & 74899) == 74898) {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker4 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker4);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent4 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged5 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z7 = zChanged5 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z7 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z8 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z8 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z8 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z8 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy4 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent4);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker5 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker5);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent5 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged6 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z8 = zChanged6 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z8 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z9 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z9 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z9 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z9 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy5 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent5);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f4 = f3;
                    i12 = iM292getNormalgmlPZk4;
                    f5 = fM221getCenterIUldqTk;
                    radial3 = radial2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier6 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier6, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 24576;
                iM292getNormalgmlPZk4 = i;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) == 74898) {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker6 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent6 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged7 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z9 = zChanged7 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z9 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z10 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z10 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z10 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z10 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy6 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent6);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker7 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent7 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged8 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z10 = zChanged8 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z10 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z11 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z11 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z11 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z11 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy7 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent7);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f4 = f3;
                i12 = iM292getNormalgmlPZk4;
                f5 = fM221getCenterIUldqTk;
                radial3 = radial2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier7 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier7, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 384;
            fM221getCenterIUldqTk = f2;
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    radial2 = radial;
                    if (composerStartRestartGroup.changed(radial2)) {
                        i8 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i8 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((i2 & 24576) == 0) {
                        iM292getNormalgmlPZk4 = i;
                        if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    if ((i3 & 32) != 0) {
                        i4 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i11 = 131072;
                        } else {
                            i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i11;
                    }
                    if ((i4 & 74899) == 74898) {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker8 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker8);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent8 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged9 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z11 = zChanged9 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z11 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z12 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z12 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z12 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z12 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy8 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent8);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker9 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker9);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent9 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged10 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z12 = zChanged10 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z12 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z13 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z13 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z13 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z13 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy9 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent9);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy9, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f4 = f3;
                    i12 = iM292getNormalgmlPZk4;
                    f5 = fM221getCenterIUldqTk;
                    radial3 = radial2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier8 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier8, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 24576;
                iM292getNormalgmlPZk4 = i;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) == 74898) {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker10 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker10);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent10 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged11 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z13 = zChanged11 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z13 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z14 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z14 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z14 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z14 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy10 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent10);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy10, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker11 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker11);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent11 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged12 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z14 = zChanged12 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z14 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z15 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z15 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z15 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z15 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy11 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent11);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy11, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap11, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier11, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f4 = f3;
                i12 = iM292getNormalgmlPZk4;
                f5 = fM221getCenterIUldqTk;
                radial3 = radial2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier9 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier9, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 3072;
            radial2 = radial;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((i2 & 24576) == 0) {
                    iM292getNormalgmlPZk4 = i;
                    if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) == 74898) {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker12 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker12);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent12 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged13 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z15 = zChanged13 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z15 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z16 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z16 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z16 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z16 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy12 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent12);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy12, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier12, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker13 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker13);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent13 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged14 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z16 = zChanged14 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z16 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z17 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z17 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z17 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z17 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy13 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent13);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy13, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap13, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier13, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f4 = f3;
                i12 = iM292getNormalgmlPZk4;
                f5 = fM221getCenterIUldqTk;
                radial3 = radial2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier10 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier10, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 24576;
            iM292getNormalgmlPZk4 = i;
            if ((i3 & 32) != 0) {
                i4 |= 196608;
            } else if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) == 74898) {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker14 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker14);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent14 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged15 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z17 = zChanged15 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z17 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z18 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z18 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z18 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z18 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy14 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent14);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy14, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier14, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker15 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker15);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent15 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged16 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z18 = zChanged16 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z18 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z19 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z19 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z19 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z19 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy15 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent15);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy15, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap15, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier15, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f4 = f3;
            i12 = iM292getNormalgmlPZk4;
            f5 = fM221getCenterIUldqTk;
            radial3 = radial2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier11 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier11, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 48;
        f3 = f;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 384) == 0) {
                fM221getCenterIUldqTk = f2;
                if (composerStartRestartGroup.changed(fM221getCenterIUldqTk)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    radial2 = radial;
                    if (composerStartRestartGroup.changed(radial2)) {
                        i8 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i8 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((i2 & 24576) == 0) {
                        iM292getNormalgmlPZk4 = i;
                        if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    if ((i3 & 32) != 0) {
                        i4 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i11 = 131072;
                        } else {
                            i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i4 |= i11;
                    }
                    if ((i4 & 74899) == 74898) {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker16 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker16);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent16 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged17 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z19 = zChanged17 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z19 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z110 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z110 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z110 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z110 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy16 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent16);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy16, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap16, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier16, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        if (i13 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i14 != 0) {
                            f3 = 270.0f;
                        }
                        if (i5 != 0) {
                            fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                        }
                        DefaultConstructorMarker defaultConstructorMarker17 = null;
                        if (i7 != 0) {
                            radial2 = null;
                        }
                        if (i9 != 0) {
                            iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                        }
                        curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                        curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker17);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(curvedRowChild);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    curvedRowChild.draw((DrawScope) contentDrawScope);
                                    contentDrawScope.drawContent();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierDrawWithContent17 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                        boolean zChanged18 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                        if ((i4 & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        boolean z110 = zChanged18 | z;
                        if ((i4 & 896) == 256) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z110 | z2;
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z111 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z111 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        } else {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                                /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                                public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                    if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                        throw new IllegalArgumentException("either height or width should be bounded".toString());
                                    }
                                    boolean z111 = Constraints.getHasBoundedWidth-impl(j);
                                    int i15 = Reader.READ_DONE;
                                    int i16 = z111 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                    if (Constraints.getHasBoundedHeight-impl(j)) {
                                        i15 = Constraints.getMaxHeight-impl(j);
                                    }
                                    int iMin = Math.min(i16, i15);
                                    float f6 = iMin / 2.0f;
                                    CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                    CurvedRowChild curvedRowChild2 = curvedRowChild;
                                    Iterator<? extends Measurable> it = list.iterator();
                                    curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                    if (it.hasNext()) {
                                        throw new IllegalArgumentException("unused measurable".toString());
                                    }
                                    curvedRowChild.estimateThickness(f6);
                                    CurvedRowChild curvedRowChild3 = curvedRowChild;
                                    curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                    float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                    curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                    final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                    return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            curvedRowChild4.placeIfNeeded(placementScope);
                                        }
                                    }, 4, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy17 = (MeasurePolicy) measurePolicyRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent17);
                        constructor = ComposeUiNode.Companion.getConstructor();
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
                        composer2 = Updater.constructor-impl(composerStartRestartGroup);
                        Updater.set-impl(composer2, measurePolicy17, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(composer2, currentCompositionLocalMap17, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!composer2.getInserting()) {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.set-impl(composer2, modifierMaterializeModifier17, ComposeUiNode.Companion.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                        curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    f4 = f3;
                    i12 = iM292getNormalgmlPZk4;
                    f5 = fM221getCenterIUldqTk;
                    radial3 = radial2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier12 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i15) {
                                CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier12, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                    }
                }
                i4 |= 24576;
                iM292getNormalgmlPZk4 = i;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) == 74898) {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker18 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker18);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent18 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged19 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z111 = zChanged19 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z111 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z112 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z112 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z112 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z112 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy18 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent18);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy18, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap18, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier18, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker19 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker19);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent19 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged110 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z112 = zChanged110 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z112 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z113 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z113 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z113 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z113 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy19 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent19);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy19, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap19, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier19, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f4 = f3;
                i12 = iM292getNormalgmlPZk4;
                f5 = fM221getCenterIUldqTk;
                radial3 = radial2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier13 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier13, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 3072;
            radial2 = radial;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((i2 & 24576) == 0) {
                    iM292getNormalgmlPZk4 = i;
                    if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) == 74898) {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker110 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker110);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent110 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged111 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z113 = zChanged111 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z113 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z114 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z114 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z114 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z114 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy110 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent110);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy110, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap110, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier110, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker111 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker111);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent111 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged112 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z114 = zChanged112 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z114 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z115 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z115 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z115 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z115 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy111 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent111);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy111, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap111, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier111, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f4 = f3;
                i12 = iM292getNormalgmlPZk4;
                f5 = fM221getCenterIUldqTk;
                radial3 = radial2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier14 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier14, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 24576;
            iM292getNormalgmlPZk4 = i;
            if ((i3 & 32) != 0) {
                i4 |= 196608;
            } else if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) == 74898) {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker112 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker112);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent112 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged113 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z115 = zChanged113 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z115 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z116 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z116 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z116 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z116 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy112 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent112);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy112, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap112, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier112, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker113 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker113);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent113 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged114 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z116 = zChanged114 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z116 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z117 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z117 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z117 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z117 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy113 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent113);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy113, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap113, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier113, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f4 = f3;
            i12 = iM292getNormalgmlPZk4;
            f5 = fM221getCenterIUldqTk;
            radial3 = radial2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier15 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier15, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 384;
        fM221getCenterIUldqTk = f2;
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((i2 & 3072) == 0) {
                radial2 = radial;
                if (composerStartRestartGroup.changed(radial2)) {
                    i8 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i8 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i4 |= i8;
            }
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((i2 & 24576) == 0) {
                    iM292getNormalgmlPZk4 = i;
                    if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) == 74898) {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker114 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker114);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent114 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged115 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z117 = zChanged115 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z117 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z118 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z118 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z118 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z118 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy114 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent114);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy114, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap114, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier114, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    if (i13 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i14 != 0) {
                        f3 = 270.0f;
                    }
                    if (i5 != 0) {
                        fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                    }
                    DefaultConstructorMarker defaultConstructorMarker115 = null;
                    if (i7 != 0) {
                        radial2 = null;
                    }
                    if (i9 != 0) {
                        iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                    }
                    curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                    curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker115);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(curvedRowChild);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                curvedRowChild.draw((DrawScope) contentDrawScope);
                                contentDrawScope.drawContent();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierDrawWithContent115 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                    boolean zChanged116 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                    if ((i4 & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    boolean z118 = zChanged116 | z;
                    if ((i4 & 896) == 256) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z118 | z2;
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z119 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z119 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    } else {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                            public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                    throw new IllegalArgumentException("either height or width should be bounded".toString());
                                }
                                boolean z119 = Constraints.getHasBoundedWidth-impl(j);
                                int i15 = Reader.READ_DONE;
                                int i16 = z119 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                                if (Constraints.getHasBoundedHeight-impl(j)) {
                                    i15 = Constraints.getMaxHeight-impl(j);
                                }
                                int iMin = Math.min(i16, i15);
                                float f6 = iMin / 2.0f;
                                CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                                CurvedRowChild curvedRowChild2 = curvedRowChild;
                                Iterator<? extends Measurable> it = list.iterator();
                                curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                                if (it.hasNext()) {
                                    throw new IllegalArgumentException("unused measurable".toString());
                                }
                                curvedRowChild.estimateThickness(f6);
                                CurvedRowChild curvedRowChild3 = curvedRowChild;
                                curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                                float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                                curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                                final CurvedRowChild curvedRowChild4 = curvedRowChild;
                                return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        curvedRowChild4.placeIfNeeded(placementScope);
                                    }
                                }, 4, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                    }
                    MeasurePolicy measurePolicy115 = (MeasurePolicy) measurePolicyRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent115);
                    constructor = ComposeUiNode.Companion.getConstructor();
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
                    composer2 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer2, measurePolicy115, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap115, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting()) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier115, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                    curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                f4 = f3;
                i12 = iM292getNormalgmlPZk4;
                f5 = fM221getCenterIUldqTk;
                radial3 = radial2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier16 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i15) {
                            CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier16, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                }
            }
            i4 |= 24576;
            iM292getNormalgmlPZk4 = i;
            if ((i3 & 32) != 0) {
                i4 |= 196608;
            } else if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) == 74898) {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker116 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker116);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent116 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged117 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z119 = zChanged117 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z119 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1110 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1110 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1110 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1110 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy116 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent116);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy116, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap116, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier116, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker117 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker117);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent117 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged118 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z1110 = zChanged118 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z1110 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1111 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1111 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1111 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1111 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy117 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent117);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy117, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap117, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier117, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f4 = f3;
            i12 = iM292getNormalgmlPZk4;
            f5 = fM221getCenterIUldqTk;
            radial3 = radial2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier17 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier17, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 3072;
        radial2 = radial;
        i9 = i3 & 16;
        if (i9 != 0) {
            if ((i2 & 24576) == 0) {
                iM292getNormalgmlPZk4 = i;
                if (composerStartRestartGroup.changed(iM292getNormalgmlPZk4)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i4 |= i10;
            }
            if ((i3 & 32) != 0) {
                i4 |= 196608;
            } else if ((i2 & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) == 74898) {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker118 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker118);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent118 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged119 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z1111 = zChanged119 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z1111 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1112 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1112 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1112 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1112 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy118 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent118);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy118, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap118, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier118, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (i13 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i14 != 0) {
                    f3 = 270.0f;
                }
                if (i5 != 0) {
                    fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
                }
                DefaultConstructorMarker defaultConstructorMarker119 = null;
                if (i7 != 0) {
                    radial2 = null;
                }
                if (i9 != 0) {
                    iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
                }
                curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
                curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker119);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(curvedRowChild);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ContentDrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ContentDrawScope contentDrawScope) {
                            curvedRowChild.draw((DrawScope) contentDrawScope);
                            contentDrawScope.drawContent();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierDrawWithContent119 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
                boolean zChanged1110 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
                if ((i4 & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                boolean z1112 = zChanged1110 | z;
                if ((i4 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z1112 | z2;
                measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1113 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1113 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                        public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                            if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                                throw new IllegalArgumentException("either height or width should be bounded".toString());
                            }
                            boolean z1113 = Constraints.getHasBoundedWidth-impl(j);
                            int i15 = Reader.READ_DONE;
                            int i16 = z1113 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                            if (Constraints.getHasBoundedHeight-impl(j)) {
                                i15 = Constraints.getMaxHeight-impl(j);
                            }
                            int iMin = Math.min(i16, i15);
                            float f6 = iMin / 2.0f;
                            CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                            CurvedRowChild curvedRowChild2 = curvedRowChild;
                            Iterator<? extends Measurable> it = list.iterator();
                            curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                            if (it.hasNext()) {
                                throw new IllegalArgumentException("unused measurable".toString());
                            }
                            curvedRowChild.estimateThickness(f6);
                            CurvedRowChild curvedRowChild3 = curvedRowChild;
                            curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                            float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                            curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                            final CurvedRowChild curvedRowChild4 = curvedRowChild;
                            return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    curvedRowChild4.placeIfNeeded(placementScope);
                                }
                            }, 4, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                }
                MeasurePolicy measurePolicy119 = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent119);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                composer2 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer2, measurePolicy119, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap119, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.set-impl(composer2, modifierMaterializeModifier119, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
                curvedRowChild.SubComposition(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            f4 = f3;
            i12 = iM292getNormalgmlPZk4;
            f5 = fM221getCenterIUldqTk;
            radial3 = radial2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier18 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i15) {
                        CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier18, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 24576;
        iM292getNormalgmlPZk4 = i;
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i2 & 196608) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i11 = 131072;
            } else {
                i11 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i4 |= i11;
        }
        if ((i4 & 74899) == 74898) {
            if (i13 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i14 != 0) {
                f3 = 270.0f;
            }
            if (i5 != 0) {
                fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
            }
            DefaultConstructorMarker defaultConstructorMarker1110 = null;
            if (i7 != 0) {
                radial2 = null;
            }
            if (i9 != 0) {
                iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
            }
            curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
            curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker1110);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(curvedRowChild);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ContentDrawScope contentDrawScope) {
                        curvedRowChild.draw((DrawScope) contentDrawScope);
                        contentDrawScope.drawContent();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ContentDrawScope contentDrawScope) {
                        curvedRowChild.draw((DrawScope) contentDrawScope);
                        contentDrawScope.drawContent();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawWithContent1110 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
            boolean zChanged1111 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
            if ((i4 & 112) == 32) {
                z = true;
            } else {
                z = false;
            }
            boolean z1113 = zChanged1111 | z;
            if ((i4 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z1113 | z2;
            measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                    public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                            throw new IllegalArgumentException("either height or width should be bounded".toString());
                        }
                        boolean z1114 = Constraints.getHasBoundedWidth-impl(j);
                        int i15 = Reader.READ_DONE;
                        int i16 = z1114 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                        if (Constraints.getHasBoundedHeight-impl(j)) {
                            i15 = Constraints.getMaxHeight-impl(j);
                        }
                        int iMin = Math.min(i16, i15);
                        float f6 = iMin / 2.0f;
                        CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                        CurvedRowChild curvedRowChild2 = curvedRowChild;
                        Iterator<? extends Measurable> it = list.iterator();
                        curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                        if (it.hasNext()) {
                            throw new IllegalArgumentException("unused measurable".toString());
                        }
                        curvedRowChild.estimateThickness(f6);
                        CurvedRowChild curvedRowChild3 = curvedRowChild;
                        curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                        float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                        curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                        final CurvedRowChild curvedRowChild4 = curvedRowChild;
                        return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                curvedRowChild4.placeIfNeeded(placementScope);
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            } else {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                    public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                            throw new IllegalArgumentException("either height or width should be bounded".toString());
                        }
                        boolean z1114 = Constraints.getHasBoundedWidth-impl(j);
                        int i15 = Reader.READ_DONE;
                        int i16 = z1114 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                        if (Constraints.getHasBoundedHeight-impl(j)) {
                            i15 = Constraints.getMaxHeight-impl(j);
                        }
                        int iMin = Math.min(i16, i15);
                        float f6 = iMin / 2.0f;
                        CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                        CurvedRowChild curvedRowChild2 = curvedRowChild;
                        Iterator<? extends Measurable> it = list.iterator();
                        curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                        if (it.hasNext()) {
                            throw new IllegalArgumentException("unused measurable".toString());
                        }
                        curvedRowChild.estimateThickness(f6);
                        CurvedRowChild curvedRowChild3 = curvedRowChild;
                        curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                        float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                        curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                        final CurvedRowChild curvedRowChild4 = curvedRowChild;
                        return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                curvedRowChild4.placeIfNeeded(placementScope);
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy1110 = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent1110);
            constructor = ComposeUiNode.Companion.getConstructor();
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
            composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicy1110, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap1110, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier1110, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
            curvedRowChild.SubComposition(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            if (i13 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i14 != 0) {
                f3 = 270.0f;
            }
            if (i5 != 0) {
                fM221getCenterIUldqTk = AnchorType.INSTANCE.m221getCenterIUldqTk();
            }
            DefaultConstructorMarker defaultConstructorMarker1111 = null;
            if (i7 != 0) {
                radial2 = null;
            }
            if (i9 != 0) {
                iM292getNormalgmlPZk4 = CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1074057563, i4, -1, "androidx.wear.compose.foundation.CurvedLayout (CurvedLayout.kt:106)");
            }
            curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM = m322initialCurvedLayoutDirectionXMJfWBM(iM292getNormalgmlPZk4, composerStartRestartGroup, (i4 >> 12) & 14);
            curvedRowChild = new CurvedRowChild(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, radial2, function1, defaultConstructorMarker1111);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457426971, "CC(remember):CurvedLayout.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(curvedRowChild);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ContentDrawScope contentDrawScope) {
                        curvedRowChild.draw((DrawScope) contentDrawScope);
                        contentDrawScope.drawContent();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<ContentDrawScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$1$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((ContentDrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(ContentDrawScope contentDrawScope) {
                        curvedRowChild.draw((DrawScope) contentDrawScope);
                        contentDrawScope.drawContent();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierDrawWithContent1111 = DrawModifierKt.drawWithContent(modifier3, (Function1) objRememberedValue);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -457420143, "CC(remember):CurvedLayout.kt#9igjgp");
            boolean zChanged1112 = composerStartRestartGroup.changed(curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM) | composerStartRestartGroup.changed(curvedRowChild);
            if ((i4 & 112) == 32) {
                z = true;
            } else {
                z = false;
            }
            boolean z1114 = zChanged1112 | z;
            if ((i4 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z1114 | z2;
            measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                    public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                            throw new IllegalArgumentException("either height or width should be bounded".toString());
                        }
                        boolean z1115 = Constraints.getHasBoundedWidth-impl(j);
                        int i15 = Reader.READ_DONE;
                        int i16 = z1115 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                        if (Constraints.getHasBoundedHeight-impl(j)) {
                            i15 = Constraints.getMaxHeight-impl(j);
                        }
                        int iMin = Math.min(i16, i15);
                        float f6 = iMin / 2.0f;
                        CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                        CurvedRowChild curvedRowChild2 = curvedRowChild;
                        Iterator<? extends Measurable> it = list.iterator();
                        curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                        if (it.hasNext()) {
                            throw new IllegalArgumentException("unused measurable".toString());
                        }
                        curvedRowChild.estimateThickness(f6);
                        CurvedRowChild curvedRowChild3 = curvedRowChild;
                        curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                        float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                        curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                        final CurvedRowChild curvedRowChild4 = curvedRowChild;
                        return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                curvedRowChild4.placeIfNeeded(placementScope);
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            } else {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1
                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                    public final MeasureResult m323measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        if (!Constraints.getHasBoundedHeight-impl(j) && !Constraints.getHasBoundedWidth-impl(j)) {
                            throw new IllegalArgumentException("either height or width should be bounded".toString());
                        }
                        boolean z1115 = Constraints.getHasBoundedWidth-impl(j);
                        int i15 = Reader.READ_DONE;
                        int i16 = z1115 ? Constraints.getMaxWidth-impl(j) : Integer.MAX_VALUE;
                        if (Constraints.getHasBoundedHeight-impl(j)) {
                            i15 = Constraints.getMaxHeight-impl(j);
                        }
                        int iMin = Math.min(i16, i15);
                        float f6 = iMin / 2.0f;
                        CurvedMeasureScope curvedMeasureScope = new CurvedMeasureScope((Density) measureScope, curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM, f6);
                        CurvedRowChild curvedRowChild2 = curvedRowChild;
                        Iterator<? extends Measurable> it = list.iterator();
                        curvedRowChild2.initializeMeasure(curvedMeasureScope, it);
                        if (it.hasNext()) {
                            throw new IllegalArgumentException("unused measurable".toString());
                        }
                        curvedRowChild.estimateThickness(f6);
                        CurvedRowChild curvedRowChild3 = curvedRowChild;
                        curvedRowChild3.radialPosition(f6, curvedRowChild3.getEstimatedThickness());
                        float sweepRadians$compose_foundation_release = curvedRowChild.getSweepRadians$compose_foundation_release();
                        curvedRowChild.m276angularPosition0AR0LA0(CurvedLayoutKt.toRadians(f3) - ((curvedLayoutDirectionM322initialCurvedLayoutDirectionXMJfWBM.clockwise() ? fM221getCenterIUldqTk : 1.0f - fM221getCenterIUldqTk) * sweepRadians$compose_foundation_release), sweepRadians$compose_foundation_release, OffsetKt.Offset(f6, f6));
                        final CurvedRowChild curvedRowChild4 = curvedRowChild;
                        return MeasureScope.layout$default(measureScope, iMin, iMin, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$2$1.3
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                curvedRowChild4.placeIfNeeded(placementScope);
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy1111 = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierDrawWithContent1111);
            constructor = ComposeUiNode.Companion.getConstructor();
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
            composer2 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer2, measurePolicy1111, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap1111, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer2.getInserting()) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier1111, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2001581039, "C123@5012L16:CurvedLayout.kt#m5emhl");
            curvedRowChild.SubComposition(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        f4 = f3;
        i12 = iM292getNormalgmlPZk4;
        f5 = fM221getCenterIUldqTk;
        radial3 = radial2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier19 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.foundation.CurvedLayoutKt$CurvedLayout$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i15) {
                    CurvedLayoutKt.m321CurvedLayoutz6uKIlA(modifier19, f4, f5, radial3, i12, function1, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }

    /* JADX INFO: renamed from: initialCurvedLayoutDirection-XMJfWBM, reason: not valid java name */
    public static final CurvedLayoutDirection m322initialCurvedLayoutDirectionXMJfWBM(int i, Composer composer, int i2) {
        int iM301getInsideOutYsh6JRM;
        ComposerKt.sourceInformationMarkerStart(composer, -418085784, "C(initialCurvedLayoutDirection)P(0:androidx.wear.compose.foundation.CurvedDirection.Angular)209@8304L7:CurvedLayout.kt#m5emhl");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-418085784, i2, -1, "androidx.wear.compose.foundation.initialCurvedLayoutDirection (CurvedLayout.kt:208)");
        }
        CompositionLocal localLayoutDirection = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume;
        if (CurvedDirection.Angular.m285equalsimpl0(i, CurvedDirection.Angular.INSTANCE.m292getNormalgmlPZk4()) ? true : CurvedDirection.Angular.m285equalsimpl0(i, CurvedDirection.Angular.INSTANCE.m290getClockwisegmlPZk4())) {
            iM301getInsideOutYsh6JRM = CurvedDirection.Radial.INSTANCE.m302getOutsideInYsh6JRM();
        } else {
            if (CurvedDirection.Angular.m285equalsimpl0(i, CurvedDirection.Angular.INSTANCE.m293getReversedgmlPZk4()) ? true : CurvedDirection.Angular.m285equalsimpl0(i, CurvedDirection.Angular.INSTANCE.m291getCounterClockwisegmlPZk4())) {
                iM301getInsideOutYsh6JRM = CurvedDirection.Radial.INSTANCE.m301getInsideOutYsh6JRM();
            } else {
                throw new RuntimeException("Unexpected CurvedDirection.Angular: " + ((Object) CurvedDirection.Angular.m288toStringimpl(i)));
            }
        }
        CurvedLayoutDirection curvedLayoutDirection = new CurvedLayoutDirection(iM301getInsideOutYsh6JRM, i, layoutDirection, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return curvedLayoutDirection;
    }

    public static final long offsetFromDistanceAndAngle(float f, float f2) {
        double d = f2;
        return OffsetKt.Offset(((float) Math.cos(d)) * f, f * ((float) Math.sin(d)));
    }

    public static final <T> float sumOf(Iterable<? extends T> iterable, Function1<? super T, Float> function1) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(it.next()));
        }
        return CollectionsKt.sumOfFloat(arrayList);
    }
}
