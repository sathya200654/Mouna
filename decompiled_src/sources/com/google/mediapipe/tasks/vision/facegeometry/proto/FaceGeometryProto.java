package com.google.mediapipe.tasks.vision.facegeometry.proto;

import com.google.mediapipe.formats.proto.MatrixDataProto;
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
public final class FaceGeometryProto {

    public interface FaceGeometryOrBuilder extends MessageLiteOrBuilder {
        Mesh3DProto.Mesh3d getMesh();

        MatrixDataProto.MatrixData getPoseTransformMatrix();

        boolean hasMesh();

        boolean hasPoseTransformMatrix();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private FaceGeometryProto() {
    }

    public static final class FaceGeometry extends GeneratedMessageLite<FaceGeometry, Builder> implements FaceGeometryOrBuilder {
        private static final FaceGeometry DEFAULT_INSTANCE;
        public static final int MESH_FIELD_NUMBER = 1;
        private static volatile Parser<FaceGeometry> PARSER = null;
        public static final int POSE_TRANSFORM_MATRIX_FIELD_NUMBER = 2;
        private int bitField0_;
        private Mesh3DProto.Mesh3d mesh_;
        private MatrixDataProto.MatrixData poseTransformMatrix_;

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

        private FaceGeometry() {
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
        public boolean hasMesh() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
        public Mesh3DProto.Mesh3d getMesh() {
            Mesh3DProto.Mesh3d mesh3d = this.mesh_;
            return mesh3d == null ? Mesh3DProto.Mesh3d.getDefaultInstance() : mesh3d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMesh(Mesh3DProto.Mesh3d value) {
            value.getClass();
            this.mesh_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMesh(Mesh3DProto.Mesh3d value) {
            value.getClass();
            Mesh3DProto.Mesh3d mesh3d = this.mesh_;
            if (mesh3d != null && mesh3d != Mesh3DProto.Mesh3d.getDefaultInstance()) {
                this.mesh_ = (Mesh3DProto.Mesh3d) Mesh3DProto.Mesh3d.newBuilder(this.mesh_).mergeFrom(value).buildPartial();
            } else {
                this.mesh_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMesh() {
            this.mesh_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
        public boolean hasPoseTransformMatrix() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
        public MatrixDataProto.MatrixData getPoseTransformMatrix() {
            MatrixDataProto.MatrixData matrixData = this.poseTransformMatrix_;
            return matrixData == null ? MatrixDataProto.MatrixData.getDefaultInstance() : matrixData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPoseTransformMatrix(MatrixDataProto.MatrixData value) {
            value.getClass();
            this.poseTransformMatrix_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergePoseTransformMatrix(MatrixDataProto.MatrixData value) {
            value.getClass();
            MatrixDataProto.MatrixData matrixData = this.poseTransformMatrix_;
            if (matrixData != null && matrixData != MatrixDataProto.MatrixData.getDefaultInstance()) {
                this.poseTransformMatrix_ = (MatrixDataProto.MatrixData) MatrixDataProto.MatrixData.newBuilder(this.poseTransformMatrix_).mergeFrom(value).buildPartial();
            } else {
                this.poseTransformMatrix_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPoseTransformMatrix() {
            this.poseTransformMatrix_ = null;
            this.bitField0_ &= -3;
        }

        public static FaceGeometry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FaceGeometry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FaceGeometry parseFrom(InputStream input) throws IOException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceGeometry parseDelimitedFrom(InputStream input) throws IOException {
            return (FaceGeometry) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometry) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FaceGeometry parseFrom(CodedInputStream input) throws IOException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FaceGeometry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FaceGeometry) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FaceGeometry prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FaceGeometry, Builder> implements FaceGeometryOrBuilder {
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
                super(FaceGeometry.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
            public boolean hasMesh() {
                return ((FaceGeometry) this.instance).hasMesh();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
            public Mesh3DProto.Mesh3d getMesh() {
                return ((FaceGeometry) this.instance).getMesh();
            }

            public Builder setMesh(Mesh3DProto.Mesh3d value) {
                copyOnWrite();
                ((FaceGeometry) this.instance).setMesh(value);
                return this;
            }

            public Builder setMesh(Mesh3DProto.Mesh3d.Builder builderForValue) {
                copyOnWrite();
                ((FaceGeometry) this.instance).setMesh((Mesh3DProto.Mesh3d) builderForValue.build());
                return this;
            }

            public Builder mergeMesh(Mesh3DProto.Mesh3d value) {
                copyOnWrite();
                ((FaceGeometry) this.instance).mergeMesh(value);
                return this;
            }

            public Builder clearMesh() {
                copyOnWrite();
                ((FaceGeometry) this.instance).clearMesh();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
            public boolean hasPoseTransformMatrix() {
                return ((FaceGeometry) this.instance).hasPoseTransformMatrix();
            }

            @Override // com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto.FaceGeometryOrBuilder
            public MatrixDataProto.MatrixData getPoseTransformMatrix() {
                return ((FaceGeometry) this.instance).getPoseTransformMatrix();
            }

            public Builder setPoseTransformMatrix(MatrixDataProto.MatrixData value) {
                copyOnWrite();
                ((FaceGeometry) this.instance).setPoseTransformMatrix(value);
                return this;
            }

            public Builder setPoseTransformMatrix(MatrixDataProto.MatrixData.Builder builderForValue) {
                copyOnWrite();
                ((FaceGeometry) this.instance).setPoseTransformMatrix((MatrixDataProto.MatrixData) builderForValue.build());
                return this;
            }

            public Builder mergePoseTransformMatrix(MatrixDataProto.MatrixData value) {
                copyOnWrite();
                ((FaceGeometry) this.instance).mergePoseTransformMatrix(value);
                return this;
            }

            public Builder clearPoseTransformMatrix() {
                copyOnWrite();
                ((FaceGeometry) this.instance).clearPoseTransformMatrix();
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
                    return new FaceGeometry();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "mesh_", "poseTransformMatrix_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FaceGeometry> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FaceGeometry.class) {
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
            FaceGeometry faceGeometry = new FaceGeometry();
            DEFAULT_INSTANCE = faceGeometry;
            GeneratedMessageLite.registerDefaultInstance(FaceGeometry.class, faceGeometry);
        }

        public static FaceGeometry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FaceGeometry> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.facegeometry.proto.FaceGeometryProto$1, reason: invalid class name */
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
