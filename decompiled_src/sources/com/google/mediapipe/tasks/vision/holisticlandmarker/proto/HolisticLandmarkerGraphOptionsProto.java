package com.google.mediapipe.tasks.vision.holisticlandmarker.proto;

import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.mediapipe.tasks.vision.facedetector.proto.FaceDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarksDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarksDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.handlandmarker.proto.HandRoiRefinementGraphOptionsProto;
import com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto;
import com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarksDetectorGraphOptionsProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class HolisticLandmarkerGraphOptionsProto {

    public interface HolisticLandmarkerGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions getFaceDetectorGraphOptions();

        FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions getFaceLandmarksDetectorGraphOptions();

        HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions getHandLandmarksDetectorGraphOptions();

        HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions getHandRoiRefinementGraphOptions();

        PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions getPoseDetectorGraphOptions();

        PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions getPoseLandmarksDetectorGraphOptions();

        boolean hasBaseOptions();

        boolean hasFaceDetectorGraphOptions();

        boolean hasFaceLandmarksDetectorGraphOptions();

        boolean hasHandLandmarksDetectorGraphOptions();

        boolean hasHandRoiRefinementGraphOptions();

        boolean hasPoseDetectorGraphOptions();

        boolean hasPoseLandmarksDetectorGraphOptions();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private HolisticLandmarkerGraphOptionsProto() {
    }

    public static final class HolisticLandmarkerGraphOptions extends GeneratedMessageLite<HolisticLandmarkerGraphOptions, Builder> implements HolisticLandmarkerGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final HolisticLandmarkerGraphOptions DEFAULT_INSTANCE;
        public static final int FACE_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 4;
        public static final int FACE_LANDMARKS_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 5;
        public static final int HAND_LANDMARKS_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 2;
        public static final int HAND_ROI_REFINEMENT_GRAPH_OPTIONS_FIELD_NUMBER = 3;
        private static volatile Parser<HolisticLandmarkerGraphOptions> PARSER = null;
        public static final int POSE_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 6;
        public static final int POSE_LANDMARKS_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 7;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions faceDetectorGraphOptions_;
        private FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions faceLandmarksDetectorGraphOptions_;
        private HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions handLandmarksDetectorGraphOptions_;
        private HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions handRoiRefinementGraphOptions_;
        private PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions poseDetectorGraphOptions_;
        private PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions poseLandmarksDetectorGraphOptions_;

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

        private HolisticLandmarkerGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasHandLandmarksDetectorGraphOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions getHandLandmarksDetectorGraphOptions() {
            HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions handLandmarksDetectorGraphOptions = this.handLandmarksDetectorGraphOptions_;
            return handLandmarksDetectorGraphOptions == null ? HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.getDefaultInstance() : handLandmarksDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
            value.getClass();
            this.handLandmarksDetectorGraphOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
            value.getClass();
            HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions handLandmarksDetectorGraphOptions = this.handLandmarksDetectorGraphOptions_;
            if (handLandmarksDetectorGraphOptions != null && handLandmarksDetectorGraphOptions != HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.getDefaultInstance()) {
                this.handLandmarksDetectorGraphOptions_ = (HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions) HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.newBuilder(this.handLandmarksDetectorGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.handLandmarksDetectorGraphOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHandLandmarksDetectorGraphOptions() {
            this.handLandmarksDetectorGraphOptions_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasHandRoiRefinementGraphOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions getHandRoiRefinementGraphOptions() {
            HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions handRoiRefinementGraphOptions = this.handRoiRefinementGraphOptions_;
            return handRoiRefinementGraphOptions == null ? HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions.getDefaultInstance() : handRoiRefinementGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHandRoiRefinementGraphOptions(HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions value) {
            value.getClass();
            this.handRoiRefinementGraphOptions_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHandRoiRefinementGraphOptions(HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions value) {
            value.getClass();
            HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions handRoiRefinementGraphOptions = this.handRoiRefinementGraphOptions_;
            if (handRoiRefinementGraphOptions != null && handRoiRefinementGraphOptions != HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions.getDefaultInstance()) {
                this.handRoiRefinementGraphOptions_ = (HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions) HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions.newBuilder(this.handRoiRefinementGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.handRoiRefinementGraphOptions_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHandRoiRefinementGraphOptions() {
            this.handRoiRefinementGraphOptions_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasFaceDetectorGraphOptions() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions getFaceDetectorGraphOptions() {
            FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions faceDetectorGraphOptions = this.faceDetectorGraphOptions_;
            return faceDetectorGraphOptions == null ? FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.getDefaultInstance() : faceDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
            value.getClass();
            this.faceDetectorGraphOptions_ = value;
            this.bitField0_ |= 8;
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
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceDetectorGraphOptions() {
            this.faceDetectorGraphOptions_ = null;
            this.bitField0_ &= -9;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasFaceLandmarksDetectorGraphOptions() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions getFaceLandmarksDetectorGraphOptions() {
            FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions faceLandmarksDetectorGraphOptions = this.faceLandmarksDetectorGraphOptions_;
            return faceLandmarksDetectorGraphOptions == null ? FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.getDefaultInstance() : faceLandmarksDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
            value.getClass();
            this.faceLandmarksDetectorGraphOptions_ = value;
            this.bitField0_ |= 16;
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
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceLandmarksDetectorGraphOptions() {
            this.faceLandmarksDetectorGraphOptions_ = null;
            this.bitField0_ &= -17;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasPoseDetectorGraphOptions() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions getPoseDetectorGraphOptions() {
            PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions poseDetectorGraphOptions = this.poseDetectorGraphOptions_;
            return poseDetectorGraphOptions == null ? PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.getDefaultInstance() : poseDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
            value.getClass();
            this.poseDetectorGraphOptions_ = value;
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
            value.getClass();
            PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions poseDetectorGraphOptions = this.poseDetectorGraphOptions_;
            if (poseDetectorGraphOptions != null && poseDetectorGraphOptions != PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.getDefaultInstance()) {
                this.poseDetectorGraphOptions_ = (PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions) PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.newBuilder(this.poseDetectorGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.poseDetectorGraphOptions_ = value;
            }
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoseDetectorGraphOptions() {
            this.poseDetectorGraphOptions_ = null;
            this.bitField0_ &= -33;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public boolean hasPoseLandmarksDetectorGraphOptions() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
        public PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions getPoseLandmarksDetectorGraphOptions() {
            PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions poseLandmarksDetectorGraphOptions = this.poseLandmarksDetectorGraphOptions_;
            return poseLandmarksDetectorGraphOptions == null ? PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.getDefaultInstance() : poseLandmarksDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
            value.getClass();
            this.poseLandmarksDetectorGraphOptions_ = value;
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
            value.getClass();
            PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions poseLandmarksDetectorGraphOptions = this.poseLandmarksDetectorGraphOptions_;
            if (poseLandmarksDetectorGraphOptions != null && poseLandmarksDetectorGraphOptions != PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.getDefaultInstance()) {
                this.poseLandmarksDetectorGraphOptions_ = (PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions) PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.newBuilder(this.poseLandmarksDetectorGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.poseLandmarksDetectorGraphOptions_ = value;
            }
            this.bitField0_ |= 64;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoseLandmarksDetectorGraphOptions() {
            this.poseLandmarksDetectorGraphOptions_ = null;
            this.bitField0_ &= -65;
        }

        public static HolisticLandmarkerGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(InputStream input) throws IOException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static HolisticLandmarkerGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (HolisticLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static HolisticLandmarkerGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HolisticLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static HolisticLandmarkerGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HolisticLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(HolisticLandmarkerGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<HolisticLandmarkerGraphOptions, Builder> implements HolisticLandmarkerGraphOptionsOrBuilder {
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
                super(HolisticLandmarkerGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasHandLandmarksDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasHandLandmarksDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions getHandLandmarksDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getHandLandmarksDetectorGraphOptions();
            }

            public Builder setHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setHandLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder setHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setHandLandmarksDetectorGraphOptions((HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergeHandLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder clearHandLandmarksDetectorGraphOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearHandLandmarksDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasHandRoiRefinementGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasHandRoiRefinementGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions getHandRoiRefinementGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getHandRoiRefinementGraphOptions();
            }

            public Builder setHandRoiRefinementGraphOptions(HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setHandRoiRefinementGraphOptions(value);
                return this;
            }

            public Builder setHandRoiRefinementGraphOptions(HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setHandRoiRefinementGraphOptions((HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeHandRoiRefinementGraphOptions(HandRoiRefinementGraphOptionsProto.HandRoiRefinementGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergeHandRoiRefinementGraphOptions(value);
                return this;
            }

            public Builder clearHandRoiRefinementGraphOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearHandRoiRefinementGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasFaceDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasFaceDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions getFaceDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getFaceDetectorGraphOptions();
            }

            public Builder setFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setFaceDetectorGraphOptions(value);
                return this;
            }

            public Builder setFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setFaceDetectorGraphOptions((FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceDetectorGraphOptions(FaceDetectorGraphOptionsProto.FaceDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergeFaceDetectorGraphOptions(value);
                return this;
            }

            public Builder clearFaceDetectorGraphOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearFaceDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasFaceLandmarksDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasFaceLandmarksDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions getFaceLandmarksDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getFaceLandmarksDetectorGraphOptions();
            }

            public Builder setFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setFaceLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder setFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setFaceLandmarksDetectorGraphOptions((FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceLandmarksDetectorGraphOptions(FaceLandmarksDetectorGraphOptionsProto.FaceLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergeFaceLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder clearFaceLandmarksDetectorGraphOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearFaceLandmarksDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasPoseDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasPoseDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions getPoseDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getPoseDetectorGraphOptions();
            }

            public Builder setPoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setPoseDetectorGraphOptions(value);
                return this;
            }

            public Builder setPoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setPoseDetectorGraphOptions((PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergePoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergePoseDetectorGraphOptions(value);
                return this;
            }

            public Builder clearPoseDetectorGraphOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearPoseDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public boolean hasPoseLandmarksDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).hasPoseLandmarksDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto.HolisticLandmarkerGraphOptionsOrBuilder
            public PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions getPoseLandmarksDetectorGraphOptions() {
                return ((HolisticLandmarkerGraphOptions) this.instance).getPoseLandmarksDetectorGraphOptions();
            }

            public Builder setPoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setPoseLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder setPoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).setPoseLandmarksDetectorGraphOptions((PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergePoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).mergePoseLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder clearPoseLandmarksDetectorGraphOptions() {
                copyOnWrite();
                ((HolisticLandmarkerGraphOptions) this.instance).clearPoseLandmarksDetectorGraphOptions();
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
                    return new HolisticLandmarkerGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"bitField0_", "baseOptions_", "handLandmarksDetectorGraphOptions_", "handRoiRefinementGraphOptions_", "faceDetectorGraphOptions_", "faceLandmarksDetectorGraphOptions_", "poseDetectorGraphOptions_", "poseLandmarksDetectorGraphOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HolisticLandmarkerGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (HolisticLandmarkerGraphOptions.class) {
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
            HolisticLandmarkerGraphOptions holisticLandmarkerGraphOptions = new HolisticLandmarkerGraphOptions();
            DEFAULT_INSTANCE = holisticLandmarkerGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(HolisticLandmarkerGraphOptions.class, holisticLandmarkerGraphOptions);
        }

        public static HolisticLandmarkerGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HolisticLandmarkerGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.holisticlandmarker.proto.HolisticLandmarkerGraphOptionsProto$1, reason: invalid class name */
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
