package com.google.mediapipe.tasks.vision.facedetector.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
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
public final class FaceDetectorGraphOptionsProto {

    public interface FaceDetectorGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        float getMinDetectionConfidence();

        float getMinSuppressionThreshold();

        int getNumFaces();

        boolean hasBaseOptions();

        boolean hasMinDetectionConfidence();

        boolean hasMinSuppressionThreshold();

        boolean hasNumFaces();
    }

    private FaceDetectorGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) FaceDetectorGraphOptions.ext);
    }

    public static final class FaceDetectorGraphOptions extends GeneratedMessageLite<FaceDetectorGraphOptions, Builder> implements FaceDetectorGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final FaceDetectorGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 502141897;
        public static final int MIN_DETECTION_CONFIDENCE_FIELD_NUMBER = 2;
        public static final int MIN_SUPPRESSION_THRESHOLD_FIELD_NUMBER = 3;
        public static final int NUM_FACES_FIELD_NUMBER = 4;
        private static volatile Parser<FaceDetectorGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, FaceDetectorGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private float minDetectionConfidence_ = 0.5f;
        private float minSuppressionThreshold_ = 0.5f;
        private int numFaces_;

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

        private FaceDetectorGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public BaseOptionsProto.BaseOptions getBaseOptions() {
            BaseOptionsProto.BaseOptions baseOptions = this.baseOptions_;
            return baseOptions == null ? BaseOptionsProto.BaseOptions.getDefaultInstance() : baseOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseOptions(BaseOptionsProto.BaseOptions value) {
            value.getClass();
            this.baseOptions_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
            value.getClass();
            BaseOptionsProto.BaseOptions baseOptions = this.baseOptions_;
            if (baseOptions != null && baseOptions != BaseOptionsProto.BaseOptions.getDefaultInstance()) {
                this.baseOptions_ = (BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder(this.baseOptions_).mergeFrom(value).buildPartial();
            } else {
                this.baseOptions_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBaseOptions() {
            this.baseOptions_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public boolean hasMinDetectionConfidence() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public float getMinDetectionConfidence() {
            return this.minDetectionConfidence_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinDetectionConfidence(float value) {
            this.bitField0_ |= 2;
            this.minDetectionConfidence_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMinDetectionConfidence() {
            this.bitField0_ &= -3;
            this.minDetectionConfidence_ = 0.5f;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public boolean hasMinSuppressionThreshold() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public float getMinSuppressionThreshold() {
            return this.minSuppressionThreshold_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinSuppressionThreshold(float value) {
            this.bitField0_ |= 4;
            this.minSuppressionThreshold_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMinSuppressionThreshold() {
            this.bitField0_ &= -5;
            this.minSuppressionThreshold_ = 0.5f;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public boolean hasNumFaces() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
        public int getNumFaces() {
            return this.numFaces_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumFaces(int value) {
            this.bitField0_ |= 8;
            this.numFaces_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumFaces() {
            this.bitField0_ &= -9;
            this.numFaces_ = 0;
        }

        public static FaceDetectorGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceDetectorGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceDetectorGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceDetectorGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceDetectorGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceDetectorGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceDetectorGraphOptions parseFrom(InputStream input) throws IOException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceDetectorGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceDetectorGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FaceDetectorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceDetectorGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceDetectorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceDetectorGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceDetectorGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FaceDetectorGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FaceDetectorGraphOptions, Builder> implements FaceDetectorGraphOptionsOrBuilder {
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
                super(FaceDetectorGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((FaceDetectorGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((FaceDetectorGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public boolean hasMinDetectionConfidence() {
                return ((FaceDetectorGraphOptions) this.instance).hasMinDetectionConfidence();
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public float getMinDetectionConfidence() {
                return ((FaceDetectorGraphOptions) this.instance).getMinDetectionConfidence();
            }

            public Builder setMinDetectionConfidence(float value) {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).setMinDetectionConfidence(value);
                return this;
            }

            public Builder clearMinDetectionConfidence() {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).clearMinDetectionConfidence();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public boolean hasMinSuppressionThreshold() {
                return ((FaceDetectorGraphOptions) this.instance).hasMinSuppressionThreshold();
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public float getMinSuppressionThreshold() {
                return ((FaceDetectorGraphOptions) this.instance).getMinSuppressionThreshold();
            }

            public Builder setMinSuppressionThreshold(float value) {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).setMinSuppressionThreshold(value);
                return this;
            }

            public Builder clearMinSuppressionThreshold() {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).clearMinSuppressionThreshold();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public boolean hasNumFaces() {
                return ((FaceDetectorGraphOptions) this.instance).hasNumFaces();
            }

            @Override // com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto.FaceDetectorGraphOptionsOrBuilder
            public int getNumFaces() {
                return ((FaceDetectorGraphOptions) this.instance).getNumFaces();
            }

            public Builder setNumFaces(int value) {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).setNumFaces(value);
                return this;
            }

            public Builder clearNumFaces() {
                copyOnWrite();
                ((FaceDetectorGraphOptions) this.instance).clearNumFaces();
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
                    return new FaceDetectorGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004င\u0003", new Object[]{"bitField0_", "baseOptions_", "minDetectionConfidence_", "minSuppressionThreshold_", "numFaces_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FaceDetectorGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FaceDetectorGraphOptions.class) {
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
            FaceDetectorGraphOptions faceDetectorGraphOptions = new FaceDetectorGraphOptions();
            DEFAULT_INSTANCE = faceDetectorGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(FaceDetectorGraphOptions.class, faceDetectorGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, FaceDetectorGraphOptions.class);
        }

        public static FaceDetectorGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FaceDetectorGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto$1, reason: invalid class name */
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
