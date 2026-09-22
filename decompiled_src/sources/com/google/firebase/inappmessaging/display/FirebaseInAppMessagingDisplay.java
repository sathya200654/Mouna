package com.google.firebase.inappmessaging.display;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.webkit.ProxyConfig;
import com.google.common.primitives.Ints;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class FirebaseInAppMessagingDisplay extends FirebaseInAppMessagingDisplayImpl {
    static final long DISMISS_THRESHOLD_MILLIS = 20000;
    static final long IMPRESSION_THRESHOLD_MILLIS = 5000;
    static final long INTERVAL_MILLIS = 1000;
    private final FiamAnimator animator;
    private final Application application;
    private final RenewableTimer autoDismissTimer;
    private final BindingWrapperFactory bindingWrapperFactory;
    private FirebaseInAppMessagingDisplayCallbacks callbacks;
    String currentlyBoundActivityName;
    private FiamListener fiamListener;
    private final FirebaseInAppMessaging headlessInAppMessaging;
    private final FiamImageLoader imageLoader;
    private final RenewableTimer impressionTimer;
    private InAppMessage inAppMessage;
    private final Map<String, Provider<InAppMessageLayoutConfig>> layoutConfigs;
    private final FiamWindowManager windowManager;

    @Inject
    FirebaseInAppMessagingDisplay(FirebaseInAppMessaging firebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> map, FiamImageLoader fiamImageLoader, RenewableTimer renewableTimer, RenewableTimer renewableTimer2, FiamWindowManager fiamWindowManager, Application application, BindingWrapperFactory bindingWrapperFactory, FiamAnimator fiamAnimator) {
        this.headlessInAppMessaging = firebaseInAppMessaging;
        this.layoutConfigs = map;
        this.imageLoader = fiamImageLoader;
        this.impressionTimer = renewableTimer;
        this.autoDismissTimer = renewableTimer2;
        this.windowManager = fiamWindowManager;
        this.application = application;
        this.bindingWrapperFactory = bindingWrapperFactory;
        this.animator = fiamAnimator;
    }

    public static FirebaseInAppMessagingDisplay getInstance() {
        return (FirebaseInAppMessagingDisplay) FirebaseApp.getInstance().get(FirebaseInAppMessagingDisplay.class);
    }

    private static int getScreenOrientation(Application application) {
        return application.getResources().getConfiguration().orientation;
    }

    public void testMessage(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        setInAppMessageAndCallbacks(inAppMessage, firebaseInAppMessagingDisplayCallbacks);
        showActiveFiam(activity);
    }

    private void setInAppMessageAndCallbacks(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.callbacks = firebaseInAppMessagingDisplayCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearInAppMessageAndCallbacks() {
        setInAppMessageAndCallbacks(null, null);
    }

    public void setFiamListener(FiamListener fiamListener) {
        this.fiamListener = fiamListener;
    }

    public void clearFiamListener() {
        this.fiamListener = null;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
        bindFiamToActivity(activity);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.FirebaseInAppMessagingDisplayImpl, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        unbindFiamFromActivity(activity);
        this.headlessInAppMessaging.removeAllListeners();
        super.onActivityPaused(activity);
    }

    private void bindFiamToActivity(final Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            Logging.logi("Binding to activity: " + activity.getLocalClassName());
            this.headlessInAppMessaging.setMessageDisplayComponent(new com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$$ExternalSyntheticLambda0
                @Override // com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplay
                public final void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
                    this.f$0.m1959x536ea386(activity, inAppMessage, firebaseInAppMessagingDisplayCallbacks);
                }
            });
            this.currentlyBoundActivityName = activity.getLocalClassName();
        }
        if (this.inAppMessage != null) {
            showActiveFiam(activity);
        }
    }

    /* JADX INFO: renamed from: lambda$bindFiamToActivity$0$com-google-firebase-inappmessaging-display-FirebaseInAppMessagingDisplay, reason: not valid java name */
    /* synthetic */ void m1959x536ea386(Activity activity, InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        if (this.inAppMessage != null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.logd("Active FIAM exists. Skipping trigger");
        } else {
            setInAppMessageAndCallbacks(inAppMessage, firebaseInAppMessagingDisplayCallbacks);
            showActiveFiam(activity);
        }
    }

    private void unbindFiamFromActivity(Activity activity) {
        String str = this.currentlyBoundActivityName;
        if (str == null || !str.equals(activity.getLocalClassName())) {
            return;
        }
        Logging.logi("Unbinding from activity: " + activity.getLocalClassName());
        this.headlessInAppMessaging.clearDisplayListener();
        removeDisplayedFiam(activity);
        this.currentlyBoundActivityName = null;
    }

    InAppMessage getCurrentInAppMessage() {
        return this.inAppMessage;
    }

    private void showActiveFiam(final Activity activity) {
        final BindingWrapper bindingWrapperCreateBannerBindingWrapper;
        if (this.inAppMessage == null || this.headlessInAppMessaging.areMessagesSuppressed()) {
            Logging.loge("No active message found to render");
            return;
        }
        if (this.inAppMessage.getMessageType().equals(MessageType.UNSUPPORTED)) {
            Logging.loge("The message being triggered is not supported by this version of the sdk.");
            return;
        }
        notifyFiamTrigger();
        InAppMessageLayoutConfig inAppMessageLayoutConfig = (InAppMessageLayoutConfig) this.layoutConfigs.get(InflaterConfigModule.configFor(this.inAppMessage.getMessageType(), getScreenOrientation(this.application))).get();
        int i = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[this.inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createBannerBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i == 2) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createModalBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i == 3) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createImageBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else if (i == 4) {
            bindingWrapperCreateBannerBindingWrapper = this.bindingWrapperFactory.createCardBindingWrapper(inAppMessageLayoutConfig, this.inAppMessage);
        } else {
            Logging.loge("No bindings found for this message type");
            return;
        }
        activity.findViewById(android.R.id.content).post(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.1
            @Override // java.lang.Runnable
            public void run() {
                FirebaseInAppMessagingDisplay.this.inflateBinding(activity, bindingWrapperCreateBannerBindingWrapper);
            }
        });
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$inappmessaging$model$MessageType;

        static {
            int[] iArr = new int[MessageType.values().length];
            $SwitchMap$com$google$firebase$inappmessaging$model$MessageType = iArr;
            try {
                iArr[MessageType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.MODAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.IMAGE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$inappmessaging$model$MessageType[MessageType.CARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void inflateBinding(final Activity activity, final BindingWrapper bindingWrapper) {
        View.OnClickListener onClickListener;
        if (this.inAppMessage == null) {
            return;
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                    FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.CLICK);
                }
                FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
            }
        };
        HashMap map = new HashMap();
        for (final Action action : extractActions(this.inAppMessage)) {
            if (action != null && !TextUtils.isEmpty(action.getActionUrl())) {
                onClickListener = new View.OnClickListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                            Logging.logi("Calling callback for click action");
                            FirebaseInAppMessagingDisplay.this.callbacks.messageClicked(action);
                        }
                        FirebaseInAppMessagingDisplay.this.launchUriIntent(activity, Uri.parse(action.getActionUrl()));
                        FirebaseInAppMessagingDisplay.this.notifyFiamClick();
                        FirebaseInAppMessagingDisplay.this.removeDisplayedFiam(activity);
                        FirebaseInAppMessagingDisplay.this.clearInAppMessageAndCallbacks();
                    }
                };
            } else {
                Logging.logi("No action url found for action. Treating as dismiss.");
                onClickListener = onClickListener2;
            }
            map.put(action, onClickListener);
        }
        final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListenerInflate = bindingWrapper.inflate(map, onClickListener2);
        if (onGlobalLayoutListenerInflate != null) {
            bindingWrapper.getImageView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListenerInflate);
        }
        loadNullableImage(activity, bindingWrapper, extractImageData(this.inAppMessage), new FiamImageLoader.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4
            @Override // com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback
            public void onSuccess() {
                if (!bindingWrapper.getConfig().backgroundEnabled().booleanValue()) {
                    bindingWrapper.getRootView().setOnTouchListener(new View.OnTouchListener() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 4) {
                                return false;
                            }
                            if (FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.UNKNOWN_DISMISS_TYPE);
                            }
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                            return true;
                        }
                    });
                }
                FirebaseInAppMessagingDisplay.this.impressionTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.2
                    @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                    public void onFinish() {
                        if (FirebaseInAppMessagingDisplay.this.inAppMessage == null || FirebaseInAppMessagingDisplay.this.callbacks == null) {
                            return;
                        }
                        Logging.logi("Impression timer onFinish for: " + FirebaseInAppMessagingDisplay.this.inAppMessage.getCampaignMetadata().getCampaignId());
                        FirebaseInAppMessagingDisplay.this.callbacks.impressionDetected();
                    }
                }, FirebaseInAppMessagingDisplay.IMPRESSION_THRESHOLD_MILLIS, 1000L);
                if (bindingWrapper.getConfig().autoDismiss().booleanValue()) {
                    FirebaseInAppMessagingDisplay.this.autoDismissTimer.start(new RenewableTimer.Callback() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.3
                        @Override // com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback
                        public void onFinish() {
                            if (FirebaseInAppMessagingDisplay.this.inAppMessage != null && FirebaseInAppMessagingDisplay.this.callbacks != null) {
                                FirebaseInAppMessagingDisplay.this.callbacks.messageDismissed(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingDismissType.AUTO);
                            }
                            FirebaseInAppMessagingDisplay.this.dismissFiam(activity);
                        }
                    }, FirebaseInAppMessagingDisplay.DISMISS_THRESHOLD_MILLIS, 1000L);
                }
                activity.runOnUiThread(new Runnable() { // from class: com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay.4.4
                    @Override // java.lang.Runnable
                    public void run() {
                        FirebaseInAppMessagingDisplay.this.windowManager.show(bindingWrapper, activity);
                        if (bindingWrapper.getConfig().animate().booleanValue()) {
                            FirebaseInAppMessagingDisplay.this.animator.slideIntoView(FirebaseInAppMessagingDisplay.this.application, bindingWrapper.getRootView(), FiamAnimator.Position.TOP);
                        }
                    }
                });
            }

            @Override // com.google.firebase.inappmessaging.display.internal.FiamImageLoader.Callback
            public void onError(Exception exc) {
                Logging.loge("Image download failure ");
                if (onGlobalLayoutListenerInflate != null) {
                    bindingWrapper.getImageView().getViewTreeObserver().removeGlobalOnLayoutListener(onGlobalLayoutListenerInflate);
                }
                FirebaseInAppMessagingDisplay.this.cancelTimers();
                FirebaseInAppMessagingDisplay.this.clearInAppMessageAndCallbacks();
            }
        });
    }

    private List<Action> extractActions(InAppMessage inAppMessage) {
        ArrayList arrayList = new ArrayList();
        int i = AnonymousClass5.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[inAppMessage.getMessageType().ordinal()];
        if (i == 1) {
            arrayList.add(((BannerMessage) inAppMessage).getAction());
            return arrayList;
        }
        if (i == 2) {
            arrayList.add(((ModalMessage) inAppMessage).getAction());
            return arrayList;
        }
        if (i == 3) {
            arrayList.add(((ImageOnlyMessage) inAppMessage).getAction());
            return arrayList;
        }
        if (i == 4) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            arrayList.add(cardMessage.getPrimaryAction());
            arrayList.add(cardMessage.getSecondaryAction());
            return arrayList;
        }
        arrayList.add(Action.builder().build());
        return arrayList;
    }

    private ImageData extractImageData(InAppMessage inAppMessage) {
        if (inAppMessage.getMessageType() == MessageType.CARD) {
            CardMessage cardMessage = (CardMessage) inAppMessage;
            ImageData portraitImageData = cardMessage.getPortraitImageData();
            ImageData landscapeImageData = cardMessage.getLandscapeImageData();
            return (getScreenOrientation(this.application) != 1 ? !isValidImageData(landscapeImageData) : isValidImageData(portraitImageData)) ? portraitImageData : landscapeImageData;
        }
        return inAppMessage.getImageData();
    }

    private boolean isValidImageData(ImageData imageData) {
        return (imageData == null || TextUtils.isEmpty(imageData.getImageUrl())) ? false : true;
    }

    private void loadNullableImage(Activity activity, BindingWrapper bindingWrapper, ImageData imageData, FiamImageLoader.Callback callback) {
        if (isValidImageData(imageData)) {
            this.imageLoader.load(imageData.getImageUrl()).addErrorListener(new GlideErrorListener(this.inAppMessage, this.callbacks)).tag(activity.getClass()).placeholder(R.drawable.image_placeholder).into(bindingWrapper.getImageView(), callback);
        } else {
            callback.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissFiam(Activity activity) {
        Logging.logd("Dismissing fiam");
        notifyFiamDismiss();
        removeDisplayedFiam(activity);
        clearInAppMessageAndCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDisplayedFiam(Activity activity) {
        if (this.windowManager.isFiamDisplayed()) {
            this.imageLoader.cancelTag(activity.getClass());
            this.windowManager.destroy(activity);
            cancelTimers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTimers() {
        this.impressionTimer.cancel();
        this.autoDismissTimer.cancel();
    }

    private void notifyFiamTrigger() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamTrigger();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFiamClick() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamClick();
        }
    }

    private void notifyFiamDismiss() {
        FiamListener fiamListener = this.fiamListener;
        if (fiamListener != null) {
            fiamListener.onFiamDismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchUriIntent(Activity activity, Uri uri) {
        if (ishttpOrHttpsUri(uri) && supportsCustomTabs(activity)) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            Intent intent = customTabsIntentBuild.intent;
            intent.addFlags(Ints.MAX_POWER_OF_TWO);
            intent.addFlags(268435456);
            customTabsIntentBuild.launchUrl(activity, uri);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", uri);
        ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent2, 0);
        intent2.addFlags(Ints.MAX_POWER_OF_TWO);
        intent2.addFlags(268435456);
        if (resolveInfoResolveActivity != null) {
            activity.startActivity(intent2);
        } else {
            Logging.loge("Device cannot resolve intent for: android.intent.action.VIEW");
        }
    }

    private boolean supportsCustomTabs(Activity activity) {
        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
        intent.setPackage("com.android.chrome");
        List<ResolveInfo> listQueryIntentServices = activity.getPackageManager().queryIntentServices(intent, 0);
        return (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) ? false : true;
    }

    private boolean ishttpOrHttpsUri(Uri uri) {
        String scheme;
        if (uri == null || (scheme = uri.getScheme()) == null) {
            return false;
        }
        return scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTP) || scheme.equalsIgnoreCase(ProxyConfig.MATCH_HTTPS);
    }
}
