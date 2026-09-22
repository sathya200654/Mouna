package com.google.mediapipe.tasks.vision.posedetector.proto;

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
public final class PoseDetectorGraphOptionsProto {

    public interface PoseDetectorGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        float getMinDetectionConfidence();

        float getMinSuppressionThreshold();

        int getNumPoses();

        boolean hasBaseOptions();

        boolean hasMinDetectionConfidence();

        boolean hasMinSuppressionThreshold();

        boolean hasNumPoses();
    }

    private PoseDetectorGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) PoseDetectorGraphOptions.ext);
    }

    public static final class PoseDetectorGraphOptions extends GeneratedMessageLite<PoseDetectorGraphOptions, Builder> implements PoseDetectorGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final PoseDetectorGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 514774813;
        public static final int MIN_DETECTION_CONFIDENCE_FIELD_NUMBER = 2;
        public static final int MIN_SUPPRESSION_THRESHOLD_FIELD_NUMBER = 3;
        public static final int NUM_POSES_FIELD_NUMBER = 4;
        private static volatile Parser<PoseDetectorGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, PoseDetectorGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private float minDetectionConfidence_ = 0.5f;
        private float minSuppressionThreshold_ = 0.5f;
        private int numPoses_;

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

        private PoseDetectorGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
        public boolean hasMinDetectionConfidence() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
        public boolean hasMinSuppressionThreshold() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
        public boolean hasNumPoses() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
        public int getNumPoses() {
            return this.numPoses_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNumPoses(int value) {
            this.bitField0_ |= 8;
            this.numPoses_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNumPoses() {
            this.bitField0_ &= -9;
            this.numPoses_ = 0;
        }

        public static PoseDetectorGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PoseDetectorGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PoseDetectorGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PoseDetectorGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PoseDetectorGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static PoseDetectorGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static PoseDetectorGraphOptions parseFrom(InputStream input) throws IOException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PoseDetectorGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PoseDetectorGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (PoseDetectorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static PoseDetectorGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PoseDetectorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static PoseDetectorGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static PoseDetectorGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PoseDetectorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(PoseDetectorGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PoseDetectorGraphOptions, Builder> implements PoseDetectorGraphOptionsOrBuilder {
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
                super(PoseDetectorGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((PoseDetectorGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((PoseDetectorGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public boolean hasMinDetectionConfidence() {
                return ((PoseDetectorGraphOptions) this.instance).hasMinDetectionConfidence();
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public float getMinDetectionConfidence() {
                return ((PoseDetectorGraphOptions) this.instance).getMinDetectionConfidence();
            }

            public Builder setMinDetectionConfidence(float value) {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).setMinDetectionConfidence(value);
                return this;
            }

            public Builder clearMinDetectionConfidence() {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).clearMinDetectionConfidence();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public boolean hasMinSuppressionThreshold() {
                return ((PoseDetectorGraphOptions) this.instance).hasMinSuppressionThreshold();
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public float getMinSuppressionThreshold() {
                return ((PoseDetectorGraphOptions) this.instance).getMinSuppressionThreshold();
            }

            public Builder setMinSuppressionThreshold(float value) {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).setMinSuppressionThreshold(value);
                return this;
            }

            public Builder clearMinSuppressionThreshold() {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).clearMinSuppressionThreshold();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public boolean hasNumPoses() {
                return ((PoseDetectorGraphOptions) this.instance).hasNumPoses();
            }

            @Override // com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto.PoseDetectorGraphOptionsOrBuilder
            public int getNumPoses() {
                return ((PoseDetectorGraphOptions) this.instance).getNumPoses();
            }

            public Builder setNumPoses(int value) {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).setNumPoses(value);
                return this;
            }

            public Builder clearNumPoses() {
                copyOnWrite();
                ((PoseDetectorGraphOptions) this.instance).clearNumPoses();
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
                    return new PoseDetectorGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004င\u0003", new Object[]{"bitField0_", "baseOptions_", "minDetectionConfidence_", "minSuppressionThreshold_", "numPoses_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<PoseDetectorGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (PoseDetectorGraphOptions.class) {
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
            PoseDetectorGraphOptions poseDetectorGraphOptions = new PoseDetectorGraphOptions();
            DEFAULT_INSTANCE = poseDetectorGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(PoseDetectorGraphOptions.class, poseDetectorGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, PoseDetectorGraphOptions.class);
        }

        public static PoseDetectorGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PoseDetectorGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.posedetector.proto.PoseDetectorGraphOptionsProto$1, reason: invalid class name */
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
