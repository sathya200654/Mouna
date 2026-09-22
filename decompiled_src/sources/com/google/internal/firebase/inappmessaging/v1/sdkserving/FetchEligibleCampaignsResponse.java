package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.internal.firebase.inappmessaging.v1.CampaignProto;
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
public final class FetchEligibleCampaignsResponse extends GeneratedMessageLite<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
    private static final FetchEligibleCampaignsResponse DEFAULT_INSTANCE;
    public static final int EXPIRATION_EPOCH_TIMESTAMP_MILLIS_FIELD_NUMBER = 2;
    public static final int MESSAGES_FIELD_NUMBER = 1;
    private static volatile Parser<FetchEligibleCampaignsResponse> PARSER;
    private long expirationEpochTimestampMillis_;
    private Internal.ProtobufList<CampaignProto.ThickContent> messages_ = emptyProtobufList();

    private FetchEligibleCampaignsResponse() {
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public List<CampaignProto.ThickContent> getMessagesList() {
        return this.messages_;
    }

    public List<? extends CampaignProto.ThickContentOrBuilder> getMessagesOrBuilderList() {
        return this.messages_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public int getMessagesCount() {
        return this.messages_.size();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public CampaignProto.ThickContent getMessages(int i) {
        return this.messages_.get(i);
    }

    public CampaignProto.ThickContentOrBuilder getMessagesOrBuilder(int i) {
        return this.messages_.get(i);
    }

    private void ensureMessagesIsMutable() {
        Internal.ProtobufList<CampaignProto.ThickContent> protobufList = this.messages_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.messages_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessages(int i, CampaignProto.ThickContent thickContent) {
        thickContent.getClass();
        ensureMessagesIsMutable();
        this.messages_.set(i, thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(CampaignProto.ThickContent thickContent) {
        thickContent.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMessages(int i, CampaignProto.ThickContent thickContent) {
        thickContent.getClass();
        ensureMessagesIsMutable();
        this.messages_.add(i, thickContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMessages(Iterable<? extends CampaignProto.ThickContent> iterable) {
        ensureMessagesIsMutable();
        AbstractMessageLite.addAll(iterable, this.messages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessages() {
        this.messages_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessages(int i) {
        ensureMessagesIsMutable();
        this.messages_.remove(i);
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
    public long getExpirationEpochTimestampMillis() {
        return this.expirationEpochTimestampMillis_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExpirationEpochTimestampMillis(long j) {
        this.expirationEpochTimestampMillis_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExpirationEpochTimestampMillis() {
        this.expirationEpochTimestampMillis_ = 0L;
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static FetchEligibleCampaignsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static FetchEligibleCampaignsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FetchEligibleCampaignsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static FetchEligibleCampaignsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static FetchEligibleCampaignsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FetchEligibleCampaignsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse) {
        return DEFAULT_INSTANCE.createBuilder(fetchEligibleCampaignsResponse);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<FetchEligibleCampaignsResponse, Builder> implements FetchEligibleCampaignsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(FetchEligibleCampaignsResponse.DEFAULT_INSTANCE);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public List<CampaignProto.ThickContent> getMessagesList() {
            return Collections.unmodifiableList(((FetchEligibleCampaignsResponse) this.instance).getMessagesList());
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public int getMessagesCount() {
            return ((FetchEligibleCampaignsResponse) this.instance).getMessagesCount();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public CampaignProto.ThickContent getMessages(int i) {
            return ((FetchEligibleCampaignsResponse) this.instance).getMessages(i);
        }

        public Builder setMessages(int i, CampaignProto.ThickContent thickContent) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).setMessages(i, thickContent);
            return this;
        }

        public Builder setMessages(int i, CampaignProto.ThickContent.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).setMessages(i, builder.build());
            return this;
        }

        public Builder addMessages(CampaignProto.ThickContent thickContent) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(thickContent);
            return this;
        }

        public Builder addMessages(int i, CampaignProto.ThickContent thickContent) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(i, thickContent);
            return this;
        }

        public Builder addMessages(CampaignProto.ThickContent.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(builder.build());
            return this;
        }

        public Builder addMessages(int i, CampaignProto.ThickContent.Builder builder) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addMessages(i, builder.build());
            return this;
        }

        public Builder addAllMessages(Iterable<? extends CampaignProto.ThickContent> iterable) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).addAllMessages(iterable);
            return this;
        }

        public Builder clearMessages() {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).clearMessages();
            return this;
        }

        public Builder removeMessages(int i) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).removeMessages(i);
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponseOrBuilder
        public long getExpirationEpochTimestampMillis() {
            return ((FetchEligibleCampaignsResponse) this.instance).getExpirationEpochTimestampMillis();
        }

        public Builder setExpirationEpochTimestampMillis(long j) {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).setExpirationEpochTimestampMillis(j);
            return this;
        }

        public Builder clearExpirationEpochTimestampMillis() {
            copyOnWrite();
            ((FetchEligibleCampaignsResponse) this.instance).clearExpirationEpochTimestampMillis();
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.FetchEligibleCampaignsResponse$1, reason: invalid class name */
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
                return new FetchEligibleCampaignsResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"messages_", CampaignProto.ThickContent.class, "expirationEpochTimestampMillis_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<FetchEligibleCampaignsResponse> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (FetchEligibleCampaignsResponse.class) {
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
        FetchEligibleCampaignsResponse fetchEligibleCampaignsResponse = new FetchEligibleCampaignsResponse();
        DEFAULT_INSTANCE = fetchEligibleCampaignsResponse;
        GeneratedMessageLite.registerDefaultInstance(FetchEligibleCampaignsResponse.class, fetchEligibleCampaignsResponse);
    }

    public static FetchEligibleCampaignsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<FetchEligibleCampaignsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
