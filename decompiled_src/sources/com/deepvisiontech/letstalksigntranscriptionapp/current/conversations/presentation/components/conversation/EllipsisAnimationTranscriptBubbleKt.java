package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EllipsisAnimationTranscriptBubble.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\u001a#\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"EllipsisAnimationTranscriptBubble", "", "modifier", "Landroidx/compose/ui/Modifier;", "baseFontSize", "Landroidx/compose/ui/unit/TextUnit;", "EllipsisAnimationTranscriptBubble-KmRG4DE", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "app_release", "dotCount", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EllipsisAnimationTranscriptBubbleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$5(Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m1579EllipsisAnimationTranscriptBubbleKmRG4DE(modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0056  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x0061 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0063  */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:38:0x007a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0106  */
    /* JADX WARN: Code duplicated, block: B:43:0x0113  */
    /* JADX WARN: Code duplicated, block: B:44:0x0116  */
    /* JADX WARN: Code duplicated, block: B:53:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:55:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:58:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: EllipsisAnimationTranscriptBubble-KmRG4DE, reason: not valid java name */
    public static final void m1579EllipsisAnimationTranscriptBubbleKmRG4DE(Modifier modifier, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        int i4;
        int i5;
        boolean z;
        final Modifier modifier3;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        long sp;
        long j4;
        State stateAnimateValue;
        AnnotatedString.Builder builder;
        float f;
        int iPushStyle;
        Composer composerStartRestartGroup = composer.startRestartGroup(-336478515);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EllipsisAnimationTranscriptBubble)P(1,0:c#ui.unit.TextUnit)39@1702L7,40@1729L54,42@1805L38,43@1853L329,75@2768L11,76@2840L11,74@2705L176,78@2913L6,79@2960L46,80@3013L227,72@2632L608:EllipsisAnimationTranscriptBubble.kt#hsonup");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = i | (composerStartRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                j2 = j;
                i3 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = j2;
            } else {
                if (i6 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i7 != 0) {
                    sp = TextUnitKt.getSp(16);
                } else {
                    sp = j2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-336478515, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubble (EllipsisAnimationTranscriptBubble.kt:38)");
                }
                CompositionLocal localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                j4 = ((Color) objConsume).unbox-impl();
                String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_bubble_msg_queue, composerStartRestartGroup, 0);
                final long j5 = sp;
                stateAnimateValue = InfiniteTransitionKt.animateValue(InfiniteTransitionKt.rememberInfiniteTransition("", composerStartRestartGroup, 6, 0), 0, 3, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Reverse, 0L, 4, (Object) null), "", composerStartRestartGroup, InfiniteTransition.$stable | 197040 | (InfiniteRepeatableSpec.$stable << 12), 0);
                builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                builder.append(strStringResource);
                for (i5 = 0; i5 < 4; i5++) {
                    builder.append(" ");
                    if (i5 < EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$0(stateAnimateValue)) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    iPushStyle = builder.pushStyle(new SpanStyle(Color.copy-wmQWz5c$default(j4, f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null));
                    try {
                        builder.append(".");
                        Unit unit = Unit.INSTANCE;
                        builder.pop(iPushStyle);
                    } catch (Throwable th) {
                        builder.pop(iPushStyle);
                        throw th;
                    }
                }
                final AnnotatedString annotatedString = builder.toAnnotatedString();
                CardColors cardColors = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
                Shape small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall();
                CardElevation cardElevation = CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62);
                composerStartRestartGroup = composerStartRestartGroup;
                Modifier modifier5 = modifier4;
                CardKt.ElevatedCard(modifier5, small, cardColors, cardElevation, ComposableLambdaKt.rememberComposableLambda(143723144, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubbleKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return EllipsisAnimationTranscriptBubbleKt.EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$4(j5, annotatedString, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | 24576, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                j3 = j5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubbleKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        return EllipsisAnimationTranscriptBubbleKt.EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$5(modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        j2 = j;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
        } else {
            if (i6 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i7 != 0) {
                sp = TextUnitKt.getSp(16);
            } else {
                sp = j2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-336478515, i4, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubble (EllipsisAnimationTranscriptBubble.kt:38)");
            }
            CompositionLocal localContentColor2 = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            j4 = ((Color) objConsume2).unbox-impl();
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_bubble_msg_queue, composerStartRestartGroup, 0);
            final long j6 = sp;
            stateAnimateValue = InfiniteTransitionKt.animateValue(InfiniteTransitionKt.rememberInfiniteTransition("", composerStartRestartGroup, 6, 0), 0, 3, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(1000, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Reverse, 0L, 4, (Object) null), "", composerStartRestartGroup, InfiniteTransition.$stable | 197040 | (InfiniteRepeatableSpec.$stable << 12), 0);
            builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            builder.append(strStringResource2);
            while (i5 < 4) {
                builder.append(" ");
                if (i5 < EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$0(stateAnimateValue)) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                iPushStyle = builder.pushStyle(new SpanStyle(Color.copy-wmQWz5c$default(j4, f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null));
                builder.append(".");
                Unit unit2 = Unit.INSTANCE;
                builder.pop(iPushStyle);
            }
            final AnnotatedString annotatedString2 = builder.toAnnotatedString();
            CardColors cardColors2 = CardDefaults.INSTANCE.elevatedCardColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getTertiaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnTertiaryContainer-0d7_KjU(), 0L, 0L, composerStartRestartGroup, CardDefaults.$stable << 12, 12);
            Shape small2 = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, MaterialTheme.$stable).getSmall();
            CardElevation cardElevation2 = CardDefaults.INSTANCE.elevatedCardElevation-aqJV_2Y(Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (CardDefaults.$stable << 18) | 6, 62);
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier modifier6 = modifier4;
            CardKt.ElevatedCard(modifier6, small2, cardColors2, cardElevation2, ComposableLambdaKt.rememberComposableLambda(143723144, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubbleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EllipsisAnimationTranscriptBubbleKt.EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$4(j6, annotatedString2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i4 & 14) | 24576, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            j3 = j6;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubbleKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    return EllipsisAnimationTranscriptBubbleKt.EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$5(modifier3, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$4(long j, AnnotatedString annotatedString, ColumnScope columnScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(columnScope, "$this$ElevatedCard");
        ComposerKt.sourceInformation(composer, "C81@3023L211:EllipsisAnimationTranscriptBubble.kt#hsonup");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(143723144, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.EllipsisAnimationTranscriptBubble.<anonymous> (EllipsisAnimationTranscriptBubble.kt:81)");
            }
            TextKt.Text-Z58ophY(annotatedString, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(8)), 0L, (TextAutoSize) null, j, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(TextUnit.getValue-impl(j) * 1.4f), 0, false, 0, 0, (Map) null, (Function1) null, (TextStyle) null, composer, 48, 0, 522220);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final int EllipsisAnimationTranscriptBubble_KmRG4DE$lambda$0(State<Integer> state) {
        return ((Number) state.getValue()).intValue();
    }
}
