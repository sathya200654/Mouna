package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model;

import com.azure.core.implementation.logging.LoggingKeys;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: Notification.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fBa\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0011HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "", "id", "", "title", LoggingKeys.BODY_KEY, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "isRead", "", "isSelected", "dateTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getTitle", "getBody", "getData", "()Ljava/util/List;", "()Z", "getDateTime", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class Notification {
    private final String body;
    private final List<NotificationData> data;
    private final long dateTime;
    private final String id;
    private final boolean isRead;
    private final boolean isSelected;
    private final String title;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.Notification$$ExternalSyntheticLambda0
        public final Object invoke() {
            return Notification._childSerializers$_anonymous_();
        }
    }), null, null, null};

    public Notification() {
        this((String) null, (String) null, (String) null, (List) null, false, false, 0L, 127, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(NotificationData$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Notification copy$default(Notification notification, String str, String str2, String str3, List list, boolean z, boolean z2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notification.id;
        }
        if ((i & 2) != 0) {
            str2 = notification.title;
        }
        if ((i & 4) != 0) {
            str3 = notification.body;
        }
        if ((i & 8) != 0) {
            list = notification.data;
        }
        if ((i & 16) != 0) {
            z = notification.isRead;
        }
        if ((i & 32) != 0) {
            z2 = notification.isSelected;
        }
        if ((i & 64) != 0) {
            j = notification.dateTime;
        }
        long j2 = j;
        boolean z3 = z;
        boolean z4 = z2;
        return notification.copy(str, str2, str3, list, z3, z4, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final List<NotificationData> component4() {
        return this.data;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getDateTime() {
        return this.dateTime;
    }

    public final Notification copy(String id, String title, String body, List<NotificationData> data, boolean isRead, boolean isSelected, long dateTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new Notification(id, title, body, data, isRead, isSelected, dateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Notification)) {
            return false;
        }
        Notification notification = (Notification) other;
        return Intrinsics.areEqual(this.id, notification.id) && Intrinsics.areEqual(this.title, notification.title) && Intrinsics.areEqual(this.body, notification.body) && Intrinsics.areEqual(this.data, notification.data) && this.isRead == notification.isRead && this.isSelected == notification.isSelected && this.dateTime == notification.dateTime;
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.title.hashCode()) * 31;
        String str = this.body;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<NotificationData> list = this.data;
        return ((((((iHashCode2 + (list != null ? list.hashCode() : 0)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Boolean.hashCode(this.isSelected)) * 31) + Long.hashCode(this.dateTime);
    }

    public String toString() {
        return "Notification(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", data=" + this.data + ", isRead=" + this.isRead + ", isSelected=" + this.isSelected + ", dateTime=" + this.dateTime + ")";
    }

    /* JADX INFO: compiled from: Notification.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/Notification;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Notification> serializer() {
            return Notification$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Notification(int i, String str, String str2, String str3, List list, boolean z, boolean z2, long j, SerializationConstructorMarker serializationConstructorMarker) {
        this.id = (i & 1) == 0 ? "" : str;
        if ((i & 2) == 0) {
            this.title = "Untitled";
        } else {
            this.title = str2;
        }
        if ((i & 4) == 0) {
            this.body = null;
        } else {
            this.body = str3;
        }
        if ((i & 8) == 0) {
            this.data = null;
        } else {
            this.data = list;
        }
        if ((i & 16) == 0) {
            this.isRead = false;
        } else {
            this.isRead = z;
        }
        if ((i & 32) == 0) {
            this.isSelected = false;
        } else {
            this.isSelected = z2;
        }
        if ((i & 64) == 0) {
            this.dateTime = 0L;
        } else {
            this.dateTime = j;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(Notification self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.id, "")) {
            output.encodeStringElement(serialDesc, 0, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.title, "Untitled")) {
            output.encodeStringElement(serialDesc, 1, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.body != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.body);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.data);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isRead) {
            output.encodeBooleanElement(serialDesc, 4, self.isRead);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.isSelected) {
            output.encodeBooleanElement(serialDesc, 5, self.isSelected);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.dateTime == 0) {
            return;
        }
        output.encodeLongElement(serialDesc, 6, self.dateTime);
    }

    public Notification(String str, String str2, String str3, List<NotificationData> list, boolean z, boolean z2, long j) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.body = str3;
        this.data = list;
        this.isRead = z;
        this.isSelected = z2;
        this.dateTime = j;
    }

    public /* synthetic */ Notification(String str, String str2, String str3, List list, boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "Untitled" : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : list, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? 0L : j);
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final List<NotificationData> getData() {
        return this.data;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final long getDateTime() {
        return this.dateTime;
    }
}
