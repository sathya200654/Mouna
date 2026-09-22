package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ErrorKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.media.MediaPlayerState;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: VideoNotificationPage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001am\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"VideoPlayer", "", "player", "Landroidx/media3/common/Player;", "mediaPlayerState", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/media3/common/Player;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VideoNotificationPage", "pageData", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "onLoadVideo", "Lkotlin/Function1;", "Landroidx/media3/common/MediaItem;", "onSubmitClick", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "onCancelClick", "(Landroidx/compose/ui/Modifier;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;Landroidx/media3/common/Player;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class VideoNotificationPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoNotificationPage$lambda$17(Modifier modifier, NotificationData notificationData, MediaPlayerState mediaPlayerState, Player player, Function1 function1, Function1 function2, Function1 function3, int i, int i2, Composer composer, int i3) {
        VideoNotificationPage(modifier, notificationData, mediaPlayerState, player, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoPlayer$lambda$4(Player player, MediaPlayerState mediaPlayerState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        VideoPlayer(player, mediaPlayerState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:52:0x013c  */
    /* JADX WARN: Code duplicated, block: B:53:0x017e  */
    /* JADX WARN: Code duplicated, block: B:66:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:69:0x020d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0211  */
    /* JADX WARN: Code duplicated, block: B:73:0x021b  */
    /* JADX WARN: Code duplicated, block: B:75:? A[RETURN, SYNTHETIC] */
    public static final void VideoPlayer(final Player player, final MediaPlayerState mediaPlayerState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        Function0 constructor;
        Intrinsics.checkNotNullParameter(mediaPlayerState, "mediaPlayerState");
        Composer composerStartRestartGroup = composer.startRestartGroup(2063158082);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VideoPlayer)P(2)47@2182L1153:VideoNotificationPage.kt#om2ogl");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(player) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(mediaPlayerState) : composerStartRestartGroup.changedInstance(mediaPlayerState) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2063158082, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoPlayer (VideoNotificationPage.kt:46)");
                }
                Modifier modifier5 = BackgroundKt.background-bw27NRU$default(modifier4, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
                modifier3 = modifier4;
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier5);
                constructor = ComposeUiNode.Companion.getConstructor();
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
                Updater.set-impl(composer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1881841890, "C:VideoNotificationPage.kt#om2ogl");
                if (mediaPlayerState.getError() != null) {
                    composerStartRestartGroup.startReplaceGroup(1881873509);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "54@2408L50,55@2501L65,53@2371L321");
                    ImageKt.Image(VectorPainterKt.rememberVectorPainter(ErrorKt.getError(Icons.INSTANCE.getDefault()), composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.notification_session_cd_video_not_loaded, composerStartRestartGroup, 0), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, composerStartRestartGroup, VectorPainter.$stable | 24960, 104);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (mediaPlayerState.getPlayerState() != 2 || (mediaPlayerState.getPlayerState() == 1 && !mediaPlayerState.isPlaying())) {
                    composerStartRestartGroup.startReplaceGroup(1882388171);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@2899L27");
                    ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 63);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1882476800);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@3022L210,65@2979L326");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 60726862, "CC(remember):VideoNotificationPage.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(player);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.Companion.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj) {
                                return VideoNotificationPageKt.VideoPlayer$lambda$3$lambda$2$lambda$1(player, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidView_androidKt.AndroidView((Function1) objRememberedValue, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Function1) null, composerStartRestartGroup, 48, 4);
                    composerStartRestartGroup.endReplaceGroup();
                }
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        return VideoNotificationPageKt.VideoPlayer$lambda$4(player, mediaPlayerState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & 147) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2063158082, i3, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoPlayer (VideoNotificationPage.kt:46)");
            }
            Modifier modifier6 = BackgroundKt.background-bw27NRU$default(modifier4, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null);
            modifier3 = modifier4;
            Alignment center2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier6);
            constructor = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl(composer3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1881841890, "C:VideoNotificationPage.kt#om2ogl");
            if (mediaPlayerState.getError() != null) {
                composerStartRestartGroup.startReplaceGroup(1881873509);
                ComposerKt.sourceInformation(composerStartRestartGroup, "54@2408L50,55@2501L65,53@2371L321");
                ImageKt.Image(VectorPainterKt.rememberVectorPainter(ErrorKt.getError(Icons.INSTANCE.getDefault()), composerStartRestartGroup, 0), StringResources_androidKt.stringResource(R.string.notification_session_cd_video_not_loaded, composerStartRestartGroup, 0), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, composerStartRestartGroup, VectorPainter.$stable | 24960, 104);
                composerStartRestartGroup.endReplaceGroup();
            } else if (mediaPlayerState.getPlayerState() != 2) {
                composerStartRestartGroup.startReplaceGroup(1882388171);
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@2899L27");
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 63);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1882388171);
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@2899L27");
                ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8((Modifier) null, 0L, 0.0f, 0L, 0, 0.0f, composerStartRestartGroup, 0, 63);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            }
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    return VideoNotificationPageKt.VideoPlayer$lambda$4(player, mediaPlayerState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerView VideoPlayer$lambda$3$lambda$2$lambda$1(Player player, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlayerView playerView = new PlayerView(context);
        playerView.setPlayer(player);
        playerView.setUseController(true);
        return playerView;
    }

    public static final void VideoNotificationPage(Modifier modifier, final NotificationData notificationData, final MediaPlayerState mediaPlayerState, final Player player, final Function1<? super MediaItem, Unit> function1, Function1<? super NotificationResponseType, Unit> function2, final Function1<? super NotificationResponseType, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Function1<? super NotificationResponseType, Unit> function4;
        final Modifier modifier3;
        Object obj;
        String str;
        int i4;
        Intrinsics.checkNotNullParameter(notificationData, "pageData");
        Intrinsics.checkNotNullParameter(mediaPlayerState, "mediaPlayerState");
        Intrinsics.checkNotNullParameter(function1, "onLoadVideo");
        Intrinsics.checkNotNullParameter(function2, "onSubmitClick");
        Intrinsics.checkNotNullParameter(function3, "onCancelClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(399538785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(VideoNotificationPage)P(1,5!1,6,3,4)89@3692L156,89@3661L187,97@3854L2276:VideoNotificationPage.kt#om2ogl");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
            i3 |= (i & 64) == 0 ? composerStartRestartGroup.changed(notificationData) : composerStartRestartGroup.changedInstance(notificationData) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(mediaPlayerState) : composerStartRestartGroup.changedInstance(mediaPlayerState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(player) ? RecyclerView.ItemAnimator.FLAG_MOVED : UserMetadata.MAX_ATTRIBUTE_SIZE;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : ArrayPool.STANDARD_BUFFER_SIZE_BYTES;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 1048576 : 524288;
        }
        int i6 = i3;
        if (!composerStartRestartGroup.shouldExecute((599187 & i6) != 599186, i6 & 1)) {
            function4 = function2;
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(399538785, i6, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPage (VideoNotificationPage.kt:88)");
            }
            String video = notificationData.getVideo();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1704694493, "CC(remember):VideoNotificationPage.kt#9igjgp");
            int i7 = i6 & 112;
            boolean z = (i7 == 32 || ((i6 & 64) != 0 && composerStartRestartGroup.changedInstance(notificationData))) | ((i6 & 57344) == 16384);
            VideoNotificationPageKt$VideoNotificationPage$1$1 videoNotificationPageKt$VideoNotificationPage$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || videoNotificationPageKt$VideoNotificationPage$1$1RememberedValue == Composer.Companion.getEmpty()) {
                videoNotificationPageKt$VideoNotificationPage$1$1RememberedValue = new VideoNotificationPageKt$VideoNotificationPage$1$1(notificationData, function1, null);
                composerStartRestartGroup.updateRememberedValue(videoNotificationPageKt$VideoNotificationPage$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(video, (Function2) videoNotificationPageKt$VideoNotificationPage$1$1RememberedValue, composerStartRestartGroup, 0);
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier4);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl(composer2, measurePolicyColumnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer2, Integer.valueOf(iHashCode), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer2, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1996097118, "C101@3966L1268,137@5244L880:VideoNotificationPage.kt#om2ogl");
            float f = 16;
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScope, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(f), 0.0f, 2, (Object) null), 1.0f, false, 2, (Object) null);
            Alignment.Horizontal centerHorizontally2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer3 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer3, Integer.valueOf(iHashCode2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer3, modifierMaterializeModifier2, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1804753846, "C107@4168L41,110@4309L10,111@4374L11,108@4222L328,119@4650L10,117@4564L218:VideoNotificationPage.kt#om2ogl");
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), composerStartRestartGroup, 6);
            float f2 = 4;
            TextKt.Text-Nvy7gAk(notificationData.getPageTitle(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getPrimary-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getHeadlineMedium(), composerStartRestartGroup, 1572912, 0, 129976);
            TextKt.Text-Nvy7gAk(notificationData.getPageBody(), PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f2)), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, 48, 0, 130044);
            String video2 = notificationData.getVideo();
            if (video2 == null || StringsKt.isBlank(video2)) {
                obj = null;
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.startReplaceGroup(1800585461);
            } else {
                composerStartRestartGroup.startReplaceGroup(1805392910);
                ComposerKt.sourceInformation(composerStartRestartGroup, "125@4851L41,126@4909L301");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), composerStartRestartGroup, 6);
                composerStartRestartGroup = composerStartRestartGroup;
                obj = null;
                VideoPlayer(player, mediaPlayerState, ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(250)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), composerStartRestartGroup, ((i6 >> 9) & 14) | (MediaPlayerState.$stable << 3) | ((i6 >> 3) & 112), 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(f)), 0.0f, 1, obj);
            Alignment.Horizontal centerHorizontally3 = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(vertical, centerHorizontally3, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            boolean z2 = false;
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composer4 = Updater.constructor-impl(composerStartRestartGroup);
            Updater.set-impl(composer4, measurePolicyColumnMeasurePolicy3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl(composer4, Integer.valueOf(iHashCode3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl(composer4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl(composer4, modifierMaterializeModifier3, ComposeUiNode.Companion.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -768577257, "C:VideoNotificationPage.kt#om2ogl");
            final NotificationResponseType primaryAction = notificationData.getPrimaryAction();
            if (primaryAction == null) {
                composerStartRestartGroup.startReplaceGroup(-768563216);
                composerStartRestartGroup.endReplaceGroup();
                function4 = function2;
                str = "CC(remember):VideoNotificationPage.kt#9igjgp";
                i4 = 32;
            } else {
                composerStartRestartGroup.startReplaceGroup(-768563215);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*146@5582L85,150@5742L67,145@5544L265");
                str = "CC(remember):VideoNotificationPage.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1038583760, str);
                i4 = 32;
                boolean z3 = (r37 == 32 || ((i6 & 64) != 0 && composerStartRestartGroup.changedInstance(notificationData))) | ((i6 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.Companion.getEmpty()) {
                    function4 = function2;
                    objRememberedValue = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            return VideoNotificationPageKt.VideoNotificationPage$lambda$16$lambda$15$lambda$10$lambda$8$lambda$7(function4, notificationData);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    function4 = function2;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.Button((Function0) objRememberedValue, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, obj), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1202298283, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoNotificationPageKt.VideoNotificationPage$lambda$16$lambda$15$lambda$10$lambda$9(primaryAction, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 508);
                Unit unit = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            final NotificationResponseType secondaryAction = notificationData.getSecondaryAction();
            if (secondaryAction == null) {
                composerStartRestartGroup.startReplaceGroup(-768226494);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-768226493);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*157@5927L87,160@6033L67,156@5885L215");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1928798569, str);
                boolean z4 = (i6 & 3670016) == 1048576;
                if (i7 == i4 || ((i6 & 64) != 0 && composerStartRestartGroup.changedInstance(notificationData))) {
                    z2 = true;
                }
                boolean z5 = z4 | z2;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z5 || objRememberedValue2 == Composer.Companion.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return VideoNotificationPageKt.VideoNotificationPage$lambda$16$lambda$15$lambda$14$lambda$12$lambda$11(function3, notificationData);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ButtonKt.TextButton((Function0) objRememberedValue2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(-523491979, true, new Function3() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return VideoNotificationPageKt.VideoNotificationPage$lambda$16$lambda$15$lambda$14$lambda$13(secondaryAction, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 510);
                Unit unit3 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function1<? super NotificationResponseType, Unit> function5 = function4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2, Object obj3) {
                    return VideoNotificationPageKt.VideoNotificationPage$lambda$17(modifier3, notificationData, mediaPlayerState, player, function1, function5, function3, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoNotificationPage$lambda$16$lambda$15$lambda$10$lambda$8$lambda$7(Function1 function1, NotificationData notificationData) {
        function1.invoke(notificationData.getPrimaryAction());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoNotificationPage$lambda$16$lambda$15$lambda$10$lambda$9(NotificationResponseType notificationResponseType, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$Button");
        ComposerKt.sourceInformation(composer, "C151@5764L27:VideoNotificationPage.kt#om2ogl");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1202298283, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoNotificationPage.kt:151)");
            }
            TextKt.Text-Nvy7gAk(notificationResponseType.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoNotificationPage$lambda$16$lambda$15$lambda$14$lambda$12$lambda$11(Function1 function1, NotificationData notificationData) {
        function1.invoke(notificationData.getSecondaryAction());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoNotificationPage$lambda$16$lambda$15$lambda$14$lambda$13(NotificationResponseType notificationResponseType, RowScope rowScope, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(rowScope, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C161@6055L27:VideoNotificationPage.kt#om2ogl");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-523491979, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.screens.VideoNotificationPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoNotificationPage.kt:161)");
            }
            TextKt.Text-Nvy7gAk(notificationResponseType.getDisplayText(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
