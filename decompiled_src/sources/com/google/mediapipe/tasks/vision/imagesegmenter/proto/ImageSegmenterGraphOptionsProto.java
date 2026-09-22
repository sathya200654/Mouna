package com.google.mediapipe.tasks.vision.imagesegmenter.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ImageSegmenterGraphOptionsProto {

    public interface ImageSegmenterGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        String getDisplayNamesLocale();

        ByteString getDisplayNamesLocaleBytes();

        SegmenterOptionsProto.SegmenterOptions getSegmenterOptions();

        boolean hasBaseOptions();

        boolean hasDisplayNamesLocale();

        boolean hasSegmenterOptions();
    }

    private ImageSegmenterGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) ImageSegmenterGraphOptions.ext);
    }

    public static final class ImageSegmenterGraphOptions extends GeneratedMessageLite<ImageSegmenterGraphOptions, Builder> implements ImageSegmenterGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        private static final ImageSegmenterGraphOptions DEFAULT_INSTANCE;
        public static final int DISPLAY_NAMES_LOCALE_FIELD_NUMBER = 2;
        public static final int EXT_FIELD_NUMBER = 458105758;
        private static volatile Parser<ImageSegmenterGraphOptions> PARSER = null;
        public static final int SEGMENTER_OPTIONS_FIELD_NUMBER = 3;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, ImageSegmenterGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private String displayNamesLocale_ = "en";
        private SegmenterOptionsProto.SegmenterOptions segmenterOptions_;

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

        private ImageSegmenterGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public BaseOptionsProto.BaseOptions getBaseOptions() {
            BaseOptionsProto.BaseOptions baseOptions = this.baseOptions_;
            return baseOptions == null ? BaseOptionsProto.BaseOptions.getDefaultInstance() : baseOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBaseOptions(BaseOptionsProto.BaseOptions value) {
            value.getClass();
            this.baseOptions_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
            value.getClass();
            BaseOptionsProto.BaseOptions baseOptions = this.baseOptions_;
            if (baseOptions != null && baseOptions != BaseOptionsProto.BaseOptions.getDefaultInstance()) {
                this.baseOptions_ = (BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder(this.baseOptions_).mergeFrom(value).buildPartial();
            } else {
                this.baseOptions_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBaseOptions() {
            this.baseOptions_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public boolean hasDisplayNamesLocale() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public String getDisplayNamesLocale() {
            return this.displayNamesLocale_;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public ByteString getDisplayNamesLocaleBytes() {
            return ByteString.copyFromUtf8(this.displayNamesLocale_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayNamesLocale(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.displayNamesLocale_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDisplayNamesLocale() {
            this.bitField0_ &= -3;
            this.displayNamesLocale_ = getDefaultInstance().getDisplayNamesLocale();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayNamesLocaleBytes(ByteString value) {
            this.displayNamesLocale_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public boolean hasSegmenterOptions() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
        public SegmenterOptionsProto.SegmenterOptions getSegmenterOptions() {
            SegmenterOptionsProto.SegmenterOptions segmenterOptions = this.segmenterOptions_;
            return segmenterOptions == null ? SegmenterOptionsProto.SegmenterOptions.getDefaultInstance() : segmenterOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
            value.getClass();
            this.segmenterOptions_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
            value.getClass();
            SegmenterOptionsProto.SegmenterOptions segmenterOptions = this.segmenterOptions_;
            if (segmenterOptions != null && segmenterOptions != SegmenterOptionsProto.SegmenterOptions.getDefaultInstance()) {
                this.segmenterOptions_ = (SegmenterOptionsProto.SegmenterOptions) SegmenterOptionsProto.SegmenterOptions.newBuilder(this.segmenterOptions_).mergeFrom(value).buildPartial();
            } else {
                this.segmenterOptions_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSegmenterOptions() {
            this.segmenterOptions_ = null;
            this.bitField0_ &= -5;
        }

        public static ImageSegmenterGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ImageSegmenterGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ImageSegmenterGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ImageSegmenterGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ImageSegmenterGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ImageSegmenterGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ImageSegmenterGraphOptions parseFrom(InputStream input) throws IOException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ImageSegmenterGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ImageSegmenterGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (ImageSegmenterGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ImageSegmenterGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ImageSegmenterGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ImageSegmenterGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ImageSegmenterGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ImageSegmenterGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ImageSegmenterGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ImageSegmenterGraphOptions, Builder> implements ImageSegmenterGraphOptionsOrBuilder {
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
                super(ImageSegmenterGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((ImageSegmenterGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((ImageSegmenterGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public boolean hasDisplayNamesLocale() {
                return ((ImageSegmenterGraphOptions) this.instance).hasDisplayNamesLocale();
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public String getDisplayNamesLocale() {
                return ((ImageSegmenterGraphOptions) this.instance).getDisplayNamesLocale();
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public ByteString getDisplayNamesLocaleBytes() {
                return ((ImageSegmenterGraphOptions) this.instance).getDisplayNamesLocaleBytes();
            }

            public Builder setDisplayNamesLocale(String value) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).setDisplayNamesLocale(value);
                return this;
            }

            public Builder clearDisplayNamesLocale() {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).clearDisplayNamesLocale();
                return this;
            }

            public Builder setDisplayNamesLocaleBytes(ByteString value) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).setDisplayNamesLocaleBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public boolean hasSegmenterOptions() {
                return ((ImageSegmenterGraphOptions) this.instance).hasSegmenterOptions();
            }

            @Override // com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto.ImageSegmenterGraphOptionsOrBuilder
            public SegmenterOptionsProto.SegmenterOptions getSegmenterOptions() {
                return ((ImageSegmenterGraphOptions) this.instance).getSegmenterOptions();
            }

            public Builder setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).setSegmenterOptions(value);
                return this;
            }

            public Builder setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions.Builder builderForValue) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).setSegmenterOptions((SegmenterOptionsProto.SegmenterOptions) builderForValue.build());
                return this;
            }

            public Builder mergeSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).mergeSegmenterOptions(value);
                return this;
            }

            public Builder clearSegmenterOptions() {
                copyOnWrite();
                ((ImageSegmenterGraphOptions) this.instance).clearSegmenterOptions();
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
                    return new ImageSegmenterGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"bitField0_", "baseOptions_", "displayNamesLocale_", "segmenterOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ImageSegmenterGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ImageSegmenterGraphOptions.class) {
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
            ImageSegmenterGraphOptions imageSegmenterGraphOptions = new ImageSegmenterGraphOptions();
            DEFAULT_INSTANCE = imageSegmenterGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(ImageSegmenterGraphOptions.class, imageSegmenterGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, ImageSegmenterGraphOptions.class);
        }

        public static ImageSegmenterGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ImageSegmenterGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.vision.imagesegmenter.proto.ImageSegmenterGraphOptionsProto$1, reason: invalid class name */
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
