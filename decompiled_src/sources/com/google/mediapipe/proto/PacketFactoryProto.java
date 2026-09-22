package com.google.mediapipe.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class PacketFactoryProto {

    public interface PacketFactoryConfigOrBuilder extends MessageLiteOrBuilder {
        String getExternalOutput();

        ByteString getExternalOutputBytes();

        PacketFactoryOptions getOptions();

        String getOutputSidePacket();

        ByteString getOutputSidePacketBytes();

        String getPacketFactory();

        ByteString getPacketFactoryBytes();

        boolean hasExternalOutput();

        boolean hasOptions();

        boolean hasOutputSidePacket();

        boolean hasPacketFactory();
    }

    public interface PacketFactoryOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<PacketFactoryOptions, PacketFactoryOptions.Builder> {
    }

    public interface PacketManagerConfigOrBuilder extends MessageLiteOrBuilder {
        PacketFactoryConfig getPacket(int index);

        int getPacketCount();

        List<PacketFactoryConfig> getPacketList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private PacketFactoryProto() {
    }

    public static final class PacketFactoryOptions extends GeneratedMessageLite.ExtendableMessage<PacketFactoryOptions, Builder> implements PacketFactoryOptionsOrBuilder {
        private static final PacketFactoryOptions DEFAULT_INSTANCE;
        private static volatile Parser<PacketFactoryOptions> PARSER;
        private byte memoizedIsInitialized = 2;

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessage, com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessage, com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessage, com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private PacketFactoryOptions() {
        }

        public static PacketFactoryOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketFactoryOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketFactoryOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketFactoryOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketFactoryOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketFactoryOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketFactoryOptions parseFrom(InputStream input) throws IOException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketFactoryOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketFactoryOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (PacketFactoryOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketFactoryOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketFactoryOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketFactoryOptions parseFrom(CodedInputStream input) throws IOException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketFactoryOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketFactoryOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(PacketFactoryOptions prototype) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PacketFactoryOptions, Builder> implements PacketFactoryOptionsOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.ExtendableBuilder, com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.ExtendableBuilder, com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                return super.internalMergeFrom((GeneratedMessageLite) message);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                return super.mergeFrom(other);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            private Builder() {
                super(PacketFactoryOptions.DEFAULT_INSTANCE);
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new PacketFactoryOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0000", null);
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PacketFactoryOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PacketFactoryOptions.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PacketFactoryOptions packetFactoryOptions = new PacketFactoryOptions();
            DEFAULT_INSTANCE = packetFactoryOptions;
            GeneratedMessageLite.registerDefaultInstance(PacketFactoryOptions.class, packetFactoryOptions);
        }

        public static PacketFactoryOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PacketFactoryOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.proto.PacketFactoryProto$1, reason: invalid class name */
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

    public static final class PacketFactoryConfig extends GeneratedMessageLite<PacketFactoryConfig, Builder> implements PacketFactoryConfigOrBuilder {
        private static final PacketFactoryConfig DEFAULT_INSTANCE;
        public static final int EXTERNAL_OUTPUT_FIELD_NUMBER = 1002;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int OUTPUT_SIDE_PACKET_FIELD_NUMBER = 2;
        public static final int PACKET_FACTORY_FIELD_NUMBER = 1;
        private static volatile Parser<PacketFactoryConfig> PARSER;
        private int bitField0_;
        private PacketFactoryOptions options_;
        private byte memoizedIsInitialized = 2;
        private String packetFactory_ = "";
        private String outputSidePacket_ = "";
        private String externalOutput_ = "";

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private PacketFactoryConfig() {
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public boolean hasPacketFactory() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public String getPacketFactory() {
            return this.packetFactory_;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public ByteString getPacketFactoryBytes() {
            return ByteString.copyFromUtf8(this.packetFactory_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacketFactory(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.packetFactory_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPacketFactory() {
            this.bitField0_ &= -2;
            this.packetFactory_ = getDefaultInstance().getPacketFactory();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacketFactoryBytes(ByteString value) {
            this.packetFactory_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public boolean hasOutputSidePacket() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public String getOutputSidePacket() {
            return this.outputSidePacket_;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public ByteString getOutputSidePacketBytes() {
            return ByteString.copyFromUtf8(this.outputSidePacket_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputSidePacket(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.outputSidePacket_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputSidePacket() {
            this.bitField0_ &= -3;
            this.outputSidePacket_ = getDefaultInstance().getOutputSidePacket();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputSidePacketBytes(ByteString value) {
            this.outputSidePacket_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public boolean hasExternalOutput() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public String getExternalOutput() {
            return this.externalOutput_;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public ByteString getExternalOutputBytes() {
            return ByteString.copyFromUtf8(this.externalOutput_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExternalOutput(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.externalOutput_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExternalOutput() {
            this.bitField0_ &= -5;
            this.externalOutput_ = getDefaultInstance().getExternalOutput();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExternalOutputBytes(ByteString value) {
            this.externalOutput_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
        public PacketFactoryOptions getOptions() {
            PacketFactoryOptions packetFactoryOptions = this.options_;
            return packetFactoryOptions == null ? PacketFactoryOptions.getDefaultInstance() : packetFactoryOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(PacketFactoryOptions value) {
            value.getClass();
            this.options_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(PacketFactoryOptions value) {
            value.getClass();
            PacketFactoryOptions packetFactoryOptions = this.options_;
            if (packetFactoryOptions != null && packetFactoryOptions != PacketFactoryOptions.getDefaultInstance()) {
                this.options_ = (PacketFactoryOptions) ((PacketFactoryOptions.Builder) PacketFactoryOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            } else {
                this.options_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -9;
        }

        public static PacketFactoryConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketFactoryConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketFactoryConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketFactoryConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketFactoryConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketFactoryConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketFactoryConfig parseFrom(InputStream input) throws IOException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketFactoryConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketFactoryConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (PacketFactoryConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketFactoryConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketFactoryConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketFactoryConfig parseFrom(CodedInputStream input) throws IOException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketFactoryConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketFactoryConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PacketFactoryConfig prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PacketFactoryConfig, Builder> implements PacketFactoryConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                return super.internalMergeFrom((GeneratedMessageLite) message);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                return super.mergeFrom(other);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            private Builder() {
                super(PacketFactoryConfig.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public boolean hasPacketFactory() {
                return ((PacketFactoryConfig) this.instance).hasPacketFactory();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public String getPacketFactory() {
                return ((PacketFactoryConfig) this.instance).getPacketFactory();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public ByteString getPacketFactoryBytes() {
                return ((PacketFactoryConfig) this.instance).getPacketFactoryBytes();
            }

            public Builder setPacketFactory(String value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setPacketFactory(value);
                return this;
            }

            public Builder clearPacketFactory() {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).clearPacketFactory();
                return this;
            }

            public Builder setPacketFactoryBytes(ByteString value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setPacketFactoryBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public boolean hasOutputSidePacket() {
                return ((PacketFactoryConfig) this.instance).hasOutputSidePacket();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public String getOutputSidePacket() {
                return ((PacketFactoryConfig) this.instance).getOutputSidePacket();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public ByteString getOutputSidePacketBytes() {
                return ((PacketFactoryConfig) this.instance).getOutputSidePacketBytes();
            }

            public Builder setOutputSidePacket(String value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setOutputSidePacket(value);
                return this;
            }

            public Builder clearOutputSidePacket() {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).clearOutputSidePacket();
                return this;
            }

            public Builder setOutputSidePacketBytes(ByteString value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setOutputSidePacketBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public boolean hasExternalOutput() {
                return ((PacketFactoryConfig) this.instance).hasExternalOutput();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public String getExternalOutput() {
                return ((PacketFactoryConfig) this.instance).getExternalOutput();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public ByteString getExternalOutputBytes() {
                return ((PacketFactoryConfig) this.instance).getExternalOutputBytes();
            }

            public Builder setExternalOutput(String value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setExternalOutput(value);
                return this;
            }

            public Builder clearExternalOutput() {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).clearExternalOutput();
                return this;
            }

            public Builder setExternalOutputBytes(ByteString value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setExternalOutputBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public boolean hasOptions() {
                return ((PacketFactoryConfig) this.instance).hasOptions();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketFactoryConfigOrBuilder
            public PacketFactoryOptions getOptions() {
                return ((PacketFactoryConfig) this.instance).getOptions();
            }

            public Builder setOptions(PacketFactoryOptions value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(PacketFactoryOptions.Builder builderForValue) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).setOptions((PacketFactoryOptions) builderForValue.build());
                return this;
            }

            public Builder mergeOptions(PacketFactoryOptions value) {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((PacketFactoryConfig) this.instance).clearOptions();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new PacketFactoryConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ᐉ\u0003Ϫဈ\u0002", new Object[]{"bitField0_", "packetFactory_", "outputSidePacket_", "options_", "externalOutput_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PacketFactoryConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PacketFactoryConfig.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PacketFactoryConfig packetFactoryConfig = new PacketFactoryConfig();
            DEFAULT_INSTANCE = packetFactoryConfig;
            GeneratedMessageLite.registerDefaultInstance(PacketFactoryConfig.class, packetFactoryConfig);
        }

        public static PacketFactoryConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PacketFactoryConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class PacketManagerConfig extends GeneratedMessageLite<PacketManagerConfig, Builder> implements PacketManagerConfigOrBuilder {
        private static final PacketManagerConfig DEFAULT_INSTANCE;
        public static final int PACKET_FIELD_NUMBER = 1;
        private static volatile Parser<PacketManagerConfig> PARSER;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<PacketFactoryConfig> packet_ = emptyProtobufList();

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return super.toBuilder();
        }

        private PacketManagerConfig() {
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketManagerConfigOrBuilder
        public List<PacketFactoryConfig> getPacketList() {
            return this.packet_;
        }

        public List<? extends PacketFactoryConfigOrBuilder> getPacketOrBuilderList() {
            return this.packet_;
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketManagerConfigOrBuilder
        public int getPacketCount() {
            return this.packet_.size();
        }

        @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketManagerConfigOrBuilder
        public PacketFactoryConfig getPacket(int index) {
            return this.packet_.get(index);
        }

        public PacketFactoryConfigOrBuilder getPacketOrBuilder(int index) {
            return this.packet_.get(index);
        }

        private void ensurePacketIsMutable() {
            Internal.ProtobufList<PacketFactoryConfig> protobufList = this.packet_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.packet_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacket(int index, PacketFactoryConfig value) {
            value.getClass();
            ensurePacketIsMutable();
            this.packet_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPacket(PacketFactoryConfig value) {
            value.getClass();
            ensurePacketIsMutable();
            this.packet_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPacket(int index, PacketFactoryConfig value) {
            value.getClass();
            ensurePacketIsMutable();
            this.packet_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPacket(Iterable<? extends PacketFactoryConfig> values) {
            ensurePacketIsMutable();
            AbstractMessageLite.addAll(values, this.packet_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPacket() {
            this.packet_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePacket(int index) {
            ensurePacketIsMutable();
            this.packet_.remove(index);
        }

        public static PacketManagerConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketManagerConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketManagerConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketManagerConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketManagerConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketManagerConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketManagerConfig parseFrom(InputStream input) throws IOException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketManagerConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketManagerConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (PacketManagerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketManagerConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketManagerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketManagerConfig parseFrom(CodedInputStream input) throws IOException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketManagerConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketManagerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PacketManagerConfig prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PacketManagerConfig, Builder> implements PacketManagerConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return super.build();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return super.buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return super.clear();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ MessageLite.Builder mo2196clone() {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo2196clone() throws CloneNotSupportedException {
                return super.mo2196clone();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return super.getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            protected /* bridge */ /* synthetic */ AbstractMessageLite.Builder internalMergeFrom(AbstractMessageLite message) {
                return super.internalMergeFrom((GeneratedMessageLite) message);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final ByteString data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final CodedInputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final MessageLite other) {
                return super.mergeFrom(other);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input) throws IOException {
                return super.mergeFrom(input);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final InputStream input, final ExtensionRegistryLite extensionRegistry) throws IOException {
                return super.mergeFrom(input, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data) throws InvalidProtocolBufferException {
                return super.mergeFrom(data);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] input, int offset, int length, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(input, offset, length, extensionRegistry);
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(final byte[] data, final ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return super.mergeFrom(data, extensionRegistry);
            }

            private Builder() {
                super(PacketManagerConfig.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketManagerConfigOrBuilder
            public List<PacketFactoryConfig> getPacketList() {
                return Collections.unmodifiableList(((PacketManagerConfig) this.instance).getPacketList());
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketManagerConfigOrBuilder
            public int getPacketCount() {
                return ((PacketManagerConfig) this.instance).getPacketCount();
            }

            @Override // com.google.mediapipe.proto.PacketFactoryProto.PacketManagerConfigOrBuilder
            public PacketFactoryConfig getPacket(int index) {
                return ((PacketManagerConfig) this.instance).getPacket(index);
            }

            public Builder setPacket(int index, PacketFactoryConfig value) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).setPacket(index, value);
                return this;
            }

            public Builder setPacket(int index, PacketFactoryConfig.Builder builderForValue) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).setPacket(index, (PacketFactoryConfig) builderForValue.build());
                return this;
            }

            public Builder addPacket(PacketFactoryConfig value) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).addPacket(value);
                return this;
            }

            public Builder addPacket(int index, PacketFactoryConfig value) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).addPacket(index, value);
                return this;
            }

            public Builder addPacket(PacketFactoryConfig.Builder builderForValue) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).addPacket((PacketFactoryConfig) builderForValue.build());
                return this;
            }

            public Builder addPacket(int index, PacketFactoryConfig.Builder builderForValue) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).addPacket(index, (PacketFactoryConfig) builderForValue.build());
                return this;
            }

            public Builder addAllPacket(Iterable<? extends PacketFactoryConfig> values) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).addAllPacket(values);
                return this;
            }

            public Builder clearPacket() {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).clearPacket();
                return this;
            }

            public Builder removePacket(int index) {
                copyOnWrite();
                ((PacketManagerConfig) this.instance).removePacket(index);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new PacketManagerConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"packet_", PacketFactoryConfig.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PacketManagerConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PacketManagerConfig.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            PacketManagerConfig packetManagerConfig = new PacketManagerConfig();
            DEFAULT_INSTANCE = packetManagerConfig;
            GeneratedMessageLite.registerDefaultInstance(PacketManagerConfig.class, packetManagerConfig);
        }

        public static PacketManagerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PacketManagerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
