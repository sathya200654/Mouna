package com.google.mediapipe.tasks.vision.facegeometry.proto;

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
public final class Mesh3DProto {

    public interface Mesh3dOrBuilder extends MessageLiteOrBuilder {
        int getIndexBuffer(int index);

        int getIndexBufferCount();

        List<Integer> getIndexBufferList();

        Mesh3d.PrimitiveType getPrimitiveType();

        float getVertexBuffer(int index);

        int getVertexBufferCount();

        List<Float> getVertexBufferList();

        Mesh3d.VertexType getVertexType();

        boolean hasPrimitiveType();

        boolean hasVertexType();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private Mesh3DProto() {
    }

    public static final class Mesh3d extends GeneratedMessageLite<Mesh3d, Builder> implements Mesh3dOrBuilder {
        private static final Mesh3d DEFAULT_INSTANCE;
        public static final int INDEX_BUFFER_FIELD_NUMBER = 4;
        private static volatile Parser<Mesh3d> PARSER = null;
        public static final int PRIMITIVE_TYPE_FIELD_NUMBER = 2;
        public static final int VERTEX_BUFFER_FIELD_NUMBER = 3;
        public static final int VERTEX_TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private int primitiveType_;
        private int vertexType_;
        private Internal.FloatList vertexBuffer_ = emptyFloatList();
        private Internal.IntList indexBuffer_ = emptyIntList();

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

        private Mesh3d() {
        }

        public enum VertexType implements Internal.EnumLite {
            VERTEX_PT(0);

            public static final int VERTEX_PT_VALUE = 0;
            private static final Internal.EnumLiteMap<VertexType> internalValueMap = new Internal.EnumLiteMap<VertexType>() { // from class: com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3d.VertexType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public VertexType findValueByNumber(int number) {
                    return VertexType.forNumber(number);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static VertexType valueOf(int value) {
                return forNumber(value);
            }

            public static VertexType forNumber(int value) {
                if (value != 0) {
                    return null;
                }
                return VERTEX_PT;
            }

            public static Internal.EnumLiteMap<VertexType> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return VertexTypeVerifier.INSTANCE;
            }

            private static final class VertexTypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new VertexTypeVerifier();

                private VertexTypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return VertexType.forNumber(number) != null;
                }
            }

            VertexType(int value) {
                this.value = value;
            }
        }

        public enum PrimitiveType implements Internal.EnumLite {
            TRIANGLE(0);

            public static final int TRIANGLE_VALUE = 0;
            private static final Internal.EnumLiteMap<PrimitiveType> internalValueMap = new Internal.EnumLiteMap<PrimitiveType>() { // from class: com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3d.PrimitiveType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public PrimitiveType findValueByNumber(int number) {
                    return PrimitiveType.forNumber(number);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static PrimitiveType valueOf(int value) {
                return forNumber(value);
            }

            public static PrimitiveType forNumber(int value) {
                if (value != 0) {
                    return null;
                }
                return TRIANGLE;
            }

            public static Internal.EnumLiteMap<PrimitiveType> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return PrimitiveTypeVerifier.INSTANCE;
            }

            private static final class PrimitiveTypeVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new PrimitiveTypeVerifier();

