package com.google.mediapipe.tasks;

import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.vision.imagesegmenter.proto.SegmenterOptionsProto;
import com.google.mediapipe.util.proto.LabelMapProto;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class TensorsToSegmentationCalculatorOptionsProto {

    public interface TensorsToSegmentationCalculatorOptionsOrBuilder extends MessageLiteOrBuilder {
        boolean containsLabelItems(long key);

        TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptions getConfidenceMaskOptions();

        @Deprecated
        Map<Long, LabelMapProto.LabelMapItem> getLabelItems();

        int getLabelItemsCount();

        Map<Long, LabelMapProto.LabelMapItem> getLabelItemsMap();

        LabelMapProto.LabelMapItem getLabelItemsOrDefault(long key, LabelMapProto.LabelMapItem defaultValue);

        LabelMapProto.LabelMapItem getLabelItemsOrThrow(long key);

        SegmenterOptionsProto.SegmenterOptions getSegmenterOptions();

        boolean hasConfidenceMaskOptions();

        boolean hasSegmenterOptions();
    }

    private TensorsToSegmentationCalculatorOptionsProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
        registry.add((GeneratedMessageLite.GeneratedExtension<?, ?>) TensorsToSegmentationCalculatorOptions.ext);
    }

    public static final class TensorsToSegmentationCalculatorOptions extends GeneratedMessageLite<TensorsToSegmentationCalculatorOptions, Builder> implements TensorsToSegmentationCalculatorOptionsOrBuilder {
        public static final int CONFIDENCE_MASK_OPTIONS_FIELD_NUMBER = 3;
        private static final TensorsToSegmentationCalculatorOptions DEFAULT_INSTANCE;
        public static final int EXT_FIELD_NUMBER = 458105876;
        public static final int LABEL_ITEMS_FIELD_NUMBER = 2;
        private static volatile Parser<TensorsToSegmentationCalculatorOptions> PARSER = null;
        public static final int SEGMENTER_OPTIONS_FIELD_NUMBER = 1;
        public static final GeneratedMessageLite.GeneratedExtension<CalculatorOptionsProto.CalculatorOptions, TensorsToSegmentationCalculatorOptions> ext;
        private int bitField0_;
        private ConfidenceMaskOptions confidenceMaskOptions_;
        private MapFieldLite<Long, LabelMapProto.LabelMapItem> labelItems_ = MapFieldLite.emptyMapField();
        private SegmenterOptionsProto.SegmenterOptions segmenterOptions_;

        public interface ConfidenceMaskOptionsOrBuilder extends MessageLiteOrBuilder {
            int getOutputChannels(int index);

            int getOutputChannelsCount();

            List<Integer> getOutputChannelsList();

            ConfidenceMaskOptions.OutputFormat getOutputFormat();

            boolean getPack4();

            boolean hasOutputFormat();

            boolean hasPack4();
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

        private TensorsToSegmentationCalculatorOptions() {
        }

        public static final class ConfidenceMaskOptions extends GeneratedMessageLite<ConfidenceMaskOptions, Builder> implements ConfidenceMaskOptionsOrBuilder {
            private static final ConfidenceMaskOptions DEFAULT_INSTANCE;
            public static final int OUTPUT_CHANNELS_FIELD_NUMBER = 1;
            public static final int OUTPUT_FORMAT_FIELD_NUMBER = 3;
            public static final int PACK4_FIELD_NUMBER = 2;
            private static volatile Parser<ConfidenceMaskOptions> PARSER;
            private int bitField0_;
            private int outputChannelsMemoizedSerializedSize = -1;
            private Internal.IntList outputChannels_ = emptyIntList();
            private int outputFormat_;
            private boolean pack4_;

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

            private ConfidenceMaskOptions() {
            }

            public enum OutputFormat implements Internal.EnumLite {
                OUTPUT_FORMAT_UNSPECIFIED(0),
                OUTPUT_FORMAT_FLOAT(1),
                OUTPUT_FORMAT_UINT8(2);

                public static final int OUTPUT_FORMAT_FLOAT_VALUE = 1;
                public static final int OUTPUT_FORMAT_UINT8_VALUE = 2;
                public static final int OUTPUT_FORMAT_UNSPECIFIED_VALUE = 0;
                private static final Internal.EnumLiteMap<OutputFormat> internalValueMap = new Internal.EnumLiteMap<OutputFormat>() { // from class: com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptions.OutputFormat.1
                    @Override // com.google.protobuf.Internal.EnumLiteMap
                    public OutputFormat findValueByNumber(int number) {
                        return OutputFormat.forNumber(number);
                    }
                };
                private final int value;

                @Override // com.google.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                @Deprecated
                public static OutputFormat valueOf(int value) {
                    return forNumber(value);
                }

                public static OutputFormat forNumber(int value) {
                    if (value == 0) {
                        return OUTPUT_FORMAT_UNSPECIFIED;
                    }
                    if (value == 1) {
                        return OUTPUT_FORMAT_FLOAT;
                    }
                    if (value != 2) {
                        return null;
                    }
                    return OUTPUT_FORMAT_UINT8;
                }

                public static Internal.EnumLiteMap<OutputFormat> internalGetValueMap() {
                    return internalValueMap;
                }

                public static Internal.EnumVerifier internalGetVerifier() {
                    return OutputFormatVerifier.INSTANCE;
                }

                private static final class OutputFormatVerifier implements Internal.EnumVerifier {
                    static final Internal.EnumVerifier INSTANCE = new OutputFormatVerifier();

                    private OutputFormatVerifier() {
                    }

                    @Override // com.google.protobuf.Internal.EnumVerifier
                    public boolean isInRange(int number) {
                        return OutputFormat.forNumber(number) != null;
                    }
                }

                OutputFormat(int value) {
                    this.value = value;
                }
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public List<Integer> getOutputChannelsList() {
                return this.outputChannels_;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public int getOutputChannelsCount() {
                return this.outputChannels_.size();
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public int getOutputChannels(int index) {
                return this.outputChannels_.getInt(index);
            }

            private void ensureOutputChannelsIsMutable() {
                Internal.IntList intList = this.outputChannels_;
                if (intList.isModifiable()) {
                    return;
                }
                this.outputChannels_ = GeneratedMessageLite.mutableCopy(intList);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOutputChannels(int index, int value) {
                ensureOutputChannelsIsMutable();
                this.outputChannels_.setInt(index, value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addOutputChannels(int value) {
                ensureOutputChannelsIsMutable();
                this.outputChannels_.addInt(value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllOutputChannels(Iterable<? extends Integer> values) {
                ensureOutputChannelsIsMutable();
                AbstractMessageLite.addAll(values, this.outputChannels_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOutputChannels() {
                this.outputChannels_ = emptyIntList();
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public boolean hasPack4() {
                return (this.bitField0_ & 1) != 0;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public boolean getPack4() {
                return this.pack4_;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setPack4(boolean value) {
                this.bitField0_ |= 1;
                this.pack4_ = value;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearPack4() {
                this.bitField0_ &= -2;
                this.pack4_ = false;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public boolean hasOutputFormat() {
                return (this.bitField0_ & 2) != 0;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
            public OutputFormat getOutputFormat() {
                OutputFormat outputFormatForNumber = OutputFormat.forNumber(this.outputFormat_);
                return outputFormatForNumber == null ? OutputFormat.OUTPUT_FORMAT_UNSPECIFIED : outputFormatForNumber;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setOutputFormat(OutputFormat value) {
                this.outputFormat_ = value.getNumber();
                this.bitField0_ |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearOutputFormat() {
                this.bitField0_ &= -3;
                this.outputFormat_ = 0;
            }

            public static ConfidenceMaskOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ConfidenceMaskOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ConfidenceMaskOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ConfidenceMaskOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ConfidenceMaskOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static ConfidenceMaskOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static ConfidenceMaskOptions parseFrom(InputStream input) throws IOException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static ConfidenceMaskOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static ConfidenceMaskOptions parseDelimitedFrom(InputStream input) throws IOException {
                return (ConfidenceMaskOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static ConfidenceMaskOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ConfidenceMaskOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static ConfidenceMaskOptions parseFrom(CodedInputStream input) throws IOException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static ConfidenceMaskOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (ConfidenceMaskOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(ConfidenceMaskOptions prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<ConfidenceMaskOptions, Builder> implements ConfidenceMaskOptionsOrBuilder {
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
                    super(ConfidenceMaskOptions.DEFAULT_INSTANCE);
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public List<Integer> getOutputChannelsList() {
                    return Collections.unmodifiableList(((ConfidenceMaskOptions) this.instance).getOutputChannelsList());
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public int getOutputChannelsCount() {
                    return ((ConfidenceMaskOptions) this.instance).getOutputChannelsCount();
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public int getOutputChannels(int index) {
                    return ((ConfidenceMaskOptions) this.instance).getOutputChannels(index);
                }

                public Builder setOutputChannels(int index, int value) {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).setOutputChannels(index, value);
                    return this;
                }

                public Builder addOutputChannels(int value) {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).addOutputChannels(value);
                    return this;
                }

                public Builder addAllOutputChannels(Iterable<? extends Integer> values) {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).addAllOutputChannels(values);
                    return this;
                }

                public Builder clearOutputChannels() {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).clearOutputChannels();
                    return this;
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public boolean hasPack4() {
                    return ((ConfidenceMaskOptions) this.instance).hasPack4();
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public boolean getPack4() {
                    return ((ConfidenceMaskOptions) this.instance).getPack4();
                }

                public Builder setPack4(boolean value) {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).setPack4(value);
                    return this;
                }

                public Builder clearPack4() {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).clearPack4();
                    return this;
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public boolean hasOutputFormat() {
                    return ((ConfidenceMaskOptions) this.instance).hasOutputFormat();
                }

                @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptions.ConfidenceMaskOptionsOrBuilder
                public OutputFormat getOutputFormat() {
                    return ((ConfidenceMaskOptions) this.instance).getOutputFormat();
                }

                public Builder setOutputFormat(OutputFormat value) {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).setOutputFormat(value);
                    return this;
                }

                public Builder clearOutputFormat() {
                    copyOnWrite();
                    ((ConfidenceMaskOptions) this.instance).clearOutputFormat();
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
                        return new ConfidenceMaskOptions();
                    case 2:
                        return new Builder(anonymousClass1);
                    case 3:
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001'\u0002ဇ\u0000\u0003᠌\u0001", new Object[]{"bitField0_", "outputChannels_", "pack4_", "outputFormat_", OutputFormat.internalGetVerifier()});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<ConfidenceMaskOptions> parser = PARSER;
                        if (parser != null) {
                            return parser;
                        }
                        synchronized (ConfidenceMaskOptions.class) {
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
                ConfidenceMaskOptions confidenceMaskOptions = new ConfidenceMaskOptions();
                DEFAULT_INSTANCE = confidenceMaskOptions;
                GeneratedMessageLite.registerDefaultInstance(ConfidenceMaskOptions.class, confidenceMaskOptions);
            }

            public static ConfidenceMaskOptions getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<ConfidenceMaskOptions> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public boolean hasSegmenterOptions() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public SegmenterOptionsProto.SegmenterOptions getSegmenterOptions() {
            SegmenterOptionsProto.SegmenterOptions segmenterOptions = this.segmenterOptions_;
            return segmenterOptions == null ? SegmenterOptionsProto.SegmenterOptions.getDefaultInstance() : segmenterOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
            value.getClass();
            this.segmenterOptions_ = value;
            this.bitField0_ |= 1;
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
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSegmenterOptions() {
            this.segmenterOptions_ = null;
            this.bitField0_ &= -2;
        }

        private static final class LabelItemsDefaultEntryHolder {
            static final MapEntryLite<Long, LabelMapProto.LabelMapItem> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.INT64, 0L, WireFormat.FieldType.MESSAGE, LabelMapProto.LabelMapItem.getDefaultInstance());

            private LabelItemsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<Long, LabelMapProto.LabelMapItem> internalGetLabelItems() {
            return this.labelItems_;
        }

        private MapFieldLite<Long, LabelMapProto.LabelMapItem> internalGetMutableLabelItems() {
            if (!this.labelItems_.isMutable()) {
                this.labelItems_ = this.labelItems_.mutableCopy();
            }
            return this.labelItems_;
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public int getLabelItemsCount() {
            return internalGetLabelItems().size();
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public boolean containsLabelItems(long key) {
            return internalGetLabelItems().containsKey(Long.valueOf(key));
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        @Deprecated
        public Map<Long, LabelMapProto.LabelMapItem> getLabelItems() {
            return getLabelItemsMap();
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public Map<Long, LabelMapProto.LabelMapItem> getLabelItemsMap() {
            return Collections.unmodifiableMap(internalGetLabelItems());
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public LabelMapProto.LabelMapItem getLabelItemsOrDefault(long key, LabelMapProto.LabelMapItem defaultValue) {
            MapFieldLite<Long, LabelMapProto.LabelMapItem> mapFieldLiteInternalGetLabelItems = internalGetLabelItems();
            return mapFieldLiteInternalGetLabelItems.containsKey(Long.valueOf(key)) ? mapFieldLiteInternalGetLabelItems.get(Long.valueOf(key)) : defaultValue;
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public LabelMapProto.LabelMapItem getLabelItemsOrThrow(long key) {
            MapFieldLite<Long, LabelMapProto.LabelMapItem> mapFieldLiteInternalGetLabelItems = internalGetLabelItems();
            if (!mapFieldLiteInternalGetLabelItems.containsKey(Long.valueOf(key))) {
                throw new IllegalArgumentException();
            }
            return mapFieldLiteInternalGetLabelItems.get(Long.valueOf(key));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Long, LabelMapProto.LabelMapItem> getMutableLabelItemsMap() {
            return internalGetMutableLabelItems();
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public boolean hasConfidenceMaskOptions() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
        public ConfidenceMaskOptions getConfidenceMaskOptions() {
            ConfidenceMaskOptions confidenceMaskOptions = this.confidenceMaskOptions_;
            return confidenceMaskOptions == null ? ConfidenceMaskOptions.getDefaultInstance() : confidenceMaskOptions;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConfidenceMaskOptions(ConfidenceMaskOptions value) {
            value.getClass();
            this.confidenceMaskOptions_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeConfidenceMaskOptions(ConfidenceMaskOptions value) {
            value.getClass();
            ConfidenceMaskOptions confidenceMaskOptions = this.confidenceMaskOptions_;
            if (confidenceMaskOptions != null && confidenceMaskOptions != ConfidenceMaskOptions.getDefaultInstance()) {
                this.confidenceMaskOptions_ = (ConfidenceMaskOptions) ConfidenceMaskOptions.newBuilder(this.confidenceMaskOptions_).mergeFrom(value).buildPartial();
            } else {
                this.confidenceMaskOptions_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConfidenceMaskOptions() {
            this.confidenceMaskOptions_ = null;
            this.bitField0_ &= -3;
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(InputStream input) throws IOException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static TensorsToSegmentationCalculatorOptions parseDelimitedFrom(InputStream input) throws IOException {
            return (TensorsToSegmentationCalculatorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static TensorsToSegmentationCalculatorOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TensorsToSegmentationCalculatorOptions) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(CodedInputStream input) throws IOException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static TensorsToSegmentationCalculatorOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TensorsToSegmentationCalculatorOptions) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TensorsToSegmentationCalculatorOptions prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TensorsToSegmentationCalculatorOptions, Builder> implements TensorsToSegmentationCalculatorOptionsOrBuilder {
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
                super(TensorsToSegmentationCalculatorOptions.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public boolean hasSegmenterOptions() {
                return ((TensorsToSegmentationCalculatorOptions) this.instance).hasSegmenterOptions();
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public SegmenterOptionsProto.SegmenterOptions getSegmenterOptions() {
                return ((TensorsToSegmentationCalculatorOptions) this.instance).getSegmenterOptions();
            }

            public Builder setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).setSegmenterOptions(value);
                return this;
            }

            public Builder setSegmenterOptions(SegmenterOptionsProto.SegmenterOptions.Builder builderForValue) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).setSegmenterOptions((SegmenterOptionsProto.SegmenterOptions) builderForValue.build());
                return this;
            }

            public Builder mergeSegmenterOptions(SegmenterOptionsProto.SegmenterOptions value) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).mergeSegmenterOptions(value);
                return this;
            }

            public Builder clearSegmenterOptions() {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).clearSegmenterOptions();
                return this;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public int getLabelItemsCount() {
                return ((TensorsToSegmentationCalculatorOptions) this.instance).getLabelItemsMap().size();
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public boolean containsLabelItems(long key) {
                return ((TensorsToSegmentationCalculatorOptions) this.instance).getLabelItemsMap().containsKey(Long.valueOf(key));
            }

            public Builder clearLabelItems() {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).getMutableLabelItemsMap().clear();
                return this;
            }

            public Builder removeLabelItems(long key) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).getMutableLabelItemsMap().remove(Long.valueOf(key));
                return this;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            @Deprecated
            public Map<Long, LabelMapProto.LabelMapItem> getLabelItems() {
                return getLabelItemsMap();
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public Map<Long, LabelMapProto.LabelMapItem> getLabelItemsMap() {
                return Collections.unmodifiableMap(((TensorsToSegmentationCalculatorOptions) this.instance).getLabelItemsMap());
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public LabelMapProto.LabelMapItem getLabelItemsOrDefault(long key, LabelMapProto.LabelMapItem defaultValue) {
                Map<Long, LabelMapProto.LabelMapItem> labelItemsMap = ((TensorsToSegmentationCalculatorOptions) this.instance).getLabelItemsMap();
                return labelItemsMap.containsKey(Long.valueOf(key)) ? labelItemsMap.get(Long.valueOf(key)) : defaultValue;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public LabelMapProto.LabelMapItem getLabelItemsOrThrow(long key) {
                Map<Long, LabelMapProto.LabelMapItem> labelItemsMap = ((TensorsToSegmentationCalculatorOptions) this.instance).getLabelItemsMap();
                if (!labelItemsMap.containsKey(Long.valueOf(key))) {
                    throw new IllegalArgumentException();
                }
                return labelItemsMap.get(Long.valueOf(key));
            }

            public Builder putLabelItems(long key, LabelMapProto.LabelMapItem value) {
                value.getClass();
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).getMutableLabelItemsMap().put(Long.valueOf(key), value);
                return this;
            }

            public Builder putAllLabelItems(Map<Long, LabelMapProto.LabelMapItem> values) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).getMutableLabelItemsMap().putAll(values);
                return this;
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public boolean hasConfidenceMaskOptions() {
                return ((TensorsToSegmentationCalculatorOptions) this.instance).hasConfidenceMaskOptions();
            }

            @Override // com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto.TensorsToSegmentationCalculatorOptionsOrBuilder
            public ConfidenceMaskOptions getConfidenceMaskOptions() {
                return ((TensorsToSegmentationCalculatorOptions) this.instance).getConfidenceMaskOptions();
            }

            public Builder setConfidenceMaskOptions(ConfidenceMaskOptions value) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).setConfidenceMaskOptions(value);
                return this;
            }

            public Builder setConfidenceMaskOptions(ConfidenceMaskOptions.Builder builderForValue) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).setConfidenceMaskOptions((ConfidenceMaskOptions) builderForValue.build());
                return this;
            }

            public Builder mergeConfidenceMaskOptions(ConfidenceMaskOptions value) {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).mergeConfidenceMaskOptions(value);
                return this;
            }

            public Builder clearConfidenceMaskOptions() {
                copyOnWrite();
                ((TensorsToSegmentationCalculatorOptions) this.instance).clearConfidenceMaskOptions();
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
                    return new TensorsToSegmentationCalculatorOptions();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0000\u0001ဉ\u0000\u00022\u0003ဉ\u0001", new Object[]{"bitField0_", "segmenterOptions_", "labelItems_", LabelItemsDefaultEntryHolder.defaultEntry, "confidenceMaskOptions_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<TensorsToSegmentationCalculatorOptions> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (TensorsToSegmentationCalculatorOptions.class) {
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
            TensorsToSegmentationCalculatorOptions tensorsToSegmentationCalculatorOptions = new TensorsToSegmentationCalculatorOptions();
            DEFAULT_INSTANCE = tensorsToSegmentationCalculatorOptions;
            GeneratedMessageLite.registerDefaultInstance(TensorsToSegmentationCalculatorOptions.class, tensorsToSegmentationCalculatorOptions);
            ext = GeneratedMessageLite.newSingularGeneratedExtension(CalculatorOptionsProto.CalculatorOptions.getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), null, EXT_FIELD_NUMBER, WireFormat.FieldType.MESSAGE, TensorsToSegmentationCalculatorOptions.class);
        }

        public static TensorsToSegmentationCalculatorOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TensorsToSegmentationCalculatorOptions> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.TensorsToSegmentationCalculatorOptionsProto$1, reason: invalid class name */
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
