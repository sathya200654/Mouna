package com.google.mediapipe.tasks.core.proto;

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
public final class ExternalFileProto {

    public interface ExternalFileOrBuilder extends MessageLiteOrBuilder {
        ByteString getFileContent();

        FileDescriptorMeta getFileDescriptorMeta();

        String getFileName();

        ByteString getFileNameBytes();

        FilePointerMeta getFilePointerMeta();

        boolean hasFileContent();

        boolean hasFileDescriptorMeta();

        boolean hasFileName();

        boolean hasFilePointerMeta();
    }

    public interface FileDescriptorMetaOrBuilder extends MessageLiteOrBuilder {
        int getFd();

        long getLength();

        long getOffset();

        boolean hasFd();

        boolean hasLength();

        boolean hasOffset();
    }

    public interface FilePointerMetaOrBuilder extends MessageLiteOrBuilder {
        long getLength();

        long getPointer();

        boolean hasLength();

        boolean hasPointer();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private ExternalFileProto() {
    }

    public static final class ExternalFile extends GeneratedMessageLite<ExternalFile, Builder> implements ExternalFileOrBuilder {
        private static final ExternalFile DEFAULT_INSTANCE;
        public static final int FILE_CONTENT_FIELD_NUMBER = 1;
        public static final int FILE_DESCRIPTOR_META_FIELD_NUMBER = 3;
        public static final int FILE_NAME_FIELD_NUMBER = 2;
        public static final int FILE_POINTER_META_FIELD_NUMBER = 4;
        private static volatile Parser<ExternalFile> PARSER;
        private int bitField0_;
        private FileDescriptorMeta fileDescriptorMeta_;
        private FilePointerMeta filePointerMeta_;
        private ByteString fileContent_ = ByteString.EMPTY;
        private String fileName_ = "";

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

