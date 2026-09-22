package com.google.mediapipe.tasks.vision.facegeometry.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.vision.facegeometry.calculators.proto.FaceGeometryPipelineCalculatorOptionsProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class FaceGeometryGraphOptionsProto {

    public interface FaceGeometryGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions getGeometryPipelineOptions();

        boolean hasGeometryPipelineOptions();
    }

    private FaceGeometryGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) FaceGeometryGraphOptions.ext);
    }

    public static final class FaceGeometryGraphOptions extends GeneratedMessageLite<FaceGeometryGraphOptions, Builder> implements FaceGeometryGraphOptionsOrBuilder {
        private static final FaceGeometryGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 515723506;
        public static final int GEOMETRY_PIPELINE_OPTIONS_FIELD_NUMBER = 1;
        private static volatile Parser<FaceGeometryGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, FaceGeometryGraphOptions> ext;
        private int bitField0_;
        private FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions geometryPipelineOptions_;

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

        private FaceGeometryGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryGraphOptionsProto.FaceGeometryGraphOptionsOrBuilder
        public boolean hasGeometryPipelineOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryGraphOptionsProto.FaceGeometryGraphOptionsOrBuilder
        public FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions getGeometryPipelineOptions() {
            FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions faceGeometryPipelineCalculatorOptions = this.geometryPipelineOptions_;
            return faceGeometryPipelineCalculatorOptions == null ? FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions.getDefaultInstance() : faceGeometryPipelineCalculatorOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGeometryPipelineOptions(FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions value) {
            value.getClass();
            this.geometryPipelineOptions_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeGeometryPipelineOptions(FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions value) {
            value.getClass();
            FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions faceGeometryPipelineCalculatorOptions = this.geometryPipelineOptions_;
            if (faceGeometryPipelineCalculatorOptions != null && faceGeometryPipelineCalculatorOptions != FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions.getDefaultInstance()) {
                this.geometryPipelineOptions_ = (FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions) FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions.newBuilder(this.geometryPipelineOptions_).mergeFrom(value).buildPartial();
            } else {
                this.geometryPipelineOptions_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGeometryPipelineOptions() {
            this.geometryPipelineOptions_ = null;
            this.bitField0_ &= -2;
        }

        public static FaceGeometryGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometryGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometryGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometryGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometryGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometryGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometryGraphOptions parseFrom(InputStream input) throws IOException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometryGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceGeometryGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FaceGeometryGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometryGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometryGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceGeometryGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometryGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometryGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FaceGeometryGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FaceGeometryGraphOptions, Builder> implements FaceGeometryGraphOptionsOrBuilder {
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
                super(FaceGeometryGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryGraphOptionsProto.FaceGeometryGraphOptionsOrBuilder
            public boolean hasGeometryPipelineOptions() {
                return ((FaceGeometryGraphOptions) this.instance).hasGeometryPipelineOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryGraphOptionsProto.FaceGeometryGraphOptionsOrBuilder
            public FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions getGeometryPipelineOptions() {
                return ((FaceGeometryGraphOptions) this.instance).getGeometryPipelineOptions();
            }

            public Builder setGeometryPipelineOptions(FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions value) {
                copyOnWrite();
                ((FaceGeometryGraphOptions) this.instance).setGeometryPipelineOptions(value);
                return this;
            }

            public Builder setGeometryPipelineOptions(FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceGeometryGraphOptions) this.instance).setGeometryPipelineOptions((FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions) builderForValue.build());
                return this;
            }

            public Builder mergeGeometryPipelineOptions(FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptions value) {
                copyOnWrite();
                ((FaceGeometryGraphOptions) this.instance).mergeGeometryPipelineOptions(value);
                return this;
            }

            public Builder clearGeometryPipelineOptions() {
                copyOnWrite();
                ((FaceGeometryGraphOptions) this.instance).clearGeometryPipelineOptions();
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
                    return new FaceGeometryGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "geometryPipelineOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FaceGeometryGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FaceGeometryGraphOptions.class) {
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
            FaceGeometryGraphOptions faceGeometryGraphOptions = new FaceGeometryGraphOptions();
            DEFAULT_INSTANCE = faceGeometryGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(FaceGeometryGraphOptions.class, faceGeometryGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, FaceGeometryGraphOptions.class);
        }

        public static FaceGeometryGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FaceGeometryGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryGraphOptionsProto$1, reason: invalid class name */
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
