package com.google.firebase.inappmessaging;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class CampaignAnalytics extends GeneratedMessageLite<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {
    public static final int CAMPAIGN_ID_FIELD_NUMBER = 2;
    public static final int CLIENT_APP_FIELD_NUMBER = 3;
    public static final int CLIENT_TIMESTAMP_MILLIS_FIELD_NUMBER = 4;
    private static final CampaignAnalytics DEFAULT_INSTANCE;
    public static final int DISMISS_TYPE_FIELD_NUMBER = 6;
    public static final int ENGAGEMENTMETRICS_DELIVERY_RETRY_COUNT_FIELD_NUMBER = 10;
    public static final int EVENT_TYPE_FIELD_NUMBER = 5;
    public static final int FETCH_ERROR_REASON_FIELD_NUMBER = 8;
    public static final int FIAM_SDK_VERSION_FIELD_NUMBER = 9;
    private static volatile Parser<CampaignAnalytics> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int RENDER_ERROR_REASON_FIELD_NUMBER = 7;
    private int bitField0_;
    private ClientAppInfo clientApp_;
    private long clientTimestampMillis_;
    private int engagementMetricsDeliveryRetryCount_;
    private Object event_;
    private int eventCase_ = 0;
    private String projectNumber_ = "";
    private String campaignId_ = "";
    private String fiamSdkVersion_ = "";

    private CampaignAnalytics() {
    }

    public enum EventCase {
        EVENT_TYPE(5),
        DISMISS_TYPE(6),
        RENDER_ERROR_REASON(7),
        FETCH_ERROR_REASON(8),
        EVENT_NOT_SET(0);

        private final int value;

        EventCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static EventCase valueOf(int i) {
            return forNumber(i);
        }

        public static EventCase forNumber(int i) {
            if (i == 0) {
                return EVENT_NOT_SET;
            }
            if (i == 5) {
                return EVENT_TYPE;
            }
            if (i == 6) {
                return DISMISS_TYPE;
            }
            if (i == 7) {
                return RENDER_ERROR_REASON;
            }
            if (i != 8) {
                return null;
            }
            return FETCH_ERROR_REASON;
        }

        public int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public EventCase getEventCase() {
        return EventCase.forNumber(this.eventCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEvent() {
        this.eventCase_ = 0;
        this.event_ = null;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasProjectNumber() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public String getProjectNumber() {
        return this.projectNumber_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ByteString getProjectNumberBytes() {
        return ByteString.copyFromUtf8(this.projectNumber_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumber(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.projectNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectNumber() {
        this.bitField0_ &= -2;
        this.projectNumber_ = getDefaultInstance().getProjectNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumberBytes(ByteString byteString) {
        this.projectNumber_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasCampaignId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public String getCampaignId() {
        return this.campaignId_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ByteString getCampaignIdBytes() {
        return ByteString.copyFromUtf8(this.campaignId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.campaignId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCampaignId() {
        this.bitField0_ &= -3;
        this.campaignId_ = getDefaultInstance().getCampaignId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCampaignIdBytes(ByteString byteString) {
        this.campaignId_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasClientApp() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ClientAppInfo getClientApp() {
        ClientAppInfo clientAppInfo = this.clientApp_;
        return clientAppInfo == null ? ClientAppInfo.getDefaultInstance() : clientAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientApp(ClientAppInfo clientAppInfo) {
        clientAppInfo.getClass();
        this.clientApp_ = clientAppInfo;
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientApp(ClientAppInfo clientAppInfo) {
        clientAppInfo.getClass();
        ClientAppInfo clientAppInfo2 = this.clientApp_;
        if (clientAppInfo2 != null && clientAppInfo2 != ClientAppInfo.getDefaultInstance()) {
            this.clientApp_ = ClientAppInfo.newBuilder(this.clientApp_).mergeFrom(clientAppInfo).buildPartial();
        } else {
            this.clientApp_ = clientAppInfo;
        }
        this.bitField0_ |= 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientApp() {
        this.clientApp_ = null;
        this.bitField0_ &= -5;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasClientTimestampMillis() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public long getClientTimestampMillis() {
        return this.clientTimestampMillis_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientTimestampMillis(long j) {
        this.bitField0_ |= 8;
        this.clientTimestampMillis_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientTimestampMillis() {
        this.bitField0_ &= -9;
        this.clientTimestampMillis_ = 0L;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasEventType() {
        return this.eventCase_ == 5;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public EventType getEventType() {
        if (this.eventCase_ == 5) {
            EventType eventTypeForNumber = EventType.forNumber(((Integer) this.event_).intValue());
            return eventTypeForNumber == null ? EventType.UNKNOWN_EVENT_TYPE : eventTypeForNumber;
        }
        return EventType.UNKNOWN_EVENT_TYPE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEventType(EventType eventType) {
        this.event_ = Integer.valueOf(eventType.getNumber());
        this.eventCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEventType() {
        if (this.eventCase_ == 5) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasDismissType() {
        return this.eventCase_ == 6;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public DismissType getDismissType() {
        if (this.eventCase_ == 6) {
            DismissType dismissTypeForNumber = DismissType.forNumber(((Integer) this.event_).intValue());
            return dismissTypeForNumber == null ? DismissType.UNKNOWN_DISMISS_TYPE : dismissTypeForNumber;
        }
        return DismissType.UNKNOWN_DISMISS_TYPE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDismissType(DismissType dismissType) {
        this.event_ = Integer.valueOf(dismissType.getNumber());
        this.eventCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDismissType() {
        if (this.eventCase_ == 6) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasRenderErrorReason() {
        return this.eventCase_ == 7;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public RenderErrorReason getRenderErrorReason() {
        if (this.eventCase_ == 7) {
            RenderErrorReason renderErrorReasonForNumber = RenderErrorReason.forNumber(((Integer) this.event_).intValue());
            return renderErrorReasonForNumber == null ? RenderErrorReason.UNSPECIFIED_RENDER_ERROR : renderErrorReasonForNumber;
        }
        return RenderErrorReason.UNSPECIFIED_RENDER_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRenderErrorReason(RenderErrorReason renderErrorReason) {
        this.event_ = Integer.valueOf(renderErrorReason.getNumber());
        this.eventCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRenderErrorReason() {
        if (this.eventCase_ == 7) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasFetchErrorReason() {
        return this.eventCase_ == 8;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public FetchErrorReason getFetchErrorReason() {
        if (this.eventCase_ == 8) {
            FetchErrorReason fetchErrorReasonForNumber = FetchErrorReason.forNumber(((Integer) this.event_).intValue());
            return fetchErrorReasonForNumber == null ? FetchErrorReason.UNSPECIFIED_FETCH_ERROR : fetchErrorReasonForNumber;
        }
        return FetchErrorReason.UNSPECIFIED_FETCH_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFetchErrorReason(FetchErrorReason fetchErrorReason) {
        this.event_ = Integer.valueOf(fetchErrorReason.getNumber());
        this.eventCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFetchErrorReason() {
        if (this.eventCase_ == 8) {
            this.eventCase_ = 0;
            this.event_ = null;
        }
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasFiamSdkVersion() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public String getFiamSdkVersion() {
        return this.fiamSdkVersion_;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public ByteString getFiamSdkVersionBytes() {
        return ByteString.copyFromUtf8(this.fiamSdkVersion_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFiamSdkVersion(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.fiamSdkVersion_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFiamSdkVersion() {
        this.bitField0_ &= -17;
        this.fiamSdkVersion_ = getDefaultInstance().getFiamSdkVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFiamSdkVersionBytes(ByteString byteString) {
        this.fiamSdkVersion_ = byteString.toStringUtf8();
        this.bitField0_ |= 16;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public boolean hasEngagementMetricsDeliveryRetryCount() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
    public int getEngagementMetricsDeliveryRetryCount() {
        return this.engagementMetricsDeliveryRetryCount_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEngagementMetricsDeliveryRetryCount(int i) {
        this.bitField0_ |= 32;
        this.engagementMetricsDeliveryRetryCount_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEngagementMetricsDeliveryRetryCount() {
        this.bitField0_ &= -33;
        this.engagementMetricsDeliveryRetryCount_ = 0;
    }

    public static CampaignAnalytics parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static CampaignAnalytics parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignAnalytics parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignAnalytics parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(InputStream inputStream) throws IOException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignAnalytics parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignAnalytics parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CampaignAnalytics) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignAnalytics parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignAnalytics) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignAnalytics parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignAnalytics parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignAnalytics) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(CampaignAnalytics campaignAnalytics) {
        return DEFAULT_INSTANCE.createBuilder(campaignAnalytics);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CampaignAnalytics, Builder> implements CampaignAnalyticsOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(CampaignAnalytics.DEFAULT_INSTANCE);
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public EventCase getEventCase() {
            return ((CampaignAnalytics) this.instance).getEventCase();
        }

        public Builder clearEvent() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearEvent();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasProjectNumber() {
            return ((CampaignAnalytics) this.instance).hasProjectNumber();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public String getProjectNumber() {
            return ((CampaignAnalytics) this.instance).getProjectNumber();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ByteString getProjectNumberBytes() {
            return ((CampaignAnalytics) this.instance).getProjectNumberBytes();
        }

        public Builder setProjectNumber(String str) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setProjectNumber(str);
            return this;
        }

        public Builder clearProjectNumber() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearProjectNumber();
            return this;
        }

        public Builder setProjectNumberBytes(ByteString byteString) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setProjectNumberBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasCampaignId() {
            return ((CampaignAnalytics) this.instance).hasCampaignId();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public String getCampaignId() {
            return ((CampaignAnalytics) this.instance).getCampaignId();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ByteString getCampaignIdBytes() {
            return ((CampaignAnalytics) this.instance).getCampaignIdBytes();
        }

        public Builder setCampaignId(String str) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setCampaignId(str);
            return this;
        }

        public Builder clearCampaignId() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearCampaignId();
            return this;
        }

        public Builder setCampaignIdBytes(ByteString byteString) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setCampaignIdBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasClientApp() {
            return ((CampaignAnalytics) this.instance).hasClientApp();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ClientAppInfo getClientApp() {
            return ((CampaignAnalytics) this.instance).getClientApp();
        }

        public Builder setClientApp(ClientAppInfo clientAppInfo) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setClientApp(clientAppInfo);
            return this;
        }

        public Builder setClientApp(ClientAppInfo.Builder builder) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setClientApp(builder.build());
            return this;
        }

        public Builder mergeClientApp(ClientAppInfo clientAppInfo) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).mergeClientApp(clientAppInfo);
            return this;
        }

        public Builder clearClientApp() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearClientApp();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasClientTimestampMillis() {
            return ((CampaignAnalytics) this.instance).hasClientTimestampMillis();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public long getClientTimestampMillis() {
            return ((CampaignAnalytics) this.instance).getClientTimestampMillis();
        }

        public Builder setClientTimestampMillis(long j) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setClientTimestampMillis(j);
            return this;
        }

        public Builder clearClientTimestampMillis() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearClientTimestampMillis();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasEventType() {
            return ((CampaignAnalytics) this.instance).hasEventType();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public EventType getEventType() {
            return ((CampaignAnalytics) this.instance).getEventType();
        }

        public Builder setEventType(EventType eventType) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setEventType(eventType);
            return this;
        }

        public Builder clearEventType() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearEventType();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasDismissType() {
            return ((CampaignAnalytics) this.instance).hasDismissType();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public DismissType getDismissType() {
            return ((CampaignAnalytics) this.instance).getDismissType();
        }

        public Builder setDismissType(DismissType dismissType) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setDismissType(dismissType);
            return this;
        }

        public Builder clearDismissType() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearDismissType();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasRenderErrorReason() {
            return ((CampaignAnalytics) this.instance).hasRenderErrorReason();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public RenderErrorReason getRenderErrorReason() {
            return ((CampaignAnalytics) this.instance).getRenderErrorReason();
        }

        public Builder setRenderErrorReason(RenderErrorReason renderErrorReason) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setRenderErrorReason(renderErrorReason);
            return this;
        }

        public Builder clearRenderErrorReason() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearRenderErrorReason();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasFetchErrorReason() {
            return ((CampaignAnalytics) this.instance).hasFetchErrorReason();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public FetchErrorReason getFetchErrorReason() {
            return ((CampaignAnalytics) this.instance).getFetchErrorReason();
        }

        public Builder setFetchErrorReason(FetchErrorReason fetchErrorReason) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setFetchErrorReason(fetchErrorReason);
            return this;
        }

        public Builder clearFetchErrorReason() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearFetchErrorReason();
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasFiamSdkVersion() {
            return ((CampaignAnalytics) this.instance).hasFiamSdkVersion();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public String getFiamSdkVersion() {
            return ((CampaignAnalytics) this.instance).getFiamSdkVersion();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public ByteString getFiamSdkVersionBytes() {
            return ((CampaignAnalytics) this.instance).getFiamSdkVersionBytes();
        }

        public Builder setFiamSdkVersion(String str) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setFiamSdkVersion(str);
            return this;
        }

        public Builder clearFiamSdkVersion() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearFiamSdkVersion();
            return this;
        }

        public Builder setFiamSdkVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setFiamSdkVersionBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public boolean hasEngagementMetricsDeliveryRetryCount() {
            return ((CampaignAnalytics) this.instance).hasEngagementMetricsDeliveryRetryCount();
        }

        @Override // com.google.firebase.inappmessaging.CampaignAnalyticsOrBuilder
        public int getEngagementMetricsDeliveryRetryCount() {
            return ((CampaignAnalytics) this.instance).getEngagementMetricsDeliveryRetryCount();
        }

        public Builder setEngagementMetricsDeliveryRetryCount(int i) {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).setEngagementMetricsDeliveryRetryCount(i);
            return this;
        }

        public Builder clearEngagementMetricsDeliveryRetryCount() {
            copyOnWrite();
            ((CampaignAnalytics) this.instance).clearEngagementMetricsDeliveryRetryCount();
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.CampaignAnalytics$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser defaultInstanceBasedParser;
        int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new CampaignAnalytics();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0001\u0001\u0001\n\n\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဂ\u0003\u0005\u083f\u0000\u0006\u083f\u0000\u0007\u083f\u0000\b\u083f\u0000\tဈ\u0004\nင\u0005", new Object[]{"event_", "eventCase_", "bitField0_", "projectNumber_", "campaignId_", "clientApp_", "clientTimestampMillis_", EventType.internalGetVerifier(), DismissType.internalGetVerifier(), RenderErrorReason.internalGetVerifier(), FetchErrorReason.internalGetVerifier(), "fiamSdkVersion_", "engagementMetricsDeliveryRetryCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CampaignAnalytics> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CampaignAnalytics.class) {
                    defaultInstanceBasedParser = PARSER;
                    if (defaultInstanceBasedParser == null) {
                        defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                        PARSER = defaultInstanceBasedParser;
                    }
                    break;
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        CampaignAnalytics campaignAnalytics = new CampaignAnalytics();
        DEFAULT_INSTANCE = campaignAnalytics;
        GeneratedMessageLite.registerDefaultInstance(CampaignAnalytics.class, campaignAnalytics);
    }

    public static CampaignAnalytics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CampaignAnalytics> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
