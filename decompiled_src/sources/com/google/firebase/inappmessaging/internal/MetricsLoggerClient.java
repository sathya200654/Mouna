package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CampaignAnalytics;
import com.google.firebase.inappmessaging.ClientAppInfo;
import com.google.firebase.inappmessaging.DismissType;
import com.google.firebase.inappmessaging.EventType;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.RenderErrorReason;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class MetricsLoggerClient {
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType, DismissType> dismissTransform;
    private static final Map<FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason, RenderErrorReason> errorTransform;
    private final AnalyticsConnector analyticsConnector;
    private final Executor blockingExecutor;
    private final Clock clock;
    private final DeveloperListenerManager developerListenerManager;
    private final EngagementMetricsLoggerInterface engagementMetricsLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;

    public interface EngagementMetricsLoggerInterface {
        void logEvent(byte[] bArr);
    }

    static {
        HashMap map = new HashMap();
        errorTransform = map;
        HashMap map2 = new HashMap();
        dismissTransform = map2;
        map.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR, RenderErrorReason.UNSPECIFIED_RENDER_ERROR);
        map.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_FETCH_ERROR, RenderErrorReason.IMAGE_FETCH_ERROR);
        map.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_DISPLAY_ERROR, RenderErrorReason.IMAGE_DISPLAY_ERROR);
        map.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT, RenderErrorReason.IMAGE_UNSUPPORTED_FORMAT);
        map2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO, DismissType.AUTO);
        map2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK, DismissType.CLICK);
        map2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.SWIPE, DismissType.SWIPE);
        map2.put(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE, DismissType.UNKNOWN_DISMISS_TYPE);
    }

    public MetricsLoggerClient(EngagementMetricsLoggerInterface engagementMetricsLoggerInterface, AnalyticsConnector analyticsConnector, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, Executor executor) {
        this.engagementMetricsLogger = engagementMetricsLoggerInterface;
        this.analyticsConnector = analyticsConnector;
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.clock = clock;
        this.developerListenerManager = developerListenerManager;
        this.blockingExecutor = executor;
    }

    void logImpression(final InAppMessage inAppMessage) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$$ExternalSyntheticLambda0
                public final void onSuccess(Object obj) {
                    this.f$0.m2030x30a26aed(inAppMessage, (String) obj);
                }
            });
            logEventAsync(inAppMessage, "fiam_impression", impressionCountsAsConversion(inAppMessage));
        }
        this.developerListenerManager.impressionDetected(inAppMessage);
    }

    /* JADX INFO: renamed from: lambda$logImpression$0$com-google-firebase-inappmessaging-internal-MetricsLoggerClient, reason: not valid java name */
    /* synthetic */ void m2030x30a26aed(InAppMessage inAppMessage, String str) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, str, EventType.IMPRESSION_EVENT_TYPE).toByteArray());
    }

    void logMessageClick(final InAppMessage inAppMessage, Action action) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$$ExternalSyntheticLambda2
                public final void onSuccess(Object obj) {
                    this.f$0.m2031x18a9bee6(inAppMessage, (String) obj);
                }
            });
            logEventAsync(inAppMessage, "fiam_action", true);
        }
        this.developerListenerManager.messageClicked(inAppMessage, action);
    }

    /* JADX INFO: renamed from: lambda$logMessageClick$1$com-google-firebase-inappmessaging-internal-MetricsLoggerClient, reason: not valid java name */
    /* synthetic */ void m2031x18a9bee6(InAppMessage inAppMessage, String str) {
        this.engagementMetricsLogger.logEvent(createEventEntry(inAppMessage, str, EventType.CLICK_EVENT_TYPE).toByteArray());
    }

    void logRenderError(final InAppMessage inAppMessage, final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$$ExternalSyntheticLambda1
                public final void onSuccess(Object obj) {
                    this.f$0.m2032x787e7c8a(inAppMessage, inAppMessagingErrorReason, (String) obj);
                }
            });
        }
        this.developerListenerManager.displayErrorEncountered(inAppMessage, inAppMessagingErrorReason);
    }

    /* JADX INFO: renamed from: lambda$logRenderError$2$com-google-firebase-inappmessaging-internal-MetricsLoggerClient, reason: not valid java name */
    /* synthetic */ void m2032x787e7c8a(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason inAppMessagingErrorReason, String str) {
        this.engagementMetricsLogger.logEvent(createRenderErrorEntry(inAppMessage, str, errorTransform.get(inAppMessagingErrorReason)).toByteArray());
    }

    void logDismiss(final InAppMessage inAppMessage, final FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType) {
        if (!isTestCampaign(inAppMessage)) {
            this.firebaseInstallations.getId().addOnSuccessListener(this.blockingExecutor, new OnSuccessListener() { // from class: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$$ExternalSyntheticLambda3
                public final void onSuccess(Object obj) {
                    this.f$0.m2029x85b8f83(inAppMessage, inAppMessagingDismissType, (String) obj);
                }
            });
            logEventAsync(inAppMessage, "fiam_dismiss", false);
        }
        this.developerListenerManager.messageDismissed(inAppMessage);
    }

    /* JADX INFO: renamed from: lambda$logDismiss$3$com-google-firebase-inappmessaging-internal-MetricsLoggerClient, reason: not valid java name */
    /* synthetic */ void m2029x85b8f83(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType inAppMessagingDismissType, String str) {
        this.engagementMetricsLogger.logEvent(createDismissEntry(inAppMessage, str, dismissTransform.get(inAppMessagingDismissType)).toByteArray());
    }

    private CampaignAnalytics createEventEntry(InAppMessage inAppMessage, String str, EventType eventType) {
        return createCampaignAnalyticsBuilder(inAppMessage, str).setEventType(eventType).build();
    }

    private CampaignAnalytics createDismissEntry(InAppMessage inAppMessage, String str, DismissType dismissType) {
        return createCampaignAnalyticsBuilder(inAppMessage, str).setDismissType(dismissType).build();
    }

    private CampaignAnalytics createRenderErrorEntry(InAppMessage inAppMessage, String str, RenderErrorReason renderErrorReason) {
        return createCampaignAnalyticsBuilder(inAppMessage, str).setRenderErrorReason(renderErrorReason).build();
    }

    private CampaignAnalytics.Builder createCampaignAnalyticsBuilder(InAppMessage inAppMessage, String str) {
        return CampaignAnalytics.newBuilder().setFiamSdkVersion("21.0.2").setProjectNumber(this.firebaseApp.getOptions().getGcmSenderId()).setCampaignId(inAppMessage.getCampaignMetadata().getCampaignId()).setClientApp(ClientAppInfo.newBuilder().setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setFirebaseInstanceId(str)).setClientTimestampMillis(this.clock.now());
    }

    private void logEventAsync(InAppMessage inAppMessage, String str, boolean z) {
        String campaignId = inAppMessage.getCampaignMetadata().getCampaignId();
        Bundle bundleCollectAnalyticsParams = collectAnalyticsParams(inAppMessage.getCampaignMetadata().getCampaignName(), campaignId);
        Logging.logd("Sending event=" + str + " params=" + bundleCollectAnalyticsParams);
        AnalyticsConnector analyticsConnector = this.analyticsConnector;
        if (analyticsConnector != null) {
            analyticsConnector.logEvent("fiam", str, bundleCollectAnalyticsParams);
            if (z) {
                this.analyticsConnector.setUserProperty("fiam", Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, "fiam:" + campaignId);
                return;
            }
            return;
        }
        Logging.logw("Unable to log event: analytics library is missing");
    }

    Bundle collectAnalyticsParams(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_nmid", str2);
        bundle.putString(Constants.ScionAnalytics.PARAM_MESSAGE_NAME, str);
        try {
            bundle.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_DEVICE_TIME, (int) (this.clock.now() / 1000));
            return bundle;
        } catch (NumberFormatException e) {
            Logging.logw("Error while parsing use_device_time in FIAM event: " + e.getMessage());
            return bundle;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.internal.MetricsLoggerClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = iArr;
            try {
                iArr[MessageType.CARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.IMAGE_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean impressionCountsAsConversion(InAppMessage inAppMessage) {
        boolean zIsValidAction;
        int i = AnonymousClass1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            return (isValidAction(cardMessage.getPrimaryAction()) || isValidAction(cardMessage.getSecondaryAction())) ? false : true;
        }
        if (i == 2) {
            zIsValidAction = isValidAction(((ModalMessage) inAppMessage).getAction());
        } else if (i == 3) {
            zIsValidAction = isValidAction(((BannerMessage) inAppMessage).getAction());
        } else if (i == 4) {
            zIsValidAction = isValidAction(((ImageOnlyMessage) inAppMessage).getAction());
        } else {
            Logging.loge("Unable to determine if impression should be counted as conversion.");
            return false;
        }
        return !zIsValidAction;
    }

    private boolean isTestCampaign(InAppMessage inAppMessage) {
        return inAppMessage.getCampaignMetadata().getIsTestMessage();
    }

    private boolean isValidAction(@Nullable Action action) {
        return (action == null || action.getActionUrl() == null || action.getActionUrl().isEmpty()) ? false : true;
    }
}
