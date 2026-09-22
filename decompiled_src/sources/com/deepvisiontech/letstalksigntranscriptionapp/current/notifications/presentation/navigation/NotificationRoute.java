package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation;

import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: NotificationRoute.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/navigation/NotificationRoute;", "", "NotificationScreen", "NotificationListScreen", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface NotificationRoute {

    /* JADX INFO: compiled from: NotificationRoute.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/navigation/NotificationRoute$NotificationScreen;", "", "notificationId", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNotificationId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class NotificationScreen {
        public static final int $stable = 0;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String notificationId;

        public static /* synthetic */ NotificationScreen copy$default(NotificationScreen notificationScreen, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = notificationScreen.notificationId;
            }
            return notificationScreen.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getNotificationId() {
            return this.notificationId;
        }

        public final NotificationScreen copy(String notificationId) {
            Intrinsics.checkNotNullParameter(notificationId, "notificationId");
            return new NotificationScreen(notificationId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NotificationScreen) && Intrinsics.areEqual(this.notificationId, ((NotificationScreen) other).notificationId);
        }

        public int hashCode() {
            return this.notificationId.hashCode();
        }

        public String toString() {
            return "NotificationScreen(notificationId=" + this.notificationId + ")";
        }

        /* JADX INFO: compiled from: NotificationRoute.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/navigation/NotificationRoute$NotificationScreen$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/navigation/NotificationRoute$NotificationScreen;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final KSerializer<NotificationScreen> serializer() {
                return NotificationRoute$NotificationScreen$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ NotificationScreen(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, NotificationRoute$NotificationScreen$$serializer.INSTANCE.getDescriptor());
            }
            this.notificationId = str;
        }

        public NotificationScreen(String str) {
            Intrinsics.checkNotNullParameter(str, "notificationId");
            this.notificationId = str;
        }

        public final String getNotificationId() {
            return this.notificationId;
        }
    }

    /* JADX INFO: compiled from: NotificationRoute.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nJ\t\u0010\u000b\u001a\u00020\fHÖ\u0001¨\u0006\r"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/presentation/navigation/NotificationRoute$NotificationListScreen;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    public static final /* data */ class NotificationListScreen {
        public static final int $stable = 0;
        public static final NotificationListScreen INSTANCE = new NotificationListScreen();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationRoute$NotificationListScreen$$ExternalSyntheticLambda0
            public final Object invoke() {
                return NotificationRoute.NotificationListScreen._init_$_anonymous_();
            }
        });

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotificationListScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1663035283;
        }

        public String toString() {
            return "NotificationListScreen";
        }

        private NotificationListScreen() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.presentation.navigation.NotificationRoute.NotificationListScreen", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public final KSerializer<NotificationListScreen> serializer() {
            return get$cachedSerializer();
        }
    }
}
