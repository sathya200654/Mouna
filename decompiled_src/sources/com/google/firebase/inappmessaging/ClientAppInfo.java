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
public final class ClientAppInfo extends GeneratedMessageLite<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
    private static final ClientAppInfo DEFAULT_INSTANCE;
    public static final int FIREBASE_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int GOOGLE_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAppInfo> PARSER;
    private int bitField0_;
    private String googleAppId_ = "";
    private String firebaseInstanceId_ = "";

    private ClientAppInfo() {
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public boolean hasGoogleAppId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public String getGoogleAppId() {
        return this.googleAppId_;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public ByteString getGoogleAppIdBytes() {
        return ByteString.copyFromUtf8(this.googleAppId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoogleAppId(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.googleAppId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGoogleAppId() {
        this.bitField0_ &= -2;
        this.googleAppId_ = getDefaultInstance().getGoogleAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGoogleAppIdBytes(ByteString byteString) {
        this.googleAppId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public boolean hasFirebaseInstanceId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public String getFirebaseInstanceId() {
        return this.firebaseInstanceId_;
    }

    @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
    public ByteString getFirebaseInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.firebaseInstanceId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirebaseInstanceId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.firebaseInstanceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFirebaseInstanceId() {
        this.bitField0_ &= -3;
        this.firebaseInstanceId_ = getDefaultInstance().getFirebaseInstanceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFirebaseInstanceIdBytes(ByteString byteString) {
        this.firebaseInstanceId_ = byteString.toStringUtf8();
        this.bitField0_ |= 2;
    }

    public static ClientAppInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ClientAppInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientAppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientAppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(InputStream inputStream) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientAppInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientAppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAppInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientAppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientAppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientAppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ClientAppInfo clientAppInfo) {
        return DEFAULT_INSTANCE.createBuilder(clientAppInfo);
    }

    public static final class Builder extends GeneratedMessageLite.Builder<ClientAppInfo, Builder> implements ClientAppInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(ClientAppInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public boolean hasGoogleAppId() {
            return ((ClientAppInfo) this.instance).hasGoogleAppId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public String getGoogleAppId() {
            return ((ClientAppInfo) this.instance).getGoogleAppId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public ByteString getGoogleAppIdBytes() {
            return ((ClientAppInfo) this.instance).getGoogleAppIdBytes();
        }

        public Builder setGoogleAppId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGoogleAppId(str);
            return this;
        }

        public Builder clearGoogleAppId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearGoogleAppId();
            return this;
        }

        public Builder setGoogleAppIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGoogleAppIdBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public boolean hasFirebaseInstanceId() {
            return ((ClientAppInfo) this.instance).hasFirebaseInstanceId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public String getFirebaseInstanceId() {
            return ((ClientAppInfo) this.instance).getFirebaseInstanceId();
        }

        @Override // com.google.firebase.inappmessaging.ClientAppInfoOrBuilder
        public ByteString getFirebaseInstanceIdBytes() {
            return ((ClientAppInfo) this.instance).getFirebaseInstanceIdBytes();
        }

        public Builder setFirebaseInstanceId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setFirebaseInstanceId(str);
            return this;
        }

        public Builder clearFirebaseInstanceId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearFirebaseInstanceId();
            return this;
        }

        public Builder setFirebaseInstanceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setFirebaseInstanceIdBytes(byteString);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.inappmessaging.ClientAppInfo$1, reason: invalid class name */
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
                return new ClientAppInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"bitField0_", "googleAppId_", "firebaseInstanceId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientAppInfo> parser = PARSER;
                if (parser != null) {
                    return parser;
                }
                synchronized (ClientAppInfo.class) {
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
        ClientAppInfo clientAppInfo = new ClientAppInfo();
        DEFAULT_INSTANCE = clientAppInfo;
        GeneratedMessageLite.registerDefaultInstance(ClientAppInfo.class, clientAppInfo);
    }

    public static ClientAppInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ClientAppInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
