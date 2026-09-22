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
public final class StreamHandlerProto {

    public interface InputStreamHandlerConfigOrBuilder extends MessageLiteOrBuilder {
        String getInputStreamHandler();

        ByteString getInputStreamHandlerBytes();

        MediaPipeOptionsProto.MediaPipeOptions getOptions();

        boolean hasInputStreamHandler();

        boolean hasOptions();
    }

    public interface OutputStreamHandlerConfigOrBuilder extends MessageLiteOrBuilder {
        String getInputSidePacket(int index);

        ByteString getInputSidePacketBytes(int index);

        int getInputSidePacketCount();

        List<String> getInputSidePacketList();

        MediaPipeOptionsProto.MediaPipeOptions getOptions();

        String getOutputStreamHandler();

        ByteString getOutputStreamHandlerBytes();

        boolean hasOptions();

        boolean hasOutputStreamHandler();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private StreamHandlerProto() {
    }

    public static final class InputStreamHandlerConfig extends GeneratedMessageLite<InputStreamHandlerConfig, Builder> implements InputStreamHandlerConfigOrBuilder {
        private static final InputStreamHandlerConfig DEFAULT_INSTANCE;
        public static final int INPUT_STREAM_HANDLER_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<InputStreamHandlerConfig> PARSER;
        private int bitField0_;
        private MediaPipeOptionsProto.MediaPipeOptions options_;
        private byte memoizedIsInitialized = 2;
        private String inputStreamHandler_ = "DefaultInputStreamHandler";

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