                private PrimitiveTypeVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return PrimitiveType.forNumber(number) != null;
                }
            }

            PrimitiveType(int value) {
                this.value = value;
            }
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public boolean hasVertexType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public VertexType getVertexType() {
            VertexType vertexTypeForNumber = VertexType.forNumber(this.vertexType_);
            return vertexTypeForNumber == null ? VertexType.VERTEX_PT : vertexTypeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVertexType(VertexType value) {
            this.vertexType_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVertexType() {
            this.bitField0_ &= -2;
            this.vertexType_ = 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public boolean hasPrimitiveType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public PrimitiveType getPrimitiveType() {
            PrimitiveType primitiveTypeForNumber = PrimitiveType.forNumber(this.primitiveType_);
            return primitiveTypeForNumber == null ? PrimitiveType.TRIANGLE : primitiveTypeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrimitiveType(PrimitiveType value) {
            this.primitiveType_ = value.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrimitiveType() {
            this.bitField0_ &= -3;
            this.primitiveType_ = 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public List<Float> getVertexBufferList() {
            return this.vertexBuffer_;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public int getVertexBufferCount() {
            return this.vertexBuffer_.size();
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public float getVertexBuffer(int index) {
            return this.vertexBuffer_.getFloat(index);
        }

        private void ensureVertexBufferIsMutable() {
            Internal.FloatList floatList = this.vertexBuffer_;
            if (floatList.isModifiable()) {
                return;
            }
            this.vertexBuffer_ = GeneratedMessageLite.mutableCopy(floatList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVertexBuffer(int index, float value) {
            ensureVertexBufferIsMutable();
            this.vertexBuffer_.setFloat(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVertexBuffer(float value) {
            ensureVertexBufferIsMutable();
            this.vertexBuffer_.addFloat(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllVertexBuffer(Iterable<? extends Float> values) {
            ensureVertexBufferIsMutable();
            AbstractMessageLite.addAll(values, this.vertexBuffer_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVertexBuffer() {
            this.vertexBuffer_ = emptyFloatList();
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public List<Integer> getIndexBufferList() {
            return this.indexBuffer_;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public int getIndexBufferCount() {
            return this.indexBuffer_.size();
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
        public int getIndexBuffer(int index) {
            return this.indexBuffer_.getInt(index);
        }

        private void ensureIndexBufferIsMutable() {
            Internal.IntList intList = this.indexBuffer_;
            if (intList.isModifiable()) {
                return;
            }
            this.indexBuffer_ = GeneratedMessageLite.mutableCopy(intList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndexBuffer(int index, int value) {
            ensureIndexBufferIsMutable();
            this.indexBuffer_.setInt(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIndexBuffer(int value) {
            ensureIndexBufferIsMutable();
            this.indexBuffer_.addInt(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllIndexBuffer(Iterable<? extends Integer> values) {
            ensureIndexBufferIsMutable();
            AbstractMessageLite.addAll(values, this.indexBuffer_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndexBuffer() {
            this.indexBuffer_ = emptyIntList();
        }

        public static Mesh3d parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Mesh3d parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Mesh3d parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Mesh3d parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Mesh3d parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Mesh3d parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Mesh3d parseFrom(InputStream input) throws IOException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Mesh3d parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Mesh3d parseDelimitedFrom(InputStream input) throws IOException {
            return (Mesh3d) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Mesh3d parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mesh3d) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Mesh3d parseFrom(CodedInputStream input) throws IOException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Mesh3d parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Mesh3d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Mesh3d prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Mesh3d, Builder> implements Mesh3dOrBuilder {
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
                super(Mesh3d.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public boolean hasVertexType() {
                return ((Mesh3d) this.instance).hasVertexType();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public VertexType getVertexType() {
                return ((Mesh3d) this.instance).getVertexType();
            }

            public Builder setVertexType(VertexType value) {
                copyOnWrite();
                ((Mesh3d) this.instance).setVertexType(value);
                return this;
            }

            public Builder clearVertexType() {
                copyOnWrite();
                ((Mesh3d) this.instance).clearVertexType();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public boolean hasPrimitiveType() {
                return ((Mesh3d) this.instance).hasPrimitiveType();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public PrimitiveType getPrimitiveType() {
                return ((Mesh3d) this.instance).getPrimitiveType();
            }

            public Builder setPrimitiveType(PrimitiveType value) {
                copyOnWrite();
                ((Mesh3d) this.instance).setPrimitiveType(value);
                return this;
            }

            public Builder clearPrimitiveType() {
                copyOnWrite();
                ((Mesh3d) this.instance).clearPrimitiveType();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public List<Float> getVertexBufferList() {
                return Collections.unmodifiableList(((Mesh3d) this.instance).getVertexBufferList());
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public int getVertexBufferCount() {
                return ((Mesh3d) this.instance).getVertexBufferCount();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public float getVertexBuffer(int index) {
                return ((Mesh3d) this.instance).getVertexBuffer(index);
            }

            public Builder setVertexBuffer(int index, float value) {
                copyOnWrite();
                ((Mesh3d) this.instance).setVertexBuffer(index, value);
                return this;
            }

            public Builder addVertexBuffer(float value) {
                copyOnWrite();
                ((Mesh3d) this.instance).addVertexBuffer(value);
                return this;
            }

            public Builder addAllVertexBuffer(Iterable<? extends Float> values) {
                copyOnWrite();
                ((Mesh3d) this.instance).addAllVertexBuffer(values);
                return this;
            }

            public Builder clearVertexBuffer() {
                copyOnWrite();
                ((Mesh3d) this.instance).clearVertexBuffer();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public List<Integer> getIndexBufferList() {
                return Collections.unmodifiableList(((Mesh3d) this.instance).getIndexBufferList());
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public int getIndexBufferCount() {
                return ((Mesh3d) this.instance).getIndexBufferCount();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto.Mesh3dOrBuilder
            public int getIndexBuffer(int index) {
                return ((Mesh3d) this.instance).getIndexBuffer(index);
            }

            public Builder setIndexBuffer(int index, int value) {
                copyOnWrite();
                ((Mesh3d) this.instance).setIndexBuffer(index, value);
                return this;
            }

            public Builder addIndexBuffer(int value) {
                copyOnWrite();
                ((Mesh3d) this.instance).addIndexBuffer(value);
                return this;
            }

            public Builder addAllIndexBuffer(Iterable<? extends Integer> values) {
                copyOnWrite();
                ((Mesh3d) this.instance).addAllIndexBuffer(values);
                return this;
            }

            public Builder clearIndexBuffer() {
                copyOnWrite();
                ((Mesh3d) this.instance).clearIndexBuffer();
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
                    return new Mesh3d();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003\u0013\u0004\u001d", new Object[]{"bitField0_", "vertexType_", VertexType.internalGetVerifier(), "primitiveType_", PrimitiveType.internalGetVerifier(), "vertexBuffer_", "indexBuffer_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Mesh3d> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Mesh3d.class) {
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
            Mesh3d mesh3d = new Mesh3d();
            DEFAULT_INSTANCE = mesh3d;
            GeneratedMessageLite.registerDefaultInstance(Mesh3d.class, mesh3d);
        }

        public static Mesh3d getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Mesh3d> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facegeometry.proto.Mesh3DProto$1, reason: invalid class name */
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
