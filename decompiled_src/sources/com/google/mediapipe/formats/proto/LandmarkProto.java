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
public final class LandmarkProto {

    public interface LandmarkListCollectionOrBuilder extends MessageLiteOrBuilder {
        LandmarkList getLandmarkList(int index);

        int getLandmarkListCount();

        List<LandmarkList> getLandmarkListList();
    }

    public interface LandmarkListOrBuilder extends MessageLiteOrBuilder {
        Landmark getLandmark(int index);

        int getLandmarkCount();

        List<Landmark> getLandmarkList();
    }

    public interface LandmarkOrBuilder extends MessageLiteOrBuilder {
        float getPresence();

        float getVisibility();

        float getX();

        float getY();

        float getZ();

        boolean hasPresence();

        boolean hasVisibility();

        boolean hasX();

        boolean hasY();

        boolean hasZ();
    }

    public interface NormalizedLandmarkListCollectionOrBuilder extends MessageLiteOrBuilder {
        NormalizedLandmarkList getLandmarkList(int index);

        int getLandmarkListCount();

        List<NormalizedLandmarkList> getLandmarkListList();
    }

    public interface NormalizedLandmarkListOrBuilder extends MessageLiteOrBuilder {
        NormalizedLandmark getLandmark(int index);

        int getLandmarkCount();

        List<NormalizedLandmark> getLandmarkList();
    }

    public interface NormalizedLandmarkOrBuilder extends MessageLiteOrBuilder {
        float getPresence();

        float getVisibility();

        float getX();

        float getY();

        float getZ();

        boolean hasPresence();

        boolean hasVisibility();

        boolean hasX();

        boolean hasY();

        boolean hasZ();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private LandmarkProto() {
    }

    public static final class Landmark extends GeneratedMessageLite<Landmark, Builder> implements LandmarkOrBuilder {
        private static final Landmark DEFAULT_INSTANCE;
        private static volatile Parser<Landmark> PARSER = null;
        public static final int PRESENCE_FIELD_NUMBER = 5;
        public static final int VISIBILITY_FIELD_NUMBER = 4;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        public static final int Z_FIELD_NUMBER = 3;
        private int bitField0_;
        private float presence_;
        private float visibility_;
        private float x_;
        private float y_;
        private float z_;

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

