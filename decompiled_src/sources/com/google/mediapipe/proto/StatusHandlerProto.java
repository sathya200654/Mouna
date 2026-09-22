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
public final class StatusHandlerProto {

    public interface StatusHandlerConfigOrBuilder extends MessageLiteOrBuilder {
        String getExternalInput(int index);

        ByteString getExternalInputBytes(int index);

        int getExternalInputCount();

        List<String> getExternalInputList();

        String getInputSidePacket(int index);

        ByteString getInputSidePacketBytes(int index);

        int getInputSidePacketCount();

        List<String> getInputSidePacketList();

        MediaPipeOptionsProto.MediaPipeOptions getOptions();

        String getStatusHandler();

        ByteString getStatusHandlerBytes();

        boolean hasOptions();

        boolean hasStatusHandler();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private StatusHandlerProto() {
    }

    public static final class StatusHandlerConfig extends GeneratedMessageLite<StatusHandlerConfig, Builder> implements StatusHandlerConfigOrBuilder {
        private static final StatusHandlerConfig DEFAULT_INSTANCE;
        public static final int EXTERNAL_INPUT_FIELD_NUMBER = 1002;
        public static final int INPUT_SIDE_PACKET_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<StatusHandlerConfig> PARSER = null;
        public static final int STATUS_HANDLER_FIELD_NUMBER = 1;
        private int bitField0_;
        private MediaPipeOptionsProto.MediaPipeOptions options_;
        private byte memoizedIsInitialized = 2;
        private String statusHandler_ = "";
        private Internal.ProtobufList<String> inputSidePacket_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> externalInput_ = GeneratedMessageLite.emptyProtobufList();

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

