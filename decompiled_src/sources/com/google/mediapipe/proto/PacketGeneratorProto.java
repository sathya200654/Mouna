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
public final class PacketGeneratorProto {

    @Deprecated
    public interface PacketGeneratorConfigOrBuilder extends MessageLiteOrBuilder {
        String getExternalInput(int index);

        ByteString getExternalInputBytes(int index);

        int getExternalInputCount();

        List<String> getExternalInputList();

        String getExternalOutput(int index);

        ByteString getExternalOutputBytes(int index);

        int getExternalOutputCount();

        List<String> getExternalOutputList();

        String getInputSidePacket(int index);

        ByteString getInputSidePacketBytes(int index);

        int getInputSidePacketCount();

        List<String> getInputSidePacketList();

        PacketGeneratorOptions getOptions();

        String getOutputSidePacket(int index);

        ByteString getOutputSidePacketBytes(int index);

        int getOutputSidePacketCount();

        List<String> getOutputSidePacketList();

        String getPacketGenerator();

        ByteString getPacketGeneratorBytes();

        boolean hasOptions();

        boolean hasPacketGenerator();
    }

    @Deprecated
    public interface PacketGeneratorOptionsOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder<PacketGeneratorOptions, PacketGeneratorOptions.Builder> {
        boolean getMergeFields();

        boolean hasMergeFields();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private PacketGeneratorProto() {
    }

    @Deprecated
    public static final class PacketGeneratorOptions extends GeneratedMessageLite.ExtendableMessage<PacketGeneratorOptions, Builder> implements PacketGeneratorOptionsOrBuilder {
        private static final PacketGeneratorOptions DEFAULT_INSTANCE;
        public static final int MERGE_FIELDS_FIELD_NUMBER = 1;
        private static volatile Parser<PacketGeneratorOptions> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private boolean mergeFields_ = true;

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

