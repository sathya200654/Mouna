package com.google.mediapipe.tasks.vision.imagegenerator.proto;

import com.google.mediapipe.tasks.vision.facelandmarker.proto.FaceLandmarkerGraphOptionsProto;
import com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto;
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
public final class ConditionedImageGraphOptionsProto {

    public interface ConditionedImageGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        ConditionedImageGraphOptions.ConditionTypeOptionsCase getConditionTypeOptionsCase();

        ConditionedImageGraphOptions.DepthConditionTypeOptions getDepthConditionTypeOptions();

        ConditionedImageGraphOptions.EdgeConditionTypeOptions getEdgeConditionTypeOptions();

        ConditionedImageGraphOptions.FaceConditionTypeOptions getFaceConditionTypeOptions();

        boolean hasDepthConditionTypeOptions();

        boolean hasEdgeConditionTypeOptions();

        boolean hasFaceConditionTypeOptions();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private ConditionedImageGraphOptionsProto() {
    }

    public static final class ConditionedImageGraphOptions extends GeneratedMessageLite<ConditionedImageGraphOptions, Builder> implements ConditionedImageGraphOptionsOrBuilder {
        private static final ConditionedImageGraphOptions DEFAULT_INSTANCE;
        public static final int DEPTH_CONDITION_TYPE_OPTIONS_FIELD_NUMBER = 4;
        public static final int EDGE_CONDITION_TYPE_OPTIONS_FIELD_NUMBER = 3;
        public static final int FACE_CONDITION_TYPE_OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<ConditionedImageGraphOptions> PARSER;
        private int conditionTypeOptionsCase_ = 0;
        private Object conditionTypeOptions_;

        public interface DepthConditionTypeOptionsOrBuilder extends MessageLiteOrBuilder {
            ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions getImageSegmenterGraphOptions();

            boolean hasImageSegmenterGraphOptions();
        }

        public interface EdgeConditionTypeOptionsOrBuilder extends MessageLiteOrBuilder {
            int getApertureSize();

            boolean getL2Gradient();

            float getThreshold1();

            float getThreshold2();
        }

        public interface FaceConditionTypeOptionsOrBuilder extends MessageLiteOrBuilder {
            FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions getFaceLandmarkerGraphOptions();

            boolean hasFaceLandmarkerGraphOptions();
        }

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

        private ConditionedImageGraphOptions() {
        }

        public static final class FaceConditionTypeOptions extends GeneratedMessageLite<FaceConditionTypeOptions, Builder> implements FaceConditionTypeOptionsOrBuilder {
            private static final FaceConditionTypeOptions DEFAULT_INSTANCE;
            public static final int FACE_LANDMARKER_GRAPH_OPTIONS_FIELD_NUMBER = 1;
            private static volatile Parser<FaceConditionTypeOptions> PARSER;
            private int bitField0_;
            private FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions faceLandmarkerGraphOptions_;

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

