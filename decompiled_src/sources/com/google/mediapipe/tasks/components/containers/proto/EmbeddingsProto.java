package com.google.mediapipe.tasks.components.containers.proto;

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
public final class EmbeddingsProto {

    public interface EmbeddingOrBuilder extends MessageLiteOrBuilder {
        Embedding.EmbeddingCase getEmbeddingCase();

        FloatEmbedding getFloatEmbedding();

        int getHeadIndex();

        String getHeadName();

        ByteString getHeadNameBytes();

        QuantizedEmbedding getQuantizedEmbedding();

        boolean hasFloatEmbedding();

        boolean hasHeadIndex();

        boolean hasHeadName();

        boolean hasQuantizedEmbedding();
    }

    public interface EmbeddingResultOrBuilder extends MessageLiteOrBuilder {
        Embedding getEmbeddings(int index);

        int getEmbeddingsCount();

        List<Embedding> getEmbeddingsList();

        long getTimestampMs();

        boolean hasTimestampMs();
    }

    public interface FloatEmbeddingOrBuilder extends MessageLiteOrBuilder {
        float getValues(int index);

        int getValuesCount();

        List<Float> getValuesList();
    }

    public interface QuantizedEmbeddingOrBuilder extends MessageLiteOrBuilder {
        ByteString getValues();

        boolean hasValues();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private EmbeddingsProto() {
    }

    public static final class FloatEmbedding extends GeneratedMessageLite<FloatEmbedding, Builder> implements FloatEmbeddingOrBuilder {
        private static final FloatEmbedding DEFAULT_INSTANCE;
        private static volatile Parser<FloatEmbedding> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 1;
        private int valuesMemoizedSerializedSize = -1;
        private Internal.FloatList values_ = emptyFloatList();

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

