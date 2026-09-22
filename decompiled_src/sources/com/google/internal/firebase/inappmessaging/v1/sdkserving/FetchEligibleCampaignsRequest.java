package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.developers.mobile.targeting.proto.ClientSignalsProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FetchEligibleCampaignsRequest extends GeneratedMessageLite<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 3;
    public static final int CLIENT_SIGNALS_FIELD_NUMBER = 4;
    private static final FetchEligibleCampaignsRequest DEFAULT_INSTANCE;
    private static volatile Parser<FetchEligibleCampaignsRequest> PARSER = null;
    public static final int PROJECT_NUMBER_FIELD_NUMBER = 1;
    public static final int REQUESTING_CLIENT_APP_FIELD_NUMBER = 2;
    private int bitField0_;
    private ClientSignalsProto.ClientSignals clientSignals_;
    private ClientAppInfo requestingClientApp_;
    private String projectNumber_ = "";
    private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = emptyProtobufList();

    private FetchEligibleCampaignsRequest() {
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public String getProjectNumber() {
        return this.projectNumber_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public ByteString getProjectNumberBytes() {
        return ByteString.copyFromUtf8(this.projectNumber_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumber(String str) {
        str.getClass();
        this.projectNumber_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProjectNumber() {
        this.projectNumber_ = getDefaultInstance().getProjectNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProjectNumberBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.projectNumber_ = byteString.toStringUtf8();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public boolean hasRequestingClientApp() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public ClientAppInfo getRequestingClientApp() {
        ClientAppInfo clientAppInfo = this.requestingClientApp_;
        return clientAppInfo == null ? ClientAppInfo.getDefaultInstance() : clientAppInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestingClientApp(ClientAppInfo clientAppInfo) {
        clientAppInfo.getClass();
        this.requestingClientApp_ = clientAppInfo;
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequestingClientApp(ClientAppInfo clientAppInfo) {
        clientAppInfo.getClass();
        ClientAppInfo clientAppInfo2 = this.requestingClientApp_;
        if (clientAppInfo2 != null && clientAppInfo2 != ClientAppInfo.getDefaultInstance()) {
            this.requestingClientApp_ = ClientAppInfo.newBuilder(this.requestingClientApp_).mergeFrom(clientAppInfo).buildPartial();
        } else {
            this.requestingClientApp_ = clientAppInfo;
        }
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestingClientApp() {
        this.requestingClientApp_ = null;
        this.bitField0_ &= -2;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public List<CampaignImpression> getAlreadySeenCampaignsList() {
        return this.alreadySeenCampaigns_;
    }

    public List<? extends CampaignImpressionOrBuilder> getAlreadySeenCampaignsOrBuilderList() {
        return this.alreadySeenCampaigns_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public int getAlreadySeenCampaignsCount() {
        return this.alreadySeenCampaigns_.size();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public CampaignImpression getAlreadySeenCampaigns(int i) {
        return this.alreadySeenCampaigns_.get(i);
    }

    public CampaignImpressionOrBuilder getAlreadySeenCampaignsOrBuilder(int i) {
        return this.alreadySeenCampaigns_.get(i);
    }

    private void ensureAlreadySeenCampaignsIsMutable() {
        Internal.ProtobufList<CampaignImpression> protobufList = this.alreadySeenCampaigns_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.alreadySeenCampaigns_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
        campaignImpression.getClass();
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.set(i, campaignImpression);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
        campaignImpression.getClass();
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(campaignImpression);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
        campaignImpression.getClass();
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.add(i, campaignImpression);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
        ensureAlreadySeenCampaignsIsMutable();
        AbstractMessageLite.addAll(iterable, this.alreadySeenCampaigns_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlreadySeenCampaigns() {
        this.alreadySeenCampaigns_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAlreadySeenCampaigns(int i) {
        ensureAlreadySeenCampaignsIsMutable();
        this.alreadySeenCampaigns_.remove(i);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public boolean hasClientSignals() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
    public ClientSignalsProto.ClientSignals getClientSignals() {
        ClientSignalsProto.ClientSignals clientSignals = this.clientSignals_;
        return clientSignals == null ? ClientSignalsProto.ClientSignals.getDefaultInstance() : clientSignals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
        clientSignals.getClass();
        this.clientSignals_ = clientSignals;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
        clientSignals.getClass();
        ClientSignalsProto.ClientSignals clientSignals2 = this.clientSignals_;
        if (clientSignals2 != null && clientSignals2 != ClientSignalsProto.ClientSignals.getDefaultInstance()) {
            this.clientSignals_ = ClientSignalsProto.ClientSignals.newBuilder(this.clientSignals_).mergeFrom(clientSignals).buildPartial();
        } else {
            this.clientSignals_ = clientSignals;
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientSignals() {
        this.clientSignals_ = null;
        this.bitField0_ &= -3;
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FetchEligibleCampaignsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FetchEligibleCampaignsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FetchEligibleCampaignsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
        return DEFAULT_INSTANCE.createBuilder(fetchEligibleCampaignsRequest);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsRequest, Builder> implements FetchEligibleCampaignsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(FetchEligibleCampaignsRequest.DEFAULT_INSTANCE);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public String getProjectNumber() {
            return ((FetchEligibleCampaignsRequest) this.instance).getProjectNumber();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public ByteString getProjectNumberBytes() {
            return ((FetchEligibleCampaignsRequest) this.instance).getProjectNumberBytes();
        }

        public Builder setProjectNumber(String str) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setProjectNumber(str);
            return this;
        }

        public Builder clearProjectNumber() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearProjectNumber();
            return this;
        }

        public Builder setProjectNumberBytes(ByteString byteString) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setProjectNumberBytes(byteString);
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public boolean hasRequestingClientApp() {
            return ((FetchEligibleCampaignsRequest) this.instance).hasRequestingClientApp();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public ClientAppInfo getRequestingClientApp() {
            return ((FetchEligibleCampaignsRequest) this.instance).getRequestingClientApp();
        }

        public Builder setRequestingClientApp(ClientAppInfo clientAppInfo) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setRequestingClientApp(clientAppInfo);
            return this;
        }

        public Builder setRequestingClientApp(ClientAppInfo.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setRequestingClientApp(builder.build());
            return this;
        }

        public Builder mergeRequestingClientApp(ClientAppInfo clientAppInfo) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).mergeRequestingClientApp(clientAppInfo);
            return this;
        }

        public Builder clearRequestingClientApp() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearRequestingClientApp();
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public List<CampaignImpression> getAlreadySeenCampaignsList() {
            return Collections.unmodifiableList(((FetchEligibleCampaignsRequest) this.instance).getAlreadySeenCampaignsList());
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public int getAlreadySeenCampaignsCount() {
            return ((FetchEligibleCampaignsRequest) this.instance).getAlreadySeenCampaignsCount();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public CampaignImpression getAlreadySeenCampaigns(int i) {
            return ((FetchEligibleCampaignsRequest) this.instance).getAlreadySeenCampaigns(i);
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setAlreadySeenCampaigns(i, builder.build());
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(builder.build());
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAlreadySeenCampaigns(i, builder.build());
            return this;
        }

        public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).addAllAlreadySeenCampaigns(iterable);
            return this;
        }

        public Builder clearAlreadySeenCampaigns() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearAlreadySeenCampaigns();
            return this;
        }

        public Builder removeAlreadySeenCampaigns(int i) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).removeAlreadySeenCampaigns(i);
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public boolean hasClientSignals() {
            return ((FetchEligibleCampaignsRequest) this.instance).hasClientSignals();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequestOrBuilder
        public ClientSignalsProto.ClientSignals getClientSignals() {
            return ((FetchEligibleCampaignsRequest) this.instance).getClientSignals();
        }

        public Builder setClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setClientSignals(clientSignals);
            return this;
        }

        public Builder setClientSignals(ClientSignalsProto.ClientSignals.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).setClientSignals(builder.build());
            return this;
        }

        public Builder mergeClientSignals(ClientSignalsProto.ClientSignals clientSignals) {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).mergeClientSignals(clientSignals);
            return this;
        }

        public Builder clearClientSignals() {
            copyOnWrite();
            ((FetchEligibleCampaignsRequest) this.instance).clearClientSignals();
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsRequest$1, reason: invalid class name */
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
                return new FetchEligibleCampaignsRequest();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u001b\u0004ဉ\u0001", new Object[]{"bitField0_", "projectNumber_", "requestingClientApp_", "alreadySeenCampaigns_", CampaignImpression.class, "clientSignals_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FetchEligibleCampaignsRequest> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FetchEligibleCampaignsRequest.class) {
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
        FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest = new FetchEligibleCampaignsRequest();
        DEFAULT_INSTANCE = fetchEligibleCampaignsRequest;
        GeneratedMessageLite.registerDefaultInstance(FetchEligibleCampaignsRequest.class, fetchEligibleCampaignsRequest);
    }

    public static FetchEligibleCampaignsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FetchEligibleCampaignsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
