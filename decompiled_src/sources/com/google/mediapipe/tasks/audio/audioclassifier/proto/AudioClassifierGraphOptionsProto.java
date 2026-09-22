package com.google.mediapipe.tasks.audio.audioclassifier.proto;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.components.processors.proto.ClassifierOptionsProto;
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
public final class AudioClassifierGraphOptionsProto {

    public interface AudioClassifierGraphOptionsOrBuilder extends MessageLiteOrBuilder {
        BaseOptionsProto.BaseOptions getBaseOptions();

        ClassifierOptionsProto.ClassifierOptions getClassifierOptions();

        double getDefaultInputAudioSampleRate();

        boolean hasBaseOptions();

        boolean hasClassifierOptions();

        boolean hasDefaultInputAudioSampleRate();
    }

    private AudioClassifierGraphOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) AudioClassifierGraphOptions.ext);
    }

    public static final class AudioClassifierGraphOptions extends GeneratedMessageLite<AudioClassifierGraphOptions, Builder> implements AudioClassifierGraphOptionsOrBuilder {
        public static final int BASE_OPTIONS_FIELD_NUMBER = 1;
        public static final int CLASSIFIER_OPTIONS_FIELD_NUMBER = 2;
        public static final int DEFAULT_INPUT_AUDIO_SAMPLE_RATE_FIELD_NUMBER = 3;
        private static final AudioClassifierGraphOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 451755788;
        private static volatile Parser<AudioClassifierGraphOptions> PARSER;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, AudioClassifierGraphOptions> ext;
        private BaseOptionsProto.BaseOptions baseOptions_;
        private int bitField0_;
        private ClassifierOptionsProto.ClassifierOptions classifierOptions_;
        private double defaultInputAudioSampleRate_;

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

        private AudioClassifierGraphOptions() {
        }

        @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
        public boolean hasBaseOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
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

        @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
        public boolean hasClassifierOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
        public ClassifierOptionsProto.ClassifierOptions getClassifierOptions() {
            ClassifierOptionsProto.ClassifierOptions classifierOptions = this.classifierOptions_;
            return classifierOptions == null ? ClassifierOptionsProto.ClassifierOptions.getDefaultInstance() : classifierOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassifierOptions(ClassifierOptionsProto.ClassifierOptions value) {
            value.getClass();
            this.classifierOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClassifierOptions(ClassifierOptionsProto.ClassifierOptions value) {
            value.getClass();
            ClassifierOptionsProto.ClassifierOptions classifierOptions = this.classifierOptions_;
            if (classifierOptions != null && classifierOptions != ClassifierOptionsProto.ClassifierOptions.getDefaultInstance()) {
                this.classifierOptions_ = (ClassifierOptionsProto.ClassifierOptions) ClassifierOptionsProto.ClassifierOptions.newBuilder(this.classifierOptions_).mergeFrom(value).buildPartial();
            } else {
                this.classifierOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassifierOptions() {
            this.classifierOptions_ = null;
            this.bitField0_ &= -3;
        }

        @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
        public boolean hasDefaultInputAudioSampleRate() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
        public double getDefaultInputAudioSampleRate() {
            return this.defaultInputAudioSampleRate_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDefaultInputAudioSampleRate(double value) {
            this.bitField0_ |= 4;
            this.defaultInputAudioSampleRate_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDefaultInputAudioSampleRate() {
            this.bitField0_ &= -5;
            this.defaultInputAudioSampleRate_ = 0.0d;
        }

        public static AudioClassifierGraphOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AudioClassifierGraphOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AudioClassifierGraphOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AudioClassifierGraphOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AudioClassifierGraphOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AudioClassifierGraphOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AudioClassifierGraphOptions parseFrom(InputStream input) throws IOException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AudioClassifierGraphOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AudioClassifierGraphOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (AudioClassifierGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static AudioClassifierGraphOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AudioClassifierGraphOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AudioClassifierGraphOptions parseFrom(CodedInputStream input) throws IOException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AudioClassifierGraphOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AudioClassifierGraphOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AudioClassifierGraphOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AudioClassifierGraphOptions, Builder> implements AudioClassifierGraphOptionsOrBuilder {
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
                super(AudioClassifierGraphOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
            public boolean hasBaseOptions() {
                return ((AudioClassifierGraphOptions) this.instance).hasBaseOptions();
            }

            @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
            public BaseOptionsProto.BaseOptions getBaseOptions() {
                return ((AudioClassifierGraphOptions) this.instance).getBaseOptions();
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).setBaseOptions(value);
                return this;
            }

            public Builder setBaseOptions(BaseOptionsProto.BaseOptions.Builder builderForValue) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).setBaseOptions((BaseOptionsProto.BaseOptions) builderForValue.build());
                return this;
            }

            public Builder mergeBaseOptions(BaseOptionsProto.BaseOptions value) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).mergeBaseOptions(value);
                return this;
            }

            public Builder clearBaseOptions() {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).clearBaseOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
            public boolean hasClassifierOptions() {
                return ((AudioClassifierGraphOptions) this.instance).hasClassifierOptions();
            }

            @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
            public ClassifierOptionsProto.ClassifierOptions getClassifierOptions() {
                return ((AudioClassifierGraphOptions) this.instance).getClassifierOptions();
            }

            public Builder setClassifierOptions(ClassifierOptionsProto.ClassifierOptions value) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).setClassifierOptions(value);
                return this;
            }

            public Builder setClassifierOptions(ClassifierOptionsProto.ClassifierOptions.Builder builderForValue) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).setClassifierOptions((ClassifierOptionsProto.ClassifierOptions) builderForValue.build());
                return this;
            }

            public Builder mergeClassifierOptions(ClassifierOptionsProto.ClassifierOptions value) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).mergeClassifierOptions(value);
                return this;
            }

            public Builder clearClassifierOptions() {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).clearClassifierOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
            public boolean hasDefaultInputAudioSampleRate() {
                return ((AudioClassifierGraphOptions) this.instance).hasDefaultInputAudioSampleRate();
            }

            @Override // com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto.AudioClassifierGraphOptionsOrBuilder
            public double getDefaultInputAudioSampleRate() {
                return ((AudioClassifierGraphOptions) this.instance).getDefaultInputAudioSampleRate();
            }

            public Builder setDefaultInputAudioSampleRate(double value) {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).setDefaultInputAudioSampleRate(value);
                return this;
            }

            public Builder clearDefaultInputAudioSampleRate() {
                copyOnWrite();
                ((AudioClassifierGraphOptions) this.instance).clearDefaultInputAudioSampleRate();
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
                    return new AudioClassifierGraphOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003က\u0002", new Object[]{"bitField0_", "baseOptions_", "classifierOptions_", "defaultInputAudioSampleRate_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<AudioClassifierGraphOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (AudioClassifierGraphOptions.class) {
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
            AudioClassifierGraphOptions audioClassifierGraphOptions = new AudioClassifierGraphOptions();
            DEFAULT_INSTANCE = audioClassifierGraphOptions;
            GeneratedMessageLite.registerDefaultInstance(AudioClassifierGraphOptions.class, audioClassifierGraphOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, AudioClassifierGraphOptions.class);
        }

        public static AudioClassifierGraphOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AudioClassifierGraphOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.audio.audioclassifier.proto.AudioClassifierGraphOptionsProto$1, reason: invalid class name */
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
