package com.deepvisiontech.letstalksigntranscriptionapp.current;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.data.services.AnalyticsManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.analytics.domain.constants.AnalyticsEvent;
import com.deepvisiontech.letstalksigntranscriptionapp.current.app.presentation.screen.AppScreenKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.notificationintent.domain.repository.NotificationIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.shareintent.domain.ShareIntentManager;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.utils.inAppMessaging.InAppMessageListener;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.manager.WebViewManager;
import com.deepvisiontech.letstalksigntranscriptionapp.legacy.ui.theme.ThemeKt;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.ktx.MessagingKt;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010%\u001a\u00020&H\u0014J\b\u0010'\u001a\u00020&H\u0014J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J\u0012\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u00020&2\u0006\u0010)\u001a\u00020*H\u0002J\b\u00101\u001a\u00020&H\u0014J\b\u00102\u001a\u00020&H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082.¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "analyticsManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "getAnalyticsManager", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;", "setAnalyticsManager", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/analytics/data/services/AnalyticsManager;)V", "webViewManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "getWebViewManager", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;", "setWebViewManager", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/manager/WebViewManager;)V", "shareIntentManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;", "getShareIntentManager", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;", "setShareIntentManager", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/shareintent/domain/ShareIntentManager;)V", "notificationIntentManager", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/domain/repository/NotificationIntentManager;", "getNotificationIntentManager", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/domain/repository/NotificationIntentManager;", "setNotificationIntentManager", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/notificationintent/domain/repository/NotificationIntentManager;)V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "getAppUpdateManager", "()Lcom/google/android/play/core/appupdate/AppUpdateManager;", "appUpdateManager$delegate", "Lkotlin/Lazy;", "updateActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "onPause", "", "onResume", "onNewIntent", "intent", "Landroid/content/Intent;", "checkForUpdate", "subscribeToFirebaseTopics", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "handleIntent", "onDestroy", "appContent", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class MainActivity extends Hilt_MainActivity {
    public static final int $stable = 8;

    @Inject
    public AnalyticsManager analyticsManager;

    /* JADX INFO: renamed from: appUpdateManager$delegate, reason: from kotlin metadata */
    private final Lazy appUpdateManager = LazyKt.lazy(new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda4
        public final Object invoke() {
            return MainActivity.appUpdateManager_delegate$lambda$0(this.f$0);
        }
    });

    @Inject
    public NotificationIntentManager notificationIntentManager;

    @Inject
    public ShareIntentManager shareIntentManager;
    private ActivityResultLauncher<IntentSenderRequest> updateActivityResultLauncher;

    @Inject
    public WebViewManager webViewManager;

    public final AnalyticsManager getAnalyticsManager() {
        AnalyticsManager analyticsManager = this.analyticsManager;
        if (analyticsManager != null) {
            return analyticsManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("analyticsManager");
        return null;
    }

    public final void setAnalyticsManager(AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(analyticsManager, "<set-?>");
        this.analyticsManager = analyticsManager;
    }

    public final WebViewManager getWebViewManager() {
        WebViewManager webViewManager = this.webViewManager;
        if (webViewManager != null) {
            return webViewManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webViewManager");
        return null;
    }

    public final void setWebViewManager(WebViewManager webViewManager) {
        Intrinsics.checkNotNullParameter(webViewManager, "<set-?>");
        this.webViewManager = webViewManager;
    }

    public final ShareIntentManager getShareIntentManager() {
        ShareIntentManager shareIntentManager = this.shareIntentManager;
        if (shareIntentManager != null) {
            return shareIntentManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareIntentManager");
        return null;
    }

    public final void setShareIntentManager(ShareIntentManager shareIntentManager) {
        Intrinsics.checkNotNullParameter(shareIntentManager, "<set-?>");
        this.shareIntentManager = shareIntentManager;
    }

    public final NotificationIntentManager getNotificationIntentManager() {
        NotificationIntentManager notificationIntentManager = this.notificationIntentManager;
        if (notificationIntentManager != null) {
            return notificationIntentManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationIntentManager");
        return null;
    }

    public final void setNotificationIntentManager(NotificationIntentManager notificationIntentManager) {
        Intrinsics.checkNotNullParameter(notificationIntentManager, "<set-?>");
        this.notificationIntentManager = notificationIntentManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final AppUpdateManager appUpdateManager_delegate$lambda$0(MainActivity mainActivity) {
        return AppUpdateManagerFactory.create((Context) mainActivity);
    }

    private final AppUpdateManager getAppUpdateManager() {
        return (AppUpdateManager) this.appUpdateManager.getValue();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        Task appUpdateInfo = getAppUpdateManager().getAppUpdateInfo();
        final Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return MainActivity.onResume$lambda$1(this.f$0, (AppUpdateInfo) obj);
            }
        };
        appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda1
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$1(MainActivity mainActivity, AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            try {
                AppUpdateManager appUpdateManager = mainActivity.getAppUpdateManager();
                ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = mainActivity.updateActivityResultLauncher;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateActivityResultLauncher");
                    activityResultLauncher = null;
                }
                appUpdateManager.startUpdateFlowForResult(appUpdateInfo, activityResultLauncher, AppUpdateOptions.newBuilder(1).build());
            } catch (Exception e) {
                Log.e("appUpdaterActivity", "Resume update failed: " + e.getMessage());
            }
        }
        return Unit.INSTANCE;
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private final void checkForUpdate() {
        Task appUpdateInfo = getAppUpdateManager().getAppUpdateInfo();
        Intrinsics.checkNotNullExpressionValue(appUpdateInfo, "getAppUpdateInfo(...)");
        final Function1 function1 = new Function1() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return MainActivity.checkForUpdate$lambda$3(this.f$0, (AppUpdateInfo) obj);
            }
        };
        appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda3
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit checkForUpdate$lambda$3(MainActivity mainActivity, AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(1)) {
            try {
                AppUpdateManager appUpdateManager = mainActivity.getAppUpdateManager();
                ActivityResultLauncher<IntentSenderRequest> activityResultLauncher = mainActivity.updateActivityResultLauncher;
                if (activityResultLauncher == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updateActivityResultLauncher");
                    activityResultLauncher = null;
                }
                appUpdateManager.startUpdateFlowForResult(appUpdateInfo, activityResultLauncher, AppUpdateOptions.newBuilder(1).build());
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
                Toast.makeText((Context) mainActivity, "Error initiating update: " + e.getMessage(), 1).show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void subscribeToFirebaseTopics() {
        MessagingKt.getMessaging(Firebase.INSTANCE).subscribeToTopic("all_devices");
        MessagingKt.getMessaging(Firebase.INSTANCE).subscribeToTopic("lts_li");
        MessagingKt.getMessaging(Firebase.INSTANCE).subscribeToTopic("lts_li_interactive");
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.Hilt_MainActivity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        this.updateActivityResultLauncher = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda6
            public final void onActivityResult(Object obj) {
                MainActivity.onCreate$lambda$5(this.f$0, (ActivityResult) obj);
            }
        });
        checkForUpdate();
        subscribeToFirebaseTopics();
        setRequestedOrientation((getResources().getConfiguration().screenLayout & 15) >= 3 ? -1 : 1);
        FirebaseInAppMessaging.getInstance().addClickListener(new InAppMessageListener());
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(intent);
        appContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onCreate$lambda$5(MainActivity mainActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "result");
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            Log.v("appUpdaterActivity", "Update flow completed!");
        } else if (resultCode == 0) {
            Log.v("appUpdaterActivity", "User cancelled Update flow!");
        } else {
            Toast.makeText((Context) mainActivity, "Update flow failed with resultCode:" + resultCode + " please try again later", 1).show();
            Log.v("appUpdaterActivity", "Update flow failed with resultCode:" + resultCode);
        }
    }

    private final void handleIntent(Intent intent) {
        CharSequence charSequenceExtra;
        String action = intent.getAction();
        String stringExtra = null;
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode != -1173264947) {
                if (iHashCode == 1703997026 && action.equals("android.intent.action.PROCESS_TEXT") && (charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.PROCESS_TEXT")) != null) {
                    stringExtra = charSequenceExtra.toString();
                }
            } else if (action.equals("android.intent.action.SEND")) {
                stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
            }
        }
        String str = stringExtra;
        if (str != null && !StringsKt.isBlank(str)) {
            getShareIntentManager().onNewShareIntentTextReceived(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("notification_id");
        if (stringExtra2 != null) {
            getNotificationIntentManager().onNewNotificationIntent(stringExtra2);
        }
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.Hilt_MainActivity
    protected void onDestroy() {
        super.onDestroy();
        AnalyticsManager analyticsManager = getAnalyticsManager();
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        analyticsManager.logEvent(new AnalyticsEvent.AppClosed(packageName));
    }

    private final void appContent() {
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-1749052219, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.appContent$lambda$8(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appContent$lambda$8(final MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C176@7039L112,174@6953L198:MainActivity.kt#w8waum");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1749052219, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity.appContent.<anonymous> (MainActivity.kt:174)");
            }
            ThemeKt.LetsTalkSignTranscriptionAppTheme(false, false, ComposableLambdaKt.rememberComposableLambda(-1209416775, true, new Function2() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivity.appContent$lambda$8$lambda$7(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 432, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appContent$lambda$8$lambda$7(MainActivity mainActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C177@7057L80:MainActivity.kt#w8waum");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1209416775, i, -1, "com.deepvisiontech.letstalksigntranscriptionapp.current.MainActivity.appContent.<anonymous>.<anonymous> (MainActivity.kt:177)");
            }
            AppScreenKt.AppScreen(mainActivity.getWebViewManager(), null, composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
