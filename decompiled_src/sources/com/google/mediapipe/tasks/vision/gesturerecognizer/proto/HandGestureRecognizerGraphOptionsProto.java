package com.google.mediapipe.tasks.vision.gesturerecognizer.proto;

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
public final class HandGestureRecognizerGraphOptionsProto {

    public interface HandGestureRecognizerGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions getCannedGestureClassifierGraphOptions();

        GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions getCustomGestureClassifierGraphOptions();

        GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions getGestureEmbedderGraphOptions();

        boolean hasBaseOptions();

        boolean hasCannedGestureClassifierGraphOptions();

        boolean hasCustomGestureClassifierGraphOptions();

        boolean hasGestureEmbedderGraphOptions();
    }

    private HandGestureRecognizerGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) HandGestureRecognizerGraphOptions.ext);
    }

    public static final class HandGestureRecognizerGraphOptions extends GeneratedMessageLite<HandGestureRecognizerGraphOptions, Builder> implements HandGestureRecognizerGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        public static final int CANNED_GESTURE_CLASSIFIER_GRAPH_OPTIONS_FIELD_NUMBER = 3;
        public static final int CUSTOM_GESTURE_CLASSIFIER_GRAPH_OPTIONS_FIELD_NUMBER = 4;
        private static final HandGestureRecognizerGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 463370452;
        public static final int GESTURE_EMBEDDER_GRAPH_OPTIONS_FIELD_NUMBER = 2;
        private static volatile Parser<HandGestureRecognizerGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, HandGestureRecognizerGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions cannedGestureClassifierGraphOptions_;
        private GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions customGestureClassifierGraphOptions_;
        private GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions gestureEmbedderGraphOptions_;

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

        private HandGestureRecognizerGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public boolean hasGestureEmbedderGraphOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions getGestureEmbedderGraphOptions() {
            GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions gestureEmbedderGraphOptions = this.gestureEmbedderGraphOptions_;
            return gestureEmbedderGraphOptions == null ? GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions.getDefaultInstance() : gestureEmbedderGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGestureEmbedderGraphOptions(GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions value) {
            value.getClass();
            this.gestureEmbedderGraphOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeGestureEmbedderGraphOptions(GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions value) {
            value.getClass();
            GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions gestureEmbedderGraphOptions = this.gestureEmbedderGraphOptions_;
            if (gestureEmbedderGraphOptions != null && gestureEmbedderGraphOptions != GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions.getDefaultInstance()) {
                this.gestureEmbedderGraphOptions_ = (GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions) GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions.newBuilder(this.gestureEmbedderGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.gestureEmbedderGraphOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGestureEmbedderGraphOptions() {
            this.gestureEmbedderGraphOptions_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public boolean hasCannedGestureClassifierGraphOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions getCannedGestureClassifierGraphOptions() {
            GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions gestureClassifierGraphOptions = this.cannedGestureClassifierGraphOptions_;
            return gestureClassifierGraphOptions == null ? GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.getDefaultInstance() : gestureClassifierGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCannedGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
            value.getClass();
            this.cannedGestureClassifierGraphOptions_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCannedGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
            value.getClass();
            GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions gestureClassifierGraphOptions = this.cannedGestureClassifierGraphOptions_;
            if (gestureClassifierGraphOptions != null && gestureClassifierGraphOptions != GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.getDefaultInstance()) {
                this.cannedGestureClassifierGraphOptions_ = (GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions) GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.newBuilder(this.cannedGestureClassifierGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.cannedGestureClassifierGraphOptions_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCannedGestureClassifierGraphOptions() {
            this.cannedGestureClassifierGraphOptions_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public boolean hasCustomGestureClassifierGraphOptions() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
        public GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions getCustomGestureClassifierGraphOptions() {
            GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions gestureClassifierGraphOptions = this.customGestureClassifierGraphOptions_;
            return gestureClassifierGraphOptions == null ? GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.getDefaultInstance() : gestureClassifierGraphOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCustomGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
            value.getClass();
            this.customGestureClassifierGraphOptions_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeCustomGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
            value.getClass();
            GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions gestureClassifierGraphOptions = this.customGestureClassifierGraphOptions_;
            if (gestureClassifierGraphOptions != null && gestureClassifierGraphOptions != GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.getDefaultInstance()) {
                this.customGestureClassifierGraphOptions_ = (GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions) GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.newBuilder(this.customGestureClassifierGraphOptions_).mergeFrom(value).buildPartial();
            } else {
                this.customGestureClassifierGraphOptions_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCustomGestureClassifierGraphOptions() {
            this.customGestureClassifierGraphOptions_ = null;
            this.bitField0_ &= -9;
        }

        public static HandGestureRecognizerGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(InputStream input) throws IOException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static HandGestureRecognizerGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (HandGestureRecognizerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static HandGestureRecognizerGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandGestureRecognizerGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static HandGestureRecognizerGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HandGestureRecognizerGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(HandGestureRecognizerGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<HandGestureRecognizerGraphOptions, Builder> implements HandGestureRecognizerGraphOptionsOrBuilder {
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
                super(HandGestureRecognizerGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public boolean hasGestureEmbedderGraphOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).hasGestureEmbedderGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions getGestureEmbedderGraphOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).getGestureEmbedderGraphOptions();
            }

            public Builder setGestureEmbedderGraphOptions(GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setGestureEmbedderGraphOptions(value);
                return this;
            }

            public Builder setGestureEmbedderGraphOptions(GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setGestureEmbedderGraphOptions((GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeGestureEmbedderGraphOptions(GestureEmbedderGraphOptionsProto.GestureEmbedderGraphOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).mergeGestureEmbedderGraphOptions(value);
                return this;
            }

            public Builder clearGestureEmbedderGraphOptions() {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).clearGestureEmbedderGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public boolean hasCannedGestureClassifierGraphOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).hasCannedGestureClassifierGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions getCannedGestureClassifierGraphOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).getCannedGestureClassifierGraphOptions();
            }

            public Builder setCannedGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setCannedGestureClassifierGraphOptions(value);
                return this;
            }

            public Builder setCannedGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setCannedGestureClassifierGraphOptions((GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeCannedGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).mergeCannedGestureClassifierGraphOptions(value);
                return this;
            }

            public Builder clearCannedGestureClassifierGraphOptions() {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).clearCannedGestureClassifierGraphOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public boolean hasCustomGestureClassifierGraphOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).hasCustomGestureClassifierGraphOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto.HandGestureRecognizerGraphOptionsOrBuilder
            public GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions getCustomGestureClassifierGraphOptions() {
                return ((HandGestureRecognizerGraphOptions) this.instance).getCustomGestureClassifierGraphOptions();
            }

            public Builder setCustomGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setCustomGestureClassifierGraphOptions(value);
                return this;
            }

            public Builder setCustomGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).setCustomGestureClassifierGraphOptions((GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions) builderForValue.build());
                return this;
            }

            public Builder mergeCustomGestureClassifierGraphOptions(GestureClassifierGraphOptionsProto.GestureClassifierGraphOptions value) {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).mergeCustomGestureClassifierGraphOptions(value);
                return this;
            }

            public Builder clearCustomGestureClassifierGraphOptions() {
                copyOnWrite();
                ((HandGestureRecognizerGraphOptions) this.instance).clearCustomGestureClassifierGraphOptions();
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
                    return new HandGestureRecognizerGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"bitField0_", "baseOptions_", "gestureEmbedderGraphOptions_", "cannedGestureClassifierGraphOptions_", "customGestureClassifierGraphOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<HandGestureRecognizerGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (HandGestureRecognizerGraphOptions.class) {
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
            HandGestureRecognizerGraphOptions handGestureRecognizerGraphOptions = new HandGestureRecognizerGraphOptions();
            DEFAULT_INSTANCE = handGestureRecognizerGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(HandGestureRecognizerGraphOptions.class, handGestureRecognizerGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, HandGestureRecognizerGraphOptions.class);
        }

        public static HandGestureRecognizerGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HandGestureRecognizerGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.gesturerecognizer.proto.HandGestureRecognizerGraphOptionsProto$1, reason: invalid class name */
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
