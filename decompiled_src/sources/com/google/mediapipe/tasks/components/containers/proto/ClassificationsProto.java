package com.google.mediapipe.tasks.components.containers.proto;

import com.google.mediapipe.formats.proto.ClassificationProto;
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
public final class ClassificationsProto {

    public interface ClassificationResultOrBuilder extends MessageLiteOrBuilder {
        Classifications getClassifications(int index);

        int getClassificationsCount();

        List<Classifications> getClassificationsList();

        long getTimestampMs();

        boolean hasTimestampMs();
    }

    public interface ClassificationsOrBuilder extends MessageLiteOrBuilder {
        ClassificationProto.ClassificationList getClassificationList();

        int getHeadIndex();

        String getHeadName();

        ByteString getHeadNameBytes();

        boolean hasClassificationList();

        boolean hasHeadIndex();

        boolean hasHeadName();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private ClassificationsProto() {
    }

    public static final class Classifications extends GeneratedMessageLite<Classifications, Builder> implements ClassificationsOrBuilder {
        public static final int CLASSIFICATION_LIST_FIELD_NUMBER = 4;
        private static final Classifications DEFAULT_INSTANCE;
        public static final int HEAD_INDEX_FIELD_NUMBER = 2;
        public static final int HEAD_NAME_FIELD_NUMBER = 3;
        private static volatile Parser<Classifications> PARSER;
        private int bitField0_;
        private ClassificationProto.ClassificationList classificationList_;
        private int headIndex_;
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

