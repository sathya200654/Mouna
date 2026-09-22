package com.google.mediapipe.formats.proto;

import androidx.room.util.TableInfo;
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
public final class ClassificationProto {

    public interface ClassificationListCollectionOrBuilder extends MessageLiteOrBuilder {
        ClassificationList getClassificationList(int index);

        int getClassificationListCount();

        List<ClassificationList> getClassificationListList();
    }

    public interface ClassificationListOrBuilder extends MessageLiteOrBuilder {
        Classification getClassification(int index);

        int getClassificationCount();

        List<Classification> getClassificationList();
    }

    public interface ClassificationOrBuilder extends MessageLiteOrBuilder {
        String getDisplayName();

        ByteString getDisplayNameBytes();

        int getIndex();

        String getLabel();

        ByteString getLabelBytes();

        float getScore();

        boolean hasDisplayName();

        boolean hasIndex();

        boolean hasLabel();

        boolean hasScore();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private ClassificationProto() {
    }

    public static final class Classification extends GeneratedMessageLite<Classification, Builder> implements ClassificationOrBuilder {
        private static final Classification DEFAULT_INSTANCE;
        public static final int DISPLAY_NAME_FIELD_NUMBER = 4;
        public static final int INDEX_FIELD_NUMBER = 1;
        public static final int LABEL_FIELD_NUMBER = 3;
        private static volatile Parser<Classification> PARSER = null;
        public static final int SCORE_FIELD_NUMBER = 2;
        private int bitField0_;
        private int index_;
        private float score_;
        private String label_ = "";
        private String displayName_ = "";

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

