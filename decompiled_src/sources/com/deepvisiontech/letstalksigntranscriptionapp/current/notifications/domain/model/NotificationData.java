package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model;

import com.google.gson.annotations.SerializedName;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: compiled from: NotificationData.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 @2\u00020\u0001:\u0002?@Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\u0081\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J}\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0015HÖ\u0001J\t\u00106\u001a\u00020\u0007HÖ\u0001J%\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\b>R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010'¨\u0006A"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "", "pageId", "", "pageType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType;", "pageTitle", "", "pageBody", "optionsList", "", "image", "video", "primaryAction", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "secondaryAction", "isResponded", "", "<init>", "(JLcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPageId", "()J", "getPageType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationPageType;", "getPageTitle", "()Ljava/lang/String;", "getPageBody", "getOptionsList", "()Ljava/util/List;", "getImage", "getVideo", "getPrimaryAction", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationResponseType;", "getSecondaryAction", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$app_release", "$serializer", "Companion", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final /* data */ class NotificationData {
    private final String image;
    private final boolean isResponded;
    private final List<String> optionsList;
    private final String pageBody;

    @SerializedName("id")
    private final long pageId;
    private final String pageTitle;
    private final NotificationPageType pageType;
    private final NotificationResponseType primaryAction;
    private final NotificationResponseType secondaryAction;
    private final String video;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData$$ExternalSyntheticLambda0
        public final Object invoke() {
            return NotificationData._childSerializers$_anonymous_();
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData$$ExternalSyntheticLambda1
        public final Object invoke() {
            return NotificationData._childSerializers$_anonymous_$0();
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData$$ExternalSyntheticLambda2
        public final Object invoke() {
            return NotificationData._childSerializers$_anonymous_$1();
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationData$$ExternalSyntheticLambda3
        public final Object invoke() {
            return NotificationData._childSerializers$_anonymous_$2();
        }
    }), null};

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return NotificationPageType.INSTANCE.serializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return EnumsKt.createSimpleEnumSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType", NotificationResponseType.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return EnumsKt.createSimpleEnumSerializer("com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model.NotificationResponseType", NotificationResponseType.values());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NotificationData copy$default(NotificationData notificationData, long j, NotificationPageType notificationPageType, String str, String str2, List list, String str3, String str4, NotificationResponseType notificationResponseType, NotificationResponseType notificationResponseType2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = notificationData.pageId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            notificationPageType = notificationData.pageType;
        }
        return notificationData.copy(j2, notificationPageType, (i & 4) != 0 ? notificationData.pageTitle : str, (i & 8) != 0 ? notificationData.pageBody : str2, (i & 16) != 0 ? notificationData.optionsList : list, (i & 32) != 0 ? notificationData.image : str3, (i & 64) != 0 ? notificationData.video : str4, (i & 128) != 0 ? notificationData.primaryAction : notificationResponseType, (i & 256) != 0 ? notificationData.secondaryAction : notificationResponseType2, (i & 512) != 0 ? notificationData.isResponded : z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPageId() {
        return this.pageId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsResponded() {
        return this.isResponded;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NotificationPageType getPageType() {
        return this.pageType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPageTitle() {
        return this.pageTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPageBody() {
        return this.pageBody;
    }

    public final List<String> component5() {
        return this.optionsList;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getVideo() {
        return this.video;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NotificationResponseType getPrimaryAction() {
        return this.primaryAction;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final NotificationResponseType getSecondaryAction() {
        return this.secondaryAction;
    }

    public final NotificationData copy(long pageId, NotificationPageType pageType, String pageTitle, String pageBody, List<String> optionsList, String image, String video, NotificationResponseType primaryAction, NotificationResponseType secondaryAction, boolean isResponded) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Intrinsics.checkNotNullParameter(pageBody, "pageBody");
        return new NotificationData(pageId, pageType, pageTitle, pageBody, optionsList, image, video, primaryAction, secondaryAction, isResponded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationData)) {
            return false;
        }
        NotificationData notificationData = (NotificationData) other;
        return this.pageId == notificationData.pageId && this.pageType == notificationData.pageType && Intrinsics.areEqual(this.pageTitle, notificationData.pageTitle) && Intrinsics.areEqual(this.pageBody, notificationData.pageBody) && Intrinsics.areEqual(this.optionsList, notificationData.optionsList) && Intrinsics.areEqual(this.image, notificationData.image) && Intrinsics.areEqual(this.video, notificationData.video) && this.primaryAction == notificationData.primaryAction && this.secondaryAction == notificationData.secondaryAction && this.isResponded == notificationData.isResponded;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.pageId) * 31) + this.pageType.hashCode()) * 31) + this.pageTitle.hashCode()) * 31) + this.pageBody.hashCode()) * 31;
        List<String> list = this.optionsList;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.image;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.video;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        NotificationResponseType notificationResponseType = this.primaryAction;
        int iHashCode5 = (iHashCode4 + (notificationResponseType == null ? 0 : notificationResponseType.hashCode())) * 31;
        NotificationResponseType notificationResponseType2 = this.secondaryAction;
        return ((iHashCode5 + (notificationResponseType2 != null ? notificationResponseType2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isResponded);
    }

    public String toString() {
        return "NotificationData(pageId=" + this.pageId + ", pageType=" + this.pageType + ", pageTitle=" + this.pageTitle + ", pageBody=" + this.pageBody + ", optionsList=" + this.optionsList + ", image=" + this.image + ", video=" + this.video + ", primaryAction=" + this.primaryAction + ", secondaryAction=" + this.secondaryAction + ", isResponded=" + this.isResponded + ")";
    }

    /* JADX INFO: compiled from: NotificationData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationData;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NotificationData> serializer() {
            return NotificationData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NotificationData(int i, long j, NotificationPageType notificationPageType, String str, String str2, List list, String str3, String str4, NotificationResponseType notificationResponseType, NotificationResponseType notificationResponseType2, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, NotificationData$$serializer.INSTANCE.getDescriptor());
        }
        this.pageId = j;
        this.pageType = notificationPageType;
        this.pageTitle = str;
        this.pageBody = str2;
        if ((i & 16) == 0) {
            this.optionsList = null;
        } else {
            this.optionsList = list;
        }
        if ((i & 32) == 0) {
            this.image = null;
        } else {
            this.image = str3;
        }
        if ((i & 64) == 0) {
            this.video = null;
        } else {
            this.video = str4;
        }
        if ((i & 128) == 0) {
            this.primaryAction = null;
        } else {
            this.primaryAction = notificationResponseType;
        }
        if ((i & 256) == 0) {
            this.secondaryAction = null;
        } else {
            this.secondaryAction = notificationResponseType2;
        }
        if ((i & 512) == 0) {
            this.isResponded = false;
        } else {
            this.isResponded = z;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$app_release(NotificationData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.pageId);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.pageType);
        output.encodeStringElement(serialDesc, 2, self.pageTitle);
        output.encodeStringElement(serialDesc, 3, self.pageBody);
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.optionsList != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.optionsList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.image != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.image);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.video != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.video);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.primaryAction != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.primaryAction);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.secondaryAction != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.secondaryAction);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.isResponded) {
            output.encodeBooleanElement(serialDesc, 9, self.isResponded);
        }
    }

    public NotificationData(long j, NotificationPageType notificationPageType, String str, String str2, List<String> list, String str3, String str4, NotificationResponseType notificationResponseType, NotificationResponseType notificationResponseType2, boolean z) {
        Intrinsics.checkNotNullParameter(notificationPageType, "pageType");
        Intrinsics.checkNotNullParameter(str, "pageTitle");
        Intrinsics.checkNotNullParameter(str2, "pageBody");
        this.pageId = j;
        this.pageType = notificationPageType;
        this.pageTitle = str;
        this.pageBody = str2;
        this.optionsList = list;
        this.image = str3;
        this.video = str4;
        this.primaryAction = notificationResponseType;
        this.secondaryAction = notificationResponseType2;
        this.isResponded = z;
    }

    public /* synthetic */ NotificationData(long j, NotificationPageType notificationPageType, String str, String str2, List list, String str3, String str4, NotificationResponseType notificationResponseType, NotificationResponseType notificationResponseType2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, notificationPageType, str, str2, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : notificationResponseType, (i & 256) != 0 ? null : notificationResponseType2, (i & 512) != 0 ? false : z);
    }

    public final long getPageId() {
        return this.pageId;
    }

    public final NotificationPageType getPageType() {
        return this.pageType;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final String getPageBody() {
        return this.pageBody;
    }

    public final List<String> getOptionsList() {
        return this.optionsList;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getVideo() {
        return this.video;
    }

    public final NotificationResponseType getPrimaryAction() {
        return this.primaryAction;
    }

    public final NotificationResponseType getSecondaryAction() {
        return this.secondaryAction;
    }

    public final boolean isResponded() {
        return this.isResponded;
    }
}
