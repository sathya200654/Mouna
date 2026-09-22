package com.google.mediapipe.formats.proto;

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
public final class DetectionProto {

    public interface DetectionListOrBuilder extends MessageLiteOrBuilder {
        Detection getDetection(int index);

        int getDetectionCount();

        List<Detection> getDetectionList();
    }

    public interface DetectionOrBuilder extends MessageLiteOrBuilder {
        Detection.AssociatedDetection getAssociatedDetections(int index);

        int getAssociatedDetectionsCount();

        List<Detection.AssociatedDetection> getAssociatedDetectionsList();

        long getDetectionId();

        String getDisplayName(int index);

        ByteString getDisplayNameBytes(int index);

        int getDisplayNameCount();

        List<String> getDisplayNameList();

        String getFeatureTag();

        ByteString getFeatureTagBytes();

        String getLabel(int index);

        ByteString getLabelBytes(int index);

        int getLabelCount();

        int getLabelId(int index);

        int getLabelIdCount();

        List<Integer> getLabelIdList();

        List<String> getLabelList();

        LocationDataProto.LocationData getLocationData();

        float getScore(int index);

        int getScoreCount();

        List<Float> getScoreList();

        long getTimestampUsec();

        String getTrackId();

        ByteString getTrackIdBytes();

        boolean hasDetectionId();

        boolean hasFeatureTag();

        boolean hasLocationData();

        boolean hasTimestampUsec();

        boolean hasTrackId();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private DetectionProto() {
    }

    public static final class Detection extends GeneratedMessageLite<Detection, Builder> implements DetectionOrBuilder {
        public static final int ASSOCIATED_DETECTIONS_FIELD_NUMBER = 8;
        private static final Detection DEFAULT_INSTANCE;
        public static final int DETECTION_ID_FIELD_NUMBER = 7;
        public static final int DISPLAY_NAME_FIELD_NUMBER = 9;
        public static final int FEATURE_TAG_FIELD_NUMBER = 5;
        public static final int LABEL_FIELD_NUMBER = 1;
        public static final int LABEL_ID_FIELD_NUMBER = 2;
        public static final int LOCATION_DATA_FIELD_NUMBER = 4;
        private static volatile Parser<Detection> PARSER = null;
        public static final int SCORE_FIELD_NUMBER = 3;
        public static final int TIMESTAMP_USEC_FIELD_NUMBER = 10;
        public static final int TRACK_ID_FIELD_NUMBER = 6;
        private int bitField0_;
        private long detectionId_;
        private LocationDataProto.LocationData locationData_;
        private long timestampUsec_;
        private int labelIdMemoizedSerializedSize = -1;
        private int scoreMemoizedSerializedSize = -1;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<String> label_ = GeneratedMessageLite.emptyProtobufList();
        private Internal.IntList labelId_ = emptyIntList();
        private Internal.FloatList score_ = emptyFloatList();
        private String featureTag_ = "";
        private String trackId_ = "";
        private Internal.ProtobufList<AssociatedDetection> associatedDetections_ = emptyProtobufList();
        private Internal.ProtobufList<String> displayName_ = GeneratedMessageLite.emptyProtobufList();

        public interface AssociatedDetectionOrBuilder extends MessageLiteOrBuilder {
            float getConfidence();

            int getId();

            boolean hasConfidence();

            boolean hasId();
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

        private Detection() {
        }

        public static final class AssociatedDetection extends GeneratedMessageLite<AssociatedDetection, Builder> implements AssociatedDetectionOrBuilder {
            public static final int CONFIDENCE_FIELD_NUMBER = 2;
            private static final AssociatedDetection DEFAULT_INSTANCE;
            public static final int ID_FIELD_NUMBER = 1;
            private static volatile Parser<AssociatedDetection> PARSER;
            private int bitField0_;
            private float confidence_;
            private int id_;

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

