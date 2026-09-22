package com.google.mediapipe.tasks.vision.facelandmarker.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryGraphOptionsProto;
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
public final class FaceLandmarkerGraphOptionsProto {

    public interface FaceLandmarkerGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions getFaceDetectorGraphOptions();

        FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions getFaceGeometryGraphOptions();

        FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions getFaceLandmarksDetectorGraphOptions();

        float getMinTrackingConfidence();

        boolean hasBaseOptions();

        boolean hasFaceDetectorGraphOptions();

        boolean hasFaceGeometryGraphOptions();

        boolean hasFaceLandmarksDetectorGraphOptions();

        boolean hasMinTrackingConfidence();
    }

    private FaceLandmarkerGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) FaceLandmarkerGraphOptions.ext);
    }

    public static final class FaceLandmarkerGraphOptions extends GeneratedMessageLite<FaceLandmarkerGraphOptions, Builder> implements FaceLandmarkerGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final FaceLandmarkerGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 508968150;
        public static final int FACE_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 2;
        public static final int FACE_GEOMETRY_GRAPH_OPTIONS_FIELD_NUMBER = 5;
        public static final int FACE_LANDMARKS_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 3;
        public static final int MIN_TRACKING_CONFIDENCE_FIELD_NUMBER = 4;
        private static volatile Parser<FaceLandmarkerGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, FaceLandmarkerGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions faceDetectorGraphOptions_;
        private FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions faceGeometryGraphOptions_;
        private FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions faceLandmarksDetectorGraphOptions_;
        private float minTrackingConfidence_ = 0.5f;

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

        private FaceLandmarkerGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public boolean hasFaceDetectorGraphOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions getFaceDetectorGraphOptions() {
            FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions faceDetectorGraphOptions = this.faceDetectorGraphOptions_;
            return faceDetectorGraphOptions == null ? FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.getDefaultInstance() : faceDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
            value.getClass();
            this.faceDetectorGraphOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
            value.getClass();
            FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions faceDetectorGraphOptions = this.faceDetectorGraphOptions_;
            if (faceDetectorGraphOptions != null && faceDetectorGraphOptions != FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.getDefaultInstance()) {
                this.faceDetectorGraphOptions_ = (FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions) FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.newBuilder(this.faceDetectorGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.faceDetectorGraphOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceDetectorGraphOptions() {
            this.faceDetectorGraphOptions_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public boolean hasFaceLandmarksDetectorGraphOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions getFaceLandmarksDetectorGraphOptions() {
            FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions faceLandmarksDetectorGraphOptions = this.faceLandmarksDetectorGraphOptions_;
            return faceLandmarksDetectorGraphOptions == null ? FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.getDefaultInstance() : faceLandmarksDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
            value.getClass();
            this.faceLandmarksDetectorGraphOptions_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
            value.getClass();
            FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions faceLandmarksDetectorGraphOptions = this.faceLandmarksDetectorGraphOptions_;
            if (faceLandmarksDetectorGraphOptions != null && faceLandmarksDetectorGraphOptions != FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.getDefaultInstance()) {
                this.faceLandmarksDetectorGraphOptions_ = (FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions) FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.newBuilder(this.faceLandmarksDetectorGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.faceLandmarksDetectorGraphOptions_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceLandmarksDetectorGraphOptions() {
            this.faceLandmarksDetectorGraphOptions_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public boolean hasMinTrackingConfidence() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public float getMinTrackingConfidence() {
            return this.minTrackingConfidence_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinTrackingConfidence(float value) {
            this.bitField0_ |= 8;
            this.minTrackingConfidence_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMinTrackingConfidence() {
            this.bitField0_ &= -9;
            this.minTrackingConfidence_ = 0.5f;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public boolean hasFaceGeometryGraphOptions() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
        public FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions getFaceGeometryGraphOptions() {
            FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions faceGeometryGraphOptions = this.faceGeometryGraphOptions_;
            return faceGeometryGraphOptions == null ? FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions.getDefaultInstance() : faceGeometryGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceGeometryGraphOptions(FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions value) {
            value.getClass();
            this.faceGeometryGraphOptions_ = value;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFaceGeometryGraphOptions(FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions value) {
            value.getClass();
            FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions faceGeometryGraphOptions = this.faceGeometryGraphOptions_;
            if (faceGeometryGraphOptions != null && faceGeometryGraphOptions != FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions.getDefaultInstance()) {
                this.faceGeometryGraphOptions_ = (FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions) FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions.newBuilder(this.faceGeometryGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.faceGeometryGraphOptions_ = value;
            }
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceGeometryGraphOptions() {
            this.faceGeometryGraphOptions_ = null;
            this.bitField0_ &= -17;
        }

        public static FaceLandmarkerGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceLandmarkerGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceLandmarkerGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceLandmarkerGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceLandmarkerGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceLandmarkerGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceLandmarkerGraphOptions parseFrom(InputStream input) throws IOException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceLandmarkerGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceLandmarkerGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (FaceLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceLandmarkerGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceLandmarkerGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceLandmarkerGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FaceLandmarkerGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FaceLandmarkerGraphOptions, Builder> implements FaceLandmarkerGraphOptionsOrBuilder {
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
                super(FaceLandmarkerGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public boolean hasFaceDetectorGraphOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).hasFaceDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions getFaceDetectorGraphOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).getFaceDetectorGraphOptions();
            }

            public Builder setFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setFaceDetectorGraphOptions(value);
                return this;
            }

            public Builder setFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setFaceDetectorGraphOptions((FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).mergeFaceDetectorGraphOptions(value);
                return this;
            }

            public Builder clearFaceDetectorGraphOptions() {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).clearFaceDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public boolean hasFaceLandmarksDetectorGraphOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).hasFaceLandmarksDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions getFaceLandmarksDetectorGraphOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).getFaceLandmarksDetectorGraphOptions();
            }

            public Builder setFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setFaceLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder setFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setFaceLandmarksDetectorGraphOptions((FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).mergeFaceLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder clearFaceLandmarksDetectorGraphOptions() {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).clearFaceLandmarksDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public boolean hasMinTrackingConfidence() {
                return ((FaceLandmarkerGraphOptions) this.instance).hasMinTrackingConfidence();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public float getMinTrackingConfidence() {
                return ((FaceLandmarkerGraphOptions) this.instance).getMinTrackingConfidence();
            }

            public Builder setMinTrackingConfidence(float value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setMinTrackingConfidence(value);
                return this;
            }

            public Builder clearMinTrackingConfidence() {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).clearMinTrackingConfidence();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public boolean hasFaceGeometryGraphOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).hasFaceGeometryGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptionsOrBuilder
            public FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions getFaceGeometryGraphOptions() {
                return ((FaceLandmarkerGraphOptions) this.instance).getFaceGeometryGraphOptions();
            }

            public Builder setFaceGeometryGraphOptions(FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setFaceGeometryGraphOptions(value);
                return this;
            }

            public Builder setFaceGeometryGraphOptions(FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).setFaceGeometryGraphOptions((FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceGeometryGraphOptions(FaceGeometryGraphOptionsProto.FaceGeometryGraphOptions value) {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).mergeFaceGeometryGraphOptions(value);
                return this;
            }

            public Builder clearFaceGeometryGraphOptions() {
                copyOnWrite();
                ((FaceLandmarkerGraphOptions) this.instance).clearFaceGeometryGraphOptions();
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
                    return new FaceLandmarkerGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"bitField0_", "baseOptions_", "faceDetectorGraphOptions_", "faceLandmarksDetectorGraphOptions_", "minTrackingConfidence_", "faceGeometryGraphOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FaceLandmarkerGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FaceLandmarkerGraphOptions.class) {
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
            FaceLandmarkerGraphOptions faceLandmarkerGraphOptions = new FaceLandmarkerGraphOptions();
            DEFAULT_INSTANCE = faceLandmarkerGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(FaceLandmarkerGraphOptions.class, faceLandmarkerGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, FaceLandmarkerGraphOptions.class);
        }

        public static FaceLandmarkerGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FaceLandmarkerGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto$1, reason: invalid class name */
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
