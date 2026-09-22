package com.google.mediapipe.tasks.vision.facelandmarker.proto;

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
public final class FaceLandmarksDetectorGraphOptionsProto {

    public interface FaceLandmarksDetectorGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions getFaceBlendshapesGraphOptions();

        float getMinDetectionConfidence();

        boolean getSmoothLandmarks();

        boolean hasBaseOptions();

        boolean hasFaceBlendshapesGraphOptions();

        boolean hasMinDetectionConfidence();

        boolean hasSmoothLandmarks();
    }

    private FaceLandmarksDetectorGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) FaceLandmarksDetectorGraphOptions.ext);
    }

    public static final class FaceLandmarksDetectorGraphOptions extends GeneratedMessageLite<FaceLandmarksDetectorGraphOptions, Builder> implements FaceLandmarksDetectorGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final FaceLandmarksDetectorGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 508968149;
        public static final int FACE_BLENDSHAPES_GRAPH_OPTIONS_FIELD_NUMBER = 3;
        public static final int MIN_DETECTION_CONFIDENCE_FIELD_NUMBER = 2;
        private static volatile Parser<FaceLandmarksDetectorGraphOptions> PARSER = null;
        public static final int SMOOTH_LANDMARKS_FIELD_NUMBER = 4;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, FaceLandmarksDetectorGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions faceBlendshapesGraphOptions_;
        private float minDetectionConfidence_ = 0.5f;
        private boolean smoothLandmarks_;

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

        private FaceLandmarksDetectorGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
        public boolean hasMinDetectionConfidence() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
        public boolean hasSmoothLandmarks() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
        public boolean getSmoothLandmarks() {
            return this.smoothLandmarks_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSmoothLandmarks(boolean value) {
            this.bitField0_ |= 4;
            this.smoothLandmarks_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSmoothLandmarks() {
            this.bitField0_ &= -5;
            this.smoothLandmarks_ = false;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
        public boolean hasFaceBlendshapesGraphOptions() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
        public FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions getFaceBlendshapesGraphOptions() {
            FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions faceBlendshapesGraphOptions = this.faceBlendshapesGraphOptions_;
            return faceBlendshapesGraphOptions == null ? FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions.getDefaultInstance() : faceBlendshapesGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceBlendshapesGraphOptions(FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions value) {
            value.getClass();
            this.faceBlendshapesGraphOptions_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFaceBlendshapesGraphOptions(FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions value) {
            value.getClass();
            FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions faceBlendshapesGraphOptions = this.faceBlendshapesGraphOptions_;
            if (faceBlendshapesGraphOptions != null && faceBlendshapesGraphOptions != FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions.getDefaultInstance()) {
                this.faceBlendshapesGraphOptions_ = (FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions) FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions.newBuilder(this.faceBlendshapesGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.faceBlendshapesGraphOptions_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceBlendshapesGraphOptions() {
            this.faceBlendshapesGraphOptions_ = null;
            this.bitField0_ &= -9;
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(InputStream input) throws IOException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceLandmarksDetectorGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FaceLandmarksDetectorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceLandmarksDetectorGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceLandmarksDetectorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceLandmarksDetectorGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceLandmarksDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FaceLandmarksDetectorGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FaceLandmarksDetectorGraphOptions, Builder> implements FaceLandmarksDetectorGraphOptionsOrBuilder {
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
                super(FaceLandmarksDetectorGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public boolean hasMinDetectionConfidence() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).hasMinDetectionConfidence();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public float getMinDetectionConfidence() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).getMinDetectionConfidence();
            }

            public Builder setMinDetectionConfidence(float value) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).setMinDetectionConfidence(value);
                return this;
            }

            public Builder clearMinDetectionConfidence() {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).clearMinDetectionConfidence();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public boolean hasSmoothLandmarks() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).hasSmoothLandmarks();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public boolean getSmoothLandmarks() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).getSmoothLandmarks();
            }

            public Builder setSmoothLandmarks(boolean value) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).setSmoothLandmarks(value);
                return this;
            }

            public Builder clearSmoothLandmarks() {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).clearSmoothLandmarks();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public boolean hasFaceBlendshapesGraphOptions() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).hasFaceBlendshapesGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptionsOrBuilder
            public FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions getFaceBlendshapesGraphOptions() {
                return ((FaceLandmarksDetectorGraphOptions) this.instance).getFaceBlendshapesGraphOptions();
            }

            public Builder setFaceBlendshapesGraphOptions(FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).setFaceBlendshapesGraphOptions(value);
                return this;
            }

            public Builder setFaceBlendshapesGraphOptions(FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).setFaceBlendshapesGraphOptions((FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceBlendshapesGraphOptions(FaceBlendshapesGraphOptionsProto.FaceBlendshapesGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).mergeFaceBlendshapesGraphOptions(value);
                return this;
            }

            public Builder clearFaceBlendshapesGraphOptions() {
                copyOnWrite();
                ((FaceLandmarksDetectorGraphOptions) this.instance).clearFaceBlendshapesGraphOptions();
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
                    return new FaceLandmarksDetectorGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003ဉ\u0003\u0004ဇ\u0002", new Object[]{"bitField0_", "baseOptions_", "minDetectionConfidence_", "faceBlendshapesGraphOptions_", "smoothLandmarks_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FaceLandmarksDetectorGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FaceLandmarksDetectorGraphOptions.class) {
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
            FaceLandmarksDetectorGraphOptions faceLandmarksDetectorGraphOptions = new FaceLandmarksDetectorGraphOptions();
            DEFAULT_INSTANCE = faceLandmarksDetectorGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(FaceLandmarksDetectorGraphOptions.class, faceLandmarksDetectorGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, FaceLandmarksDetectorGraphOptions.class);
        }

        public static FaceLandmarksDetectorGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FaceLandmarksDetectorGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto$1, reason: invalid class name */
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
