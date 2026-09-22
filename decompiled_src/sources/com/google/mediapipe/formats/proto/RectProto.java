package com.google.mediapipe.formats.proto;

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
public final class RectProto {

    public interface NormalizedRectOrBuilder extends MessageLiteOrBuilder {
        float getHeight();

        long getRectId();

        float getRotation();

        float getWidth();

        float getXCenter();

        float getYCenter();

        boolean hasHeight();

        boolean hasRectId();

        boolean hasRotation();

        boolean hasWidth();

        boolean hasXCenter();

        boolean hasYCenter();
    }

    public interface RectOrBuilder extends MessageLiteOrBuilder {
        int getHeight();

        long getRectId();

        float getRotation();

        int getWidth();

        int getXCenter();

        int getYCenter();

        boolean hasHeight();

        boolean hasRectId();

        boolean hasRotation();

        boolean hasWidth();

        boolean hasXCenter();

        boolean hasYCenter();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private RectProto() {
    }

    public static final class Rect extends GeneratedMessageLite<Rect, Builder> implements RectOrBuilder {
        private static final Rect DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 3;
        private static volatile Parser<Rect> PARSER = null;
        public static final int RECT_ID_FIELD_NUMBER = 6;
        public static final int ROTATION_FIELD_NUMBER = 5;
        public static final int WIDTH_FIELD_NUMBER = 4;
        public static final int X_CENTER_FIELD_NUMBER = 1;
        public static final int Y_CENTER_FIELD_NUMBER = 2;
        private int bitField0_;
        private int height_;
        private byte memoizedIsInitialized = 2;
        private long rectId_;
        private float rotation_;
        private int width_;
        private int xCenter_;
        private int yCenter_;

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

