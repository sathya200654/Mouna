package androidx.wear.compose.materialcore;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoundsLimiter.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a}\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\b\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00032\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\n*\u00020\n2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0002\b\u0006H\u0002¨\u0006\u0011"}, d2 = {"BoundsLimiter", "", "offset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/IntOffset;", "Lkotlin/ExtensionFunctionType;", "size", "Landroidx/compose/ui/unit/IntSize;", "modifier", "Landroidx/compose/ui/Modifier;", "onSizeChanged", "content", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "transparentSizeModifier", "compose-material-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BoundsLimiterKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0227  */
    /* JADX WARN: Code duplicated, block: B:102:0x0235  */
    /* JADX WARN: Code duplicated, block: B:105:0x0288  */
    /* JADX WARN: Code duplicated, block: B:109:0x0292  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0083  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x0113  */
    /* JADX WARN: Code duplicated, block: B:75:0x011f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0123  */
    /* JADX WARN: Code duplicated, block: B:79:0x0148  */
    /* JADX WARN: Code duplicated, block: B:81:0x0156  */
    /* JADX WARN: Code duplicated, block: B:84:0x0192  */
    /* JADX WARN: Code duplicated, block: B:85:0x0194  */
    /* JADX WARN: Code duplicated, block: B:88:0x019b  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:96:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:97:0x0202  */
    public static final void BoundsLimiter(final Function1<? super Density, IntOffset> function1, final Function1<? super Density, IntSize> function2, Modifier modifier, Function1<? super IntSize, Unit> function3, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super IntSize, Unit> function5;
        int i5;
        int i6;
        Modifier modifier3;
        AnonymousClass1 anonymousClass1;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        boolean z;
        Object objRememberedValue;
        int currentCompositeKeyHash2;
        Function0 constructor2;
        Composer composer3;
        Function2 setCompositeKeyHash2;
        final Function1<? super IntSize, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-254777585);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoundsLimiter)P(2,4,1,3)48@2005L688:BoundsLimiter.kt#f7tims");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                    if (i7 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                            /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final void m905invokeozmzZPI(long j) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                                return Unit.INSTANCE;
                            }
                        };
                    } else {
                        anonymousClass1 = function5;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
                    }
                    Modifier modifierAbsoluteOffset = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
                    Alignment topLeft = AbsoluteAlignment.INSTANCE.getTopLeft();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topLeft, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
                    Modifier modifierTransparentSizeModifier = transparentSizeModifier(modifier3, function2);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                            }

                            /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m906invokeBjo55l4(Density density) {
                                return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierAbsoluteOffset2 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier, (Function1) objRememberedValue);
                    Alignment topLeft2 = AbsoluteAlignment.INSTANCE.getTopLeft();
                    int i8 = (i3 >> 3) & 7168;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset2);
                    constructor2 = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composer3 = Updater.constructor-impl(composerStartRestartGroup);
                    Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i8 >> 6) & 112) | 6));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = anonymousClass1;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i9) {
                            BoundsLimiterKt.BoundsLimiter(function1, function2, modifier4, function6, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            function5 = function3;
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) == 9362) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m905invokeozmzZPI(long j) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
                }
                Modifier modifierAbsoluteOffset3 = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
                Alignment topLeft3 = AbsoluteAlignment.INSTANCE.getTopLeft();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft3, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
                Modifier modifierTransparentSizeModifier2 = transparentSizeModifier(modifier3, function2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierAbsoluteOffset4 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier2, (Function1) objRememberedValue);
                Alignment topLeft4 = AbsoluteAlignment.INSTANCE.getTopLeft();
                int i9 = (i3 >> 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset4);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i9 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = anonymousClass1;
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m905invokeozmzZPI(long j) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
                }
                Modifier modifierAbsoluteOffset5 = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
                Alignment topLeft5 = AbsoluteAlignment.INSTANCE.getTopLeft();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft5, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset5);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
                Modifier modifierTransparentSizeModifier3 = transparentSizeModifier(modifier3, function2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierAbsoluteOffset6 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier3, (Function1) objRememberedValue);
                Alignment topLeft6 = AbsoluteAlignment.INSTANCE.getTopLeft();
                int i10 = (i3 >> 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft6, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset6);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i10 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = anonymousClass1;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i11) {
                        BoundsLimiterKt.BoundsLimiter(function1, function2, modifier5, function6, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            if ((i2 & 16) != 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) == 9362) {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m905invokeozmzZPI(long j) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
                }
                Modifier modifierAbsoluteOffset7 = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
                Alignment topLeft7 = AbsoluteAlignment.INSTANCE.getTopLeft();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft7, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset7);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
                Modifier modifierTransparentSizeModifier4 = transparentSizeModifier(modifier3, function2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierAbsoluteOffset8 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier4, (Function1) objRememberedValue);
                Alignment topLeft8 = AbsoluteAlignment.INSTANCE.getTopLeft();
                int i11 = (i3 >> 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft8, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset8);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i11 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = anonymousClass1;
            } else {
                if (i7 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m905invokeozmzZPI(long j) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                            return Unit.INSTANCE;
                        }
                    };
                } else {
                    anonymousClass1 = function5;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
                }
                Modifier modifierAbsoluteOffset9 = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
                Alignment topLeft9 = AbsoluteAlignment.INSTANCE.getTopLeft();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft9, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset9);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
                Modifier modifierTransparentSizeModifier5 = transparentSizeModifier(modifier3, function2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                        }

                        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                        public final long m906invokeBjo55l4(Density density) {
                            return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierAbsoluteOffset10 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier5, (Function1) objRememberedValue);
                Alignment topLeft10 = AbsoluteAlignment.INSTANCE.getTopLeft();
                int i12 = (i3 >> 3) & 7168;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft10, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset10);
                constructor2 = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composer3 = Updater.constructor-impl(composerStartRestartGroup);
                Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer3, currentCompositionLocalMap10, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer3.getInserting()) {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.set-impl(composer3, modifierMaterializeModifier10, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i12 >> 6) & 112) | 6));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = anonymousClass1;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i13) {
                        BoundsLimiterKt.BoundsLimiter(function1, function2, modifier6, function6, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function3;
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i3 & 9363) == 9362) {
            if (i7 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m905invokeozmzZPI(long j) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass1 = function5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
            }
            Modifier modifierAbsoluteOffset11 = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
            Alignment topLeft11 = AbsoluteAlignment.INSTANCE.getTopLeft();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft11, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset11);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
            Modifier modifierTransparentSizeModifier6 = transparentSizeModifier(modifier3, function2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m906invokeBjo55l4(Density density) {
                        return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m906invokeBjo55l4(Density density) {
                        return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAbsoluteOffset12 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier6, (Function1) objRememberedValue);
            Alignment topLeft12 = AbsoluteAlignment.INSTANCE.getTopLeft();
            int i13 = (i3 >> 3) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft12, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset12);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap12, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier12, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i13 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = anonymousClass1;
        } else {
            if (i7 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                anonymousClass1 = new Function1<IntSize, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.1
                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m905invokeozmzZPI(long j) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m905invokeozmzZPI(((IntSize) obj).unbox-impl());
                        return Unit.INSTANCE;
                    }
                };
            } else {
                anonymousClass1 = function5;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254777585, i3, -1, "androidx.wear.compose.materialcore.BoundsLimiter (BoundsLimiter.kt:48)");
            }
            Modifier modifierAbsoluteOffset13 = OffsetKt.absoluteOffset(OnRemeasuredModifierKt.onSizeChanged(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), anonymousClass1), function1);
            Alignment topLeft13 = AbsoluteAlignment.INSTANCE.getTopLeft();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft13, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset13);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022404902, "C62@2599L13,59@2506L185:BoundsLimiter.kt#f7tims");
            Modifier modifierTransparentSizeModifier7 = transparentSizeModifier(modifier3, function2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 382663997, "CC(remember):BoundsLimiter.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z) {
                objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m906invokeBjo55l4(Density density) {
                        return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$BoundsLimiter$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.box-impl(m906invokeBjo55l4((Density) obj));
                    }

                    /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m906invokeBjo55l4(Density density) {
                        return IntOffset.unaryMinus-nOcc-ac(((IntOffset) function1.invoke(density)).unbox-impl());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAbsoluteOffset14 = OffsetKt.absoluteOffset(modifierTransparentSizeModifier7, (Function1) objRememberedValue);
            Alignment topLeft14 = AbsoluteAlignment.INSTANCE.getTopLeft();
            int i14 = (i3 >> 3) & 7168;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(topLeft14, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAbsoluteOffset14);
            constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap14, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!composer3.getInserting()) {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composer3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composer3.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.set-impl(composer3, modifierMaterializeModifier14, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            function4.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i14 >> 6) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = anonymousClass1;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.BoundsLimiter.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i15) {
                    BoundsLimiterKt.BoundsLimiter(function1, function2, modifier7, function6, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    private static final Modifier transparentSizeModifier(Modifier modifier, final Function1<? super Density, IntSize> function1) {
        return modifier.then(new LayoutModifier() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt.transparentSizeModifier.1
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public MeasureResult m907measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                final Placeable placeable = measurable.measure-BRTryo0(j);
                long j2 = ((IntSize) function1.invoke(measureScope)).unbox-impl();
                return MeasureScope.layout$default(measureScope, IntSize.getWidth-impl(j2), IntSize.getHeight-impl(j2), (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.wear.compose.materialcore.BoundsLimiterKt$transparentSizeModifier$1$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
                    }
                }, 4, (Object) null);
            }
        });
    }
}
