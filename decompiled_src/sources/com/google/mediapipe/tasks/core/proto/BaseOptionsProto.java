package com.google.mediapipe.tasks.core.proto;

import com.google.mediapipe.gpu.GpuOriginProto;
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
public final class BaseOptionsProto {

    public interface BaseOptionsOrBuilder extends MessageLiteOrBuilder {
        AccelerationProto.Acceleration getAcceleration();

        GpuOriginProto.GpuOrigin.Mode getGpuOrigin();

        ExternalFileProto.ExternalFile getModelAsset();

        boolean getUseStreamMode();

        boolean hasAcceleration();

        boolean hasGpuOrigin();

        boolean hasModelAsset();

        boolean hasUseStreamMode();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private BaseOptionsProto() {
    }

    public static final class BaseOptions extends GeneratedMessageLite<BaseOptions, Builder> implements BaseOptionsOrBuilder {
        public static final int ACCELERATION_FIELD_NUMBER = 3;
        private static final BaseOptions DEFAULT_INSTANCE;
        public static final int GPU_ORIGIN_FIELD_NUMBER = 4;
        public static final int MODEL_ASSET_FIELD_NUMBER = 1;
        private static volatile Parser<BaseOptions> PARSER = null;
        public static final int USE_STREAM_MODE_FIELD_NUMBER = 2;
        private AccelerationProto.Acceleration acceleration_;
        private int bitField0_;
        private int gpuOrigin_ = 2;
        private ExternalFileProto.ExternalFile modelAsset_;
        private boolean useStreamMode_;

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

