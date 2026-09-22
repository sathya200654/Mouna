package com.google.mediapipe.tasks.components.containers.proto;

import com.google.mediapipe.formats.proto.ClassificationProto;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.formats.proto.RectProto;
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
public final class LandmarksDetectionResultProto {

    public interface LandmarksDetectionResultOrBuilder extends MessageLiteOrBuilder {
        ClassificationProto.ClassificationList getClassifications();

        LandmarkProto.NormalizedLandmarkList getLandmarks();

        RectProto.NormalizedRect getRect();

        LandmarkProto.LandmarkList getWorldLandmarks();

        boolean hasClassifications();

        boolean hasLandmarks();

        boolean hasRect();

        boolean hasWorldLandmarks();
    }

    public interface MultiLandmarksDetectionResultOrBuilder extends MessageLiteOrBuilder {
        ClassificationProto.ClassificationList getClassifications(int index);

        int getClassificationsCount();

        List<ClassificationProto.ClassificationList> getClassificationsList();

        LandmarkProto.NormalizedLandmarkList getLandmarks(int index);

        int getLandmarksCount();

        List<LandmarkProto.NormalizedLandmarkList> getLandmarksList();

        RectProto.NormalizedRect getRects(int index);

        int getRectsCount();

        List<RectProto.NormalizedRect> getRectsList();

        LandmarkProto.LandmarkList getWorldLandmarks(int index);

        int getWorldLandmarksCount();

        List<LandmarkProto.LandmarkList> getWorldLandmarksList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private LandmarksDetectionResultProto() {
    }

    public static final class LandmarksDetectionResult extends GeneratedMessageLite<LandmarksDetectionResult, Builder> implements LandmarksDetectionResultOrBuilder {
        public static final int CLASSIFICATIONS_FIELD_NUMBER = 2;
        private static final LandmarksDetectionResult DEFAULT_INSTANCE;
        public static final int LANDMARKS_FIELD_NUMBER = 1;
        private static volatile Parser<LandmarksDetectionResult> PARSER = null;
        public static final int RECT_FIELD_NUMBER = 4;
        public static final int WORLD_LANDMARKS_FIELD_NUMBER = 3;
        private int bitField0_;
        private ClassificationProto.ClassificationList classifications_;
        private LandmarkProto.NormalizedLandmarkList landmarks_;
        private byte memoizedIsInitialized = 2;
        private RectProto.NormalizedRect rect_;
        private LandmarkProto.LandmarkList worldLandmarks_;

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

