package com.google.mediapipe.tasks.vision.interactivesegmenter.proto;

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
public final class RegionOfInterestProto {

    public interface PointOrBuilder extends MessageLiteOrBuilder {
        boolean getNormalized();

        float getX();

        float getY();
    }

    public interface RegionOfInterestOrBuilder extends MessageLiteOrBuilder {
        RegionOfInterest.FocusRegionCase getFocusRegionCase();

        Point getKeypoint();

        Scribble getScribble();

        boolean hasKeypoint();

        boolean hasScribble();
    }

    public interface ScribbleOrBuilder extends MessageLiteOrBuilder {
        Point getPoint(int index);

        int getPointCount();

        List<Point> getPointList();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private RegionOfInterestProto() {
    }

    public static final class Point extends GeneratedMessageLite<Point, Builder> implements PointOrBuilder {
        private static final Point DEFAULT_INSTANCE;
        public static final int NORMALIZED_FIELD_NUMBER = 3;
        private static volatile Parser<Point> PARSER = null;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private boolean normalized_;
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

        private Point() {
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.PointOrBuilder
        public float getX() {
            return this.x_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setX(float value) {
            this.x_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearX() {
            this.x_ = 0.0f;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.PointOrBuilder
        public float getY() {
            return this.y_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setY(float value) {
            this.y_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearY() {
            this.y_ = 0.0f;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.PointOrBuilder
        public boolean getNormalized() {
            return this.normalized_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNormalized(boolean value) {
            this.normalized_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNormalized() {
            this.normalized_ = false;
        }

        public static Point parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Point parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Point parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Point parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Point parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Point parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Point parseFrom(InputStream input) throws IOException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Point parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Point parseDelimitedFrom(InputStream input) throws IOException {
            return (Point) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Point parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Point) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Point parseFrom(CodedInputStream input) throws IOException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Point parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Point) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Point prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Point, Builder> implements PointOrBuilder {
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
                super(Point.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.PointOrBuilder
            public float getX() {
                return ((Point) this.instance).getX();
            }

            public Builder setX(float value) {
                copyOnWrite();
                ((Point) this.instance).setX(value);
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                ((Point) this.instance).clearX();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.PointOrBuilder
            public float getY() {
                return ((Point) this.instance).getY();
            }

            public Builder setY(float value) {
                copyOnWrite();
                ((Point) this.instance).setY(value);
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                ((Point) this.instance).clearY();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.PointOrBuilder
            public boolean getNormalized() {
                return ((Point) this.instance).getNormalized();
            }

            public Builder setNormalized(boolean value) {
                copyOnWrite();
                ((Point) this.instance).setNormalized(value);
                return this;
            }

            public Builder clearNormalized() {
                copyOnWrite();
                ((Point) this.instance).clearNormalized();
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
                    return new Point();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0001\u0002\u0001\u0003\u0007", new Object[]{"x_", "y_", "normalized_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Point> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Point.class) {
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
            Point point = new Point();
            DEFAULT_INSTANCE = point;
            GeneratedMessageLite.registerDefaultInstance(Point.class, point);
        }

        public static Point getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Point> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto$1, reason: invalid class name */
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

    public static final class Scribble extends GeneratedMessageLite<Scribble, Builder> implements ScribbleOrBuilder {
        private static final Scribble DEFAULT_INSTANCE;
        private static volatile Parser<Scribble> PARSER = null;
        public static final int POINT_FIELD_NUMBER = 1;
        private Internal.ProtobufList<Point> point_ = emptyProtobufList();

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

        private Scribble() {
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.ScribbleOrBuilder
        public List<Point> getPointList() {
            return this.point_;
        }

        public List<? extends PointOrBuilder> getPointOrBuilderList() {
            return this.point_;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.ScribbleOrBuilder
        public int getPointCount() {
            return this.point_.size();
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.ScribbleOrBuilder
        public Point getPoint(int index) {
            return this.point_.get(index);
        }

        public PointOrBuilder getPointOrBuilder(int index) {
            return this.point_.get(index);
        }

        private void ensurePointIsMutable() {
            Internal.ProtobufList<Point> protobufList = this.point_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.point_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoint(int index, Point value) {
            value.getClass();
            ensurePointIsMutable();
            this.point_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPoint(Point value) {
            value.getClass();
            ensurePointIsMutable();
            this.point_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPoint(int index, Point value) {
            value.getClass();
            ensurePointIsMutable();
            this.point_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPoint(Iterable<? extends Point> values) {
            ensurePointIsMutable();
            AbstractMessageLite.addAll(values, this.point_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoint() {
            this.point_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePoint(int index) {
            ensurePointIsMutable();
            this.point_.remove(index);
        }

        public static Scribble parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Scribble parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Scribble parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Scribble parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Scribble parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Scribble parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Scribble parseFrom(InputStream input) throws IOException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Scribble parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Scribble parseDelimitedFrom(InputStream input) throws IOException {
            return (Scribble) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Scribble parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Scribble) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Scribble parseFrom(CodedInputStream input) throws IOException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Scribble parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Scribble) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Scribble prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Scribble, Builder> implements ScribbleOrBuilder {
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
                super(Scribble.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.ScribbleOrBuilder
            public List<Point> getPointList() {
                return Collections.unmodifiableList(((Scribble) this.instance).getPointList());
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.ScribbleOrBuilder
            public int getPointCount() {
                return ((Scribble) this.instance).getPointCount();
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.ScribbleOrBuilder
            public Point getPoint(int index) {
                return ((Scribble) this.instance).getPoint(index);
            }

            public Builder setPoint(int index, Point value) {
                copyOnWrite();
                ((Scribble) this.instance).setPoint(index, value);
                return this;
            }

            public Builder setPoint(int index, Point.Builder builderForValue) {
                copyOnWrite();
                ((Scribble) this.instance).setPoint(index, (Point) builderForValue.build());
                return this;
            }

            public Builder addPoint(Point value) {
                copyOnWrite();
                ((Scribble) this.instance).addPoint(value);
                return this;
            }

            public Builder addPoint(int index, Point value) {
                copyOnWrite();
                ((Scribble) this.instance).addPoint(index, value);
                return this;
            }

            public Builder addPoint(Point.Builder builderForValue) {
                copyOnWrite();
                ((Scribble) this.instance).addPoint((Point) builderForValue.build());
                return this;
            }

            public Builder addPoint(int index, Point.Builder builderForValue) {
                copyOnWrite();
                ((Scribble) this.instance).addPoint(index, (Point) builderForValue.build());
                return this;
            }

            public Builder addAllPoint(Iterable<? extends Point> values) {
                copyOnWrite();
                ((Scribble) this.instance).addAllPoint(values);
                return this;
            }

            public Builder clearPoint() {
                copyOnWrite();
                ((Scribble) this.instance).clearPoint();
                return this;
            }

            public Builder removePoint(int index) {
                copyOnWrite();
                ((Scribble) this.instance).removePoint(index);
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
                    return new Scribble();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"point_", Point.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Scribble> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Scribble.class) {
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
            Scribble scribble = new Scribble();
            DEFAULT_INSTANCE = scribble;
            GeneratedMessageLite.registerDefaultInstance(Scribble.class, scribble);
        }

        public static Scribble getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Scribble> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RegionOfInterest extends GeneratedMessageLite<RegionOfInterest, Builder> implements RegionOfInterestOrBuilder {
        private static final RegionOfInterest DEFAULT_INSTANCE;
        public static final int KEYPOINT_FIELD_NUMBER = 1;
        private static volatile Parser<RegionOfInterest> PARSER = null;
        public static final int SCRIBBLE_FIELD_NUMBER = 2;
        private int focusRegionCase_ = 0;
        private Object focusRegion_;

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

        private RegionOfInterest() {
        }

        public enum FocusRegionCase {
            KEYPOINT(1),
            SCRIBBLE(2),
            FOCUSREGION_NOT_SET(0);

            private final int value;

            FocusRegionCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static FocusRegionCase valueOf(int value) {
                return forNumber(value);
            }

            public static FocusRegionCase forNumber(int value) {
                if (value == 0) {
                    return FOCUSREGION_NOT_SET;
                }
                if (value == 1) {
                    return KEYPOINT;
                }
                if (value != 2) {
                    return null;
                }
                return SCRIBBLE;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
        public FocusRegionCase getFocusRegionCase() {
            return FocusRegionCase.forNumber(this.focusRegionCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFocusRegion() {
            this.focusRegionCase_ = 0;
            this.focusRegion_ = null;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
        public boolean hasKeypoint() {
            return this.focusRegionCase_ == 1;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
        public Point getKeypoint() {
            if (this.focusRegionCase_ == 1) {
                return (Point) this.focusRegion_;
            }
            return Point.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeypoint(Point value) {
            value.getClass();
            this.focusRegion_ = value;
            this.focusRegionCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeKeypoint(Point value) {
            value.getClass();
            if (this.focusRegionCase_ == 1 && this.focusRegion_ != Point.getDefaultInstance()) {
                this.focusRegion_ = Point.newBuilder((Point) this.focusRegion_).mergeFrom(value).buildPartial();
            } else {
                this.focusRegion_ = value;
            }
            this.focusRegionCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeypoint() {
            if (this.focusRegionCase_ == 1) {
                this.focusRegionCase_ = 0;
                this.focusRegion_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
        public boolean hasScribble() {
            return this.focusRegionCase_ == 2;
        }

        @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
        public Scribble getScribble() {
            if (this.focusRegionCase_ == 2) {
                return (Scribble) this.focusRegion_;
            }
            return Scribble.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScribble(Scribble value) {
            value.getClass();
            this.focusRegion_ = value;
            this.focusRegionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeScribble(Scribble value) {
            value.getClass();
            if (this.focusRegionCase_ == 2 && this.focusRegion_ != Scribble.getDefaultInstance()) {
                this.focusRegion_ = Scribble.newBuilder((Scribble) this.focusRegion_).mergeFrom(value).buildPartial();
            } else {
                this.focusRegion_ = value;
            }
            this.focusRegionCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScribble() {
            if (this.focusRegionCase_ == 2) {
                this.focusRegionCase_ = 0;
                this.focusRegion_ = null;
            }
        }

        public static RegionOfInterest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RegionOfInterest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RegionOfInterest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RegionOfInterest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RegionOfInterest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RegionOfInterest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RegionOfInterest parseFrom(InputStream input) throws IOException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RegionOfInterest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RegionOfInterest parseDelimitedFrom(InputStream input) throws IOException {
            return (RegionOfInterest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static RegionOfInterest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionOfInterest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RegionOfInterest parseFrom(CodedInputStream input) throws IOException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RegionOfInterest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegionOfInterest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RegionOfInterest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RegionOfInterest, Builder> implements RegionOfInterestOrBuilder {
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
                super(RegionOfInterest.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
            public FocusRegionCase getFocusRegionCase() {
                return ((RegionOfInterest) this.instance).getFocusRegionCase();
            }

            public Builder clearFocusRegion() {
                copyOnWrite();
                ((RegionOfInterest) this.instance).clearFocusRegion();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
            public boolean hasKeypoint() {
                return ((RegionOfInterest) this.instance).hasKeypoint();
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
            public Point getKeypoint() {
                return ((RegionOfInterest) this.instance).getKeypoint();
            }

            public Builder setKeypoint(Point value) {
                copyOnWrite();
                ((RegionOfInterest) this.instance).setKeypoint(value);
                return this;
            }

            public Builder setKeypoint(Point.Builder builderForValue) {
                copyOnWrite();
                ((RegionOfInterest) this.instance).setKeypoint((Point) builderForValue.build());
                return this;
            }

            public Builder mergeKeypoint(Point value) {
                copyOnWrite();
                ((RegionOfInterest) this.instance).mergeKeypoint(value);
                return this;
            }

            public Builder clearKeypoint() {
                copyOnWrite();
                ((RegionOfInterest) this.instance).clearKeypoint();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
            public boolean hasScribble() {
                return ((RegionOfInterest) this.instance).hasScribble();
            }

            @Override // com.google.mediapipe.tasks.vision.interactivesegmenter.proto.RegionOfInterestProto.RegionOfInterestOrBuilder
            public Scribble getScribble() {
                return ((RegionOfInterest) this.instance).getScribble();
            }

            public Builder setScribble(Scribble value) {
                copyOnWrite();
                ((RegionOfInterest) this.instance).setScribble(value);
                return this;
            }

            public Builder setScribble(Scribble.Builder builderForValue) {
                copyOnWrite();
                ((RegionOfInterest) this.instance).setScribble((Scribble) builderForValue.build());
                return this;
            }

            public Builder mergeScribble(Scribble value) {
                copyOnWrite();
                ((RegionOfInterest) this.instance).mergeScribble(value);
                return this;
            }

            public Builder clearScribble() {
                copyOnWrite();
                ((RegionOfInterest) this.instance).clearScribble();
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
                    return new RegionOfInterest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"focusRegion_", "focusRegionCase_", Point.class, Scribble.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<RegionOfInterest> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (RegionOfInterest.class) {
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
            RegionOfInterest regionOfInterest = new RegionOfInterest();
            DEFAULT_INSTANCE = regionOfInterest;
            GeneratedMessageLite.registerDefaultInstance(RegionOfInterest.class, regionOfInterest);
        }

        public static RegionOfInterest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RegionOfInterest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