        private BaseOptions() {
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public boolean hasModelAsset() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public ExternalFileProto.ExternalFile getModelAsset() {
            ExternalFileProto.ExternalFile externalFile = this.modelAsset_;
            return externalFile == null ? ExternalFileProto.ExternalFile.getDefaultInstance() : externalFile;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModelAsset(ExternalFileProto.ExternalFile value) {
            value.getClass();
            this.modelAsset_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeModelAsset(ExternalFileProto.ExternalFile value) {
            value.getClass();
            ExternalFileProto.ExternalFile externalFile = this.modelAsset_;
            if (externalFile != null && externalFile != ExternalFileProto.ExternalFile.getDefaultInstance()) {
                this.modelAsset_ = (ExternalFileProto.ExternalFile) ExternalFileProto.ExternalFile.newBuilder(this.modelAsset_).mergeFrom(value).buildPartial();
            } else {
                this.modelAsset_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearModelAsset() {
            this.modelAsset_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public boolean hasUseStreamMode() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public boolean getUseStreamMode() {
            return this.useStreamMode_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUseStreamMode(boolean value) {
            this.bitField0_ |= 2;
            this.useStreamMode_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUseStreamMode() {
            this.bitField0_ &= -3;
            this.useStreamMode_ = false;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public boolean hasAcceleration() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public AccelerationProto.Acceleration getAcceleration() {
            AccelerationProto.Acceleration acceleration = this.acceleration_;
            return acceleration == null ? AccelerationProto.Acceleration.getDefaultInstance() : acceleration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAcceleration(AccelerationProto.Acceleration value) {
            value.getClass();
            this.acceleration_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAcceleration(AccelerationProto.Acceleration value) {
            value.getClass();
            AccelerationProto.Acceleration acceleration = this.acceleration_;
            if (acceleration != null && acceleration != AccelerationProto.Acceleration.getDefaultInstance()) {
                this.acceleration_ = (AccelerationProto.Acceleration) AccelerationProto.Acceleration.newBuilder(this.acceleration_).mergeFrom(value).buildPartial();
            } else {
                this.acceleration_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAcceleration() {
            this.acceleration_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public boolean hasGpuOrigin() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
        public GpuOriginProto.GpuOrigin.Mode getGpuOrigin() {
            GpuOriginProto.GpuOrigin.Mode modeForNumber = GpuOriginProto.GpuOrigin.Mode.forNumber(this.gpuOrigin_);
            return modeForNumber == null ? GpuOriginProto.GpuOrigin.Mode.TOP_LEFT : modeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGpuOrigin(GpuOriginProto.GpuOrigin.Mode value) {
            this.gpuOrigin_ = value.getNumber();
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGpuOrigin() {
            this.bitField0_ &= -9;
            this.gpuOrigin_ = 2;
        }

        public static BaseOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BaseOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BaseOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BaseOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BaseOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static BaseOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static BaseOptions parseFrom(InputStream input) throws IOException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static BaseOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static BaseOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (BaseOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static BaseOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BaseOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static BaseOptions parseFrom(CodedInputStream input) throws IOException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static BaseOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BaseOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(BaseOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<BaseOptions, Builder> implements BaseOptionsOrBuilder {
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
                super(BaseOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public boolean hasModelAsset() {
                return ((BaseOptions) this.instance).hasModelAsset();
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public ExternalFileProto.ExternalFile getModelAsset() {
                return ((BaseOptions) this.instance).getModelAsset();
            }

            public Builder setModelAsset(ExternalFileProto.ExternalFile value) {
                copyOnWrite();
                ((BaseOptions) this.instance).setModelAsset(value);
                return this;
            }

            public Builder setModelAsset(ExternalFileProto.ExternalFile.Builder builderForValue) {
                copyOnWrite();
                ((BaseOptions) this.instance).setModelAsset((ExternalFileProto.ExternalFile) builderForValue.build());
                return this;
            }

            public Builder mergeModelAsset(ExternalFileProto.ExternalFile value) {
                copyOnWrite();
                ((BaseOptions) this.instance).mergeModelAsset(value);
                return this;
            }

            public Builder clearModelAsset() {
                copyOnWrite();
                ((BaseOptions) this.instance).clearModelAsset();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public boolean hasUseStreamMode() {
                return ((BaseOptions) this.instance).hasUseStreamMode();
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public boolean getUseStreamMode() {
                return ((BaseOptions) this.instance).getUseStreamMode();
            }

            public Builder setUseStreamMode(boolean value) {
                copyOnWrite();
                ((BaseOptions) this.instance).setUseStreamMode(value);
                return this;
            }

            public Builder clearUseStreamMode() {
                copyOnWrite();
                ((BaseOptions) this.instance).clearUseStreamMode();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public boolean hasAcceleration() {
                return ((BaseOptions) this.instance).hasAcceleration();
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public AccelerationProto.Acceleration getAcceleration() {
                return ((BaseOptions) this.instance).getAcceleration();
            }

            public Builder setAcceleration(AccelerationProto.Acceleration value) {
                copyOnWrite();
                ((BaseOptions) this.instance).setAcceleration(value);
                return this;
            }

            public Builder setAcceleration(AccelerationProto.Acceleration.Builder builderForValue) {
                copyOnWrite();
                ((BaseOptions) this.instance).setAcceleration((AccelerationProto.Acceleration) builderForValue.build());
                return this;
            }

            public Builder mergeAcceleration(AccelerationProto.Acceleration value) {
                copyOnWrite();
                ((BaseOptions) this.instance).mergeAcceleration(value);
                return this;
            }

            public Builder clearAcceleration() {
                copyOnWrite();
                ((BaseOptions) this.instance).clearAcceleration();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public boolean hasGpuOrigin() {
                return ((BaseOptions) this.instance).hasGpuOrigin();
            }

            @Override // com.google.mediapipe.tasks.core.proto.BaseOptionsProto.BaseOptionsOrBuilder
            public GpuOriginProto.GpuOrigin.Mode getGpuOrigin() {
                return ((BaseOptions) this.instance).getGpuOrigin();
            }

            public Builder setGpuOrigin(GpuOriginProto.GpuOrigin.Mode value) {
                copyOnWrite();
                ((BaseOptions) this.instance).setGpuOrigin(value);
                return this;
            }

            public Builder clearGpuOrigin() {
                copyOnWrite();
                ((BaseOptions) this.instance).clearGpuOrigin();
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
                    return new BaseOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004᠌\u0003", new Object[]{"bitField0_", "modelAsset_", "useStreamMode_", "acceleration_", "gpuOrigin_", GpuOriginProto.GpuOrigin.Mode.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<BaseOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (BaseOptions.class) {
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
            BaseOptions baseOptions = new BaseOptions();
            DEFAULT_INSTANCE = baseOptions;
            GeneratedMessageLite.registerDefaultInstance(BaseOptions.class, baseOptions);
        }

        public static BaseOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BaseOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.core.proto.BaseOptionsProto$1, reason: invalid class name */
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