        private LandmarksDetectionResult() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public boolean hasLandmarks() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public LandmarkProto.NormalizedLandmarkList getLandmarks() {
            LandmarkProto.NormalizedLandmarkList normalizedLandmarkList = this.landmarks_;
            return normalizedLandmarkList == null ? LandmarkProto.NormalizedLandmarkList.getDefaultInstance() : normalizedLandmarkList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandmarks(LandmarkProto.NormalizedLandmarkList value) {
            value.getClass();
            this.landmarks_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLandmarks(LandmarkProto.NormalizedLandmarkList value) {
            value.getClass();
            LandmarkProto.NormalizedLandmarkList normalizedLandmarkList = this.landmarks_;
            if (normalizedLandmarkList != null && normalizedLandmarkList != LandmarkProto.NormalizedLandmarkList.getDefaultInstance()) {
                this.landmarks_ = (LandmarkProto.NormalizedLandmarkList) LandmarkProto.NormalizedLandmarkList.newBuilder(this.landmarks_).mergeFrom(value).buildPartial();
            } else {
                this.landmarks_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandmarks() {
            this.landmarks_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public boolean hasClassifications() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public ClassificationProto.ClassificationList getClassifications() {
            ClassificationProto.ClassificationList classificationList = this.classifications_;
            return classificationList == null ? ClassificationProto.ClassificationList.getDefaultInstance() : classificationList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassifications(ClassificationProto.ClassificationList value) {
            value.getClass();
            this.classifications_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClassifications(ClassificationProto.ClassificationList value) {
            value.getClass();
            ClassificationProto.ClassificationList classificationList = this.classifications_;
            if (classificationList != null && classificationList != ClassificationProto.ClassificationList.getDefaultInstance()) {
                this.classifications_ = (ClassificationProto.ClassificationList) ClassificationProto.ClassificationList.newBuilder(this.classifications_).mergeFrom(value).buildPartial();
            } else {
                this.classifications_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassifications() {
            this.classifications_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public boolean hasWorldLandmarks() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public LandmarkProto.LandmarkList getWorldLandmarks() {
            LandmarkProto.LandmarkList landmarkList = this.worldLandmarks_;
            return landmarkList == null ? LandmarkProto.LandmarkList.getDefaultInstance() : landmarkList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWorldLandmarks(LandmarkProto.LandmarkList value) {
            value.getClass();
            this.worldLandmarks_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeWorldLandmarks(LandmarkProto.LandmarkList value) {
            value.getClass();
            LandmarkProto.LandmarkList landmarkList = this.worldLandmarks_;
            if (landmarkList != null && landmarkList != LandmarkProto.LandmarkList.getDefaultInstance()) {
                this.worldLandmarks_ = (LandmarkProto.LandmarkList) LandmarkProto.LandmarkList.newBuilder(this.worldLandmarks_).mergeFrom(value).buildPartial();
            } else {
                this.worldLandmarks_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWorldLandmarks() {
            this.worldLandmarks_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public boolean hasRect() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
        public RectProto.NormalizedRect getRect() {
            RectProto.NormalizedRect normalizedRect = this.rect_;
            return normalizedRect == null ? RectProto.NormalizedRect.getDefaultInstance() : normalizedRect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRect(RectProto.NormalizedRect value) {
            value.getClass();
            this.rect_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRect(RectProto.NormalizedRect value) {
            value.getClass();
            RectProto.NormalizedRect normalizedRect = this.rect_;
            if (normalizedRect != null && normalizedRect != RectProto.NormalizedRect.getDefaultInstance()) {
                this.rect_ = (RectProto.NormalizedRect) RectProto.NormalizedRect.newBuilder(this.rect_).mergeFrom(value).buildPartial();
            } else {
                this.rect_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRect() {
            this.rect_ = null;
            this.bitField0_ &= -9;
        }

        public static LandmarksDetectionResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarksDetectionResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarksDetectionResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarksDetectionResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarksDetectionResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarksDetectionResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarksDetectionResult parseFrom(InputStream input) throws IOException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarksDetectionResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LandmarksDetectionResult parseDelimitedFrom(InputStream input) throws IOException {
            return (LandmarksDetectionResult) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarksDetectionResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarksDetectionResult) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LandmarksDetectionResult parseFrom(CodedInputStream input) throws IOException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarksDetectionResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LandmarksDetectionResult prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LandmarksDetectionResult, Builder> implements LandmarksDetectionResultOrBuilder {
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
                super(LandmarksDetectionResult.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public boolean hasLandmarks() {
                return ((LandmarksDetectionResult) this.instance).hasLandmarks();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public LandmarkProto.NormalizedLandmarkList getLandmarks() {
                return ((LandmarksDetectionResult) this.instance).getLandmarks();
            }

            public Builder setLandmarks(LandmarkProto.NormalizedLandmarkList value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setLandmarks(value);
                return this;
            }

            public Builder setLandmarks(LandmarkProto.NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setLandmarks((LandmarkProto.NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder mergeLandmarks(LandmarkProto.NormalizedLandmarkList value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).mergeLandmarks(value);
                return this;
            }

            public Builder clearLandmarks() {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).clearLandmarks();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public boolean hasClassifications() {
                return ((LandmarksDetectionResult) this.instance).hasClassifications();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public ClassificationProto.ClassificationList getClassifications() {
                return ((LandmarksDetectionResult) this.instance).getClassifications();
            }

            public Builder setClassifications(ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setClassifications(value);
                return this;
            }

            public Builder setClassifications(ClassificationProto.ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setClassifications((ClassificationProto.ClassificationList) builderForValue.build());
                return this;
            }

            public Builder mergeClassifications(ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).mergeClassifications(value);
                return this;
            }

            public Builder clearClassifications() {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).clearClassifications();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public boolean hasWorldLandmarks() {
                return ((LandmarksDetectionResult) this.instance).hasWorldLandmarks();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public LandmarkProto.LandmarkList getWorldLandmarks() {
                return ((LandmarksDetectionResult) this.instance).getWorldLandmarks();
            }

            public Builder setWorldLandmarks(LandmarkProto.LandmarkList value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setWorldLandmarks(value);
                return this;
            }

            public Builder setWorldLandmarks(LandmarkProto.LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setWorldLandmarks((LandmarkProto.LandmarkList) builderForValue.build());
                return this;
            }

            public Builder mergeWorldLandmarks(LandmarkProto.LandmarkList value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).mergeWorldLandmarks(value);
                return this;
            }

            public Builder clearWorldLandmarks() {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).clearWorldLandmarks();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public boolean hasRect() {
                return ((LandmarksDetectionResult) this.instance).hasRect();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.LandmarksDetectionResultOrBuilder
            public RectProto.NormalizedRect getRect() {
                return ((LandmarksDetectionResult) this.instance).getRect();
            }

            public Builder setRect(RectProto.NormalizedRect value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setRect(value);
                return this;
            }

            public Builder setRect(RectProto.NormalizedRect.Builder builderForValue) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).setRect((RectProto.NormalizedRect) builderForValue.build());
                return this;
            }

            public Builder mergeRect(RectProto.NormalizedRect value) {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).mergeRect(value);
                return this;
            }

            public Builder clearRect() {
                copyOnWrite();
                ((LandmarksDetectionResult) this.instance).clearRect();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new LandmarksDetectionResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003", new Object[]{"bitField0_", "landmarks_", "classifications_", "worldLandmarks_", "rect_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LandmarksDetectionResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LandmarksDetectionResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            LandmarksDetectionResult landmarksDetectionResult = new LandmarksDetectionResult();
            DEFAULT_INSTANCE = landmarksDetectionResult;
            GeneratedMessageLite.registerDefaultInstance(LandmarksDetectionResult.class, landmarksDetectionResult);
        }

        public static LandmarksDetectionResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LandmarksDetectionResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto$1, reason: invalid class name */
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

    public static final class MultiLandmarksDetectionResult extends GeneratedMessageLite<MultiLandmarksDetectionResult, Builder> implements MultiLandmarksDetectionResultOrBuilder {
        public static final int CLASSIFICATIONS_FIELD_NUMBER = 2;
        private static final MultiLandmarksDetectionResult DEFAULT_INSTANCE;
        public static final int LANDMARKS_FIELD_NUMBER = 1;
        private static volatile Parser<MultiLandmarksDetectionResult> PARSER = null;
        public static final int RECTS_FIELD_NUMBER = 4;
        public static final int WORLD_LANDMARKS_FIELD_NUMBER = 3;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<LandmarkProto.NormalizedLandmarkList> landmarks_ = emptyProtobufList();
        private Internal.ProtobufList<ClassificationProto.ClassificationList> classifications_ = emptyProtobufList();
        private Internal.ProtobufList<LandmarkProto.LandmarkList> worldLandmarks_ = emptyProtobufList();
        private Internal.ProtobufList<RectProto.NormalizedRect> rects_ = emptyProtobufList();

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

        private MultiLandmarksDetectionResult() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public List<LandmarkProto.NormalizedLandmarkList> getLandmarksList() {
            return this.landmarks_;
        }

        public List<? extends LandmarkProto.NormalizedLandmarkListOrBuilder> getLandmarksOrBuilderList() {
            return this.landmarks_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public int getLandmarksCount() {
            return this.landmarks_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public LandmarkProto.NormalizedLandmarkList getLandmarks(int index) {
            return this.landmarks_.get(index);
        }

        public LandmarkProto.NormalizedLandmarkListOrBuilder getLandmarksOrBuilder(int index) {
            return this.landmarks_.get(index);
        }

        private void ensureLandmarksIsMutable() {
            Internal.ProtobufList<LandmarkProto.NormalizedLandmarkList> protobufList = this.landmarks_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.landmarks_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandmarks(int index, LandmarkProto.NormalizedLandmarkList value) {
            value.getClass();
            ensureLandmarksIsMutable();
            this.landmarks_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmarks(LandmarkProto.NormalizedLandmarkList value) {
            value.getClass();
            ensureLandmarksIsMutable();
            this.landmarks_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmarks(int index, LandmarkProto.NormalizedLandmarkList value) {
            value.getClass();
            ensureLandmarksIsMutable();
            this.landmarks_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLandmarks(Iterable<? extends LandmarkProto.NormalizedLandmarkList> values) {
            ensureLandmarksIsMutable();
            AbstractMessageLite.addAll(values, this.landmarks_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandmarks() {
            this.landmarks_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLandmarks(int index) {
            ensureLandmarksIsMutable();
            this.landmarks_.remove(index);
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public List<ClassificationProto.ClassificationList> getClassificationsList() {
            return this.classifications_;
        }

        public List<? extends ClassificationProto.ClassificationListOrBuilder> getClassificationsOrBuilderList() {
            return this.classifications_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public int getClassificationsCount() {
            return this.classifications_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public ClassificationProto.ClassificationList getClassifications(int index) {
            return this.classifications_.get(index);
        }

        public ClassificationProto.ClassificationListOrBuilder getClassificationsOrBuilder(int index) {
            return this.classifications_.get(index);
        }

        private void ensureClassificationsIsMutable() {
            Internal.ProtobufList<ClassificationProto.ClassificationList> protobufList = this.classifications_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.classifications_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassifications(int index, ClassificationProto.ClassificationList value) {
            value.getClass();
            ensureClassificationsIsMutable();
            this.classifications_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassifications(ClassificationProto.ClassificationList value) {
            value.getClass();
            ensureClassificationsIsMutable();
            this.classifications_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassifications(int index, ClassificationProto.ClassificationList value) {
            value.getClass();
            ensureClassificationsIsMutable();
            this.classifications_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllClassifications(Iterable<? extends ClassificationProto.ClassificationList> values) {
            ensureClassificationsIsMutable();
            AbstractMessageLite.addAll(values, this.classifications_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassifications() {
            this.classifications_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeClassifications(int index) {
            ensureClassificationsIsMutable();
            this.classifications_.remove(index);
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public List<LandmarkProto.LandmarkList> getWorldLandmarksList() {
            return this.worldLandmarks_;
        }

        public List<? extends LandmarkProto.LandmarkListOrBuilder> getWorldLandmarksOrBuilderList() {
            return this.worldLandmarks_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public int getWorldLandmarksCount() {
            return this.worldLandmarks_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public LandmarkProto.LandmarkList getWorldLandmarks(int index) {
            return this.worldLandmarks_.get(index);
        }

        public LandmarkProto.LandmarkListOrBuilder getWorldLandmarksOrBuilder(int index) {
            return this.worldLandmarks_.get(index);
        }

        private void ensureWorldLandmarksIsMutable() {
            Internal.ProtobufList<LandmarkProto.LandmarkList> protobufList = this.worldLandmarks_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.worldLandmarks_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWorldLandmarks(int index, LandmarkProto.LandmarkList value) {
            value.getClass();
            ensureWorldLandmarksIsMutable();
            this.worldLandmarks_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addWorldLandmarks(LandmarkProto.LandmarkList value) {
            value.getClass();
            ensureWorldLandmarksIsMutable();
            this.worldLandmarks_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addWorldLandmarks(int index, LandmarkProto.LandmarkList value) {
            value.getClass();
            ensureWorldLandmarksIsMutable();
            this.worldLandmarks_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllWorldLandmarks(Iterable<? extends LandmarkProto.LandmarkList> values) {
            ensureWorldLandmarksIsMutable();
            AbstractMessageLite.addAll(values, this.worldLandmarks_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWorldLandmarks() {
            this.worldLandmarks_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeWorldLandmarks(int index) {
            ensureWorldLandmarksIsMutable();
            this.worldLandmarks_.remove(index);
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public List<RectProto.NormalizedRect> getRectsList() {
            return this.rects_;
        }

        public List<? extends RectProto.NormalizedRectOrBuilder> getRectsOrBuilderList() {
            return this.rects_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public int getRectsCount() {
            return this.rects_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
        public RectProto.NormalizedRect getRects(int index) {
            return this.rects_.get(index);
        }

        public RectProto.NormalizedRectOrBuilder getRectsOrBuilder(int index) {
            return this.rects_.get(index);
        }

        private void ensureRectsIsMutable() {
            Internal.ProtobufList<RectProto.NormalizedRect> protobufList = this.rects_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.rects_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRects(int index, RectProto.NormalizedRect value) {
            value.getClass();
            ensureRectsIsMutable();
            this.rects_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRects(RectProto.NormalizedRect value) {
            value.getClass();
            ensureRectsIsMutable();
            this.rects_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRects(int index, RectProto.NormalizedRect value) {
            value.getClass();
            ensureRectsIsMutable();
            this.rects_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRects(Iterable<? extends RectProto.NormalizedRect> values) {
            ensureRectsIsMutable();
            AbstractMessageLite.addAll(values, this.rects_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRects() {
            this.rects_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRects(int index) {
            ensureRectsIsMutable();
            this.rects_.remove(index);
        }

        public static MultiLandmarksDetectionResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MultiLandmarksDetectionResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MultiLandmarksDetectionResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MultiLandmarksDetectionResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MultiLandmarksDetectionResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MultiLandmarksDetectionResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MultiLandmarksDetectionResult parseFrom(InputStream input) throws IOException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MultiLandmarksDetectionResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MultiLandmarksDetectionResult parseDelimitedFrom(InputStream input) throws IOException {
            return (MultiLandmarksDetectionResult) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MultiLandmarksDetectionResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MultiLandmarksDetectionResult) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MultiLandmarksDetectionResult parseFrom(CodedInputStream input) throws IOException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MultiLandmarksDetectionResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MultiLandmarksDetectionResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MultiLandmarksDetectionResult prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MultiLandmarksDetectionResult, Builder> implements MultiLandmarksDetectionResultOrBuilder {
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
                super(MultiLandmarksDetectionResult.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public List<LandmarkProto.NormalizedLandmarkList> getLandmarksList() {
                return Collections.unmodifiableList(((MultiLandmarksDetectionResult) this.instance).getLandmarksList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public int getLandmarksCount() {
                return ((MultiLandmarksDetectionResult) this.instance).getLandmarksCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public LandmarkProto.NormalizedLandmarkList getLandmarks(int index) {
                return ((MultiLandmarksDetectionResult) this.instance).getLandmarks(index);
            }

            public Builder setLandmarks(int index, LandmarkProto.NormalizedLandmarkList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setLandmarks(index, value);
                return this;
            }

            public Builder setLandmarks(int index, LandmarkProto.NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setLandmarks(index, (LandmarkProto.NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder addLandmarks(LandmarkProto.NormalizedLandmarkList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addLandmarks(value);
                return this;
            }

            public Builder addLandmarks(int index, LandmarkProto.NormalizedLandmarkList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addLandmarks(index, value);
                return this;
            }

            public Builder addLandmarks(LandmarkProto.NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addLandmarks((LandmarkProto.NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder addLandmarks(int index, LandmarkProto.NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addLandmarks(index, (LandmarkProto.NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder addAllLandmarks(Iterable<? extends LandmarkProto.NormalizedLandmarkList> values) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addAllLandmarks(values);
                return this;
            }

            public Builder clearLandmarks() {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).clearLandmarks();
                return this;
            }

            public Builder removeLandmarks(int index) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).removeLandmarks(index);
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public List<ClassificationProto.ClassificationList> getClassificationsList() {
                return Collections.unmodifiableList(((MultiLandmarksDetectionResult) this.instance).getClassificationsList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public int getClassificationsCount() {
                return ((MultiLandmarksDetectionResult) this.instance).getClassificationsCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public ClassificationProto.ClassificationList getClassifications(int index) {
                return ((MultiLandmarksDetectionResult) this.instance).getClassifications(index);
            }

            public Builder setClassifications(int index, ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setClassifications(index, value);
                return this;
            }

            public Builder setClassifications(int index, ClassificationProto.ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setClassifications(index, (ClassificationProto.ClassificationList) builderForValue.build());
                return this;
            }

            public Builder addClassifications(ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addClassifications(value);
                return this;
            }

            public Builder addClassifications(int index, ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addClassifications(index, value);
                return this;
            }

            public Builder addClassifications(ClassificationProto.ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addClassifications((ClassificationProto.ClassificationList) builderForValue.build());
                return this;
            }

            public Builder addClassifications(int index, ClassificationProto.ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addClassifications(index, (ClassificationProto.ClassificationList) builderForValue.build());
                return this;
            }

            public Builder addAllClassifications(Iterable<? extends ClassificationProto.ClassificationList> values) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addAllClassifications(values);
                return this;
            }

            public Builder clearClassifications() {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).clearClassifications();
                return this;
            }

            public Builder removeClassifications(int index) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).removeClassifications(index);
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public List<LandmarkProto.LandmarkList> getWorldLandmarksList() {
                return Collections.unmodifiableList(((MultiLandmarksDetectionResult) this.instance).getWorldLandmarksList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public int getWorldLandmarksCount() {
                return ((MultiLandmarksDetectionResult) this.instance).getWorldLandmarksCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public LandmarkProto.LandmarkList getWorldLandmarks(int index) {
                return ((MultiLandmarksDetectionResult) this.instance).getWorldLandmarks(index);
            }

            public Builder setWorldLandmarks(int index, LandmarkProto.LandmarkList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setWorldLandmarks(index, value);
                return this;
            }

            public Builder setWorldLandmarks(int index, LandmarkProto.LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setWorldLandmarks(index, (LandmarkProto.LandmarkList) builderForValue.build());
                return this;
            }

            public Builder addWorldLandmarks(LandmarkProto.LandmarkList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addWorldLandmarks(value);
                return this;
            }

            public Builder addWorldLandmarks(int index, LandmarkProto.LandmarkList value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addWorldLandmarks(index, value);
                return this;
            }

            public Builder addWorldLandmarks(LandmarkProto.LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addWorldLandmarks((LandmarkProto.LandmarkList) builderForValue.build());
                return this;
            }

            public Builder addWorldLandmarks(int index, LandmarkProto.LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addWorldLandmarks(index, (LandmarkProto.LandmarkList) builderForValue.build());
                return this;
            }

            public Builder addAllWorldLandmarks(Iterable<? extends LandmarkProto.LandmarkList> values) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addAllWorldLandmarks(values);
                return this;
            }

            public Builder clearWorldLandmarks() {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).clearWorldLandmarks();
                return this;
            }

            public Builder removeWorldLandmarks(int index) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).removeWorldLandmarks(index);
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public List<RectProto.NormalizedRect> getRectsList() {
                return Collections.unmodifiableList(((MultiLandmarksDetectionResult) this.instance).getRectsList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public int getRectsCount() {
                return ((MultiLandmarksDetectionResult) this.instance).getRectsCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.LandmarksDetectionResultProto.MultiLandmarksDetectionResultOrBuilder
            public RectProto.NormalizedRect getRects(int index) {
                return ((MultiLandmarksDetectionResult) this.instance).getRects(index);
            }

            public Builder setRects(int index, RectProto.NormalizedRect value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setRects(index, value);
                return this;
            }

            public Builder setRects(int index, RectProto.NormalizedRect.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).setRects(index, (RectProto.NormalizedRect) builderForValue.build());
                return this;
            }

            public Builder addRects(RectProto.NormalizedRect value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addRects(value);
                return this;
            }

            public Builder addRects(int index, RectProto.NormalizedRect value) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addRects(index, value);
                return this;
            }

            public Builder addRects(RectProto.NormalizedRect.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addRects((RectProto.NormalizedRect) builderForValue.build());
                return this;
            }

            public Builder addRects(int index, RectProto.NormalizedRect.Builder builderForValue) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addRects(index, (RectProto.NormalizedRect) builderForValue.build());
                return this;
            }

            public Builder addAllRects(Iterable<? extends RectProto.NormalizedRect> values) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).addAllRects(values);
                return this;
            }

            public Builder clearRects() {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).clearRects();
                return this;
            }

            public Builder removeRects(int index) {
                copyOnWrite();
                ((MultiLandmarksDetectionResult) this.instance).removeRects(index);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new MultiLandmarksDetectionResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0001\u0001\u001b\u0002\u001b\u0003\u001b\u0004Л", new Object[]{"landmarks_", LandmarkProto.NormalizedLandmarkList.class, "classifications_", ClassificationProto.ClassificationList.class, "worldLandmarks_", LandmarkProto.LandmarkList.class, "rects_", RectProto.NormalizedRect.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MultiLandmarksDetectionResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MultiLandmarksDetectionResult.class) {
                        defaultInstanceBasedParser = PARSER;
                        if (defaultInstanceBasedParser == null) {
                            defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = defaultInstanceBasedParser;
                        }
                        break;
                    }
                    return defaultInstanceBasedParser;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    this.memoizedIsInitialized = (byte) (arg0 == null ? 0 : 1);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            MultiLandmarksDetectionResult multiLandmarksDetectionResult = new MultiLandmarksDetectionResult();
            DEFAULT_INSTANCE = multiLandmarksDetectionResult;
            GeneratedMessageLite.registerDefaultInstance(MultiLandmarksDetectionResult.class, multiLandmarksDetectionResult);
        }

        public static MultiLandmarksDetectionResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MultiLandmarksDetectionResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
