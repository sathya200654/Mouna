package com.google.internal.firebase.inappmessaging.v1.sdkserving;

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
public final class CampaignImpressionList extends GeneratedMessageLite<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
    public static final int ALREADY_SEEN_CAMPAIGNS_FIELD_NUMBER = 1;
    private static final CampaignImpressionList DEFAULT_INSTANCE;
    private static volatile Parser<CampaignImpressionList> PARSER;
    private Internal.ProtobufList<CampaignImpression> alreadySeenCampaigns_ = emptyProtobufList();

    private CampaignImpressionList() {
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
    public List<CampaignImpression> getAlreadySeenCampaignsList() {
        return this.alreadySeenCampaigns_;
    }

    public List<? extends CampaignImpressionOrBuilder> getAlreadySeenCampaignsOrBuilderList() {
        return this.alreadySeenCampaigns_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
    public int getAlreadySeenCampaignsCount() {
        return this.alreadySeenCampaigns_.size();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
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

    public static CampaignImpressionList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static CampaignImpressionList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CampaignImpressionList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CampaignImpressionList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(InputStream inputStream) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpressionList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CampaignImpressionList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CampaignImpressionList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpressionList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CampaignImpressionList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CampaignImpressionList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CampaignImpressionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(CampaignImpressionList campaignImpressionList) {
        return DEFAULT_INSTANCE.createBuilder(campaignImpressionList);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<CampaignImpressionList, Builder> implements CampaignImpressionListOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(CampaignImpressionList.DEFAULT_INSTANCE);
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
        public List<CampaignImpression> getAlreadySeenCampaignsList() {
            return Collections.unmodifiableList(((CampaignImpressionList) this.instance).getAlreadySeenCampaignsList());
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
        public int getAlreadySeenCampaignsCount() {
            return ((CampaignImpressionList) this.instance).getAlreadySeenCampaignsCount();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionListOrBuilder
        public CampaignImpression getAlreadySeenCampaigns(int i) {
            return ((CampaignImpressionList) this.instance).getAlreadySeenCampaigns(i);
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).setAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder setAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).setAlreadySeenCampaigns(i, builder.build());
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression campaignImpression) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression campaignImpression) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(i, campaignImpression);
            return this;
        }

        public Builder addAlreadySeenCampaigns(CampaignImpression.Builder builder) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(builder.build());
            return this;
        }

        public Builder addAlreadySeenCampaigns(int i, CampaignImpression.Builder builder) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAlreadySeenCampaigns(i, builder.build());
            return this;
        }

        public Builder addAllAlreadySeenCampaigns(Iterable<? extends CampaignImpression> iterable) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).addAllAlreadySeenCampaigns(iterable);
            return this;
        }

        public Builder clearAlreadySeenCampaigns() {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).clearAlreadySeenCampaigns();
            return this;
        }

        public Builder removeAlreadySeenCampaigns(int i) {
            copyOnWrite();
            ((CampaignImpressionList) this.instance).removeAlreadySeenCampaigns(i);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.CampaignImpressionList$1, reason: invalid class name */
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
                return new CampaignImpressionList();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"alreadySeenCampaigns_", CampaignImpression.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CampaignImpressionList> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (CampaignImpressionList.class) {
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
        CampaignImpressionList campaignImpressionList = new CampaignImpressionList();
        DEFAULT_INSTANCE = campaignImpressionList;
        GeneratedMessageLite.registerDefaultInstance(CampaignImpressionList.class, campaignImpressionList);
    }

    public static CampaignImpressionList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CampaignImpressionList> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
