package com.google.mediapipe.tasks.vision.handlandmarker.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.mediapipe.tasks.vision.handdetector.proto.HandDetectorGraphOptionsProto;
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
public final class HandLandmarkerGraphOptionsProto {

    public interface HandLandmarkerGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        HandDetectorGraphOptionsProto.HandDetectorGraphOptions getHandDetectorGraphOptions();

        HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions getHandLandmarksDetectorGraphOptions();

        float getMinTrackingConfidence();

        boolean hasBaseOptions();

        boolean hasHandDetectorGraphOptions();

        boolean hasHandLandmarksDetectorGraphOptions();

        boolean hasMinTrackingConfidence();
    }

    private HandLandmarkerGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) HandLandmarkerGraphOptions.ext);
    }

    public static final class HandLandmarkerGraphOptions extends GeneratedMessageLite<HandLandmarkerGraphOptions, Builder> implements HandLandmarkerGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final HandLandmarkerGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 462713202;
        public static final int HAND_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 2;
        public static final int HAND_LANDMARKS_DETECTOR_GRAPH_OPTIONS_FIELD_NUMBER = 3;
        public static final int MIN_TRACKING_CONFIDENCE_FIELD_NUMBER = 4;
        private static volatile Parser<HandLandmarkerGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, HandLandmarkerGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private HandDetectorGraphOptionsProto.HandDetectorGraphOptions handDetectorGraphOptions_;
        private HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions handLandmarksDetectorGraphOptions_;
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

        private HandLandmarkerGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
        public boolean hasHandDetectorGraphOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
        public HandDetectorGraphOptionsProto.HandDetectorGraphOptions getHandDetectorGraphOptions() {
            HandDetectorGraphOptionsProto.HandDetectorGraphOptions handDetectorGraphOptions = this.handDetectorGraphOptions_;
            return handDetectorGraphOptions == null ? HandDetectorGraphOptionsProto.HandDetectorGraphOptions.getDefaultInstance() : handDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHandDetectorGraphOptions(HandDetectorGraphOptionsProto.HandDetectorGraphOptions value) {
            value.getClass();
            this.handDetectorGraphOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeHandDetectorGraphOptions(HandDetectorGraphOptionsProto.HandDetectorGraphOptions value) {
            value.getClass();
            HandDetectorGraphOptionsProto.HandDetectorGraphOptions handDetectorGraphOptions = this.handDetectorGraphOptions_;
            if (handDetectorGraphOptions != null && handDetectorGraphOptions != HandDetectorGraphOptionsProto.HandDetectorGraphOptions.getDefaultInstance()) {
                this.handDetectorGraphOptions_ = (HandDetectorGraphOptionsProto.HandDetectorGraphOptions) HandDetectorGraphOptionsProto.HandDetectorGraphOptions.newBuilder(this.handDetectorGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.handDetectorGraphOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHandDetectorGraphOptions() {
            this.handDetectorGraphOptions_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
        public boolean hasHandLandmarksDetectorGraphOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
        public HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions getHandLandmarksDetectorGraphOptions() {
            HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions handLandmarksDetectorGraphOptions = this.handLandmarksDetectorGraphOptions_;
            return handLandmarksDetectorGraphOptions == null ? HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.getDefaultInstance() : handLandmarksDetectorGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
            value.getClass();
            this.handLandmarksDetectorGraphOptions_ = value;
            this.bitField0_ |= 4;
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
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHandLandmarksDetectorGraphOptions() {
            this.handLandmarksDetectorGraphOptions_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
        public boolean hasMinTrackingConfidence() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
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

        public static HandLandmarkerGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HandLandmarkerGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HandLandmarkerGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HandLandmarkerGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HandLandmarkerGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HandLandmarkerGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HandLandmarkerGraphOptions parseFrom(InputStream input) throws IOException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static HandLandmarkerGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static HandLandmarkerGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (HandLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static HandLandmarkerGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandLandmarkerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static HandLandmarkerGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static HandLandmarkerGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandLandmarkerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(HandLandmarkerGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<HandLandmarkerGraphOptions, Builder> implements HandLandmarkerGraphOptionsOrBuilder {
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
                super(HandLandmarkerGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((HandLandmarkerGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((HandLandmarkerGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public boolean hasHandDetectorGraphOptions() {
                return ((HandLandmarkerGraphOptions) this.instance).hasHandDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public HandDetectorGraphOptionsProto.HandDetectorGraphOptions getHandDetectorGraphOptions() {
                return ((HandLandmarkerGraphOptions) this.instance).getHandDetectorGraphOptions();
            }

            public Builder setHandDetectorGraphOptions(HandDetectorGraphOptionsProto.HandDetectorGraphOptions value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setHandDetectorGraphOptions(value);
                return this;
            }

            public Builder setHandDetectorGraphOptions(HandDetectorGraphOptionsProto.HandDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setHandDetectorGraphOptions((HandDetectorGraphOptionsProto.HandDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeHandDetectorGraphOptions(HandDetectorGraphOptionsProto.HandDetectorGraphOptions value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).mergeHandDetectorGraphOptions(value);
                return this;
            }

            public Builder clearHandDetectorGraphOptions() {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).clearHandDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public boolean hasHandLandmarksDetectorGraphOptions() {
                return ((HandLandmarkerGraphOptions) this.instance).hasHandLandmarksDetectorGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions getHandLandmarksDetectorGraphOptions() {
                return ((HandLandmarkerGraphOptions) this.instance).getHandLandmarksDetectorGraphOptions();
            }

            public Builder setHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setHandLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder setHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setHandLandmarksDetectorGraphOptions((HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeHandLandmarksDetectorGraphOptions(HandLandmarksDetectorGraphOptionsProto.HandLandmarksDetectorGraphOptions value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).mergeHandLandmarksDetectorGraphOptions(value);
                return this;
            }

            public Builder clearHandLandmarksDetectorGraphOptions() {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).clearHandLandmarksDetectorGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public boolean hasMinTrackingConfidence() {
                return ((HandLandmarkerGraphOptions) this.instance).hasMinTrackingConfidence();
            }

            @Override // com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto.HandLandmarkerGraphOptionsOrBuilder
            public float getMinTrackingConfidence() {
                return ((HandLandmarkerGraphOptions) this.instance).getMinTrackingConfidence();
            }

            public Builder setMinTrackingConfidence(float value) {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).setMinTrackingConfidence(value);
                return this;
            }

            public Builder clearMinTrackingConfidence() {
                copyOnWrite();
                ((HandLandmarkerGraphOptions) this.instance).clearMinTrackingConfidence();
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
                    return new HandLandmarkerGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "baseOptions_", "handDetectorGraphOptions_", "handLandmarksDetectorGraphOptions_", "minTrackingConfidence_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HandLandmarkerGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (HandLandmarkerGraphOptions.class) {
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
            HandLandmarkerGraphOptions handLandmarkerGraphOptions = new HandLandmarkerGraphOptions();
            DEFAULT_INSTANCE = handLandmarkerGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(HandLandmarkerGraphOptions.class, handLandmarkerGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, HandLandmarkerGraphOptions.class);
        }

        public static HandLandmarkerGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HandLandmarkerGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.handlandmarker.proto.HandLandmarkerGraphOptionsProto$1, reason: invalid class name */
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