        private Classification() {
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public boolean hasIndex() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public int getIndex() {
            return this.index_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIndex(int value) {
            this.bitField0_ |= 1;
            this.index_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIndex() {
            this.bitField0_ &= -2;
            this.index_ = 0;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public boolean hasScore() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public float getScore() {
            return this.score_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScore(float value) {
            this.bitField0_ |= 2;
            this.score_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScore() {
            this.bitField0_ &= -3;
            this.score_ = 0.0f;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public boolean hasLabel() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public String getLabel() {
            return this.label_;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public ByteString getLabelBytes() {
            return ByteString.copyFromUtf8(this.label_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLabel(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.label_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLabel() {
            this.bitField0_ &= -5;
            this.label_ = getDefaultInstance().getLabel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLabelBytes(ByteString value) {
            this.label_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public boolean hasDisplayName() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public String getDisplayName() {
            return this.displayName_;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
        public ByteString getDisplayNameBytes() {
            return ByteString.copyFromUtf8(this.displayName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayName(String value) {
            value.getClass();
            this.bitField0_ |= 8;
            this.displayName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDisplayName() {
            this.bitField0_ &= -9;
            this.displayName_ = getDefaultInstance().getDisplayName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayNameBytes(ByteString value) {
            this.displayName_ = value.toStringUtf8();
            this.bitField0_ |= 8;
        }

        public static Classification parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Classification parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Classification parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Classification parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Classification parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Classification parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Classification parseFrom(InputStream input) throws IOException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Classification parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Classification parseDelimitedFrom(InputStream input) throws IOException {
            return (Classification) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Classification parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Classification) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Classification parseFrom(CodedInputStream input) throws IOException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Classification parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Classification) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Classification prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Classification, Builder> implements ClassificationOrBuilder {
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
                super(Classification.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public boolean hasIndex() {
                return ((Classification) this.instance).hasIndex();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public int getIndex() {
                return ((Classification) this.instance).getIndex();
            }

            public Builder setIndex(int value) {
                copyOnWrite();
                ((Classification) this.instance).setIndex(value);
                return this;
            }

            public Builder clearIndex() {
                copyOnWrite();
                ((Classification) this.instance).clearIndex();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public boolean hasScore() {
                return ((Classification) this.instance).hasScore();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public float getScore() {
                return ((Classification) this.instance).getScore();
            }

            public Builder setScore(float value) {
                copyOnWrite();
                ((Classification) this.instance).setScore(value);
                return this;
            }

            public Builder clearScore() {
                copyOnWrite();
                ((Classification) this.instance).clearScore();
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public boolean hasLabel() {
                return ((Classification) this.instance).hasLabel();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public String getLabel() {
                return ((Classification) this.instance).getLabel();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public ByteString getLabelBytes() {
                return ((Classification) this.instance).getLabelBytes();
            }

            public Builder setLabel(String value) {
                copyOnWrite();
                ((Classification) this.instance).setLabel(value);
                return this;
            }

            public Builder clearLabel() {
                copyOnWrite();
                ((Classification) this.instance).clearLabel();
                return this;
            }

            public Builder setLabelBytes(ByteString value) {
                copyOnWrite();
                ((Classification) this.instance).setLabelBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public boolean hasDisplayName() {
                return ((Classification) this.instance).hasDisplayName();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public String getDisplayName() {
                return ((Classification) this.instance).getDisplayName();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationOrBuilder
            public ByteString getDisplayNameBytes() {
                return ((Classification) this.instance).getDisplayNameBytes();
            }

            public Builder setDisplayName(String value) {
                copyOnWrite();
                ((Classification) this.instance).setDisplayName(value);
                return this;
            }

            public Builder clearDisplayName() {
                copyOnWrite();
                ((Classification) this.instance).clearDisplayName();
                return this;
            }

            public Builder setDisplayNameBytes(ByteString value) {
                copyOnWrite();
                ((Classification) this.instance).setDisplayNameBytes(value);
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
                    return new Classification();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"bitField0_", TableInfo.Index.DEFAULT_PREFIX, "score_", "label_", "displayName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Classification> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Classification.class) {
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
            Classification classification = new Classification();
            DEFAULT_INSTANCE = classification;
            GeneratedMessageLite.registerDefaultInstance(Classification.class, classification);
        }

        public static Classification getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Classification> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.formats.proto.ClassificationProto$1, reason: invalid class name */
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

    public static final class ClassificationList extends GeneratedMessageLite<ClassificationList, Builder> implements ClassificationListOrBuilder {
        public static final int CLASSIFICATION_FIELD_NUMBER = 1;
        private static final ClassificationList DEFAULT_INSTANCE;
        private static volatile Parser<ClassificationList> PARSER;
        private Internal.ProtobufList<Classification> classification_ = emptyProtobufList();

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

        private ClassificationList() {
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListOrBuilder
        public List<Classification> getClassificationList() {
            return this.classification_;
        }

        public List<? extends ClassificationOrBuilder> getClassificationOrBuilderList() {
            return this.classification_;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListOrBuilder
        public int getClassificationCount() {
            return this.classification_.size();
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListOrBuilder
        public Classification getClassification(int index) {
            return this.classification_.get(index);
        }

        public ClassificationOrBuilder getClassificationOrBuilder(int index) {
            return this.classification_.get(index);
        }

        private void ensureClassificationIsMutable() {
            Internal.ProtobufList<Classification> protobufList = this.classification_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.classification_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassification(int index, Classification value) {
            value.getClass();
            ensureClassificationIsMutable();
            this.classification_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassification(Classification value) {
            value.getClass();
            ensureClassificationIsMutable();
            this.classification_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassification(int index, Classification value) {
            value.getClass();
            ensureClassificationIsMutable();
            this.classification_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllClassification(Iterable<? extends Classification> values) {
            ensureClassificationIsMutable();
            AbstractMessageLite.addAll(values, this.classification_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassification() {
            this.classification_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeClassification(int index) {
            ensureClassificationIsMutable();
            this.classification_.remove(index);
        }

        public static ClassificationList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationList parseFrom(InputStream input) throws IOException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ClassificationList parseDelimitedFrom(InputStream input) throws IOException {
            return (ClassificationList) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationList) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ClassificationList parseFrom(CodedInputStream input) throws IOException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClassificationList prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClassificationList, Builder> implements ClassificationListOrBuilder {
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
                super(ClassificationList.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListOrBuilder
            public List<Classification> getClassificationList() {
                return Collections.unmodifiableList(((ClassificationList) this.instance).getClassificationList());
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListOrBuilder
            public int getClassificationCount() {
                return ((ClassificationList) this.instance).getClassificationCount();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListOrBuilder
            public Classification getClassification(int index) {
                return ((ClassificationList) this.instance).getClassification(index);
            }

            public Builder setClassification(int index, Classification value) {
                copyOnWrite();
                ((ClassificationList) this.instance).setClassification(index, value);
                return this;
            }

            public Builder setClassification(int index, Classification.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationList) this.instance).setClassification(index, (Classification) builderForValue.build());
                return this;
            }

            public Builder addClassification(Classification value) {
                copyOnWrite();
                ((ClassificationList) this.instance).addClassification(value);
                return this;
            }

            public Builder addClassification(int index, Classification value) {
                copyOnWrite();
                ((ClassificationList) this.instance).addClassification(index, value);
                return this;
            }

            public Builder addClassification(Classification.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationList) this.instance).addClassification((Classification) builderForValue.build());
                return this;
            }

            public Builder addClassification(int index, Classification.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationList) this.instance).addClassification(index, (Classification) builderForValue.build());
                return this;
            }

            public Builder addAllClassification(Iterable<? extends Classification> values) {
                copyOnWrite();
                ((ClassificationList) this.instance).addAllClassification(values);
                return this;
            }

            public Builder clearClassification() {
                copyOnWrite();
                ((ClassificationList) this.instance).clearClassification();
                return this;
            }

            public Builder removeClassification(int index) {
                copyOnWrite();
                ((ClassificationList) this.instance).removeClassification(index);
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
                    return new ClassificationList();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"classification_", Classification.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClassificationList> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ClassificationList.class) {
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
            ClassificationList classificationList = new ClassificationList();
            DEFAULT_INSTANCE = classificationList;
            GeneratedMessageLite.registerDefaultInstance(ClassificationList.class, classificationList);
        }

        public static ClassificationList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClassificationList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ClassificationListCollection extends GeneratedMessageLite<ClassificationListCollection, Builder> implements ClassificationListCollectionOrBuilder {
        public static final int CLASSIFICATION_LIST_FIELD_NUMBER = 1;
        private static final ClassificationListCollection DEFAULT_INSTANCE;
        private static volatile Parser<ClassificationListCollection> PARSER;
        private Internal.ProtobufList<ClassificationList> classificationList_ = emptyProtobufList();

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

        private ClassificationListCollection() {
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListCollectionOrBuilder
        public List<ClassificationList> getClassificationListList() {
            return this.classificationList_;
        }

        public List<? extends ClassificationListOrBuilder> getClassificationListOrBuilderList() {
            return this.classificationList_;
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListCollectionOrBuilder
        public int getClassificationListCount() {
            return this.classificationList_.size();
        }

        @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListCollectionOrBuilder
        public ClassificationList getClassificationList(int index) {
            return this.classificationList_.get(index);
        }

        public ClassificationListOrBuilder getClassificationListOrBuilder(int index) {
            return this.classificationList_.get(index);
        }

        private void ensureClassificationListIsMutable() {
            Internal.ProtobufList<ClassificationList> protobufList = this.classificationList_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.classificationList_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClassificationList(int index, ClassificationList value) {
            value.getClass();
            ensureClassificationListIsMutable();
            this.classificationList_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassificationList(ClassificationList value) {
            value.getClass();
            ensureClassificationListIsMutable();
            this.classificationList_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClassificationList(int index, ClassificationList value) {
            value.getClass();
            ensureClassificationListIsMutable();
            this.classificationList_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllClassificationList(Iterable<? extends ClassificationList> values) {
            ensureClassificationListIsMutable();
            AbstractMessageLite.addAll(values, this.classificationList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClassificationList() {
            this.classificationList_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeClassificationList(int index) {
            ensureClassificationListIsMutable();
            this.classificationList_.remove(index);
        }

        public static ClassificationListCollection parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationListCollection parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationListCollection parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationListCollection parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationListCollection parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ClassificationListCollection parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ClassificationListCollection parseFrom(InputStream input) throws IOException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationListCollection parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ClassificationListCollection parseDelimitedFrom(InputStream input) throws IOException {
            return (ClassificationListCollection) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationListCollection parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationListCollection) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ClassificationListCollection parseFrom(CodedInputStream input) throws IOException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ClassificationListCollection parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClassificationListCollection) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ClassificationListCollection prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ClassificationListCollection, Builder> implements ClassificationListCollectionOrBuilder {
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
                super(ClassificationListCollection.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListCollectionOrBuilder
            public List<ClassificationList> getClassificationListList() {
                return Collections.unmodifiableList(((ClassificationListCollection) this.instance).getClassificationListList());
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListCollectionOrBuilder
            public int getClassificationListCount() {
                return ((ClassificationListCollection) this.instance).getClassificationListCount();
            }

            @Override // com.google.mediapipe.formats.proto.ClassificationProto.ClassificationListCollectionOrBuilder
            public ClassificationList getClassificationList(int index) {
                return ((ClassificationListCollection) this.instance).getClassificationList(index);
            }

            public Builder setClassificationList(int index, ClassificationList value) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).setClassificationList(index, value);
                return this;
            }

            public Builder setClassificationList(int index, ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).setClassificationList(index, (ClassificationList) builderForValue.build());
                return this;
            }

            public Builder addClassificationList(ClassificationList value) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).addClassificationList(value);
                return this;
            }

            public Builder addClassificationList(int index, ClassificationList value) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).addClassificationList(index, value);
                return this;
            }

            public Builder addClassificationList(ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).addClassificationList((ClassificationList) builderForValue.build());
                return this;
            }

            public Builder addClassificationList(int index, ClassificationList.Builder builderForValue) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).addClassificationList(index, (ClassificationList) builderForValue.build());
                return this;
            }

            public Builder addAllClassificationList(Iterable<? extends ClassificationList> values) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).addAllClassificationList(values);
                return this;
            }

            public Builder clearClassificationList() {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).clearClassificationList();
                return this;
            }

            public Builder removeClassificationList(int index) {
                copyOnWrite();
                ((ClassificationListCollection) this.instance).removeClassificationList(index);
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
                    return new ClassificationListCollection();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"classificationList_", ClassificationList.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ClassificationListCollection> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ClassificationListCollection.class) {
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
            ClassificationListCollection classificationListCollection = new ClassificationListCollection();
            DEFAULT_INSTANCE = classificationListCollection;
            GeneratedMessageLite.registerDefaultInstance(ClassificationListCollection.class, classificationListCollection);
        }

        public static ClassificationListCollection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClassificationListCollection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