        private Classifications() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public boolean hasClassificationList() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public ClassificationProto.ClassificationList getClassificationList() {
            ClassificationProto.ClassificationList classificationList = this.classificationList_;
            return classificationList == null ? ClassificationProto.ClassificationList.getDefaultInstance() : classificationList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassificationList(ClassificationProto.ClassificationList value) {
            value.getClass();
            this.classificationList_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClassificationList(ClassificationProto.ClassificationList value) {
            value.getClass();
            ClassificationProto.ClassificationList classificationList = this.classificationList_;
            if (classificationList != null && classificationList != ClassificationProto.ClassificationList.getDefaultInstance()) {
                this.classificationList_ = (ClassificationProto.ClassificationList) ClassificationProto.ClassificationList.newBuilder(this.classificationList_).mergeFrom(value).buildPartial();
            } else {
                this.classificationList_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassificationList() {
            this.classificationList_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public boolean hasHeadIndex() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public int getHeadIndex() {
            return this.headIndex_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadIndex(int value) {
            this.bitField0_ |= 2;
            this.headIndex_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeadIndex() {
            this.bitField0_ &= -3;
            this.headIndex_ = 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public boolean hasHeadName() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public String getHeadName() {
            return this.headName_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
        public ByteString getHeadNameBytes() {
            return ByteString.copyFromUtf8(this.headName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadName(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.headName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHeadName() {
            this.bitField0_ &= -5;
            this.headName_ = getDefaultInstance().getHeadName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeadNameBytes(ByteString value) {
            this.headName_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static Classifications parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Classifications parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Classifications parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Classifications parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Classifications parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Classifications parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Classifications parseFrom(InputStream input) throws IOException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Classifications parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Classifications parseDelimitedFrom(InputStream input) throws IOException {
            return (Classifications) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Classifications parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Classifications) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Classifications parseFrom(CodedInputStream input) throws IOException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Classifications parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Classifications) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Classifications prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Classifications, Builder> implements ClassificationsOrBuilder {
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
                super(Classifications.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public boolean hasClassificationList() {
                return ((Classifications) this.instance).hasClassificationList();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public ClassificationProto.ClassificationList getClassificationList() {
                return ((Classifications) this.instance).getClassificationList();
            }

            public Builder setClassificationList(ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((Classifications) this.instance).setClassificationList(value);
                return this;
            }

            public Builder setClassificationList(ClassificationProto.ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((Classifications) this.instance).setClassificationList((ClassificationProto.ClassificationList) builderForValue.build());
                return this;
            }

            public Builder mergeClassificationList(ClassificationProto.ClassificationList value) {
                copyOnWrite();
                ((Classifications) this.instance).mergeClassificationList(value);
                return this;
            }

            public Builder clearClassificationList() {
                copyOnWrite();
                ((Classifications) this.instance).clearClassificationList();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public boolean hasHeadIndex() {
                return ((Classifications) this.instance).hasHeadIndex();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public int getHeadIndex() {
                return ((Classifications) this.instance).getHeadIndex();
            }

            public Builder setHeadIndex(int value) {
                copyOnWrite();
                ((Classifications) this.instance).setHeadIndex(value);
                return this;
            }

            public Builder clearHeadIndex() {
                copyOnWrite();
                ((Classifications) this.instance).clearHeadIndex();
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public boolean hasHeadName() {
                return ((Classifications) this.instance).hasHeadName();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public String getHeadName() {
                return ((Classifications) this.instance).getHeadName();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationsOrBuilder
            public ByteString getHeadNameBytes() {
                return ((Classifications) this.instance).getHeadNameBytes();
            }

            public Builder setHeadName(String value) {
                copyOnWrite();
                ((Classifications) this.instance).setHeadName(value);
                return this;
            }

            public Builder clearHeadName() {
                copyOnWrite();
                ((Classifications) this.instance).clearHeadName();
                return this;
            }

            public Builder setHeadNameBytes(ByteString value) {
                copyOnWrite();
                ((Classifications) this.instance).setHeadNameBytes(value);
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
                    return new Classifications();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0002\u0004\u0003\u0000\u0000\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဉ\u0000", new Object[]{"bitField0_", "headIndex_", "headName_", "classificationList_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Classifications> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Classifications.class) {
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
            Classifications classifications = new Classifications();
            DEFAULT_INSTANCE = classifications;
            GeneratedMessageLite.registerDefaultInstance(Classifications.class, classifications);
        }

        public static Classifications getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Classifications> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto$1, reason: invalid class name */
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

    public static final class ClassificationResult extends GeneratedMessageLite<ClassificationResult, Builder> implements ClassificationResultOrBuilder {
        public static final int CLASSIFICATIONS_FIELD_NUMBER = 1;
        private static final ClassificationResult DEFAULT_INSTANCE;
        private static volatile Parser<ClassificationResult> PARSER = null;
        public static final int TIMESTAMP_MS_FIELD_NUMBER = 2;
        private int bitField0_;
        private Internal.ProtobufList<Classifications> classifications_ = emptyProtobufList();
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

        private ClassificationResult() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
        public List<Classifications> getClassificationsList() {
            return this.classifications_;
        }

        public List<? extends ClassificationsOrBuilder> getClassificationsOrBuilderList() {
            return this.classifications_;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
        public int getClassificationsCount() {
            return this.classifications_.size();
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
        public Classifications getClassifications(int index) {
            return this.classifications_.get(index);
        }

        public ClassificationsOrBuilder getClassificationsOrBuilder(int index) {
            return this.classifications_.get(index);
        }

        private void ensureClassificationsIsMutable() {
            Internal.ProtobufList<Classifications> protobufList = this.classifications_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.classifications_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassifications(int index, Classifications value) {
            value.getClass();
            ensureClassificationsIsMutable();
            this.classifications_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassifications(Classifications value) {
            value.getClass();
            ensureClassificationsIsMutable();
            this.classifications_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassifications(int index, Classifications value) {
            value.getClass();
            ensureClassificationsIsMutable();
            this.classifications_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllClassifications(Iterable<? extends Classifications> values) {
            ensureClassificationsIsMutable();
            AbstractMessageLite.addAll(values, this.classifications_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassifications() {
            this.classifications_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeClassifications(int index) {
            ensureClassificationsIsMutable();
            this.classifications_.remove(index);
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
        public boolean hasTimestampMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
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

        public static ClassificationResult parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationResult parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationResult parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationResult parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationResult parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationResult parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationResult parseFrom(InputStream input) throws IOException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationResult parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ClassificationResult parseDelimitedFrom(InputStream input) throws IOException {
            return (ClassificationResult) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationResult parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationResult) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ClassificationResult parseFrom(CodedInputStream input) throws IOException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationResult parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClassificationResult prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClassificationResult, Builder> implements ClassificationResultOrBuilder {
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
                super(ClassificationResult.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
            public List<Classifications> getClassificationsList() {
                return Collections.unmodifiableList(((ClassificationResult) this.instance).getClassificationsList());
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
            public int getClassificationsCount() {
                return ((ClassificationResult) this.instance).getClassificationsCount();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
            public Classifications getClassifications(int index) {
                return ((ClassificationResult) this.instance).getClassifications(index);
            }

            public Builder setClassifications(int index, Classifications value) {
                copyOnWrite();
                ((ClassificationResult) this.instance).setClassifications(index, value);
                return this;
            }

            public Builder setClassifications(int index, Classifications.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationResult) this.instance).setClassifications(index, (Classifications) builderForValue.build());
                return this;
            }

            public Builder addClassifications(Classifications value) {
                copyOnWrite();
                ((ClassificationResult) this.instance).addClassifications(value);
                return this;
            }

            public Builder addClassifications(int index, Classifications value) {
                copyOnWrite();
                ((ClassificationResult) this.instance).addClassifications(index, value);
                return this;
            }

            public Builder addClassifications(Classifications.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationResult) this.instance).addClassifications((Classifications) builderForValue.build());
                return this;
            }

            public Builder addClassifications(int index, Classifications.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationResult) this.instance).addClassifications(index, (Classifications) builderForValue.build());
                return this;
            }

            public Builder addAllClassifications(Iterable<? extends Classifications> values) {
                copyOnWrite();
                ((ClassificationResult) this.instance).addAllClassifications(values);
                return this;
            }

            public Builder clearClassifications() {
                copyOnWrite();
                ((ClassificationResult) this.instance).clearClassifications();
                return this;
            }

            public Builder removeClassifications(int index) {
                copyOnWrite();
                ((ClassificationResult) this.instance).removeClassifications(index);
                return this;
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
            public boolean hasTimestampMs() {
                return ((ClassificationResult) this.instance).hasTimestampMs();
            }

            @Override // com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto.ClassificationResultOrBuilder
            public long getTimestampMs() {
                return ((ClassificationResult) this.instance).getTimestampMs();
            }

            public Builder setTimestampMs(long value) {
                copyOnWrite();
                ((ClassificationResult) this.instance).setTimestampMs(value);
                return this;
            }

            public Builder clearTimestampMs() {
                copyOnWrite();
                ((ClassificationResult) this.instance).clearTimestampMs();
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
                    return new ClassificationResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဂ\u0000", new Object[]{"bitField0_", "classifications_", Classifications.class, "timestampMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClassificationResult> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ClassificationResult.class) {
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
            ClassificationResult classificationResult = new ClassificationResult();
            DEFAULT_INSTANCE = classificationResult;
            GeneratedMessageLite.registerDefaultInstance(ClassificationResult.class, classificationResult);
        }

        public static ClassificationResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClassificationResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
