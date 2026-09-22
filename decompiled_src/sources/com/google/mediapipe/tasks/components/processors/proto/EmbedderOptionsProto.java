package com.google.mediapipe.tasks.components.processors.proto;

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
public final class EmbedderOptionsProto {

    public interface EmbedderOptionsOrBuilder extends MessageLiteOrBuilder {
        boolean getL2Normalize();

        boolean getQuantize();

        boolean hasL2Normalize();

        boolean hasQuantize();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private EmbedderOptionsProto() {
    }

    public static final class EmbedderOptions extends GeneratedMessageLite<EmbedderOptions, Builder> implements EmbedderOptionsOrBuilder {
        private static final EmbedderOptions DEFAULT_INSTANCE;
        public static final int L2_NORMALIZE_FIELD_NUMBER = 1;
        private static volatile Parser<EmbedderOptions> PARSER = null;
        public static final int QUANTIZE_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean l2Normalize_;
        private boolean quantize_;

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

        private EmbedderOptions() {
        }

        @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
        public boolean hasL2Normalize() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
        public boolean getL2Normalize() {
            return this.l2Normalize_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setL2Normalize(boolean value) {
            this.bitField0_ |= 1;
            this.l2Normalize_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearL2Normalize() {
            this.bitField0_ &= -2;
            this.l2Normalize_ = false;
        }

        @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
        public boolean hasQuantize() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
        public boolean getQuantize() {
            return this.quantize_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQuantize(boolean value) {
            this.bitField0_ |= 2;
            this.quantize_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQuantize() {
            this.bitField0_ &= -3;
            this.quantize_ = false;
        }

        public static EmbedderOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EmbedderOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EmbedderOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EmbedderOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EmbedderOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EmbedderOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EmbedderOptions parseFrom(InputStream input) throws IOException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EmbedderOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EmbedderOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (EmbedderOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static EmbedderOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EmbedderOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EmbedderOptions parseFrom(CodedInputStream input) throws IOException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EmbedderOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EmbedderOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EmbedderOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EmbedderOptions, Builder> implements EmbedderOptionsOrBuilder {
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
                super(EmbedderOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
            public boolean hasL2Normalize() {
                return ((EmbedderOptions) this.instance).hasL2Normalize();
            }

            @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
            public boolean getL2Normalize() {
                return ((EmbedderOptions) this.instance).getL2Normalize();
            }

            public Builder setL2Normalize(boolean value) {
                copyOnWrite();
                ((EmbedderOptions) this.instance).setL2Normalize(value);
                return this;
            }

            public Builder clearL2Normalize() {
                copyOnWrite();
                ((EmbedderOptions) this.instance).clearL2Normalize();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
            public boolean hasQuantize() {
                return ((EmbedderOptions) this.instance).hasQuantize();
            }

            @Override // com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto.EmbedderOptionsOrBuilder
            public boolean getQuantize() {
                return ((EmbedderOptions) this.instance).getQuantize();
            }

            public Builder setQuantize(boolean value) {
                copyOnWrite();
                ((EmbedderOptions) this.instance).setQuantize(value);
                return this;
            }

            public Builder clearQuantize() {
                copyOnWrite();
                ((EmbedderOptions) this.instance).clearQuantize();
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
                    return new EmbedderOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"bitField0_", "l2Normalize_", "quantize_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EmbedderOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EmbedderOptions.class) {
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
            EmbedderOptions embedderOptions = new EmbedderOptions();
            DEFAULT_INSTANCE = embedderOptions;
            GeneratedMessageLite.registerDefaultInstance(EmbedderOptions.class, embedderOptions);
        }

        public static EmbedderOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EmbedderOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.components.processors.proto.EmbedderOptionsProto$1, reason: invalid class name */
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