        private Landmark() {
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public boolean hasX() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
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

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public boolean hasY() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
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

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public boolean hasZ() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public float getZ() {
            return this.z_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZ(float value) {
            this.bitField0_ |= 4;
            this.z_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZ() {
            this.bitField0_ &= -5;
            this.z_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public boolean hasVisibility() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public float getVisibility() {
            return this.visibility_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVisibility(float value) {
            this.bitField0_ |= 8;
            this.visibility_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVisibility() {
            this.bitField0_ &= -9;
            this.visibility_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public boolean hasPresence() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
        public float getPresence() {
            return this.presence_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresence(float value) {
            this.bitField0_ |= 16;
            this.presence_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresence() {
            this.bitField0_ &= -17;
            this.presence_ = 0.0f;
        }

        public static Landmark parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Landmark parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Landmark parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Landmark parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Landmark parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Landmark parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Landmark parseFrom(InputStream input) throws IOException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Landmark parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Landmark parseDelimitedFrom(InputStream input) throws IOException {
            return (Landmark) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Landmark parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Landmark) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Landmark parseFrom(CodedInputStream input) throws IOException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Landmark parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Landmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Landmark prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Landmark, Builder> implements LandmarkOrBuilder {
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
                super(Landmark.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public boolean hasX() {
                return ((Landmark) this.instance).hasX();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public float getX() {
                return ((Landmark) this.instance).getX();
            }

            public Builder setX(float value) {
                copyOnWrite();
                ((Landmark) this.instance).setX(value);
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                ((Landmark) this.instance).clearX();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public boolean hasY() {
                return ((Landmark) this.instance).hasY();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public float getY() {
                return ((Landmark) this.instance).getY();
            }

            public Builder setY(float value) {
                copyOnWrite();
                ((Landmark) this.instance).setY(value);
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                ((Landmark) this.instance).clearY();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public boolean hasZ() {
                return ((Landmark) this.instance).hasZ();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public float getZ() {
                return ((Landmark) this.instance).getZ();
            }

            public Builder setZ(float value) {
                copyOnWrite();
                ((Landmark) this.instance).setZ(value);
                return this;
            }

            public Builder clearZ() {
                copyOnWrite();
                ((Landmark) this.instance).clearZ();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public boolean hasVisibility() {
                return ((Landmark) this.instance).hasVisibility();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public float getVisibility() {
                return ((Landmark) this.instance).getVisibility();
            }

            public Builder setVisibility(float value) {
                copyOnWrite();
                ((Landmark) this.instance).setVisibility(value);
                return this;
            }

            public Builder clearVisibility() {
                copyOnWrite();
                ((Landmark) this.instance).clearVisibility();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public boolean hasPresence() {
                return ((Landmark) this.instance).hasPresence();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkOrBuilder
            public float getPresence() {
                return ((Landmark) this.instance).getPresence();
            }

            public Builder setPresence(float value) {
                copyOnWrite();
                ((Landmark) this.instance).setPresence(value);
                return this;
            }

            public Builder clearPresence() {
                copyOnWrite();
                ((Landmark) this.instance).clearPresence();
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
                    return new Landmark();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004", new Object[]{"bitField0_", "x_", "y_", "z_", "visibility_", "presence_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Landmark> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Landmark.class) {
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
            Landmark landmark = new Landmark();
            DEFAULT_INSTANCE = landmark;
            GeneratedMessageLite.registerDefaultInstance(Landmark.class, landmark);
        }

        public static Landmark getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Landmark> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.formats.proto.LandmarkProto$1, reason: invalid class name */
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

    public static final class LandmarkList extends GeneratedMessageLite<LandmarkList, Builder> implements LandmarkListOrBuilder {
        private static final LandmarkList DEFAULT_INSTANCE;
        public static final int LANDMARK_FIELD_NUMBER = 1;
        private static volatile Parser<LandmarkList> PARSER;
        private Internal.ProtobufList<Landmark> landmark_ = emptyProtobufList();

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

        private LandmarkList() {
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListOrBuilder
        public List<Landmark> getLandmarkList() {
            return this.landmark_;
        }

        public List<? extends LandmarkOrBuilder> getLandmarkOrBuilderList() {
            return this.landmark_;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListOrBuilder
        public int getLandmarkCount() {
            return this.landmark_.size();
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListOrBuilder
        public Landmark getLandmark(int index) {
            return this.landmark_.get(index);
        }

        public LandmarkOrBuilder getLandmarkOrBuilder(int index) {
            return this.landmark_.get(index);
        }

        private void ensureLandmarkIsMutable() {
            Internal.ProtobufList<Landmark> protobufList = this.landmark_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.landmark_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandmark(int index, Landmark value) {
            value.getClass();
            ensureLandmarkIsMutable();
            this.landmark_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmark(Landmark value) {
            value.getClass();
            ensureLandmarkIsMutable();
            this.landmark_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmark(int index, Landmark value) {
            value.getClass();
            ensureLandmarkIsMutable();
            this.landmark_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLandmark(Iterable<? extends Landmark> values) {
            ensureLandmarkIsMutable();
            AbstractMessageLite.addAll(values, this.landmark_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandmark() {
            this.landmark_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLandmark(int index) {
            ensureLandmarkIsMutable();
            this.landmark_.remove(index);
        }

        public static LandmarkList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarkList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarkList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarkList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarkList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarkList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarkList parseFrom(InputStream input) throws IOException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarkList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LandmarkList parseDelimitedFrom(InputStream input) throws IOException {
            return (LandmarkList) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarkList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarkList) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LandmarkList parseFrom(CodedInputStream input) throws IOException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarkList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LandmarkList prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LandmarkList, Builder> implements LandmarkListOrBuilder {
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
                super(LandmarkList.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListOrBuilder
            public List<Landmark> getLandmarkList() {
                return Collections.unmodifiableList(((LandmarkList) this.instance).getLandmarkList());
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListOrBuilder
            public int getLandmarkCount() {
                return ((LandmarkList) this.instance).getLandmarkCount();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListOrBuilder
            public Landmark getLandmark(int index) {
                return ((LandmarkList) this.instance).getLandmark(index);
            }

            public Builder setLandmark(int index, Landmark value) {
                copyOnWrite();
                ((LandmarkList) this.instance).setLandmark(index, value);
                return this;
            }

            public Builder setLandmark(int index, Landmark.Builder builderForValue) {
                copyOnWrite();
                ((LandmarkList) this.instance).setLandmark(index, (Landmark) builderForValue.build());
                return this;
            }

            public Builder addLandmark(Landmark value) {
                copyOnWrite();
                ((LandmarkList) this.instance).addLandmark(value);
                return this;
            }

            public Builder addLandmark(int index, Landmark value) {
                copyOnWrite();
                ((LandmarkList) this.instance).addLandmark(index, value);
                return this;
            }

            public Builder addLandmark(Landmark.Builder builderForValue) {
                copyOnWrite();
                ((LandmarkList) this.instance).addLandmark((Landmark) builderForValue.build());
                return this;
            }

            public Builder addLandmark(int index, Landmark.Builder builderForValue) {
                copyOnWrite();
                ((LandmarkList) this.instance).addLandmark(index, (Landmark) builderForValue.build());
                return this;
            }

            public Builder addAllLandmark(Iterable<? extends Landmark> values) {
                copyOnWrite();
                ((LandmarkList) this.instance).addAllLandmark(values);
                return this;
            }

            public Builder clearLandmark() {
                copyOnWrite();
                ((LandmarkList) this.instance).clearLandmark();
                return this;
            }

            public Builder removeLandmark(int index) {
                copyOnWrite();
                ((LandmarkList) this.instance).removeLandmark(index);
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
                    return new LandmarkList();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"landmark_", Landmark.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LandmarkList> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LandmarkList.class) {
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
            LandmarkList landmarkList = new LandmarkList();
            DEFAULT_INSTANCE = landmarkList;
            GeneratedMessageLite.registerDefaultInstance(LandmarkList.class, landmarkList);
        }

        public static LandmarkList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LandmarkList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class LandmarkListCollection extends GeneratedMessageLite<LandmarkListCollection, Builder> implements LandmarkListCollectionOrBuilder {
        private static final LandmarkListCollection DEFAULT_INSTANCE;
        public static final int LANDMARK_LIST_FIELD_NUMBER = 1;
        private static volatile Parser<LandmarkListCollection> PARSER;
        private Internal.ProtobufList<LandmarkList> landmarkList_ = emptyProtobufList();

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

        private LandmarkListCollection() {
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListCollectionOrBuilder
        public List<LandmarkList> getLandmarkListList() {
            return this.landmarkList_;
        }

        public List<? extends LandmarkListOrBuilder> getLandmarkListOrBuilderList() {
            return this.landmarkList_;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListCollectionOrBuilder
        public int getLandmarkListCount() {
            return this.landmarkList_.size();
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListCollectionOrBuilder
        public LandmarkList getLandmarkList(int index) {
            return this.landmarkList_.get(index);
        }

        public LandmarkListOrBuilder getLandmarkListOrBuilder(int index) {
            return this.landmarkList_.get(index);
        }

        private void ensureLandmarkListIsMutable() {
            Internal.ProtobufList<LandmarkList> protobufList = this.landmarkList_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.landmarkList_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandmarkList(int index, LandmarkList value) {
            value.getClass();
            ensureLandmarkListIsMutable();
            this.landmarkList_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmarkList(LandmarkList value) {
            value.getClass();
            ensureLandmarkListIsMutable();
            this.landmarkList_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmarkList(int index, LandmarkList value) {
            value.getClass();
            ensureLandmarkListIsMutable();
            this.landmarkList_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLandmarkList(Iterable<? extends LandmarkList> values) {
            ensureLandmarkListIsMutable();
            AbstractMessageLite.addAll(values, this.landmarkList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandmarkList() {
            this.landmarkList_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLandmarkList(int index) {
            ensureLandmarkListIsMutable();
            this.landmarkList_.remove(index);
        }

        public static LandmarkListCollection parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarkListCollection parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarkListCollection parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarkListCollection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarkListCollection parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LandmarkListCollection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LandmarkListCollection parseFrom(InputStream input) throws IOException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarkListCollection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LandmarkListCollection parseDelimitedFrom(InputStream input) throws IOException {
            return (LandmarkListCollection) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarkListCollection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarkListCollection) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LandmarkListCollection parseFrom(CodedInputStream input) throws IOException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LandmarkListCollection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LandmarkListCollection prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LandmarkListCollection, Builder> implements LandmarkListCollectionOrBuilder {
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
                super(LandmarkListCollection.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListCollectionOrBuilder
            public List<LandmarkList> getLandmarkListList() {
                return Collections.unmodifiableList(((LandmarkListCollection) this.instance).getLandmarkListList());
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListCollectionOrBuilder
            public int getLandmarkListCount() {
                return ((LandmarkListCollection) this.instance).getLandmarkListCount();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.LandmarkListCollectionOrBuilder
            public LandmarkList getLandmarkList(int index) {
                return ((LandmarkListCollection) this.instance).getLandmarkList(index);
            }

            public Builder setLandmarkList(int index, LandmarkList value) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).setLandmarkList(index, value);
                return this;
            }

            public Builder setLandmarkList(int index, LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).setLandmarkList(index, (LandmarkList) builderForValue.build());
                return this;
            }

            public Builder addLandmarkList(LandmarkList value) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).addLandmarkList(value);
                return this;
            }

            public Builder addLandmarkList(int index, LandmarkList value) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).addLandmarkList(index, value);
                return this;
            }

            public Builder addLandmarkList(LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).addLandmarkList((LandmarkList) builderForValue.build());
                return this;
            }

            public Builder addLandmarkList(int index, LandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).addLandmarkList(index, (LandmarkList) builderForValue.build());
                return this;
            }

            public Builder addAllLandmarkList(Iterable<? extends LandmarkList> values) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).addAllLandmarkList(values);
                return this;
            }

            public Builder clearLandmarkList() {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).clearLandmarkList();
                return this;
            }

            public Builder removeLandmarkList(int index) {
                copyOnWrite();
                ((LandmarkListCollection) this.instance).removeLandmarkList(index);
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
                    return new LandmarkListCollection();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"landmarkList_", LandmarkList.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LandmarkListCollection> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LandmarkListCollection.class) {
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
            LandmarkListCollection landmarkListCollection = new LandmarkListCollection();
            DEFAULT_INSTANCE = landmarkListCollection;
            GeneratedMessageLite.registerDefaultInstance(LandmarkListCollection.class, landmarkListCollection);
        }

        public static LandmarkListCollection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LandmarkListCollection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class NormalizedLandmark extends GeneratedMessageLite<NormalizedLandmark, Builder> implements NormalizedLandmarkOrBuilder {
        private static final NormalizedLandmark DEFAULT_INSTANCE;
        private static volatile Parser<NormalizedLandmark> PARSER = null;
        public static final int PRESENCE_FIELD_NUMBER = 5;
        public static final int VISIBILITY_FIELD_NUMBER = 4;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        public static final int Z_FIELD_NUMBER = 3;
        private int bitField0_;
        private float presence_;
        private float visibility_;
        private float x_;
        private float y_;
        private float z_;

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

        private NormalizedLandmark() {
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public boolean hasX() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
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

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public boolean hasY() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
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

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public boolean hasZ() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public float getZ() {
            return this.z_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZ(float value) {
            this.bitField0_ |= 4;
            this.z_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZ() {
            this.bitField0_ &= -5;
            this.z_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public boolean hasVisibility() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public float getVisibility() {
            return this.visibility_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVisibility(float value) {
            this.bitField0_ |= 8;
            this.visibility_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVisibility() {
            this.bitField0_ &= -9;
            this.visibility_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public boolean hasPresence() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
        public float getPresence() {
            return this.presence_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresence(float value) {
            this.bitField0_ |= 16;
            this.presence_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresence() {
            this.bitField0_ &= -17;
            this.presence_ = 0.0f;
        }

        public static NormalizedLandmark parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmark parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmark parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmark parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmark parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmark parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmark parseFrom(InputStream input) throws IOException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmark parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedLandmark parseDelimitedFrom(InputStream input) throws IOException {
            return (NormalizedLandmark) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmark parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmark) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedLandmark parseFrom(CodedInputStream input) throws IOException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmark parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmark) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NormalizedLandmark prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<NormalizedLandmark, Builder> implements NormalizedLandmarkOrBuilder {
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
                super(NormalizedLandmark.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public boolean hasX() {
                return ((NormalizedLandmark) this.instance).hasX();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public float getX() {
                return ((NormalizedLandmark) this.instance).getX();
            }

            public Builder setX(float value) {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).setX(value);
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).clearX();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public boolean hasY() {
                return ((NormalizedLandmark) this.instance).hasY();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public float getY() {
                return ((NormalizedLandmark) this.instance).getY();
            }

            public Builder setY(float value) {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).setY(value);
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).clearY();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public boolean hasZ() {
                return ((NormalizedLandmark) this.instance).hasZ();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public float getZ() {
                return ((NormalizedLandmark) this.instance).getZ();
            }

            public Builder setZ(float value) {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).setZ(value);
                return this;
            }

            public Builder clearZ() {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).clearZ();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public boolean hasVisibility() {
                return ((NormalizedLandmark) this.instance).hasVisibility();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public float getVisibility() {
                return ((NormalizedLandmark) this.instance).getVisibility();
            }

            public Builder setVisibility(float value) {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).setVisibility(value);
                return this;
            }

            public Builder clearVisibility() {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).clearVisibility();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public boolean hasPresence() {
                return ((NormalizedLandmark) this.instance).hasPresence();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkOrBuilder
            public float getPresence() {
                return ((NormalizedLandmark) this.instance).getPresence();
            }

            public Builder setPresence(float value) {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).setPresence(value);
                return this;
            }

            public Builder clearPresence() {
                copyOnWrite();
                ((NormalizedLandmark) this.instance).clearPresence();
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
                    return new NormalizedLandmark();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004", new Object[]{"bitField0_", "x_", "y_", "z_", "visibility_", "presence_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<NormalizedLandmark> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (NormalizedLandmark.class) {
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
            NormalizedLandmark normalizedLandmark = new NormalizedLandmark();
            DEFAULT_INSTANCE = normalizedLandmark;
            GeneratedMessageLite.registerDefaultInstance(NormalizedLandmark.class, normalizedLandmark);
        }

        public static NormalizedLandmark getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NormalizedLandmark> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class NormalizedLandmarkList extends GeneratedMessageLite<NormalizedLandmarkList, Builder> implements NormalizedLandmarkListOrBuilder {
        private static final NormalizedLandmarkList DEFAULT_INSTANCE;
        public static final int LANDMARK_FIELD_NUMBER = 1;
        private static volatile Parser<NormalizedLandmarkList> PARSER;
        private Internal.ProtobufList<NormalizedLandmark> landmark_ = emptyProtobufList();

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

        private NormalizedLandmarkList() {
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListOrBuilder
        public List<NormalizedLandmark> getLandmarkList() {
            return this.landmark_;
        }

        public List<? extends NormalizedLandmarkOrBuilder> getLandmarkOrBuilderList() {
            return this.landmark_;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListOrBuilder
        public int getLandmarkCount() {
            return this.landmark_.size();
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListOrBuilder
        public NormalizedLandmark getLandmark(int index) {
            return this.landmark_.get(index);
        }

        public NormalizedLandmarkOrBuilder getLandmarkOrBuilder(int index) {
            return this.landmark_.get(index);
        }

        private void ensureLandmarkIsMutable() {
            Internal.ProtobufList<NormalizedLandmark> protobufList = this.landmark_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.landmark_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandmark(int index, NormalizedLandmark value) {
            value.getClass();
            ensureLandmarkIsMutable();
            this.landmark_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmark(NormalizedLandmark value) {
            value.getClass();
            ensureLandmarkIsMutable();
            this.landmark_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmark(int index, NormalizedLandmark value) {
            value.getClass();
            ensureLandmarkIsMutable();
            this.landmark_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLandmark(Iterable<? extends NormalizedLandmark> values) {
            ensureLandmarkIsMutable();
            AbstractMessageLite.addAll(values, this.landmark_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandmark() {
            this.landmark_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLandmark(int index) {
            ensureLandmarkIsMutable();
            this.landmark_.remove(index);
        }

        public static NormalizedLandmarkList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmarkList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmarkList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmarkList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmarkList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmarkList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmarkList parseFrom(InputStream input) throws IOException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmarkList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedLandmarkList parseDelimitedFrom(InputStream input) throws IOException {
            return (NormalizedLandmarkList) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmarkList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmarkList) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedLandmarkList parseFrom(CodedInputStream input) throws IOException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmarkList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmarkList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NormalizedLandmarkList prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<NormalizedLandmarkList, Builder> implements NormalizedLandmarkListOrBuilder {
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
                super(NormalizedLandmarkList.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListOrBuilder
            public List<NormalizedLandmark> getLandmarkList() {
                return Collections.unmodifiableList(((NormalizedLandmarkList) this.instance).getLandmarkList());
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListOrBuilder
            public int getLandmarkCount() {
                return ((NormalizedLandmarkList) this.instance).getLandmarkCount();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListOrBuilder
            public NormalizedLandmark getLandmark(int index) {
                return ((NormalizedLandmarkList) this.instance).getLandmark(index);
            }

            public Builder setLandmark(int index, NormalizedLandmark value) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).setLandmark(index, value);
                return this;
            }

            public Builder setLandmark(int index, NormalizedLandmark.Builder builderForValue) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).setLandmark(index, (NormalizedLandmark) builderForValue.build());
                return this;
            }

            public Builder addLandmark(NormalizedLandmark value) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).addLandmark(value);
                return this;
            }

            public Builder addLandmark(int index, NormalizedLandmark value) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).addLandmark(index, value);
                return this;
            }

            public Builder addLandmark(NormalizedLandmark.Builder builderForValue) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).addLandmark((NormalizedLandmark) builderForValue.build());
                return this;
            }

            public Builder addLandmark(int index, NormalizedLandmark.Builder builderForValue) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).addLandmark(index, (NormalizedLandmark) builderForValue.build());
                return this;
            }

            public Builder addAllLandmark(Iterable<? extends NormalizedLandmark> values) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).addAllLandmark(values);
                return this;
            }

            public Builder clearLandmark() {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).clearLandmark();
                return this;
            }

            public Builder removeLandmark(int index) {
                copyOnWrite();
                ((NormalizedLandmarkList) this.instance).removeLandmark(index);
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
                    return new NormalizedLandmarkList();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"landmark_", NormalizedLandmark.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<NormalizedLandmarkList> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (NormalizedLandmarkList.class) {
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
            NormalizedLandmarkList normalizedLandmarkList = new NormalizedLandmarkList();
            DEFAULT_INSTANCE = normalizedLandmarkList;
            GeneratedMessageLite.registerDefaultInstance(NormalizedLandmarkList.class, normalizedLandmarkList);
        }

        public static NormalizedLandmarkList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NormalizedLandmarkList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class NormalizedLandmarkListCollection extends GeneratedMessageLite<NormalizedLandmarkListCollection, Builder> implements NormalizedLandmarkListCollectionOrBuilder {
        private static final NormalizedLandmarkListCollection DEFAULT_INSTANCE;
        public static final int LANDMARK_LIST_FIELD_NUMBER = 1;
        private static volatile Parser<NormalizedLandmarkListCollection> PARSER;
        private Internal.ProtobufList<NormalizedLandmarkList> landmarkList_ = emptyProtobufList();

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

        private NormalizedLandmarkListCollection() {
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListCollectionOrBuilder
        public List<NormalizedLandmarkList> getLandmarkListList() {
            return this.landmarkList_;
        }

        public List<? extends NormalizedLandmarkListOrBuilder> getLandmarkListOrBuilderList() {
            return this.landmarkList_;
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListCollectionOrBuilder
        public int getLandmarkListCount() {
            return this.landmarkList_.size();
        }

        @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListCollectionOrBuilder
        public NormalizedLandmarkList getLandmarkList(int index) {
            return this.landmarkList_.get(index);
        }

        public NormalizedLandmarkListOrBuilder getLandmarkListOrBuilder(int index) {
            return this.landmarkList_.get(index);
        }

        private void ensureLandmarkListIsMutable() {
            Internal.ProtobufList<NormalizedLandmarkList> protobufList = this.landmarkList_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.landmarkList_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLandmarkList(int index, NormalizedLandmarkList value) {
            value.getClass();
            ensureLandmarkListIsMutable();
            this.landmarkList_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmarkList(NormalizedLandmarkList value) {
            value.getClass();
            ensureLandmarkListIsMutable();
            this.landmarkList_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLandmarkList(int index, NormalizedLandmarkList value) {
            value.getClass();
            ensureLandmarkListIsMutable();
            this.landmarkList_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLandmarkList(Iterable<? extends NormalizedLandmarkList> values) {
            ensureLandmarkListIsMutable();
            AbstractMessageLite.addAll(values, this.landmarkList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLandmarkList() {
            this.landmarkList_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLandmarkList(int index) {
            ensureLandmarkListIsMutable();
            this.landmarkList_.remove(index);
        }

        public static NormalizedLandmarkListCollection parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmarkListCollection parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmarkListCollection parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmarkListCollection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmarkListCollection parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static NormalizedLandmarkListCollection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static NormalizedLandmarkListCollection parseFrom(InputStream input) throws IOException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmarkListCollection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedLandmarkListCollection parseDelimitedFrom(InputStream input) throws IOException {
            return (NormalizedLandmarkListCollection) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmarkListCollection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmarkListCollection) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static NormalizedLandmarkListCollection parseFrom(CodedInputStream input) throws IOException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static NormalizedLandmarkListCollection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NormalizedLandmarkListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(NormalizedLandmarkListCollection prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<NormalizedLandmarkListCollection, Builder> implements NormalizedLandmarkListCollectionOrBuilder {
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
                super(NormalizedLandmarkListCollection.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListCollectionOrBuilder
            public List<NormalizedLandmarkList> getLandmarkListList() {
                return Collections.unmodifiableList(((NormalizedLandmarkListCollection) this.instance).getLandmarkListList());
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListCollectionOrBuilder
            public int getLandmarkListCount() {
                return ((NormalizedLandmarkListCollection) this.instance).getLandmarkListCount();
            }

            @Override // com.google.mediapipe.formats.proto.LandmarkProto.NormalizedLandmarkListCollectionOrBuilder
            public NormalizedLandmarkList getLandmarkList(int index) {
                return ((NormalizedLandmarkListCollection) this.instance).getLandmarkList(index);
            }

            public Builder setLandmarkList(int index, NormalizedLandmarkList value) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).setLandmarkList(index, value);
                return this;
            }

            public Builder setLandmarkList(int index, NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).setLandmarkList(index, (NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder addLandmarkList(NormalizedLandmarkList value) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).addLandmarkList(value);
                return this;
            }

            public Builder addLandmarkList(int index, NormalizedLandmarkList value) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).addLandmarkList(index, value);
                return this;
            }

            public Builder addLandmarkList(NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).addLandmarkList((NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder addLandmarkList(int index, NormalizedLandmarkList.Builder builderForValue) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).addLandmarkList(index, (NormalizedLandmarkList) builderForValue.build());
                return this;
            }

            public Builder addAllLandmarkList(Iterable<? extends NormalizedLandmarkList> values) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).addAllLandmarkList(values);
                return this;
            }

            public Builder clearLandmarkList() {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).clearLandmarkList();
                return this;
            }

            public Builder removeLandmarkList(int index) {
                copyOnWrite();
                ((NormalizedLandmarkListCollection) this.instance).removeLandmarkList(index);
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
                    return new NormalizedLandmarkListCollection();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"landmarkList_", NormalizedLandmarkList.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<NormalizedLandmarkListCollection> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (NormalizedLandmarkListCollection.class) {
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
            NormalizedLandmarkListCollection normalizedLandmarkListCollection = new NormalizedLandmarkListCollection();
            DEFAULT_INSTANCE = normalizedLandmarkListCollection;
            GeneratedMessageLite.registerDefaultInstance(NormalizedLandmarkListCollection.class, normalizedLandmarkListCollection);
        }

        public static NormalizedLandmarkListCollection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NormalizedLandmarkListCollection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
