package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.ConversationMessage;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.viewmodels.ConversationUiAction;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils.TimeUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TranscriptionBubble.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"TranscriptionBubble", "", "modifier", "Landroidx/compose/ui/Modifier;", ResponseKeys.KEY_MESSAGE, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "showUserName", "", "baseFontSize", "Landroidx/compose/ui/unit/TextUnit;", "onAction", "Lkotlin/Function1;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/presentation/viewmodels/ConversationUiAction;", "TranscriptionBubble-n82DnDo", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;ZJLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TranscriptionBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TranscriptionBubble_n82DnDo$lambda$8(Modifier modifier, ConversationMessage conversationMessage, boolean z, long j, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1601TranscriptionBubblen82DnDo(modifier, conversationMessage, z, j, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x028a  */
    /* JADX WARN: Code duplicated, block: B:103:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:106:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:107:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:110:0x0339  */
    /* JADX WARN: Code duplicated, block: B:112:0x0341  */
    /* JADX WARN: Code duplicated, block: B:115:0x034e  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:39:0x007f  */
    /* JADX WARN: Code duplicated, block: B:44:0x008a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0090  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:51:0x009e  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00de  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:77:0x0105  */
    /* JADX WARN: Code duplicated, block: B:80:0x0123  */
    /* JADX WARN: Code duplicated, block: B:81:0x0177  */
    /* JADX WARN: Code duplicated, block: B:84:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:87:0x0206  */
    /* JADX WARN: Code duplicated, block: B:88:0x020a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0271  */
    /* JADX WARN: Code duplicated, block: B:92:0x0273  */
    /* JADX WARN: Code duplicated, block: B:95:0x027a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0282  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r8v25, types: [boolean] */
    /* JADX INFO: renamed from: TranscriptionBubble-n82DnDo, reason: not valid java name */
    public static final void m1601TranscriptionBubblen82DnDo(Modifier modifier, final ConversationMessage conversationMessage, boolean z, long j, final Function1<? super ConversationUiAction, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        final Modifier modifier3;
        final boolean z4;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        boolean z5;
        long sp;
        boolean z6;
        Alignment.Companion companion;
        Alignment centerStart;
        RoundedCornerShape roundedCornerShape;
        Alignment alignment;
        boolean z7;
        int i6;
        CardColors cardColors;
        Composer composer2;
        Function0 constructor;
        int i7;
        ?? r0;
        int i8;
        Object objRememberedValue;
        Object objRememberedValue2;
        float f;
        int i9;
        Intrinsics.checkNotNullParameter(conversationMessage, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer composerStartRestartGroup = composer.startRestartGroup(-222648538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TranscriptionBubble)P(2,1,4,0:c#ui.unit.TextUnit)65@2921L2410:TranscriptionBubble.kt#hsonup");
        int i10 = i2 & 1;
        if (i10 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(conversationMessage) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(j)) {
                        i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                    } else {
                        i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    j2 = j;
                } else {
                    if (i10 != 0) {
                        modifier4 = (Modifier) Modifier.Companion;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i11 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i4 != 0) {
                        sp = TextUnitKt.getSp(16);
                    } else {
                        sp = j;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-222648538, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubble (TranscriptionBubble.kt:40)");
                    }
                    final String userName = conversationMessage.getUserName();
                    if (conversationMessage.getMessageType() == MessageType.TEXT_TO_SPEECH) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    companion = Alignment.Companion;
                    if (z6) {
                        centerStart = companion.getCenterEnd();
                    } else {
                        centerStart = companion.getCenterStart();
                    }
                    if (z6) {
                        float f2 = 16;
                        roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f2), Dp.constructor-impl(f2), Dp.constructor-impl(0), Dp.constructor-impl(f2));
                    } else {
                        float f3 = 16;
                        roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f3), Dp.constructor-impl(f3), Dp.constructor-impl(f3), Dp.constructor-impl(0));
                    }
                    RoundedCornerShape roundedCornerShape2 = roundedCornerShape;
                    if (conversationMessage.isProcessed()) {
                        composerStartRestartGroup.startReplaceGroup(-1492306387);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "54@2582L11,55@2655L11,53@2519L178");
                        alignment = centerStart;
                        z7 = false;
                        i6 = 1;
                        cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    } else {
                        alignment = centerStart;
                        z7 = false;
                        i6 = 1;
                        composerStartRestartGroup.startReplaceGroup(-1492095153);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "59@2795L11,60@2867L11,58@2732L176");
                        cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    CardColors cardColors2 = cardColors;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, i6, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, z7);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, z7 ? 1 : 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                    constructor = ComposeUiNode.Companion.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composer3 = Updater.constructor-impl(composer2);
                    Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 931374464, "C74@3217L105,73@3179L2,80@3445L113,83@3569L1756,69@3030L2295:TranscriptionBubble.kt#hsonup");
                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion, 0.85f);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1692616117, "CC(remember):TranscriptionBubble.kt#9igjgp");
                    if ((57344 & i3) == 16384) {
                        i7 = i6;
                    } else {
                        i7 = z7 ? 1 : 0;
                    }
                    r0 = z7;
                    if ((i3 & 112) == 32) {
                        r0 = i6;
                    }
                    i8 = r0 | i7;
                    objRememberedValue = composer2.rememberedValue();
                    if (i8 == 0 || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1692614798, "CC(remember):TranscriptionBubble.kt#9igjgp");
                    objRememberedValue2 = composer2.rememberedValue();
                    if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifier5 = ClickableKt.combinedClickable-hoGz1lA$default(modifierFillMaxWidth, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (MutableInteractionSource) null, (Function0) objRememberedValue2, 239, (Object) null);
                    CardDefaults cardDefaults = CardDefaults.INSTANCE;
                    if (conversationMessage.isProcessed()) {
                        f = Dp.constructor-impl((float) 0.5d);
                    } else {
                        f = Dp.constructor-impl(2);
                    }
                    Composer composer4 = composer2;
                    composerStartRestartGroup = composer4;
                    Modifier modifier6 = modifier4;
                    final boolean z8 = z5;
                    final long j3 = sp;
                    CardKt.ElevatedCard(modifier5, (Shape) roundedCornerShape2, cardColors2, cardDefaults.elevatedCardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer4, CardDefaults.$stable << 18, 62), ComposableLambdaKt.rememberComposableLambda(675497575, i6, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$6(z8, userName, j3, conversationMessage, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = j3;
                    z4 = z8;
                    modifier3 = modifier6;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$8(modifier3, conversationMessage, z4, j2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                j2 = j;
            } else {
                if (i10 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i11 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i4 != 0) {
                    sp = TextUnitKt.getSp(16);
                } else {
                    sp = j;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-222648538, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubble (TranscriptionBubble.kt:40)");
                }
                final String userName2 = conversationMessage.getUserName();
                if (conversationMessage.getMessageType() == MessageType.TEXT_TO_SPEECH) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                companion = Alignment.Companion;
                if (z6) {
                    centerStart = companion.getCenterEnd();
                } else {
                    centerStart = companion.getCenterStart();
                }
                if (z6) {
                    float f4 = 16;
                    roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f4), Dp.constructor-impl(f4), Dp.constructor-impl(0), Dp.constructor-impl(f4));
                } else {
                    float f5 = 16;
                    roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f5), Dp.constructor-impl(f5), Dp.constructor-impl(f5), Dp.constructor-impl(0));
                }
                RoundedCornerShape roundedCornerShape3 = roundedCornerShape;
                if (conversationMessage.isProcessed()) {
                    composerStartRestartGroup.startReplaceGroup(-1492306387);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@2582L11,55@2655L11,53@2519L178");
                    alignment = centerStart;
                    z7 = false;
                    i6 = 1;
                    cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    alignment = centerStart;
                    z7 = false;
                    i6 = 1;
                    composerStartRestartGroup.startReplaceGroup(-1492095153);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@2795L11,60@2867L11,58@2732L176");
                    cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                CardColors cardColors3 = cardColors;
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, i6, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, z7);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, z7 ? 1 : 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default2);
                constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composer5 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer5, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer5, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer5, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 931374464, "C74@3217L105,73@3179L2,80@3445L113,83@3569L1756,69@3030L2295:TranscriptionBubble.kt#hsonup");
                Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(Modifier.Companion, 0.85f);
                ComposerKt.sourceInformationMarkerStart(composer2, 1692616117, "CC(remember):TranscriptionBubble.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                    i7 = i6;
                } else {
                    i7 = z7 ? 1 : 0;
                }
                r0 = z7;
                if ((i3 & 112) == 32) {
                    r0 = i6;
                }
                i8 = r0 | i7;
                objRememberedValue = composer2.rememberedValue();
                if (i8 == 0) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function2 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1692614798, "CC(remember):TranscriptionBubble.kt#9igjgp");
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifier7 = ClickableKt.combinedClickable-hoGz1lA$default(modifierFillMaxWidth2, false, (String) null, (Role) null, (String) null, function2, (Function0) null, false, (MutableInteractionSource) null, (Function0) objRememberedValue2, 239, (Object) null);
                CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
                if (conversationMessage.isProcessed()) {
                    f = Dp.constructor-impl((float) 0.5d);
                } else {
                    f = Dp.constructor-impl(2);
                }
                Composer composer6 = composer2;
                composerStartRestartGroup = composer6;
                Modifier modifier8 = modifier4;
                final boolean z9 = z5;
                final long j4 = sp;
                CardKt.ElevatedCard(modifier7, (Shape) roundedCornerShape3, cardColors3, cardDefaults2.elevatedCardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer6, CardDefaults.$stable << 18, 62), ComposableLambdaKt.rememberComposableLambda(675497575, i6, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$6(z9, userName2, j4, conversationMessage, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j4;
                z4 = z9;
                modifier3 = modifier8;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$8(modifier3, conversationMessage, z4, j2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(j)) {
                    i5 = RecyclerView.ItemAnimator.FLAG_MOVED;
                } else {
                    i5 = UserMetadata.MAX_ATTRIBUTE_SIZE;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                j2 = j;
            } else {
                if (i10 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i11 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i4 != 0) {
                    sp = TextUnitKt.getSp(16);
                } else {
                    sp = j;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-222648538, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubble (TranscriptionBubble.kt:40)");
                }
                final String userName3 = conversationMessage.getUserName();
                if (conversationMessage.getMessageType() == MessageType.TEXT_TO_SPEECH) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                companion = Alignment.Companion;
                if (z6) {
                    centerStart = companion.getCenterEnd();
                } else {
                    centerStart = companion.getCenterStart();
                }
                if (z6) {
                    float f6 = 16;
                    roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f6), Dp.constructor-impl(f6), Dp.constructor-impl(0), Dp.constructor-impl(f6));
                } else {
                    float f7 = 16;
                    roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f7), Dp.constructor-impl(f7), Dp.constructor-impl(f7), Dp.constructor-impl(0));
                }
                RoundedCornerShape roundedCornerShape4 = roundedCornerShape;
                if (conversationMessage.isProcessed()) {
                    composerStartRestartGroup.startReplaceGroup(-1492306387);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@2582L11,55@2655L11,53@2519L178");
                    alignment = centerStart;
                    z7 = false;
                    i6 = 1;
                    cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                } else {
                    alignment = centerStart;
                    z7 = false;
                    i6 = 1;
                    composerStartRestartGroup.startReplaceGroup(-1492095153);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "59@2795L11,60@2867L11,58@2732L176");
                    cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                CardColors cardColors4 = cardColors;
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, i6, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, z7);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, z7 ? 1 : 0));
                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default3);
                constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer composer7 = Updater.constructor-impl(composer2);
                Updater.set-impl(composer7, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer7, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer7, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer7, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 931374464, "C74@3217L105,73@3179L2,80@3445L113,83@3569L1756,69@3030L2295:TranscriptionBubble.kt#hsonup");
                Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(Modifier.Companion, 0.85f);
                ComposerKt.sourceInformationMarkerStart(composer2, 1692616117, "CC(remember):TranscriptionBubble.kt#9igjgp");
                if ((57344 & i3) == 16384) {
                    i7 = i6;
                } else {
                    i7 = z7 ? 1 : 0;
                }
                r0 = z7;
                if ((i3 & 112) == 32) {
                    r0 = i6;
                }
                i8 = r0 | i7;
                objRememberedValue = composer2.rememberedValue();
                if (i8 == 0) {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function3 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, 1692614798, "CC(remember):TranscriptionBubble.kt#9igjgp");
                objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifier9 = ClickableKt.combinedClickable-hoGz1lA$default(modifierFillMaxWidth3, false, (String) null, (Role) null, (String) null, function3, (Function0) null, false, (MutableInteractionSource) null, (Function0) objRememberedValue2, 239, (Object) null);
                CardDefaults cardDefaults3 = CardDefaults.INSTANCE;
                if (conversationMessage.isProcessed()) {
                    f = Dp.constructor-impl((float) 0.5d);
                } else {
                    f = Dp.constructor-impl(2);
                }
                Composer composer8 = composer2;
                composerStartRestartGroup = composer8;
                Modifier modifier10 = modifier4;
                final boolean z10 = z5;
                final long j5 = sp;
                CardKt.ElevatedCard(modifier9, (Shape) roundedCornerShape4, cardColors4, cardDefaults3.elevatedCardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer8, CardDefaults.$stable << 18, 62), ComposableLambdaKt.rememberComposableLambda(675497575, i6, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$6(z10, userName3, j5, conversationMessage, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j5;
                z4 = z10;
                modifier3 = modifier10;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$8(modifier3, conversationMessage, z4, j2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            j2 = j;
        } else {
            if (i10 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i11 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i4 != 0) {
                sp = TextUnitKt.getSp(16);
            } else {
                sp = j;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-222648538, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubble (TranscriptionBubble.kt:40)");
            }
            final String userName4 = conversationMessage.getUserName();
            if (conversationMessage.getMessageType() == MessageType.TEXT_TO_SPEECH) {
                z6 = true;
            } else {
                z6 = false;
            }
            companion = Alignment.Companion;
            if (z6) {
                centerStart = companion.getCenterEnd();
            } else {
                centerStart = companion.getCenterStart();
            }
            if (z6) {
                float f8 = 16;
                roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f8), Dp.constructor-impl(f8), Dp.constructor-impl(0), Dp.constructor-impl(f8));
            } else {
                float f9 = 16;
                roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f9), Dp.constructor-impl(f9), Dp.constructor-impl(f9), Dp.constructor-impl(0));
            }
            RoundedCornerShape roundedCornerShape5 = roundedCornerShape;
            if (conversationMessage.isProcessed()) {
                composerStartRestartGroup.startReplaceGroup(-1492306387);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@2582L11,55@2655L11,53@2519L178");
                alignment = centerStart;
                z7 = false;
                i6 = 1;
                cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSecondaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSecondaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            } else {
                alignment = centerStart;
                z7 = false;
                i6 = 1;
                composerStartRestartGroup.startReplaceGroup(-1492095153);
                ComposerKt.sourceInformation(composerStartRestartGroup, "59@2795L11,60@2867L11,58@2732L176");
                cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            CardColors cardColors5 = cardColors;
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(modifier4, 0.0f, i6, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(alignment, z7);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, z7 ? 1 : 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default4);
            constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composer9 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer9, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer9, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer9, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer9, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 931374464, "C74@3217L105,73@3179L2,80@3445L113,83@3569L1756,69@3030L2295:TranscriptionBubble.kt#hsonup");
            Modifier modifierFillMaxWidth4 = SizeKt.fillMaxWidth(Modifier.Companion, 0.85f);
            ComposerKt.sourceInformationMarkerStart(composer2, 1692616117, "CC(remember):TranscriptionBubble.kt#9igjgp");
            if ((57344 & i3) == 16384) {
                i7 = i6;
            } else {
                i7 = z7 ? 1 : 0;
            }
            r0 = z7;
            if ((i3 & 112) == 32) {
                r0 = i6;
            }
            i8 = r0 | i7;
            objRememberedValue = composer2.rememberedValue();
            if (i8 == 0) {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(function1, conversationMessage);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            Function0 function4 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerStart(composer2, 1692614798, "CC(remember):TranscriptionBubble.kt#9igjgp");
            objRememberedValue2 = composer2.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifier11 = ClickableKt.combinedClickable-hoGz1lA$default(modifierFillMaxWidth4, false, (String) null, (Role) null, (String) null, function4, (Function0) null, false, (MutableInteractionSource) null, (Function0) objRememberedValue2, 239, (Object) null);
            CardDefaults cardDefaults4 = CardDefaults.INSTANCE;
            if (conversationMessage.isProcessed()) {
                f = Dp.constructor-impl((float) 0.5d);
            } else {
                f = Dp.constructor-impl(2);
            }
            Composer composer10 = composer2;
            composerStartRestartGroup = composer10;
            Modifier modifier12 = modifier4;
            final boolean z11 = z5;
            final long j6 = sp;
            CardKt.ElevatedCard(modifier11, (Shape) roundedCornerShape5, cardColors5, cardDefaults4.elevatedCardElevation-aqJV_2Y(f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer10, CardDefaults.$stable << 18, 62), ComposableLambdaKt.rememberComposableLambda(675497575, i6, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$7$lambda$6(z11, userName4, j6, conversationMessage, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j6;
            z4 = z11;
            modifier3 = modifier12;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubbleKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return TranscriptionBubbleKt.TranscriptionBubble_n82DnDo$lambda$8(modifier3, conversationMessage, z4, j2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TranscriptionBubble_n82DnDo$lambda$7$lambda$1$lambda$0(Function1 function1, ConversationMessage conversationMessage) {
        function1.invoke(new ConversationUiAction.OnBubbleLongPress(conversationMessage));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TranscriptionBubble_n82DnDo$lambda$7$lambda$6(boolean z, String str, long j, ConversationMessage conversationMessage, ColumnScope columnScope, Composer composer, int i) {
        String str2;
        String str3;
        String str4;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(columnScope, "$this$ElevatedCard");
        ComposerKt.sourceInformation(composer2, "C84@3583L1732:TranscriptionBubble.kt#hsonup");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(675497575, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TranscriptionBubble.<anonymous>.<anonymous> (TranscriptionBubble.kt:84)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer2, 0);
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composer2);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1847783349, "C103@4412L7,99@4206L231,106@4455L40,108@4513L788:TranscriptionBubble.kt#hsonup");
            if (z && !StringsKt.isBlank(str)) {
                composer2.startReplaceGroup(-1847776530);
                ComposerKt.sourceInformation(composer2, "92@3958L7,88@3739L431");
                long sp = TextUnitKt.getSp(TextUnit.getValue-impl(j) * 0.75f);
                FontWeight bold = FontWeight.Companion.getBold();
                CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composer2.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                str2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                TextKt.Text-Nvy7gAk(str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(2), 7, (Object) null), Color.copy-wmQWz5c$default(((Color) objConsume).unbox-impl(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, composer2, 1572912, 24960, 241576);
                composer2 = composer2;
            } else {
                str2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                composer2.startReplaceGroup(-1851479387);
            }
            composer2.endReplaceGroup();
            String message = conversationMessage.getMessage();
            long sp2 = TextUnitKt.getSp(TextUnit.getValue-impl(j) * 1.3f);
            CompositionLocal localContentColor2 = ContentColorKt.getLocalContentColor();
            String str5 = str2;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, str5);
            Object objConsume2 = composer2.consume(localContentColor2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            TextKt.Text-Nvy7gAk(message, (Modifier) null, ((Color) objConsume2).unbox-impl(), (TextAutoSize) null, j, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp2, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 260074);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), composer, 6);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, str3);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, str4);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 955334990, "C114@4788L50,116@4958L7,113@4751L256,121@5234L7,118@5028L255:TranscriptionBubble.kt#hsonup");
            String strStringResource = StringResources_androidKt.stringResource(conversationMessage.getMessageType().getDisplayTextRes(), composer, 0);
            long sp3 = TextUnitKt.getSp(TextUnit.getValue-impl(j) * 0.65f);
            CompositionLocal localContentColor3 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, str5);
            Object objConsume3 = composer.consume(localContentColor3);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(strStringResource, (Modifier) null, Color.copy-wmQWz5c$default(((Color) objConsume3).unbox-impl(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, sp3, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262122);
            String strMillisToDateString$default = TimeUtils.millisToDateString$default(TimeUtils.INSTANCE, conversationMessage.getTimeCreated(), null, null, 6, null);
            long sp4 = TextUnitKt.getSp(TextUnit.getValue-impl(j) * 0.65f);
            CompositionLocal localContentColor4 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, str5);
            Object objConsume4 = composer.consume(localContentColor4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(strMillisToDateString$default, (Modifier) null, Color.copy-wmQWz5c$default(((Color) objConsume4).unbox-impl(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, sp4, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