        private Rect() {
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public boolean hasXCenter() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public int getXCenter() {
            return this.xCenter_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXCenter(int value) {
            this.bitField0_ |= 1;
            this.xCenter_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXCenter() {
            this.bitField0_ &= -2;
            this.xCenter_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public boolean hasYCenter() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public int getYCenter() {
            return this.yCenter_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setYCenter(int value) {
            this.bitField0_ |= 2;
            this.yCenter_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearYCenter() {
            this.bitField0_ &= -3;
            this.yCenter_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public boolean hasHeight() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public int getHeight() {
            return this.height_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int value) {
            this.bitField0_ |= 4;
            this.height_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.bitField0_ &= -5;
            this.height_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public boolean hasWidth() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public int getWidth() {
            return this.width_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int value) {
            this.bitField0_ |= 8;
            this.width_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.bitField0_ &= -9;
            this.width_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public boolean hasRotation() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public float getRotation() {
            return this.rotation_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRotation(float value) {
            this.bitField0_ |= 16;
            this.rotation_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRotation() {
            this.bitField0_ &= -17;
            this.rotation_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public boolean hasRectId() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
        public long getRectId() {
            return this.rectId_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRectId(long value) {
            this.bitField0_ |= 32;
            this.rectId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRectId() {
            this.bitField0_ &= -33;
            this.rectId_ = 0L;
        }

        public static Rect parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Rect parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Rect parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Rect parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Rect parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Rect parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Rect parseFrom(InputStream input) throws IOException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Rect parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Rect parseDelimitedFrom(InputStream input) throws IOException {
            return (Rect) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Rect parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Rect) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Rect parseFrom(CodedInputStream input) throws IOException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Rect parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Rect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Rect prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Rect, Builder> implements RectOrBuilder {
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
                super(Rect.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public boolean hasXCenter() {
                return ((Rect) this.instance).hasXCenter();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public int getXCenter() {
                return ((Rect) this.instance).getXCenter();
            }

            public Builder setXCenter(int value) {
                copyOnWrite();
                ((Rect) this.instance).setXCenter(value);
                return this;
            }

            public Builder clearXCenter() {
                copyOnWrite();
                ((Rect) this.instance).clearXCenter();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public boolean hasYCenter() {
                return ((Rect) this.instance).hasYCenter();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public int getYCenter() {
                return ((Rect) this.instance).getYCenter();
            }

            public Builder setYCenter(int value) {
                copyOnWrite();
                ((Rect) this.instance).setYCenter(value);
                return this;
            }

            public Builder clearYCenter() {
                copyOnWrite();
                ((Rect) this.instance).clearYCenter();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public boolean hasHeight() {
                return ((Rect) this.instance).hasHeight();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public int getHeight() {
                return ((Rect) this.instance).getHeight();
            }

            public Builder setHeight(int value) {
                copyOnWrite();
                ((Rect) this.instance).setHeight(value);
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                ((Rect) this.instance).clearHeight();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public boolean hasWidth() {
                return ((Rect) this.instance).hasWidth();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public int getWidth() {
                return ((Rect) this.instance).getWidth();
            }

            public Builder setWidth(int value) {
                copyOnWrite();
                ((Rect) this.instance).setWidth(value);
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((Rect) this.instance).clearWidth();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public boolean hasRotation() {
                return ((Rect) this.instance).hasRotation();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public float getRotation() {
                return ((Rect) this.instance).getRotation();
            }

            public Builder setRotation(float value) {
                copyOnWrite();
                ((Rect) this.instance).setRotation(value);
                return this;
            }

            public Builder clearRotation() {
                copyOnWrite();
                ((Rect) this.instance).clearRotation();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public boolean hasRectId() {
                return ((Rect) this.instance).hasRectId();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.RectOrBuilder
            public long getRectId() {
                return ((Rect) this.instance).getRectId();
            }

            public Builder setRectId(long value) {
                copyOnWrite();
                ((Rect) this.instance).setRectId(value);
                return this;
            }

            public Builder clearRectId() {
                copyOnWrite();
                ((Rect) this.instance).clearRectId();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new Rect();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002\u0004ᔄ\u0003\u0005ခ\u0004\u0006ဂ\u0005", new Object[]{"bitField0_", "xCenter_", "yCenter_", "height_", "width_", "rotation_", "rectId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Rect> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Rect.class) {
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
            Rect rect = new Rect();
            DEFAULT_INSTANCE = rect;
            GeneratedMessageLite.registerDefaultInstance(Rect.class, rect);
        }

        public static Rect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Rect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.formats.proto.RectProto$1, reason: invalid class name */
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

    public static final class NormalizedRect extends GeneratedMessageLite<NormalizedRect, Builder> implements NormalizedRectOrBuilder {
        private static final NormalizedRect DEFAULT_INSTANCE;
        public static final int HEIGHT_FIELD_NUMBER = 3;
        private static volatile Parser<NormalizedRect> PARSER = null;
        public static final int RECT_ID_FIELD_NUMBER = 6;
        public static final int ROTATION_FIELD_NUMBER = 5;
        public static final int WIDTH_FIELD_NUMBER = 4;
        public static final int X_CENTER_FIELD_NUMBER = 1;
        public static final int Y_CENTER_FIELD_NUMBER = 2;
        private int bitField0_;
        private float height_;
        private byte memoizedIsInitialized = 2;
        private long rectId_;
        private float rotation_;
        private float width_;
        private float xCenter_;
        private float yCenter_;

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

        private NormalizedRect() {
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public boolean hasXCenter() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public float getXCenter() {
            return this.xCenter_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXCenter(float value) {
            this.bitField0_ |= 1;
            this.xCenter_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXCenter() {
            this.bitField0_ &= -2;
            this.xCenter_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public boolean hasYCenter() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public float getYCenter() {
            return this.yCenter_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setYCenter(float value) {
            this.bitField0_ |= 2;
            this.yCenter_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearYCenter() {
            this.bitField0_ &= -3;
            this.yCenter_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public boolean hasHeight() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public float getHeight() {
            return this.height_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(float value) {
            this.bitField0_ |= 4;
            this.height_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeight() {
            this.bitField0_ &= -5;
            this.height_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public boolean hasWidth() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public float getWidth() {
            return this.width_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(float value) {
            this.bitField0_ |= 8;
            this.width_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWidth() {
            this.bitField0_ &= -9;
            this.width_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public boolean hasRotation() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public float getRotation() {
            return this.rotation_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRotation(float value) {
            this.bitField0_ |= 16;
            this.rotation_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRotation() {
            this.bitField0_ &= -17;
            this.rotation_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public boolean hasRectId() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
        public long getRectId() {
            return this.rectId_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRectId(long value) {
            this.bitField0_ |= 32;
            this.rectId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRectId() {
            this.bitField0_ &= -33;
            this.rectId_ = 0L;
        }

        public static NormalizedRect parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedRect parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedRect parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedRect parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedRect parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedRect parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedRect parseFrom(InputStream input) throws IOException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedRect parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedRect parseDelimitedFrom(InputStream input) throws IOException {
            return (NormalizedRect) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedRect parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedRect) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedRect parseFrom(CodedInputStream input) throws IOException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedRect parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NormalizedRect prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<NormalizedRect, Builder> implements NormalizedRectOrBuilder {
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
                super(NormalizedRect.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public boolean hasXCenter() {
                return ((NormalizedRect) this.instance).hasXCenter();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public float getXCenter() {
                return ((NormalizedRect) this.instance).getXCenter();
            }

            public Builder setXCenter(float value) {
                copyOnWrite();
                ((NormalizedRect) this.instance).setXCenter(value);
                return this;
            }

            public Builder clearXCenter() {
                copyOnWrite();
                ((NormalizedRect) this.instance).clearXCenter();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public boolean hasYCenter() {
                return ((NormalizedRect) this.instance).hasYCenter();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public float getYCenter() {
                return ((NormalizedRect) this.instance).getYCenter();
            }

            public Builder setYCenter(float value) {
                copyOnWrite();
                ((NormalizedRect) this.instance).setYCenter(value);
                return this;
            }

            public Builder clearYCenter() {
                copyOnWrite();
                ((NormalizedRect) this.instance).clearYCenter();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public boolean hasHeight() {
                return ((NormalizedRect) this.instance).hasHeight();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public float getHeight() {
                return ((NormalizedRect) this.instance).getHeight();
            }

            public Builder setHeight(float value) {
                copyOnWrite();
                ((NormalizedRect) this.instance).setHeight(value);
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                ((NormalizedRect) this.instance).clearHeight();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public boolean hasWidth() {
                return ((NormalizedRect) this.instance).hasWidth();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public float getWidth() {
                return ((NormalizedRect) this.instance).getWidth();
            }

            public Builder setWidth(float value) {
                copyOnWrite();
                ((NormalizedRect) this.instance).setWidth(value);
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                ((NormalizedRect) this.instance).clearWidth();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public boolean hasRotation() {
                return ((NormalizedRect) this.instance).hasRotation();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public float getRotation() {
                return ((NormalizedRect) this.instance).getRotation();
            }

            public Builder setRotation(float value) {
                copyOnWrite();
                ((NormalizedRect) this.instance).setRotation(value);
                return this;
            }

            public Builder clearRotation() {
                copyOnWrite();
                ((NormalizedRect) this.instance).clearRotation();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public boolean hasRectId() {
                return ((NormalizedRect) this.instance).hasRectId();
            }

            @Override // com.google.mediapipe.formats.proto.RectProto.NormalizedRectOrBuilder
            public long getRectId() {
                return ((NormalizedRect) this.instance).getRectId();
            }

            public Builder setRectId(long value) {
                copyOnWrite();
                ((NormalizedRect) this.instance).setRectId(value);
                return this;
            }

            public Builder clearRectId() {
                copyOnWrite();
                ((NormalizedRect) this.instance).clearRectId();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            Parser defaultInstanceBasedParser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[method.ordinal()]) {
                case 1:
                    return new NormalizedRect();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ᔁ\u0003\u0005ခ\u0004\u0006ဂ\u0005", new Object[]{"bitField0_", "xCenter_", "yCenter_", "height_", "width_", "rotation_", "rectId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<NormalizedRect> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (NormalizedRect.class) {
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
            NormalizedRect normalizedRect = new NormalizedRect();
            DEFAULT_INSTANCE = normalizedRect;
            GeneratedMessageLite.registerDefaultInstance(NormalizedRect.class, normalizedRect);
        }

        public static NormalizedRect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NormalizedRect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
