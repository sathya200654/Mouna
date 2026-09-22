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
public final class MatrixDataProto {

    public interface MatrixDataOrBuilder extends MessageLiteOrBuilder {
        int getCols();

        MatrixData.Layout getLayout();

        float getPackedData(int index);

        int getPackedDataCount();

        List<Float> getPackedDataList();

        int getRows();

        boolean hasCols();

        boolean hasLayout();

        boolean hasRows();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private MatrixDataProto() {
    }

    public static final class MatrixData extends GeneratedMessageLite<MatrixData, Builder> implements MatrixDataOrBuilder {
        public static final int COLS_FIELD_NUMBER = 2;
        private static final MatrixData DEFAULT_INSTANCE;
        public static final int LAYOUT_FIELD_NUMBER = 4;
        public static final int PACKED_DATA_FIELD_NUMBER = 3;
        private static volatile Parser<MatrixData> PARSER = null;
        public static final int ROWS_FIELD_NUMBER = 1;
        private int bitField0_;
        private int cols_;
        private int layout_;
        private int packedDataMemoizedSerializedSize = -1;
        private Internal.FloatList packedData_ = emptyFloatList();
        private int rows_;

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

        private MatrixData() {
        }

        public enum Layout implements Internal.EnumLite {
            COLUMN_MAJOR(0),
            ROW_MAJOR(1);

            public static final int COLUMN_MAJOR_VALUE = 0;
            public static final int ROW_MAJOR_VALUE = 1;
            private static final Internal.EnumLiteMap<Layout> internalValueMap = new Internal.EnumLiteMap<Layout>() { // from class: com.google.mediapipe.formats.proto.MatrixDataProto.MatrixData.Layout.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Layout findValueByNumber(int number) {
                    return Layout.forNumber(number);
                }
            };
            private final int value;

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Deprecated
            public static Layout valueOf(int value) {
                return forNumber(value);
            }

            public static Layout forNumber(int value) {
                if (value == 0) {
                    return COLUMN_MAJOR;
                }
                if (value != 1) {
                    return null;
                }
                return ROW_MAJOR;
            }

            public static Internal.EnumLiteMap<Layout> internalGetValueMap() {
                return internalValueMap;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return LayoutVerifier.INSTANCE;
            }

            private static final class LayoutVerifier implements Internal.EnumVerifier {
                static final Internal.EnumVerifier INSTANCE = new LayoutVerifier();

                private LayoutVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int number) {
                    return Layout.forNumber(number) != null;
                }
            }

            Layout(int value) {
                this.value = value;
            }
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public boolean hasRows() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public int getRows() {
            return this.rows_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRows(int value) {
            this.bitField0_ |= 1;
            this.rows_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRows() {
            this.bitField0_ &= -2;
            this.rows_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public boolean hasCols() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public int getCols() {
            return this.cols_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCols(int value) {
            this.bitField0_ |= 2;
            this.cols_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCols() {
            this.bitField0_ &= -3;
            this.cols_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public List<Float> getPackedDataList() {
            return this.packedData_;
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public int getPackedDataCount() {
            return this.packedData_.size();
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public float getPackedData(int index) {
            return this.packedData_.getFloat(index);
        }

        private void ensurePackedDataIsMutable() {
            Internal.FloatList floatList = this.packedData_;
            if (floatList.isModifiable()) {
                return;
            }
            this.packedData_ = GeneratedMessageLite.mutableCopy(floatList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackedData(int index, float value) {
            ensurePackedDataIsMutable();
            this.packedData_.setFloat(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPackedData(float value) {
            ensurePackedDataIsMutable();
            this.packedData_.addFloat(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPackedData(Iterable<? extends Float> values) {
            ensurePackedDataIsMutable();
            AbstractMessageLite.addAll(values, this.packedData_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackedData() {
            this.packedData_ = emptyFloatList();
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public boolean hasLayout() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
        public Layout getLayout() {
            Layout layoutForNumber = Layout.forNumber(this.layout_);
            return layoutForNumber == null ? Layout.COLUMN_MAJOR : layoutForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLayout(Layout value) {
            this.layout_ = value.getNumber();
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLayout() {
            this.bitField0_ &= -5;
            this.layout_ = 0;
        }

        public static MatrixData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MatrixData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MatrixData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MatrixData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MatrixData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MatrixData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MatrixData parseFrom(InputStream input) throws IOException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MatrixData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MatrixData parseDelimitedFrom(InputStream input) throws IOException {
            return (MatrixData) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MatrixData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MatrixData) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MatrixData parseFrom(CodedInputStream input) throws IOException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MatrixData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MatrixData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MatrixData prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MatrixData, Builder> implements MatrixDataOrBuilder {
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
                super(MatrixData.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public boolean hasRows() {
                return ((MatrixData) this.instance).hasRows();
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public int getRows() {
                return ((MatrixData) this.instance).getRows();
            }

            public Builder setRows(int value) {
                copyOnWrite();
                ((MatrixData) this.instance).setRows(value);
                return this;
            }

            public Builder clearRows() {
                copyOnWrite();
                ((MatrixData) this.instance).clearRows();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public boolean hasCols() {
                return ((MatrixData) this.instance).hasCols();
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public int getCols() {
                return ((MatrixData) this.instance).getCols();
            }

            public Builder setCols(int value) {
                copyOnWrite();
                ((MatrixData) this.instance).setCols(value);
                return this;
            }

            public Builder clearCols() {
                copyOnWrite();
                ((MatrixData) this.instance).clearCols();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public List<Float> getPackedDataList() {
                return Collections.unmodifiableList(((MatrixData) this.instance).getPackedDataList());
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public int getPackedDataCount() {
                return ((MatrixData) this.instance).getPackedDataCount();
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public float getPackedData(int index) {
                return ((MatrixData) this.instance).getPackedData(index);
            }

            public Builder setPackedData(int index, float value) {
                copyOnWrite();
                ((MatrixData) this.instance).setPackedData(index, value);
                return this;
            }

            public Builder addPackedData(float value) {
                copyOnWrite();
                ((MatrixData) this.instance).addPackedData(value);
                return this;
            }

            public Builder addAllPackedData(Iterable<? extends Float> values) {
                copyOnWrite();
                ((MatrixData) this.instance).addAllPackedData(values);
                return this;
            }

            public Builder clearPackedData() {
                copyOnWrite();
                ((MatrixData) this.instance).clearPackedData();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public boolean hasLayout() {
                return ((MatrixData) this.instance).hasLayout();
            }

            @Override // com.google.mediapipe.formats.proto.MatrixDataProto.MatrixDataOrBuilder
            public Layout getLayout() {
                return ((MatrixData) this.instance).getLayout();
            }

            public Builder setLayout(Layout value) {
                copyOnWrite();
                ((MatrixData) this.instance).setLayout(value);
                return this;
            }

            public Builder clearLayout() {
                copyOnWrite();
                ((MatrixData) this.instance).clearLayout();
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
                    return new MatrixData();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003$\u0004᠌\u0002", new Object[]{"bitField0_", "rows_", "cols_", "packedData_", "layout_", Layout.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MatrixData> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MatrixData.class) {
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
            MatrixData matrixData = new MatrixData();
            DEFAULT_INSTANCE = matrixData;
            GeneratedMessageLite.registerDefaultInstance(MatrixData.class, matrixData);
        }

        public static MatrixData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MatrixData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.formats.proto.MatrixDataProto$1, reason: invalid class name */
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
