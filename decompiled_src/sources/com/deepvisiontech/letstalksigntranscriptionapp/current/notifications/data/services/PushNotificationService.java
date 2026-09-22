package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.azure.core.implementation.logging.LoggingKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.R;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.di.ApplicationScope;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData;
import com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.repository.NotificationRepository;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: PushNotificationService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016H\u0002J6\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0082@¢\u0006\u0002\u0010#J \u0010$\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/data/services/PushNotificationService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "notificationRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;", "getNotificationRepository", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;", "setNotificationRepository", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/repository/NotificationRepository;)V", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "getExternalScope$annotations", "getExternalScope", "()Lkotlinx/coroutines/CoroutineScope;", "setExternalScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "onNewToken", "", "token", "", "onMessageReceived", ResponseKeys.KEY_MESSAGE, "Lcom/google/firebase/messaging/RemoteMessage;", "fromJsonToNotificationDataList", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "json", "saveNotificationToDatabase", "id", "title", LoggingKeys.BODY_KEY, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showNotification", "mongoId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class PushNotificationService extends Hilt_PushNotificationService {
    public static final int $stable = 8;

    @Inject
    public CoroutineScope externalScope;
    private final Gson gson = new Gson();

    @Inject
    public NotificationRepository notificationRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services.PushNotificationService$saveNotificationToDatabase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services.PushNotificationService", f = "PushNotificationService.kt", i = {0, 0, 0, 0, 0}, l = {89}, m = "saveNotificationToDatabase", n = {"id", "title", LoggingKeys.BODY_KEY, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "notification"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C02901 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C02901(Continuation<? super C02901> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationService.this.saveNotificationToDatabase(null, null, null, null, (Continuation) this);
        }
    }

    @ApplicationScope
    public static /* synthetic */ void getExternalScope$annotations() {
    }

    public final NotificationRepository getNotificationRepository() {
        NotificationRepository notificationRepository = this.notificationRepository;
        if (notificationRepository != null) {
            return notificationRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationRepository");
        return null;
    }

    public final void setNotificationRepository(NotificationRepository notificationRepository) {
        Intrinsics.checkNotNullParameter(notificationRepository, "<set-?>");
        this.notificationRepository = notificationRepository;
    }

    public final CoroutineScope getExternalScope() {
        CoroutineScope coroutineScope = this.externalScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("externalScope");
        return null;
    }

    public final void setExternalScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.externalScope = coroutineScope;
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        Log.d(FirebaseMessaging.INSTANCE_ID_SCOPE, "New token: " + token);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        super.onMessageReceived(message);
        Log.d("FCM_MESSAGE", "FCM Message Received: " + message.getData());
        String str = message.getData().get("dbId");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.e("FCM_ERROR", "Received notification without a 'dbId'. Ignoring message.");
            return;
        }
        String str3 = message.getData().get("title");
        if (str3 == null) {
            str3 = "New Notification";
        }
        String str4 = str3;
        String str5 = message.getData().get(LoggingKeys.BODY_KEY);
        if (str5 == null) {
            str5 = "You have a new message.";
        }
        BuildersKt.launch$default(getExternalScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(str, str4, str5, fromJsonToNotificationDataList(message.getData().get("pages")), null), 3, (Object) null);
    }

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services.PushNotificationService$onMessageReceived$1, reason: invalid class name */
    /* JADX INFO: compiled from: PushNotificationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services.PushNotificationService$onMessageReceived$1", f = "PushNotificationService.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $body;
        final /* synthetic */ String $mongoId;
        final /* synthetic */ List<NotificationData> $notificationDataList;
        final /* synthetic */ String $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, List<NotificationData> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mongoId = str;
            this.$title = str2;
            this.$body = str3;
            this.$notificationDataList = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PushNotificationService.this.new AnonymousClass1(this.$mongoId, this.$title, this.$body, this.$notificationDataList, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PushNotificationService.this.saveNotificationToDatabase(this.$mongoId, this.$title, this.$body, this.$notificationDataList, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PushNotificationService.this.showNotification(this.$title, this.$body, this.$mongoId);
            return Unit.INSTANCE;
        }
    }

    private final List<NotificationData> fromJsonToNotificationDataList(String json) {
        String str = json;
        if (str != null && str.length() != 0) {
            try {
                return (List) this.gson.fromJson(json, new TypeToken<List<? extends NotificationData>>() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.data.services.PushNotificationService$fromJsonToNotificationDataList$listType$1
                }.getType());
            } catch (Exception e) {
                Log.e("FCM_JSON_ERROR", "Failed to parse 'pages' JSON", e);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object saveNotificationToDatabase(String str, String str2, String str3, List<NotificationData> list, Continuation<? super Unit> continuation) {
        C02901 c02901;
        PushNotificationService pushNotificationService;
        String str4;
        if (continuation instanceof C02901) {
            c02901 = (C02901) continuation;
            if ((c02901.label & Integer.MIN_VALUE) != 0) {
                c02901.label -= Integer.MIN_VALUE;
                pushNotificationService = this;
            } else {
                pushNotificationService = this;
                c02901 = pushNotificationService.new C02901(continuation);
            }
        } else {
            pushNotificationService = this;
            c02901 = pushNotificationService.new C02901(continuation);
        }
        Object obj = c02901.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c02901.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Notification notification = new Notification(str, str2, str3, (List) list, false, false, System.currentTimeMillis(), 32, (DefaultConstructorMarker) null);
            NotificationRepository notificationRepository = pushNotificationService.getNotificationRepository();
            c02901.L$0 = str;
            c02901.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c02901.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            c02901.L$3 = SpillingKt.nullOutSpilledVariable(list);
            c02901.L$4 = SpillingKt.nullOutSpilledVariable(notification);
            c02901.label = 1;
            if (notificationRepository.insertNotifications(notification, c02901) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str4 = str;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str4 = (String) c02901.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Log.d("FCM_DB", "Notification saved to database with ID: " + str4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNotification(String title, String body, String mongoId) {
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationChannel notificationChannel = new NotificationChannel("default_notification_channel", "General Notifications", 4);
        notificationChannel.setDescription("Channel for general app notifications");
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(335544320);
            launchIntentForPackage.putExtra("notification_id", mongoId);
        } else {
            launchIntentForPackage = null;
        }
        PushNotificationService pushNotificationService = this;
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(pushNotificationService, "default_notification_channel").setContentTitle(title).setContentText(body).setSmallIcon(R.drawable.small_logo1).setAutoCancel(true).setPriority(1).setDefaults(-1).setContentIntent(PendingIntent.getActivity(pushNotificationService, mongoId.hashCode(), launchIntentForPackage, 1140850688));
        Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
        notificationManager.notify(mongoId.hashCode(), contentIntent.build());
        Log.d("FCM_UI", "Notification shown in system tray for ID: " + mongoId);
    }
}