        private PacketGeneratorOptions() {
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorOptionsOrBuilder
        public boolean hasMergeFields() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorOptionsOrBuilder
        public boolean getMergeFields() {
            return this.mergeFields_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMergeFields(boolean value) {
            this.bitField0_ |= 1;
            this.mergeFields_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMergeFields() {
            this.bitField0_ &= -2;
            this.mergeFields_ = true;
        }

        public static PacketGeneratorOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketGeneratorOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketGeneratorOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketGeneratorOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketGeneratorOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketGeneratorOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketGeneratorOptions parseFrom(InputStream input) throws IOException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketGeneratorOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketGeneratorOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (PacketGeneratorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketGeneratorOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketGeneratorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketGeneratorOptions parseFrom(CodedInputStream input) throws IOException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketGeneratorOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketGeneratorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder() {
            return (Builder) DEFAULT_INSTANCE.createBuilder();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static Builder newBuilder(PacketGeneratorOptions prototype) {
            return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PacketGeneratorOptions, Builder> implements PacketGeneratorOptionsOrBuilder {
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
                super(PacketGeneratorOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorOptionsOrBuilder
            public boolean hasMergeFields() {
                return ((PacketGeneratorOptions) this.instance).hasMergeFields();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorOptionsOrBuilder
            public boolean getMergeFields() {
                return ((PacketGeneratorOptions) this.instance).getMergeFields();
            }

            public Builder setMergeFields(boolean value) {
                copyOnWrite();
                ((PacketGeneratorOptions) this.instance).setMergeFields(value);
                return this;
            }

            public Builder clearMergeFields() {
                copyOnWrite();
                ((PacketGeneratorOptions) this.instance).clearMergeFields();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new PacketGeneratorOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"bitField0_", "mergeFields_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PacketGeneratorOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PacketGeneratorOptions.class) {
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
            PacketGeneratorOptions packetGeneratorOptions = new PacketGeneratorOptions();
            DEFAULT_INSTANCE = packetGeneratorOptions;
            GeneratedMessageLite.registerDefaultInstance(PacketGeneratorOptions.class, packetGeneratorOptions);
        }

        public static PacketGeneratorOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PacketGeneratorOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.proto.PacketGeneratorProto$1, reason: invalid class name */
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

    @Deprecated
    public static final class PacketGeneratorConfig extends GeneratedMessageLite<PacketGeneratorConfig, Builder> implements PacketGeneratorConfigOrBuilder {
        private static final PacketGeneratorConfig DEFAULT_INSTANCE;
        public static final int EXTERNAL_INPUT_FIELD_NUMBER = 1002;
        public static final int EXTERNAL_OUTPUT_FIELD_NUMBER = 1003;
        public static final int INPUT_SIDE_PACKET_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_SIDE_PACKET_FIELD_NUMBER = 3;
        public static final int PACKET_GENERATOR_FIELD_NUMBER = 1;
        private static volatile Parser<PacketGeneratorConfig> PARSER;
        private int bitField0_;
        private PacketGeneratorOptions options_;
        private byte memoizedIsInitialized = 2;
        private String packetGenerator_ = "";
        private Internal.ProtobufList<String> inputSidePacket_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> externalInput_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> outputSidePacket_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> externalOutput_ = GeneratedMessageLite.emptyProtobufList();

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

        private PacketGeneratorConfig() {
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public boolean hasPacketGenerator() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public String getPacketGenerator() {
            return this.packetGenerator_;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public ByteString getPacketGeneratorBytes() {
            return ByteString.copyFromUtf8(this.packetGenerator_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacketGenerator(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.packetGenerator_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPacketGenerator() {
            this.bitField0_ &= -2;
            this.packetGenerator_ = getDefaultInstance().getPacketGenerator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPacketGeneratorBytes(ByteString value) {
            this.packetGenerator_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public List<String> getInputSidePacketList() {
            return this.inputSidePacket_;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public int getInputSidePacketCount() {
            return this.inputSidePacket_.size();
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public String getInputSidePacket(int index) {
            return this.inputSidePacket_.get(index);
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public ByteString getInputSidePacketBytes(int index) {
            return ByteString.copyFromUtf8(this.inputSidePacket_.get(index));
        }

        private void ensureInputSidePacketIsMutable() {
            Internal.ProtobufList<String> protobufList = this.inputSidePacket_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.inputSidePacket_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputSidePacket(int index, String value) {
            value.getClass();
            ensureInputSidePacketIsMutable();
            this.inputSidePacket_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInputSidePacket(String value) {
            value.getClass();
            ensureInputSidePacketIsMutable();
            this.inputSidePacket_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllInputSidePacket(Iterable<String> values) {
            ensureInputSidePacketIsMutable();
            AbstractMessageLite.addAll(values, this.inputSidePacket_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInputSidePacket() {
            this.inputSidePacket_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInputSidePacketBytes(ByteString value) {
            ensureInputSidePacketIsMutable();
            this.inputSidePacket_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public List<String> getExternalInputList() {
            return this.externalInput_;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public int getExternalInputCount() {
            return this.externalInput_.size();
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public String getExternalInput(int index) {
            return this.externalInput_.get(index);
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public ByteString getExternalInputBytes(int index) {
            return ByteString.copyFromUtf8(this.externalInput_.get(index));
        }

        private void ensureExternalInputIsMutable() {
            Internal.ProtobufList<String> protobufList = this.externalInput_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.externalInput_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExternalInput(int index, String value) {
            value.getClass();
            ensureExternalInputIsMutable();
            this.externalInput_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExternalInput(String value) {
            value.getClass();
            ensureExternalInputIsMutable();
            this.externalInput_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllExternalInput(Iterable<String> values) {
            ensureExternalInputIsMutable();
            AbstractMessageLite.addAll(values, this.externalInput_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExternalInput() {
            this.externalInput_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExternalInputBytes(ByteString value) {
            ensureExternalInputIsMutable();
            this.externalInput_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public List<String> getOutputSidePacketList() {
            return this.outputSidePacket_;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public int getOutputSidePacketCount() {
            return this.outputSidePacket_.size();
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public String getOutputSidePacket(int index) {
            return this.outputSidePacket_.get(index);
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public ByteString getOutputSidePacketBytes(int index) {
            return ByteString.copyFromUtf8(this.outputSidePacket_.get(index));
        }

        private void ensureOutputSidePacketIsMutable() {
            Internal.ProtobufList<String> protobufList = this.outputSidePacket_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.outputSidePacket_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputSidePacket(int index, String value) {
            value.getClass();
            ensureOutputSidePacketIsMutable();
            this.outputSidePacket_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOutputSidePacket(String value) {
            value.getClass();
            ensureOutputSidePacketIsMutable();
            this.outputSidePacket_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllOutputSidePacket(Iterable<String> values) {
            ensureOutputSidePacketIsMutable();
            AbstractMessageLite.addAll(values, this.outputSidePacket_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputSidePacket() {
            this.outputSidePacket_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addOutputSidePacketBytes(ByteString value) {
            ensureOutputSidePacketIsMutable();
            this.outputSidePacket_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public List<String> getExternalOutputList() {
            return this.externalOutput_;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public int getExternalOutputCount() {
            return this.externalOutput_.size();
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public String getExternalOutput(int index) {
            return this.externalOutput_.get(index);
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public ByteString getExternalOutputBytes(int index) {
            return ByteString.copyFromUtf8(this.externalOutput_.get(index));
        }

        private void ensureExternalOutputIsMutable() {
            Internal.ProtobufList<String> protobufList = this.externalOutput_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.externalOutput_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExternalOutput(int index, String value) {
            value.getClass();
            ensureExternalOutputIsMutable();
            this.externalOutput_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExternalOutput(String value) {
            value.getClass();
            ensureExternalOutputIsMutable();
            this.externalOutput_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllExternalOutput(Iterable<String> values) {
            ensureExternalOutputIsMutable();
            AbstractMessageLite.addAll(values, this.externalOutput_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExternalOutput() {
            this.externalOutput_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addExternalOutputBytes(ByteString value) {
            ensureExternalOutputIsMutable();
            this.externalOutput_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
        public PacketGeneratorOptions getOptions() {
            PacketGeneratorOptions packetGeneratorOptions = this.options_;
            return packetGeneratorOptions == null ? PacketGeneratorOptions.getDefaultInstance() : packetGeneratorOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(PacketGeneratorOptions value) {
            value.getClass();
            this.options_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(PacketGeneratorOptions value) {
            value.getClass();
            PacketGeneratorOptions packetGeneratorOptions = this.options_;
            if (packetGeneratorOptions != null && packetGeneratorOptions != PacketGeneratorOptions.getDefaultInstance()) {
                this.options_ = (PacketGeneratorOptions) ((PacketGeneratorOptions.Builder) PacketGeneratorOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
            } else {
                this.options_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOptions() {
            this.options_ = null;
            this.bitField0_ &= -3;
        }

        public static PacketGeneratorConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketGeneratorConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketGeneratorConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketGeneratorConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketGeneratorConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PacketGeneratorConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PacketGeneratorConfig parseFrom(InputStream input) throws IOException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketGeneratorConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketGeneratorConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (PacketGeneratorConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketGeneratorConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketGeneratorConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PacketGeneratorConfig parseFrom(CodedInputStream input) throws IOException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PacketGeneratorConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PacketGeneratorConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PacketGeneratorConfig prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PacketGeneratorConfig, Builder> implements PacketGeneratorConfigOrBuilder {
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
                super(PacketGeneratorConfig.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public boolean hasPacketGenerator() {
                return ((PacketGeneratorConfig) this.instance).hasPacketGenerator();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public String getPacketGenerator() {
                return ((PacketGeneratorConfig) this.instance).getPacketGenerator();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public ByteString getPacketGeneratorBytes() {
                return ((PacketGeneratorConfig) this.instance).getPacketGeneratorBytes();
            }

            public Builder setPacketGenerator(String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setPacketGenerator(value);
                return this;
            }

            public Builder clearPacketGenerator() {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).clearPacketGenerator();
                return this;
            }

            public Builder setPacketGeneratorBytes(ByteString value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setPacketGeneratorBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public List<String> getInputSidePacketList() {
                return Collections.unmodifiableList(((PacketGeneratorConfig) this.instance).getInputSidePacketList());
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public int getInputSidePacketCount() {
                return ((PacketGeneratorConfig) this.instance).getInputSidePacketCount();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public String getInputSidePacket(int index) {
                return ((PacketGeneratorConfig) this.instance).getInputSidePacket(index);
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public ByteString getInputSidePacketBytes(int index) {
                return ((PacketGeneratorConfig) this.instance).getInputSidePacketBytes(index);
            }

            public Builder setInputSidePacket(int index, String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setInputSidePacket(index, value);
                return this;
            }

            public Builder addInputSidePacket(String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addInputSidePacket(value);
                return this;
            }

            public Builder addAllInputSidePacket(Iterable<String> values) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addAllInputSidePacket(values);
                return this;
            }

            public Builder clearInputSidePacket() {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).clearInputSidePacket();
                return this;
            }

            public Builder addInputSidePacketBytes(ByteString value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addInputSidePacketBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public List<String> getExternalInputList() {
                return Collections.unmodifiableList(((PacketGeneratorConfig) this.instance).getExternalInputList());
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public int getExternalInputCount() {
                return ((PacketGeneratorConfig) this.instance).getExternalInputCount();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public String getExternalInput(int index) {
                return ((PacketGeneratorConfig) this.instance).getExternalInput(index);
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public ByteString getExternalInputBytes(int index) {
                return ((PacketGeneratorConfig) this.instance).getExternalInputBytes(index);
            }

            public Builder setExternalInput(int index, String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setExternalInput(index, value);
                return this;
            }

            public Builder addExternalInput(String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addExternalInput(value);
                return this;
            }

            public Builder addAllExternalInput(Iterable<String> values) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addAllExternalInput(values);
                return this;
            }

            public Builder clearExternalInput() {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).clearExternalInput();
                return this;
            }

            public Builder addExternalInputBytes(ByteString value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addExternalInputBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public List<String> getOutputSidePacketList() {
                return Collections.unmodifiableList(((PacketGeneratorConfig) this.instance).getOutputSidePacketList());
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public int getOutputSidePacketCount() {
                return ((PacketGeneratorConfig) this.instance).getOutputSidePacketCount();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public String getOutputSidePacket(int index) {
                return ((PacketGeneratorConfig) this.instance).getOutputSidePacket(index);
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public ByteString getOutputSidePacketBytes(int index) {
                return ((PacketGeneratorConfig) this.instance).getOutputSidePacketBytes(index);
            }

            public Builder setOutputSidePacket(int index, String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setOutputSidePacket(index, value);
                return this;
            }

            public Builder addOutputSidePacket(String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addOutputSidePacket(value);
                return this;
            }

            public Builder addAllOutputSidePacket(Iterable<String> values) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addAllOutputSidePacket(values);
                return this;
            }

            public Builder clearOutputSidePacket() {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).clearOutputSidePacket();
                return this;
            }

            public Builder addOutputSidePacketBytes(ByteString value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addOutputSidePacketBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public List<String> getExternalOutputList() {
                return Collections.unmodifiableList(((PacketGeneratorConfig) this.instance).getExternalOutputList());
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public int getExternalOutputCount() {
                return ((PacketGeneratorConfig) this.instance).getExternalOutputCount();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public String getExternalOutput(int index) {
                return ((PacketGeneratorConfig) this.instance).getExternalOutput(index);
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public ByteString getExternalOutputBytes(int index) {
                return ((PacketGeneratorConfig) this.instance).getExternalOutputBytes(index);
            }

            public Builder setExternalOutput(int index, String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setExternalOutput(index, value);
                return this;
            }

            public Builder addExternalOutput(String value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addExternalOutput(value);
                return this;
            }

            public Builder addAllExternalOutput(Iterable<String> values) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addAllExternalOutput(values);
                return this;
            }

            public Builder clearExternalOutput() {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).clearExternalOutput();
                return this;
            }

            public Builder addExternalOutputBytes(ByteString value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).addExternalOutputBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public boolean hasOptions() {
                return ((PacketGeneratorConfig) this.instance).hasOptions();
            }

            @Override // com.google.mediapipe.proto.PacketGeneratorProto.PacketGeneratorConfigOrBuilder
            public PacketGeneratorOptions getOptions() {
                return ((PacketGeneratorConfig) this.instance).getOptions();
            }

            public Builder setOptions(PacketGeneratorOptions value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(PacketGeneratorOptions.Builder builderForValue) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).setOptions((PacketGeneratorOptions) builderForValue.build());
                return this;
            }

            public Builder mergeOptions(PacketGeneratorOptions value) {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((PacketGeneratorConfig) this.instance).clearOptions();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new PacketGeneratorConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"bitField0_", "packetGenerator_", "inputSidePacket_", "outputSidePacket_", "options_", "externalInput_", "externalOutput_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PacketGeneratorConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PacketGeneratorConfig.class) {
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
            PacketGeneratorConfig packetGeneratorConfig = new PacketGeneratorConfig();
            DEFAULT_INSTANCE = packetGeneratorConfig;
            GeneratedMessageLite.registerDefaultInstance(PacketGeneratorConfig.class, packetGeneratorConfig);
        }

        public static PacketGeneratorConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PacketGeneratorConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
