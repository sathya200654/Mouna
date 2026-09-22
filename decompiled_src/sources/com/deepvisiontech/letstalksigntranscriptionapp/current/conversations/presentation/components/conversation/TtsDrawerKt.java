package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.VolumeUpKt;
import androidx.compose.material.icons.filled.TextFieldsKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TtsDrawer.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\u001aQ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"TtsDrawer", "", "modifier", "Landroidx/compose/ui/Modifier;", "ttsText", "", "ttsLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "startInterpretation", "Lkotlin/Function0;", "repeatTtsText", "onClose", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_release", "fontSize", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TtsDrawerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$43(Modifier modifier, String str, LanguageEnum languageEnum, Function0 function0, Function0 function1, Function0 function2, int i, int i2, Composer composer, int i3) {
        TtsDrawer(modifier, str, languageEnum, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TtsDrawer(Modifier modifier, final String str, final LanguageEnum languageEnum, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(str, "ttsText");
        Intrinsics.checkNotNullParameter(languageEnum, "ttsLanguage");
        Intrinsics.checkNotNullParameter(function0, "startInterpretation");
        Intrinsics.checkNotNullParameter(function1, "repeatTtsText");
        Intrinsics.checkNotNullParameter(function2, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(425622510);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TtsDrawer)P(!1,5,4,3,2)62@2721L37,63@2790L7,64@2821L76,65@2918L71,66@3014L87,68@3124L72,69@3216L75,71@3316L56,72@3398L57,74@3487L714,74@3461L740,97@4315L7265,94@4207L7373:TtsDrawer.kt#hsonup");
        int i4 = i2 & 1;
        if (i4 != 0) {
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
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if (!composerStartRestartGroup.shouldExecute((74771 & i3) != 74770, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(425622510, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawer (TtsDrawer.kt:61)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001346419, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(40.0f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001349658, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                Object systemService = context.getSystemService("audio");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
                objRememberedValue2 = (AudioManager) systemService;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final AudioManager audioManager = (AudioManager) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001352757, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = Integer.valueOf(audioManager.getStreamMaxVolume(3));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final int iIntValue = ((Number) objRememberedValue3).intValue();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001355845, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(audioManager.getStreamVolume(3));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Modifier modifier5 = modifier4;
            final String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_tts_cd_font_size, new Object[]{Integer.valueOf((int) TtsDrawer$lambda$1(mutableFloatState))}, composerStartRestartGroup, 0);
            final String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_tts_cd_volume, new Object[]{Integer.valueOf(mutableIntState.getIntValue())}, composerStartRestartGroup, 0);
            final String strStringResource3 = StringResources_androidKt.stringResource(R.string.conversation_settings_font_desc, composerStartRestartGroup, 0);
            final String strStringResource4 = StringResources_androidKt.stringResource(R.string.conversation_settings_voice_desc, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1001371608, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(audioManager) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$8$lambda$7(context, audioManager, mutableIntState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(context, (Function1) objRememberedValue5, composerStartRestartGroup, 0);
            float f = 0;
            float f2 = 32;
            composer2 = composerStartRestartGroup;
            SurfaceKt.Surface-T9BRK9s((Modifier) null, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(f), Dp.constructor-impl(f), Dp.constructor-impl(f2), Dp.constructor-impl(f2)), 0L, 0L, Dp.constructor-impl(12), 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1605892685, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return TtsDrawerKt.TtsDrawer$lambda$42(modifier5, strStringResource3, strStringResource, mutableFloatState, iIntValue, mutableIntState, strStringResource4, strStringResource2, audioManager, function1, function0, str, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 12607488, 109);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    return TtsDrawerKt.TtsDrawer$lambda$43(modifier3, str, languageEnum, function0, function1, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float TtsDrawer$lambda$1(MutableFloatState mutableFloatState) {
        return ((FloatState) mutableFloatState).getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$TtsDrawer$1$1$volumeReceiver$1] */
    public static final DisposableEffectResult TtsDrawer$lambda$8$lambda$7(final Context context, final AudioManager audioManager, final MutableIntState mutableIntState, DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final ?? r4 = new BroadcastReceiver() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$TtsDrawer$1$1$volumeReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                int streamVolume;
                if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.media.VOLUME_CHANGED_ACTION") || mutableIntState.getIntValue() == (streamVolume = audioManager.getStreamVolume(3))) {
                    return;
                }
                mutableIntState.setIntValue(streamVolume);
            }
        };
        context.registerReceiver((BroadcastReceiver) r4, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        return new DisposableEffectResult() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$TtsDrawer$lambda$8$lambda$7$$inlined$onDispose$1
            public void dispose() {
                context.unregisterReceiver(r4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$15$lambda$12$lambda$11(MutableFloatState mutableFloatState, float f) {
        mutableFloatState.setFloatValue(64.0f - f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$15$lambda$10$lambda$9(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$15$lambda$14$lambda$13(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleX(-1.0f);
        graphicsLayerScope.setScaleY(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$22$lambda$19$lambda$18(MutableIntState mutableIntState, int i, AudioManager audioManager, float f) {
        mutableIntState.setIntValue(i - ((int) f));
        audioManager.setStreamVolume(3, mutableIntState.getIntValue(), 4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$22$lambda$17$lambda$16(String str, String str2, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$22$lambda$21$lambda$20(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleX(-1.0f);
        graphicsLayerScope.setScaleY(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$28$lambda$27$lambda$26(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$28$lambda$25$lambda$24(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleX(-1.0f);
        graphicsLayerScope.setScaleY(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$32$lambda$31(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$30$lambda$29(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleY(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$36$lambda$35$lambda$34(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setScaleX(-1.0f);
        graphicsLayerScope.setScaleY(-1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TtsDrawer$lambda$42(Modifier modifier, final String str, final String str2, final MutableFloatState mutableFloatState, final int i, final MutableIntState mutableIntState, final String str3, final String str4, final AudioManager audioManager, final Function0 function0, final Function0 function1, String str5, final Function0 function2, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C98@4325L7249:TtsDrawer.kt#hsonup");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1605892685, i2, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawer.<anonymous> (TtsDrawer.kt:98)");
            }
            Modifier modifier2 = PaddingKt.padding-3ABfNKs(modifier, Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier2);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 754987010, "C101@4404L4206,181@8624L2643,236@11280L284:TtsDrawer.kt#hsonup");
            Modifier modifier3 = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifier3);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composer);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -710966173, "C105@4531L1808,140@6391L2205:TtsDrawer.kt#hsonup");
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composer);
            Updater.set-impl(composer4, measurePolicyRowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -327058352, "C116@5088L11,117@5202L11,118@5308L11,119@5389L11,120@5502L11,115@5019L556,124@5700L159,112@4865L23,110@4769L1112,131@6017L11,132@6083L56,135@6269L30,129@5902L419:TtsDrawer.kt#hsonup");
            float fTtsDrawer$lambda$1 = 64.0f - TtsDrawer$lambda$1(mutableFloatState);
            ClosedFloatingPointRange closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 48.0f);
            SliderColors sliderColors = SliderDefaults.INSTANCE.colors-q0g_0yA(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, 0L, 0L, composer, 0, 6, 992);
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 543667458, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChanged = composer.changed(str) | composer.changed(str2);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$15$lambda$10$lambda$9(str, str2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierWeight$default, false, (Function1) objRememberedValue, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 543640602, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.Companion.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$15$lambda$12$lambda$11(mutableFloatState, ((Float) obj).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SliderKt.Slider(fTtsDrawer$lambda$1, (Function1) objRememberedValue2, modifierSemantics$default, false, closedFloatingPointRangeRangeTo, 5, (Function0) null, sliderColors, (MutableInteractionSource) null, composer, 196656, 328);
            ImageVector textFields = TextFieldsKt.getTextFields(Icons.INSTANCE.getDefault());
            long j = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
            String strStringResource = StringResources_androidKt.stringResource(R.string.conversation_tts_cd_change_font, composer, 0);
            float f = 24;
            Modifier modifier4 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 543685537, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.Companion.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$15$lambda$14$lambda$13((GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconKt.Icon-ww6aTOc(textFields, strStringResource, GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) objRememberedValue3), j, composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composer5 = Updater.constructor-impl(composer);
            Updater.set-impl(composer5, measurePolicyRowMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer5, currentCompositionLocalMap4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer5, Integer.valueOf(iHashCode4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer5, modifierMaterializeModifier4, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 90063500, "C157@7333L11,158@7447L11,159@7553L11,160@7634L11,161@7747L11,156@7264L556,165@7945L159,147@6765L387,145@6629L1497,172@8272L11,173@8338L58,176@8526L30,170@8147L431:TtsDrawer.kt#hsonup");
            float f2 = i;
            float intValue = f2 - mutableIntState.getIntValue();
            ClosedFloatingPointRange closedFloatingPointRangeRangeTo2 = RangesKt.rangeTo(0.0f, f2);
            SliderColors sliderColors2 = SliderDefaults.INSTANCE.colors-q0g_0yA(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, 0L, 0L, composer, 0, 6, 992);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScope2, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 972776921, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChanged2 = composer.changed(str3) | composer.changed(str4);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.Companion.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$22$lambda$17$lambda$16(str3, str4, (SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierWeight$default2, false, (Function1) objRememberedValue4, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 972739389, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(audioManager);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == Composer.Companion.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$22$lambda$19$lambda$18(mutableIntState, i, audioManager, ((Float) obj).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SliderKt.Slider(intValue, (Function1) objRememberedValue5, modifierSemantics$default2, false, closedFloatingPointRangeRangeTo2, 0, (Function0) null, sliderColors2, (MutableInteractionSource) null, composer, 0, 360);
            ImageVector volumeUp = VolumeUpKt.getVolumeUp(Icons.AutoMirrored.Filled.INSTANCE);
            long j2 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.conversation_tts_cd_change_volume, composer, 0);
            Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 972795384, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.Companion.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$23$lambda$22$lambda$21$lambda$20((GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconKt.Icon-ww6aTOc(volumeUp, strStringResource2, GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) objRememberedValue6), j2, composer, 384, 0);
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
            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default3);
            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor5);
            } else {
                composer.useNode();
            }
            Composer composer6 = Updater.constructor-impl(composer);
            Updater.set-impl(composer6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer6, currentCompositionLocalMap5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer6, Integer.valueOf(iHashCode5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer6, modifierMaterializeModifier5, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1818439357, "C184@8715L1761,223@10755L21,218@10493L760:TtsDrawer.kt#hsonup");
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal spaceBetween3 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(spaceBetween3, centerVertically3, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default4);
            Function0 constructor6 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor6);
            } else {
                composer.useNode();
            }
            Composer composer7 = Updater.constructor-impl(composer);
            Updater.set-impl(composer7, measurePolicyRowMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer7, currentCompositionLocalMap6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer7, Integer.valueOf(iHashCode6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer7, modifierMaterializeModifier6, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2143914808, "C189@8953L802,207@9970L11,208@10061L11,206@9895L220,210@10175L16,205@9822L19,204@9776L682:TtsDrawer.kt#hsonup");
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier6 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composer, modifier6);
            Function0 constructor7 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor7);
            } else {
                composer.useNode();
            }
            Composer composer8 = Updater.constructor-impl(composer);
            Updater.set-impl(composer8, measurePolicyRowMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer8, currentCompositionLocalMap7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer8, Integer.valueOf(iHashCode7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer8, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer8, modifierMaterializeModifier7, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope4 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1698081015, "C193@9195L11,194@9290L11,192@9116L232,196@9412L30,191@9033L25,190@8983L750:TtsDrawer.kt#hsonup");
            IconButtonColors iconButtonColors = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer, IconButtonDefaults.$stable << 12, 12);
            Modifier modifier7 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 1301715804, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue7 = composer.rememberedValue();
            if (objRememberedValue7 == Composer.Companion.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$28$lambda$25$lambda$24((GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier7, (Function1) objRememberedValue7);
            ComposerKt.sourceInformationMarkerStart(composer, 1301703671, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChanged3 = composer.changed(function1);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue8 == Composer.Companion.getEmpty()) {
                objRememberedValue8 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$28$lambda$27$lambda$26(function1);
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue8, modifierGraphicsLayer, false, iconButtonColors, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$TtsDrawerKt.INSTANCE.m1552getLambda$50124036$app_release(), composer, 1572912, 52);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonColors iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors-ro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimaryContainer-0d7_KjU(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnPrimaryContainer-0d7_KjU(), 0L, 0L, composer, IconButtonDefaults.$stable << 12, 12);
            Modifier modifier8 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart(composer, 1316352394, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue9 = composer.rememberedValue();
            if (objRememberedValue9 == Composer.Companion.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$30$lambda$29((GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierGraphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifier8, (Function1) objRememberedValue9);
            ComposerKt.sourceInformationMarkerStart(composer, 1316341101, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChanged4 = composer.changed(function0);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue10 == Composer.Companion.getEmpty()) {
                objRememberedValue10 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$33$lambda$32$lambda$31(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue10, modifierGraphicsLayer2, false, iconButtonColors2, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$TtsDrawerKt.INSTANCE.m1551getLambda$1565165032$app_release(), composer, 1572912, 52);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(160)), ScrollKt.rememberScrollState(0, composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(bottom, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            Function0 constructor8 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor8);
            } else {
                composer.useNode();
            }
            Composer composer9 = Updater.constructor-impl(composer);
            Updater.set-impl(composer9, measurePolicyColumnMeasurePolicy4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer9, currentCompositionLocalMap8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer9, Integer.valueOf(iHashCode8), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer9, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer9, modifierMaterializeModifier8, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -180113226, "C228@10977L11,232@11183L30,225@10818L417:TtsDrawer.kt#hsonup");
            TextStyle textStyle = new TextStyle(0L, TextUnitKt.getSp(TtsDrawer$lambda$1(mutableFloatState)), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (DefaultConstructorMarker) null);
            long j3 = MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
            int i3 = TextAlign.Companion.getCenter-e0LSkKk();
            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composer, 1241127178, "CC(remember):TtsDrawer.kt#9igjgp");
            Object objRememberedValue11 = composer.rememberedValue();
            if (objRememberedValue11 == Composer.Companion.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$37$lambda$36$lambda$35$lambda$34((GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.Text-Nvy7gAk(str5, GraphicsLayerModifierKt.graphicsLayer(modifierFillMaxWidth$default5, (Function1) objRememberedValue11), j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i3), 0L, 0, false, 0, 0, (Function1) null, textStyle, composer, 48, 0, 130040);
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
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier9 = Modifier.Companion;
            MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap9 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composer, modifier9);
            Function0 constructor9 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor9);
            } else {
                composer.useNode();
            }
            Composer composer10 = Updater.constructor-impl(composer);
            Updater.set-impl(composer10, measurePolicyRowMeasurePolicy5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer10, currentCompositionLocalMap9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer10, Integer.valueOf(iHashCode9), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer10, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer10, modifierMaterializeModifier9, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope5 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1846003554, "C237@11323L13,237@11302L248:TtsDrawer.kt#hsonup");
            ComposerKt.sourceInformationMarkerStart(composer, -1306474054, "CC(remember):TtsDrawer.kt#9igjgp");
            boolean zChanged5 = composer.changed(function2);
            Object objRememberedValue12 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue12 == Composer.Companion.getEmpty()) {
                objRememberedValue12 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.presentation.components.conversation.TtsDrawerKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        return TtsDrawerKt.TtsDrawer$lambda$42$lambda$41$lambda$40$lambda$39$lambda$38(function2);
                    }
                };
                composer.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0) objRememberedValue12, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$TtsDrawerKt.INSTANCE.getLambda$1983284267$app_release(), composer, 1572864, 62);
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
