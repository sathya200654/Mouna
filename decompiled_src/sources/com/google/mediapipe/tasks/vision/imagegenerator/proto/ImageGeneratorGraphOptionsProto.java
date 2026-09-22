package com.google.mediapipe.tasks.vision.imagegenerator.proto;

import com.google.mediapipe.calculator.proto.StableDiffusionIterateCalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.ExternalFileProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ImageGeneratorGraphOptionsProto {

    public interface ImageGeneratorGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        ControlPluginGraphOptionsProto.ControlPluginGraphOptions getControlPluginGraphsOptions(int index);

        int getControlPluginGraphsOptionsCount();

        List<ControlPluginGraphOptionsProto.ControlPluginGraphOptions> getControlPluginGraphsOptionsList();

        ExternalFileProto.ExternalFile getLoraWeightsFile();

        StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions getStableDiffusionIterateOptions();

        String getText2ImageModelDirectory();

        ByteString getText2ImageModelDirectoryBytes();

        boolean hasLoraWeightsFile();

        boolean hasStableDiffusionIterateOptions();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private ImageGeneratorGraphOptionsProto() {
    }

    public static final class ImageGeneratorGraphOptions extends GeneratedMessageLite<ImageGeneratorGraphOptions, Builder> implements ImageGeneratorGraphOptionsOrBuilder {
        public static final int CONTROL_PLUGIN_GRAPHS_OPTIONS_FIELD_NUMBER = 3;
        private static final ImageGeneratorGraphOptions DEFAULT_INSTANCE;
        public static final int LORA_WEIGHTS_FILE_FIELD_NUMBER = 2;
        private static volatile Parser<ImageGeneratorGraphOptions> PARSER = null;
        public static final int STABLE_DIFFUSION_ITERATE_OPTIONS_FIELD_NUMBER = 4;
        public static final int TEXT2IMAGE_MODEL_DIRECTORY_FIELD_NUMBER = 1;
        private int bitField0_;
        private ExternalFileProto.ExternalFile loraWeightsFile_;
        private StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions stableDiffusionIterateOptions_;
        private String text2ImageModelDirectory_ = "";
        private Internal.ProtobufList<ControlPluginGraphOptionsProto.ControlPluginGraphOptions> controlPluginGraphsOptions_ = emptyProtobufList();

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

        private ImageGeneratorGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public String getText2ImageModelDirectory() {
            return this.text2ImageModelDirectory_;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public ByteString getText2ImageModelDirectoryBytes() {
            return ByteString.copyFromUtf8(this.text2ImageModelDirectory_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText2ImageModelDirectory(String value) {
            value.getClass();
            this.text2ImageModelDirectory_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearText2ImageModelDirectory() {
            this.text2ImageModelDirectory_ = getDefaultInstance().getText2ImageModelDirectory();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText2ImageModelDirectoryBytes(ByteString value) {
            checkByteStringIsUtf8(value);
            this.text2ImageModelDirectory_ = value.toStringUtf8();
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public boolean hasLoraWeightsFile() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public ExternalFileProto.ExternalFile getLoraWeightsFile() {
            ExternalFileProto.ExternalFile externalFile = this.loraWeightsFile_;
            return externalFile == null ? ExternalFileProto.ExternalFile.getDefaultInstance() : externalFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoraWeightsFile(ExternalFileProto.ExternalFile value) {
            value.getClass();
            this.loraWeightsFile_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLoraWeightsFile(ExternalFileProto.ExternalFile value) {
            value.getClass();
            ExternalFileProto.ExternalFile externalFile = this.loraWeightsFile_;
            if (externalFile != null && externalFile != ExternalFileProto.ExternalFile.getDefaultInstance()) {
                this.loraWeightsFile_ = (ExternalFileProto.ExternalFile) ExternalFileProto.ExternalFile.newBuilder(this.loraWeightsFile_).mergeFrom(value).buildPartial();
            } else {
                this.loraWeightsFile_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoraWeightsFile() {
            this.loraWeightsFile_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public List<ControlPluginGraphOptionsProto.ControlPluginGraphOptions> getControlPluginGraphsOptionsList() {
            return this.controlPluginGraphsOptions_;
        }

        public List<? extends ControlPluginGraphOptionsProto.ControlPluginGraphOptionsOrBuilder> getControlPluginGraphsOptionsOrBuilderList() {
            return this.controlPluginGraphsOptions_;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public int getControlPluginGraphsOptionsCount() {
            return this.controlPluginGraphsOptions_.size();
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public ControlPluginGraphOptionsProto.ControlPluginGraphOptions getControlPluginGraphsOptions(int index) {
            return this.controlPluginGraphsOptions_.get(index);
        }

        public ControlPluginGraphOptionsProto.ControlPluginGraphOptionsOrBuilder getControlPluginGraphsOptionsOrBuilder(int index) {
            return this.controlPluginGraphsOptions_.get(index);
        }

        private void ensureControlPluginGraphsOptionsIsMutable() {
            Internal.ProtobufList<ControlPluginGraphOptionsProto.ControlPluginGraphOptions> protobufList = this.controlPluginGraphsOptions_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.controlPluginGraphsOptions_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setControlPluginGraphsOptions(int index, ControlPluginGraphOptionsProto.ControlPluginGraphOptions value) {
            value.getClass();
            ensureControlPluginGraphsOptionsIsMutable();
            this.controlPluginGraphsOptions_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addControlPluginGraphsOptions(ControlPluginGraphOptionsProto.ControlPluginGraphOptions value) {
            value.getClass();
            ensureControlPluginGraphsOptionsIsMutable();
            this.controlPluginGraphsOptions_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addControlPluginGraphsOptions(int index, ControlPluginGraphOptionsProto.ControlPluginGraphOptions value) {
            value.getClass();
            ensureControlPluginGraphsOptionsIsMutable();
            this.controlPluginGraphsOptions_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllControlPluginGraphsOptions(Iterable<? extends ControlPluginGraphOptionsProto.ControlPluginGraphOptions> values) {
            ensureControlPluginGraphsOptionsIsMutable();
            AbstractMessageLite.addAll(values, this.controlPluginGraphsOptions_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearControlPluginGraphsOptions() {
            this.controlPluginGraphsOptions_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeControlPluginGraphsOptions(int index) {
            ensureControlPluginGraphsOptionsIsMutable();
            this.controlPluginGraphsOptions_.remove(index);
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public boolean hasStableDiffusionIterateOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
        public StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions getStableDiffusionIterateOptions() {
            StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions stableDiffusionIterateCalculatorOptions = this.stableDiffusionIterateOptions_;
            return stableDiffusionIterateCalculatorOptions == null ? StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions.getDefaultInstance() : stableDiffusionIterateCalculatorOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStableDiffusionIterateOptions(StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions value) {
            value.getClass();
            this.stableDiffusionIterateOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeStableDiffusionIterateOptions(StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions value) {
            value.getClass();
            StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions stableDiffusionIterateCalculatorOptions = this.stableDiffusionIterateOptions_;
            if (stableDiffusionIterateCalculatorOptions != null && stableDiffusionIterateCalculatorOptions != StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions.getDefaultInstance()) {
                this.stableDiffusionIterateOptions_ = (StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions) StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions.newBuilder(this.stableDiffusionIterateOptions_).mergeFrom(value).buildPartial();
            } else {
                this.stableDiffusionIterateOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStableDiffusionIterateOptions() {
            this.stableDiffusionIterateOptions_ = null;
            this.bitField0_ &= -3;
        }

        public static ImageGeneratorGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ImageGeneratorGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ImageGeneratorGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ImageGeneratorGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ImageGeneratorGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ImageGeneratorGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ImageGeneratorGraphOptions parseFrom(InputStream input) throws IOException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ImageGeneratorGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ImageGeneratorGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (ImageGeneratorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ImageGeneratorGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ImageGeneratorGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ImageGeneratorGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ImageGeneratorGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ImageGeneratorGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ImageGeneratorGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ImageGeneratorGraphOptions, Builder> implements ImageGeneratorGraphOptionsOrBuilder {
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
                super(ImageGeneratorGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public String getText2ImageModelDirectory() {
                return ((ImageGeneratorGraphOptions) this.instance).getText2ImageModelDirectory();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public ByteString getText2ImageModelDirectoryBytes() {
                return ((ImageGeneratorGraphOptions) this.instance).getText2ImageModelDirectoryBytes();
            }

            public Builder setText2ImageModelDirectory(String value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setText2ImageModelDirectory(value);
                return this;
            }

            public Builder clearText2ImageModelDirectory() {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).clearText2ImageModelDirectory();
                return this;
            }

            public Builder setText2ImageModelDirectoryBytes(ByteString value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setText2ImageModelDirectoryBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public boolean hasLoraWeightsFile() {
                return ((ImageGeneratorGraphOptions) this.instance).hasLoraWeightsFile();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public ExternalFileProto.ExternalFile getLoraWeightsFile() {
                return ((ImageGeneratorGraphOptions) this.instance).getLoraWeightsFile();
            }

            public Builder setLoraWeightsFile(ExternalFileProto.ExternalFile value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setLoraWeightsFile(value);
                return this;
            }

            public Builder setLoraWeightsFile(ExternalFileProto.ExternalFile.Builder builderForValue) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setLoraWeightsFile((ExternalFileProto.ExternalFile) builderForValue.build());
                return this;
            }

            public Builder mergeLoraWeightsFile(ExternalFileProto.ExternalFile value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).mergeLoraWeightsFile(value);
                return this;
            }

            public Builder clearLoraWeightsFile() {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).clearLoraWeightsFile();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public List<ControlPluginGraphOptionsProto.ControlPluginGraphOptions> getControlPluginGraphsOptionsList() {
                return Collections.unmodifiableList(((ImageGeneratorGraphOptions) this.instance).getControlPluginGraphsOptionsList());
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public int getControlPluginGraphsOptionsCount() {
                return ((ImageGeneratorGraphOptions) this.instance).getControlPluginGraphsOptionsCount();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public ControlPluginGraphOptionsProto.ControlPluginGraphOptions getControlPluginGraphsOptions(int index) {
                return ((ImageGeneratorGraphOptions) this.instance).getControlPluginGraphsOptions(index);
            }

            public Builder setControlPluginGraphsOptions(int index, ControlPluginGraphOptionsProto.ControlPluginGraphOptions value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setControlPluginGraphsOptions(index, value);
                return this;
            }

            public Builder setControlPluginGraphsOptions(int index, ControlPluginGraphOptionsProto.ControlPluginGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setControlPluginGraphsOptions(index, (ControlPluginGraphOptionsProto.ControlPluginGraphOptions) builderForValue.build());
                return this;
            }

            public Builder addControlPluginGraphsOptions(ControlPluginGraphOptionsProto.ControlPluginGraphOptions value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).addControlPluginGraphsOptions(value);
                return this;
            }

            public Builder addControlPluginGraphsOptions(int index, ControlPluginGraphOptionsProto.ControlPluginGraphOptions value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).addControlPluginGraphsOptions(index, value);
                return this;
            }

            public Builder addControlPluginGraphsOptions(ControlPluginGraphOptionsProto.ControlPluginGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).addControlPluginGraphsOptions((ControlPluginGraphOptionsProto.ControlPluginGraphOptions) builderForValue.build());
                return this;
            }

            public Builder addControlPluginGraphsOptions(int index, ControlPluginGraphOptionsProto.ControlPluginGraphOptions.Builder builderForValue) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).addControlPluginGraphsOptions(index, (ControlPluginGraphOptionsProto.ControlPluginGraphOptions) builderForValue.build());
                return this;
            }

            public Builder addAllControlPluginGraphsOptions(Iterable<? extends ControlPluginGraphOptionsProto.ControlPluginGraphOptions> values) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).addAllControlPluginGraphsOptions(values);
                return this;
            }

            public Builder clearControlPluginGraphsOptions() {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).clearControlPluginGraphsOptions();
                return this;
            }

            public Builder removeControlPluginGraphsOptions(int index) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).removeControlPluginGraphsOptions(index);
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public boolean hasStableDiffusionIterateOptions() {
                return ((ImageGeneratorGraphOptions) this.instance).hasStableDiffusionIterateOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto.ImageGeneratorGraphOptionsOrBuilder
            public StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions getStableDiffusionIterateOptions() {
                return ((ImageGeneratorGraphOptions) this.instance).getStableDiffusionIterateOptions();
            }

            public Builder setStableDiffusionIterateOptions(StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setStableDiffusionIterateOptions(value);
                return this;
            }

            public Builder setStableDiffusionIterateOptions(StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions.Builder builderForValue) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).setStableDiffusionIterateOptions((StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions) builderForValue.build());
                return this;
            }

            public Builder mergeStableDiffusionIterateOptions(StableDiffusionIterateCalculatorOptionsProto.StableDiffusionIterateCalculatorOptions value) {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).mergeStableDiffusionIterateOptions(value);
                return this;
            }

            public Builder clearStableDiffusionIterateOptions() {
                copyOnWrite();
                ((ImageGeneratorGraphOptions) this.instance).clearStableDiffusionIterateOptions();
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
                    return new ImageGeneratorGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002ဉ\u0000\u0003\u001b\u0004ဉ\u0001", new Object[]{"bitField0_", "text2ImageModelDirectory_", "loraWeightsFile_", "controlPluginGraphsOptions_", ControlPluginGraphOptionsProto.ControlPluginGraphOptions.class, "stableDiffusionIterateOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ImageGeneratorGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ImageGeneratorGraphOptions.class) {
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
            ImageGeneratorGraphOptions imageGeneratorGraphOptions = new ImageGeneratorGraphOptions();
            DEFAULT_INSTANCE = imageGeneratorGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(ImageGeneratorGraphOptions.class, imageGeneratorGraphOptions);
        }

        public static ImageGeneratorGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImageGeneratorGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.imagegenerator.proto.ImageGeneratorGraphOptionsProto$1, reason: invalid class name */
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
