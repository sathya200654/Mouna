package com.google.mediapipe.tasks.vision.objectdetector.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
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
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ObjectDetectorOptionsProto {

    public interface ObjectDetectorOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        String getCategoryAllowlist(int index);

        ByteString getCategoryAllowlistBytes(int index);

        int getCategoryAllowlistCount();

        List<String> getCategoryAllowlistList();

        String getCategoryDenylist(int index);

        ByteString getCategoryDenylistBytes(int index);

        int getCategoryDenylistCount();

        List<String> getCategoryDenylistList();

        String getDisplayNamesLocale();

        ByteString getDisplayNamesLocaleBytes();

        int getMaxResults();

        float getMinSuppressionThreshold();

        boolean getMulticlassNms();

        float getScoreThreshold();

        boolean hasBaseOptions();

        boolean hasDisplayNamesLocale();

        boolean hasMaxResults();

        boolean hasMinSuppressionThreshold();

        boolean hasMulticlassNms();

        boolean hasScoreThreshold();
    }

    private ObjectDetectorOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) ObjectDetectorOptions.ext);
    }

    public static final class ObjectDetectorOptions extends GeneratedMessageLite<ObjectDetectorOptions, Builder> implements ObjectDetectorOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        public static final int CATEGORY_ALLOWLIST_FIELD_NUMBER = 5;
        public static final int CATEGORY_DENYLIST_FIELD_NUMBER = 6;
        private static final ObjectDetectorOptions DEFAULT_INSTANCE;
        public static final int DISPLAY_NAMES_LOCALE_FIELD_NUMBER = 2;
        public static final int EXT_FIELD_NUMBER = 443442058;
        public static final int MAX_RESULTS_FIELD_NUMBER = 3;
        public static final int MIN_SUPPRESSION_THRESHOLD_FIELD_NUMBER = 8;
        public static final int MULTICLASS_NMS_FIELD_NUMBER = 7;
        private static volatile Parser<ObjectDetectorOptions> PARSER = null;
        public static final int SCORE_THRESHOLD_FIELD_NUMBER = 4;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, ObjectDetectorOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private boolean multiclassNms_;
        private float scoreThreshold_;
        private String displayNamesLocale_ = "en";
        private int maxResults_ = -1;
        private Internal.ProtobufList<String> categoryAllowlist_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.ProtobufList<String> categoryDenylist_ = GeneratedMessageLite.emptyProtobufList();
        private float minSuppressionThreshold_ = 0.3f;

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

        private ObjectDetectorOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean hasDisplayNamesLocale() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public String getDisplayNamesLocale() {
            return this.displayNamesLocale_;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public ByteString getDisplayNamesLocaleBytes() {
            return ByteString.copyFromUtf8(this.displayNamesLocale_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayNamesLocale(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.displayNamesLocale_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDisplayNamesLocale() {
            this.bitField0_ &= -3;
            this.displayNamesLocale_ = getDefaultInstance().getDisplayNamesLocale();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayNamesLocaleBytes(ByteString value) {
            this.displayNamesLocale_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean hasMaxResults() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public int getMaxResults() {
            return this.maxResults_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMaxResults(int value) {
            this.bitField0_ |= 4;
            this.maxResults_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMaxResults() {
            this.bitField0_ &= -5;
            this.maxResults_ = -1;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean hasScoreThreshold() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public float getScoreThreshold() {
            return this.scoreThreshold_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScoreThreshold(float value) {
            this.bitField0_ |= 8;
            this.scoreThreshold_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScoreThreshold() {
            this.bitField0_ &= -9;
            this.scoreThreshold_ = 0.0f;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public List<String> getCategoryAllowlistList() {
            return this.categoryAllowlist_;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public int getCategoryAllowlistCount() {
            return this.categoryAllowlist_.size();
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public String getCategoryAllowlist(int index) {
            return this.categoryAllowlist_.get(index);
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public ByteString getCategoryAllowlistBytes(int index) {
            return ByteString.copyFromUtf8(this.categoryAllowlist_.get(index));
        }

        private void ensureCategoryAllowlistIsMutable() {
            Internal.ProtobufList<String> protobufList = this.categoryAllowlist_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.categoryAllowlist_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCategoryAllowlist(int index, String value) {
            value.getClass();
            ensureCategoryAllowlistIsMutable();
            this.categoryAllowlist_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCategoryAllowlist(String value) {
            value.getClass();
            ensureCategoryAllowlistIsMutable();
            this.categoryAllowlist_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCategoryAllowlist(Iterable<String> values) {
            ensureCategoryAllowlistIsMutable();
            AbstractMessageLite.addAll(values, this.categoryAllowlist_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCategoryAllowlist() {
            this.categoryAllowlist_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCategoryAllowlistBytes(ByteString value) {
            ensureCategoryAllowlistIsMutable();
            this.categoryAllowlist_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public List<String> getCategoryDenylistList() {
            return this.categoryDenylist_;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public int getCategoryDenylistCount() {
            return this.categoryDenylist_.size();
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public String getCategoryDenylist(int index) {
            return this.categoryDenylist_.get(index);
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public ByteString getCategoryDenylistBytes(int index) {
            return ByteString.copyFromUtf8(this.categoryDenylist_.get(index));
        }

        private void ensureCategoryDenylistIsMutable() {
            Internal.ProtobufList<String> protobufList = this.categoryDenylist_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.categoryDenylist_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCategoryDenylist(int index, String value) {
            value.getClass();
            ensureCategoryDenylistIsMutable();
            this.categoryDenylist_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCategoryDenylist(String value) {
            value.getClass();
            ensureCategoryDenylistIsMutable();
            this.categoryDenylist_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCategoryDenylist(Iterable<String> values) {
            ensureCategoryDenylistIsMutable();
            AbstractMessageLite.addAll(values, this.categoryDenylist_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCategoryDenylist() {
            this.categoryDenylist_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCategoryDenylistBytes(ByteString value) {
            ensureCategoryDenylistIsMutable();
            this.categoryDenylist_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean hasMulticlassNms() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean getMulticlassNms() {
            return this.multiclassNms_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMulticlassNms(boolean value) {
            this.bitField0_ |= 16;
            this.multiclassNms_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMulticlassNms() {
            this.bitField0_ &= -17;
            this.multiclassNms_ = false;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public boolean hasMinSuppressionThreshold() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
        public float getMinSuppressionThreshold() {
            return this.minSuppressionThreshold_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMinSuppressionThreshold(float value) {
            this.bitField0_ |= 32;
            this.minSuppressionThreshold_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMinSuppressionThreshold() {
            this.bitField0_ &= -33;
            this.minSuppressionThreshold_ = 0.3f;
        }

        public static ObjectDetectorOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ObjectDetectorOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ObjectDetectorOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ObjectDetectorOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ObjectDetectorOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ObjectDetectorOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ObjectDetectorOptions parseFrom(InputStream input) throws IOException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ObjectDetectorOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ObjectDetectorOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (ObjectDetectorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ObjectDetectorOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObjectDetectorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ObjectDetectorOptions parseFrom(CodedInputStream input) throws IOException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ObjectDetectorOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ObjectDetectorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ObjectDetectorOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ObjectDetectorOptions, Builder> implements ObjectDetectorOptionsOrBuilder {
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
                super(ObjectDetectorOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((ObjectDetectorOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((ObjectDetectorOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean hasDisplayNamesLocale() {
                return ((ObjectDetectorOptions) this.instance).hasDisplayNamesLocale();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public String getDisplayNamesLocale() {
                return ((ObjectDetectorOptions) this.instance).getDisplayNamesLocale();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public ByteString getDisplayNamesLocaleBytes() {
                return ((ObjectDetectorOptions) this.instance).getDisplayNamesLocaleBytes();
            }

            public Builder setDisplayNamesLocale(String value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setDisplayNamesLocale(value);
                return this;
            }

            public Builder clearDisplayNamesLocale() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearDisplayNamesLocale();
                return this;
            }

            public Builder setDisplayNamesLocaleBytes(ByteString value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setDisplayNamesLocaleBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean hasMaxResults() {
                return ((ObjectDetectorOptions) this.instance).hasMaxResults();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public int getMaxResults() {
                return ((ObjectDetectorOptions) this.instance).getMaxResults();
            }

            public Builder setMaxResults(int value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setMaxResults(value);
                return this;
            }

            public Builder clearMaxResults() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearMaxResults();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean hasScoreThreshold() {
                return ((ObjectDetectorOptions) this.instance).hasScoreThreshold();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public float getScoreThreshold() {
                return ((ObjectDetectorOptions) this.instance).getScoreThreshold();
            }

            public Builder setScoreThreshold(float value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setScoreThreshold(value);
                return this;
            }

            public Builder clearScoreThreshold() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearScoreThreshold();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public List<String> getCategoryAllowlistList() {
                return Collections.unmodifiableList(((ObjectDetectorOptions) this.instance).getCategoryAllowlistList());
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public int getCategoryAllowlistCount() {
                return ((ObjectDetectorOptions) this.instance).getCategoryAllowlistCount();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public String getCategoryAllowlist(int index) {
                return ((ObjectDetectorOptions) this.instance).getCategoryAllowlist(index);
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public ByteString getCategoryAllowlistBytes(int index) {
                return ((ObjectDetectorOptions) this.instance).getCategoryAllowlistBytes(index);
            }

            public Builder setCategoryAllowlist(int index, String value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setCategoryAllowlist(index, value);
                return this;
            }

            public Builder addCategoryAllowlist(String value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).addCategoryAllowlist(value);
                return this;
            }

            public Builder addAllCategoryAllowlist(Iterable<String> values) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).addAllCategoryAllowlist(values);
                return this;
            }

            public Builder clearCategoryAllowlist() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearCategoryAllowlist();
                return this;
            }

            public Builder addCategoryAllowlistBytes(ByteString value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).addCategoryAllowlistBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public List<String> getCategoryDenylistList() {
                return Collections.unmodifiableList(((ObjectDetectorOptions) this.instance).getCategoryDenylistList());
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public int getCategoryDenylistCount() {
                return ((ObjectDetectorOptions) this.instance).getCategoryDenylistCount();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public String getCategoryDenylist(int index) {
                return ((ObjectDetectorOptions) this.instance).getCategoryDenylist(index);
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public ByteString getCategoryDenylistBytes(int index) {
                return ((ObjectDetectorOptions) this.instance).getCategoryDenylistBytes(index);
            }

            public Builder setCategoryDenylist(int index, String value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setCategoryDenylist(index, value);
                return this;
            }

            public Builder addCategoryDenylist(String value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).addCategoryDenylist(value);
                return this;
            }

            public Builder addAllCategoryDenylist(Iterable<String> values) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).addAllCategoryDenylist(values);
                return this;
            }

            public Builder clearCategoryDenylist() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearCategoryDenylist();
                return this;
            }

            public Builder addCategoryDenylistBytes(ByteString value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).addCategoryDenylistBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean hasMulticlassNms() {
                return ((ObjectDetectorOptions) this.instance).hasMulticlassNms();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean getMulticlassNms() {
                return ((ObjectDetectorOptions) this.instance).getMulticlassNms();
            }

            public Builder setMulticlassNms(boolean value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setMulticlassNms(value);
                return this;
            }

            public Builder clearMulticlassNms() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearMulticlassNms();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public boolean hasMinSuppressionThreshold() {
                return ((ObjectDetectorOptions) this.instance).hasMinSuppressionThreshold();
            }

            @Override // com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto.ObjectDetectorOptionsOrBuilder
            public float getMinSuppressionThreshold() {
                return ((ObjectDetectorOptions) this.instance).getMinSuppressionThreshold();
            }

            public Builder setMinSuppressionThreshold(float value) {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).setMinSuppressionThreshold(value);
                return this;
            }

            public Builder clearMinSuppressionThreshold() {
                copyOnWrite();
                ((ObjectDetectorOptions) this.instance).clearMinSuppressionThreshold();
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
                    return new ObjectDetectorOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ခ\u0003\u0005\u001a\u0006\u001a\u0007ဇ\u0004\bခ\u0005", new Object[]{"bitField0_", "baseOptions_", "displayNamesLocale_", "maxResults_", "scoreThreshold_", "categoryAllowlist_", "categoryDenylist_", "multiclassNms_", "minSuppressionThreshold_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ObjectDetectorOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ObjectDetectorOptions.class) {
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
            ObjectDetectorOptions objectDetectorOptions = new ObjectDetectorOptions();
            DEFAULT_INSTANCE = objectDetectorOptions;
            GeneratedMessageLite.registerDefaultInstance(ObjectDetectorOptions.class, objectDetectorOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, ObjectDetectorOptions.class);
        }

        public static ObjectDetectorOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ObjectDetectorOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.objectdetector.proto.ObjectDetectorOptionsProto$1, reason: invalid class name */
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
