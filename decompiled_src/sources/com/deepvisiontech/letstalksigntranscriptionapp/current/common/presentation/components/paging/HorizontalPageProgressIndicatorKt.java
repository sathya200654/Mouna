package com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: HorizontalPageProgressIndicator.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"HorizontalPageProgressIndicator", "", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "inActiveColor", "Landroidx/compose/ui/graphics/Color;", "activeColor", "HorizontalPageProgressIndicator-eaDK9VM", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HorizontalPageProgressIndicatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPageProgressIndicator_eaDK9VM$lambda$6(PagerState pagerState, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m1430HorizontalPageProgressIndicatoreaDK9VM(pagerState, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:108:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:109:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:112:0x0306  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x0081  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008c  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00af  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:74:0x0103  */
    /* JADX WARN: Code duplicated, block: B:77:0x0185  */
    /* JADX WARN: Code duplicated, block: B:80:0x0191  */
    /* JADX WARN: Code duplicated, block: B:81:0x0195  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:90:0x0201  */
    /* JADX WARN: Code duplicated, block: B:93:0x026d  */
    /* JADX WARN: Code duplicated, block: B:94:0x026f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0286  */
    /* JADX INFO: renamed from: HorizontalPageProgressIndicator-eaDK9VM, reason: not valid java name */
    public static final void m1430HorizontalPageProgressIndicatoreaDK9VM(final PagerState pagerState, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        boolean z;
        final long j5;
        final long j6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        float f;
        Function0 constructor;
        int i4;
        int pageCount;
        final int i5;
        final boolean z2;
        long j7;
        final String strStringResource;
        boolean z3;
        boolean zChanged;
        Object objRememberedValue2;
        boolean zChanged2;
        Object objRememberedValue3;
        int i6;
        Intrinsics.checkNotNullParameter(pagerState, "pagerState");
        Composer composerStartRestartGroup = composer.startRestartGroup(399780898);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalPageProgressIndicator)P(3,2,1:c#ui.graphics.Color,0:c#ui.graphics.Color)36@1596L24,39@1627L1326:HorizontalPageProgressIndicator.kt#s0ihav");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    int i8 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i3 |= i8;
                } else {
                    j3 = j;
                }
                i3 |= i8;
            } else {
                j3 = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    j4 = j2;
                    if (composerStartRestartGroup.changed(j4)) {
                        i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    }
                    i3 |= i6;
                } else {
                    j4 = j2;
                }
                i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                i3 |= i6;
            } else {
                j4 = j2;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1476L11,34@1545L11");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        j3 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        j4 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
                        i3 &= -7169;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(399780898, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicator (HorizontalPageProgressIndicator.kt:35)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                f = 8;
                Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.wrapContentHeight$default(modifier2, (Alignment.Vertical) null, false, 3, (Object) null), 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f), 7, (Object) null);
                Arrangement.Horizontal center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, Alignment.Companion.getTop(), composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
                constructor = ComposeUiNode.Companion.getConstructor();
                i4 = i3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -418901597, "C:HorizontalPageProgressIndicator.kt#s0ihav");
                composerStartRestartGroup.startReplaceGroup(-1260438944);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*50@2035L69,51@2139L65,61@2548L158,66@2738L185,52@2217L720");
                pageCount = pagerState.getPageCount();
                i5 = 0;
                while (i5 < pageCount) {
                    if (pagerState.getCurrentPage() == i5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        j7 = j4;
                    } else {
                        j7 = j3;
                    }
                    int i9 = i5 + 1;
                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.global_pager_go_to_label, new Object[]{Integer.valueOf(i9)}, composerStartRestartGroup, 0);
                    int i10 = pageCount;
                    strStringResource = StringResources_androidKt.stringResource(R.string.global_pager_cd_page, new Object[]{Integer.valueOf(i9)}, composerStartRestartGroup, 0);
                    Modifier modifier4 = SizeKt.size-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), RoundedCornerShapeKt.getCircleShape()), j7, (Shape) null, 2, (Object) null), Dp.constructor-impl(f));
                    Role role = Role.box-impl(Role.Companion.getTab-o7Vup1c());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1705105300, "CC(remember):HorizontalPageProgressIndicator.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope);
                    if ((i4 & 14) == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zChanged = zChangedInstance | z3 | composerStartRestartGroup.changed(i5);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$1$lambda$0(coroutineScope, pagerState, i5);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(modifier4, false, strStringResource2, role, (MutableInteractionSource) null, (Function0) objRememberedValue2, 9, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1705099193, "CC(remember):HorizontalPageProgressIndicator.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(z2) | composerStartRestartGroup.changed(strStringResource);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$3$lambda$2(z2, strStringResource, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxKt.Box(SemanticsModifierKt.semantics$default(modifier5, false, (Function1) objRememberedValue3, 1, (Object) null), composerStartRestartGroup, 0);
                    pageCount = i10;
                    i5 = i9;
                }
                composerStartRestartGroup.endReplaceGroup();
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
            j5 = j3;
            j6 = j4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$6(pagerState, modifier6, j5, j6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i8;
            } else {
                j3 = j;
            }
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                    i6 = RecyclerView.ItemAnimator.FLAG_MOVED;
                }
                i3 |= i6;
            } else {
                j4 = j2;
            }
            i6 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            i3 |= i6;
        } else {
            j4 = j2;
        }
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "33@1476L11,34@1545L11");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    j4 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
                    i3 &= -7169;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    j3 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    j4 = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU();
                    i3 &= -7169;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(399780898, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicator (HorizontalPageProgressIndicator.kt:35)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            f = 8;
            Modifier modifier7 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.wrapContentHeight$default(modifier2, (Alignment.Vertical) null, false, 3, (Object) null), 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(f), 7, (Object) null);
            Arrangement.Horizontal center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, Alignment.Companion.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier7);
            constructor = ComposeUiNode.Companion.getConstructor();
            i4 = i3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -418901597, "C:HorizontalPageProgressIndicator.kt#s0ihav");
            composerStartRestartGroup.startReplaceGroup(-1260438944);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*50@2035L69,51@2139L65,61@2548L158,66@2738L185,52@2217L720");
            pageCount = pagerState.getPageCount();
            i5 = 0;
            while (i5 < pageCount) {
                if (pagerState.getCurrentPage() == i5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    j7 = j4;
                } else {
                    j7 = j3;
                }
                int i11 = i5 + 1;
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.global_pager_go_to_label, new Object[]{Integer.valueOf(i11)}, composerStartRestartGroup, 0);
                int i12 = pageCount;
                strStringResource = StringResources_androidKt.stringResource(R.string.global_pager_cd_page, new Object[]{Integer.valueOf(i11)}, composerStartRestartGroup, 0);
                Modifier modifier8 = SizeKt.size-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClipKt.clip(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), RoundedCornerShapeKt.getCircleShape()), j7, (Shape) null, 2, (Object) null), Dp.constructor-impl(f));
                Role role2 = Role.box-impl(Role.Companion.getTab-o7Vup1c());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1705105300, "CC(remember):HorizontalPageProgressIndicator.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(coroutineScope);
                if ((i4 & 14) == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged = zChangedInstance2 | z3 | composerStartRestartGroup.changed(i5);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$1$lambda$0(coroutineScope, pagerState, i5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$1$lambda$0(coroutineScope, pagerState, i5);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier9 = ClickableKt.clickable-oSLSa3U$default(modifier8, false, strStringResource3, role2, (MutableInteractionSource) null, (Function0) objRememberedValue2, 9, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1705099193, "CC(remember):HorizontalPageProgressIndicator.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(z2) | composerStartRestartGroup.changed(strStringResource);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$3$lambda$2(z2, strStringResource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$3$lambda$2(z2, strStringResource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(SemanticsModifierKt.semantics$default(modifier9, false, (Function1) objRememberedValue3, 1, (Object) null), composerStartRestartGroup, 0);
                pageCount = i12;
                i5 = i11;
            }
            composerStartRestartGroup.endReplaceGroup();
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
        j5 = j3;
        j6 = j4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier10 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.common.presentation.components.paging.HorizontalPageProgressIndicatorKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    return HorizontalPageProgressIndicatorKt.HorizontalPageProgressIndicator_eaDK9VM$lambda$6(pagerState, modifier10, j5, j6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$1$lambda$0(CoroutineScope coroutineScope, PagerState pagerState, int i) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HorizontalPageProgressIndicatorKt$HorizontalPageProgressIndicator$1$1$1$1$1(pagerState, i, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPageProgressIndicator_eaDK9VM$lambda$5$lambda$4$lambda$3$lambda$2(boolean z, String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getTab-o7Vup1c());
        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }
}
