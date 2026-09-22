package com.google.mediapipe.tasks.vision.poselandmarker.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto;
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
public final class PoseLandmarkerGraphOptionsProto {

    public interface PoseLandmarkerGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        float getMinTrackingConfidence();

        PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions getPoseDetectorGraphOptions();

        PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions getPoseLandmarksDetectorGraphOptions();

        boolean hasBaseOptions();

        boolean hasMinTrackingConfidence();

        boolean hasPoseDetectorGraphOptions();

        boolean hasPoseLandmarksDetectorGraphOptions();
    }

    private PoseLandmarkerGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) PoseLandmarkerGraphOptions.ext);
    }

    public static final class PoseLandmarkerGraphOptions extends GeneratedMessageLite<PoseLandmarkerGraphOptions, Builder> implements PoseLandmarkerGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final PoseLandmarkerGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 516587230;
        public static final int MIN_TRACKING_CONFIDENCE_FIELD_NUMBER = 4;
        private static volatile Parser<PoseLandmarkerGraphOptions> PARSER = null;
        public static final int POSE_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 2;
        public static final int POSE_LANDMARKS_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 3;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, PoseLandmarkerGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private float minTrackingConfidence_ = 0.5f;
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

        private PoseLandmarkerGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
        public boolean hasPoseDetectorGraphOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
        public PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions getPoseDetectorGraphOptions() {
            PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions poseDetectorGraphOptions = this.poseDetectorGraphOptions_;
            return poseDetectorGraphOptions == null ? PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.getDefaultInstance() : poseDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
            value.getClass();
            this.poseDetectorGraphOptions_ = value;
            this.bitField0_ |= 2;
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
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoseDetectorGraphOptions() {
            this.poseDetectorGraphOptions_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
        public boolean hasPoseLandmarksDetectorGraphOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
        public PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions getPoseLandmarksDetectorGraphOptions() {
            PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions poseLandmarksDetectorGraphOptions = this.poseLandmarksDetectorGraphOptions_;
            return poseLandmarksDetectorGraphOptions == null ? PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.getDefaultInstance() : poseLandmarksDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
            value.getClass();
            this.poseLandmarksDetectorGraphOptions_ = value;
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoseLandmarksDetectorGraphOptions() {
            this.poseLandmarksDetectorGraphOptions_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
        public boolean hasMinTrackingConfidence() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
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

        public static PoseLandmarkerGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PoseLandmarkerGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PoseLandmarkerGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PoseLandmarkerGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PoseLandmarkerGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PoseLandmarkerGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PoseLandmarkerGraphOptions parseFrom(InputStream input) throws IOException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PoseLandmarkerGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PoseLandmarkerGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (PoseLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PoseLandmarkerGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PoseLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PoseLandmarkerGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PoseLandmarkerGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PoseLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PoseLandmarkerGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PoseLandmarkerGraphOptions, Builder> implements PoseLandmarkerGraphOptionsOrBuilder {
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
                super(PoseLandmarkerGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((PoseLandmarkerGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((PoseLandmarkerGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public boolean hasPoseDetectorGraphOptions() {
                return ((PoseLandmarkerGraphOptions) this.instance).hasPoseDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions getPoseDetectorGraphOptions() {
                return ((PoseLandmarkerGraphOptions) this.instance).getPoseDetectorGraphOptions();
            }

            public Builder setPoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setPoseDetectorGraphOptions(value);
                return this;
            }

            public Builder setPoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setPoseDetectorGraphOptions((PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergePoseDetectorGraphOptions(PoseDetectorGraphOptionsProto.PoseDetectorGraphOptions value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).mergePoseDetectorGraphOptions(value);
                return this;
            }

            public Builder clearPoseDetectorGraphOptions() {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).clearPoseDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public boolean hasPoseLandmarksDetectorGraphOptions() {
                return ((PoseLandmarkerGraphOptions) this.instance).hasPoseLandmarksDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions getPoseLandmarksDetectorGraphOptions() {
                return ((PoseLandmarkerGraphOptions) this.instance).getPoseLandmarksDetectorGraphOptions();
            }

            public Builder setPoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setPoseLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder setPoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setPoseLandmarksDetectorGraphOptions((PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergePoseLandmarksDetectorGraphOptions(PoseLandmarksDetectorGraphOptionsProto.PoseLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).mergePoseLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder clearPoseLandmarksDetectorGraphOptions() {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).clearPoseLandmarksDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public boolean hasMinTrackingConfidence() {
                return ((PoseLandmarkerGraphOptions) this.instance).hasMinTrackingConfidence();
            }

            @Override // com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto.PoseLandmarkerGraphOptionsOrBuilder
            public float getMinTrackingConfidence() {
                return ((PoseLandmarkerGraphOptions) this.instance).getMinTrackingConfidence();
            }

            public Builder setMinTrackingConfidence(float value) {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).setMinTrackingConfidence(value);
                return this;
            }

            public Builder clearMinTrackingConfidence() {
                copyOnWrite();
                ((PoseLandmarkerGraphOptions) this.instance).clearMinTrackingConfidence();
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
                    return new PoseLandmarkerGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "baseOptions_", "poseDetectorGraphOptions_", "poseLandmarksDetectorGraphOptions_", "minTrackingConfidence_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PoseLandmarkerGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PoseLandmarkerGraphOptions.class) {
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
            PoseLandmarkerGraphOptions poseLandmarkerGraphOptions = new PoseLandmarkerGraphOptions();
            DEFAULT_INSTANCE = poseLandmarkerGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(PoseLandmarkerGraphOptions.class, poseLandmarkerGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, PoseLandmarkerGraphOptions.class);
        }

        public static PoseLandmarkerGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PoseLandmarkerGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.poselandmarker.proto.PoseLandmarkerGraphOptionsProto$1, reason: invalid class name */
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