        private InputStreamHandlerConfig() {
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
        public boolean hasInputStreamHandler() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
        public String getInputStreamHandler() {
            return this.inputStreamHandler_;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
        public ByteString getInputStreamHandlerBytes() {
            return ByteString.copyFromUtf8(this.inputStreamHandler_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputStreamHandler(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.inputStreamHandler_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInputStreamHandler() {
            this.bitField0_ &= -2;
            this.inputStreamHandler_ = getDefaultInstance().getInputStreamHandler();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputStreamHandlerBytes(ByteString value) {
            this.inputStreamHandler_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
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

        public static InputStreamHandlerConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static InputStreamHandlerConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static InputStreamHandlerConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static InputStreamHandlerConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static InputStreamHandlerConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static InputStreamHandlerConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static InputStreamHandlerConfig parseFrom(InputStream input) throws IOException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static InputStreamHandlerConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static InputStreamHandlerConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (InputStreamHandlerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static InputStreamHandlerConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InputStreamHandlerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static InputStreamHandlerConfig parseFrom(CodedInputStream input) throws IOException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static InputStreamHandlerConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(InputStreamHandlerConfig prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<InputStreamHandlerConfig, Builder> implements InputStreamHandlerConfigOrBuilder {
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
                super(InputStreamHandlerConfig.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
            public boolean hasInputStreamHandler() {
                return ((InputStreamHandlerConfig) this.instance).hasInputStreamHandler();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
            public String getInputStreamHandler() {
                return ((InputStreamHandlerConfig) this.instance).getInputStreamHandler();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
            public ByteString getInputStreamHandlerBytes() {
                return ((InputStreamHandlerConfig) this.instance).getInputStreamHandlerBytes();
            }

            public Builder setInputStreamHandler(String value) {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).setInputStreamHandler(value);
                return this;
            }

            public Builder clearInputStreamHandler() {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).clearInputStreamHandler();
                return this;
            }

            public Builder setInputStreamHandlerBytes(ByteString value) {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).setInputStreamHandlerBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
            public boolean hasOptions() {
                return ((InputStreamHandlerConfig) this.instance).hasOptions();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.InputStreamHandlerConfigOrBuilder
            public MediaPipeOptionsProto.MediaPipeOptions getOptions() {
                return ((InputStreamHandlerConfig) this.instance).getOptions();
            }

            public Builder setOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(MediaPipeOptionsProto.MediaPipeOptions.Builder builderForValue) {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).setOptions((MediaPipeOptionsProto.MediaPipeOptions) builderForValue.build());
                return this;
            }

            public Builder mergeOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((InputStreamHandlerConfig) this.instance).clearOptions();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new InputStreamHandlerConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0003ᐉ\u0001", new Object[]{"bitField0_", "inputStreamHandler_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<InputStreamHandlerConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (InputStreamHandlerConfig.class) {
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
            InputStreamHandlerConfig inputStreamHandlerConfig = new InputStreamHandlerConfig();
            DEFAULT_INSTANCE = inputStreamHandlerConfig;
            GeneratedMessageLite.registerDefaultInstance(InputStreamHandlerConfig.class, inputStreamHandlerConfig);
        }

        public static InputStreamHandlerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InputStreamHandlerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.proto.StreamHandlerProto$1, reason: invalid class name */
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

    public static final class OutputStreamHandlerConfig extends GeneratedMessageLite<OutputStreamHandlerConfig, Builder> implements OutputStreamHandlerConfigOrBuilder {
        private static final OutputStreamHandlerConfig DEFAULT_INSTANCE;
        public static final int INPUT_SIDE_PACKET_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int OUTPUT_STREAM_HANDLER_FIELD_NUMBER = 1;
        private static volatile Parser<OutputStreamHandlerConfig> PARSER;
        private int bitField0_;
        private MediaPipeOptionsProto.MediaPipeOptions options_;
        private byte memoizedIsInitialized = 2;
        private String outputStreamHandler_ = "InOrderOutputStreamHandler";
        private Internal.ProtobufList<String> inputSidePacket_ = GeneratedMessageLite.emptyProtobufList();

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

        private OutputStreamHandlerConfig() {
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public boolean hasOutputStreamHandler() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public String getOutputStreamHandler() {
            return this.outputStreamHandler_;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public ByteString getOutputStreamHandlerBytes() {
            return ByteString.copyFromUtf8(this.outputStreamHandler_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputStreamHandler(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.outputStreamHandler_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputStreamHandler() {
            this.bitField0_ &= -2;
            this.outputStreamHandler_ = getDefaultInstance().getOutputStreamHandler();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputStreamHandlerBytes(ByteString value) {
            this.outputStreamHandler_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public List<String> getInputSidePacketList() {
            return this.inputSidePacket_;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public int getInputSidePacketCount() {
            return this.inputSidePacket_.size();
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public String getInputSidePacket(int index) {
            return this.inputSidePacket_.get(index);
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
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

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
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

        public static OutputStreamHandlerConfig parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OutputStreamHandlerConfig parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OutputStreamHandlerConfig parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OutputStreamHandlerConfig parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OutputStreamHandlerConfig parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static OutputStreamHandlerConfig parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static OutputStreamHandlerConfig parseFrom(InputStream input) throws IOException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static OutputStreamHandlerConfig parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static OutputStreamHandlerConfig parseDelimitedFrom(InputStream input) throws IOException {
            return (OutputStreamHandlerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static OutputStreamHandlerConfig parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OutputStreamHandlerConfig) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static OutputStreamHandlerConfig parseFrom(CodedInputStream input) throws IOException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static OutputStreamHandlerConfig parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OutputStreamHandlerConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(OutputStreamHandlerConfig prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OutputStreamHandlerConfig, Builder> implements OutputStreamHandlerConfigOrBuilder {
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
                super(OutputStreamHandlerConfig.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public boolean hasOutputStreamHandler() {
                return ((OutputStreamHandlerConfig) this.instance).hasOutputStreamHandler();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public String getOutputStreamHandler() {
                return ((OutputStreamHandlerConfig) this.instance).getOutputStreamHandler();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public ByteString getOutputStreamHandlerBytes() {
                return ((OutputStreamHandlerConfig) this.instance).getOutputStreamHandlerBytes();
            }

            public Builder setOutputStreamHandler(String value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).setOutputStreamHandler(value);
                return this;
            }

            public Builder clearOutputStreamHandler() {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).clearOutputStreamHandler();
                return this;
            }

            public Builder setOutputStreamHandlerBytes(ByteString value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).setOutputStreamHandlerBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public List<String> getInputSidePacketList() {
                return Collections.unmodifiableList(((OutputStreamHandlerConfig) this.instance).getInputSidePacketList());
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public int getInputSidePacketCount() {
                return ((OutputStreamHandlerConfig) this.instance).getInputSidePacketCount();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public String getInputSidePacket(int index) {
                return ((OutputStreamHandlerConfig) this.instance).getInputSidePacket(index);
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public ByteString getInputSidePacketBytes(int index) {
                return ((OutputStreamHandlerConfig) this.instance).getInputSidePacketBytes(index);
            }

            public Builder setInputSidePacket(int index, String value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).setInputSidePacket(index, value);
                return this;
            }

            public Builder addInputSidePacket(String value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).addInputSidePacket(value);
                return this;
            }

            public Builder addAllInputSidePacket(Iterable<String> values) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).addAllInputSidePacket(values);
                return this;
            }

            public Builder clearInputSidePacket() {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).clearInputSidePacket();
                return this;
            }

            public Builder addInputSidePacketBytes(ByteString value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).addInputSidePacketBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public boolean hasOptions() {
                return ((OutputStreamHandlerConfig) this.instance).hasOptions();
            }

            @Override // com.google.mediapipe.proto.StreamHandlerProto.OutputStreamHandlerConfigOrBuilder
            public MediaPipeOptionsProto.MediaPipeOptions getOptions() {
                return ((OutputStreamHandlerConfig) this.instance).getOptions();
            }

            public Builder setOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).setOptions(value);
                return this;
            }

            public Builder setOptions(MediaPipeOptionsProto.MediaPipeOptions.Builder builderForValue) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).setOptions((MediaPipeOptionsProto.MediaPipeOptions) builderForValue.build());
                return this;
            }

            public Builder mergeOptions(MediaPipeOptionsProto.MediaPipeOptions value) {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).mergeOptions(value);
                return this;
            }

            public Builder clearOptions() {
                copyOnWrite();
                ((OutputStreamHandlerConfig) this.instance).clearOptions();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new OutputStreamHandlerConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"bitField0_", "outputStreamHandler_", "inputSidePacket_", "options_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<OutputStreamHandlerConfig> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (OutputStreamHandlerConfig.class) {
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
            OutputStreamHandlerConfig outputStreamHandlerConfig = new OutputStreamHandlerConfig();
            DEFAULT_INSTANCE = outputStreamHandlerConfig;
            GeneratedMessageLite.registerDefaultInstance(OutputStreamHandlerConfig.class, outputStreamHandlerConfig);
        }

        public static OutputStreamHandlerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OutputStreamHandlerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
