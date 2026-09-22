package com.google.mediapipe.formats.proto;

import com.google.mediapipe.formats.annotation.proto.RasterizationProto;
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
public final class LocationDataProto {

    public interface LocationDataOrBuilder extends MessageLiteOrBuilder {
        LocationData.BoundingBox getBoundingBox();

        LocationData.Format getFormat();

        LocationData.BinaryMask getMask();

        LocationData.RelativeBoundingBox getRelativeBoundingBox();

        LocationData.RelativeKeypoint getRelativeKeypoints(int index);

        int getRelativeKeypointsCount();

        List<LocationData.RelativeKeypoint> getRelativeKeypointsList();

        boolean hasBoundingBox();

        boolean hasFormat();

        boolean hasMask();

        boolean hasRelativeBoundingBox();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private LocationDataProto() {
    }

    public static final class LocationData extends GeneratedMessageLite<LocationData, Builder> implements LocationDataOrBuilder {
        public static final int BOUNDING_BOX_FIELD_NUMBER = 2;
        private static final LocationData DEFAULT_INSTANCE;
        public static final int FORMAT_FIELD_NUMBER = 1;
        public static final int MASK_FIELD_NUMBER = 4;
        private static volatile Parser<LocationData> PARSER = null;
        public static final int RELATIVE_BOUNDING_BOX_FIELD_NUMBER = 3;
        public static final int RELATIVE_KEYPOINTS_FIELD_NUMBER = 5;
        private int bitField0_;
        private BoundingBox boundingBox_;
        private int format_;
        private BinaryMask mask_;
        private RelativeBoundingBox relativeBoundingBox_;
        private byte memoizedIsInitialized = 2;
        private Internal.ProtobufList<RelativeKeypoint> relativeKeypoints_ = emptyProtobufList();

        public interface BinaryMaskOrBuilder extends MessageLiteOrBuilder {
            int getHeight();

            RasterizationProto.Rasterization getRasterization();

            int getWidth();

            boolean hasHeight();

            boolean hasRasterization();

            boolean hasWidth();
        }

        public interface BoundingBoxOrBuilder extends MessageLiteOrBuilder {
            int getHeight();

            int getWidth();

            int getXmin();

            int getYmin();

            boolean hasHeight();

            boolean hasWidth();

            boolean hasXmin();

            boolean hasYmin();
        }

        public interface RelativeBoundingBoxOrBuilder extends MessageLiteOrBuilder {
            float getHeight();

            float getWidth();

            float getXmin();

            float getYmin();

            boolean hasHeight();

            boolean hasWidth();

            boolean hasXmin();

            boolean hasYmin();
        }

        public interface RelativeKeypointOrBuilder extends MessageLiteOrBuilder {
            String getKeypointLabel();

            ByteString getKeypointLabelBytes();

            float getScore();

            float getX();

            float getY();

            boolean hasKeypointLabel();

            boolean hasScore();

            boolean hasX();

            boolean hasY();
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

        private LocationData() {
        }

        public enum Format implements Internal.EnumLite {
            GLOBAL(0),
            BOUNDING_BOX(1),
            RELATIVE_BOUNDING_BOX(2),
            MASK(3);

            public static final int BOUNDING_BOX_VALUE = 1;
            public static final int GLOBAL_VALUE = 0;
            public static final int MASK_VALUE = 3;
            public static final int RELATIVE_BOUNDING_BOX_VALUE = 2;
            private static final Internal.EnumLiteMap<Format> internalValueMap = new Internal.EnumLiteMap<Format>() { // from class: com.google.mediapipe.formats.proto.LocationDataProto.LocationData.Format.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Format findValueByNumber(int number) {
                    return Format.forNumber(number);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Format valueOf(int value) {
                return forNumber(value);
            }

            public static Format forNumber(int value) {
                if (value == 0) {
                    return GLOBAL;
                }
                if (value == 1) {
                    return BOUNDING_BOX;
                }
                if (value == 2) {
                    return RELATIVE_BOUNDING_BOX;
                }
                if (value != 3) {
                    return null;
                }
                return MASK;
            }

            public static Internal.EnumLiteMap<Format> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return FormatVerifier.INSTANCE;
            }

            private static final class FormatVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new FormatVerifier();

                private FormatVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return Format.forNumber(number) != null;
                }
            }

            Format(int value) {
                this.value = value;
            }
        }

