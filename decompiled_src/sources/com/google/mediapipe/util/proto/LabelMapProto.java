package com.google.mediapipe.util.proto;

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
public final class LabelMapProto {

    public interface LabelMapItemOrBuilder extends MessageLiteOrBuilder {
        String getChildName(int index);

        ByteString getChildNameBytes(int index);

        int getChildNameCount();

        List<String> getChildNameList();

        String getDisplayName();

        ByteString getDisplayNameBytes();

        String getName();

        ByteString getNameBytes();

        boolean hasDisplayName();

        boolean hasName();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private LabelMapProto() {
    }

    public static final class LabelMapItem extends GeneratedMessageLite<LabelMapItem, Builder> implements LabelMapItemOrBuilder {
        public static final int CHILD_NAME_FIELD_NUMBER = 3;
        private static final LabelMapItem DEFAULT_INSTANCE;
        public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<LabelMapItem> PARSER;
        private int bitField0_;
        private String name_ = "";
        private String displayName_ = "";
        private Internal.ProtobufList<String> childName_ = GeneratedMessageLite.emptyProtobufList();

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

        private LabelMapItem() {
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.name_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString value) {
            this.name_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public boolean hasDisplayName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public String getDisplayName() {
            return this.displayName_;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public ByteString getDisplayNameBytes() {
            return ByteString.copyFromUtf8(this.displayName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayName(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.displayName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDisplayName() {
            this.bitField0_ &= -3;
            this.displayName_ = getDefaultInstance().getDisplayName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDisplayNameBytes(ByteString value) {
            this.displayName_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public List<String> getChildNameList() {
            return this.childName_;
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public int getChildNameCount() {
            return this.childName_.size();
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public String getChildName(int index) {
            return this.childName_.get(index);
        }

        @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
        public ByteString getChildNameBytes(int index) {
            return ByteString.copyFromUtf8(this.childName_.get(index));
        }

        private void ensureChildNameIsMutable() {
            Internal.ProtobufList<String> protobufList = this.childName_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.childName_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChildName(int index, String value) {
            value.getClass();
            ensureChildNameIsMutable();
            this.childName_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChildName(String value) {
            value.getClass();
            ensureChildNameIsMutable();
            this.childName_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChildName(Iterable<String> values) {
            ensureChildNameIsMutable();
            AbstractMessageLite.addAll(values, this.childName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChildName() {
            this.childName_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChildNameBytes(ByteString value) {
            ensureChildNameIsMutable();
            this.childName_.add(value.toStringUtf8());
        }

        public static LabelMapItem parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LabelMapItem parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LabelMapItem parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LabelMapItem parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LabelMapItem parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static LabelMapItem parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static LabelMapItem parseFrom(InputStream input) throws IOException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LabelMapItem parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LabelMapItem parseDelimitedFrom(InputStream input) throws IOException {
            return (LabelMapItem) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static LabelMapItem parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LabelMapItem) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static LabelMapItem parseFrom(CodedInputStream input) throws IOException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static LabelMapItem parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LabelMapItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(LabelMapItem prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<LabelMapItem, Builder> implements LabelMapItemOrBuilder {
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
                super(LabelMapItem.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public boolean hasName() {
                return ((LabelMapItem) this.instance).hasName();
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public String getName() {
                return ((LabelMapItem) this.instance).getName();
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public ByteString getNameBytes() {
                return ((LabelMapItem) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((LabelMapItem) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).setNameBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public boolean hasDisplayName() {
                return ((LabelMapItem) this.instance).hasDisplayName();
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public String getDisplayName() {
                return ((LabelMapItem) this.instance).getDisplayName();
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public ByteString getDisplayNameBytes() {
                return ((LabelMapItem) this.instance).getDisplayNameBytes();
            }

            public Builder setDisplayName(String value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).setDisplayName(value);
                return this;
            }

            public Builder clearDisplayName() {
                copyOnWrite();
                ((LabelMapItem) this.instance).clearDisplayName();
                return this;
            }

            public Builder setDisplayNameBytes(ByteString value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).setDisplayNameBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public List<String> getChildNameList() {
                return Collections.unmodifiableList(((LabelMapItem) this.instance).getChildNameList());
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public int getChildNameCount() {
                return ((LabelMapItem) this.instance).getChildNameCount();
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public String getChildName(int index) {
                return ((LabelMapItem) this.instance).getChildName(index);
            }

            @Override // com.google.mediapipe.util.proto.LabelMapProto.LabelMapItemOrBuilder
            public ByteString getChildNameBytes(int index) {
                return ((LabelMapItem) this.instance).getChildNameBytes(index);
            }

            public Builder setChildName(int index, String value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).setChildName(index, value);
                return this;
            }

            public Builder addChildName(String value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).addChildName(value);
                return this;
            }

            public Builder addAllChildName(Iterable<String> values) {
                copyOnWrite();
                ((LabelMapItem) this.instance).addAllChildName(values);
                return this;
            }

            public Builder clearChildName() {
                copyOnWrite();
                ((LabelMapItem) this.instance).clearChildName();
                return this;
            }

            public Builder addChildNameBytes(ByteString value) {
                copyOnWrite();
                ((LabelMapItem) this.instance).addChildNameBytes(value);
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
                    return new LabelMapItem();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a", new Object[]{"bitField0_", "name_", "displayName_", "childName_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<LabelMapItem> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (LabelMapItem.class) {
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
            LabelMapItem labelMapItem = new LabelMapItem();
            DEFAULT_INSTANCE = labelMapItem;
            GeneratedMessageLite.registerDefaultInstance(LabelMapItem.class, labelMapItem);
        }

        public static LabelMapItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LabelMapItem> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.util.proto.LabelMapProto$1, reason: invalid class name */
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
