package com.google.mediapipe.tasks.vision.facegeometry.calculators.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.ExternalFileProto;
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
public final class FaceGeometryPipelineCalculatorOptionsProto {

    public interface FaceGeometryPipelineCalculatorOptionsOrBuilder extends MessageLiteOrBuilder {
        ExternalFileProto.ExternalFile getMetadataFile();

        boolean hasMetadataFile();
    }

    private FaceGeometryPipelineCalculatorOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) FaceGeometryPipelineCalculatorOptions.ext);
    }

    public static final class FaceGeometryPipelineCalculatorOptions extends GeneratedMessageLite<FaceGeometryPipelineCalculatorOptions, Builder> implements FaceGeometryPipelineCalculatorOptionsOrBuilder {
        private static final FaceGeometryPipelineCalculatorOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 512499200;
        public static final int METADATA_FILE_FIELD_NUMBER = 1;
        private static volatile Parser<FaceGeometryPipelineCalculatorOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, FaceGeometryPipelineCalculatorOptions> ext;
        private int bitField0_;
        private ExternalFileProto.ExternalFile metadataFile_;

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

        private FaceGeometryPipelineCalculatorOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.calculators.proto.FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptionsOrBuilder
        public boolean hasMetadataFile() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.calculators.proto.FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptionsOrBuilder
        public ExternalFileProto.ExternalFile getMetadataFile() {
            ExternalFileProto.ExternalFile externalFile = this.metadataFile_;
            return externalFile == null ? ExternalFileProto.ExternalFile.getDefaultInstance() : externalFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetadataFile(ExternalFileProto.ExternalFile value) {
            value.getClass();
            this.metadataFile_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMetadataFile(ExternalFileProto.ExternalFile value) {
            value.getClass();
            ExternalFileProto.ExternalFile externalFile = this.metadataFile_;
            if (externalFile != null && externalFile != ExternalFileProto.ExternalFile.getDefaultInstance()) {
                this.metadataFile_ = (ExternalFileProto.ExternalFile) ExternalFileProto.ExternalFile.newBuilder(this.metadataFile_).mergeFrom(value).buildPartial();
            } else {
                this.metadataFile_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetadataFile() {
            this.metadataFile_ = null;
            this.bitField0_ &= -2;
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(InputStream input) throws IOException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceGeometryPipelineCalculatorOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FaceGeometryPipelineCalculatorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometryPipelineCalculatorOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometryPipelineCalculatorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(CodedInputStream input) throws IOException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometryPipelineCalculatorOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometryPipelineCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FaceGeometryPipelineCalculatorOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FaceGeometryPipelineCalculatorOptions, Builder> implements FaceGeometryPipelineCalculatorOptionsOrBuilder {
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
                super(FaceGeometryPipelineCalculatorOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.calculators.proto.FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptionsOrBuilder
            public boolean hasMetadataFile() {
                return ((FaceGeometryPipelineCalculatorOptions) this.instance).hasMetadataFile();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.calculators.proto.FaceGeometryPipelineCalculatorOptionsProto.FaceGeometryPipelineCalculatorOptionsOrBuilder
            public ExternalFileProto.ExternalFile getMetadataFile() {
                return ((FaceGeometryPipelineCalculatorOptions) this.instance).getMetadataFile();
            }

            public Builder setMetadataFile(ExternalFileProto.ExternalFile value) {
                copyOnWrite();
                ((FaceGeometryPipelineCalculatorOptions) this.instance).setMetadataFile(value);
                return this;
            }

            public Builder setMetadataFile(ExternalFileProto.ExternalFile.Builder builderForValue) {
                copyOnWrite();
                ((FaceGeometryPipelineCalculatorOptions) this.instance).setMetadataFile((ExternalFileProto.ExternalFile) builderForValue.build());
                return this;
            }

            public Builder mergeMetadataFile(ExternalFileProto.ExternalFile value) {
                copyOnWrite();
                ((FaceGeometryPipelineCalculatorOptions) this.instance).mergeMetadataFile(value);
                return this;
            }

            public Builder clearMetadataFile() {
                copyOnWrite();
                ((FaceGeometryPipelineCalculatorOptions) this.instance).clearMetadataFile();
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
                    return new FaceGeometryPipelineCalculatorOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "metadataFile_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FaceGeometryPipelineCalculatorOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FaceGeometryPipelineCalculatorOptions.class) {
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
            FaceGeometryPipelineCalculatorOptions faceGeometryPipelineCalculatorOptions = new FaceGeometryPipelineCalculatorOptions();
            DEFAULT_INSTANCE = faceGeometryPipelineCalculatorOptions;
            GeneratedMessageLite.registerDefaultInstance(FaceGeometryPipelineCalculatorOptions.class, faceGeometryPipelineCalculatorOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, FaceGeometryPipelineCalculatorOptions.class);
        }

        public static FaceGeometryPipelineCalculatorOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FaceGeometryPipelineCalculatorOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facegeometry.calculators.proto.FaceGeometryPipelineCalculatorOptionsProto$1, reason: invalid class name */
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