        public static final class BoundingBox extends GeneratedMessageLite<BoundingBox, Builder> implements BoundingBoxOrBuilder {
            private static final BoundingBox DEFAULT_INSTANCE;
            public static final int HEIGHT_FIELD_NUMBER = 4;
            private static volatile Parser<BoundingBox> PARSER = null;
            public static final int WIDTH_FIELD_NUMBER = 3;
            public static final int XMIN_FIELD_NUMBER = 1;
            public static final int YMIN_FIELD_NUMBER = 2;
            private int bitField0_;
            private int height_;
            private int width_;
            private int xmin_;
            private int ymin_;

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

            private BoundingBox() {
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public boolean hasXmin() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public int getXmin() {
                return this.xmin_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXmin(int value) {
                this.bitField0_ |= 1;
                this.xmin_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXmin() {
                this.bitField0_ &= -2;
                this.xmin_ = 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public boolean hasYmin() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public int getYmin() {
                return this.ymin_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYmin(int value) {
                this.bitField0_ |= 2;
                this.ymin_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYmin() {
                this.bitField0_ &= -3;
                this.ymin_ = 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public boolean hasWidth() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public int getWidth() {
                return this.width_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setWidth(int value) {
                this.bitField0_ |= 4;
                this.width_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearWidth() {
                this.bitField0_ &= -5;
                this.width_ = 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public boolean hasHeight() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
            public int getHeight() {
                return this.height_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHeight(int value) {
                this.bitField0_ |= 8;
                this.height_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearHeight() {
                this.bitField0_ &= -9;
                this.height_ = 0;
            }

            public static BoundingBox parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static BoundingBox parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static BoundingBox parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static BoundingBox parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static BoundingBox parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static BoundingBox parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static BoundingBox parseFrom(InputStream input) throws IOException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static BoundingBox parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static BoundingBox parseDelimitedFrom(InputStream input) throws IOException {
                return (BoundingBox) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static BoundingBox parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (BoundingBox) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static BoundingBox parseFrom(CodedInputStream input) throws IOException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static BoundingBox parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (BoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(BoundingBox prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<BoundingBox, Builder> implements BoundingBoxOrBuilder {
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
                    super(BoundingBox.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public boolean hasXmin() {
                    return ((BoundingBox) this.instance).hasXmin();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public int getXmin() {
                    return ((BoundingBox) this.instance).getXmin();
                }

                public Builder setXmin(int value) {
                    copyOnWrite();
                    ((BoundingBox) this.instance).setXmin(value);
                    return this;
                }

                public Builder clearXmin() {
                    copyOnWrite();
                    ((BoundingBox) this.instance).clearXmin();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public boolean hasYmin() {
                    return ((BoundingBox) this.instance).hasYmin();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public int getYmin() {
                    return ((BoundingBox) this.instance).getYmin();
                }

                public Builder setYmin(int value) {
                    copyOnWrite();
                    ((BoundingBox) this.instance).setYmin(value);
                    return this;
                }

                public Builder clearYmin() {
                    copyOnWrite();
                    ((BoundingBox) this.instance).clearYmin();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public boolean hasWidth() {
                    return ((BoundingBox) this.instance).hasWidth();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public int getWidth() {
                    return ((BoundingBox) this.instance).getWidth();
                }

                public Builder setWidth(int value) {
                    copyOnWrite();
                    ((BoundingBox) this.instance).setWidth(value);
                    return this;
                }

                public Builder clearWidth() {
                    copyOnWrite();
                    ((BoundingBox) this.instance).clearWidth();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public boolean hasHeight() {
                    return ((BoundingBox) this.instance).hasHeight();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BoundingBoxOrBuilder
                public int getHeight() {
                    return ((BoundingBox) this.instance).getHeight();
                }

                public Builder setHeight(int value) {
                    copyOnWrite();
                    ((BoundingBox) this.instance).setHeight(value);
                    return this;
                }

                public Builder clearHeight() {
                    copyOnWrite();
                    ((BoundingBox) this.instance).clearHeight();
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
                        return new BoundingBox();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"bitField0_", "xmin_", "ymin_", "width_", "height_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BoundingBox> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (BoundingBox.class) {
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
                BoundingBox boundingBox = new BoundingBox();
                DEFAULT_INSTANCE = boundingBox;
                GeneratedMessageLite.registerDefaultInstance(BoundingBox.class, boundingBox);
            }

            public static BoundingBox getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<BoundingBox> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class RelativeBoundingBox extends GeneratedMessageLite<RelativeBoundingBox, Builder> implements RelativeBoundingBoxOrBuilder {
            private static final RelativeBoundingBox DEFAULT_INSTANCE;
            public static final int HEIGHT_FIELD_NUMBER = 4;
            private static volatile Parser<RelativeBoundingBox> PARSER = null;
            public static final int WIDTH_FIELD_NUMBER = 3;
            public static final int XMIN_FIELD_NUMBER = 1;
            public static final int YMIN_FIELD_NUMBER = 2;
            private int bitField0_;
            private float height_;
            private float width_;
            private float xmin_;
            private float ymin_;

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

            private RelativeBoundingBox() {
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public boolean hasXmin() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public float getXmin() {
                return this.xmin_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setXmin(float value) {
                this.bitField0_ |= 1;
                this.xmin_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearXmin() {
                this.bitField0_ &= -2;
                this.xmin_ = 0.0f;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public boolean hasYmin() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public float getYmin() {
                return this.ymin_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setYmin(float value) {
                this.bitField0_ |= 2;
                this.ymin_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearYmin() {
                this.bitField0_ &= -3;
                this.ymin_ = 0.0f;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public boolean hasWidth() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public float getWidth() {
                return this.width_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setWidth(float value) {
                this.bitField0_ |= 4;
                this.width_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearWidth() {
                this.bitField0_ &= -5;
                this.width_ = 0.0f;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public boolean hasHeight() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
            public float getHeight() {
                return this.height_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHeight(float value) {
                this.bitField0_ |= 8;
                this.height_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearHeight() {
                this.bitField0_ &= -9;
                this.height_ = 0.0f;
            }

            public static RelativeBoundingBox parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RelativeBoundingBox parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RelativeBoundingBox parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RelativeBoundingBox parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RelativeBoundingBox parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RelativeBoundingBox parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RelativeBoundingBox parseFrom(InputStream input) throws IOException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static RelativeBoundingBox parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static RelativeBoundingBox parseDelimitedFrom(InputStream input) throws IOException {
                return (RelativeBoundingBox) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static RelativeBoundingBox parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RelativeBoundingBox) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static RelativeBoundingBox parseFrom(CodedInputStream input) throws IOException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static RelativeBoundingBox parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RelativeBoundingBox) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(RelativeBoundingBox prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<RelativeBoundingBox, Builder> implements RelativeBoundingBoxOrBuilder {
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
                    super(RelativeBoundingBox.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public boolean hasXmin() {
                    return ((RelativeBoundingBox) this.instance).hasXmin();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public float getXmin() {
                    return ((RelativeBoundingBox) this.instance).getXmin();
                }

                public Builder setXmin(float value) {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).setXmin(value);
                    return this;
                }

                public Builder clearXmin() {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).clearXmin();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public boolean hasYmin() {
                    return ((RelativeBoundingBox) this.instance).hasYmin();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public float getYmin() {
                    return ((RelativeBoundingBox) this.instance).getYmin();
                }

                public Builder setYmin(float value) {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).setYmin(value);
                    return this;
                }

                public Builder clearYmin() {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).clearYmin();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public boolean hasWidth() {
                    return ((RelativeBoundingBox) this.instance).hasWidth();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public float getWidth() {
                    return ((RelativeBoundingBox) this.instance).getWidth();
                }

                public Builder setWidth(float value) {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).setWidth(value);
                    return this;
                }

                public Builder clearWidth() {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).clearWidth();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public boolean hasHeight() {
                    return ((RelativeBoundingBox) this.instance).hasHeight();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeBoundingBoxOrBuilder
                public float getHeight() {
                    return ((RelativeBoundingBox) this.instance).getHeight();
                }

                public Builder setHeight(float value) {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).setHeight(value);
                    return this;
                }

                public Builder clearHeight() {
                    copyOnWrite();
                    ((RelativeBoundingBox) this.instance).clearHeight();
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
                        return new RelativeBoundingBox();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "xmin_", "ymin_", "width_", "height_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<RelativeBoundingBox> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (RelativeBoundingBox.class) {
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
                RelativeBoundingBox relativeBoundingBox = new RelativeBoundingBox();
                DEFAULT_INSTANCE = relativeBoundingBox;
                GeneratedMessageLite.registerDefaultInstance(RelativeBoundingBox.class, relativeBoundingBox);
            }

            public static RelativeBoundingBox getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<RelativeBoundingBox> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class BinaryMask extends GeneratedMessageLite<BinaryMask, Builder> implements BinaryMaskOrBuilder {
            private static final BinaryMask DEFAULT_INSTANCE;
            public static final int HEIGHT_FIELD_NUMBER = 2;
            private static volatile Parser<BinaryMask> PARSER = null;
            public static final int RASTERIZATION_FIELD_NUMBER = 3;
            public static final int WIDTH_FIELD_NUMBER = 1;
            private int bitField0_;
            private int height_;
            private byte memoizedIsInitialized = 2;
            private RasterizationProto.Rasterization rasterization_;
            private int width_;

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

            private BinaryMask() {
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
            public boolean hasWidth() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
            public int getWidth() {
                return this.width_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setWidth(int value) {
                this.bitField0_ |= 1;
                this.width_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearWidth() {
                this.bitField0_ &= -2;
                this.width_ = 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
            public boolean hasHeight() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
            public int getHeight() {
                return this.height_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setHeight(int value) {
                this.bitField0_ |= 2;
                this.height_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearHeight() {
                this.bitField0_ &= -3;
                this.height_ = 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
            public boolean hasRasterization() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
            public RasterizationProto.Rasterization getRasterization() {
                RasterizationProto.Rasterization rasterization = this.rasterization_;
                return rasterization == null ? RasterizationProto.Rasterization.getDefaultInstance() : rasterization;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setRasterization(RasterizationProto.Rasterization value) {
                value.getClass();
                this.rasterization_ = value;
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void mergeRasterization(RasterizationProto.Rasterization value) {
                value.getClass();
                RasterizationProto.Rasterization rasterization = this.rasterization_;
                if (rasterization != null && rasterization != RasterizationProto.Rasterization.getDefaultInstance()) {
                    this.rasterization_ = (RasterizationProto.Rasterization) RasterizationProto.Rasterization.newBuilder(this.rasterization_).mergeFrom(value).buildPartial();
                } else {
                    this.rasterization_ = value;
                }
                this.bitField0_ |= 4;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearRasterization() {
                this.rasterization_ = null;
                this.bitField0_ &= -5;
            }

            public static BinaryMask parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static BinaryMask parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static BinaryMask parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static BinaryMask parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static BinaryMask parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static BinaryMask parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static BinaryMask parseFrom(InputStream input) throws IOException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static BinaryMask parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static BinaryMask parseDelimitedFrom(InputStream input) throws IOException {
                return (BinaryMask) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static BinaryMask parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (BinaryMask) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static BinaryMask parseFrom(CodedInputStream input) throws IOException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static BinaryMask parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (BinaryMask) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(BinaryMask prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<BinaryMask, Builder> implements BinaryMaskOrBuilder {
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
                    super(BinaryMask.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
                public boolean hasWidth() {
                    return ((BinaryMask) this.instance).hasWidth();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
                public int getWidth() {
                    return ((BinaryMask) this.instance).getWidth();
                }

                public Builder setWidth(int value) {
                    copyOnWrite();
                    ((BinaryMask) this.instance).setWidth(value);
                    return this;
                }

                public Builder clearWidth() {
                    copyOnWrite();
                    ((BinaryMask) this.instance).clearWidth();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
                public boolean hasHeight() {
                    return ((BinaryMask) this.instance).hasHeight();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
                public int getHeight() {
                    return ((BinaryMask) this.instance).getHeight();
                }

                public Builder setHeight(int value) {
                    copyOnWrite();
                    ((BinaryMask) this.instance).setHeight(value);
                    return this;
                }

                public Builder clearHeight() {
                    copyOnWrite();
                    ((BinaryMask) this.instance).clearHeight();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
                public boolean hasRasterization() {
                    return ((BinaryMask) this.instance).hasRasterization();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.BinaryMaskOrBuilder
                public RasterizationProto.Rasterization getRasterization() {
                    return ((BinaryMask) this.instance).getRasterization();
                }

                public Builder setRasterization(RasterizationProto.Rasterization value) {
                    copyOnWrite();
                    ((BinaryMask) this.instance).setRasterization(value);
                    return this;
                }

                public Builder setRasterization(RasterizationProto.Rasterization.Builder builderForValue) {
                    copyOnWrite();
                    ((BinaryMask) this.instance).setRasterization((RasterizationProto.Rasterization) builderForValue.build());
                    return this;
                }

                public Builder mergeRasterization(RasterizationProto.Rasterization value) {
                    copyOnWrite();
                    ((BinaryMask) this.instance).mergeRasterization(value);
                    return this;
                }

                public Builder clearRasterization() {
                    copyOnWrite();
                    ((BinaryMask) this.instance).clearRasterization();
                    return this;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                Parser defaultInstanceBasedParser;
                AnonymousClass1 anonymousClass1 = null;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                    case 1:
                        return new BinaryMask();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002", new Object[]{"bitField0_", "width_", "height_", "rasterization_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<BinaryMask> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (BinaryMask.class) {
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
                BinaryMask binaryMask = new BinaryMask();
                DEFAULT_INSTANCE = binaryMask;
                GeneratedMessageLite.registerDefaultInstance(BinaryMask.class, binaryMask);
            }

            public static BinaryMask getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<BinaryMask> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        public static final class RelativeKeypoint extends GeneratedMessageLite<RelativeKeypoint, Builder> implements RelativeKeypointOrBuilder {
            private static final RelativeKeypoint DEFAULT_INSTANCE;
            public static final int KEYPOINT_LABEL_FIELD_NUMBER = 3;
            private static volatile Parser<RelativeKeypoint> PARSER = null;
            public static final int SCORE_FIELD_NUMBER = 4;
            public static final int X_FIELD_NUMBER = 1;
            public static final int Y_FIELD_NUMBER = 2;
            private int bitField0_;
            private String keypointLabel_ = "";
            private float score_;
            private float x_;
            private float y_;

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

            private RelativeKeypoint() {
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public boolean hasX() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public float getX() {
                return this.x_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setX(float value) {
                this.bitField0_ |= 1;
                this.x_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearX() {
                this.bitField0_ &= -2;
                this.x_ = 0.0f;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public boolean hasY() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public float getY() {
                return this.y_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setY(float value) {
                this.bitField0_ |= 2;
                this.y_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearY() {
                this.bitField0_ &= -3;
                this.y_ = 0.0f;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public boolean hasKeypointLabel() {
                return (this.bitField0_ & 4) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public String getKeypointLabel() {
                return this.keypointLabel_;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public ByteString getKeypointLabelBytes() {
                return ByteString.copyFromUtf8(this.keypointLabel_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setKeypointLabel(String value) {
                value.getClass();
                this.bitField0_ |= 4;
                this.keypointLabel_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearKeypointLabel() {
                this.bitField0_ &= -5;
                this.keypointLabel_ = getDefaultInstance().getKeypointLabel();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setKeypointLabelBytes(ByteString value) {
                this.keypointLabel_ = value.toStringUtf8();
                this.bitField0_ |= 4;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public boolean hasScore() {
                return (this.bitField0_ & 8) != 0;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
            public float getScore() {
                return this.score_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setScore(float value) {
                this.bitField0_ |= 8;
                this.score_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearScore() {
                this.bitField0_ &= -9;
                this.score_ = 0.0f;
            }

            public static RelativeKeypoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RelativeKeypoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RelativeKeypoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RelativeKeypoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RelativeKeypoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static RelativeKeypoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static RelativeKeypoint parseFrom(InputStream input) throws IOException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static RelativeKeypoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static RelativeKeypoint parseDelimitedFrom(InputStream input) throws IOException {
                return (RelativeKeypoint) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static RelativeKeypoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RelativeKeypoint) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static RelativeKeypoint parseFrom(CodedInputStream input) throws IOException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static RelativeKeypoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (RelativeKeypoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(RelativeKeypoint prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<RelativeKeypoint, Builder> implements RelativeKeypointOrBuilder {
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
                    super(RelativeKeypoint.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public boolean hasX() {
                    return ((RelativeKeypoint) this.instance).hasX();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public float getX() {
                    return ((RelativeKeypoint) this.instance).getX();
                }

                public Builder setX(float value) {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).setX(value);
                    return this;
                }

                public Builder clearX() {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).clearX();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public boolean hasY() {
                    return ((RelativeKeypoint) this.instance).hasY();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public float getY() {
                    return ((RelativeKeypoint) this.instance).getY();
                }

                public Builder setY(float value) {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).setY(value);
                    return this;
                }

                public Builder clearY() {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).clearY();
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public boolean hasKeypointLabel() {
                    return ((RelativeKeypoint) this.instance).hasKeypointLabel();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public String getKeypointLabel() {
                    return ((RelativeKeypoint) this.instance).getKeypointLabel();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public ByteString getKeypointLabelBytes() {
                    return ((RelativeKeypoint) this.instance).getKeypointLabelBytes();
                }

                public Builder setKeypointLabel(String value) {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).setKeypointLabel(value);
                    return this;
                }

                public Builder clearKeypointLabel() {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).clearKeypointLabel();
                    return this;
                }

                public Builder setKeypointLabelBytes(ByteString value) {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).setKeypointLabelBytes(value);
                    return this;
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public boolean hasScore() {
                    return ((RelativeKeypoint) this.instance).hasScore();
                }

                @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationData.RelativeKeypointOrBuilder
                public float getScore() {
                    return ((RelativeKeypoint) this.instance).getScore();
                }

                public Builder setScore(float value) {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).setScore(value);
                    return this;
                }

                public Builder clearScore() {
                    copyOnWrite();
                    ((RelativeKeypoint) this.instance).clearScore();
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
                        return new RelativeKeypoint();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ဈ\u0002\u0004ခ\u0003", new Object[]{"bitField0_", "x_", "y_", "keypointLabel_", "score_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<RelativeKeypoint> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (RelativeKeypoint.class) {
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
                RelativeKeypoint relativeKeypoint = new RelativeKeypoint();
                DEFAULT_INSTANCE = relativeKeypoint;
                GeneratedMessageLite.registerDefaultInstance(RelativeKeypoint.class, relativeKeypoint);
            }

            public static RelativeKeypoint getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<RelativeKeypoint> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public boolean hasFormat() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public Format getFormat() {
            Format formatForNumber = Format.forNumber(this.format_);
            return formatForNumber == null ? Format.GLOBAL : formatForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFormat(Format value) {
            this.format_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFormat() {
            this.bitField0_ &= -2;
            this.format_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public boolean hasBoundingBox() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public BoundingBox getBoundingBox() {
            BoundingBox boundingBox = this.boundingBox_;
            return boundingBox == null ? BoundingBox.getDefaultInstance() : boundingBox;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBoundingBox(BoundingBox value) {
            value.getClass();
            this.boundingBox_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBoundingBox(BoundingBox value) {
            value.getClass();
            BoundingBox boundingBox = this.boundingBox_;
            if (boundingBox != null && boundingBox != BoundingBox.getDefaultInstance()) {
                this.boundingBox_ = (BoundingBox) BoundingBox.newBuilder(this.boundingBox_).mergeFrom(value).buildPartial();
            } else {
                this.boundingBox_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBoundingBox() {
            this.boundingBox_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public boolean hasRelativeBoundingBox() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public RelativeBoundingBox getRelativeBoundingBox() {
            RelativeBoundingBox relativeBoundingBox = this.relativeBoundingBox_;
            return relativeBoundingBox == null ? RelativeBoundingBox.getDefaultInstance() : relativeBoundingBox;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeBoundingBox(RelativeBoundingBox value) {
            value.getClass();
            this.relativeBoundingBox_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRelativeBoundingBox(RelativeBoundingBox value) {
            value.getClass();
            RelativeBoundingBox relativeBoundingBox = this.relativeBoundingBox_;
            if (relativeBoundingBox != null && relativeBoundingBox != RelativeBoundingBox.getDefaultInstance()) {
                this.relativeBoundingBox_ = (RelativeBoundingBox) RelativeBoundingBox.newBuilder(this.relativeBoundingBox_).mergeFrom(value).buildPartial();
            } else {
                this.relativeBoundingBox_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeBoundingBox() {
            this.relativeBoundingBox_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public boolean hasMask() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public BinaryMask getMask() {
            BinaryMask binaryMask = this.mask_;
            return binaryMask == null ? BinaryMask.getDefaultInstance() : binaryMask;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMask(BinaryMask value) {
            value.getClass();
            this.mask_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMask(BinaryMask value) {
            value.getClass();
            BinaryMask binaryMask = this.mask_;
            if (binaryMask != null && binaryMask != BinaryMask.getDefaultInstance()) {
                this.mask_ = (BinaryMask) BinaryMask.newBuilder(this.mask_).mergeFrom(value).buildPartial();
            } else {
                this.mask_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMask() {
            this.mask_ = null;
            this.bitField0_ &= -9;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public List<RelativeKeypoint> getRelativeKeypointsList() {
            return this.relativeKeypoints_;
        }

        public List<? extends RelativeKeypointOrBuilder> getRelativeKeypointsOrBuilderList() {
            return this.relativeKeypoints_;
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public int getRelativeKeypointsCount() {
            return this.relativeKeypoints_.size();
        }

        @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
        public RelativeKeypoint getRelativeKeypoints(int index) {
            return this.relativeKeypoints_.get(index);
        }

        public RelativeKeypointOrBuilder getRelativeKeypointsOrBuilder(int index) {
            return this.relativeKeypoints_.get(index);
        }

        private void ensureRelativeKeypointsIsMutable() {
            Internal.ProtobufList<RelativeKeypoint> protobufList = this.relativeKeypoints_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.relativeKeypoints_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRelativeKeypoints(int index, RelativeKeypoint value) {
            value.getClass();
            ensureRelativeKeypointsIsMutable();
            this.relativeKeypoints_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRelativeKeypoints(RelativeKeypoint value) {
            value.getClass();
            ensureRelativeKeypointsIsMutable();
            this.relativeKeypoints_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRelativeKeypoints(int index, RelativeKeypoint value) {
            value.getClass();
            ensureRelativeKeypointsIsMutable();
            this.relativeKeypoints_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRelativeKeypoints(Iterable<? extends RelativeKeypoint> values) {
            ensureRelativeKeypointsIsMutable();
            AbstractMessageLite.addAll(values, this.relativeKeypoints_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRelativeKeypoints() {
            this.relativeKeypoints_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRelativeKeypoints(int index) {
            ensureRelativeKeypointsIsMutable();
            this.relativeKeypoints_.remove(index);
        }

        public static LocationData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LocationData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LocationData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LocationData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LocationData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LocationData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LocationData parseFrom(InputStream input) throws IOException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LocationData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LocationData parseDelimitedFrom(InputStream input) throws IOException {
            return (LocationData) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static LocationData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LocationData) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LocationData parseFrom(CodedInputStream input) throws IOException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LocationData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LocationData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LocationData prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LocationData, Builder> implements LocationDataOrBuilder {
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
                super(LocationData.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public boolean hasFormat() {
                return ((LocationData) this.instance).hasFormat();
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public Format getFormat() {
                return ((LocationData) this.instance).getFormat();
            }

            public Builder setFormat(Format value) {
                copyOnWrite();
                ((LocationData) this.instance).setFormat(value);
                return this;
            }

            public Builder clearFormat() {
                copyOnWrite();
                ((LocationData) this.instance).clearFormat();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public boolean hasBoundingBox() {
                return ((LocationData) this.instance).hasBoundingBox();
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public BoundingBox getBoundingBox() {
                return ((LocationData) this.instance).getBoundingBox();
            }

            public Builder setBoundingBox(BoundingBox value) {
                copyOnWrite();
                ((LocationData) this.instance).setBoundingBox(value);
                return this;
            }

            public Builder setBoundingBox(BoundingBox.Builder builderForValue) {
                copyOnWrite();
                ((LocationData) this.instance).setBoundingBox((BoundingBox) builderForValue.build());
                return this;
            }

            public Builder mergeBoundingBox(BoundingBox value) {
                copyOnWrite();
                ((LocationData) this.instance).mergeBoundingBox(value);
                return this;
            }

            public Builder clearBoundingBox() {
                copyOnWrite();
                ((LocationData) this.instance).clearBoundingBox();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public boolean hasRelativeBoundingBox() {
                return ((LocationData) this.instance).hasRelativeBoundingBox();
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public RelativeBoundingBox getRelativeBoundingBox() {
                return ((LocationData) this.instance).getRelativeBoundingBox();
            }

            public Builder setRelativeBoundingBox(RelativeBoundingBox value) {
                copyOnWrite();
                ((LocationData) this.instance).setRelativeBoundingBox(value);
                return this;
            }

            public Builder setRelativeBoundingBox(RelativeBoundingBox.Builder builderForValue) {
                copyOnWrite();
                ((LocationData) this.instance).setRelativeBoundingBox((RelativeBoundingBox) builderForValue.build());
                return this;
            }

            public Builder mergeRelativeBoundingBox(RelativeBoundingBox value) {
                copyOnWrite();
                ((LocationData) this.instance).mergeRelativeBoundingBox(value);
                return this;
            }

            public Builder clearRelativeBoundingBox() {
                copyOnWrite();
                ((LocationData) this.instance).clearRelativeBoundingBox();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public boolean hasMask() {
                return ((LocationData) this.instance).hasMask();
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public BinaryMask getMask() {
                return ((LocationData) this.instance).getMask();
            }

            public Builder setMask(BinaryMask value) {
                copyOnWrite();
                ((LocationData) this.instance).setMask(value);
                return this;
            }

            public Builder setMask(BinaryMask.Builder builderForValue) {
                copyOnWrite();
                ((LocationData) this.instance).setMask((BinaryMask) builderForValue.build());
                return this;
            }

            public Builder mergeMask(BinaryMask value) {
                copyOnWrite();
                ((LocationData) this.instance).mergeMask(value);
                return this;
            }

            public Builder clearMask() {
                copyOnWrite();
                ((LocationData) this.instance).clearMask();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public List<RelativeKeypoint> getRelativeKeypointsList() {
                return Collections.unmodifiableList(((LocationData) this.instance).getRelativeKeypointsList());
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public int getRelativeKeypointsCount() {
                return ((LocationData) this.instance).getRelativeKeypointsCount();
            }

            @Override // com.google.mediapipe.formats.proto.LocationDataProto.LocationDataOrBuilder
            public RelativeKeypoint getRelativeKeypoints(int index) {
                return ((LocationData) this.instance).getRelativeKeypoints(index);
            }

            public Builder setRelativeKeypoints(int index, RelativeKeypoint value) {
                copyOnWrite();
                ((LocationData) this.instance).setRelativeKeypoints(index, value);
                return this;
            }

            public Builder setRelativeKeypoints(int index, RelativeKeypoint.Builder builderForValue) {
                copyOnWrite();
                ((LocationData) this.instance).setRelativeKeypoints(index, (RelativeKeypoint) builderForValue.build());
                return this;
            }

            public Builder addRelativeKeypoints(RelativeKeypoint value) {
                copyOnWrite();
                ((LocationData) this.instance).addRelativeKeypoints(value);
                return this;
            }

            public Builder addRelativeKeypoints(int index, RelativeKeypoint value) {
                copyOnWrite();
                ((LocationData) this.instance).addRelativeKeypoints(index, value);
                return this;
            }

            public Builder addRelativeKeypoints(RelativeKeypoint.Builder builderForValue) {
                copyOnWrite();
                ((LocationData) this.instance).addRelativeKeypoints((RelativeKeypoint) builderForValue.build());
                return this;
            }

            public Builder addRelativeKeypoints(int index, RelativeKeypoint.Builder builderForValue) {
                copyOnWrite();
                ((LocationData) this.instance).addRelativeKeypoints(index, (RelativeKeypoint) builderForValue.build());
                return this;
            }

            public Builder addAllRelativeKeypoints(Iterable<? extends RelativeKeypoint> values) {
                copyOnWrite();
                ((LocationData) this.instance).addAllRelativeKeypoints(values);
                return this;
            }

            public Builder clearRelativeKeypoints() {
                copyOnWrite();
                ((LocationData) this.instance).clearRelativeKeypoints();
                return this;
            }

            public Builder removeRelativeKeypoints(int index) {
                copyOnWrite();
                ((LocationData) this.instance).removeRelativeKeypoints(index);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new LocationData();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005\u001b", new Object[]{"bitField0_", "format_", Format.internalGetVerifier(), "boundingBox_", "relativeBoundingBox_", "mask_", "relativeKeypoints_", RelativeKeypoint.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LocationData> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LocationData.class) {
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
            LocationData locationData = new LocationData();
            DEFAULT_INSTANCE = locationData;
            GeneratedMessageLite.registerDefaultInstance(LocationData.class, locationData);
        }

        public static LocationData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LocationData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.formats.proto.LocationDataProto$1, reason: invalid class name */
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
