package androidx.wear.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListHeader.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u001c\u0010\u0007\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"ListHeader", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "ListHeader-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "compose-material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ListHeaderKt {
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:30:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x016b  */
    /* JADX WARN: Code duplicated, block: B:79:0x0177  */
    /* JADX WARN: Code duplicated, block: B:80:0x017b  */
    /* JADX WARN: Code duplicated, block: B:83:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:85:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:88:0x0230  */
    /* JADX WARN: Code duplicated, block: B:91:0x0239  */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ListHeader-eopBjH0, reason: not valid java name */
    public static final void m614ListHeadereopBjH0(Modifier modifier, long j, long j2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        int i4;
        Modifier modifier3;
        long j5;
        int i5;
        final long onSurfaceVariant;
        int currentCompositeKeyHash;
        Function0 constructor;
        Composer composer2;
        Function2 setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-708661671);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ListHeader)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)51@2176L6,54@2254L507:ListHeader.kt#gj9v0t");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                j3 = j;
                i3 |= composerStartRestartGroup.changed(j3) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    j4 = j2;
                    int i8 = composerStartRestartGroup.changed(j4) ? 256 : 128;
                    i3 |= i8;
                } else {
                    j4 = j2;
                }
                i3 |= i8;
            } else {
                j4 = j2;
            }
            if ((i2 & 8) != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i4;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) == 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    modifier3 = modifier2;
                } else {
                    if (i6 != 0) {
                        modifier3 = (Modifier) Modifier.Companion;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i7 != 0) {
                        j5 = Color.Companion.getTransparent-0d7_KjU();
                    } else {
                        j5 = j3;
                    }
                    if ((i2 & 4) != 0) {
                        long j6 = j5;
                        i5 = i3 & (-897);
                        onSurfaceVariant = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnSurfaceVariant();
                        j3 = j6;
                    } else {
                        j3 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-708661671, i5, -1, "androidx.wear.compose.material.ListHeader (ListHeader.kt:53)");
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentSize$default(IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, Dp.constructor-impl(48), 1, (Object) null), IntrinsicSize.Min), (Alignment) null, false, 3, (Object) null), j3, (Shape) null, 2, (Object) null), Dp.constructor-impl(14), 0.0f, 2, (Object) null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
                        }
                    });
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
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
                    Updater.set-impl(composer2, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    final RowScope rowScope = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -514501159, "C65@2693L10,66@2722L33,63@2564L191:ListHeader.kt#gj9v0t");
                    CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(onSurfaceVariant)), TextKt.getLocalTextStyle().provides(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton())}, ComposableLambdaKt.rememberComposableLambda(1760990389, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            ComposerKt.sourceInformation(composer3, "C67@2736L9:ListHeader.kt#gj9v0t");
                            if ((i9 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1760990389, i9, -1, "androidx.wear.compose.material.ListHeader.<anonymous>.<anonymous> (ListHeader.kt:67)");
                            }
                            function3.invoke(rowScope, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
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
                i5 = i3;
                onSurfaceVariant = j4;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-708661671, i5, -1, "androidx.wear.compose.material.ListHeader (ListHeader.kt:53)");
                }
                Modifier modifierSemantics2 = SemanticsModifierKt.semantics(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentSize$default(IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, Dp.constructor-impl(48), 1, (Object) null), IntrinsicSize.Min), (Alignment) null, false, 3, (Object) null), j3, (Shape) null, 2, (Object) null), Dp.constructor-impl(14), 0.0f, 2, (Object) null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
                    }
                });
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics2);
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
                Updater.set-impl(composer2, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                final RowScope rowScope2 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -514501159, "C65@2693L10,66@2722L33,63@2564L191:ListHeader.kt#gj9v0t");
                CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(onSurfaceVariant)), TextKt.getLocalTextStyle().provides(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton())}, ComposableLambdaKt.rememberComposableLambda(1760990389, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        ComposerKt.sourceInformation(composer3, "C67@2736L9:ListHeader.kt#gj9v0t");
                        if ((i9 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1760990389, i9, -1, "androidx.wear.compose.material.ListHeader.<anonymous>.<anonymous> (ListHeader.kt:67)");
                        }
                        function3.invoke(rowScope2, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
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
                onSurfaceVariant = j4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                final long j7 = j3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        ListHeaderKt.m614ListHeadereopBjH0(modifier4, j7, onSurfaceVariant, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        j3 = j;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (composerStartRestartGroup.changed(j4)) {
                }
                i3 |= i8;
            } else {
                j4 = j2;
            }
            i3 |= i8;
        } else {
            j4 = j2;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = RecyclerView.ItemAnimator.FLAG_MOVED;
            } else {
                i4 = UserMetadata.MAX_ATTRIBUTE_SIZE;
            }
            i3 |= i4;
        }
        if ((i3 & 1171) == 1170) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i7 != 0) {
                    j5 = Color.Companion.getTransparent-0d7_KjU();
                } else {
                    j5 = j3;
                }
                if ((i2 & 4) != 0) {
                    long j8 = j5;
                    i5 = i3 & (-897);
                    onSurfaceVariant = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnSurfaceVariant();
                    j3 = j8;
                } else {
                    j3 = j5;
                    i5 = i3;
                    onSurfaceVariant = j4;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i7 != 0) {
                    j5 = Color.Companion.getTransparent-0d7_KjU();
                } else {
                    j5 = j3;
                }
                if ((i2 & 4) != 0) {
                    long j9 = j5;
                    i5 = i3 & (-897);
                    onSurfaceVariant = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnSurfaceVariant();
                    j3 = j9;
                } else {
                    j3 = j5;
                    i5 = i3;
                    onSurfaceVariant = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-708661671, i5, -1, "androidx.wear.compose.material.ListHeader (ListHeader.kt:53)");
            }
            Modifier modifierSemantics3 = SemanticsModifierKt.semantics(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentSize$default(IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, Dp.constructor-impl(48), 1, (Object) null), IntrinsicSize.Min), (Alignment) null, false, 3, (Object) null), j3, (Shape) null, 2, (Object) null), Dp.constructor-impl(14), 0.0f, 2, (Object) null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
                }
            });
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics3);
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            final RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -514501159, "C65@2693L10,66@2722L33,63@2564L191:ListHeader.kt#gj9v0t");
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(onSurfaceVariant)), TextKt.getLocalTextStyle().provides(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton())}, ComposableLambdaKt.rememberComposableLambda(1760990389, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "C67@2736L9:ListHeader.kt#gj9v0t");
                    if ((i9 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1760990389, i9, -1, "androidx.wear.compose.material.ListHeader.<anonymous>.<anonymous> (ListHeader.kt:67)");
                    }
                    function3.invoke(rowScope3, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
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
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0) {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i7 != 0) {
                    j5 = Color.Companion.getTransparent-0d7_KjU();
                } else {
                    j5 = j3;
                }
                if ((i2 & 4) != 0) {
                    long j10 = j5;
                    i5 = i3 & (-897);
                    onSurfaceVariant = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnSurfaceVariant();
                    j3 = j10;
                } else {
                    j3 = j5;
                    i5 = i3;
                    onSurfaceVariant = j4;
                }
            } else {
                if (i6 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier2;
                }
                if (i7 != 0) {
                    j5 = Color.Companion.getTransparent-0d7_KjU();
                } else {
                    j5 = j3;
                }
                if ((i2 & 4) != 0) {
                    long j11 = j5;
                    i5 = i3 & (-897);
                    onSurfaceVariant = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getOnSurfaceVariant();
                    j3 = j11;
                } else {
                    j3 = j5;
                    i5 = i3;
                    onSurfaceVariant = j4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-708661671, i5, -1, "androidx.wear.compose.material.ListHeader (ListHeader.kt:53)");
            }
            Modifier modifierSemantics4 = SemanticsModifierKt.semantics(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.wrapContentSize$default(IntrinsicKt.height(SizeKt.defaultMinSize-VpY3zN4$default(modifier3, 0.0f, Dp.constructor-impl(48), 1, (Object) null), IntrinsicSize.Min), (Alignment) null, false, 3, (Object) null), j3, (Shape) null, 2, (Object) null), Dp.constructor-impl(14), 0.0f, 2, (Object) null), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.heading(semanticsPropertyReceiver);
                }
            });
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics4);
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
            Updater.set-impl(composer2, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            final RowScope rowScope4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -514501159, "C65@2693L10,66@2722L33,63@2564L191:ListHeader.kt#gj9v0t");
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(onSurfaceVariant)), TextKt.getLocalTextStyle().provides(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getButton())}, ComposableLambdaKt.rememberComposableLambda(1760990389, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    ComposerKt.sourceInformation(composer3, "C67@2736L9:ListHeader.kt#gj9v0t");
                    if ((i9 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1760990389, i9, -1, "androidx.wear.compose.material.ListHeader.<anonymous>.<anonymous> (ListHeader.kt:67)");
                    }
                    function3.invoke(rowScope4, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j12 = j3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.wear.compose.material.ListHeaderKt$ListHeader$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i9) {
                    ListHeaderKt.m614ListHeadereopBjH0(modifier5, j12, onSurfaceVariant, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