            private AssociatedDetection() {
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
            public boolean hasId() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
            public int getId() {
                return this.id_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setId(int value) {
                this.bitField0_ |= 1;
                this.id_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearId() {
                this.bitField0_ &= -2;
                this.id_ = 0;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
            public boolean hasConfidence() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
            public float getConfidence() {
                return this.confidence_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setConfidence(float value) {
                this.bitField0_ |= 2;
                this.confidence_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearConfidence() {
                this.bitField0_ &= -3;
                this.confidence_ = 0.0f;
            }

            public static AssociatedDetection parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static AssociatedDetection parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static AssociatedDetection parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static AssociatedDetection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static AssociatedDetection parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static AssociatedDetection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static AssociatedDetection parseFrom(InputStream input) throws IOException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static AssociatedDetection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static AssociatedDetection parseDelimitedFrom(InputStream input) throws IOException {
                return (AssociatedDetection) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static AssociatedDetection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AssociatedDetection) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static AssociatedDetection parseFrom(CodedInputStream input) throws IOException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static AssociatedDetection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (AssociatedDetection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(AssociatedDetection prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<AssociatedDetection, Builder> implements AssociatedDetectionOrBuilder {
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
                    super(AssociatedDetection.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
                public boolean hasId() {
                    return ((AssociatedDetection) this.instance).hasId();
                }

                @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
                public int getId() {
                    return ((AssociatedDetection) this.instance).getId();
                }

                public Builder setId(int value) {
                    copyOnWrite();
                    ((AssociatedDetection) this.instance).setId(value);
                    return this;
                }

                public Builder clearId() {
                    copyOnWrite();
                    ((AssociatedDetection) this.instance).clearId();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
                public boolean hasConfidence() {
                    return ((AssociatedDetection) this.instance).hasConfidence();
                }

                @Override // com.google.mediapipe.formats.proto.DetectionProto.Detection.AssociatedDetectionOrBuilder
                public float getConfidence() {
                    return ((AssociatedDetection) this.instance).getConfidence();
                }

                public Builder setConfidence(float value) {
                    copyOnWrite();
                    ((AssociatedDetection) this.instance).setConfidence(value);
                    return this;
                }

                public Builder clearConfidence() {
                    copyOnWrite();
                    ((AssociatedDetection) this.instance).clearConfidence();
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
                        return new AssociatedDetection();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001", new Object[]{"bitField0_", "id_", "confidence_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<AssociatedDetection> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (AssociatedDetection.class) {
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
                AssociatedDetection associatedDetection = new AssociatedDetection();
                DEFAULT_INSTANCE = associatedDetection;
                GeneratedMessageLite.registerDefaultInstance(AssociatedDetection.class, associatedDetection);
            }

            public static AssociatedDetection getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<AssociatedDetection> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public List<String> getLabelList() {
            return this.label_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public int getLabelCount() {
            return this.label_.size();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public String getLabel(int index) {
            return this.label_.get(index);
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public ByteString getLabelBytes(int index) {
            return ByteString.copyFromUtf8(this.label_.get(index));
        }

        private void ensureLabelIsMutable() {
            Internal.ProtobufList<String> protobufList = this.label_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.label_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLabel(int index, String value) {
            value.getClass();
            ensureLabelIsMutable();
            this.label_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLabel(String value) {
            value.getClass();
            ensureLabelIsMutable();
            this.label_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLabel(Iterable<String> values) {
            ensureLabelIsMutable();
            AbstractMessageLite.addAll(values, this.label_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLabel() {
            this.label_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLabelBytes(ByteString value) {
            ensureLabelIsMutable();
            this.label_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public List<Integer> getLabelIdList() {
            return this.labelId_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public int getLabelIdCount() {
            return this.labelId_.size();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public int getLabelId(int index) {
            return this.labelId_.getInt(index);
        }

        private void ensureLabelIdIsMutable() {
            Internal.IntList intList = this.labelId_;
            if (intList.isModifiable()) {
                return;
            }
            this.labelId_ = GeneratedMessageLite.mutableCopy(intList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLabelId(int index, int value) {
            ensureLabelIdIsMutable();
            this.labelId_.setInt(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLabelId(int value) {
            ensureLabelIdIsMutable();
            this.labelId_.addInt(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLabelId(Iterable<? extends Integer> values) {
            ensureLabelIdIsMutable();
            AbstractMessageLite.addAll(values, this.labelId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLabelId() {
            this.labelId_ = emptyIntList();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public List<Float> getScoreList() {
            return this.score_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public int getScoreCount() {
            return this.score_.size();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public float getScore(int index) {
            return this.score_.getFloat(index);
        }

        private void ensureScoreIsMutable() {
            Internal.FloatList floatList = this.score_;
            if (floatList.isModifiable()) {
                return;
            }
            this.score_ = GeneratedMessageLite.mutableCopy(floatList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScore(int index, float value) {
            ensureScoreIsMutable();
            this.score_.setFloat(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addScore(float value) {
            ensureScoreIsMutable();
            this.score_.addFloat(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllScore(Iterable<? extends Float> values) {
            ensureScoreIsMutable();
            AbstractMessageLite.addAll(values, this.score_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScore() {
            this.score_ = emptyFloatList();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public boolean hasLocationData() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public LocationDataProto.LocationData getLocationData() {
            LocationDataProto.LocationData locationData = this.locationData_;
            return locationData == null ? LocationDataProto.LocationData.getDefaultInstance() : locationData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLocationData(LocationDataProto.LocationData value) {
            value.getClass();
            this.locationData_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLocationData(LocationDataProto.LocationData value) {
            value.getClass();
            LocationDataProto.LocationData locationData = this.locationData_;
            if (locationData != null && locationData != LocationDataProto.LocationData.getDefaultInstance()) {
                this.locationData_ = (LocationDataProto.LocationData) LocationDataProto.LocationData.newBuilder(this.locationData_).mergeFrom(value).buildPartial();
            } else {
                this.locationData_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLocationData() {
            this.locationData_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public boolean hasFeatureTag() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public String getFeatureTag() {
            return this.featureTag_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public ByteString getFeatureTagBytes() {
            return ByteString.copyFromUtf8(this.featureTag_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFeatureTag(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.featureTag_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFeatureTag() {
            this.bitField0_ &= -3;
            this.featureTag_ = getDefaultInstance().getFeatureTag();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFeatureTagBytes(ByteString value) {
            this.featureTag_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public boolean hasTrackId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public String getTrackId() {
            return this.trackId_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public ByteString getTrackIdBytes() {
            return ByteString.copyFromUtf8(this.trackId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackId(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.trackId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTrackId() {
            this.bitField0_ &= -5;
            this.trackId_ = getDefaultInstance().getTrackId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTrackIdBytes(ByteString value) {
            this.trackId_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public boolean hasDetectionId() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public long getDetectionId() {
            return this.detectionId_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDetectionId(long value) {
            this.bitField0_ |= 8;
            this.detectionId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDetectionId() {
            this.bitField0_ &= -9;
            this.detectionId_ = 0L;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public List<AssociatedDetection> getAssociatedDetectionsList() {
            return this.associatedDetections_;
        }

        public List<? extends AssociatedDetectionOrBuilder> getAssociatedDetectionsOrBuilderList() {
            return this.associatedDetections_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public int getAssociatedDetectionsCount() {
            return this.associatedDetections_.size();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public AssociatedDetection getAssociatedDetections(int index) {
            return this.associatedDetections_.get(index);
        }

        public AssociatedDetectionOrBuilder getAssociatedDetectionsOrBuilder(int index) {
            return this.associatedDetections_.get(index);
        }

        private void ensureAssociatedDetectionsIsMutable() {
            Internal.ProtobufList<AssociatedDetection> protobufList = this.associatedDetections_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.associatedDetections_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAssociatedDetections(int index, AssociatedDetection value) {
            value.getClass();
            ensureAssociatedDetectionsIsMutable();
            this.associatedDetections_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAssociatedDetections(AssociatedDetection value) {
            value.getClass();
            ensureAssociatedDetectionsIsMutable();
            this.associatedDetections_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAssociatedDetections(int index, AssociatedDetection value) {
            value.getClass();
            ensureAssociatedDetectionsIsMutable();
            this.associatedDetections_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAssociatedDetections(Iterable<? extends AssociatedDetection> values) {
            ensureAssociatedDetectionsIsMutable();
            AbstractMessageLite.addAll(values, this.associatedDetections_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAssociatedDetections() {
            this.associatedDetections_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAssociatedDetections(int index) {
            ensureAssociatedDetectionsIsMutable();
            this.associatedDetections_.remove(index);
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public List<String> getDisplayNameList() {
            return this.displayName_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public int getDisplayNameCount() {
            return this.displayName_.size();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public String getDisplayName(int index) {
            return this.displayName_.get(index);
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public ByteString getDisplayNameBytes(int index) {
            return ByteString.copyFromUtf8(this.displayName_.get(index));
        }

        private void ensureDisplayNameIsMutable() {
            Internal.ProtobufList<String> protobufList = this.displayName_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.displayName_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayName(int index, String value) {
            value.getClass();
            ensureDisplayNameIsMutable();
            this.displayName_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDisplayName(String value) {
            value.getClass();
            ensureDisplayNameIsMutable();
            this.displayName_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDisplayName(Iterable<String> values) {
            ensureDisplayNameIsMutable();
            AbstractMessageLite.addAll(values, this.displayName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDisplayName() {
            this.displayName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDisplayNameBytes(ByteString value) {
            ensureDisplayNameIsMutable();
            this.displayName_.add(value.toStringUtf8());
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public boolean hasTimestampUsec() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
        public long getTimestampUsec() {
            return this.timestampUsec_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestampUsec(long value) {
            this.bitField0_ |= 16;
            this.timestampUsec_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestampUsec() {
            this.bitField0_ &= -17;
            this.timestampUsec_ = 0L;
        }

        public static Detection parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Detection parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Detection parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Detection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Detection parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Detection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Detection parseFrom(InputStream input) throws IOException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Detection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Detection parseDelimitedFrom(InputStream input) throws IOException {
            return (Detection) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Detection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Detection) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Detection parseFrom(CodedInputStream input) throws IOException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Detection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Detection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Detection prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Detection, Builder> implements DetectionOrBuilder {
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
                super(Detection.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public List<String> getLabelList() {
                return Collections.unmodifiableList(((Detection) this.instance).getLabelList());
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public int getLabelCount() {
                return ((Detection) this.instance).getLabelCount();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public String getLabel(int index) {
                return ((Detection) this.instance).getLabel(index);
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public ByteString getLabelBytes(int index) {
                return ((Detection) this.instance).getLabelBytes(index);
            }

            public Builder setLabel(int index, String value) {
                copyOnWrite();
                ((Detection) this.instance).setLabel(index, value);
                return this;
            }

            public Builder addLabel(String value) {
                copyOnWrite();
                ((Detection) this.instance).addLabel(value);
                return this;
            }

            public Builder addAllLabel(Iterable<String> values) {
                copyOnWrite();
                ((Detection) this.instance).addAllLabel(values);
                return this;
            }

            public Builder clearLabel() {
                copyOnWrite();
                ((Detection) this.instance).clearLabel();
                return this;
            }

            public Builder addLabelBytes(ByteString value) {
                copyOnWrite();
                ((Detection) this.instance).addLabelBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public List<Integer> getLabelIdList() {
                return Collections.unmodifiableList(((Detection) this.instance).getLabelIdList());
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public int getLabelIdCount() {
                return ((Detection) this.instance).getLabelIdCount();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public int getLabelId(int index) {
                return ((Detection) this.instance).getLabelId(index);
            }

            public Builder setLabelId(int index, int value) {
                copyOnWrite();
                ((Detection) this.instance).setLabelId(index, value);
                return this;
            }

            public Builder addLabelId(int value) {
                copyOnWrite();
                ((Detection) this.instance).addLabelId(value);
                return this;
            }

            public Builder addAllLabelId(Iterable<? extends Integer> values) {
                copyOnWrite();
                ((Detection) this.instance).addAllLabelId(values);
                return this;
            }

            public Builder clearLabelId() {
                copyOnWrite();
                ((Detection) this.instance).clearLabelId();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public List<Float> getScoreList() {
                return Collections.unmodifiableList(((Detection) this.instance).getScoreList());
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public int getScoreCount() {
                return ((Detection) this.instance).getScoreCount();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public float getScore(int index) {
                return ((Detection) this.instance).getScore(index);
            }

            public Builder setScore(int index, float value) {
                copyOnWrite();
                ((Detection) this.instance).setScore(index, value);
                return this;
            }

            public Builder addScore(float value) {
                copyOnWrite();
                ((Detection) this.instance).addScore(value);
                return this;
            }

            public Builder addAllScore(Iterable<? extends Float> values) {
                copyOnWrite();
                ((Detection) this.instance).addAllScore(values);
                return this;
            }

            public Builder clearScore() {
                copyOnWrite();
                ((Detection) this.instance).clearScore();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public boolean hasLocationData() {
                return ((Detection) this.instance).hasLocationData();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public LocationDataProto.LocationData getLocationData() {
                return ((Detection) this.instance).getLocationData();
            }

            public Builder setLocationData(LocationDataProto.LocationData value) {
                copyOnWrite();
                ((Detection) this.instance).setLocationData(value);
                return this;
            }

            public Builder setLocationData(LocationDataProto.LocationData.Builder builderForValue) {
                copyOnWrite();
                ((Detection) this.instance).setLocationData((LocationDataProto.LocationData) builderForValue.build());
                return this;
            }

            public Builder mergeLocationData(LocationDataProto.LocationData value) {
                copyOnWrite();
                ((Detection) this.instance).mergeLocationData(value);
                return this;
            }

            public Builder clearLocationData() {
                copyOnWrite();
                ((Detection) this.instance).clearLocationData();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public boolean hasFeatureTag() {
                return ((Detection) this.instance).hasFeatureTag();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public String getFeatureTag() {
                return ((Detection) this.instance).getFeatureTag();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public ByteString getFeatureTagBytes() {
                return ((Detection) this.instance).getFeatureTagBytes();
            }

            public Builder setFeatureTag(String value) {
                copyOnWrite();
                ((Detection) this.instance).setFeatureTag(value);
                return this;
            }

            public Builder clearFeatureTag() {
                copyOnWrite();
                ((Detection) this.instance).clearFeatureTag();
                return this;
            }

            public Builder setFeatureTagBytes(ByteString value) {
                copyOnWrite();
                ((Detection) this.instance).setFeatureTagBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public boolean hasTrackId() {
                return ((Detection) this.instance).hasTrackId();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public String getTrackId() {
                return ((Detection) this.instance).getTrackId();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public ByteString getTrackIdBytes() {
                return ((Detection) this.instance).getTrackIdBytes();
            }

            public Builder setTrackId(String value) {
                copyOnWrite();
                ((Detection) this.instance).setTrackId(value);
                return this;
            }

            public Builder clearTrackId() {
                copyOnWrite();
                ((Detection) this.instance).clearTrackId();
                return this;
            }

            public Builder setTrackIdBytes(ByteString value) {
                copyOnWrite();
                ((Detection) this.instance).setTrackIdBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public boolean hasDetectionId() {
                return ((Detection) this.instance).hasDetectionId();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public long getDetectionId() {
                return ((Detection) this.instance).getDetectionId();
            }

            public Builder setDetectionId(long value) {
                copyOnWrite();
                ((Detection) this.instance).setDetectionId(value);
                return this;
            }

            public Builder clearDetectionId() {
                copyOnWrite();
                ((Detection) this.instance).clearDetectionId();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public List<AssociatedDetection> getAssociatedDetectionsList() {
                return Collections.unmodifiableList(((Detection) this.instance).getAssociatedDetectionsList());
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public int getAssociatedDetectionsCount() {
                return ((Detection) this.instance).getAssociatedDetectionsCount();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public AssociatedDetection getAssociatedDetections(int index) {
                return ((Detection) this.instance).getAssociatedDetections(index);
            }

            public Builder setAssociatedDetections(int index, AssociatedDetection value) {
                copyOnWrite();
                ((Detection) this.instance).setAssociatedDetections(index, value);
                return this;
            }

            public Builder setAssociatedDetections(int index, AssociatedDetection.Builder builderForValue) {
                copyOnWrite();
                ((Detection) this.instance).setAssociatedDetections(index, (AssociatedDetection) builderForValue.build());
                return this;
            }

            public Builder addAssociatedDetections(AssociatedDetection value) {
                copyOnWrite();
                ((Detection) this.instance).addAssociatedDetections(value);
                return this;
            }

            public Builder addAssociatedDetections(int index, AssociatedDetection value) {
                copyOnWrite();
                ((Detection) this.instance).addAssociatedDetections(index, value);
                return this;
            }

            public Builder addAssociatedDetections(AssociatedDetection.Builder builderForValue) {
                copyOnWrite();
                ((Detection) this.instance).addAssociatedDetections((AssociatedDetection) builderForValue.build());
                return this;
            }

            public Builder addAssociatedDetections(int index, AssociatedDetection.Builder builderForValue) {
                copyOnWrite();
                ((Detection) this.instance).addAssociatedDetections(index, (AssociatedDetection) builderForValue.build());
                return this;
            }

            public Builder addAllAssociatedDetections(Iterable<? extends AssociatedDetection> values) {
                copyOnWrite();
                ((Detection) this.instance).addAllAssociatedDetections(values);
                return this;
            }

            public Builder clearAssociatedDetections() {
                copyOnWrite();
                ((Detection) this.instance).clearAssociatedDetections();
                return this;
            }

            public Builder removeAssociatedDetections(int index) {
                copyOnWrite();
                ((Detection) this.instance).removeAssociatedDetections(index);
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public List<String> getDisplayNameList() {
                return Collections.unmodifiableList(((Detection) this.instance).getDisplayNameList());
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public int getDisplayNameCount() {
                return ((Detection) this.instance).getDisplayNameCount();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public String getDisplayName(int index) {
                return ((Detection) this.instance).getDisplayName(index);
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public ByteString getDisplayNameBytes(int index) {
                return ((Detection) this.instance).getDisplayNameBytes(index);
            }

            public Builder setDisplayName(int index, String value) {
                copyOnWrite();
                ((Detection) this.instance).setDisplayName(index, value);
                return this;
            }

            public Builder addDisplayName(String value) {
                copyOnWrite();
                ((Detection) this.instance).addDisplayName(value);
                return this;
            }

            public Builder addAllDisplayName(Iterable<String> values) {
                copyOnWrite();
                ((Detection) this.instance).addAllDisplayName(values);
                return this;
            }

            public Builder clearDisplayName() {
                copyOnWrite();
                ((Detection) this.instance).clearDisplayName();
                return this;
            }

            public Builder addDisplayNameBytes(ByteString value) {
                copyOnWrite();
                ((Detection) this.instance).addDisplayNameBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public boolean hasTimestampUsec() {
                return ((Detection) this.instance).hasTimestampUsec();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionOrBuilder
            public long getTimestampUsec() {
                return ((Detection) this.instance).getTimestampUsec();
            }

            public Builder setTimestampUsec(long value) {
                copyOnWrite();
                ((Detection) this.instance).setTimestampUsec(value);
                return this;
            }

            public Builder clearTimestampUsec() {
                copyOnWrite();
                ((Detection) this.instance).clearTimestampUsec();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Detection();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0005\u0001\u0001\u001a\u0002'\u0003$\u0004ᐉ\u0000\u0005ဈ\u0001\u0006ဈ\u0002\u0007ဂ\u0003\b\u001b\t\u001a\nဂ\u0004", new Object[]{"bitField0_", "label_", "labelId_", "score_", "locationData_", "featureTag_", "trackId_", "detectionId_", "associatedDetections_", AssociatedDetection.class, "displayName_", "timestampUsec_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Detection> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Detection.class) {
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
            Detection detection = new Detection();
            DEFAULT_INSTANCE = detection;
            GeneratedMessageLite.registerDefaultInstance(Detection.class, detection);
        }

        public static Detection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Detection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.formats.proto.DetectionProto$1, reason: invalid class name */
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

    public static final class DetectionList extends GeneratedMessageLite<DetectionList, Builder> implements DetectionListOrBuilder {
        private static final DetectionList DEFAULT_INSTANCE;
        public static final int DETECTION_FIELD_NUMBER = 1;
        private static volatile Parser<DetectionList> PARSER;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<Detection> detection_ = emptyProtobufList();

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

        private DetectionList() {
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionListOrBuilder
        public List<Detection> getDetectionList() {
            return this.detection_;
        }

        public List<? extends DetectionOrBuilder> getDetectionOrBuilderList() {
            return this.detection_;
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionListOrBuilder
        public int getDetectionCount() {
            return this.detection_.size();
        }

        @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionListOrBuilder
        public Detection getDetection(int index) {
            return this.detection_.get(index);
        }

        public DetectionOrBuilder getDetectionOrBuilder(int index) {
            return this.detection_.get(index);
        }

        private void ensureDetectionIsMutable() {
            Internal.ProtobufList<Detection> protobufList = this.detection_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.detection_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDetection(int index, Detection value) {
            value.getClass();
            ensureDetectionIsMutable();
            this.detection_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDetection(Detection value) {
            value.getClass();
            ensureDetectionIsMutable();
            this.detection_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDetection(int index, Detection value) {
            value.getClass();
            ensureDetectionIsMutable();
            this.detection_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDetection(Iterable<? extends Detection> values) {
            ensureDetectionIsMutable();
            AbstractMessageLite.addAll(values, this.detection_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDetection() {
            this.detection_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDetection(int index) {
            ensureDetectionIsMutable();
            this.detection_.remove(index);
        }

        public static DetectionList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DetectionList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DetectionList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DetectionList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DetectionList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DetectionList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DetectionList parseFrom(InputStream input) throws IOException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DetectionList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DetectionList parseDelimitedFrom(InputStream input) throws IOException {
            return (DetectionList) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DetectionList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DetectionList) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DetectionList parseFrom(CodedInputStream input) throws IOException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DetectionList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DetectionList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DetectionList prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DetectionList, Builder> implements DetectionListOrBuilder {
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
                super(DetectionList.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionListOrBuilder
            public List<Detection> getDetectionList() {
                return Collections.unmodifiableList(((DetectionList) this.instance).getDetectionList());
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionListOrBuilder
            public int getDetectionCount() {
                return ((DetectionList) this.instance).getDetectionCount();
            }

            @Override // com.google.mediapipe.formats.proto.DetectionProto.DetectionListOrBuilder
            public Detection getDetection(int index) {
                return ((DetectionList) this.instance).getDetection(index);
            }

            public Builder setDetection(int index, Detection value) {
                copyOnWrite();
                ((DetectionList) this.instance).setDetection(index, value);
                return this;
            }

            public Builder setDetection(int index, Detection.Builder builderForValue) {
                copyOnWrite();
                ((DetectionList) this.instance).setDetection(index, (Detection) builderForValue.build());
                return this;
            }

            public Builder addDetection(Detection value) {
                copyOnWrite();
                ((DetectionList) this.instance).addDetection(value);
                return this;
            }

            public Builder addDetection(int index, Detection value) {
                copyOnWrite();
                ((DetectionList) this.instance).addDetection(index, value);
                return this;
            }

            public Builder addDetection(Detection.Builder builderForValue) {
                copyOnWrite();
                ((DetectionList) this.instance).addDetection((Detection) builderForValue.build());
                return this;
            }

            public Builder addDetection(int index, Detection.Builder builderForValue) {
                copyOnWrite();
                ((DetectionList) this.instance).addDetection(index, (Detection) builderForValue.build());
                return this;
            }

            public Builder addAllDetection(Iterable<? extends Detection> values) {
                copyOnWrite();
                ((DetectionList) this.instance).addAllDetection(values);
                return this;
            }

            public Builder clearDetection() {
                copyOnWrite();
                ((DetectionList) this.instance).clearDetection();
                return this;
            }

            public Builder removeDetection(int index) {
                copyOnWrite();
                ((DetectionList) this.instance).removeDetection(index);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new DetectionList();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"detection_", Detection.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<DetectionList> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (DetectionList.class) {
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
            DetectionList detectionList = new DetectionList();
            DEFAULT_INSTANCE = detectionList;
            GeneratedMessageLite.registerDefaultInstance(DetectionList.class, detectionList);
        }

        public static DetectionList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DetectionList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
