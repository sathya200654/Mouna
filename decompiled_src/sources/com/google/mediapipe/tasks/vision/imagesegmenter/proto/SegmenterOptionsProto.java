package com.google.mediapipe.tasks.vision.imagesegmenter.proto;

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

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SegmenterOptionsProto {

    public interface SegmenterOptionsOrBuilder extends MessageLiteOrBuilder {
        SegmenterOptions.Activation getActivation();

        @Deprecated
        SegmenterOptions.OutputType getOutputType();

        boolean hasActivation();

        @Deprecated
        boolean hasOutputType();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private SegmenterOptionsProto() {
    }

    public static final class SegmenterOptions extends GeneratedMessageLite<SegmenterOptions, Builder> implements SegmenterOptionsOrBuilder {
        public static final int ACTIVATION_FIELD_NUMBER = 2;
        private static final SegmenterOptions DEFAULT_INSTANCE;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 1;
        private static volatile Parser<SegmenterOptions> PARSER;
        private int activation_;
        private int bitField0_;
        private int outputType_;

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

        private SegmenterOptions() {
        }

        public enum OutputType implements Internal.EnumLite {
            UNSPECIFIED(0),
            CATEGORY_MASK(1),
            CONFIDENCE_MASK(2);

            public static final int CATEGORY_MASK_VALUE = 1;
            public static final int CONFIDENCE_MASK_VALUE = 2;
            public static final int UNSPECIFIED_VALUE = 0;
            private static final Internal.EnumLiteMap<OutputType> internalValueMap = new Internal.EnumLiteMap<OutputType>() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptions.OutputType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OutputType findValueByNumber(int number) {
                    return OutputType.forNumber(number);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OutputType valueOf(int value) {
                return forNumber(value);
            }

            public static OutputType forNumber(int value) {
                if (value == 0) {
                    return UNSPECIFIED;
                }
                if (value == 1) {
                    return CATEGORY_MASK;
                }
                if (value != 2) {
                    return null;
                }
                return CONFIDENCE_MASK;
            }

            public static Internal.EnumLiteMap<OutputType> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return OutputTypeVerifier.INSTANCE;
            }

            private static final class OutputTypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new OutputTypeVerifier();

                private OutputTypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return OutputType.forNumber(number) != null;
                }
            }

            OutputType(int value) {
                this.value = value;
            }
        }

        public enum Activation implements Internal.EnumLite {
            NONE(0),
            SIGMOID(1),
            SOFTMAX(2);

            public static final int NONE_VALUE = 0;
            public static final int SIGMOID_VALUE = 1;
            public static final int SOFTMAX_VALUE = 2;
            private static final Internal.EnumLiteMap<Activation> internalValueMap = new Internal.EnumLiteMap<Activation>() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptions.Activation.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Activation findValueByNumber(int number) {
                    return Activation.forNumber(number);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Activation valueOf(int value) {
                return forNumber(value);
            }

            public static Activation forNumber(int value) {
                if (value == 0) {
                    return NONE;
                }
                if (value == 1) {
                    return SIGMOID;
                }
                if (value != 2) {
                    return null;
                }
                return SOFTMAX;
            }

            public static Internal.EnumLiteMap<Activation> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ActivationVerifier.INSTANCE;
            }

            private static final class ActivationVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new ActivationVerifier();

                private ActivationVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return Activation.forNumber(number) != null;
                }
            }

            Activation(int value) {
                this.value = value;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
        @Deprecated
        public boolean hasOutputType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
        @Deprecated
        public OutputType getOutputType() {
            OutputType outputTypeForNumber = OutputType.forNumber(this.outputType_);
            return outputTypeForNumber == null ? OutputType.UNSPECIFIED : outputTypeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOutputType(OutputType value) {
            this.outputType_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOutputType() {
            this.bitField0_ &= -2;
            this.outputType_ = 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
        public boolean hasActivation() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
        public Activation getActivation() {
            Activation activationForNumber = Activation.forNumber(this.activation_);
            return activationForNumber == null ? Activation.NONE : activationForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivation(Activation value) {
            this.activation_ = value.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearActivation() {
            this.bitField0_ &= -3;
            this.activation_ = 0;
        }

        public static SegmenterOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SegmenterOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SegmenterOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SegmenterOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SegmenterOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SegmenterOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SegmenterOptions parseFrom(InputStream input) throws IOException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SegmenterOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SegmenterOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (SegmenterOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SegmenterOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SegmenterOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SegmenterOptions parseFrom(CodedInputStream input) throws IOException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SegmenterOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SegmenterOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SegmenterOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SegmenterOptions, Builder> implements SegmenterOptionsOrBuilder {
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
                super(SegmenterOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
            @Deprecated
            public boolean hasOutputType() {
                return ((SegmenterOptions) this.instance).hasOutputType();
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
            @Deprecated
            public OutputType getOutputType() {
                return ((SegmenterOptions) this.instance).getOutputType();
            }

            @Deprecated
            public Builder setOutputType(OutputType value) {
                copyOnWrite();
                ((SegmenterOptions) this.instance).setOutputType(value);
                return this;
            }

            @Deprecated
            public Builder clearOutputType() {
                copyOnWrite();
                ((SegmenterOptions) this.instance).clearOutputType();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
            public boolean hasActivation() {
                return ((SegmenterOptions) this.instance).hasActivation();
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto.SegmenterOptionsOrBuilder
            public Activation getActivation() {
                return ((SegmenterOptions) this.instance).getActivation();
            }

            public Builder setActivation(Activation value) {
                copyOnWrite();
                ((SegmenterOptions) this.instance).setActivation(value);
                return this;
            }

            public Builder clearActivation() {
                copyOnWrite();
                ((SegmenterOptions) this.instance).clearActivation();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            int i = AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()];
            AnonymousClass1 anonymousClass1 = null;
            switch (i) {
                case 1:
                    return new SegmenterOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"bitField0_", "outputType_", OutputType.internalGetVerifier(), "activation_", Activation.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SegmenterOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SegmenterOptions.class) {
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
            SegmenterOptions segmenterOptions = new SegmenterOptions();
            DEFAULT_INSTANCE = segmenterOptions;
            GeneratedMessageLite.registerDefaultInstance(SegmenterOptions.class, segmenterOptions);
        }

        public static SegmenterOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SegmenterOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto$1, reason: invalid class name */
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
