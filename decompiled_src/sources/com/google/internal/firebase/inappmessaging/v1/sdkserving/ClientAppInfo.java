package com.google.internal.firebase.inappmessaging.v1.sdkserving;

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
    public static final int APP_INSTANCE_ID_FIELD_NUMBER = 2;
    public static final int APP_INSTANCE_ID_TOKEN_FIELD_NUMBER = 3;
    private static final ClientAppInfo DEFAULT_INSTANCE;
    public static final int GMP_APP_ID_FIELD_NUMBER = 1;
    private static volatile Parser<ClientAppInfo> PARSER;
    private String gmpAppId_ = "";
    private String appInstanceId_ = "";
    private String appInstanceIdToken_ = "";

    private ClientAppInfo() {
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public String getGmpAppId() {
        return this.gmpAppId_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public ByteString getGmpAppIdBytes() {
        return ByteString.copyFromUtf8(this.gmpAppId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGmpAppId(String str) {
        str.getClass();
        this.gmpAppId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGmpAppId() {
        this.gmpAppId_ = getDefaultInstance().getGmpAppId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGmpAppIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.gmpAppId_ = byteString.toStringUtf8();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public String getAppInstanceId() {
        return this.appInstanceId_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public ByteString getAppInstanceIdBytes() {
        return ByteString.copyFromUtf8(this.appInstanceId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceId(String str) {
        str.getClass();
        this.appInstanceId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppInstanceId() {
        this.appInstanceId_ = getDefaultInstance().getAppInstanceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.appInstanceId_ = byteString.toStringUtf8();
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public String getAppInstanceIdToken() {
        return this.appInstanceIdToken_;
    }

    @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
    public ByteString getAppInstanceIdTokenBytes() {
        return ByteString.copyFromUtf8(this.appInstanceIdToken_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceIdToken(String str) {
        str.getClass();
        this.appInstanceIdToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAppInstanceIdToken() {
        this.appInstanceIdToken_ = getDefaultInstance().getAppInstanceIdToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAppInstanceIdTokenBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.appInstanceIdToken_ = byteString.toStringUtf8();
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

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public String getGmpAppId() {
            return ((ClientAppInfo) this.instance).getGmpAppId();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public ByteString getGmpAppIdBytes() {
            return ((ClientAppInfo) this.instance).getGmpAppIdBytes();
        }

        public Builder setGmpAppId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGmpAppId(str);
            return this;
        }

        public Builder clearGmpAppId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearGmpAppId();
            return this;
        }

        public Builder setGmpAppIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setGmpAppIdBytes(byteString);
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public String getAppInstanceId() {
            return ((ClientAppInfo) this.instance).getAppInstanceId();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public ByteString getAppInstanceIdBytes() {
            return ((ClientAppInfo) this.instance).getAppInstanceIdBytes();
        }

        public Builder setAppInstanceId(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceId(str);
            return this;
        }

        public Builder clearAppInstanceId() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearAppInstanceId();
            return this;
        }

        public Builder setAppInstanceIdBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceIdBytes(byteString);
            return this;
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public String getAppInstanceIdToken() {
            return ((ClientAppInfo) this.instance).getAppInstanceIdToken();
        }

        @Override // com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfoOrBuilder
        public ByteString getAppInstanceIdTokenBytes() {
            return ((ClientAppInfo) this.instance).getAppInstanceIdTokenBytes();
        }

        public Builder setAppInstanceIdToken(String str) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceIdToken(str);
            return this;
        }

        public Builder clearAppInstanceIdToken() {
            copyOnWrite();
            ((ClientAppInfo) this.instance).clearAppInstanceIdToken();
            return this;
        }

        public Builder setAppInstanceIdTokenBytes(ByteString byteString) {
            copyOnWrite();
            ((ClientAppInfo) this.instance).setAppInstanceIdTokenBytes(byteString);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.google.internal.firebase.inappmessaging.v1.sdkserving.ClientAppInfo$1, reason: invalid class name */
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
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"gmpAppId_", "appInstanceId_", "appInstanceIdToken_"});
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