        private FloatEmbedding() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.FloatEmbeddingOrBuilder
        public List<Float> getValuesList() {
            return this.values_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.FloatEmbeddingOrBuilder
        public int getValuesCount() {
            return this.values_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.FloatEmbeddingOrBuilder
        public float getValues(int index) {
            return this.values_.getFloat(index);
        }

        private void ensureValuesIsMutable() {
            Internal.FloatList floatList = this.values_;
            if (floatList.isModifiable()) {
                return;
            }
            this.values_ = GeneratedMessageLite.mutableCopy(floatList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValues(int index, float value) {
            ensureValuesIsMutable();
            this.values_.setFloat(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addValues(float value) {
            ensureValuesIsMutable();
            this.values_.addFloat(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllValues(Iterable<? extends Float> values) {
            ensureValuesIsMutable();
            AbstractMessageLite.addAll(values, this.values_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValues() {
            this.values_ = emptyFloatList();
        }

        public static FloatEmbedding parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FloatEmbedding parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FloatEmbedding parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FloatEmbedding parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FloatEmbedding parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FloatEmbedding parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FloatEmbedding parseFrom(InputStream input) throws IOException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FloatEmbedding parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FloatEmbedding parseDelimitedFrom(InputStream input) throws IOException {
            return (FloatEmbedding) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FloatEmbedding parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FloatEmbedding) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FloatEmbedding parseFrom(CodedInputStream input) throws IOException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FloatEmbedding parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FloatEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FloatEmbedding prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FloatEmbedding, Builder> implements FloatEmbeddingOrBuilder {
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
                super(FloatEmbedding.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.FloatEmbeddingOrBuilder
            public List<Float> getValuesList() {
                return Collections.unmodifiableList(((FloatEmbedding) this.instance).getValuesList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.FloatEmbeddingOrBuilder
            public int getValuesCount() {
                return ((FloatEmbedding) this.instance).getValuesCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.FloatEmbeddingOrBuilder
            public float getValues(int index) {
                return ((FloatEmbedding) this.instance).getValues(index);
            }

            public Builder setValues(int index, float value) {
                copyOnWrite();
                ((FloatEmbedding) this.instance).setValues(index, value);
                return this;
            }

            public Builder addValues(float value) {
                copyOnWrite();
                ((FloatEmbedding) this.instance).addValues(value);
                return this;
            }

            public Builder addAllValues(Iterable<? extends Float> values) {
                copyOnWrite();
                ((FloatEmbedding) this.instance).addAllValues(values);
                return this;
            }

            public Builder clearValues() {
                copyOnWrite();
                ((FloatEmbedding) this.instance).clearValues();
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
                    return new FloatEmbedding();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001$", new Object[]{"values_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FloatEmbedding> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FloatEmbedding.class) {
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
            FloatEmbedding floatEmbedding = new FloatEmbedding();
            DEFAULT_INSTANCE = floatEmbedding;
            GeneratedMessageLite.registerDefaultInstance(FloatEmbedding.class, floatEmbedding);
        }

        public static FloatEmbedding getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FloatEmbedding> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto$1, reason: invalid class name */
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

    public static final class QuantizedEmbedding extends GeneratedMessageLite<QuantizedEmbedding, Builder> implements QuantizedEmbeddingOrBuilder {
        private static final QuantizedEmbedding DEFAULT_INSTANCE;
        private static volatile Parser<QuantizedEmbedding> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString values_ = ByteString.EMPTY;

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

        private QuantizedEmbedding() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.QuantizedEmbeddingOrBuilder
        public boolean hasValues() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.QuantizedEmbeddingOrBuilder
        public ByteString getValues() {
            return this.values_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValues(ByteString value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.values_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValues() {
            this.bitField0_ &= -2;
            this.values_ = getDefaultInstance().getValues();
        }

        public static QuantizedEmbedding parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static QuantizedEmbedding parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static QuantizedEmbedding parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static QuantizedEmbedding parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static QuantizedEmbedding parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static QuantizedEmbedding parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static QuantizedEmbedding parseFrom(InputStream input) throws IOException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static QuantizedEmbedding parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static QuantizedEmbedding parseDelimitedFrom(InputStream input) throws IOException {
            return (QuantizedEmbedding) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static QuantizedEmbedding parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuantizedEmbedding) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static QuantizedEmbedding parseFrom(CodedInputStream input) throws IOException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static QuantizedEmbedding parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (QuantizedEmbedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(QuantizedEmbedding prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<QuantizedEmbedding, Builder> implements QuantizedEmbeddingOrBuilder {
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
                super(QuantizedEmbedding.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.QuantizedEmbeddingOrBuilder
            public boolean hasValues() {
                return ((QuantizedEmbedding) this.instance).hasValues();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.QuantizedEmbeddingOrBuilder
            public ByteString getValues() {
                return ((QuantizedEmbedding) this.instance).getValues();
            }

            public Builder setValues(ByteString value) {
                copyOnWrite();
                ((QuantizedEmbedding) this.instance).setValues(value);
                return this;
            }

            public Builder clearValues() {
                copyOnWrite();
                ((QuantizedEmbedding) this.instance).clearValues();
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
                    return new QuantizedEmbedding();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ည\u0000", new Object[]{"bitField0_", "values_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<QuantizedEmbedding> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (QuantizedEmbedding.class) {
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
            QuantizedEmbedding quantizedEmbedding = new QuantizedEmbedding();
            DEFAULT_INSTANCE = quantizedEmbedding;
            GeneratedMessageLite.registerDefaultInstance(QuantizedEmbedding.class, quantizedEmbedding);
        }

        public static QuantizedEmbedding getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<QuantizedEmbedding> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Embedding extends GeneratedMessageLite<Embedding, Builder> implements EmbeddingOrBuilder {
        private static final Embedding DEFAULT_INSTANCE;
        public static final int FLOAT_EMBEDDING_FIELD_NUMBER = 1;
        public static final int HEAD_INDEX_FIELD_NUMBER = 3;
        public static final int HEAD_NAME_FIELD_NUMBER = 4;
        private static volatile Parser<Embedding> PARSER = null;
        public static final int QUANTIZED_EMBEDDING_FIELD_NUMBER = 2;
        private int bitField0_;
        private Object embedding_;
        private int headIndex_;
        private int embeddingCase_ = 0;
        private String headName_ = "";

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

        private Embedding() {
        }

        public enum EmbeddingCase {
            FLOAT_EMBEDDING(1),
            QUANTIZED_EMBEDDING(2),
            EMBEDDING_NOT_SET(0);

            private final int value;

            EmbeddingCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static EmbeddingCase valueOf(int value) {
                return forNumber(value);
            }

            public static EmbeddingCase forNumber(int value) {
                if (value == 0) {
                    return EMBEDDING_NOT_SET;
                }
                if (value == 1) {
                    return FLOAT_EMBEDDING;
                }
                if (value != 2) {
                    return null;
                }
                return QUANTIZED_EMBEDDING;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public EmbeddingCase getEmbeddingCase() {
            return EmbeddingCase.forNumber(this.embeddingCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEmbedding() {
            this.embeddingCase_ = 0;
            this.embedding_ = null;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public boolean hasFloatEmbedding() {
            return this.embeddingCase_ == 1;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public FloatEmbedding getFloatEmbedding() {
            if (this.embeddingCase_ == 1) {
                return (FloatEmbedding) this.embedding_;
            }
            return FloatEmbedding.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFloatEmbedding(FloatEmbedding value) {
            value.getClass();
            this.embedding_ = value;
            this.embeddingCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFloatEmbedding(FloatEmbedding value) {
            value.getClass();
            if (this.embeddingCase_ == 1 && this.embedding_ != FloatEmbedding.getDefaultInstance()) {
                this.embedding_ = FloatEmbedding.newBuilder((FloatEmbedding) this.embedding_).mergeFrom(value).buildPartial();
            } else {
                this.embedding_ = value;
            }
            this.embeddingCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFloatEmbedding() {
            if (this.embeddingCase_ == 1) {
                this.embeddingCase_ = 0;
                this.embedding_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public boolean hasQuantizedEmbedding() {
            return this.embeddingCase_ == 2;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public QuantizedEmbedding getQuantizedEmbedding() {
            if (this.embeddingCase_ == 2) {
                return (QuantizedEmbedding) this.embedding_;
            }
            return QuantizedEmbedding.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQuantizedEmbedding(QuantizedEmbedding value) {
            value.getClass();
            this.embedding_ = value;
            this.embeddingCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeQuantizedEmbedding(QuantizedEmbedding value) {
            value.getClass();
            if (this.embeddingCase_ == 2 && this.embedding_ != QuantizedEmbedding.getDefaultInstance()) {
                this.embedding_ = QuantizedEmbedding.newBuilder((QuantizedEmbedding) this.embedding_).mergeFrom(value).buildPartial();
            } else {
                this.embedding_ = value;
            }
            this.embeddingCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQuantizedEmbedding() {
            if (this.embeddingCase_ == 2) {
                this.embeddingCase_ = 0;
                this.embedding_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public boolean hasHeadIndex() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public int getHeadIndex() {
            return this.headIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadIndex(int value) {
            this.bitField0_ |= 1;
            this.headIndex_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeadIndex() {
            this.bitField0_ &= -2;
            this.headIndex_ = 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public boolean hasHeadName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public String getHeadName() {
            return this.headName_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
        public ByteString getHeadNameBytes() {
            return ByteString.copyFromUtf8(this.headName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadName(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.headName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeadName() {
            this.bitField0_ &= -3;
            this.headName_ = getDefaultInstance().getHeadName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadNameBytes(ByteString value) {
            this.headName_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        public static Embedding parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Embedding parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Embedding parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Embedding parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Embedding parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Embedding parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Embedding parseFrom(InputStream input) throws IOException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Embedding parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Embedding parseDelimitedFrom(InputStream input) throws IOException {
            return (Embedding) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Embedding parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Embedding) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Embedding parseFrom(CodedInputStream input) throws IOException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Embedding parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Embedding) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Embedding prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Embedding, Builder> implements EmbeddingOrBuilder {
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
                super(Embedding.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public EmbeddingCase getEmbeddingCase() {
                return ((Embedding) this.instance).getEmbeddingCase();
            }

            public Builder clearEmbedding() {
                copyOnWrite();
                ((Embedding) this.instance).clearEmbedding();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public boolean hasFloatEmbedding() {
                return ((Embedding) this.instance).hasFloatEmbedding();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public FloatEmbedding getFloatEmbedding() {
                return ((Embedding) this.instance).getFloatEmbedding();
            }

            public Builder setFloatEmbedding(FloatEmbedding value) {
                copyOnWrite();
                ((Embedding) this.instance).setFloatEmbedding(value);
                return this;
            }

            public Builder setFloatEmbedding(FloatEmbedding.Builder builderForValue) {
                copyOnWrite();
                ((Embedding) this.instance).setFloatEmbedding((FloatEmbedding) builderForValue.build());
                return this;
            }

            public Builder mergeFloatEmbedding(FloatEmbedding value) {
                copyOnWrite();
                ((Embedding) this.instance).mergeFloatEmbedding(value);
                return this;
            }

            public Builder clearFloatEmbedding() {
                copyOnWrite();
                ((Embedding) this.instance).clearFloatEmbedding();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public boolean hasQuantizedEmbedding() {
                return ((Embedding) this.instance).hasQuantizedEmbedding();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public QuantizedEmbedding getQuantizedEmbedding() {
                return ((Embedding) this.instance).getQuantizedEmbedding();
            }

            public Builder setQuantizedEmbedding(QuantizedEmbedding value) {
                copyOnWrite();
                ((Embedding) this.instance).setQuantizedEmbedding(value);
                return this;
            }

            public Builder setQuantizedEmbedding(QuantizedEmbedding.Builder builderForValue) {
                copyOnWrite();
                ((Embedding) this.instance).setQuantizedEmbedding((QuantizedEmbedding) builderForValue.build());
                return this;
            }

            public Builder mergeQuantizedEmbedding(QuantizedEmbedding value) {
                copyOnWrite();
                ((Embedding) this.instance).mergeQuantizedEmbedding(value);
                return this;
            }

            public Builder clearQuantizedEmbedding() {
                copyOnWrite();
                ((Embedding) this.instance).clearQuantizedEmbedding();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public boolean hasHeadIndex() {
                return ((Embedding) this.instance).hasHeadIndex();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public int getHeadIndex() {
                return ((Embedding) this.instance).getHeadIndex();
            }

            public Builder setHeadIndex(int value) {
                copyOnWrite();
                ((Embedding) this.instance).setHeadIndex(value);
                return this;
            }

            public Builder clearHeadIndex() {
                copyOnWrite();
                ((Embedding) this.instance).clearHeadIndex();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public boolean hasHeadName() {
                return ((Embedding) this.instance).hasHeadName();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public String getHeadName() {
                return ((Embedding) this.instance).getHeadName();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingOrBuilder
            public ByteString getHeadNameBytes() {
                return ((Embedding) this.instance).getHeadNameBytes();
            }

            public Builder setHeadName(String value) {
                copyOnWrite();
                ((Embedding) this.instance).setHeadName(value);
                return this;
            }

            public Builder clearHeadName() {
                copyOnWrite();
                ((Embedding) this.instance).clearHeadName();
                return this;
            }

            public Builder setHeadNameBytes(ByteString value) {
                copyOnWrite();
                ((Embedding) this.instance).setHeadNameBytes(value);
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
                    return new Embedding();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003င\u0000\u0004ဈ\u0001", new Object[]{"embedding_", "embeddingCase_", "bitField0_", FloatEmbedding.class, QuantizedEmbedding.class, "headIndex_", "headName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Embedding> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Embedding.class) {
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
            Embedding embedding = new Embedding();
            DEFAULT_INSTANCE = embedding;
            GeneratedMessageLite.registerDefaultInstance(Embedding.class, embedding);
        }

        public static Embedding getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Embedding> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class EmbeddingResult extends GeneratedMessageLite<EmbeddingResult, Builder> implements EmbeddingResultOrBuilder {
        private static final EmbeddingResult DEFAULT_INSTANCE;
        public static final int EMBEDDINGS_FIELD_NUMBER = 1;
        private static volatile Parser<EmbeddingResult> PARSER = null;
        public static final int TIMESTAMP_MS_FIELD_NUMBER = 2;
        private int bitField0_;
        private Internal.ProtobufList<Embedding> embeddings_ = emptyProtobufList();
        private long timestampMs_;

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

        private EmbeddingResult() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
        public List<Embedding> getEmbeddingsList() {
            return this.embeddings_;
        }

        public List<? extends EmbeddingOrBuilder> getEmbeddingsOrBuilderList() {
            return this.embeddings_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
        public int getEmbeddingsCount() {
            return this.embeddings_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
        public Embedding getEmbeddings(int index) {
            return this.embeddings_.get(index);
        }

        public EmbeddingOrBuilder getEmbeddingsOrBuilder(int index) {
            return this.embeddings_.get(index);
        }

        private void ensureEmbeddingsIsMutable() {
            Internal.ProtobufList<Embedding> protobufList = this.embeddings_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.embeddings_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEmbeddings(int index, Embedding value) {
            value.getClass();
            ensureEmbeddingsIsMutable();
            this.embeddings_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEmbeddings(Embedding value) {
            value.getClass();
            ensureEmbeddingsIsMutable();
            this.embeddings_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEmbeddings(int index, Embedding value) {
            value.getClass();
            ensureEmbeddingsIsMutable();
            this.embeddings_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEmbeddings(Iterable<? extends Embedding> values) {
            ensureEmbeddingsIsMutable();
            AbstractMessageLite.addAll(values, this.embeddings_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEmbeddings() {
            this.embeddings_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeEmbeddings(int index) {
            ensureEmbeddingsIsMutable();
            this.embeddings_.remove(index);
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
        public boolean hasTimestampMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
        public long getTimestampMs() {
            return this.timestampMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimestampMs(long value) {
            this.bitField0_ |= 1;
            this.timestampMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimestampMs() {
            this.bitField0_ &= -2;
            this.timestampMs_ = 0L;
        }

        public static EmbeddingResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EmbeddingResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EmbeddingResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EmbeddingResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EmbeddingResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static EmbeddingResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static EmbeddingResult parseFrom(InputStream input) throws IOException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EmbeddingResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EmbeddingResult parseDelimitedFrom(InputStream input) throws IOException {
            return (EmbeddingResult) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static EmbeddingResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EmbeddingResult) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static EmbeddingResult parseFrom(CodedInputStream input) throws IOException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static EmbeddingResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EmbeddingResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(EmbeddingResult prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<EmbeddingResult, Builder> implements EmbeddingResultOrBuilder {
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
                super(EmbeddingResult.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
            public List<Embedding> getEmbeddingsList() {
                return Collections.unmodifiableList(((EmbeddingResult) this.instance).getEmbeddingsList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
            public int getEmbeddingsCount() {
                return ((EmbeddingResult) this.instance).getEmbeddingsCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
            public Embedding getEmbeddings(int index) {
                return ((EmbeddingResult) this.instance).getEmbeddings(index);
            }

            public Builder setEmbeddings(int index, Embedding value) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).setEmbeddings(index, value);
                return this;
            }

            public Builder setEmbeddings(int index, Embedding.Builder builderForValue) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).setEmbeddings(index, (Embedding) builderForValue.build());
                return this;
            }

            public Builder addEmbeddings(Embedding value) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).addEmbeddings(value);
                return this;
            }

            public Builder addEmbeddings(int index, Embedding value) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).addEmbeddings(index, value);
                return this;
            }

            public Builder addEmbeddings(Embedding.Builder builderForValue) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).addEmbeddings((Embedding) builderForValue.build());
                return this;
            }

            public Builder addEmbeddings(int index, Embedding.Builder builderForValue) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).addEmbeddings(index, (Embedding) builderForValue.build());
                return this;
            }

            public Builder addAllEmbeddings(Iterable<? extends Embedding> values) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).addAllEmbeddings(values);
                return this;
            }

            public Builder clearEmbeddings() {
                copyOnWrite();
                ((EmbeddingResult) this.instance).clearEmbeddings();
                return this;
            }

            public Builder removeEmbeddings(int index) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).removeEmbeddings(index);
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
            public boolean hasTimestampMs() {
                return ((EmbeddingResult) this.instance).hasTimestampMs();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.EmbeddingsProto.EmbeddingResultOrBuilder
            public long getTimestampMs() {
                return ((EmbeddingResult) this.instance).getTimestampMs();
            }

            public Builder setTimestampMs(long value) {
                copyOnWrite();
                ((EmbeddingResult) this.instance).setTimestampMs(value);
                return this;
            }

            public Builder clearTimestampMs() {
                copyOnWrite();
                ((EmbeddingResult) this.instance).clearTimestampMs();
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
                    return new EmbeddingResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဂ\u0000", new Object[]{"bitField0_", "embeddings_", Embedding.class, "timestampMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<EmbeddingResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (EmbeddingResult.class) {
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
            EmbeddingResult embeddingResult = new EmbeddingResult();
            DEFAULT_INSTANCE = embeddingResult;
            GeneratedMessageLite.registerDefaultInstance(EmbeddingResult.class, embeddingResult);
        }

        public static EmbeddingResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EmbeddingResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