        private StatusHandlerConfig() {
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public boolean hasStatusHandler() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public String getStatusHandler() {
            return this.statusHandler_;
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public ByteString getStatusHandlerBytes() {
            return ByteString.copyFromUtf8(this.statusHandler_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusHandler(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.statusHandler_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatusHandler() {
            this.bitField0_ &= -2;
            this.statusHandler_ = getDefaultInstance().getStatusHandler();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatusHandlerBytes(ByteString value) {
            this.statusHandler_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public List<String> getInputSidePacketList() {
            return this.inputSidePacket_;
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public int getInputSidePacketCount() {
            return this.inputSidePacket_.size();
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public String getInputSidePacket(int index) {
            return this.inputSidePacket_.get(index);
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
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

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public List<String> getExternalInputList() {
            return this.externalInput_;
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public int getExternalInputCount() {
            return this.externalInput_.size();
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public String getExternalInput(int index) {
            return this.externalInput_.get(index);
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
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

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
        public MediaPipeOptionsProto.MediaPipeOptions getOptions() {
            MediaPipeOptionsProto.MediaPipeOptions mediaPipeOptions = this.options_;
            return mediaPipeOptions == null ? MediaPipeOptionsProto.MediaPipeOptions.getDefaultInstance() : mediaPipeOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
            value.getClass();
            this.options_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void mergeOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
            value.getClass();
            MediaPipeOptionsProto.MediaPipeOptions mediaPipeOptions = this.options_;
            if (mediaPipeOptions != null && mediaPipeOptions != MediaPipeOptionsProto.MediaPipeOptions.getDefaultInstance()) {
                this.options_ = (MediaPipeOptionsProto.MediaPipeOptions) ((MediaPipeOptionsProto.MediaPipeOptions.Builder) MediaPipeOptionsProto.MediaPipeOptions.newBuilder(this.options_).mergeFrom(value)).buildPartial();
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

        public static StatusHandlerConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static StatusHandlerConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static StatusHandlerConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static StatusHandlerConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static StatusHandlerConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static StatusHandlerConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static StatusHandlerConfig parseFrom(InputStream input) throws IOException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static StatusHandlerConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static StatusHandlerConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (StatusHandlerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static StatusHandlerConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StatusHandlerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static StatusHandlerConfig parseFrom(CodedInputStream input) throws IOException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static StatusHandlerConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (StatusHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(StatusHandlerConfig prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<StatusHandlerConfig, Builder> implements StatusHandlerConfigOrBuilder {
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
                super(StatusHandlerConfig.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public boolean hasStatusHandler() {
                return ((StatusHandlerConfig) this.instance).hasStatusHandler();
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public String getStatusHandler() {
                return ((StatusHandlerConfig) this.instance).getStatusHandler();
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public ByteString getStatusHandlerBytes() {
                return ((StatusHandlerConfig) this.instance).getStatusHandlerBytes();
            }

            public Builder setStatusHandler(String value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).setStatusHandler(value);
                return this;
            }

            public Builder clearStatusHandler() {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).clearStatusHandler();
                return this;
            }

            public Builder setStatusHandlerBytes(ByteString value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).setStatusHandlerBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public List<String> getInputSidePacketList() {
                return Collections.unmodifiableList(((StatusHandlerConfig) this.instance).getInputSidePacketList());
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public int getInputSidePacketCount() {
                return ((StatusHandlerConfig) this.instance).getInputSidePacketCount();
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public String getInputSidePacket(int index) {
                return ((StatusHandlerConfig) this.instance).getInputSidePacket(index);
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public ByteString getInputSidePacketBytes(int index) {
                return ((StatusHandlerConfig) this.instance).getInputSidePacketBytes(index);
            }

            public Builder setInputSidePacket(int index, String value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).setInputSidePacket(index, value);
                return this;
            }

            public Builder addInputSidePacket(String value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).addInputSidePacket(value);
                return this;
            }

            public Builder addAllInputSidePacket(Iterable<String> values) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).addAllInputSidePacket(values);
                return this;
            }

            public Builder clearInputSidePacket() {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).clearInputSidePacket();
                return this;
            }

            public Builder addInputSidePacketBytes(ByteString value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).addInputSidePacketBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public List<String> getExternalInputList() {
                return Collections.unmodifiableList(((StatusHandlerConfig) this.instance).getExternalInputList());
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public int getExternalInputCount() {
                return ((StatusHandlerConfig) this.instance).getExternalInputCount();
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public String getExternalInput(int index) {
                return ((StatusHandlerConfig) this.instance).getExternalInput(index);
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public ByteString getExternalInputBytes(int index) {
                return ((StatusHandlerConfig) this.instance).getExternalInputBytes(index);
            }

            public Builder setExternalInput(int index, String value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).setExternalInput(index, value);
                return this;
            }

            public Builder addExternalInput(String value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).addExternalInput(value);
                return this;
            }

            public Builder addAllExternalInput(Iterable<String> values) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).addAllExternalInput(values);
                return this;
            }

            public Builder clearExternalInput() {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).clearExternalInput();
                return this;
            }

            public Builder addExternalInputBytes(ByteString value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).addExternalInputBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public boolean hasOptions() {
                return ((StatusHandlerConfig) this.instance).hasOptions();
            }

            @Override // com.google.mediapipe.proto.StatusHandlerProto.StatusHandlerConfigOrBuilder
            public MediaPipeOptionsProto.MediaPipeOptions getOptions() {
                return ((StatusHandlerConfig) this.instance).getOptions();
            }

            public Builder setOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(MediaPipeOptionsProto.MediaPipeOptions.Builder builderForValue) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).setOptions((MediaPipeOptionsProto.MediaPipeOptions) builderForValue.build());
                return this;
            }

            public Builder mergeOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((StatusHandlerConfig) this.instance).clearOptions();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new StatusHandlerConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001Ϫ\u0004\u0000\u0002\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001Ϫ\u001a", new Object[]{"bitField0_", "statusHandler_", "inputSidePacket_", "options_", "externalInput_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<StatusHandlerConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (StatusHandlerConfig.class) {
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
            StatusHandlerConfig statusHandlerConfig = new StatusHandlerConfig();
            DEFAULT_INSTANCE = statusHandlerConfig;
            GeneratedMessageLite.registerDefaultInstance(StatusHandlerConfig.class, statusHandlerConfig);
        }

        public static StatusHandlerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<StatusHandlerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.proto.StatusHandlerProto$1, reason: invalid class name */
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
}
