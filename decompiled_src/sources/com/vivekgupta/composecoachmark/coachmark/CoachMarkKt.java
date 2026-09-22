package com.vivekgupta.composecoachmark.coachmark;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoachMark.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u009d\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"CoachMark", "", "modifier", "Landroidx/compose/ui/Modifier;", "coachMarkState", "Lcom/vivekgupta/composecoachmark/coachmark/CoachMarkState;", "showCoachMark", "", "onShowBegin", "Lkotlin/Function0;", "onBeforeShowingCoachMark", "Lkotlin/Function2;", "", "onAfterShowingCoachMark", "onBack", "onCancelled", "onCompleted", "(Landroidx/compose/ui/Modifier;Lcom/vivekgupta/composecoachmark/coachmark/CoachMarkState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "composecoachmark_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CoachMarkKt {
    /* JADX WARN: Code duplicated, block: B:101:0x0145 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0147  */
    /* JADX WARN: Code duplicated, block: B:103:0x014e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0152  */
    /* JADX WARN: Code duplicated, block: B:106:0x0155  */
    /* JADX WARN: Code duplicated, block: B:108:0x0158  */
    /* JADX WARN: Code duplicated, block: B:109:0x015e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0161  */
    /* JADX WARN: Code duplicated, block: B:112:0x0166  */
    /* JADX WARN: Code duplicated, block: B:114:0x0169  */
    /* JADX WARN: Code duplicated, block: B:115:0x016e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0172  */
    /* JADX WARN: Code duplicated, block: B:118:0x0177  */
    /* JADX WARN: Code duplicated, block: B:121:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:129:0x021d  */
    /* JADX WARN: Code duplicated, block: B:132:0x0228  */
    /* JADX WARN: Code duplicated, block: B:136:0x0262  */
    /* JADX WARN: Code duplicated, block: B:174:0x0407  */
    /* JADX WARN: Code duplicated, block: B:177:0x041a  */
    /* JADX WARN: Code duplicated, block: B:181:0x042c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:182:0x042d  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0083  */
    /* JADX WARN: Code duplicated, block: B:41:0x008b  */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:48:0x009d  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:53:0x00af  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00be  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:67:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00de  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:81:0x0100  */
    /* JADX WARN: Code duplicated, block: B:83:0x0106  */
    /* JADX WARN: Code duplicated, block: B:84:0x0109  */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:89:0x0114  */
    /* JADX WARN: Code duplicated, block: B:91:0x0119  */
    /* JADX WARN: Code duplicated, block: B:93:0x011f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0122  */
    /* JADX WARN: Code duplicated, block: B:97:0x0130  */
    public static final void CoachMark(Modifier modifier, final CoachMarkState coachMarkState, boolean z, Function0<Unit> function0, Function2<? super Integer, ? super Integer, Unit> function2, Function2<? super Integer, ? super Integer, Unit> function3, Function0<Unit> function1, final Function0<Unit> function4, final Function0<Unit> function5, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        int i4;
        Function0<Unit> function6;
        int i5;
        int i6;
        final Function2<? super Integer, ? super Integer, Unit> function7;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier3;
        final boolean z3;
        Function0<Unit> function8;
        AnonymousClass2 anonymousClass2;
        AnonymousClass3 anonymousClass3;
        final AnonymousClass4 anonymousClass4;
        boolean zChanged;
        Object objRememberedValue;
        boolean zChanged2;
        Object objRememberedValue2;
        Function2<? super Integer, ? super Integer, Unit> function9;
        final MutableState mutableState;
        Function0<Unit> function10;
        Composer composer2;
        Modifier modifier4;
        final Function2<? super Integer, ? super Integer, Unit> function11;
        final boolean z4;
        final Function2<? super Integer, ? super Integer, Unit> function12;
        final Function0<Unit> function13;
        final Modifier modifier5;
        final Function0<Unit> function14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(coachMarkState, "coachMarkState");
        Intrinsics.checkNotNullParameter(function4, "onCancelled");
        Intrinsics.checkNotNullParameter(function5, "onCompleted");
        Composer composerStartRestartGroup = composer.startRestartGroup(1445281312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CoachMark)P(1!1,8,7,4)");
        int i14 = i2 & 1;
        if (i14 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(coachMarkState) ? 32 : 16;
        }
        int i15 = i2 & 4;
        if (i15 == 0) {
            if ((i & 896) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 7168) == 0) {
                    function6 = function0;
                    if (composerStartRestartGroup.changed(function6)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    i3 |= 24576;
                    function7 = function2;
                } else {
                    function7 = function2;
                    if ((i & 57344) == 0) {
                        if (composerStartRestartGroup.changed(function7)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= 196608;
                } else if ((i & 458752) == 0) {
                    if (composerStartRestartGroup.changed(function3)) {
                        i9 = 131072;
                    } else {
                        i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    if (composerStartRestartGroup.changed(function1)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                if ((i2 & 128) != 0) {
                    if ((29360128 & i) == 0) {
                        if (composerStartRestartGroup.changed(function4)) {
                            i12 = 8388608;
                        } else {
                            i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                        }
                    }
                    if ((i2 & 256) != 0) {
                        if ((234881024 & i) == 0) {
                            if (composerStartRestartGroup.changed(function5)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                        }
                        if ((191739611 & i3) == 38347922 || !composerStartRestartGroup.getSkipping()) {
                            if (i14 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i15 != 0) {
                                z3 = true;
                            } else {
                                z3 = z2;
                            }
                            if (i4 != 0) {
                                function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m2230invoke() {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2230invoke();
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                function8 = function6;
                            }
                            if (i6 != 0) {
                                anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                    public final void invoke(int i16, int i17) {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                anonymousClass2 = function7;
                            }
                            if (i8 != 0) {
                                anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                    public final void invoke(int i16, int i17) {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                anonymousClass3 = function3;
                            }
                            if (i10 != 0) {
                                anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                    public final void m2231invoke() {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2231invoke();
                                        return Unit.INSTANCE;
                                    }
                                };
                            } else {
                                anonymousClass4 = function1;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                            }
                            Object[] objArr = new Object[0];
                            Boolean boolValueOf = Boolean.valueOf(z3);
                            composerStartRestartGroup.startReplaceableGroup(1157296644);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(boolValueOf);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final MutableState<Boolean> m2235invoke() {
                                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Integer> m2237invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            }, composerStartRestartGroup, 3080, 6);
                            Object[] objArr2 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                            composerStartRestartGroup.startReplaceableGroup(1618982084);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState3) | composerStartRestartGroup.changed(mutableState2);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                function9 = anonymousClass3;
                            } else {
                                function9 = anonymousClass3;
                                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                                }
                                composerStartRestartGroup.endReplaceableGroup();
                                int i16 = i3;
                                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i16 >> 9) & 14);
                                if (CoachMark$lambda$6(mutableState) || coachMarkState.getTargetList$composecoachmark_release().isEmpty()) {
                                    function10 = function8;
                                    composer2 = composerStartRestartGroup;
                                    modifier4 = modifier3;
                                    function11 = function9;
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                                    boolean zChanged3 = composerStartRestartGroup.changed(stateRememberUpdatedState);
                                    Function0<Unit> function15 = function8;
                                    CoachMarkKt$CoachMark$5$1 coachMarkKt$CoachMark$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChanged3 || coachMarkKt$CoachMark$5$1RememberedValue == Composer.Companion.getEmpty()) {
                                        coachMarkKt$CoachMark$5$1RememberedValue = new CoachMarkKt$CoachMark$5$1(stateRememberUpdatedState, null);
                                        composerStartRestartGroup.updateRememberedValue(coachMarkKt$CoachMark$5$1RememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    EffectsKt.LaunchedEffect(unit, (Function2) coachMarkKt$CoachMark$5$1RememberedValue, composerStartRestartGroup, 70);
                                    Integer numValueOf = Integer.valueOf(HelperKt.nextKey(coachMarkState.getTargetList$composecoachmark_release(), CoachMark$lambda$3(mutableState3)));
                                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                    boolean zChanged4 = composerStartRestartGroup.changed(anonymousClass2) | composerStartRestartGroup.changed(mutableState3) | composerStartRestartGroup.changed(coachMarkState);
                                    CoachMarkKt$CoachMark$6$1 coachMarkKt$CoachMark$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (zChanged4 || coachMarkKt$CoachMark$6$1RememberedValue == Composer.Companion.getEmpty()) {
                                        coachMarkKt$CoachMark$6$1RememberedValue = new CoachMarkKt$CoachMark$6$1(anonymousClass2, coachMarkState, mutableState3, null);
                                        composerStartRestartGroup.updateRememberedValue(coachMarkKt$CoachMark$6$1RememberedValue);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    EffectsKt.LaunchedEffect(numValueOf, (Function2) coachMarkKt$CoachMark$6$1RememberedValue, composerStartRestartGroup, 64);
                                    CoachData coachDataNextValue = HelperKt.nextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMark$lambda$3(mutableState3));
                                    Function3<BoxWithConstraintsScope, Composer, Integer, Unit> content = coachDataNextValue.getContent();
                                    LayoutCoordinates coordinates = coachDataNextValue.getCoordinates();
                                    boolean zIsForcedAlignment = coachDataNextValue.isForcedAlignment();
                                    Alignment alignment = coachDataNextValue.getAlignment();
                                    function10 = function15;
                                    RevealEffect revealEffect = coachDataNextValue.getRevealEffect();
                                    CoachStyle coachStyle = coachDataNextValue.getCoachStyle();
                                    Object[] objArr3 = {mutableState, mutableState3, anonymousClass4, coachMarkState};
                                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                                    boolean zChanged5 = false;
                                    for (int i17 = 0; i17 < 4; i17++) {
                                        zChanged5 |= composerStartRestartGroup.changed(objArr3[i17]);
                                    }
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged5 || objRememberedValue3 == Composer.Companion.getEmpty()) {
                                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$7$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m2232invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                            public final void m2232invoke() {
                                                boolean zHasNextValue;
                                                MutableState<Boolean> mutableState4 = mutableState;
                                                if (CoachMarkKt.CoachMark$lambda$3(mutableState3) == 0) {
                                                    zHasNextValue = false;
                                                } else {
                                                    anonymousClass4.invoke();
                                                    MutableState<Integer> mutableState5 = mutableState3;
                                                    CoachMarkKt.CoachMark$lambda$4(mutableState5, CoachMarkKt.CoachMark$lambda$3(mutableState5) - 1);
                                                    CoachMarkKt.CoachMark$lambda$3(mutableState3);
                                                    zHasNextValue = HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState3));
                                                }
                                                CoachMarkKt.CoachMark$lambda$7(mutableState4, zHasNextValue);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    Function0 function16 = (Function0) objRememberedValue3;
                                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                                    boolean zChanged6 = composerStartRestartGroup.changed(mutableState2) | composerStartRestartGroup.changed(mutableState) | composerStartRestartGroup.changed(function4);
                                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged6 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                                        objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$8$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m2233invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                            public final void m2233invoke() {
                                                CoachMarkKt.CoachMark$lambda$2(mutableState2, false);
                                                CoachMarkKt.CoachMark$lambda$7(mutableState, false);
                                                function4.invoke();
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    Function0 function17 = (Function0) objRememberedValue4;
                                    function11 = function9;
                                    boolean zChanged7 = false;
                                    Object[] objArr4 = {function11, mutableState3, coachMarkState, mutableState, function5, mutableState2};
                                    composerStartRestartGroup.startReplaceableGroup(-568225417);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                                    for (int i18 = 0; i18 < 6; i18++) {
                                        zChanged7 |= composerStartRestartGroup.changed(objArr4[i18]);
                                    }
                                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged7 || objRememberedValue5 == Composer.Companion.getEmpty()) {
                                        Object obj = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$9$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(0);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m2234invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                            public final void m2234invoke() {
                                                function11.invoke(Integer.valueOf(CoachMarkKt.CoachMark$lambda$3(mutableState3)), Integer.valueOf(HelperKt.firstKey(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState3))));
                                                MutableState<Integer> mutableState4 = mutableState3;
                                                CoachMarkKt.CoachMark$lambda$4(mutableState4, CoachMarkKt.CoachMark$lambda$3(mutableState4) + 1);
                                                CoachMarkKt.CoachMark$lambda$3(mutableState3);
                                                CoachMarkKt.CoachMark$lambda$7(mutableState, HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState3)));
                                                if (CoachMarkKt.CoachMark$lambda$6(mutableState)) {
                                                    return;
                                                }
                                                CoachMarkKt.CoachMark$lambda$4(mutableState3, 0);
                                                function5.invoke();
                                                CoachMarkKt.CoachMark$lambda$2(mutableState2, false);
                                            }
                                        };
                                        function11 = function11;
                                        objRememberedValue5 = (Function0) obj;
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                    }
                                    composerStartRestartGroup.endReplaceableGroup();
                                    modifier4 = modifier3;
                                    CoachKt.Coach(modifier4, coordinates, content, coachStyle, revealEffect, alignment, zIsForcedAlignment, function16, function17, (Function0) objRememberedValue5, composerStartRestartGroup, (i16 & 14) | 64, 0);
                                    composer2 = composerStartRestartGroup;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z4 = z3;
                                function12 = function11;
                                function13 = function10;
                                modifier5 = modifier4;
                                function7 = anonymousClass2;
                                function14 = anonymousClass4;
                            }
                            objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2236invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState3)) && CoachMarkKt.CoachMark$lambda$1(mutableState2)), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            composerStartRestartGroup.endReplaceableGroup();
                            int i19 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i19 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            function14 = function1;
                            composer2 = composerStartRestartGroup;
                            modifier5 = modifier2;
                            z4 = z2;
                            function13 = function6;
                            function12 = function3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                            return;
                        }
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i20) {
                                CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                            }
                        });
                    }
                    i13 = 100663296;
                    i3 |= i13;
                    if ((191739611 & i3) == 38347922) {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i110, int i111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i110, int i111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr5 = new Object[0];
                        Boolean boolValueOf2 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf2);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr5, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState5 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr6 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState5) | composerStartRestartGroup.changed(mutableState4);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i110 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr6, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i110 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState5)) && CoachMarkKt.CoachMark$lambda$1(mutableState4)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i111 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr6, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i112, int i113) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i112, int i113) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr7 = new Object[0];
                        Boolean boolValueOf3 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf3);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState6 = (MutableState) RememberSaveableKt.rememberSaveable(objArr7, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState7 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr8 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState7) | composerStartRestartGroup.changed(mutableState6);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i112 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr8, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState5 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i112 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState7)) && CoachMarkKt.CoachMark$lambda$1(mutableState6)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i113 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr8, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState6 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i113 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                        }
                    });
                }
                i12 = 12582912;
                i3 |= i12;
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(function5)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i114, int i115) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i114, int i115) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr9 = new Object[0];
                        Boolean boolValueOf4 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf4);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState8 = (MutableState) RememberSaveableKt.rememberSaveable(objArr9, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState9 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr10 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState9) | composerStartRestartGroup.changed(mutableState8);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i114 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr10, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState7 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i114 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState9)) && CoachMarkKt.CoachMark$lambda$1(mutableState8)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i115 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr10, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState8 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i115 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i116, int i117) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i116, int i117) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr11 = new Object[0];
                        Boolean boolValueOf5 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf5);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState10 = (MutableState) RememberSaveableKt.rememberSaveable(objArr11, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState11 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr12 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState11) | composerStartRestartGroup.changed(mutableState10);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i116 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr12, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState9 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i116 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState11)) && CoachMarkKt.CoachMark$lambda$1(mutableState10)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i117 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr12, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState10 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i117 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                        }
                    });
                }
                i13 = 100663296;
                i3 |= i13;
                if ((191739611 & i3) == 38347922) {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i118, int i119) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i118, int i119) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr13 = new Object[0];
                    Boolean boolValueOf6 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf6);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState12 = (MutableState) RememberSaveableKt.rememberSaveable(objArr13, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState13 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr14 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState13) | composerStartRestartGroup.changed(mutableState12);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i118 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr14, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState11 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i118 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState13)) && CoachMarkKt.CoachMark$lambda$1(mutableState12)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i119 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr14, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState12 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i119 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i1110, int i1111) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i1110, int i1111) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr15 = new Object[0];
                    Boolean boolValueOf7 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf7);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState14 = (MutableState) RememberSaveableKt.rememberSaveable(objArr15, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState15 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr16 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState15) | composerStartRestartGroup.changed(mutableState14);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1110 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr16, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState13 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1110 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState15)) && CoachMarkKt.CoachMark$lambda$1(mutableState14)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1111 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr16, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState14 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                    }
                });
            }
            i3 |= 3072;
            function6 = function0;
            i6 = i2 & 16;
            if (i6 != 0) {
                i3 |= 24576;
                function7 = function2;
            } else {
                function7 = function2;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= 196608;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(function5)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i1112, int i1113) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i1112, int i1113) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr17 = new Object[0];
                        Boolean boolValueOf8 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf8);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState16 = (MutableState) RememberSaveableKt.rememberSaveable(objArr17, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState17 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr18 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState17) | composerStartRestartGroup.changed(mutableState16);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i1112 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr18, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState15 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1112 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState17)) && CoachMarkKt.CoachMark$lambda$1(mutableState16)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1113 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr18, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState16 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1113 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i1114, int i1115) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i1114, int i1115) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr19 = new Object[0];
                        Boolean boolValueOf9 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf9);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState18 = (MutableState) RememberSaveableKt.rememberSaveable(objArr19, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState19 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr110 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState19) | composerStartRestartGroup.changed(mutableState18);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i1114 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState17 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1114 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState19)) && CoachMarkKt.CoachMark$lambda$1(mutableState18)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1115 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState18 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1115 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                        }
                    });
                }
                i13 = 100663296;
                i3 |= i13;
                if ((191739611 & i3) == 38347922) {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i1116, int i1117) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i1116, int i1117) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr111 = new Object[0];
                    Boolean boolValueOf10 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf10);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState110 = (MutableState) RememberSaveableKt.rememberSaveable(objArr111, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState111 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr112 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState111) | composerStartRestartGroup.changed(mutableState110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1116 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState19 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1116 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState111)) && CoachMarkKt.CoachMark$lambda$1(mutableState110)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1117 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState110 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1117 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i1118, int i1119) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i1118, int i1119) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr113 = new Object[0];
                    Boolean boolValueOf11 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf11);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState112 = (MutableState) RememberSaveableKt.rememberSaveable(objArr113, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState113 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr114 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState113) | composerStartRestartGroup.changed(mutableState112);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1118 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState111 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1118 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState113)) && CoachMarkKt.CoachMark$lambda$1(mutableState112)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1119 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState112 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1119 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                    }
                });
            }
            i12 = 12582912;
            i3 |= i12;
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(function5)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i11110, int i11111) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i11110, int i11111) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr115 = new Object[0];
                    Boolean boolValueOf12 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf12);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState114 = (MutableState) RememberSaveableKt.rememberSaveable(objArr115, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState115 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr116 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState115) | composerStartRestartGroup.changed(mutableState114);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i11110 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState113 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11110 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState115)) && CoachMarkKt.CoachMark$lambda$1(mutableState114)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11111 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState114 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i11112, int i11113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i11112, int i11113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr117 = new Object[0];
                    Boolean boolValueOf13 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf13);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState116 = (MutableState) RememberSaveableKt.rememberSaveable(objArr117, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState117 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr118 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState117) | composerStartRestartGroup.changed(mutableState116);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i11112 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState115 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11112 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState117)) && CoachMarkKt.CoachMark$lambda$1(mutableState116)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11113 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState116 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11113 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                    }
                });
            }
            i13 = 100663296;
            i3 |= i13;
            if ((191739611 & i3) == 38347922) {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i11114, int i11115) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i11114, int i11115) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr119 = new Object[0];
                Boolean boolValueOf14 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf14);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState118 = (MutableState) RememberSaveableKt.rememberSaveable(objArr119, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState119 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr1110 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState119) | composerStartRestartGroup.changed(mutableState118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11114 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState117 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11114 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState119)) && CoachMarkKt.CoachMark$lambda$1(mutableState118)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i11115 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState118 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11115 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            } else {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i11116, int i11117) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i11116, int i11117) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr1111 = new Object[0];
                Boolean boolValueOf15 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf15);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState1110 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState1111 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr1112 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1111) | composerStartRestartGroup.changed(mutableState1110);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11116 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState119 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11116 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1111)) && CoachMarkKt.CoachMark$lambda$1(mutableState1110)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i11117 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState1110 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11117 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 384;
        z2 = z;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 7168) == 0) {
                function6 = function0;
                if (composerStartRestartGroup.changed(function6)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                i3 |= 24576;
                function7 = function2;
            } else {
                function7 = function2;
                if ((i & 57344) == 0) {
                    if (composerStartRestartGroup.changed(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= 196608;
            } else if ((i & 458752) == 0) {
                if (composerStartRestartGroup.changed(function3)) {
                    i9 = 131072;
                } else {
                    i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 3670016) == 0) {
                if (composerStartRestartGroup.changed(function1)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            if ((i2 & 128) != 0) {
                if ((29360128 & i) == 0) {
                    if (composerStartRestartGroup.changed(function4)) {
                        i12 = 8388608;
                    } else {
                        i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                    }
                }
                if ((i2 & 256) != 0) {
                    if ((234881024 & i) == 0) {
                        if (composerStartRestartGroup.changed(function5)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                    }
                    if ((191739611 & i3) == 38347922) {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i11118, int i11119) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i11118, int i11119) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr1113 = new Object[0];
                        Boolean boolValueOf16 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf16);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState1112 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1113, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState1113 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr1114 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1113) | composerStartRestartGroup.changed(mutableState1112);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i11118 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState1111 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11118 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1113)) && CoachMarkKt.CoachMark$lambda$1(mutableState1112)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i11119 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState1112 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11119 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        if (i14 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i15 != 0) {
                            z3 = true;
                        } else {
                            z3 = z2;
                        }
                        if (i4 != 0) {
                            function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2230invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2230invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            function8 = function6;
                        }
                        if (i6 != 0) {
                            anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                                public final void invoke(int i111110, int i111111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass2 = function7;
                        }
                        if (i8 != 0) {
                            anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                                public final void invoke(int i111110, int i111111) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass3 = function3;
                        }
                        if (i10 != 0) {
                            anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m2231invoke() {
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2231invoke();
                                    return Unit.INSTANCE;
                                }
                            };
                        } else {
                            anonymousClass4 = function1;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                        }
                        Object[] objArr1115 = new Object[0];
                        Boolean boolValueOf17 = Boolean.valueOf(z3);
                        composerStartRestartGroup.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(boolValueOf17);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final MutableState<Boolean> m2235invoke() {
                                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        final MutableState<Boolean> mutableState1114 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1115, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                        final MutableState<Integer> mutableState1115 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Integer> m2237invoke() {
                                return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        }, composerStartRestartGroup, 3080, 6);
                        Object[] objArr1116 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                        composerStartRestartGroup.startReplaceableGroup(1618982084);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1115) | composerStartRestartGroup.changed(mutableState1114);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            function9 = anonymousClass3;
                            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                            }
                            composerStartRestartGroup.endReplaceableGroup();
                            int i111110 = i3;
                            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                            State stateRememberUpdatedState1113 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111110 >> 9) & 14);
                            if (CoachMark$lambda$6(mutableState)) {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            } else {
                                function10 = function8;
                                composer2 = composerStartRestartGroup;
                                modifier4 = modifier3;
                                function11 = function9;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            function12 = function11;
                            function13 = function10;
                            modifier5 = modifier4;
                            function7 = anonymousClass2;
                            function14 = anonymousClass4;
                        } else {
                            function9 = anonymousClass3;
                        }
                        objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2236invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1115)) && CoachMarkKt.CoachMark$lambda$1(mutableState1114)), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceableGroup();
                        int i111111 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState1114 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111111 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    }
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i20) {
                            CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                        }
                    });
                }
                i13 = 100663296;
                i3 |= i13;
                if ((191739611 & i3) == 38347922) {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i111112, int i111113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i111112, int i111113) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr1117 = new Object[0];
                    Boolean boolValueOf18 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf18);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState1116 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1117, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState1117 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr1118 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1117) | composerStartRestartGroup.changed(mutableState1116);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i111112 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState1115 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111112 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1117)) && CoachMarkKt.CoachMark$lambda$1(mutableState1116)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i111113 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState1116 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111113 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i111114, int i111115) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i111114, int i111115) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr1119 = new Object[0];
                    Boolean boolValueOf19 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf19);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState1118 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1119, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState1119 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr11110 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1119) | composerStartRestartGroup.changed(mutableState1118);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i111114 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState1117 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111114 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1119)) && CoachMarkKt.CoachMark$lambda$1(mutableState1118)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i111115 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState1118 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111115 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                    }
                });
            }
            i12 = 12582912;
            i3 |= i12;
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(function5)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i111116, int i111117) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i111116, int i111117) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr11111 = new Object[0];
                    Boolean boolValueOf110 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf110);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState11110 = (MutableState) RememberSaveableKt.rememberSaveable(objArr11111, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState11111 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr11112 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState11111) | composerStartRestartGroup.changed(mutableState11110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i111116 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState1119 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111116 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState11111)) && CoachMarkKt.CoachMark$lambda$1(mutableState11110)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i111117 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState11110 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111117 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i111118, int i111119) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i111118, int i111119) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr11113 = new Object[0];
                    Boolean boolValueOf111 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf111);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState11112 = (MutableState) RememberSaveableKt.rememberSaveable(objArr11113, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState11113 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr11114 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState11113) | composerStartRestartGroup.changed(mutableState11112);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i111118 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState11111 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111118 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState11113)) && CoachMarkKt.CoachMark$lambda$1(mutableState11112)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i111119 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState11112 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i111119 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                    }
                });
            }
            i13 = 100663296;
            i3 |= i13;
            if ((191739611 & i3) == 38347922) {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i1111110, int i1111111) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i1111110, int i1111111) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr11115 = new Object[0];
                Boolean boolValueOf112 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf112);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState11114 = (MutableState) RememberSaveableKt.rememberSaveable(objArr11115, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState11115 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr11116 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState11115) | composerStartRestartGroup.changed(mutableState11114);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1111110 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState11113 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111110 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState11115)) && CoachMarkKt.CoachMark$lambda$1(mutableState11114)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i1111111 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState11114 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111111 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            } else {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i1111112, int i1111113) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i1111112, int i1111113) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr11117 = new Object[0];
                Boolean boolValueOf113 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf113);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState11116 = (MutableState) RememberSaveableKt.rememberSaveable(objArr11117, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState11117 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr11118 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState11117) | composerStartRestartGroup.changed(mutableState11116);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1111112 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState11115 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111112 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState11117)) && CoachMarkKt.CoachMark$lambda$1(mutableState11116)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i1111113 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr11118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState11116 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111113 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                }
            });
        }
        i3 |= 3072;
        function6 = function0;
        i6 = i2 & 16;
        if (i6 != 0) {
            i3 |= 24576;
            function7 = function2;
        } else {
            function7 = function2;
            if ((i & 57344) == 0) {
                if (composerStartRestartGroup.changed(function7)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= 196608;
        } else if ((i & 458752) == 0) {
            if (composerStartRestartGroup.changed(function3)) {
                i9 = 131072;
            } else {
                i9 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i3 |= i9;
        }
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
        } else if ((i & 3670016) == 0) {
            if (composerStartRestartGroup.changed(function1)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        if ((i2 & 128) != 0) {
            if ((29360128 & i) == 0) {
                if (composerStartRestartGroup.changed(function4)) {
                    i12 = 8388608;
                } else {
                    i12 = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
                }
            }
            if ((i2 & 256) != 0) {
                if ((234881024 & i) == 0) {
                    if (composerStartRestartGroup.changed(function5)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                }
                if ((191739611 & i3) == 38347922) {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i1111114, int i1111115) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i1111114, int i1111115) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr11119 = new Object[0];
                    Boolean boolValueOf114 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf114);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState11118 = (MutableState) RememberSaveableKt.rememberSaveable(objArr11119, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState11119 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr111110 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState11119) | composerStartRestartGroup.changed(mutableState11118);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1111114 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState11117 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111114 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState11119)) && CoachMarkKt.CoachMark$lambda$1(mutableState11118)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1111115 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState11118 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111115 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    if (i14 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i15 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    if (i4 != 0) {
                        function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2230invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2230invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        function8 = function6;
                    }
                    if (i6 != 0) {
                        anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                            public final void invoke(int i1111116, int i1111117) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass2 = function7;
                    }
                    if (i8 != 0) {
                        anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                            public final void invoke(int i1111116, int i1111117) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass3 = function3;
                    }
                    if (i10 != 0) {
                        anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m2231invoke() {
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2231invoke();
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass4 = function1;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                    }
                    Object[] objArr111111 = new Object[0];
                    Boolean boolValueOf115 = Boolean.valueOf(z3);
                    composerStartRestartGroup.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(boolValueOf115);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final MutableState<Boolean> m2235invoke() {
                                return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    final MutableState<Boolean> mutableState111110 = (MutableState) RememberSaveableKt.rememberSaveable(objArr111111, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                    final MutableState<Integer> mutableState111111 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Integer> m2237invoke() {
                            return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    }, composerStartRestartGroup, 3080, 6);
                    Object[] objArr111112 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                    composerStartRestartGroup.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState111111) | composerStartRestartGroup.changed(mutableState111110);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        function9 = anonymousClass3;
                        if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        }
                        composerStartRestartGroup.endReplaceableGroup();
                        int i1111116 = i3;
                        mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                        State stateRememberUpdatedState11119 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111116 >> 9) & 14);
                        if (CoachMark$lambda$6(mutableState)) {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        } else {
                            function10 = function8;
                            composer2 = composerStartRestartGroup;
                            modifier4 = modifier3;
                            function11 = function9;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z4 = z3;
                        function12 = function11;
                        function13 = function10;
                        modifier5 = modifier4;
                        function7 = anonymousClass2;
                        function14 = anonymousClass4;
                    } else {
                        function9 = anonymousClass3;
                    }
                    objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2236invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState111111)) && CoachMarkKt.CoachMark$lambda$1(mutableState111110)), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1111117 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState111110 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111117 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                    return;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i20) {
                        CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                    }
                });
            }
            i13 = 100663296;
            i3 |= i13;
            if ((191739611 & i3) == 38347922) {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i1111118, int i1111119) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i1111118, int i1111119) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr111113 = new Object[0];
                Boolean boolValueOf116 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf116);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState111112 = (MutableState) RememberSaveableKt.rememberSaveable(objArr111113, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState111113 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr111114 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState111113) | composerStartRestartGroup.changed(mutableState111112);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i1111118 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState111111 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111118 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState111113)) && CoachMarkKt.CoachMark$lambda$1(mutableState111112)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i1111119 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState111112 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i1111119 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            } else {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i11111110, int i11111111) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i11111110, int i11111111) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr111115 = new Object[0];
                Boolean boolValueOf117 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf117);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState111114 = (MutableState) RememberSaveableKt.rememberSaveable(objArr111115, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState111115 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr111116 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState111115) | composerStartRestartGroup.changed(mutableState111114);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11111110 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState111113 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111110 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState111115)) && CoachMarkKt.CoachMark$lambda$1(mutableState111114)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i11111111 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111116, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState111114 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111111 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                }
            });
        }
        i12 = 12582912;
        i3 |= i12;
        if ((i2 & 256) != 0) {
            if ((234881024 & i) == 0) {
                if (composerStartRestartGroup.changed(function5)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
            }
            if ((191739611 & i3) == 38347922) {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i11111112, int i11111113) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i11111112, int i11111113) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr111117 = new Object[0];
                Boolean boolValueOf118 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf118);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState111116 = (MutableState) RememberSaveableKt.rememberSaveable(objArr111117, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState111117 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr111118 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState111117) | composerStartRestartGroup.changed(mutableState111116);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11111112 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState111115 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111112 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState111117)) && CoachMarkKt.CoachMark$lambda$1(mutableState111116)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i11111113 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr111118, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState111116 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111113 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            } else {
                if (i14 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i15 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if (i4 != 0) {
                    function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2230invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2230invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    function8 = function6;
                }
                if (i6 != 0) {
                    anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                        public final void invoke(int i11111114, int i11111115) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass2 = function7;
                }
                if (i8 != 0) {
                    anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                        public final void invoke(int i11111114, int i11111115) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass3 = function3;
                }
                if (i10 != 0) {
                    anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m2231invoke() {
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2231invoke();
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass4 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
                }
                Object[] objArr111119 = new Object[0];
                Boolean boolValueOf119 = Boolean.valueOf(z3);
                composerStartRestartGroup.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(boolValueOf119);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final MutableState<Boolean> m2235invoke() {
                            return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                final MutableState<Boolean> mutableState111118 = (MutableState) RememberSaveableKt.rememberSaveable(objArr111119, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
                final MutableState<Integer> mutableState111119 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Integer> m2237invoke() {
                        return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                }, composerStartRestartGroup, 3080, 6);
                Object[] objArr1111110 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
                composerStartRestartGroup.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState111119) | composerStartRestartGroup.changed(mutableState111118);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    function9 = anonymousClass3;
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    int i11111114 = i3;
                    mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                    State stateRememberUpdatedState111117 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111114 >> 9) & 14);
                    if (CoachMark$lambda$6(mutableState)) {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    } else {
                        function10 = function8;
                        composer2 = composerStartRestartGroup;
                        modifier4 = modifier3;
                        function11 = function9;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z3;
                    function12 = function11;
                    function13 = function10;
                    modifier5 = modifier4;
                    function7 = anonymousClass2;
                    function14 = anonymousClass4;
                } else {
                    function9 = anonymousClass3;
                }
                objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2236invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState111119)) && CoachMarkKt.CoachMark$lambda$1(mutableState111118)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                composerStartRestartGroup.endReplaceableGroup();
                int i11111115 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111110, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState111118 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111115 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                return;
            }
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i20) {
                    CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
                }
            });
        }
        i13 = 100663296;
        i3 |= i13;
        if ((191739611 & i3) == 38347922) {
            if (i14 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i15 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i4 != 0) {
                function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2230invoke() {
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2230invoke();
                        return Unit.INSTANCE;
                    }
                };
            } else {
                function8 = function6;
            }
            if (i6 != 0) {
                anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                    public final void invoke(int i11111116, int i11111117) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass2 = function7;
            }
            if (i8 != 0) {
                anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                    public final void invoke(int i11111116, int i11111117) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass3 = function3;
            }
            if (i10 != 0) {
                anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2231invoke() {
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2231invoke();
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass4 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
            }
            Object[] objArr1111111 = new Object[0];
            Boolean boolValueOf1110 = Boolean.valueOf(z3);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(boolValueOf1110);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2235invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2235invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState<Boolean> mutableState1111110 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111111, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
            final MutableState<Integer> mutableState1111111 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MutableState<Integer> m2237invoke() {
                    return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                }
            }, composerStartRestartGroup, 3080, 6);
            Object[] objArr1111112 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1111111) | composerStartRestartGroup.changed(mutableState1111110);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                function9 = anonymousClass3;
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i11111116 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState111119 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111116 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            } else {
                function9 = anonymousClass3;
            }
            objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MutableState<Boolean> m2236invoke() {
                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1111111)) && CoachMarkKt.CoachMark$lambda$1(mutableState1111110)), (SnapshotMutationPolicy) null, 2, (Object) null);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            composerStartRestartGroup.endReplaceableGroup();
            int i11111117 = i3;
            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111112, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
            State stateRememberUpdatedState1111110 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111117 >> 9) & 14);
            if (CoachMark$lambda$6(mutableState)) {
                function10 = function8;
                composer2 = composerStartRestartGroup;
                modifier4 = modifier3;
                function11 = function9;
            } else {
                function10 = function8;
                composer2 = composerStartRestartGroup;
                modifier4 = modifier3;
                function11 = function9;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z3;
            function12 = function11;
            function13 = function10;
            modifier5 = modifier4;
            function7 = anonymousClass2;
            function14 = anonymousClass4;
        } else {
            if (i14 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i15 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            if (i4 != 0) {
                function8 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.1
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2230invoke() {
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2230invoke();
                        return Unit.INSTANCE;
                    }
                };
            } else {
                function8 = function6;
            }
            if (i6 != 0) {
                anonymousClass2 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.2
                    public final void invoke(int i11111118, int i11111119) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass2 = function7;
            }
            if (i8 != 0) {
                anonymousClass3 = new Function2<Integer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.3
                    public final void invoke(int i11111118, int i11111119) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke(((Number) obj2).intValue(), ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass3 = function3;
            }
            if (i10 != 0) {
                anonymousClass4 = new Function0<Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.4
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m2231invoke() {
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2231invoke();
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass4 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445281312, i3, -1, "com.vivekgupta.composecoachmark.coachmark.CoachMark (CoachMark.kt:19)");
            }
            Object[] objArr1111113 = new Object[0];
            Boolean boolValueOf1111 = Boolean.valueOf(z3);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(boolValueOf1111);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2235invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canDrawCoachMark$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final MutableState<Boolean> m2235invoke() {
                        return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            final MutableState<Boolean> mutableState1111112 = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111113, (Saver) null, (String) null, (Function0) objRememberedValue, composerStartRestartGroup, 8, 6);
            final MutableState<Integer> mutableState1111113 = (MutableState) RememberSaveableKt.rememberSaveable(new Object[0], (Saver) null, (String) null, new Function0<MutableState<Integer>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$count$2
                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MutableState<Integer> m2237invoke() {
                    return SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
                }
            }, composerStartRestartGroup, 3080, 6);
            Object[] objArr1111114 = {Integer.valueOf(coachMarkState.getTargetList$composecoachmark_release().size())};
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1,2,3):Composables.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(coachMarkState) | composerStartRestartGroup.changed(mutableState1111113) | composerStartRestartGroup.changed(mutableState1111112);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                function9 = anonymousClass3;
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                }
                composerStartRestartGroup.endReplaceableGroup();
                int i11111118 = i3;
                mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
                State stateRememberUpdatedState1111111 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111118 >> 9) & 14);
                if (CoachMark$lambda$6(mutableState)) {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                } else {
                    function10 = function8;
                    composer2 = composerStartRestartGroup;
                    modifier4 = modifier3;
                    function11 = function9;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z3;
                function12 = function11;
                function13 = function10;
                modifier5 = modifier4;
                function7 = anonymousClass2;
                function14 = anonymousClass4;
            } else {
                function9 = anonymousClass3;
            }
            objRememberedValue2 = (Function0) new Function0<MutableState<Boolean>>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt$CoachMark$canShowNext$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final MutableState<Boolean> m2236invoke() {
                    return SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(HelperKt.hasNextValue(coachMarkState.getTargetList$composecoachmark_release(), CoachMarkKt.CoachMark$lambda$3(mutableState1111113)) && CoachMarkKt.CoachMark$lambda$1(mutableState1111112)), (SnapshotMutationPolicy) null, 2, (Object) null);
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            composerStartRestartGroup.endReplaceableGroup();
            int i11111119 = i3;
            mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr1111114, (Saver) null, (String) null, (Function0) objRememberedValue2, composerStartRestartGroup, 8, 6);
            State stateRememberUpdatedState1111112 = SnapshotStateKt.rememberUpdatedState(function8, composerStartRestartGroup, (i11111119 >> 9) & 14);
            if (CoachMark$lambda$6(mutableState)) {
                function10 = function8;
                composer2 = composerStartRestartGroup;
                modifier4 = modifier3;
                function11 = function9;
            } else {
                function10 = function8;
                composer2 = composerStartRestartGroup;
                modifier4 = modifier3;
                function11 = function9;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z3;
            function12 = function11;
            function13 = function10;
            modifier5 = modifier4;
            function7 = anonymousClass2;
            function14 = anonymousClass4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.vivekgupta.composecoachmark.coachmark.CoachMarkKt.CoachMark.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i20) {
                CoachMarkKt.CoachMark(modifier5, coachMarkState, z4, function13, function7, function12, function14, function4, function5, composer3, i | 1, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoachMark$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoachMark$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CoachMark$lambda$3(MutableState<Integer> mutableState) {
        return ((Number) ((State) mutableState).getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoachMark$lambda$4(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoachMark$lambda$6(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoachMark$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> CoachMark$lambda$8(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }
}
