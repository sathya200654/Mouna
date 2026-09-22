package androidx.wear.compose.material;

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
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0015\b\u0002\u0010\u0004\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\u0007\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "vignette", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "positionIndicator", "pageIndicator", "timeText", "content", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ScaffoldKt {
    /* JADX WARN: Code duplicated, block: B:100:0x0177  */
    /* JADX WARN: Code duplicated, block: B:104:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:112:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:116:0x020f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0235  */
    /* JADX WARN: Code duplicated, block: B:122:0x0240  */
    /* JADX WARN: Code duplicated, block: B:124:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:91:0x0134  */
    /* JADX WARN: Code duplicated, block: B:94:0x0140  */
    /* JADX WARN: Code duplicated, block: B:95:0x0144  */
    /* JADX WARN: Code duplicated, block: B:98:0x0169  */
    public static final void Scaffold(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, final Function2<? super Composer, ? super Integer, Unit> function6, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function10;
        int i9;
        int i10;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-135365608);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scaffold)P(1,5,3,2,4)64@3171L172:Scaffold.kt#gj9v0t");
        int i11 = i2 & 1;
        if (i11 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                function7 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function7) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function8 = function3;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        function9 = function4;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                        } else {
                            i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            function10 = function5;
                            if (composerStartRestartGroup.changedInstance(function10)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i2 & 32) != 0) {
                            i3 |= 196608;
                        } else if ((i & 196608) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i10 = 131072;
                            } else {
                                i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                            }
                            i3 |= i10;
                        }
                        if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                            if (i11 != 0) {
                                modifier3 = (Modifier) Modifier.Companion;
                            } else {
                                modifier3 = modifier2;
                            }
                            if (i12 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                function8 = null;
                            }
                            if (i6 != 0) {
                                function9 = null;
                            }
                            if (i8 != 0) {
                                function10 = null;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                            function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                            composerStartRestartGroup.startReplaceGroup(-642566498);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                            if (function7 != null) {
                                function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-642565346);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                            if (function8 != null) {
                                function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-642564322);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                            if (function9 != null) {
                                function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-642563458);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                            if (function10 != null) {
                                function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                            modifier3 = modifier2;
                        }
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        function14 = function10;
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ScaffoldKt.Scaffold(modifier4, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    function10 = function5;
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                    } else if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    }
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier5 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ScaffoldKt.Scaffold(modifier5, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                function9 = function4;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function10 = function5;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                    } else if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        BoxScope boxScope5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    }
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier6 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ScaffoldKt.Scaffold(modifier6, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function10 = function5;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    BoxScope boxScope7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                }
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier7 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ScaffoldKt.Scaffold(modifier7, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            function8 = function3;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function10 = function5;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                    } else if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope8 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        BoxScope boxScope9 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    }
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier8 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ScaffoldKt.Scaffold(modifier8, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function10 = function5;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope10 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    BoxScope boxScope11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                }
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier9 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ScaffoldKt.Scaffold(modifier9, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            function9 = function4;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function10 = function5;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope12 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    BoxScope boxScope13 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                }
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier10 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ScaffoldKt.Scaffold(modifier10, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function10 = function5;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i10;
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            }
            function11 = function7;
            function12 = function8;
            function13 = function9;
            function14 = function10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier11 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ScaffoldKt.Scaffold(modifier11, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        function7 = function2;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function8 = function3;
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        function10 = function5;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i2 & 32) != 0) {
                        i3 |= 196608;
                    } else if ((i & 196608) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i10 = 131072;
                        } else {
                            i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                        }
                        i3 |= i10;
                    }
                    if ((74899 & i3) == 74898) {
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope16 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                        if (i11 != 0) {
                            modifier3 = (Modifier) Modifier.Companion;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i12 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            function8 = null;
                        }
                        if (i6 != 0) {
                            function9 = null;
                        }
                        if (i8 != 0) {
                            function10 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                        Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy17, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope17 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                        function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        composerStartRestartGroup.startReplaceGroup(-642566498);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                        if (function7 != null) {
                            function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642565346);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                        if (function8 != null) {
                            function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642564322);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                        if (function9 != null) {
                            function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(-642563458);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                        if (function10 != null) {
                            function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    }
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier12 = modifier3;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i13) {
                                ScaffoldKt.Scaffold(modifier12, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 24576;
                function10 = function5;
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope18 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy19, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope19 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                }
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier13 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ScaffoldKt.Scaffold(modifier13, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            function9 = function4;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function10 = function5;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy110, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope110 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy111, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope111 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                }
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier14 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ScaffoldKt.Scaffold(modifier14, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function10 = function5;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i10;
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy112, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope112 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy113, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope113 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            }
            function11 = function7;
            function12 = function8;
            function13 = function9;
            function14 = function10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier15 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ScaffoldKt.Scaffold(modifier15, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        function8 = function3;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                function9 = function4;
                if (composerStartRestartGroup.changedInstance(function9)) {
                    i7 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i7 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    function10 = function5;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i2 & 32) != 0) {
                    i3 |= 196608;
                } else if ((i & 196608) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i10 = 131072;
                    } else {
                        i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                    }
                    i3 |= i10;
                }
                if ((74899 & i3) == 74898) {
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy114, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope114 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    if (i11 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i12 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        function8 = null;
                    }
                    if (i6 != 0) {
                        function9 = null;
                    }
                    if (i8 != 0) {
                        function10 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy115 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                    Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy115, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope115 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                    function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    composerStartRestartGroup.startReplaceGroup(-642566498);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                    if (function7 != null) {
                        function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642565346);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                    if (function8 != null) {
                        function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642564322);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                    if (function9 != null) {
                        function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-642563458);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                    if (function10 != null) {
                        function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                }
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier16 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ScaffoldKt.Scaffold(modifier16, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 24576;
            function10 = function5;
            if ((i2 & 32) != 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i10;
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy116 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy116, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope116 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy117 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy117, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope117 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            }
            function11 = function7;
            function12 = function8;
            function13 = function9;
            function14 = function10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier17 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ScaffoldKt.Scaffold(modifier17, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        function9 = function4;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                function10 = function5;
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i2 & 32) != 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i10 = 131072;
                } else {
                    i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
                }
                i3 |= i10;
            }
            if ((74899 & i3) == 74898) {
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy118 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy118, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope118 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                if (i11 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i12 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    function8 = null;
                }
                if (i6 != 0) {
                    function9 = null;
                }
                if (i8 != 0) {
                    function10 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy119 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy119, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope119 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
                function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                composerStartRestartGroup.startReplaceGroup(-642566498);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
                if (function7 != null) {
                    function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642565346);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
                if (function8 != null) {
                    function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642564322);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
                if (function9 != null) {
                    function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-642563458);
                ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
                if (function10 != null) {
                    function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            }
            function11 = function7;
            function12 = function8;
            function13 = function9;
            function14 = function10;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier18 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ScaffoldKt.Scaffold(modifier18, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 24576;
        function10 = function5;
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i10 = 131072;
            } else {
                i10 = ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
            }
            i3 |= i10;
        }
        if ((74899 & i3) == 74898) {
            if (i11 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i12 != 0) {
                function7 = null;
            }
            if (i4 != 0) {
                function8 = null;
            }
            if (i6 != 0) {
                function9 = null;
            }
            if (i8 != 0) {
                function10 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy1110, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope1110 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
            function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
            composerStartRestartGroup.startReplaceGroup(-642566498);
            ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
            if (function7 != null) {
                function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-642565346);
            ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
            if (function8 != null) {
                function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-642564322);
            ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
            if (function9 != null) {
                function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-642563458);
            ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
            if (function10 != null) {
                function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            if (i11 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i12 != 0) {
                function7 = null;
            }
            if (i4 != 0) {
                function8 = null;
            }
            if (i6 != 0) {
                function9 = null;
            }
            if (i8 != 0) {
                function10 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-135365608, i3, -1, "androidx.wear.compose.material.Scaffold (Scaffold.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
            Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy1111, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope1111 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1555251082, "C65@3206L9:Scaffold.kt#gj9v0t");
            function6.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
            composerStartRestartGroup.startReplaceGroup(-642566498);
            ComposerKt.sourceInformation(composerStartRestartGroup, "66@3234L8");
            if (function7 != null) {
                function7.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-642565346);
            ComposerKt.sourceInformation(composerStartRestartGroup, "67@3270L8");
            if (function8 != null) {
                function8.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-642564322);
            ComposerKt.sourceInformation(composerStartRestartGroup, "68@3302L8");
            if (function9 != null) {
                function9.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-642563458);
            ComposerKt.sourceInformation(composerStartRestartGroup, "69@3329L8");
            if (function10 != null) {
                function10.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
        }
        function11 = function7;
        function12 = function8;
        function13 = function9;
        function14 = function10;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier19 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ScaffoldKt.Scaffold.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    ScaffoldKt.Scaffold(modifier19, function11, function12, function13, function14, function6, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
