package androidx.wear.compose.material;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Vignette.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"Vignette", "", "vignettePosition", "Landroidx/wear/compose/material/VignettePosition;", "modifier", "Landroidx/compose/ui/Modifier;", "Vignette-V-tdIJU", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class VignetteKt {
    /* JADX WARN: Code duplicated, block: B:30:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:41:0x00be  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:50:0x0131  */
    /* JADX WARN: Code duplicated, block: B:52:0x0137  */
    /* JADX WARN: Code duplicated, block: B:53:0x013a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0174  */
    /* JADX WARN: Code duplicated, block: B:58:0x018c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0192  */
    /* JADX WARN: Code duplicated, block: B:61:0x0195  */
    /* JADX WARN: Code duplicated, block: B:65:0x01db  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: Vignette-V-tdIJU, reason: not valid java name */
    public static final void m869VignetteVtdIJU(final int i, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        final Modifier modifier2;
        Modifier modifier3;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        BoxScope boxScope;
        BoxScope boxScope2;
        int i5;
        ImageResources imageResources;
        ImageResources imageResources2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(1408741579);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Vignette)P(1:androidx.wear.compose.material.VignettePosition)98@3131L1064:Vignette.kt#gj9v0t");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i6 = i3 & 2;
        if (i6 == 0) {
            if ((i2 & 48) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i4 & 19) == 18 || !composerStartRestartGroup.getSkipping()) {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1408741579, i4, -1, "androidx.wear.compose.material.Vignette (Vignette.kt:96)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1528740696, "C:Vignette.kt#gj9v0t");
                composerStartRestartGroup.startReplaceGroup(-920517624);
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@3298L15,101@3259L171,100@3226L438");
                if (VignettePosition.m873drawTopimpl$compose_material_release(i)) {
                    if (androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composerStartRestartGroup, 0)) {
                        imageResources2 = ImageResources.CircularVignetteTop;
                    } else {
                        imageResources2 = ImageResources.RectangularVignetteTop;
                    }
                    i5 = 0;
                    boxScope2 = boxScope;
                    ImageKt.Image(ResourcesKt.imageResource(imageResources2, composerStartRestartGroup, 0), (String) null, SizeKt.fillMaxWidth$default(boxScope.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
                } else {
                    boxScope2 = boxScope;
                    i5 = 0;
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-920501516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "115@3804L15,114@3765L177,113@3732L447");
                if (VignettePosition.m872drawBottomimpl$compose_material_release(i)) {
                    if (androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composerStartRestartGroup, i5)) {
                        imageResources = ImageResources.CircularVignetteBottom;
                    } else {
                        imageResources = ImageResources.RectangularVignetteBottom;
                    }
                    ImageKt.Image(ResourcesKt.imageResource(imageResources, composerStartRestartGroup, i5), (String) null, SizeKt.fillMaxWidth$default(boxScope2.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
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
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.VignetteKt$Vignette$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i7) {
                        VignetteKt.m869VignetteVtdIJU(i, modifier2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
            }
        }
        i4 |= 48;
        modifier2 = modifier;
        if ((i4 & 19) == 18) {
            if (i6 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408741579, i4, -1, "androidx.wear.compose.material.Vignette (Vignette.kt:96)");
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
            boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1528740696, "C:Vignette.kt#gj9v0t");
            composerStartRestartGroup.startReplaceGroup(-920517624);
            ComposerKt.sourceInformation(composerStartRestartGroup, "102@3298L15,101@3259L171,100@3226L438");
            if (VignettePosition.m873drawTopimpl$compose_material_release(i)) {
                if (androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composerStartRestartGroup, 0)) {
                    imageResources2 = ImageResources.CircularVignetteTop;
                } else {
                    imageResources2 = ImageResources.RectangularVignetteTop;
                }
                i5 = 0;
                boxScope2 = boxScope;
                ImageKt.Image(ResourcesKt.imageResource(imageResources2, composerStartRestartGroup, 0), (String) null, SizeKt.fillMaxWidth$default(boxScope.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
            } else {
                boxScope2 = boxScope;
                i5 = 0;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-920501516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "115@3804L15,114@3765L177,113@3732L447");
            if (VignettePosition.m872drawBottomimpl$compose_material_release(i)) {
                if (androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composerStartRestartGroup, i5)) {
                    imageResources = ImageResources.CircularVignetteBottom;
                } else {
                    imageResources = ImageResources.RectangularVignetteBottom;
                }
                ImageKt.Image(ResourcesKt.imageResource(imageResources, composerStartRestartGroup, i5), (String) null, SizeKt.fillMaxWidth$default(boxScope2.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
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
            modifier2 = modifier3;
        } else {
            if (i6 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408741579, i4, -1, "androidx.wear.compose.material.Vignette (Vignette.kt:96)");
            }
            Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
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
            boxScope = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1528740696, "C:Vignette.kt#gj9v0t");
            composerStartRestartGroup.startReplaceGroup(-920517624);
            ComposerKt.sourceInformation(composerStartRestartGroup, "102@3298L15,101@3259L171,100@3226L438");
            if (VignettePosition.m873drawTopimpl$compose_material_release(i)) {
                if (androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composerStartRestartGroup, 0)) {
                    imageResources2 = ImageResources.CircularVignetteTop;
                } else {
                    imageResources2 = ImageResources.RectangularVignetteTop;
                }
                i5 = 0;
                boxScope2 = boxScope;
                ImageKt.Image(ResourcesKt.imageResource(imageResources2, composerStartRestartGroup, 0), (String) null, SizeKt.fillMaxWidth$default(boxScope.align(Modifier.Companion, Alignment.Companion.getTopCenter()), 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
            } else {
                boxScope2 = boxScope;
                i5 = 0;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-920501516);
            ComposerKt.sourceInformation(composerStartRestartGroup, "115@3804L15,114@3765L177,113@3732L447");
            if (VignettePosition.m872drawBottomimpl$compose_material_release(i)) {
                if (androidx.wear.compose.materialcore.ResourcesKt.isRoundDevice(composerStartRestartGroup, i5)) {
                    imageResources = ImageResources.CircularVignetteBottom;
                } else {
                    imageResources = ImageResources.RectangularVignetteBottom;
                }
                ImageKt.Image(ResourcesKt.imageResource(imageResources, composerStartRestartGroup, i5), (String) null, SizeKt.fillMaxWidth$default(boxScope2.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillWidth(), 0.0f, (ColorFilter) null, composerStartRestartGroup, 24624, 104);
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
            modifier2 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.VignetteKt$Vignette$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    VignetteKt.m869VignetteVtdIJU(i, modifier2, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                }
            });
        }
    }
}
