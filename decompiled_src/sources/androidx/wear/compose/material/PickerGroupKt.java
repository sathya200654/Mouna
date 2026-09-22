package androidx.wear.compose.material;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.compose.foundation.HierarchicalFocusCoordinatorKt;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PickerGroup.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\bH\u0003¢\u0006\u0002\u0010\t\u001a\u0095\u0001\u0010\n\u001a\u00020\u00012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2#\b\u0002\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u001b\b\u0002\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\u001a\u001a(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0016\u0010#\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002\u001a\u0017\u0010$\u001a\u00020\u000f2\b\b\u0002\u0010%\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010&\u001a\f\u0010'\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010(\u001a\u00020\u0005*\u00020 H\u0000\u001a\u0014\u0010)\u001a\u00020\u0003*\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006,²\u0006\n\u0010-\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"AutoCenteringRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "propagateMinConstraints", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PickerGroup", "pickers", "", "Landroidx/wear/compose/material/PickerGroupItem;", "pickerGroupState", "Landroidx/wear/compose/material/PickerGroupState;", "onSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "selectedIndex", "autoCenter", "touchExplorationStateProvider", "Landroidx/wear/compose/material/TouchExplorationStateProvider;", "separator", "([Landroidx/wear/compose/material/PickerGroupItem;Landroidx/compose/ui/Modifier;Landroidx/wear/compose/material/PickerGroupState;Lkotlin/jvm/functions/Function1;ZZLandroidx/wear/compose/material/TouchExplorationStateProvider;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "calculateHeight-K40F9xA", "(JLjava/util/List;)I", "computeCenteringOffset", "rememberPickerGroupState", "initiallySelectedIndex", "(ILandroidx/compose/runtime/Composer;II)Landroidx/wear/compose/material/PickerGroupState;", "autoCenteringTarget", "isAutoCenteringTarget", "scrollablePicker", "pickerState", "Landroidx/wear/compose/material/PickerState;", "compose-material_release", "touchExplorationServicesEnabled"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PickerGroupKt {
    /* JADX WARN: Code duplicated, block: B:106:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x015d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0166  */
    /* JADX WARN: Code duplicated, block: B:111:0x016f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0172  */
    /* JADX WARN: Code duplicated, block: B:115:0x0179  */
    /* JADX WARN: Code duplicated, block: B:117:0x017c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0181  */
    /* JADX WARN: Code duplicated, block: B:121:0x018b  */
    /* JADX WARN: Code duplicated, block: B:123:0x018f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0191  */
    /* JADX WARN: Code duplicated, block: B:127:0x019c  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ba A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:134:0x01be  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:140:0x021a  */
    /* JADX WARN: Code duplicated, block: B:144:0x0229  */
    /* JADX WARN: Code duplicated, block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:43:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x008f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0091  */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce A[PHI: r17
  0x00ce: PHI (r17v6 int) = (r17v0 int), (r17v3 int), (r17v4 int) binds: [B:70:0x00cc, B:77:0x00e0, B:76:0x00dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:82:0x0103  */
    /* JADX WARN: Code duplicated, block: B:83:0x0105  */
    /* JADX WARN: Code duplicated, block: B:87:0x0113  */
    /* JADX WARN: Code duplicated, block: B:90:0x011e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0134  */
    /* JADX WARN: Code duplicated, block: B:96:0x013f  */
    public static final void PickerGroup(final PickerGroupItem[] pickerGroupItemArr, Modifier modifier, PickerGroupState pickerGroupState, Function1<? super Integer, Unit> function1, boolean z, boolean z2, TouchExplorationStateProvider touchExplorationStateProvider, Function3<? super Integer, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        PickerGroupState pickerGroupStateRememberPickerGroupState;
        Function1<? super Integer, Unit> function2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        boolean z4;
        int i7;
        int i8;
        int i9;
        int length;
        int i10;
        boolean z5;
        DefaultTouchExplorationStateProvider defaultTouchExplorationStateProvider;
        final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function4;
        final State<Boolean> state;
        Modifier modifierScrollablePicker;
        Composer composer2;
        final PickerGroupState pickerGroupState2;
        final TouchExplorationStateProvider touchExplorationStateProvider2;
        final Modifier modifier3;
        final boolean z6;
        final boolean z7;
        final Function1<? super Integer, Unit> function5;
        int selectedIndex;
        boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        boolean zChangedInstance;
        Composer composerStartRestartGroup = composer.startRestartGroup(1300754617);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PickerGroup)P(4,1,3,2!2,7)98@5043L23,116@5728L3067,100@5072L3723:PickerGroup.kt#gj9v0t");
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 = i | 48;
            modifier2 = modifier;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 32 : 16) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                pickerGroupStateRememberPickerGroupState = pickerGroupState;
                int i14 = composerStartRestartGroup.changed(pickerGroupStateRememberPickerGroupState) ? 256 : 128;
                i3 |= i14;
            } else {
                pickerGroupStateRememberPickerGroupState = pickerGroupState;
            }
            i3 |= i14;
        } else {
            pickerGroupStateRememberPickerGroupState = pickerGroupState;
        }
        int i15 = i2 & 8;
        if (i15 == 0) {
            if ((i & 3072) == 0) {
                function2 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function2) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i7 = 131072;
                        } else {
                            i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i7;
                    }
                    if ((i & 1572864) == 0) {
                        if ((i2 & 64) != 0) {
                            i12 = 524288;
                        } else {
                            if ((i & 2097152) == 0) {
                                zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                            } else {
                                zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                            }
                            if (zChangedInstance) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                        }
                        i3 |= i12;
                    }
                    i8 = i2 & 128;
                    i9 = 12582912;
                    if (i8 == 0) {
                        i3 |= i9;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 8388608;
                        } else {
                            i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                        i3 |= i9;
                    }
                    composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
                    length = pickerGroupItemArr.length;
                    i10 = 0;
                    while (i10 < length) {
                        int i16 = length;
                        if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                            i11 = 4;
                        } else {
                            i11 = 0;
                        }
                        i3 |= i11;
                        i10++;
                        length = i16;
                    }
                    composerStartRestartGroup.endMovableGroup();
                    if ((i3 & 14) == 0) {
                        i3 |= 2;
                    }
                    if ((4793491 & i3) == 4793490 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                modifier2 = (Modifier) Modifier.Companion;
                            }
                            if ((i2 & 4) != 0) {
                                z5 = false;
                                i3 &= -897;
                                pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                            } else {
                                z5 = false;
                            }
                            if (i15 != 0) {
                                function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                    public final void invoke(int i17) {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).intValue());
                                        return Unit.INSTANCE;
                                    }
                                };
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                z4 = z5;
                            }
                            if ((i2 & 64) != 0) {
                                defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                                i3 &= -3670017;
                            } else {
                                defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            } else {
                                function4 = function3;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                            function4 = function3;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                        }
                        state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                        if (PickerGroup$lambda$0(state)) {
                            int length2 = pickerGroupItemArr.length;
                            selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                            if (selectedIndex >= 0 || selectedIndex >= length2) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            if (z8) {
                                modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                            } else {
                                modifierScrollablePicker = Modifier.Companion;
                            }
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                        final PickerGroupState pickerGroupState3 = pickerGroupStateRememberPickerGroupState;
                        final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function6 = function4;
                        final Function1<? super Integer, Unit> function7 = function2;
                        final boolean z9 = z3;
                        AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i17) {
                                ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                                if ((i17 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(713652740, i17, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState3);
                                final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                                final PickerGroupState pickerGroupState4 = pickerGroupState3;
                                Object objRememberedValue = composer3.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                    objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m635invoke() {
                                            return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState4.getSelectedIndex()));
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                                PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                                final PickerGroupState pickerGroupState5 = pickerGroupState3;
                                Function3<Integer, Composer, Integer, Unit> function8 = function6;
                                final boolean z10 = z9;
                                final State<Boolean> state2 = state;
                                Function1<Integer, Unit> function9 = function7;
                                int length3 = pickerGroupItemArr3.length;
                                int i18 = 0;
                                int i19 = 0;
                                while (i19 < length3) {
                                    final Function1<Integer, Unit> function10 = function9;
                                    final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i19];
                                    int i20 = i18 + 1;
                                    int i21 = length3;
                                    final boolean z11 = i18 == pickerGroupState5.getSelectedIndex();
                                    final int i22 = i18;
                                    final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                    boolean zChanged = composer3.changed(z11);
                                    Object objRememberedValue2 = composer3.rememberedValue();
                                    if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                        objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                            public final Boolean m636invoke() {
                                                return Boolean.valueOf(z11);
                                            }
                                        };
                                        composer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    Function3<Integer, Composer, Integer, Unit> function11 = function8;
                                    int i23 = i19;
                                    HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i24) {
                                            ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                            if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                                }
                                                FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                                composer4.startReplaceGroup(-1219820472);
                                                ComposerKt.sourceInformation(composer4, "126@6391L30");
                                                if (focusRequester == null) {
                                                    focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                                }
                                                composer4.endReplaceGroup();
                                                PickerState pickerState = pickerGroupItem.getPickerState();
                                                String contentDescription = pickerGroupItem.getContentDescription();
                                                boolean z12 = !z11;
                                                Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z11 && z10) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                                Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                                Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                                boolean z13 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z11;
                                                FlingBehavior flingBehavior2 = flingBehavior;
                                                final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                                final boolean z14 = z11;
                                                final PickerGroupState pickerGroupState6 = pickerGroupState5;
                                                final int i25 = i22;
                                                final Function1<Integer, Unit> function12 = function10;
                                                final State<Boolean> state3 = state2;
                                                PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z12, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z13, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(4);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                        invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                        int i28;
                                                        Modifier modifierPointerInput;
                                                        ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                        if ((i27 & 6) == 0) {
                                                            i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                        } else {
                                                            i28 = i27;
                                                        }
                                                        if ((i27 & 48) == 0) {
                                                            i28 |= composer5.changed(i26) ? 32 : 16;
                                                        }
                                                        if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                            }
                                                            PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                            boolean z15 = z14;
                                                            PickerGroupState pickerGroupState7 = pickerGroupState6;
                                                            int i29 = i25;
                                                            Function1<Integer, Unit> function13 = function12;
                                                            State<Boolean> state4 = state3;
                                                            composer5.startReplaceGroup(663033228);
                                                            ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                            if (PickerGroupKt.PickerGroup$lambda$0(state4) || z15) {
                                                                modifierPointerInput = Modifier.Companion;
                                                            } else {
                                                                Modifier modifier4 = Modifier.Companion;
                                                                Unit unit = Unit.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                                boolean zChanged2 = composer5.changed(pickerGroupState7) | composer5.changed(i29) | composer5.changed(function13);
                                                                PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                                if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                    pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState7, i29, function13, null);
                                                                    composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            composer5.endReplaceGroup();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer composer6 = Updater.constructor-impl(composer5);
                                                            Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                            Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                            if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                            pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z15), composer5, Integer.valueOf(i28 & 126));
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endNode();
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                }, composer4, 54), composer4, 0, 3072, 5056);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }, composer3, 54), composer3, 48);
                                    composer3.startReplaceGroup(-882907323);
                                    ComposerKt.sourceInformation(composer3, "170@8752L13");
                                    if (i22 < pickerGroupItemArr3.length - 1 && function11 != null) {
                                        function11.invoke(Integer.valueOf(i22), composer3, 0);
                                    }
                                    composer3.endReplaceGroup();
                                    i19 = i23 + 1;
                                    length3 = i21;
                                    function8 = function11;
                                    function9 = function10;
                                    i18 = i20;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                        touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                        modifier3 = modifier2;
                        z6 = z3;
                        z7 = z4;
                        function5 = function2;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        function4 = function3;
                        composer2 = composerStartRestartGroup;
                        pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                        touchExplorationStateProvider2 = touchExplorationStateProvider;
                        modifier3 = modifier2;
                        function5 = function2;
                        z6 = z3;
                        z7 = z4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i17) {
                                PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                                PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 196608;
                z4 = z2;
                if ((i & 1572864) == 0) {
                    if ((i2 & 64) != 0) {
                        i12 = 524288;
                    } else {
                        if ((i & 2097152) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                        }
                        if (zChangedInstance) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    i3 |= i12;
                }
                i8 = i2 & 128;
                i9 = 12582912;
                if (i8 == 0) {
                    i3 |= i9;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
                length = pickerGroupItemArr.length;
                i10 = 0;
                while (i10 < length) {
                    int i17 = length;
                    if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                        i11 = 4;
                    } else {
                        i11 = 0;
                    }
                    i3 |= i11;
                    i10++;
                    length = i17;
                }
                composerStartRestartGroup.endMovableGroup();
                if ((i3 & 14) == 0) {
                    i3 |= 2;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i18) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i18) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                    }
                    state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                    if (PickerGroup$lambda$0(state)) {
                        int length3 = pickerGroupItemArr.length;
                        selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                    final PickerGroupState pickerGroupState4 = pickerGroupStateRememberPickerGroupState;
                    final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function8 = function4;
                    final Function1<? super Integer, Unit> function9 = function2;
                    final boolean z10 = z3;
                    AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i18) {
                            ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                            if ((i18 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713652740, i18, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState4);
                            final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState5 = pickerGroupState4;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m635invoke() {
                                        return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState5.getSelectedIndex()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                            PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState6 = pickerGroupState4;
                            Function3<Integer, Composer, Integer, Unit> function10 = function8;
                            final boolean z11 = z10;
                            final State<Boolean> state2 = state;
                            Function1<Integer, Unit> function11 = function9;
                            int length4 = pickerGroupItemArr3.length;
                            int i19 = 0;
                            int i110 = 0;
                            while (i110 < length4) {
                                final Function1<? super Integer, Unit> function12 = function11;
                                final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i110];
                                int i20 = i19 + 1;
                                int i21 = length4;
                                final boolean z12 = i19 == pickerGroupState6.getSelectedIndex();
                                final int i22 = i19;
                                final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChanged = composer3.changed(z12);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m636invoke() {
                                            return Boolean.valueOf(z12);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Function3<Integer, Composer, Integer, Unit> function13 = function10;
                                int i23 = i110;
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i24) {
                                        ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                        if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                            }
                                            FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                            composer4.startReplaceGroup(-1219820472);
                                            ComposerKt.sourceInformation(composer4, "126@6391L30");
                                            if (focusRequester == null) {
                                                focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                            }
                                            composer4.endReplaceGroup();
                                            PickerState pickerState = pickerGroupItem.getPickerState();
                                            String contentDescription = pickerGroupItem.getContentDescription();
                                            boolean z13 = !z12;
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z12 && z11) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                            Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                            Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                            boolean z14 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z12;
                                            FlingBehavior flingBehavior2 = flingBehavior;
                                            final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                            final boolean z15 = z12;
                                            final PickerGroupState pickerGroupState7 = pickerGroupState6;
                                            final int i25 = i22;
                                            final Function1<? super Integer, Unit> function14 = function12;
                                            final State<Boolean> state3 = state2;
                                            PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z13, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z14, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                    invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                    int i28;
                                                    Modifier modifierPointerInput;
                                                    ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                    if ((i27 & 6) == 0) {
                                                        i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                    } else {
                                                        i28 = i27;
                                                    }
                                                    if ((i27 & 48) == 0) {
                                                        i28 |= composer5.changed(i26) ? 32 : 16;
                                                    }
                                                    if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                        }
                                                        PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                        boolean z16 = z15;
                                                        PickerGroupState pickerGroupState8 = pickerGroupState7;
                                                        int i29 = i25;
                                                        Function1<Integer, Unit> function15 = function14;
                                                        State<Boolean> state4 = state3;
                                                        composer5.startReplaceGroup(663033228);
                                                        ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                        if (PickerGroupKt.PickerGroup$lambda$0(state4) || z16) {
                                                            modifierPointerInput = Modifier.Companion;
                                                        } else {
                                                            Modifier modifier4 = Modifier.Companion;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(pickerGroupState8) | composer5.changed(i29) | composer5.changed(function15);
                                                            PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                            if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState8, i29, function15, null);
                                                                composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        composer5.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer composer6 = Updater.constructor-impl(composer5);
                                                        Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                        pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z16), composer5, Integer.valueOf(i28 & 126));
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, 0, 3072, 5056);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 48);
                                composer3.startReplaceGroup(-882907323);
                                ComposerKt.sourceInformation(composer3, "170@8752L13");
                                if (i22 < pickerGroupItemArr3.length - 1 && function13 != null) {
                                    function13.invoke(Integer.valueOf(i22), composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                i110 = i23 + 1;
                                length4 = i21;
                                function10 = function13;
                                function11 = function12;
                                i19 = i20;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                    touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                    function5 = function2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i18) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i18) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                    }
                    state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                    if (PickerGroup$lambda$0(state)) {
                        int length4 = pickerGroupItemArr.length;
                        selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                    final PickerGroupState pickerGroupState5 = pickerGroupStateRememberPickerGroupState;
                    final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function10 = function4;
                    final Function1<? super Integer, Unit> function11 = function2;
                    final boolean z11 = z3;
                    AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i18) {
                            ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                            if ((i18 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713652740, i18, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState5);
                            final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState6 = pickerGroupState5;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m635invoke() {
                                        return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState6.getSelectedIndex()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                            PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState7 = pickerGroupState5;
                            Function3<Integer, Composer, Integer, Unit> function12 = function10;
                            final boolean z12 = z11;
                            final State<Boolean> state2 = state;
                            Function1<Integer, Unit> function13 = function11;
                            int length5 = pickerGroupItemArr3.length;
                            int i19 = 0;
                            int i110 = 0;
                            while (i110 < length5) {
                                final Function1<? super Integer, Unit> function14 = function13;
                                final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i110];
                                int i20 = i19 + 1;
                                int i21 = length5;
                                final boolean z13 = i19 == pickerGroupState7.getSelectedIndex();
                                final int i22 = i19;
                                final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChanged = composer3.changed(z13);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m636invoke() {
                                            return Boolean.valueOf(z13);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Function3<Integer, Composer, Integer, Unit> function15 = function12;
                                int i23 = i110;
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i24) {
                                        ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                        if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                            }
                                            FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                            composer4.startReplaceGroup(-1219820472);
                                            ComposerKt.sourceInformation(composer4, "126@6391L30");
                                            if (focusRequester == null) {
                                                focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                            }
                                            composer4.endReplaceGroup();
                                            PickerState pickerState = pickerGroupItem.getPickerState();
                                            String contentDescription = pickerGroupItem.getContentDescription();
                                            boolean z14 = !z13;
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z13 && z12) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                            Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                            Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                            boolean z15 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z13;
                                            FlingBehavior flingBehavior2 = flingBehavior;
                                            final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                            final boolean z16 = z13;
                                            final PickerGroupState pickerGroupState8 = pickerGroupState7;
                                            final int i25 = i22;
                                            final Function1<? super Integer, Unit> function16 = function14;
                                            final State<Boolean> state3 = state2;
                                            PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z14, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z15, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                    invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                    int i28;
                                                    Modifier modifierPointerInput;
                                                    ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                    if ((i27 & 6) == 0) {
                                                        i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                    } else {
                                                        i28 = i27;
                                                    }
                                                    if ((i27 & 48) == 0) {
                                                        i28 |= composer5.changed(i26) ? 32 : 16;
                                                    }
                                                    if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                        }
                                                        PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                        boolean z17 = z16;
                                                        PickerGroupState pickerGroupState9 = pickerGroupState8;
                                                        int i29 = i25;
                                                        Function1<Integer, Unit> function17 = function16;
                                                        State<Boolean> state4 = state3;
                                                        composer5.startReplaceGroup(663033228);
                                                        ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                        if (PickerGroupKt.PickerGroup$lambda$0(state4) || z17) {
                                                            modifierPointerInput = Modifier.Companion;
                                                        } else {
                                                            Modifier modifier4 = Modifier.Companion;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(pickerGroupState9) | composer5.changed(i29) | composer5.changed(function17);
                                                            PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                            if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState9, i29, function17, null);
                                                                composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        composer5.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer composer6 = Updater.constructor-impl(composer5);
                                                        Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                        pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z17), composer5, Integer.valueOf(i28 & 126));
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, 0, 3072, 5056);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 48);
                                composer3.startReplaceGroup(-882907323);
                                ComposerKt.sourceInformation(composer3, "170@8752L13");
                                if (i22 < pickerGroupItemArr3.length - 1 && function15 != null) {
                                    function15.invoke(Integer.valueOf(i22), composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                i110 = i23 + 1;
                                length5 = i21;
                                function12 = function15;
                                function13 = function14;
                                i19 = i20;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                    touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                    function5 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i18) {
                            PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            z3 = z;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 131072;
                    } else {
                        i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if ((i2 & 64) != 0) {
                        i12 = 524288;
                    } else {
                        if ((i & 2097152) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                        }
                        if (zChangedInstance) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    i3 |= i12;
                }
                i8 = i2 & 128;
                i9 = 12582912;
                if (i8 == 0) {
                    i3 |= i9;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
                length = pickerGroupItemArr.length;
                i10 = 0;
                while (i10 < length) {
                    int i18 = length;
                    if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                        i11 = 4;
                    } else {
                        i11 = 0;
                    }
                    i3 |= i11;
                    i10++;
                    length = i18;
                }
                composerStartRestartGroup.endMovableGroup();
                if ((i3 & 14) == 0) {
                    i3 |= 2;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i19) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i19) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                    }
                    state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                    if (PickerGroup$lambda$0(state)) {
                        int length5 = pickerGroupItemArr.length;
                        selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                    final PickerGroupState pickerGroupState6 = pickerGroupStateRememberPickerGroupState;
                    final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function12 = function4;
                    final Function1<? super Integer, Unit> function13 = function2;
                    final boolean z12 = z3;
                    AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i19) {
                            ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                            if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713652740, i19, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState6);
                            final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState7 = pickerGroupState6;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m635invoke() {
                                        return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState7.getSelectedIndex()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                            PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState8 = pickerGroupState6;
                            Function3<Integer, Composer, Integer, Unit> function14 = function12;
                            final boolean z13 = z12;
                            final State<Boolean> state2 = state;
                            Function1<Integer, Unit> function15 = function13;
                            int length6 = pickerGroupItemArr3.length;
                            int i110 = 0;
                            int i111 = 0;
                            while (i111 < length6) {
                                final Function1<? super Integer, Unit> function16 = function15;
                                final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i111];
                                int i20 = i110 + 1;
                                int i21 = length6;
                                final boolean z14 = i110 == pickerGroupState8.getSelectedIndex();
                                final int i22 = i110;
                                final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChanged = composer3.changed(z14);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m636invoke() {
                                            return Boolean.valueOf(z14);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Function3<Integer, Composer, Integer, Unit> function17 = function14;
                                int i23 = i111;
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i24) {
                                        ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                        if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                            }
                                            FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                            composer4.startReplaceGroup(-1219820472);
                                            ComposerKt.sourceInformation(composer4, "126@6391L30");
                                            if (focusRequester == null) {
                                                focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                            }
                                            composer4.endReplaceGroup();
                                            PickerState pickerState = pickerGroupItem.getPickerState();
                                            String contentDescription = pickerGroupItem.getContentDescription();
                                            boolean z15 = !z14;
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z14 && z13) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                            Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                            Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                            boolean z16 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z14;
                                            FlingBehavior flingBehavior2 = flingBehavior;
                                            final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                            final boolean z17 = z14;
                                            final PickerGroupState pickerGroupState9 = pickerGroupState8;
                                            final int i25 = i22;
                                            final Function1<? super Integer, Unit> function18 = function16;
                                            final State<Boolean> state3 = state2;
                                            PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z15, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z16, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                    invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                    int i28;
                                                    Modifier modifierPointerInput;
                                                    ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                    if ((i27 & 6) == 0) {
                                                        i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                    } else {
                                                        i28 = i27;
                                                    }
                                                    if ((i27 & 48) == 0) {
                                                        i28 |= composer5.changed(i26) ? 32 : 16;
                                                    }
                                                    if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                        }
                                                        PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                        boolean z18 = z17;
                                                        PickerGroupState pickerGroupState10 = pickerGroupState9;
                                                        int i29 = i25;
                                                        Function1<Integer, Unit> function19 = function18;
                                                        State<Boolean> state4 = state3;
                                                        composer5.startReplaceGroup(663033228);
                                                        ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                        if (PickerGroupKt.PickerGroup$lambda$0(state4) || z18) {
                                                            modifierPointerInput = Modifier.Companion;
                                                        } else {
                                                            Modifier modifier4 = Modifier.Companion;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(pickerGroupState10) | composer5.changed(i29) | composer5.changed(function19);
                                                            PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                            if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState10, i29, function19, null);
                                                                composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        composer5.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer composer6 = Updater.constructor-impl(composer5);
                                                        Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                        pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z18), composer5, Integer.valueOf(i28 & 126));
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, 0, 3072, 5056);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 48);
                                composer3.startReplaceGroup(-882907323);
                                ComposerKt.sourceInformation(composer3, "170@8752L13");
                                if (i22 < pickerGroupItemArr3.length - 1 && function17 != null) {
                                    function17.invoke(Integer.valueOf(i22), composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                i111 = i23 + 1;
                                length6 = i21;
                                function14 = function17;
                                function15 = function16;
                                i110 = i20;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                    touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                    function5 = function2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i19) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i19) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                    }
                    state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                    if (PickerGroup$lambda$0(state)) {
                        int length6 = pickerGroupItemArr.length;
                        selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                    final PickerGroupState pickerGroupState7 = pickerGroupStateRememberPickerGroupState;
                    final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function14 = function4;
                    final Function1<? super Integer, Unit> function15 = function2;
                    final boolean z13 = z3;
                    AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i19) {
                            ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                            if ((i19 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713652740, i19, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState7);
                            final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState8 = pickerGroupState7;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m635invoke() {
                                        return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState8.getSelectedIndex()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                            PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState9 = pickerGroupState7;
                            Function3<Integer, Composer, Integer, Unit> function16 = function14;
                            final boolean z14 = z13;
                            final State<Boolean> state2 = state;
                            Function1<Integer, Unit> function17 = function15;
                            int length7 = pickerGroupItemArr3.length;
                            int i110 = 0;
                            int i111 = 0;
                            while (i111 < length7) {
                                final Function1<? super Integer, Unit> function18 = function17;
                                final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i111];
                                int i20 = i110 + 1;
                                int i21 = length7;
                                final boolean z15 = i110 == pickerGroupState9.getSelectedIndex();
                                final int i22 = i110;
                                final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChanged = composer3.changed(z15);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m636invoke() {
                                            return Boolean.valueOf(z15);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Function3<Integer, Composer, Integer, Unit> function19 = function16;
                                int i23 = i111;
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i24) {
                                        ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                        if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                            }
                                            FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                            composer4.startReplaceGroup(-1219820472);
                                            ComposerKt.sourceInformation(composer4, "126@6391L30");
                                            if (focusRequester == null) {
                                                focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                            }
                                            composer4.endReplaceGroup();
                                            PickerState pickerState = pickerGroupItem.getPickerState();
                                            String contentDescription = pickerGroupItem.getContentDescription();
                                            boolean z16 = !z15;
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z15 && z14) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                            Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                            Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                            boolean z17 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z15;
                                            FlingBehavior flingBehavior2 = flingBehavior;
                                            final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                            final boolean z18 = z15;
                                            final PickerGroupState pickerGroupState10 = pickerGroupState9;
                                            final int i25 = i22;
                                            final Function1<? super Integer, Unit> function110 = function18;
                                            final State<Boolean> state3 = state2;
                                            PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z16, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z17, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                    invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                    int i28;
                                                    Modifier modifierPointerInput;
                                                    ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                    if ((i27 & 6) == 0) {
                                                        i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                    } else {
                                                        i28 = i27;
                                                    }
                                                    if ((i27 & 48) == 0) {
                                                        i28 |= composer5.changed(i26) ? 32 : 16;
                                                    }
                                                    if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                        }
                                                        PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                        boolean z19 = z18;
                                                        PickerGroupState pickerGroupState11 = pickerGroupState10;
                                                        int i29 = i25;
                                                        Function1<Integer, Unit> function111 = function110;
                                                        State<Boolean> state4 = state3;
                                                        composer5.startReplaceGroup(663033228);
                                                        ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                        if (PickerGroupKt.PickerGroup$lambda$0(state4) || z19) {
                                                            modifierPointerInput = Modifier.Companion;
                                                        } else {
                                                            Modifier modifier4 = Modifier.Companion;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(pickerGroupState11) | composer5.changed(i29) | composer5.changed(function111);
                                                            PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                            if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState11, i29, function111, null);
                                                                composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        composer5.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer composer6 = Updater.constructor-impl(composer5);
                                                        Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                        pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z19), composer5, Integer.valueOf(i28 & 126));
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, 0, 3072, 5056);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 48);
                                composer3.startReplaceGroup(-882907323);
                                ComposerKt.sourceInformation(composer3, "170@8752L13");
                                if (i22 < pickerGroupItemArr3.length - 1 && function19 != null) {
                                    function19.invoke(Integer.valueOf(i22), composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                i111 = i23 + 1;
                                length7 = i21;
                                function16 = function19;
                                function17 = function18;
                                i110 = i20;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                    touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                    function5 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i19) {
                            PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            z4 = z2;
            if ((i & 1572864) == 0) {
                if ((i2 & 64) != 0) {
                    i12 = 524288;
                } else {
                    if ((i & 2097152) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                    }
                    if (zChangedInstance) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                i3 |= i12;
            }
            i8 = i2 & 128;
            i9 = 12582912;
            if (i8 == 0) {
                i3 |= i9;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i9;
            }
            composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
            length = pickerGroupItemArr.length;
            i10 = 0;
            while (i10 < length) {
                int i19 = length;
                if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
                i3 |= i11;
                i10++;
                length = i19;
            }
            composerStartRestartGroup.endMovableGroup();
            if ((i3 & 14) == 0) {
                i3 |= 2;
            }
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i110) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i110) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                }
                state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                if (PickerGroup$lambda$0(state)) {
                    int length7 = pickerGroupItemArr.length;
                    selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
                final PickerGroupState pickerGroupState8 = pickerGroupStateRememberPickerGroupState;
                final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function16 = function4;
                final Function1<? super Integer, Unit> function17 = function2;
                final boolean z14 = z3;
                AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
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
                        ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                        if ((i110 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713652740, i110, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState8);
                        final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState9 = pickerGroupState8;
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m635invoke() {
                                    return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState9.getSelectedIndex()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                        PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState10 = pickerGroupState8;
                        Function3<Integer, Composer, Integer, Unit> function18 = function16;
                        final boolean z15 = z14;
                        final State<Boolean> state2 = state;
                        Function1<Integer, Unit> function19 = function17;
                        int length8 = pickerGroupItemArr3.length;
                        int i111 = 0;
                        int i112 = 0;
                        while (i112 < length8) {
                            final Function1<? super Integer, Unit> function110 = function19;
                            final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i112];
                            int i20 = i111 + 1;
                            int i21 = length8;
                            final boolean z16 = i111 == pickerGroupState10.getSelectedIndex();
                            final int i22 = i111;
                            final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChanged = composer3.changed(z16);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m636invoke() {
                                        return Boolean.valueOf(z16);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Function3<Integer, Composer, Integer, Unit> function111 = function18;
                            int i23 = i112;
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i24) {
                                    ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                    if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                        }
                                        FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                        composer4.startReplaceGroup(-1219820472);
                                        ComposerKt.sourceInformation(composer4, "126@6391L30");
                                        if (focusRequester == null) {
                                            focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                        }
                                        composer4.endReplaceGroup();
                                        PickerState pickerState = pickerGroupItem.getPickerState();
                                        String contentDescription = pickerGroupItem.getContentDescription();
                                        boolean z17 = !z16;
                                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z16 && z15) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                        Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                        Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                        boolean z18 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z16;
                                        FlingBehavior flingBehavior2 = flingBehavior;
                                        final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                        final boolean z19 = z16;
                                        final PickerGroupState pickerGroupState11 = pickerGroupState10;
                                        final int i25 = i22;
                                        final Function1<? super Integer, Unit> function112 = function110;
                                        final State<Boolean> state3 = state2;
                                        PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z17, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z18, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                int i28;
                                                Modifier modifierPointerInput;
                                                ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                if ((i27 & 6) == 0) {
                                                    i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                } else {
                                                    i28 = i27;
                                                }
                                                if ((i27 & 48) == 0) {
                                                    i28 |= composer5.changed(i26) ? 32 : 16;
                                                }
                                                if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                    }
                                                    PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                    boolean z110 = z19;
                                                    PickerGroupState pickerGroupState12 = pickerGroupState11;
                                                    int i29 = i25;
                                                    Function1<Integer, Unit> function113 = function112;
                                                    State<Boolean> state4 = state3;
                                                    composer5.startReplaceGroup(663033228);
                                                    ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                    if (PickerGroupKt.PickerGroup$lambda$0(state4) || z110) {
                                                        modifierPointerInput = Modifier.Companion;
                                                    } else {
                                                        Modifier modifier4 = Modifier.Companion;
                                                        Unit unit = Unit.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                        boolean zChanged2 = composer5.changed(pickerGroupState12) | composer5.changed(i29) | composer5.changed(function113);
                                                        PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                        if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                            pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState12, i29, function113, null);
                                                            composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer composer6 = Updater.constructor-impl(composer5);
                                                    Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                    pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z110), composer5, Integer.valueOf(i28 & 126));
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, 0, 3072, 5056);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 48);
                            composer3.startReplaceGroup(-882907323);
                            ComposerKt.sourceInformation(composer3, "170@8752L13");
                            if (i22 < pickerGroupItemArr3.length - 1 && function111 != null) {
                                function111.invoke(Integer.valueOf(i22), composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            i112 = i23 + 1;
                            length8 = i21;
                            function18 = function111;
                            function19 = function110;
                            i111 = i20;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
                function5 = function2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i110) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i110) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                }
                state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                if (PickerGroup$lambda$0(state)) {
                    int length8 = pickerGroupItemArr.length;
                    selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
                final PickerGroupState pickerGroupState9 = pickerGroupStateRememberPickerGroupState;
                final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function18 = function4;
                final Function1<? super Integer, Unit> function19 = function2;
                final boolean z15 = z3;
                AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
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
                        ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                        if ((i110 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713652740, i110, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState9);
                        final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState10 = pickerGroupState9;
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m635invoke() {
                                    return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState10.getSelectedIndex()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                        PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState11 = pickerGroupState9;
                        Function3<Integer, Composer, Integer, Unit> function110 = function18;
                        final boolean z16 = z15;
                        final State<Boolean> state2 = state;
                        Function1<Integer, Unit> function111 = function19;
                        int length9 = pickerGroupItemArr3.length;
                        int i111 = 0;
                        int i112 = 0;
                        while (i112 < length9) {
                            final Function1<? super Integer, Unit> function112 = function111;
                            final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i112];
                            int i20 = i111 + 1;
                            int i21 = length9;
                            final boolean z17 = i111 == pickerGroupState11.getSelectedIndex();
                            final int i22 = i111;
                            final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChanged = composer3.changed(z17);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m636invoke() {
                                        return Boolean.valueOf(z17);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Function3<Integer, Composer, Integer, Unit> function113 = function110;
                            int i23 = i112;
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i24) {
                                    ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                    if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                        }
                                        FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                        composer4.startReplaceGroup(-1219820472);
                                        ComposerKt.sourceInformation(composer4, "126@6391L30");
                                        if (focusRequester == null) {
                                            focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                        }
                                        composer4.endReplaceGroup();
                                        PickerState pickerState = pickerGroupItem.getPickerState();
                                        String contentDescription = pickerGroupItem.getContentDescription();
                                        boolean z18 = !z17;
                                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z17 && z16) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                        Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                        Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                        boolean z19 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z17;
                                        FlingBehavior flingBehavior2 = flingBehavior;
                                        final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                        final boolean z110 = z17;
                                        final PickerGroupState pickerGroupState12 = pickerGroupState11;
                                        final int i25 = i22;
                                        final Function1<? super Integer, Unit> function114 = function112;
                                        final State<Boolean> state3 = state2;
                                        PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z18, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z19, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                int i28;
                                                Modifier modifierPointerInput;
                                                ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                if ((i27 & 6) == 0) {
                                                    i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                } else {
                                                    i28 = i27;
                                                }
                                                if ((i27 & 48) == 0) {
                                                    i28 |= composer5.changed(i26) ? 32 : 16;
                                                }
                                                if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                    }
                                                    PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                    boolean z111 = z110;
                                                    PickerGroupState pickerGroupState13 = pickerGroupState12;
                                                    int i29 = i25;
                                                    Function1<Integer, Unit> function115 = function114;
                                                    State<Boolean> state4 = state3;
                                                    composer5.startReplaceGroup(663033228);
                                                    ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                    if (PickerGroupKt.PickerGroup$lambda$0(state4) || z111) {
                                                        modifierPointerInput = Modifier.Companion;
                                                    } else {
                                                        Modifier modifier4 = Modifier.Companion;
                                                        Unit unit = Unit.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                        boolean zChanged2 = composer5.changed(pickerGroupState13) | composer5.changed(i29) | composer5.changed(function115);
                                                        PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                        if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                            pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState13, i29, function115, null);
                                                            composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer composer6 = Updater.constructor-impl(composer5);
                                                    Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                    pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z111), composer5, Integer.valueOf(i28 & 126));
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, 0, 3072, 5056);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 48);
                            composer3.startReplaceGroup(-882907323);
                            ComposerKt.sourceInformation(composer3, "170@8752L13");
                            if (i22 < pickerGroupItemArr3.length - 1 && function113 != null) {
                                function113.invoke(Integer.valueOf(i22), composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            i112 = i23 + 1;
                            length9 = i21;
                            function110 = function113;
                            function111 = function112;
                            i111 = i20;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
                function5 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
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
                        PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        function2 = function1;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i7 = 131072;
                    } else {
                        i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if ((i2 & 64) != 0) {
                        i12 = 524288;
                    } else {
                        if ((i & 2097152) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                        }
                        if (zChangedInstance) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                    }
                    i3 |= i12;
                }
                i8 = i2 & 128;
                i9 = 12582912;
                if (i8 == 0) {
                    i3 |= i9;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                    i3 |= i9;
                }
                composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
                length = pickerGroupItemArr.length;
                i10 = 0;
                while (i10 < length) {
                    int i110 = length;
                    if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                        i11 = 4;
                    } else {
                        i11 = 0;
                    }
                    i3 |= i11;
                    i10++;
                    length = i110;
                }
                composerStartRestartGroup.endMovableGroup();
                if ((i3 & 14) == 0) {
                    i3 |= 2;
                }
                if ((4793491 & i3) == 4793490) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                    }
                    state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                    if (PickerGroup$lambda$0(state)) {
                        int length9 = pickerGroupItemArr.length;
                        selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                    final PickerGroupState pickerGroupState10 = pickerGroupStateRememberPickerGroupState;
                    final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function110 = function4;
                    final Function1<? super Integer, Unit> function111 = function2;
                    final boolean z16 = z3;
                    AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i111) {
                            ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                            if ((i111 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713652740, i111, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState10);
                            final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState11 = pickerGroupState10;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m635invoke() {
                                        return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState11.getSelectedIndex()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                            PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState12 = pickerGroupState10;
                            Function3<Integer, Composer, Integer, Unit> function112 = function110;
                            final boolean z17 = z16;
                            final State<Boolean> state2 = state;
                            Function1<Integer, Unit> function113 = function111;
                            int length10 = pickerGroupItemArr3.length;
                            int i112 = 0;
                            int i113 = 0;
                            while (i113 < length10) {
                                final Function1<? super Integer, Unit> function114 = function113;
                                final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i113];
                                int i20 = i112 + 1;
                                int i21 = length10;
                                final boolean z18 = i112 == pickerGroupState12.getSelectedIndex();
                                final int i22 = i112;
                                final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChanged = composer3.changed(z18);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m636invoke() {
                                            return Boolean.valueOf(z18);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Function3<Integer, Composer, Integer, Unit> function115 = function112;
                                int i23 = i113;
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i24) {
                                        ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                        if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                            }
                                            FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                            composer4.startReplaceGroup(-1219820472);
                                            ComposerKt.sourceInformation(composer4, "126@6391L30");
                                            if (focusRequester == null) {
                                                focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                            }
                                            composer4.endReplaceGroup();
                                            PickerState pickerState = pickerGroupItem.getPickerState();
                                            String contentDescription = pickerGroupItem.getContentDescription();
                                            boolean z19 = !z18;
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z18 && z17) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                            Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                            Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                            boolean z110 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z18;
                                            FlingBehavior flingBehavior2 = flingBehavior;
                                            final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                            final boolean z111 = z18;
                                            final PickerGroupState pickerGroupState13 = pickerGroupState12;
                                            final int i25 = i22;
                                            final Function1<? super Integer, Unit> function116 = function114;
                                            final State<Boolean> state3 = state2;
                                            PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z19, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z110, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                    invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                    int i28;
                                                    Modifier modifierPointerInput;
                                                    ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                    if ((i27 & 6) == 0) {
                                                        i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                    } else {
                                                        i28 = i27;
                                                    }
                                                    if ((i27 & 48) == 0) {
                                                        i28 |= composer5.changed(i26) ? 32 : 16;
                                                    }
                                                    if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                        }
                                                        PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                        boolean z112 = z111;
                                                        PickerGroupState pickerGroupState14 = pickerGroupState13;
                                                        int i29 = i25;
                                                        Function1<Integer, Unit> function117 = function116;
                                                        State<Boolean> state4 = state3;
                                                        composer5.startReplaceGroup(663033228);
                                                        ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                        if (PickerGroupKt.PickerGroup$lambda$0(state4) || z112) {
                                                            modifierPointerInput = Modifier.Companion;
                                                        } else {
                                                            Modifier modifier4 = Modifier.Companion;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(pickerGroupState14) | composer5.changed(i29) | composer5.changed(function117);
                                                            PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                            if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState14, i29, function117, null);
                                                                composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        composer5.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer composer6 = Updater.constructor-impl(composer5);
                                                        Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                        pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z112), composer5, Integer.valueOf(i28 & 126));
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, 0, 3072, 5056);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 48);
                                composer3.startReplaceGroup(-882907323);
                                ComposerKt.sourceInformation(composer3, "170@8752L13");
                                if (i22 < pickerGroupItemArr3.length - 1 && function115 != null) {
                                    function115.invoke(Integer.valueOf(i22), composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                i113 = i23 + 1;
                                length10 = i21;
                                function112 = function115;
                                function113 = function114;
                                i112 = i20;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                    touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                    function5 = function2;
                } else {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = (Modifier) Modifier.Companion;
                        }
                        if ((i2 & 4) != 0) {
                            z5 = false;
                            i3 &= -897;
                            pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                        } else {
                            z5 = false;
                        }
                        if (i15 != 0) {
                            function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                                public final void invoke(int i111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke(((Number) obj).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            z4 = z5;
                        }
                        if ((i2 & 64) != 0) {
                            defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                            i3 &= -3670017;
                        } else {
                            defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        } else {
                            function4 = function3;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                    }
                    state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                    if (PickerGroup$lambda$0(state)) {
                        int length10 = pickerGroupItemArr.length;
                        selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            z8 = false;
                        } else {
                            z8 = false;
                        }
                        if (z8) {
                            modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                        } else {
                            modifierScrollablePicker = Modifier.Companion;
                        }
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                    final PickerGroupState pickerGroupState11 = pickerGroupStateRememberPickerGroupState;
                    final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function112 = function4;
                    final Function1<? super Integer, Unit> function113 = function2;
                    final boolean z17 = z3;
                    AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i111) {
                            ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                            if ((i111 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(713652740, i111, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState11);
                            final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState12 = pickerGroupState11;
                            Object objRememberedValue = composer3.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m635invoke() {
                                        return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState12.getSelectedIndex()));
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                            PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                            final PickerGroupState pickerGroupState13 = pickerGroupState11;
                            Function3<Integer, Composer, Integer, Unit> function114 = function112;
                            final boolean z18 = z17;
                            final State<Boolean> state2 = state;
                            Function1<Integer, Unit> function115 = function113;
                            int length11 = pickerGroupItemArr3.length;
                            int i112 = 0;
                            int i113 = 0;
                            while (i113 < length11) {
                                final Function1<? super Integer, Unit> function116 = function115;
                                final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i113];
                                int i20 = i112 + 1;
                                int i21 = length11;
                                final boolean z19 = i112 == pickerGroupState13.getSelectedIndex();
                                final int i22 = i112;
                                final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                                boolean zChanged = composer3.changed(z19);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m636invoke() {
                                            return Boolean.valueOf(z19);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                Function3<Integer, Composer, Integer, Unit> function117 = function114;
                                int i23 = i113;
                                HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i24) {
                                        ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                        if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                            }
                                            FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                            composer4.startReplaceGroup(-1219820472);
                                            ComposerKt.sourceInformation(composer4, "126@6391L30");
                                            if (focusRequester == null) {
                                                focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                            }
                                            composer4.endReplaceGroup();
                                            PickerState pickerState = pickerGroupItem.getPickerState();
                                            String contentDescription = pickerGroupItem.getContentDescription();
                                            boolean z110 = !z19;
                                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z19 && z18) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                            Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                            Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                            boolean z111 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z19;
                                            FlingBehavior flingBehavior2 = flingBehavior;
                                            final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                            final boolean z112 = z19;
                                            final PickerGroupState pickerGroupState14 = pickerGroupState13;
                                            final int i25 = i22;
                                            final Function1<? super Integer, Unit> function118 = function116;
                                            final State<Boolean> state3 = state2;
                                            PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z110, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z111, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(4);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                    invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                    int i28;
                                                    Modifier modifierPointerInput;
                                                    ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                    if ((i27 & 6) == 0) {
                                                        i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                    } else {
                                                        i28 = i27;
                                                    }
                                                    if ((i27 & 48) == 0) {
                                                        i28 |= composer5.changed(i26) ? 32 : 16;
                                                    }
                                                    if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                        }
                                                        PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                        boolean z113 = z112;
                                                        PickerGroupState pickerGroupState15 = pickerGroupState14;
                                                        int i29 = i25;
                                                        Function1<Integer, Unit> function119 = function118;
                                                        State<Boolean> state4 = state3;
                                                        composer5.startReplaceGroup(663033228);
                                                        ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                        if (PickerGroupKt.PickerGroup$lambda$0(state4) || z113) {
                                                            modifierPointerInput = Modifier.Companion;
                                                        } else {
                                                            Modifier modifier4 = Modifier.Companion;
                                                            Unit unit = Unit.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                            boolean zChanged2 = composer5.changed(pickerGroupState15) | composer5.changed(i29) | composer5.changed(function119);
                                                            PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                            if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                                pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState15, i29, function119, null);
                                                                composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                            }
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        composer5.endReplaceGroup();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer composer6 = Updater.constructor-impl(composer5);
                                                        Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                        pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z113), composer5, Integer.valueOf(i28 & 126));
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }, composer4, 54), composer4, 0, 3072, 5056);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }, composer3, 54), composer3, 48);
                                composer3.startReplaceGroup(-882907323);
                                ComposerKt.sourceInformation(composer3, "170@8752L13");
                                if (i22 < pickerGroupItemArr3.length - 1 && function117 != null) {
                                    function117.invoke(Integer.valueOf(i22), composer3, 0);
                                }
                                composer3.endReplaceGroup();
                                i113 = i23 + 1;
                                length11 = i21;
                                function114 = function117;
                                function115 = function116;
                                i112 = i20;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                    touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                    modifier3 = modifier2;
                    z6 = z3;
                    z7 = z4;
                    function5 = function2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i111) {
                            PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                            PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 196608;
            z4 = z2;
            if ((i & 1572864) == 0) {
                if ((i2 & 64) != 0) {
                    i12 = 524288;
                } else {
                    if ((i & 2097152) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                    }
                    if (zChangedInstance) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                i3 |= i12;
            }
            i8 = i2 & 128;
            i9 = 12582912;
            if (i8 == 0) {
                i3 |= i9;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i9;
            }
            composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
            length = pickerGroupItemArr.length;
            i10 = 0;
            while (i10 < length) {
                int i111 = length;
                if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
                i3 |= i11;
                i10++;
                length = i111;
            }
            composerStartRestartGroup.endMovableGroup();
            if ((i3 & 14) == 0) {
                i3 |= 2;
            }
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i112) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i112) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                }
                state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                if (PickerGroup$lambda$0(state)) {
                    int length11 = pickerGroupItemArr.length;
                    selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
                final PickerGroupState pickerGroupState12 = pickerGroupStateRememberPickerGroupState;
                final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function114 = function4;
                final Function1<? super Integer, Unit> function115 = function2;
                final boolean z18 = z3;
                AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i112) {
                        ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                        if ((i112 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713652740, i112, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState12);
                        final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState13 = pickerGroupState12;
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m635invoke() {
                                    return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState13.getSelectedIndex()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                        PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState14 = pickerGroupState12;
                        Function3<Integer, Composer, Integer, Unit> function116 = function114;
                        final boolean z19 = z18;
                        final State<Boolean> state2 = state;
                        Function1<Integer, Unit> function117 = function115;
                        int length12 = pickerGroupItemArr3.length;
                        int i113 = 0;
                        int i114 = 0;
                        while (i114 < length12) {
                            final Function1<? super Integer, Unit> function118 = function117;
                            final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i114];
                            int i20 = i113 + 1;
                            int i21 = length12;
                            final boolean z110 = i113 == pickerGroupState14.getSelectedIndex();
                            final int i22 = i113;
                            final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChanged = composer3.changed(z110);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m636invoke() {
                                        return Boolean.valueOf(z110);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Function3<Integer, Composer, Integer, Unit> function119 = function116;
                            int i23 = i114;
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i24) {
                                    ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                    if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                        }
                                        FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                        composer4.startReplaceGroup(-1219820472);
                                        ComposerKt.sourceInformation(composer4, "126@6391L30");
                                        if (focusRequester == null) {
                                            focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                        }
                                        composer4.endReplaceGroup();
                                        PickerState pickerState = pickerGroupItem.getPickerState();
                                        String contentDescription = pickerGroupItem.getContentDescription();
                                        boolean z111 = !z110;
                                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z110 && z19) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                        Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                        Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                        boolean z112 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z110;
                                        FlingBehavior flingBehavior2 = flingBehavior;
                                        final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                        final boolean z113 = z110;
                                        final PickerGroupState pickerGroupState15 = pickerGroupState14;
                                        final int i25 = i22;
                                        final Function1<? super Integer, Unit> function1110 = function118;
                                        final State<Boolean> state3 = state2;
                                        PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z111, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z112, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                int i28;
                                                Modifier modifierPointerInput;
                                                ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                if ((i27 & 6) == 0) {
                                                    i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                } else {
                                                    i28 = i27;
                                                }
                                                if ((i27 & 48) == 0) {
                                                    i28 |= composer5.changed(i26) ? 32 : 16;
                                                }
                                                if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                    }
                                                    PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                    boolean z114 = z113;
                                                    PickerGroupState pickerGroupState16 = pickerGroupState15;
                                                    int i29 = i25;
                                                    Function1<Integer, Unit> function1111 = function1110;
                                                    State<Boolean> state4 = state3;
                                                    composer5.startReplaceGroup(663033228);
                                                    ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                    if (PickerGroupKt.PickerGroup$lambda$0(state4) || z114) {
                                                        modifierPointerInput = Modifier.Companion;
                                                    } else {
                                                        Modifier modifier4 = Modifier.Companion;
                                                        Unit unit = Unit.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                        boolean zChanged2 = composer5.changed(pickerGroupState16) | composer5.changed(i29) | composer5.changed(function1111);
                                                        PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                        if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                            pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState16, i29, function1111, null);
                                                            composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer composer6 = Updater.constructor-impl(composer5);
                                                    Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                    pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z114), composer5, Integer.valueOf(i28 & 126));
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, 0, 3072, 5056);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 48);
                            composer3.startReplaceGroup(-882907323);
                            ComposerKt.sourceInformation(composer3, "170@8752L13");
                            if (i22 < pickerGroupItemArr3.length - 1 && function119 != null) {
                                function119.invoke(Integer.valueOf(i22), composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            i114 = i23 + 1;
                            length12 = i21;
                            function116 = function119;
                            function117 = function118;
                            i113 = i20;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
                function5 = function2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i112) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i112) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                }
                state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                if (PickerGroup$lambda$0(state)) {
                    int length12 = pickerGroupItemArr.length;
                    selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
                final PickerGroupState pickerGroupState13 = pickerGroupStateRememberPickerGroupState;
                final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function116 = function4;
                final Function1<? super Integer, Unit> function117 = function2;
                final boolean z19 = z3;
                AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i112) {
                        ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                        if ((i112 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713652740, i112, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState13);
                        final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState14 = pickerGroupState13;
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m635invoke() {
                                    return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState14.getSelectedIndex()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                        PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState15 = pickerGroupState13;
                        Function3<Integer, Composer, Integer, Unit> function118 = function116;
                        final boolean z110 = z19;
                        final State<Boolean> state2 = state;
                        Function1<Integer, Unit> function119 = function117;
                        int length13 = pickerGroupItemArr3.length;
                        int i113 = 0;
                        int i114 = 0;
                        while (i114 < length13) {
                            final Function1<? super Integer, Unit> function1110 = function119;
                            final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i114];
                            int i20 = i113 + 1;
                            int i21 = length13;
                            final boolean z111 = i113 == pickerGroupState15.getSelectedIndex();
                            final int i22 = i113;
                            final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChanged = composer3.changed(z111);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m636invoke() {
                                        return Boolean.valueOf(z111);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Function3<Integer, Composer, Integer, Unit> function1111 = function118;
                            int i23 = i114;
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i24) {
                                    ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                    if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                        }
                                        FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                        composer4.startReplaceGroup(-1219820472);
                                        ComposerKt.sourceInformation(composer4, "126@6391L30");
                                        if (focusRequester == null) {
                                            focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                        }
                                        composer4.endReplaceGroup();
                                        PickerState pickerState = pickerGroupItem.getPickerState();
                                        String contentDescription = pickerGroupItem.getContentDescription();
                                        boolean z112 = !z111;
                                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z111 && z110) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                        Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                        Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                        boolean z113 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z111;
                                        FlingBehavior flingBehavior2 = flingBehavior;
                                        final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                        final boolean z114 = z111;
                                        final PickerGroupState pickerGroupState16 = pickerGroupState15;
                                        final int i25 = i22;
                                        final Function1<? super Integer, Unit> function1112 = function1110;
                                        final State<Boolean> state3 = state2;
                                        PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z112, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z113, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                int i28;
                                                Modifier modifierPointerInput;
                                                ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                if ((i27 & 6) == 0) {
                                                    i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                } else {
                                                    i28 = i27;
                                                }
                                                if ((i27 & 48) == 0) {
                                                    i28 |= composer5.changed(i26) ? 32 : 16;
                                                }
                                                if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                    }
                                                    PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                    boolean z115 = z114;
                                                    PickerGroupState pickerGroupState17 = pickerGroupState16;
                                                    int i29 = i25;
                                                    Function1<Integer, Unit> function1113 = function1112;
                                                    State<Boolean> state4 = state3;
                                                    composer5.startReplaceGroup(663033228);
                                                    ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                    if (PickerGroupKt.PickerGroup$lambda$0(state4) || z115) {
                                                        modifierPointerInput = Modifier.Companion;
                                                    } else {
                                                        Modifier modifier4 = Modifier.Companion;
                                                        Unit unit = Unit.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                        boolean zChanged2 = composer5.changed(pickerGroupState17) | composer5.changed(i29) | composer5.changed(function1113);
                                                        PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                        if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                            pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState17, i29, function1113, null);
                                                            composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer composer6 = Updater.constructor-impl(composer5);
                                                    Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                    pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z115), composer5, Integer.valueOf(i28 & 126));
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, 0, 3072, 5056);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 48);
                            composer3.startReplaceGroup(-882907323);
                            ComposerKt.sourceInformation(composer3, "170@8752L13");
                            if (i22 < pickerGroupItemArr3.length - 1 && function1111 != null) {
                                function1111.invoke(Integer.valueOf(i22), composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            i114 = i23 + 1;
                            length13 = i21;
                            function118 = function1111;
                            function119 = function1110;
                            i113 = i20;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
                function5 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i112) {
                        PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        z3 = z;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i7 = 131072;
                } else {
                    i7 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i7;
            }
            if ((i & 1572864) == 0) {
                if ((i2 & 64) != 0) {
                    i12 = 524288;
                } else {
                    if ((i & 2097152) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                    }
                    if (zChangedInstance) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                }
                i3 |= i12;
            }
            i8 = i2 & 128;
            i9 = 12582912;
            if (i8 == 0) {
                i3 |= i9;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
                i3 |= i9;
            }
            composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
            ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
            length = pickerGroupItemArr.length;
            i10 = 0;
            while (i10 < length) {
                int i112 = length;
                if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
                i3 |= i11;
                i10++;
                length = i112;
            }
            composerStartRestartGroup.endMovableGroup();
            if ((i3 & 14) == 0) {
                i3 |= 2;
            }
            if ((4793491 & i3) == 4793490) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                }
                state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                if (PickerGroup$lambda$0(state)) {
                    int length13 = pickerGroupItemArr.length;
                    selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
                final PickerGroupState pickerGroupState14 = pickerGroupStateRememberPickerGroupState;
                final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function118 = function4;
                final Function1<? super Integer, Unit> function119 = function2;
                final boolean z110 = z3;
                AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i113) {
                        ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                        if ((i113 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713652740, i113, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState14);
                        final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState15 = pickerGroupState14;
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m635invoke() {
                                    return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState15.getSelectedIndex()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                        PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState16 = pickerGroupState14;
                        Function3<Integer, Composer, Integer, Unit> function1110 = function118;
                        final boolean z111 = z110;
                        final State<Boolean> state2 = state;
                        Function1<Integer, Unit> function1111 = function119;
                        int length14 = pickerGroupItemArr3.length;
                        int i114 = 0;
                        int i115 = 0;
                        while (i115 < length14) {
                            final Function1<? super Integer, Unit> function1112 = function1111;
                            final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i115];
                            int i20 = i114 + 1;
                            int i21 = length14;
                            final boolean z112 = i114 == pickerGroupState16.getSelectedIndex();
                            final int i22 = i114;
                            final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChanged = composer3.changed(z112);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m636invoke() {
                                        return Boolean.valueOf(z112);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Function3<Integer, Composer, Integer, Unit> function1113 = function1110;
                            int i23 = i115;
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i24) {
                                    ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                    if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                        }
                                        FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                        composer4.startReplaceGroup(-1219820472);
                                        ComposerKt.sourceInformation(composer4, "126@6391L30");
                                        if (focusRequester == null) {
                                            focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                        }
                                        composer4.endReplaceGroup();
                                        PickerState pickerState = pickerGroupItem.getPickerState();
                                        String contentDescription = pickerGroupItem.getContentDescription();
                                        boolean z113 = !z112;
                                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z112 && z111) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                        Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                        Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                        boolean z114 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z112;
                                        FlingBehavior flingBehavior2 = flingBehavior;
                                        final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                        final boolean z115 = z112;
                                        final PickerGroupState pickerGroupState17 = pickerGroupState16;
                                        final int i25 = i22;
                                        final Function1<? super Integer, Unit> function1114 = function1112;
                                        final State<Boolean> state3 = state2;
                                        PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z113, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z114, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                int i28;
                                                Modifier modifierPointerInput;
                                                ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                if ((i27 & 6) == 0) {
                                                    i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                } else {
                                                    i28 = i27;
                                                }
                                                if ((i27 & 48) == 0) {
                                                    i28 |= composer5.changed(i26) ? 32 : 16;
                                                }
                                                if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                    }
                                                    PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                    boolean z116 = z115;
                                                    PickerGroupState pickerGroupState18 = pickerGroupState17;
                                                    int i29 = i25;
                                                    Function1<Integer, Unit> function1115 = function1114;
                                                    State<Boolean> state4 = state3;
                                                    composer5.startReplaceGroup(663033228);
                                                    ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                    if (PickerGroupKt.PickerGroup$lambda$0(state4) || z116) {
                                                        modifierPointerInput = Modifier.Companion;
                                                    } else {
                                                        Modifier modifier4 = Modifier.Companion;
                                                        Unit unit = Unit.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                        boolean zChanged2 = composer5.changed(pickerGroupState18) | composer5.changed(i29) | composer5.changed(function1115);
                                                        PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                        if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                            pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState18, i29, function1115, null);
                                                            composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer composer6 = Updater.constructor-impl(composer5);
                                                    Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                    pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z116), composer5, Integer.valueOf(i28 & 126));
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, 0, 3072, 5056);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 48);
                            composer3.startReplaceGroup(-882907323);
                            ComposerKt.sourceInformation(composer3, "170@8752L13");
                            if (i22 < pickerGroupItemArr3.length - 1 && function1113 != null) {
                                function1113.invoke(Integer.valueOf(i22), composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            i115 = i23 + 1;
                            length14 = i21;
                            function1110 = function1113;
                            function1111 = function1112;
                            i114 = i20;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
                function5 = function2;
            } else {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = (Modifier) Modifier.Companion;
                    }
                    if ((i2 & 4) != 0) {
                        z5 = false;
                        i3 &= -897;
                        pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                    } else {
                        z5 = false;
                    }
                    if (i15 != 0) {
                        function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                            public final void invoke(int i113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke(((Number) obj).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        z4 = z5;
                    }
                    if ((i2 & 64) != 0) {
                        defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                        i3 &= -3670017;
                    } else {
                        defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    } else {
                        function4 = function3;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
                }
                state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
                if (PickerGroup$lambda$0(state)) {
                    int length14 = pickerGroupItemArr.length;
                    selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                    } else {
                        modifierScrollablePicker = Modifier.Companion;
                    }
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
                final PickerGroupState pickerGroupState15 = pickerGroupStateRememberPickerGroupState;
                final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function1110 = function4;
                final Function1<? super Integer, Unit> function1111 = function2;
                final boolean z111 = z3;
                AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i113) {
                        ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                        if ((i113 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(713652740, i113, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState15);
                        final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState16 = pickerGroupState15;
                        Object objRememberedValue = composer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m635invoke() {
                                    return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState16.getSelectedIndex()));
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                        PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                        final PickerGroupState pickerGroupState17 = pickerGroupState15;
                        Function3<Integer, Composer, Integer, Unit> function1112 = function1110;
                        final boolean z112 = z111;
                        final State<Boolean> state2 = state;
                        Function1<Integer, Unit> function1113 = function1111;
                        int length15 = pickerGroupItemArr3.length;
                        int i114 = 0;
                        int i115 = 0;
                        while (i115 < length15) {
                            final Function1<? super Integer, Unit> function1114 = function1113;
                            final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i115];
                            int i20 = i114 + 1;
                            int i21 = length15;
                            final boolean z113 = i114 == pickerGroupState17.getSelectedIndex();
                            final int i22 = i114;
                            final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                            boolean zChanged = composer3.changed(z113);
                            Object objRememberedValue2 = composer3.rememberedValue();
                            if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                                objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m636invoke() {
                                        return Boolean.valueOf(z113);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Function3<Integer, Composer, Integer, Unit> function1115 = function1112;
                            int i23 = i115;
                            HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i24) {
                                    ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                    if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                        }
                                        FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                        composer4.startReplaceGroup(-1219820472);
                                        ComposerKt.sourceInformation(composer4, "126@6391L30");
                                        if (focusRequester == null) {
                                            focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                        }
                                        composer4.endReplaceGroup();
                                        PickerState pickerState = pickerGroupItem.getPickerState();
                                        String contentDescription = pickerGroupItem.getContentDescription();
                                        boolean z114 = !z113;
                                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z113 && z112) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                        Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                        Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                        boolean z115 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z113;
                                        FlingBehavior flingBehavior2 = flingBehavior;
                                        final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                        final boolean z116 = z113;
                                        final PickerGroupState pickerGroupState18 = pickerGroupState17;
                                        final int i25 = i22;
                                        final Function1<? super Integer, Unit> function1116 = function1114;
                                        final State<Boolean> state3 = state2;
                                        PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z114, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z115, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(4);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                                invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                                int i28;
                                                Modifier modifierPointerInput;
                                                ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                                if ((i27 & 6) == 0) {
                                                    i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                                } else {
                                                    i28 = i27;
                                                }
                                                if ((i27 & 48) == 0) {
                                                    i28 |= composer5.changed(i26) ? 32 : 16;
                                                }
                                                if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                    }
                                                    PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                    boolean z117 = z116;
                                                    PickerGroupState pickerGroupState19 = pickerGroupState18;
                                                    int i29 = i25;
                                                    Function1<Integer, Unit> function1117 = function1116;
                                                    State<Boolean> state4 = state3;
                                                    composer5.startReplaceGroup(663033228);
                                                    ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                    if (PickerGroupKt.PickerGroup$lambda$0(state4) || z117) {
                                                        modifierPointerInput = Modifier.Companion;
                                                    } else {
                                                        Modifier modifier4 = Modifier.Companion;
                                                        Unit unit = Unit.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                        boolean zChanged2 = composer5.changed(pickerGroupState19) | composer5.changed(i29) | composer5.changed(function1117);
                                                        PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                        if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                            pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState19, i29, function1117, null);
                                                            composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    composer5.endReplaceGroup();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer composer6 = Updater.constructor-impl(composer5);
                                                    Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                    pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z117), composer5, Integer.valueOf(i28 & 126));
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endNode();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }, composer4, 54), composer4, 0, 3072, 5056);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54), composer3, 48);
                            composer3.startReplaceGroup(-882907323);
                            ComposerKt.sourceInformation(composer3, "170@8752L13");
                            if (i22 < pickerGroupItemArr3.length - 1 && function1115 != null) {
                                function1115.invoke(Integer.valueOf(i22), composer3, 0);
                            }
                            composer3.endReplaceGroup();
                            i115 = i23 + 1;
                            length15 = i21;
                            function1112 = function1115;
                            function1113 = function1114;
                            i114 = i20;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
                touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
                modifier3 = modifier2;
                z6 = z3;
                z7 = z4;
                function5 = function2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i113) {
                        PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                        PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 196608;
        z4 = z2;
        if ((i & 1572864) == 0) {
            if ((i2 & 64) != 0) {
                i12 = 524288;
            } else {
                if ((i & 2097152) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(touchExplorationStateProvider);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(touchExplorationStateProvider);
                }
                if (zChangedInstance) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
            }
            i3 |= i12;
        }
        i8 = i2 & 128;
        i9 = 12582912;
        if (i8 == 0) {
            i3 |= i9;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
            }
            i3 |= i9;
        }
        composerStartRestartGroup.startMovableGroup(1134531887, Integer.valueOf(pickerGroupItemArr.length));
        ComposerKt.sourceInformation(composerStartRestartGroup, "90@4643L26");
        length = pickerGroupItemArr.length;
        i10 = 0;
        while (i10 < length) {
            int i113 = length;
            if (composerStartRestartGroup.changed(pickerGroupItemArr[i10])) {
                i11 = 4;
            } else {
                i11 = 0;
            }
            i3 |= i11;
            i10++;
            length = i113;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i3 & 14) == 0) {
            i3 |= 2;
        }
        if ((4793491 & i3) == 4793490) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    z5 = false;
                    i3 &= -897;
                    pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                } else {
                    z5 = false;
                }
                if (i15 != 0) {
                    function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                        public final void invoke(int i114) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z4 = z5;
                }
                if ((i2 & 64) != 0) {
                    defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                    i3 &= -3670017;
                } else {
                    defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                }
                if (i8 != 0) {
                    function4 = null;
                } else {
                    function4 = function3;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    z5 = false;
                    i3 &= -897;
                    pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                } else {
                    z5 = false;
                }
                if (i15 != 0) {
                    function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                        public final void invoke(int i114) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z4 = z5;
                }
                if ((i2 & 64) != 0) {
                    defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                    i3 &= -3670017;
                } else {
                    defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                }
                if (i8 != 0) {
                    function4 = null;
                } else {
                    function4 = function3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
            }
            state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
            if (PickerGroup$lambda$0(state)) {
                int length15 = pickerGroupItemArr.length;
                selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                if (selectedIndex >= 0) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                if (z8) {
                    modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
            } else {
                modifierScrollablePicker = Modifier.Companion;
            }
            final PickerGroupState pickerGroupState16 = pickerGroupStateRememberPickerGroupState;
            final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function1112 = function4;
            final Function1<? super Integer, Unit> function1113 = function2;
            final boolean z112 = z3;
            AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
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
                    ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                    if ((i114 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713652740, i114, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                    boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState16);
                    final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                    final PickerGroupState pickerGroupState17 = pickerGroupState16;
                    Object objRememberedValue = composer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m635invoke() {
                                return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState17.getSelectedIndex()));
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                    PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                    final PickerGroupState pickerGroupState18 = pickerGroupState16;
                    Function3<Integer, Composer, Integer, Unit> function1114 = function1112;
                    final boolean z113 = z112;
                    final State<Boolean> state2 = state;
                    Function1<Integer, Unit> function1115 = function1113;
                    int length16 = pickerGroupItemArr3.length;
                    int i115 = 0;
                    int i116 = 0;
                    while (i116 < length16) {
                        final Function1<? super Integer, Unit> function1116 = function1115;
                        final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i116];
                        int i20 = i115 + 1;
                        int i21 = length16;
                        final boolean z114 = i115 == pickerGroupState18.getSelectedIndex();
                        final int i22 = i115;
                        final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChanged = composer3.changed(z114);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m636invoke() {
                                    return Boolean.valueOf(z114);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Function3<Integer, Composer, Integer, Unit> function1117 = function1114;
                        int i23 = i116;
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i24) {
                                ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                    }
                                    FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                    composer4.startReplaceGroup(-1219820472);
                                    ComposerKt.sourceInformation(composer4, "126@6391L30");
                                    if (focusRequester == null) {
                                        focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    PickerState pickerState = pickerGroupItem.getPickerState();
                                    String contentDescription = pickerGroupItem.getContentDescription();
                                    boolean z115 = !z114;
                                    Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z114 && z113) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                    Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                    Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                    boolean z116 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z114;
                                    FlingBehavior flingBehavior2 = flingBehavior;
                                    final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                    final boolean z117 = z114;
                                    final PickerGroupState pickerGroupState19 = pickerGroupState18;
                                    final int i25 = i22;
                                    final Function1<? super Integer, Unit> function1118 = function1116;
                                    final State<Boolean> state3 = state2;
                                    PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z115, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z116, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                            invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                            int i28;
                                            Modifier modifierPointerInput;
                                            ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                            if ((i27 & 6) == 0) {
                                                i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                            } else {
                                                i28 = i27;
                                            }
                                            if ((i27 & 48) == 0) {
                                                i28 |= composer5.changed(i26) ? 32 : 16;
                                            }
                                            if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                }
                                                PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                boolean z118 = z117;
                                                PickerGroupState pickerGroupState110 = pickerGroupState19;
                                                int i29 = i25;
                                                Function1<Integer, Unit> function1119 = function1118;
                                                State<Boolean> state4 = state3;
                                                composer5.startReplaceGroup(663033228);
                                                ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                if (PickerGroupKt.PickerGroup$lambda$0(state4) || z118) {
                                                    modifierPointerInput = Modifier.Companion;
                                                } else {
                                                    Modifier modifier4 = Modifier.Companion;
                                                    Unit unit = Unit.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                    boolean zChanged2 = composer5.changed(pickerGroupState110) | composer5.changed(i29) | composer5.changed(function1119);
                                                    PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                    if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                        pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState110, i29, function1119, null);
                                                        composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                }
                                                composer5.endReplaceGroup();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer composer6 = Updater.constructor-impl(composer5);
                                                Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z118), composer5, Integer.valueOf(i28 & 126));
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }, composer4, 54), composer4, 0, 3072, 5056);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, composer3, 54), composer3, 48);
                        composer3.startReplaceGroup(-882907323);
                        ComposerKt.sourceInformation(composer3, "170@8752L13");
                        if (i22 < pickerGroupItemArr3.length - 1 && function1117 != null) {
                            function1117.invoke(Integer.valueOf(i22), composer3, 0);
                        }
                        composer3.endReplaceGroup();
                        i116 = i23 + 1;
                        length16 = i21;
                        function1114 = function1117;
                        function1115 = function1116;
                        i115 = i20;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
            touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
            modifier3 = modifier2;
            z6 = z3;
            z7 = z4;
            function5 = function2;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    z5 = false;
                    i3 &= -897;
                    pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                } else {
                    z5 = false;
                }
                if (i15 != 0) {
                    function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                        public final void invoke(int i114) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z4 = z5;
                }
                if ((i2 & 64) != 0) {
                    defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                    i3 &= -3670017;
                } else {
                    defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                }
                if (i8 != 0) {
                    function4 = null;
                } else {
                    function4 = function3;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i2 & 4) != 0) {
                    z5 = false;
                    i3 &= -897;
                    pickerGroupStateRememberPickerGroupState = rememberPickerGroupState(0, composerStartRestartGroup, 0, 1);
                } else {
                    z5 = false;
                }
                if (i15 != 0) {
                    function2 = new Function1<Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.1
                        public final void invoke(int i114) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    z4 = z5;
                }
                if ((i2 & 64) != 0) {
                    defaultTouchExplorationStateProvider = new DefaultTouchExplorationStateProvider();
                    i3 &= -3670017;
                } else {
                    defaultTouchExplorationStateProvider = touchExplorationStateProvider;
                }
                if (i8 != 0) {
                    function4 = null;
                } else {
                    function4 = function3;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1300754617, i3, -1, "androidx.wear.compose.material.PickerGroup (PickerGroup.kt:97)");
            }
            state = defaultTouchExplorationStateProvider.touchExplorationState(composerStartRestartGroup, (i3 >> 18) & 14);
            if (PickerGroup$lambda$0(state)) {
                int length16 = pickerGroupItemArr.length;
                selectedIndex = pickerGroupStateRememberPickerGroupState.getSelectedIndex();
                if (selectedIndex >= 0) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                if (z8) {
                    modifierScrollablePicker = scrollablePicker(Modifier.Companion, pickerGroupItemArr[pickerGroupStateRememberPickerGroupState.getSelectedIndex()].getPickerState());
                } else {
                    modifierScrollablePicker = Modifier.Companion;
                }
            } else {
                modifierScrollablePicker = Modifier.Companion;
            }
            final PickerGroupState pickerGroupState17 = pickerGroupStateRememberPickerGroupState;
            final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function1114 = function4;
            final Function1<? super Integer, Unit> function1115 = function2;
            final boolean z113 = z3;
            AutoCenteringRow(modifier2.then(modifierScrollablePicker), z4, ComposableLambdaKt.rememberComposableLambda(713652740, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.2
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
                    ComposerKt.sourceInformation(composer3, "C119@5940L81,119@5895L130,*124@6200L45,125@6303L18,125@6323L2357,125@6258L2422:PickerGroup.kt#gj9v0t");
                    if ((i114 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(713652740, i114, -1, "androidx.wear.compose.material.PickerGroup.<anonymous> (PickerGroup.kt:119)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, -882995424, "CC(remember):PickerGroup.kt#9igjgp");
                    boolean zChangedInstance2 = composer3.changedInstance(pickerGroupItemArr) | composer3.changed(pickerGroupState17);
                    final PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                    final PickerGroupState pickerGroupState18 = pickerGroupState17;
                    Object objRememberedValue = composer3.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m635invoke() {
                                return Boolean.valueOf(!ArraysKt.getIndices(pickerGroupItemArr2).contains(pickerGroupState18.getSelectedIndex()));
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue, ComposableSingletons$PickerGroupKt.INSTANCE.m578getLambda1$compose_material_release(), composer3, 48);
                    PickerGroupItem[] pickerGroupItemArr3 = pickerGroupItemArr;
                    final PickerGroupState pickerGroupState19 = pickerGroupState17;
                    Function3<Integer, Composer, Integer, Unit> function1116 = function1114;
                    final boolean z114 = z113;
                    final State<Boolean> state2 = state;
                    Function1<Integer, Unit> function1117 = function1115;
                    int length17 = pickerGroupItemArr3.length;
                    int i115 = 0;
                    int i116 = 0;
                    while (i116 < length17) {
                        final Function1<? super Integer, Unit> function1118 = function1117;
                        final PickerGroupItem pickerGroupItem = pickerGroupItemArr3[i116];
                        int i20 = i115 + 1;
                        int i21 = length17;
                        final boolean z115 = i115 == pickerGroupState19.getSelectedIndex();
                        final int i22 = i115;
                        final FlingBehavior flingBehavior = PickerDefaults.INSTANCE.flingBehavior(pickerGroupItem.getPickerState(), null, composer3, 384, 2);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1753546816, "CC(remember):PickerGroup.kt#9igjgp");
                        boolean zChanged = composer3.changed(z115);
                        Object objRememberedValue2 = composer3.rememberedValue();
                        if (zChanged || objRememberedValue2 == Composer.Companion.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<Boolean>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m636invoke() {
                                    return Boolean.valueOf(z115);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Function3<Integer, Composer, Integer, Unit> function1119 = function1116;
                        int i23 = i116;
                        HierarchicalFocusCoordinatorKt.HierarchicalFocusCoordinator((Function0) objRememberedValue2, ComposableLambdaKt.rememberComposableLambda(-1047791432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i24) {
                                ComposerKt.sourceInformation(composer4, "C144@7449L1199,127@6438L2228:PickerGroup.kt#gj9v0t");
                                if ((i24 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1047791432, i24, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:126)");
                                    }
                                    FocusRequester focusRequester = pickerGroupItem.getFocusRequester();
                                    composer4.startReplaceGroup(-1219820472);
                                    ComposerKt.sourceInformation(composer4, "126@6391L30");
                                    if (focusRequester == null) {
                                        focusRequester = HierarchicalFocusCoordinatorKt.rememberActiveFocusRequester(composer4, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    PickerState pickerState = pickerGroupItem.getPickerState();
                                    String contentDescription = pickerGroupItem.getContentDescription();
                                    boolean z116 = !z115;
                                    Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(pickerGroupItem.getModifier().then((z115 && z114) ? PickerGroupKt.autoCenteringTarget(Modifier.Companion) : Modifier.Companion), focusRequester);
                                    Function3<BoxScope, Composer, Integer, Unit> readOnlyLabel = pickerGroupItem.getReadOnlyLabel();
                                    Function0<Unit> onSelected = pickerGroupItem.getOnSelected();
                                    boolean z117 = !PickerGroupKt.PickerGroup$lambda$0(state2) || z115;
                                    FlingBehavior flingBehavior2 = flingBehavior;
                                    final PickerGroupItem pickerGroupItem2 = pickerGroupItem;
                                    final boolean z118 = z115;
                                    final PickerGroupState pickerGroupState110 = pickerGroupState19;
                                    final int i25 = i22;
                                    final Function1<? super Integer, Unit> function11110 = function1118;
                                    final State<Boolean> state3 = state2;
                                    PickerKt.m642PickerkzdTruM(pickerState, contentDescription, modifierFocusRequester, z116, readOnlyLabel, onSelected, null, 0.0f, 0.0f, 0L, flingBehavior2, z117, null, ComposableLambdaKt.rememberComposableLambda(-1477267982, true, new Function4<PickerScope, Integer, Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$PickerGroup$2$2$2.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                            invoke((PickerScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(PickerScope pickerScope, int i26, Composer composer5, int i27) {
                                            int i28;
                                            Modifier modifierPointerInput;
                                            ComposerKt.sourceInformation(composer5, "C*146@7537L1063:PickerGroup.kt#gj9v0t");
                                            if ((i27 & 6) == 0) {
                                                i28 = ((i27 & 8) == 0 ? composer5.changed(pickerScope) : composer5.changedInstance(pickerScope) ? 4 : 2) | i27;
                                            } else {
                                                i28 = i27;
                                            }
                                            if ((i27 & 48) == 0) {
                                                i28 |= composer5.changed(i26) ? 32 : 16;
                                            }
                                            if ((i28 & 147) != 146 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1477267982, i28, -1, "androidx.wear.compose.material.PickerGroup.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PickerGroup.kt:145)");
                                                }
                                                PickerGroupItem pickerGroupItem3 = pickerGroupItem2;
                                                boolean z119 = z118;
                                                PickerGroupState pickerGroupState111 = pickerGroupState110;
                                                int i29 = i25;
                                                Function1<Integer, Unit> function11111 = function11110;
                                                State<Boolean> state4 = state3;
                                                composer5.startReplaceGroup(663033228);
                                                ComposerKt.sourceInformation(composer5, "149@7743L727");
                                                if (PickerGroupKt.PickerGroup$lambda$0(state4) || z119) {
                                                    modifierPointerInput = Modifier.Companion;
                                                } else {
                                                    Modifier modifier4 = Modifier.Companion;
                                                    Unit unit = Unit.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1036133886, "CC(remember):PickerGroup.kt#9igjgp");
                                                    boolean zChanged2 = composer5.changed(pickerGroupState111) | composer5.changed(i29) | composer5.changed(function11111);
                                                    PickerGroupKt$PickerGroup$2$2$2$1$1$1$1 pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = composer5.rememberedValue();
                                                    if (zChanged2 || pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue == Composer.Companion.getEmpty()) {
                                                        pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue = new PickerGroupKt$PickerGroup$2$2$2$1$1$1$1(pickerGroupState111, i29, function11111, null);
                                                        composer5.updateRememberedValue(pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier4, unit, (Function2) pickerGroupKt$PickerGroup$2$2$2$1$1$1$1RememberedValue);
                                                }
                                                composer5.endReplaceGroup();
                                                ComposerKt.sourceInformationMarkerStart(composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer5, modifierPointerInput);
                                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                ComposerKt.sourceInformationMarkerStart(composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer composer6 = Updater.constructor-impl(composer5);
                                                Updater.set-impl(composer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                                                Updater.set-impl(composer6, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                if (composer6.getInserting() || !Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    composer6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    composer6.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.set-impl(composer6, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                                                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1366256170, "C163@8535L35:PickerGroup.kt#gj9v0t");
                                                pickerGroupItem3.getOption().invoke(pickerScope, Integer.valueOf(i26), Boolean.valueOf(z119), composer5, Integer.valueOf(i28 & 126));
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endNode();
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }, composer4, 54), composer4, 0, 3072, 5056);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, composer3, 54), composer3, 48);
                        composer3.startReplaceGroup(-882907323);
                        ComposerKt.sourceInformation(composer3, "170@8752L13");
                        if (i22 < pickerGroupItemArr3.length - 1 && function1119 != null) {
                            function1119.invoke(Integer.valueOf(i22), composer3, 0);
                        }
                        composer3.endReplaceGroup();
                        i116 = i23 + 1;
                        length17 = i21;
                        function1116 = function1119;
                        function1117 = function1118;
                        i115 = i20;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 12) & 112) | 384, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            pickerGroupState2 = pickerGroupStateRememberPickerGroupState;
            touchExplorationStateProvider2 = defaultTouchExplorationStateProvider;
            modifier3 = modifier2;
            z6 = z3;
            z7 = z4;
            function5 = function2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.PickerGroup.3
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
                    PickerGroupItem[] pickerGroupItemArr2 = pickerGroupItemArr;
                    PickerGroupKt.PickerGroup((PickerGroupItem[]) Arrays.copyOf(pickerGroupItemArr2, pickerGroupItemArr2.length), modifier3, pickerGroupState2, function5, z6, z7, touchExplorationStateProvider2, function4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final PickerGroupState rememberPickerGroupState(final int i, Composer composer, int i2, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1271810622, "C(rememberPickerGroupState)187@9153L48,184@9070L131:PickerGroup.kt#gj9v0t");
        boolean z = true;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1271810622, i2, -1, "androidx.wear.compose.material.rememberPickerGroupState (PickerGroup.kt:184)");
        }
        Object[] objArr = {Integer.valueOf(i)};
        Saver<PickerGroupState, Object> saver = PickerGroupState.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, 2095019134, "CC(remember):PickerGroup.kt#9igjgp");
        if ((((i2 & 14) ^ 6) <= 4 || !composer.changed(i)) && (i2 & 6) != 4) {
            z = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = (Function0) new Function0<PickerGroupState>() { // from class: androidx.wear.compose.material.PickerGroupKt$rememberPickerGroupState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final PickerGroupState m638invoke() {
                    return new PickerGroupState(i);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        PickerGroupState pickerGroupState = (PickerGroupState) RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, (Function0) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return pickerGroupState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AutoCenteringRow(Modifier modifier, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1462783307);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AutoCenteringRow)P(1,2)262@12166L998,262@12119L1045:PickerGroup.kt#gj9v0t");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1462783307, i3, -1, "androidx.wear.compose.material.AutoCenteringRow (PickerGroup.kt:261)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1771014269, "CC(remember):PickerGroup.kt#9igjgp");
            boolean z2 = (i3 & 112) == 32;
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || measurePolicyRememberedValue == Composer.Companion.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.wear.compose.material.PickerGroupKt$AutoCenteringRow$1$1
                    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
                    public final MeasureResult m634measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        if (!z) {
                            j = Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
                        }
                        ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            arrayList.add(list.get(i5).measure-BRTryo0(j));
                        }
                        final ArrayList arrayList2 = arrayList;
                        final int iComputeCenteringOffset = PickerGroupKt.computeCenteringOffset(arrayList2);
                        final int i6 = Constraints.getHasBoundedWidth-impl(j) ? Constraints.getMaxWidth-impl(j) : Constraints.getMinWidth-impl(j);
                        final int iM633calculateHeightK40F9xA = PickerGroupKt.m633calculateHeightK40F9xA(j, arrayList2);
                        return MeasureScope.layout$default(measureScope, i6, iM633calculateHeightK40F9xA, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt$AutoCenteringRow$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                float width = (i6 / 2.0f) - iComputeCenteringOffset;
                                List<Placeable> list2 = arrayList2;
                                int i7 = iM633calculateHeightK40F9xA;
                                int size2 = list2.size();
                                int i8 = 0;
                                while (i8 < size2) {
                                    Placeable placeable = list2.get(i8);
                                    Placeable.PlacementScope placementScope2 = placementScope;
                                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, MathKt.roundToInt(width), MathKt.roundToInt((i7 - placeable.getHeight()) / 2.0f), 0.0f, 4, (Object) null);
                                    width += placeable.getWidth();
                                    i8++;
                                    placementScope = placementScope2;
                                }
                            }
                        }, 4, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i5 = ((i3 >> 6) & 14) | ((i3 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.set-impl(composer2, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i6 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.PickerGroupKt.AutoCenteringRow.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    PickerGroupKt.AutoCenteringRow(modifier2, z, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final Modifier scrollablePicker(Modifier modifier, final PickerState pickerState) {
        return ComposedModifierKt.composed$default(Modifier.Companion, (Function1) null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.wear.compose.material.PickerGroupKt.scrollablePicker.1
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceGroup(64144918);
                ComposerKt.sourceInformation(composer, "C296@13557L34:PickerGroup.kt#gj9v0t");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(64144918, i, -1, "androidx.wear.compose.material.scrollablePicker.<anonymous> (PickerGroup.kt:293)");
                }
                Modifier modifierScrollable$default = ScrollableKt.scrollable$default(modifier2, pickerState, Orientation.Vertical, false, true, PickerDefaults.INSTANCE.flingBehavior(pickerState, null, composer, 384, 2), (MutableInteractionSource) null, 36, (Object) null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceGroup();
                return modifierScrollable$default;
            }
        }, 1, (Object) null);
    }

    public static final Modifier autoCenteringTarget(Modifier modifier) {
        return modifier.then(new ParentDataModifier() { // from class: androidx.wear.compose.material.PickerGroupKt.autoCenteringTarget.1
            /* JADX INFO: renamed from: modifyParentData, reason: merged with bridge method [inline-methods] */
            public AutoCenteringRowParentData m637modifyParentData(Density density, Object obj) {
                return new AutoCenteringRowParentData();
            }
        });
    }

    public static final boolean isAutoCenteringTarget(Placeable placeable) {
        Object parentData = placeable.getParentData();
        return (parentData instanceof AutoCenteringRowParentData ? (AutoCenteringRowParentData) parentData : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int computeCenteringOffset(List<? extends Placeable> list) {
        int size = list.size();
        int width = 0;
        for (int i = 0; i < size; i++) {
            Placeable placeable = list.get(i);
            if (isAutoCenteringTarget(placeable)) {
                return width + (placeable.getWidth() / 2);
            }
            width += placeable.getWidth();
        }
        return width / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateHeight-K40F9xA, reason: not valid java name */
    public static final int m633calculateHeightK40F9xA(long j, List<? extends Placeable> list) {
        Integer num;
        if (list.isEmpty()) {
            num = null;
        } else {
            Integer numValueOf = Integer.valueOf(list.get(0).getHeight());
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer numValueOf2 = Integer.valueOf(list.get(i).getHeight());
                    if (numValueOf2.compareTo(numValueOf) > 0) {
                        numValueOf = numValueOf2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            num = numValueOf;
        }
        Intrinsics.checkNotNull(num);
        return RangesKt.coerceIn(num.intValue(), Constraints.getMinHeight-impl(j), Constraints.getMaxHeight-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PickerGroup$lambda$0(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }
}