            private FaceConditionTypeOptions() {
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.FaceConditionTypeOptionsOrBuilder
            public boolean hasFaceLandmarkerGraphOptions() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.FaceConditionTypeOptionsOrBuilder
            public FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions getFaceLandmarkerGraphOptions() {
                FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions faceLandmarkerGraphOptions = this.faceLandmarkerGraphOptions_;
                return faceLandmarkerGraphOptions == null ? FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.getDefaultInstance() : faceLandmarkerGraphOptions;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setFaceLandmarkerGraphOptions(FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions value) {
                value.getClass();
                this.faceLandmarkerGraphOptions_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeFaceLandmarkerGraphOptions(FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions value) {
                value.getClass();
                FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions faceLandmarkerGraphOptions = this.faceLandmarkerGraphOptions_;
                if (faceLandmarkerGraphOptions != null && faceLandmarkerGraphOptions != FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.getDefaultInstance()) {
                    this.faceLandmarkerGraphOptions_ = (FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions) FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.newBuilder(this.faceLandmarkerGraphOptions_).mergeFrom(value).buildPartial();
                } else {
                    this.faceLandmarkerGraphOptions_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearFaceLandmarkerGraphOptions() {
                this.faceLandmarkerGraphOptions_ = null;
                this.bitField0_ &= -2;
            }

            public static FaceConditionTypeOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FaceConditionTypeOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FaceConditionTypeOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FaceConditionTypeOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FaceConditionTypeOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static FaceConditionTypeOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static FaceConditionTypeOptions parseFrom(InputStream input) throws IOException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FaceConditionTypeOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FaceConditionTypeOptions parseDelimitedFrom(InputStream input) throws IOException {
                return (FaceConditionTypeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static FaceConditionTypeOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FaceConditionTypeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static FaceConditionTypeOptions parseFrom(CodedInputStream input) throws IOException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static FaceConditionTypeOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (FaceConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(FaceConditionTypeOptions prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<FaceConditionTypeOptions, Builder> implements FaceConditionTypeOptionsOrBuilder {
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
                    super(FaceConditionTypeOptions.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.FaceConditionTypeOptionsOrBuilder
                public boolean hasFaceLandmarkerGraphOptions() {
                    return ((FaceConditionTypeOptions) this.instance).hasFaceLandmarkerGraphOptions();
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.FaceConditionTypeOptionsOrBuilder
                public FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions getFaceLandmarkerGraphOptions() {
                    return ((FaceConditionTypeOptions) this.instance).getFaceLandmarkerGraphOptions();
                }

                public Builder setFaceLandmarkerGraphOptions(FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions value) {
                    copyOnWrite();
                    ((FaceConditionTypeOptions) this.instance).setFaceLandmarkerGraphOptions(value);
                    return this;
                }

                public Builder setFaceLandmarkerGraphOptions(FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions.Builder builderForValue) {
                    copyOnWrite();
                    ((FaceConditionTypeOptions) this.instance).setFaceLandmarkerGraphOptions((FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions) builderForValue.build());
                    return this;
                }

                public Builder mergeFaceLandmarkerGraphOptions(FaceLandmarkerGraphOptionsProto.FaceLandmarkerGraphOptions value) {
                    copyOnWrite();
                    ((FaceConditionTypeOptions) this.instance).mergeFaceLandmarkerGraphOptions(value);
                    return this;
                }

                public Builder clearFaceLandmarkerGraphOptions() {
                    copyOnWrite();
                    ((FaceConditionTypeOptions) this.instance).clearFaceLandmarkerGraphOptions();
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
                        return new FaceConditionTypeOptions();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "faceLandmarkerGraphOptions_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<FaceConditionTypeOptions> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (FaceConditionTypeOptions.class) {
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
                FaceConditionTypeOptions faceConditionTypeOptions = new FaceConditionTypeOptions();
                DEFAULT_INSTANCE = faceConditionTypeOptions;
                GeneratedMessageLite.registerDefaultInstance(FaceConditionTypeOptions.class, faceConditionTypeOptions);
            }

            public static FaceConditionTypeOptions getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<FaceConditionTypeOptions> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class EdgeConditionTypeOptions extends GeneratedMessageLite<EdgeConditionTypeOptions, Builder> implements EdgeConditionTypeOptionsOrBuilder {
            public static final int APERTURE_SIZE_FIELD_NUMBER = 3;
            private static final EdgeConditionTypeOptions DEFAULT_INSTANCE;
            public static final int L2_GRADIENT_FIELD_NUMBER = 4;
            private static volatile Parser<EdgeConditionTypeOptions> PARSER = null;
            public static final int THRESHOLD_1_FIELD_NUMBER = 1;
            public static final int THRESHOLD_2_FIELD_NUMBER = 2;
            private int apertureSize_;
            private boolean l2Gradient_;
            private float threshold1_;
            private float threshold2_;

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

            private EdgeConditionTypeOptions() {
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
            public float getThreshold1() {
                return this.threshold1_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreshold1(float value) {
                this.threshold1_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThreshold1() {
                this.threshold1_ = 0.0f;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
            public float getThreshold2() {
                return this.threshold2_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setThreshold2(float value) {
                this.threshold2_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearThreshold2() {
                this.threshold2_ = 0.0f;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
            public int getApertureSize() {
                return this.apertureSize_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setApertureSize(int value) {
                this.apertureSize_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearApertureSize() {
                this.apertureSize_ = 0;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
            public boolean getL2Gradient() {
                return this.l2Gradient_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setL2Gradient(boolean value) {
                this.l2Gradient_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearL2Gradient() {
                this.l2Gradient_ = false;
            }

            public static EdgeConditionTypeOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static EdgeConditionTypeOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static EdgeConditionTypeOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static EdgeConditionTypeOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static EdgeConditionTypeOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static EdgeConditionTypeOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static EdgeConditionTypeOptions parseFrom(InputStream input) throws IOException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static EdgeConditionTypeOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static EdgeConditionTypeOptions parseDelimitedFrom(InputStream input) throws IOException {
                return (EdgeConditionTypeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static EdgeConditionTypeOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (EdgeConditionTypeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static EdgeConditionTypeOptions parseFrom(CodedInputStream input) throws IOException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static EdgeConditionTypeOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (EdgeConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(EdgeConditionTypeOptions prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<EdgeConditionTypeOptions, Builder> implements EdgeConditionTypeOptionsOrBuilder {
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
                    super(EdgeConditionTypeOptions.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
                public float getThreshold1() {
                    return ((EdgeConditionTypeOptions) this.instance).getThreshold1();
                }

                public Builder setThreshold1(float value) {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).setThreshold1(value);
                    return this;
                }

                public Builder clearThreshold1() {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).clearThreshold1();
                    return this;
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
                public float getThreshold2() {
                    return ((EdgeConditionTypeOptions) this.instance).getThreshold2();
                }

                public Builder setThreshold2(float value) {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).setThreshold2(value);
                    return this;
                }

                public Builder clearThreshold2() {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).clearThreshold2();
                    return this;
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
                public int getApertureSize() {
                    return ((EdgeConditionTypeOptions) this.instance).getApertureSize();
                }

                public Builder setApertureSize(int value) {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).setApertureSize(value);
                    return this;
                }

                public Builder clearApertureSize() {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).clearApertureSize();
                    return this;
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.EdgeConditionTypeOptionsOrBuilder
                public boolean getL2Gradient() {
                    return ((EdgeConditionTypeOptions) this.instance).getL2Gradient();
                }

                public Builder setL2Gradient(boolean value) {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).setL2Gradient(value);
                    return this;
                }

                public Builder clearL2Gradient() {
                    copyOnWrite();
                    ((EdgeConditionTypeOptions) this.instance).clearL2Gradient();
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
                        return new EdgeConditionTypeOptions();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0001\u0002\u0001\u0003\u0004\u0004\u0007", new Object[]{"threshold1_", "threshold2_", "apertureSize_", "l2Gradient_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<EdgeConditionTypeOptions> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (EdgeConditionTypeOptions.class) {
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
                EdgeConditionTypeOptions edgeConditionTypeOptions = new EdgeConditionTypeOptions();
                DEFAULT_INSTANCE = edgeConditionTypeOptions;
                GeneratedMessageLite.registerDefaultInstance(EdgeConditionTypeOptions.class, edgeConditionTypeOptions);
            }

            public static EdgeConditionTypeOptions getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<EdgeConditionTypeOptions> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class DepthConditionTypeOptions extends GeneratedMessageLite<DepthConditionTypeOptions, Builder> implements DepthConditionTypeOptionsOrBuilder {
            private static final DepthConditionTypeOptions DEFAULT_INSTANCE;
            public static final int IMAGE_SEGMENTER_GRAPH_OPTIONS_FIELD_NUMBER = 1;
            private static volatile Parser<DepthConditionTypeOptions> PARSER;
            private int bitField0_;
            private ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions imageSegmenterGraphOptions_;

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

            private DepthConditionTypeOptions() {
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.DepthConditionTypeOptionsOrBuilder
            public boolean hasImageSegmenterGraphOptions() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.DepthConditionTypeOptionsOrBuilder
            public ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions getImageSegmenterGraphOptions() {
                ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions imageSegmenterGraphOptions = this.imageSegmenterGraphOptions_;
                return imageSegmenterGraphOptions == null ? ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.getDefaultInstance() : imageSegmenterGraphOptions;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setImageSegmenterGraphOptions(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions value) {
                value.getClass();
                this.imageSegmenterGraphOptions_ = value;
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeImageSegmenterGraphOptions(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions value) {
                value.getClass();
                ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions imageSegmenterGraphOptions = this.imageSegmenterGraphOptions_;
                if (imageSegmenterGraphOptions != null && imageSegmenterGraphOptions != ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.getDefaultInstance()) {
                    this.imageSegmenterGraphOptions_ = (ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions) ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.newBuilder(this.imageSegmenterGraphOptions_).mergeFrom(value).buildPartial();
                } else {
                    this.imageSegmenterGraphOptions_ = value;
                }
                this.bitField0_ |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearImageSegmenterGraphOptions() {
                this.imageSegmenterGraphOptions_ = null;
                this.bitField0_ &= -2;
            }

            public static DepthConditionTypeOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static DepthConditionTypeOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static DepthConditionTypeOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static DepthConditionTypeOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static DepthConditionTypeOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static DepthConditionTypeOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static DepthConditionTypeOptions parseFrom(InputStream input) throws IOException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static DepthConditionTypeOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static DepthConditionTypeOptions parseDelimitedFrom(InputStream input) throws IOException {
                return (DepthConditionTypeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static DepthConditionTypeOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DepthConditionTypeOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static DepthConditionTypeOptions parseFrom(CodedInputStream input) throws IOException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static DepthConditionTypeOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DepthConditionTypeOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(DepthConditionTypeOptions prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<DepthConditionTypeOptions, Builder> implements DepthConditionTypeOptionsOrBuilder {
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
                    super(DepthConditionTypeOptions.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.DepthConditionTypeOptionsOrBuilder
                public boolean hasImageSegmenterGraphOptions() {
                    return ((DepthConditionTypeOptions) this.instance).hasImageSegmenterGraphOptions();
                }

                @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptions.DepthConditionTypeOptionsOrBuilder
                public ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions getImageSegmenterGraphOptions() {
                    return ((DepthConditionTypeOptions) this.instance).getImageSegmenterGraphOptions();
                }

                public Builder setImageSegmenterGraphOptions(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions value) {
                    copyOnWrite();
                    ((DepthConditionTypeOptions) this.instance).setImageSegmenterGraphOptions(value);
                    return this;
                }

                public Builder setImageSegmenterGraphOptions(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions.Builder builderForValue) {
                    copyOnWrite();
                    ((DepthConditionTypeOptions) this.instance).setImageSegmenterGraphOptions((ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions) builderForValue.build());
                    return this;
                }

                public Builder mergeImageSegmenterGraphOptions(ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptions value) {
                    copyOnWrite();
                    ((DepthConditionTypeOptions) this.instance).mergeImageSegmenterGraphOptions(value);
                    return this;
                }

                public Builder clearImageSegmenterGraphOptions() {
                    copyOnWrite();
                    ((DepthConditionTypeOptions) this.instance).clearImageSegmenterGraphOptions();
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
                        return new DepthConditionTypeOptions();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "imageSegmenterGraphOptions_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<DepthConditionTypeOptions> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (DepthConditionTypeOptions.class) {
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
                DepthConditionTypeOptions depthConditionTypeOptions = new DepthConditionTypeOptions();
                DEFAULT_INSTANCE = depthConditionTypeOptions;
                GeneratedMessageLite.registerDefaultInstance(DepthConditionTypeOptions.class, depthConditionTypeOptions);
            }

            public static DepthConditionTypeOptions getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DepthConditionTypeOptions> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public enum ConditionTypeOptionsCase {
            FACE_CONDITION_TYPE_OPTIONS(2),
            EDGE_CONDITION_TYPE_OPTIONS(3),
            DEPTH_CONDITION_TYPE_OPTIONS(4),
            CONDITIONTYPEOPTIONS_NOT_SET(0);

            private final int value;

            ConditionTypeOptionsCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ConditionTypeOptionsCase valueOf(int value) {
                return forNumber(value);
            }

            public static ConditionTypeOptionsCase forNumber(int value) {
                if (value == 0) {
                    return CONDITIONTYPEOPTIONS_NOT_SET;
                }
                if (value == 2) {
                    return FACE_CONDITION_TYPE_OPTIONS;
                }
                if (value == 3) {
                    return EDGE_CONDITION_TYPE_OPTIONS;
                }
                if (value != 4) {
                    return null;
                }
                return DEPTH_CONDITION_TYPE_OPTIONS;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public ConditionTypeOptionsCase getConditionTypeOptionsCase() {
            return ConditionTypeOptionsCase.forNumber(this.conditionTypeOptionsCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConditionTypeOptions() {
            this.conditionTypeOptionsCase_ = 0;
            this.conditionTypeOptions_ = null;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public boolean hasFaceConditionTypeOptions() {
            return this.conditionTypeOptionsCase_ == 2;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public FaceConditionTypeOptions getFaceConditionTypeOptions() {
            if (this.conditionTypeOptionsCase_ == 2) {
                return (FaceConditionTypeOptions) this.conditionTypeOptions_;
            }
            return FaceConditionTypeOptions.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceConditionTypeOptions(FaceConditionTypeOptions value) {
            value.getClass();
            this.conditionTypeOptions_ = value;
            this.conditionTypeOptionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFaceConditionTypeOptions(FaceConditionTypeOptions value) {
            value.getClass();
            if (this.conditionTypeOptionsCase_ == 2 && this.conditionTypeOptions_ != FaceConditionTypeOptions.getDefaultInstance()) {
                this.conditionTypeOptions_ = FaceConditionTypeOptions.newBuilder((FaceConditionTypeOptions) this.conditionTypeOptions_).mergeFrom(value).buildPartial();
            } else {
                this.conditionTypeOptions_ = value;
            }
            this.conditionTypeOptionsCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceConditionTypeOptions() {
            if (this.conditionTypeOptionsCase_ == 2) {
                this.conditionTypeOptionsCase_ = 0;
                this.conditionTypeOptions_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public boolean hasEdgeConditionTypeOptions() {
            return this.conditionTypeOptionsCase_ == 3;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public EdgeConditionTypeOptions getEdgeConditionTypeOptions() {
            if (this.conditionTypeOptionsCase_ == 3) {
                return (EdgeConditionTypeOptions) this.conditionTypeOptions_;
            }
            return EdgeConditionTypeOptions.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEdgeConditionTypeOptions(EdgeConditionTypeOptions value) {
            value.getClass();
            this.conditionTypeOptions_ = value;
            this.conditionTypeOptionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEdgeConditionTypeOptions(EdgeConditionTypeOptions value) {
            value.getClass();
            if (this.conditionTypeOptionsCase_ == 3 && this.conditionTypeOptions_ != EdgeConditionTypeOptions.getDefaultInstance()) {
                this.conditionTypeOptions_ = EdgeConditionTypeOptions.newBuilder((EdgeConditionTypeOptions) this.conditionTypeOptions_).mergeFrom(value).buildPartial();
            } else {
                this.conditionTypeOptions_ = value;
            }
            this.conditionTypeOptionsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEdgeConditionTypeOptions() {
            if (this.conditionTypeOptionsCase_ == 3) {
                this.conditionTypeOptionsCase_ = 0;
                this.conditionTypeOptions_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public boolean hasDepthConditionTypeOptions() {
            return this.conditionTypeOptionsCase_ == 4;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
        public DepthConditionTypeOptions getDepthConditionTypeOptions() {
            if (this.conditionTypeOptionsCase_ == 4) {
                return (DepthConditionTypeOptions) this.conditionTypeOptions_;
            }
            return DepthConditionTypeOptions.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDepthConditionTypeOptions(DepthConditionTypeOptions value) {
            value.getClass();
            this.conditionTypeOptions_ = value;
            this.conditionTypeOptionsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDepthConditionTypeOptions(DepthConditionTypeOptions value) {
            value.getClass();
            if (this.conditionTypeOptionsCase_ == 4 && this.conditionTypeOptions_ != DepthConditionTypeOptions.getDefaultInstance()) {
                this.conditionTypeOptions_ = DepthConditionTypeOptions.newBuilder((DepthConditionTypeOptions) this.conditionTypeOptions_).mergeFrom(value).buildPartial();
            } else {
                this.conditionTypeOptions_ = value;
            }
            this.conditionTypeOptionsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDepthConditionTypeOptions() {
            if (this.conditionTypeOptionsCase_ == 4) {
                this.conditionTypeOptionsCase_ = 0;
                this.conditionTypeOptions_ = null;
            }
        }

        public static ConditionedImageGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ConditionedImageGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ConditionedImageGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ConditionedImageGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ConditionedImageGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ConditionedImageGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ConditionedImageGraphOptions parseFrom(InputStream input) throws IOException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ConditionedImageGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ConditionedImageGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (ConditionedImageGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ConditionedImageGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ConditionedImageGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ConditionedImageGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ConditionedImageGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ConditionedImageGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ConditionedImageGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ConditionedImageGraphOptions, Builder> implements ConditionedImageGraphOptionsOrBuilder {
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
                super(ConditionedImageGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public ConditionTypeOptionsCase getConditionTypeOptionsCase() {
                return ((ConditionedImageGraphOptions) this.instance).getConditionTypeOptionsCase();
            }

            public Builder clearConditionTypeOptions() {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).clearConditionTypeOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public boolean hasFaceConditionTypeOptions() {
                return ((ConditionedImageGraphOptions) this.instance).hasFaceConditionTypeOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public FaceConditionTypeOptions getFaceConditionTypeOptions() {
                return ((ConditionedImageGraphOptions) this.instance).getFaceConditionTypeOptions();
            }

            public Builder setFaceConditionTypeOptions(FaceConditionTypeOptions value) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).setFaceConditionTypeOptions(value);
                return this;
            }

            public Builder setFaceConditionTypeOptions(FaceConditionTypeOptions.Builder builderForValue) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).setFaceConditionTypeOptions((FaceConditionTypeOptions) builderForValue.build());
                return this;
            }

            public Builder mergeFaceConditionTypeOptions(FaceConditionTypeOptions value) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).mergeFaceConditionTypeOptions(value);
                return this;
            }

            public Builder clearFaceConditionTypeOptions() {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).clearFaceConditionTypeOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public boolean hasEdgeConditionTypeOptions() {
                return ((ConditionedImageGraphOptions) this.instance).hasEdgeConditionTypeOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public EdgeConditionTypeOptions getEdgeConditionTypeOptions() {
                return ((ConditionedImageGraphOptions) this.instance).getEdgeConditionTypeOptions();
            }

            public Builder setEdgeConditionTypeOptions(EdgeConditionTypeOptions value) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).setEdgeConditionTypeOptions(value);
                return this;
            }

            public Builder setEdgeConditionTypeOptions(EdgeConditionTypeOptions.Builder builderForValue) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).setEdgeConditionTypeOptions((EdgeConditionTypeOptions) builderForValue.build());
                return this;
            }

            public Builder mergeEdgeConditionTypeOptions(EdgeConditionTypeOptions value) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).mergeEdgeConditionTypeOptions(value);
                return this;
            }

            public Builder clearEdgeConditionTypeOptions() {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).clearEdgeConditionTypeOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public boolean hasDepthConditionTypeOptions() {
                return ((ConditionedImageGraphOptions) this.instance).hasDepthConditionTypeOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto.ConditionedImageGraphOptionsOrBuilder
            public DepthConditionTypeOptions getDepthConditionTypeOptions() {
                return ((ConditionedImageGraphOptions) this.instance).getDepthConditionTypeOptions();
            }

            public Builder setDepthConditionTypeOptions(DepthConditionTypeOptions value) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).setDepthConditionTypeOptions(value);
                return this;
            }

            public Builder setDepthConditionTypeOptions(DepthConditionTypeOptions.Builder builderForValue) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).setDepthConditionTypeOptions((DepthConditionTypeOptions) builderForValue.build());
                return this;
            }

            public Builder mergeDepthConditionTypeOptions(DepthConditionTypeOptions value) {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).mergeDepthConditionTypeOptions(value);
                return this;
            }

            public Builder clearDepthConditionTypeOptions() {
                copyOnWrite();
                ((ConditionedImageGraphOptions) this.instance).clearDepthConditionTypeOptions();
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
                    return new ConditionedImageGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0002\u0004\u0003\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"conditionTypeOptions_", "conditionTypeOptionsCase_", FaceConditionTypeOptions.class, EdgeConditionTypeOptions.class, DepthConditionTypeOptions.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ConditionedImageGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ConditionedImageGraphOptions.class) {
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
            ConditionedImageGraphOptions conditionedImageGraphOptions = new ConditionedImageGraphOptions();
            DEFAULT_INSTANCE = conditionedImageGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(ConditionedImageGraphOptions.class, conditionedImageGraphOptions);
        }

        public static ConditionedImageGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ConditionedImageGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.imagegenerator.proto.ConditionedImageGraphOptionsProto$1, reason: invalid class name */
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