        private ExternalFile() {
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public boolean hasFileContent() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public ByteString getFileContent() {
            return this.fileContent_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileContent(ByteString value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.fileContent_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileContent() {
            this.bitField0_ &= -2;
            this.fileContent_ = getDefaultInstance().getFileContent();
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public boolean hasFileName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public String getFileName() {
            return this.fileName_;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public ByteString getFileNameBytes() {
            return ByteString.copyFromUtf8(this.fileName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileName(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.fileName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileName() {
            this.bitField0_ &= -3;
            this.fileName_ = getDefaultInstance().getFileName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileNameBytes(ByteString value) {
            this.fileName_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public boolean hasFileDescriptorMeta() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public FileDescriptorMeta getFileDescriptorMeta() {
            FileDescriptorMeta fileDescriptorMeta = this.fileDescriptorMeta_;
            return fileDescriptorMeta == null ? FileDescriptorMeta.getDefaultInstance() : fileDescriptorMeta;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileDescriptorMeta(FileDescriptorMeta value) {
            value.getClass();
            this.fileDescriptorMeta_ = value;
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFileDescriptorMeta(FileDescriptorMeta value) {
            value.getClass();
            FileDescriptorMeta fileDescriptorMeta = this.fileDescriptorMeta_;
            if (fileDescriptorMeta != null && fileDescriptorMeta != FileDescriptorMeta.getDefaultInstance()) {
                this.fileDescriptorMeta_ = (FileDescriptorMeta) FileDescriptorMeta.newBuilder(this.fileDescriptorMeta_).mergeFrom(value).buildPartial();
            } else {
                this.fileDescriptorMeta_ = value;
            }
            this.bitField0_ |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileDescriptorMeta() {
            this.fileDescriptorMeta_ = null;
            this.bitField0_ &= -5;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public boolean hasFilePointerMeta() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
        public FilePointerMeta getFilePointerMeta() {
            FilePointerMeta filePointerMeta = this.filePointerMeta_;
            return filePointerMeta == null ? FilePointerMeta.getDefaultInstance() : filePointerMeta;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilePointerMeta(FilePointerMeta value) {
            value.getClass();
            this.filePointerMeta_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFilePointerMeta(FilePointerMeta value) {
            value.getClass();
            FilePointerMeta filePointerMeta = this.filePointerMeta_;
            if (filePointerMeta != null && filePointerMeta != FilePointerMeta.getDefaultInstance()) {
                this.filePointerMeta_ = (FilePointerMeta) FilePointerMeta.newBuilder(this.filePointerMeta_).mergeFrom(value).buildPartial();
            } else {
                this.filePointerMeta_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilePointerMeta() {
            this.filePointerMeta_ = null;
            this.bitField0_ &= -9;
        }

        public static ExternalFile parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ExternalFile parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ExternalFile parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ExternalFile parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ExternalFile parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ExternalFile parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ExternalFile parseFrom(InputStream input) throws IOException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ExternalFile parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ExternalFile parseDelimitedFrom(InputStream input) throws IOException {
            return (ExternalFile) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ExternalFile parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExternalFile) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ExternalFile parseFrom(CodedInputStream input) throws IOException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ExternalFile parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ExternalFile) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExternalFile prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ExternalFile, Builder> implements ExternalFileOrBuilder {
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
                super(ExternalFile.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public boolean hasFileContent() {
                return ((ExternalFile) this.instance).hasFileContent();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public ByteString getFileContent() {
                return ((ExternalFile) this.instance).getFileContent();
            }

            public Builder setFileContent(ByteString value) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFileContent(value);
                return this;
            }

            public Builder clearFileContent() {
                copyOnWrite();
                ((ExternalFile) this.instance).clearFileContent();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public boolean hasFileName() {
                return ((ExternalFile) this.instance).hasFileName();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public String getFileName() {
                return ((ExternalFile) this.instance).getFileName();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public ByteString getFileNameBytes() {
                return ((ExternalFile) this.instance).getFileNameBytes();
            }

            public Builder setFileName(String value) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFileName(value);
                return this;
            }

            public Builder clearFileName() {
                copyOnWrite();
                ((ExternalFile) this.instance).clearFileName();
                return this;
            }

            public Builder setFileNameBytes(ByteString value) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFileNameBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public boolean hasFileDescriptorMeta() {
                return ((ExternalFile) this.instance).hasFileDescriptorMeta();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public FileDescriptorMeta getFileDescriptorMeta() {
                return ((ExternalFile) this.instance).getFileDescriptorMeta();
            }

            public Builder setFileDescriptorMeta(FileDescriptorMeta value) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFileDescriptorMeta(value);
                return this;
            }

            public Builder setFileDescriptorMeta(FileDescriptorMeta.Builder builderForValue) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFileDescriptorMeta((FileDescriptorMeta) builderForValue.build());
                return this;
            }

            public Builder mergeFileDescriptorMeta(FileDescriptorMeta value) {
                copyOnWrite();
                ((ExternalFile) this.instance).mergeFileDescriptorMeta(value);
                return this;
            }

            public Builder clearFileDescriptorMeta() {
                copyOnWrite();
                ((ExternalFile) this.instance).clearFileDescriptorMeta();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public boolean hasFilePointerMeta() {
                return ((ExternalFile) this.instance).hasFilePointerMeta();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.ExternalFileOrBuilder
            public FilePointerMeta getFilePointerMeta() {
                return ((ExternalFile) this.instance).getFilePointerMeta();
            }

            public Builder setFilePointerMeta(FilePointerMeta value) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFilePointerMeta(value);
                return this;
            }

            public Builder setFilePointerMeta(FilePointerMeta.Builder builderForValue) {
                copyOnWrite();
                ((ExternalFile) this.instance).setFilePointerMeta((FilePointerMeta) builderForValue.build());
                return this;
            }

            public Builder mergeFilePointerMeta(FilePointerMeta value) {
                copyOnWrite();
                ((ExternalFile) this.instance).mergeFilePointerMeta(value);
                return this;
            }

            public Builder clearFilePointerMeta() {
                copyOnWrite();
                ((ExternalFile) this.instance).clearFilePointerMeta();
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
                    return new ExternalFile();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"bitField0_", "fileContent_", "fileName_", "fileDescriptorMeta_", "filePointerMeta_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<ExternalFile> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (ExternalFile.class) {
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
            ExternalFile externalFile = new ExternalFile();
            DEFAULT_INSTANCE = externalFile;
            GeneratedMessageLite.registerDefaultInstance(ExternalFile.class, externalFile);
        }

        public static ExternalFile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExternalFile> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.core.proto.ExternalFileProto$1, reason: invalid class name */
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

    public static final class FileDescriptorMeta extends GeneratedMessageLite<FileDescriptorMeta, Builder> implements FileDescriptorMetaOrBuilder {
        private static final FileDescriptorMeta DEFAULT_INSTANCE;
        public static final int FD_FIELD_NUMBER = 1;
        public static final int LENGTH_FIELD_NUMBER = 2;
        public static final int OFFSET_FIELD_NUMBER = 3;
        private static volatile Parser<FileDescriptorMeta> PARSER;
        private int bitField0_;
        private int fd_;
        private long length_;
        private long offset_;

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

        private FileDescriptorMeta() {
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
        public boolean hasFd() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
        public int getFd() {
            return this.fd_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFd(int value) {
            this.bitField0_ |= 1;
            this.fd_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFd() {
            this.bitField0_ &= -2;
            this.fd_ = 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
        public boolean hasLength() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
        public long getLength() {
            return this.length_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLength(long value) {
            this.bitField0_ |= 2;
            this.length_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLength() {
            this.bitField0_ &= -3;
            this.length_ = 0L;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
        public boolean hasOffset() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
        public long getOffset() {
            return this.offset_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOffset(long value) {
            this.bitField0_ |= 4;
            this.offset_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOffset() {
            this.bitField0_ &= -5;
            this.offset_ = 0L;
        }

        public static FileDescriptorMeta parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorMeta parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorMeta parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorMeta parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorMeta parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FileDescriptorMeta parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FileDescriptorMeta parseFrom(InputStream input) throws IOException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorMeta parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileDescriptorMeta parseDelimitedFrom(InputStream input) throws IOException {
            return (FileDescriptorMeta) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorMeta parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorMeta) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FileDescriptorMeta parseFrom(CodedInputStream input) throws IOException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FileDescriptorMeta parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FileDescriptorMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FileDescriptorMeta prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FileDescriptorMeta, Builder> implements FileDescriptorMetaOrBuilder {
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
                super(FileDescriptorMeta.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
            public boolean hasFd() {
                return ((FileDescriptorMeta) this.instance).hasFd();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
            public int getFd() {
                return ((FileDescriptorMeta) this.instance).getFd();
            }

            public Builder setFd(int value) {
                copyOnWrite();
                ((FileDescriptorMeta) this.instance).setFd(value);
                return this;
            }

            public Builder clearFd() {
                copyOnWrite();
                ((FileDescriptorMeta) this.instance).clearFd();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
            public boolean hasLength() {
                return ((FileDescriptorMeta) this.instance).hasLength();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
            public long getLength() {
                return ((FileDescriptorMeta) this.instance).getLength();
            }

            public Builder setLength(long value) {
                copyOnWrite();
                ((FileDescriptorMeta) this.instance).setLength(value);
                return this;
            }

            public Builder clearLength() {
                copyOnWrite();
                ((FileDescriptorMeta) this.instance).clearLength();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
            public boolean hasOffset() {
                return ((FileDescriptorMeta) this.instance).hasOffset();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FileDescriptorMetaOrBuilder
            public long getOffset() {
                return ((FileDescriptorMeta) this.instance).getOffset();
            }

            public Builder setOffset(long value) {
                copyOnWrite();
                ((FileDescriptorMeta) this.instance).setOffset(value);
                return this;
            }

            public Builder clearOffset() {
                copyOnWrite();
                ((FileDescriptorMeta) this.instance).clearOffset();
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
                    return new FileDescriptorMeta();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"bitField0_", "fd_", "length_", "offset_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FileDescriptorMeta> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FileDescriptorMeta.class) {
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
            FileDescriptorMeta fileDescriptorMeta = new FileDescriptorMeta();
            DEFAULT_INSTANCE = fileDescriptorMeta;
            GeneratedMessageLite.registerDefaultInstance(FileDescriptorMeta.class, fileDescriptorMeta);
        }

        public static FileDescriptorMeta getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FileDescriptorMeta> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class FilePointerMeta extends GeneratedMessageLite<FilePointerMeta, Builder> implements FilePointerMetaOrBuilder {
        private static final FilePointerMeta DEFAULT_INSTANCE;
        public static final int LENGTH_FIELD_NUMBER = 2;
        private static volatile Parser<FilePointerMeta> PARSER = null;
        public static final int POINTER_FIELD_NUMBER = 1;
        private int bitField0_;
        private long length_;
        private long pointer_;

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

        private FilePointerMeta() {
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
        public boolean hasPointer() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
        public long getPointer() {
            return this.pointer_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPointer(long value) {
            this.bitField0_ |= 1;
            this.pointer_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPointer() {
            this.bitField0_ &= -2;
            this.pointer_ = 0L;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
        public boolean hasLength() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
        public long getLength() {
            return this.length_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLength(long value) {
            this.bitField0_ |= 2;
            this.length_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLength() {
            this.bitField0_ &= -3;
            this.length_ = 0L;
        }

        public static FilePointerMeta parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FilePointerMeta parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FilePointerMeta parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FilePointerMeta parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FilePointerMeta parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static FilePointerMeta parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static FilePointerMeta parseFrom(InputStream input) throws IOException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FilePointerMeta parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FilePointerMeta parseDelimitedFrom(InputStream input) throws IOException {
            return (FilePointerMeta) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static FilePointerMeta parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FilePointerMeta) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static FilePointerMeta parseFrom(CodedInputStream input) throws IOException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static FilePointerMeta parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FilePointerMeta) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(FilePointerMeta prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<FilePointerMeta, Builder> implements FilePointerMetaOrBuilder {
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
                super(FilePointerMeta.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
            public boolean hasPointer() {
                return ((FilePointerMeta) this.instance).hasPointer();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
            public long getPointer() {
                return ((FilePointerMeta) this.instance).getPointer();
            }

            public Builder setPointer(long value) {
                copyOnWrite();
                ((FilePointerMeta) this.instance).setPointer(value);
                return this;
            }

            public Builder clearPointer() {
                copyOnWrite();
                ((FilePointerMeta) this.instance).clearPointer();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
            public boolean hasLength() {
                return ((FilePointerMeta) this.instance).hasLength();
            }

            @Override // com.google.mediapipe.tasks.core.proto.ExternalFileProto.FilePointerMetaOrBuilder
            public long getLength() {
                return ((FilePointerMeta) this.instance).getLength();
            }

            public Builder setLength(long value) {
                copyOnWrite();
                ((FilePointerMeta) this.instance).setLength(value);
                return this;
            }

            public Builder clearLength() {
                copyOnWrite();
                ((FilePointerMeta) this.instance).clearLength();
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
                    return new FilePointerMeta();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဂ\u0001", new Object[]{"bitField0_", "pointer_", "length_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FilePointerMeta> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (FilePointerMeta.class) {
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
            FilePointerMeta filePointerMeta = new FilePointerMeta();
            DEFAULT_INSTANCE = filePointerMeta;
            GeneratedMessageLite.registerDefaultInstance(FilePointerMeta.class, filePointerMeta);
        }

        public static FilePointerMeta getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FilePointerMeta> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
