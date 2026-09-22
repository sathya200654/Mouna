package com.google.mediapipe.proto;

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
public final class MediaPipeLoggingProto {

    public interface MediaPipeLogExtensionOrBuilder extends MessageLiteOrBuilder {
        SolutionEvent getSolutionEvent();

        SystemInfo getSystemInfo();

        boolean hasSolutionEvent();

        boolean hasSystemInfo();
    }

    public interface SolutionErrorOrBuilder extends MessageLiteOrBuilder {
        MediaPipeLoggingEnumsProto.ErrorCode getErrorCode();

        boolean hasErrorCode();
    }

    public interface SolutionEventOrBuilder extends MessageLiteOrBuilder {
        SolutionError getErrorDetails();

        SolutionEvent.EventDetailsCase getEventDetailsCase();

        MediaPipeLoggingEnumsProto.EventName getEventName();

        SolutionInvocationReport getInvocationReport();

        SolutionSessionClone getSessionClone();

        SolutionSessionEnd getSessionEnd();

        SolutionSessionStart getSessionStart();

        MediaPipeLoggingEnumsProto.SolutionName getSolutionName();

        boolean hasErrorDetails();

        boolean hasEventName();

        boolean hasInvocationReport();

        boolean hasSessionClone();

        boolean hasSessionEnd();

        boolean hasSessionStart();

        boolean hasSolutionName();
    }

    public interface SolutionInvocationCountOrBuilder extends MessageLiteOrBuilder {
        long getCount();

        MediaPipeLoggingEnumsProto.InputDataType getInputDataType();

        boolean hasCount();

        boolean hasInputDataType();
    }

    public interface SolutionInvocationReportOrBuilder extends MessageLiteOrBuilder {
        long getDropped();

        long getElapsedTimeMs();

        SolutionInvocationCount getInvocationCount(int index);

        int getInvocationCountCount();

        List<SolutionInvocationCount> getInvocationCountList();

        MediaPipeLoggingEnumsProto.SolutionMode getMode();

        long getPipelineAverageLatencyMs();

        long getPipelinePeakLatencyMs();

        boolean hasDropped();

        boolean hasElapsedTimeMs();

        boolean hasMode();

        boolean hasPipelineAverageLatencyMs();

        boolean hasPipelinePeakLatencyMs();
    }

    public interface SolutionSessionCloneOrBuilder extends MessageLiteOrBuilder {
        String getGraphName();

        ByteString getGraphNameBytes();

        long getInitLatencyMs();

        MediaPipeLoggingEnumsProto.SolutionMode getMode();

        boolean hasGraphName();

        boolean hasInitLatencyMs();

        boolean hasMode();
    }

    public interface SolutionSessionEndOrBuilder extends MessageLiteOrBuilder {
        SolutionInvocationReport getInvocationReport();

        boolean hasInvocationReport();
    }

    public interface SolutionSessionStartOrBuilder extends MessageLiteOrBuilder {
        String getGraphName();

        ByteString getGraphNameBytes();

        long getInitLatencyMs();

        MediaPipeLoggingEnumsProto.SolutionMode getMode();

        boolean hasGraphName();

        boolean hasInitLatencyMs();

        boolean hasMode();
    }

    public interface SystemInfoOrBuilder extends MessageLiteOrBuilder {
        String getAppId();

        ByteString getAppIdBytes();

        String getAppVersion();

        ByteString getAppVersionBytes();

        MediaPipeLoggingEnumsProto.HostEnvironment getHostEnvironment();

        String getHostVersion();

        ByteString getHostVersionBytes();

        String getMediapipeVersion();

        ByteString getMediapipeVersionBytes();

        MediaPipeLoggingEnumsProto.Platform getPlatform();

        boolean hasAppId();

        boolean hasAppVersion();

        boolean hasHostEnvironment();

        boolean hasHostVersion();

        boolean hasMediapipeVersion();

        boolean hasPlatform();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private MediaPipeLoggingProto() {
    }

    public static final class MediaPipeLogExtension extends GeneratedMessageLite<MediaPipeLogExtension, Builder> implements MediaPipeLogExtensionOrBuilder {
        private static final MediaPipeLogExtension DEFAULT_INSTANCE;
        private static volatile Parser<MediaPipeLogExtension> PARSER = null;
        public static final int SOLUTION_EVENT_FIELD_NUMBER = 2;
        public static final int SYSTEM_INFO_FIELD_NUMBER = 1;
        private int bitField0_;
        private SolutionEvent solutionEvent_;
        private SystemInfo systemInfo_;

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

        private MediaPipeLogExtension() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
        public boolean hasSystemInfo() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
        public SystemInfo getSystemInfo() {
            SystemInfo systemInfo = this.systemInfo_;
            return systemInfo == null ? SystemInfo.getDefaultInstance() : systemInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSystemInfo(SystemInfo value) {
            value.getClass();
            this.systemInfo_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSystemInfo(SystemInfo value) {
            value.getClass();
            SystemInfo systemInfo = this.systemInfo_;
            if (systemInfo != null && systemInfo != SystemInfo.getDefaultInstance()) {
                this.systemInfo_ = (SystemInfo) SystemInfo.newBuilder(this.systemInfo_).mergeFrom(value).buildPartial();
            } else {
                this.systemInfo_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSystemInfo() {
            this.systemInfo_ = null;
            this.bitField0_ &= -2;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
        public boolean hasSolutionEvent() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
        public SolutionEvent getSolutionEvent() {
            SolutionEvent solutionEvent = this.solutionEvent_;
            return solutionEvent == null ? SolutionEvent.getDefaultInstance() : solutionEvent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSolutionEvent(SolutionEvent value) {
            value.getClass();
            this.solutionEvent_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSolutionEvent(SolutionEvent value) {
            value.getClass();
            SolutionEvent solutionEvent = this.solutionEvent_;
            if (solutionEvent != null && solutionEvent != SolutionEvent.getDefaultInstance()) {
                this.solutionEvent_ = (SolutionEvent) SolutionEvent.newBuilder(this.solutionEvent_).mergeFrom(value).buildPartial();
            } else {
                this.solutionEvent_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSolutionEvent() {
            this.solutionEvent_ = null;
            this.bitField0_ &= -3;
        }

        public static MediaPipeLogExtension parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MediaPipeLogExtension parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MediaPipeLogExtension parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MediaPipeLogExtension parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MediaPipeLogExtension parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static MediaPipeLogExtension parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static MediaPipeLogExtension parseFrom(InputStream input) throws IOException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MediaPipeLogExtension parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MediaPipeLogExtension parseDelimitedFrom(InputStream input) throws IOException {
            return (MediaPipeLogExtension) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static MediaPipeLogExtension parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MediaPipeLogExtension) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static MediaPipeLogExtension parseFrom(CodedInputStream input) throws IOException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static MediaPipeLogExtension parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MediaPipeLogExtension) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MediaPipeLogExtension prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MediaPipeLogExtension, Builder> implements MediaPipeLogExtensionOrBuilder {
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
                super(MediaPipeLogExtension.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
            public boolean hasSystemInfo() {
                return ((MediaPipeLogExtension) this.instance).hasSystemInfo();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
            public SystemInfo getSystemInfo() {
                return ((MediaPipeLogExtension) this.instance).getSystemInfo();
            }

            public Builder setSystemInfo(SystemInfo value) {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).setSystemInfo(value);
                return this;
            }

            public Builder setSystemInfo(SystemInfo.Builder builderForValue) {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).setSystemInfo((SystemInfo) builderForValue.build());
                return this;
            }

            public Builder mergeSystemInfo(SystemInfo value) {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).mergeSystemInfo(value);
                return this;
            }

            public Builder clearSystemInfo() {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).clearSystemInfo();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
            public boolean hasSolutionEvent() {
                return ((MediaPipeLogExtension) this.instance).hasSolutionEvent();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.MediaPipeLogExtensionOrBuilder
            public SolutionEvent getSolutionEvent() {
                return ((MediaPipeLogExtension) this.instance).getSolutionEvent();
            }

            public Builder setSolutionEvent(SolutionEvent value) {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).setSolutionEvent(value);
                return this;
            }

            public Builder setSolutionEvent(SolutionEvent.Builder builderForValue) {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).setSolutionEvent((SolutionEvent) builderForValue.build());
                return this;
            }

            public Builder mergeSolutionEvent(SolutionEvent value) {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).mergeSolutionEvent(value);
                return this;
            }

            public Builder clearSolutionEvent() {
                copyOnWrite();
                ((MediaPipeLogExtension) this.instance).clearSolutionEvent();
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
                    return new MediaPipeLogExtension();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "systemInfo_", "solutionEvent_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MediaPipeLogExtension> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (MediaPipeLogExtension.class) {
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
            MediaPipeLogExtension mediaPipeLogExtension = new MediaPipeLogExtension();
            DEFAULT_INSTANCE = mediaPipeLogExtension;
            GeneratedMessageLite.registerDefaultInstance(MediaPipeLogExtension.class, mediaPipeLogExtension);
        }

        public static MediaPipeLogExtension getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MediaPipeLogExtension> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.proto.MediaPipeLoggingProto$1, reason: invalid class name */
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

    public static final class SystemInfo extends GeneratedMessageLite<SystemInfo, Builder> implements SystemInfoOrBuilder {
        public static final int APP_ID_FIELD_NUMBER = 2;
        public static final int APP_VERSION_FIELD_NUMBER = 3;
        private static final SystemInfo DEFAULT_INSTANCE;
        public static final int HOST_ENVIRONMENT_FIELD_NUMBER = 6;
        public static final int HOST_VERSION_FIELD_NUMBER = 5;
        public static final int MEDIAPIPE_VERSION_FIELD_NUMBER = 4;
        private static volatile Parser<SystemInfo> PARSER = null;
        public static final int PLATFORM_FIELD_NUMBER = 1;
        private int bitField0_;
        private int hostEnvironment_;
        private int platform_;
        private String appId_ = "";
        private String appVersion_ = "";
        private String mediapipeVersion_ = "";
        private String hostVersion_ = "";

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

        private SystemInfo() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public boolean hasPlatform() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public MediaPipeLoggingEnumsProto.Platform getPlatform() {
            MediaPipeLoggingEnumsProto.Platform platformForNumber = MediaPipeLoggingEnumsProto.Platform.forNumber(this.platform_);
            return platformForNumber == null ? MediaPipeLoggingEnumsProto.Platform.PLATFORM_UNKNOWN : platformForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlatform(MediaPipeLoggingEnumsProto.Platform value) {
            this.platform_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPlatform() {
            this.bitField0_ &= -2;
            this.platform_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public boolean hasAppId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public String getAppId() {
            return this.appId_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppId(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.appId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppId() {
            this.bitField0_ &= -3;
            this.appId_ = getDefaultInstance().getAppId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppIdBytes(ByteString value) {
            this.appId_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public boolean hasAppVersion() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public String getAppVersion() {
            return this.appVersion_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public ByteString getAppVersionBytes() {
            return ByteString.copyFromUtf8(this.appVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersion(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.appVersion_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppVersion() {
            this.bitField0_ &= -5;
            this.appVersion_ = getDefaultInstance().getAppVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppVersionBytes(ByteString value) {
            this.appVersion_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public boolean hasMediapipeVersion() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public String getMediapipeVersion() {
            return this.mediapipeVersion_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public ByteString getMediapipeVersionBytes() {
            return ByteString.copyFromUtf8(this.mediapipeVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMediapipeVersion(String value) {
            value.getClass();
            this.bitField0_ |= 8;
            this.mediapipeVersion_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMediapipeVersion() {
            this.bitField0_ &= -9;
            this.mediapipeVersion_ = getDefaultInstance().getMediapipeVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMediapipeVersionBytes(ByteString value) {
            this.mediapipeVersion_ = value.toStringUtf8();
            this.bitField0_ |= 8;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public boolean hasHostVersion() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public String getHostVersion() {
            return this.hostVersion_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public ByteString getHostVersionBytes() {
            return ByteString.copyFromUtf8(this.hostVersion_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHostVersion(String value) {
            value.getClass();
            this.bitField0_ |= 16;
            this.hostVersion_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHostVersion() {
            this.bitField0_ &= -17;
            this.hostVersion_ = getDefaultInstance().getHostVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHostVersionBytes(ByteString value) {
            this.hostVersion_ = value.toStringUtf8();
            this.bitField0_ |= 16;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public boolean hasHostEnvironment() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
        public MediaPipeLoggingEnumsProto.HostEnvironment getHostEnvironment() {
            MediaPipeLoggingEnumsProto.HostEnvironment hostEnvironmentForNumber = MediaPipeLoggingEnumsProto.HostEnvironment.forNumber(this.hostEnvironment_);
            return hostEnvironmentForNumber == null ? MediaPipeLoggingEnumsProto.HostEnvironment.HOST_ENVIRONMENT_UNKNOWN : hostEnvironmentForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHostEnvironment(MediaPipeLoggingEnumsProto.HostEnvironment value) {
            this.hostEnvironment_ = value.getNumber();
            this.bitField0_ |= 32;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHostEnvironment() {
            this.bitField0_ &= -33;
            this.hostEnvironment_ = 0;
        }

        public static SystemInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SystemInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SystemInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SystemInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SystemInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SystemInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SystemInfo parseFrom(InputStream input) throws IOException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SystemInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SystemInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SystemInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SystemInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SystemInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SystemInfo parseFrom(CodedInputStream input) throws IOException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SystemInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SystemInfo prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SystemInfo, Builder> implements SystemInfoOrBuilder {
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
                super(SystemInfo.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public boolean hasPlatform() {
                return ((SystemInfo) this.instance).hasPlatform();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public MediaPipeLoggingEnumsProto.Platform getPlatform() {
                return ((SystemInfo) this.instance).getPlatform();
            }

            public Builder setPlatform(MediaPipeLoggingEnumsProto.Platform value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setPlatform(value);
                return this;
            }

            public Builder clearPlatform() {
                copyOnWrite();
                ((SystemInfo) this.instance).clearPlatform();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public boolean hasAppId() {
                return ((SystemInfo) this.instance).hasAppId();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public String getAppId() {
                return ((SystemInfo) this.instance).getAppId();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public ByteString getAppIdBytes() {
                return ((SystemInfo) this.instance).getAppIdBytes();
            }

            public Builder setAppId(String value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setAppId(value);
                return this;
            }

            public Builder clearAppId() {
                copyOnWrite();
                ((SystemInfo) this.instance).clearAppId();
                return this;
            }

            public Builder setAppIdBytes(ByteString value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setAppIdBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public boolean hasAppVersion() {
                return ((SystemInfo) this.instance).hasAppVersion();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public String getAppVersion() {
                return ((SystemInfo) this.instance).getAppVersion();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public ByteString getAppVersionBytes() {
                return ((SystemInfo) this.instance).getAppVersionBytes();
            }

            public Builder setAppVersion(String value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setAppVersion(value);
                return this;
            }

            public Builder clearAppVersion() {
                copyOnWrite();
                ((SystemInfo) this.instance).clearAppVersion();
                return this;
            }

            public Builder setAppVersionBytes(ByteString value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setAppVersionBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public boolean hasMediapipeVersion() {
                return ((SystemInfo) this.instance).hasMediapipeVersion();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public String getMediapipeVersion() {
                return ((SystemInfo) this.instance).getMediapipeVersion();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public ByteString getMediapipeVersionBytes() {
                return ((SystemInfo) this.instance).getMediapipeVersionBytes();
            }

            public Builder setMediapipeVersion(String value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setMediapipeVersion(value);
                return this;
            }

            public Builder clearMediapipeVersion() {
                copyOnWrite();
                ((SystemInfo) this.instance).clearMediapipeVersion();
                return this;
            }

            public Builder setMediapipeVersionBytes(ByteString value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setMediapipeVersionBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public boolean hasHostVersion() {
                return ((SystemInfo) this.instance).hasHostVersion();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public String getHostVersion() {
                return ((SystemInfo) this.instance).getHostVersion();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public ByteString getHostVersionBytes() {
                return ((SystemInfo) this.instance).getHostVersionBytes();
            }

            public Builder setHostVersion(String value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setHostVersion(value);
                return this;
            }

            public Builder clearHostVersion() {
                copyOnWrite();
                ((SystemInfo) this.instance).clearHostVersion();
                return this;
            }

            public Builder setHostVersionBytes(ByteString value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setHostVersionBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public boolean hasHostEnvironment() {
                return ((SystemInfo) this.instance).hasHostEnvironment();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SystemInfoOrBuilder
            public MediaPipeLoggingEnumsProto.HostEnvironment getHostEnvironment() {
                return ((SystemInfo) this.instance).getHostEnvironment();
            }

            public Builder setHostEnvironment(MediaPipeLoggingEnumsProto.HostEnvironment value) {
                copyOnWrite();
                ((SystemInfo) this.instance).setHostEnvironment(value);
                return this;
            }

            public Builder clearHostEnvironment() {
                copyOnWrite();
                ((SystemInfo) this.instance).clearHostEnvironment();
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
                    return new SystemInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006᠌\u0005", new Object[]{"bitField0_", "platform_", MediaPipeLoggingEnumsProto.Platform.internalGetVerifier(), "appId_", "appVersion_", "mediapipeVersion_", "hostVersion_", "hostEnvironment_", MediaPipeLoggingEnumsProto.HostEnvironment.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SystemInfo> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SystemInfo.class) {
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
            SystemInfo systemInfo = new SystemInfo();
            DEFAULT_INSTANCE = systemInfo;
            GeneratedMessageLite.registerDefaultInstance(SystemInfo.class, systemInfo);
        }

        public static SystemInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SystemInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionEvent extends GeneratedMessageLite<SolutionEvent, Builder> implements SolutionEventOrBuilder {
        private static final SolutionEvent DEFAULT_INSTANCE;
        public static final int ERROR_DETAILS_FIELD_NUMBER = 6;
        public static final int EVENT_NAME_FIELD_NUMBER = 2;
        public static final int INVOCATION_REPORT_FIELD_NUMBER = 4;
        private static volatile Parser<SolutionEvent> PARSER = null;
        public static final int SESSION_CLONE_FIELD_NUMBER = 7;
        public static final int SESSION_END_FIELD_NUMBER = 5;
        public static final int SESSION_START_FIELD_NUMBER = 3;
        public static final int SOLUTION_NAME_FIELD_NUMBER = 1;
        private int bitField0_;
        private int eventDetailsCase_ = 0;
        private Object eventDetails_;
        private int eventName_;
        private int solutionName_;

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

        private SolutionEvent() {
        }

        public enum EventDetailsCase {
            SESSION_START(3),
            INVOCATION_REPORT(4),
            SESSION_END(5),
            ERROR_DETAILS(6),
            SESSION_CLONE(7),
            EVENTDETAILS_NOT_SET(0);

            private final int value;

            EventDetailsCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static EventDetailsCase valueOf(int value) {
                return forNumber(value);
            }

            public static EventDetailsCase forNumber(int value) {
                if (value == 0) {
                    return EVENTDETAILS_NOT_SET;
                }
                if (value == 3) {
                    return SESSION_START;
                }
                if (value == 4) {
                    return INVOCATION_REPORT;
                }
                if (value == 5) {
                    return SESSION_END;
                }
                if (value == 6) {
                    return ERROR_DETAILS;
                }
                if (value != 7) {
                    return null;
                }
                return SESSION_CLONE;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public EventDetailsCase getEventDetailsCase() {
            return EventDetailsCase.forNumber(this.eventDetailsCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventDetails() {
            this.eventDetailsCase_ = 0;
            this.eventDetails_ = null;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasSolutionName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public MediaPipeLoggingEnumsProto.SolutionName getSolutionName() {
            MediaPipeLoggingEnumsProto.SolutionName solutionNameForNumber = MediaPipeLoggingEnumsProto.SolutionName.forNumber(this.solutionName_);
            return solutionNameForNumber == null ? MediaPipeLoggingEnumsProto.SolutionName.SOLUTION_UNKNOWN : solutionNameForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSolutionName(MediaPipeLoggingEnumsProto.SolutionName value) {
            this.solutionName_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSolutionName() {
            this.bitField0_ &= -2;
            this.solutionName_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasEventName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public MediaPipeLoggingEnumsProto.EventName getEventName() {
            MediaPipeLoggingEnumsProto.EventName eventNameForNumber = MediaPipeLoggingEnumsProto.EventName.forNumber(this.eventName_);
            return eventNameForNumber == null ? MediaPipeLoggingEnumsProto.EventName.EVENT_START : eventNameForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEventName(MediaPipeLoggingEnumsProto.EventName value) {
            this.eventName_ = value.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEventName() {
            this.bitField0_ &= -3;
            this.eventName_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasSessionStart() {
            return this.eventDetailsCase_ == 3;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public SolutionSessionStart getSessionStart() {
            if (this.eventDetailsCase_ == 3) {
                return (SolutionSessionStart) this.eventDetails_;
            }
            return SolutionSessionStart.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionStart(SolutionSessionStart value) {
            value.getClass();
            this.eventDetails_ = value;
            this.eventDetailsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSessionStart(SolutionSessionStart value) {
            value.getClass();
            if (this.eventDetailsCase_ == 3 && this.eventDetails_ != SolutionSessionStart.getDefaultInstance()) {
                this.eventDetails_ = SolutionSessionStart.newBuilder((SolutionSessionStart) this.eventDetails_).mergeFrom(value).buildPartial();
            } else {
                this.eventDetails_ = value;
            }
            this.eventDetailsCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionStart() {
            if (this.eventDetailsCase_ == 3) {
                this.eventDetailsCase_ = 0;
                this.eventDetails_ = null;
            }
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasInvocationReport() {
            return this.eventDetailsCase_ == 4;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public SolutionInvocationReport getInvocationReport() {
            if (this.eventDetailsCase_ == 4) {
                return (SolutionInvocationReport) this.eventDetails_;
            }
            return SolutionInvocationReport.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInvocationReport(SolutionInvocationReport value) {
            value.getClass();
            this.eventDetails_ = value;
            this.eventDetailsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInvocationReport(SolutionInvocationReport value) {
            value.getClass();
            if (this.eventDetailsCase_ == 4 && this.eventDetails_ != SolutionInvocationReport.getDefaultInstance()) {
                this.eventDetails_ = SolutionInvocationReport.newBuilder((SolutionInvocationReport) this.eventDetails_).mergeFrom(value).buildPartial();
            } else {
                this.eventDetails_ = value;
            }
            this.eventDetailsCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInvocationReport() {
            if (this.eventDetailsCase_ == 4) {
                this.eventDetailsCase_ = 0;
                this.eventDetails_ = null;
            }
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasSessionEnd() {
            return this.eventDetailsCase_ == 5;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public SolutionSessionEnd getSessionEnd() {
            if (this.eventDetailsCase_ == 5) {
                return (SolutionSessionEnd) this.eventDetails_;
            }
            return SolutionSessionEnd.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionEnd(SolutionSessionEnd value) {
            value.getClass();
            this.eventDetails_ = value;
            this.eventDetailsCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSessionEnd(SolutionSessionEnd value) {
            value.getClass();
            if (this.eventDetailsCase_ == 5 && this.eventDetails_ != SolutionSessionEnd.getDefaultInstance()) {
                this.eventDetails_ = SolutionSessionEnd.newBuilder((SolutionSessionEnd) this.eventDetails_).mergeFrom(value).buildPartial();
            } else {
                this.eventDetails_ = value;
            }
            this.eventDetailsCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionEnd() {
            if (this.eventDetailsCase_ == 5) {
                this.eventDetailsCase_ = 0;
                this.eventDetails_ = null;
            }
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasErrorDetails() {
            return this.eventDetailsCase_ == 6;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public SolutionError getErrorDetails() {
            if (this.eventDetailsCase_ == 6) {
                return (SolutionError) this.eventDetails_;
            }
            return SolutionError.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorDetails(SolutionError value) {
            value.getClass();
            this.eventDetails_ = value;
            this.eventDetailsCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeErrorDetails(SolutionError value) {
            value.getClass();
            if (this.eventDetailsCase_ == 6 && this.eventDetails_ != SolutionError.getDefaultInstance()) {
                this.eventDetails_ = SolutionError.newBuilder((SolutionError) this.eventDetails_).mergeFrom(value).buildPartial();
            } else {
                this.eventDetails_ = value;
            }
            this.eventDetailsCase_ = 6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorDetails() {
            if (this.eventDetailsCase_ == 6) {
                this.eventDetailsCase_ = 0;
                this.eventDetails_ = null;
            }
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public boolean hasSessionClone() {
            return this.eventDetailsCase_ == 7;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
        public SolutionSessionClone getSessionClone() {
            if (this.eventDetailsCase_ == 7) {
                return (SolutionSessionClone) this.eventDetails_;
            }
            return SolutionSessionClone.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionClone(SolutionSessionClone value) {
            value.getClass();
            this.eventDetails_ = value;
            this.eventDetailsCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSessionClone(SolutionSessionClone value) {
            value.getClass();
            if (this.eventDetailsCase_ == 7 && this.eventDetails_ != SolutionSessionClone.getDefaultInstance()) {
                this.eventDetails_ = SolutionSessionClone.newBuilder((SolutionSessionClone) this.eventDetails_).mergeFrom(value).buildPartial();
            } else {
                this.eventDetails_ = value;
            }
            this.eventDetailsCase_ = 7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionClone() {
            if (this.eventDetailsCase_ == 7) {
                this.eventDetailsCase_ = 0;
                this.eventDetails_ = null;
            }
        }

        public static SolutionEvent parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionEvent parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionEvent parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionEvent parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionEvent parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionEvent parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionEvent parseFrom(InputStream input) throws IOException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionEvent parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionEvent parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionEvent) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionEvent parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionEvent) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionEvent parseFrom(CodedInputStream input) throws IOException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionEvent parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionEvent prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionEvent, Builder> implements SolutionEventOrBuilder {
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
                super(SolutionEvent.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public EventDetailsCase getEventDetailsCase() {
                return ((SolutionEvent) this.instance).getEventDetailsCase();
            }

            public Builder clearEventDetails() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearEventDetails();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasSolutionName() {
                return ((SolutionEvent) this.instance).hasSolutionName();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public MediaPipeLoggingEnumsProto.SolutionName getSolutionName() {
                return ((SolutionEvent) this.instance).getSolutionName();
            }

            public Builder setSolutionName(MediaPipeLoggingEnumsProto.SolutionName value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSolutionName(value);
                return this;
            }

            public Builder clearSolutionName() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearSolutionName();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasEventName() {
                return ((SolutionEvent) this.instance).hasEventName();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public MediaPipeLoggingEnumsProto.EventName getEventName() {
                return ((SolutionEvent) this.instance).getEventName();
            }

            public Builder setEventName(MediaPipeLoggingEnumsProto.EventName value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setEventName(value);
                return this;
            }

            public Builder clearEventName() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearEventName();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasSessionStart() {
                return ((SolutionEvent) this.instance).hasSessionStart();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public SolutionSessionStart getSessionStart() {
                return ((SolutionEvent) this.instance).getSessionStart();
            }

            public Builder setSessionStart(SolutionSessionStart value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSessionStart(value);
                return this;
            }

            public Builder setSessionStart(SolutionSessionStart.Builder builderForValue) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSessionStart((SolutionSessionStart) builderForValue.build());
                return this;
            }

            public Builder mergeSessionStart(SolutionSessionStart value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).mergeSessionStart(value);
                return this;
            }

            public Builder clearSessionStart() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearSessionStart();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasInvocationReport() {
                return ((SolutionEvent) this.instance).hasInvocationReport();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public SolutionInvocationReport getInvocationReport() {
                return ((SolutionEvent) this.instance).getInvocationReport();
            }

            public Builder setInvocationReport(SolutionInvocationReport value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setInvocationReport(value);
                return this;
            }

            public Builder setInvocationReport(SolutionInvocationReport.Builder builderForValue) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setInvocationReport((SolutionInvocationReport) builderForValue.build());
                return this;
            }

            public Builder mergeInvocationReport(SolutionInvocationReport value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).mergeInvocationReport(value);
                return this;
            }

            public Builder clearInvocationReport() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearInvocationReport();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasSessionEnd() {
                return ((SolutionEvent) this.instance).hasSessionEnd();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public SolutionSessionEnd getSessionEnd() {
                return ((SolutionEvent) this.instance).getSessionEnd();
            }

            public Builder setSessionEnd(SolutionSessionEnd value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSessionEnd(value);
                return this;
            }

            public Builder setSessionEnd(SolutionSessionEnd.Builder builderForValue) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSessionEnd((SolutionSessionEnd) builderForValue.build());
                return this;
            }

            public Builder mergeSessionEnd(SolutionSessionEnd value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).mergeSessionEnd(value);
                return this;
            }

            public Builder clearSessionEnd() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearSessionEnd();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasErrorDetails() {
                return ((SolutionEvent) this.instance).hasErrorDetails();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public SolutionError getErrorDetails() {
                return ((SolutionEvent) this.instance).getErrorDetails();
            }

            public Builder setErrorDetails(SolutionError value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setErrorDetails(value);
                return this;
            }

            public Builder setErrorDetails(SolutionError.Builder builderForValue) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setErrorDetails((SolutionError) builderForValue.build());
                return this;
            }

            public Builder mergeErrorDetails(SolutionError value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).mergeErrorDetails(value);
                return this;
            }

            public Builder clearErrorDetails() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearErrorDetails();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public boolean hasSessionClone() {
                return ((SolutionEvent) this.instance).hasSessionClone();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionEventOrBuilder
            public SolutionSessionClone getSessionClone() {
                return ((SolutionEvent) this.instance).getSessionClone();
            }

            public Builder setSessionClone(SolutionSessionClone value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSessionClone(value);
                return this;
            }

            public Builder setSessionClone(SolutionSessionClone.Builder builderForValue) {
                copyOnWrite();
                ((SolutionEvent) this.instance).setSessionClone((SolutionSessionClone) builderForValue.build());
                return this;
            }

            public Builder mergeSessionClone(SolutionSessionClone value) {
                copyOnWrite();
                ((SolutionEvent) this.instance).mergeSessionClone(value);
                return this;
            }

            public Builder clearSessionClone() {
                copyOnWrite();
                ((SolutionEvent) this.instance).clearSessionClone();
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
                    return new SolutionEvent();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"eventDetails_", "eventDetailsCase_", "bitField0_", "solutionName_", MediaPipeLoggingEnumsProto.SolutionName.internalGetVerifier(), "eventName_", MediaPipeLoggingEnumsProto.EventName.internalGetVerifier(), SolutionSessionStart.class, SolutionInvocationReport.class, SolutionSessionEnd.class, SolutionError.class, SolutionSessionClone.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionEvent> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionEvent.class) {
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
            SolutionEvent solutionEvent = new SolutionEvent();
            DEFAULT_INSTANCE = solutionEvent;
            GeneratedMessageLite.registerDefaultInstance(SolutionEvent.class, solutionEvent);
        }

        public static SolutionEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionInvocationCount extends GeneratedMessageLite<SolutionInvocationCount, Builder> implements SolutionInvocationCountOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 2;
        private static final SolutionInvocationCount DEFAULT_INSTANCE;
        public static final int INPUT_DATA_TYPE_FIELD_NUMBER = 1;
        private static volatile Parser<SolutionInvocationCount> PARSER;
        private int bitField0_;
        private long count_;
        private int inputDataType_;

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

        private SolutionInvocationCount() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
        public boolean hasInputDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
        public MediaPipeLoggingEnumsProto.InputDataType getInputDataType() {
            MediaPipeLoggingEnumsProto.InputDataType inputDataTypeForNumber = MediaPipeLoggingEnumsProto.InputDataType.forNumber(this.inputDataType_);
            return inputDataTypeForNumber == null ? MediaPipeLoggingEnumsProto.InputDataType.INPUT_TYPE_UNKNOWN : inputDataTypeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputDataType(MediaPipeLoggingEnumsProto.InputDataType value) {
            this.inputDataType_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInputDataType() {
            this.bitField0_ &= -2;
            this.inputDataType_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
        public boolean hasCount() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
        public long getCount() {
            return this.count_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(long value) {
            this.bitField0_ |= 2;
            this.count_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.bitField0_ &= -3;
            this.count_ = 0L;
        }

        public static SolutionInvocationCount parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionInvocationCount parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionInvocationCount parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionInvocationCount parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionInvocationCount parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionInvocationCount parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionInvocationCount parseFrom(InputStream input) throws IOException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionInvocationCount parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionInvocationCount parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionInvocationCount) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionInvocationCount parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionInvocationCount) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionInvocationCount parseFrom(CodedInputStream input) throws IOException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionInvocationCount parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionInvocationCount) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionInvocationCount prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionInvocationCount, Builder> implements SolutionInvocationCountOrBuilder {
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
                super(SolutionInvocationCount.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
            public boolean hasInputDataType() {
                return ((SolutionInvocationCount) this.instance).hasInputDataType();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
            public MediaPipeLoggingEnumsProto.InputDataType getInputDataType() {
                return ((SolutionInvocationCount) this.instance).getInputDataType();
            }

            public Builder setInputDataType(MediaPipeLoggingEnumsProto.InputDataType value) {
                copyOnWrite();
                ((SolutionInvocationCount) this.instance).setInputDataType(value);
                return this;
            }

            public Builder clearInputDataType() {
                copyOnWrite();
                ((SolutionInvocationCount) this.instance).clearInputDataType();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
            public boolean hasCount() {
                return ((SolutionInvocationCount) this.instance).hasCount();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationCountOrBuilder
            public long getCount() {
                return ((SolutionInvocationCount) this.instance).getCount();
            }

            public Builder setCount(long value) {
                copyOnWrite();
                ((SolutionInvocationCount) this.instance).setCount(value);
                return this;
            }

            public Builder clearCount() {
                copyOnWrite();
                ((SolutionInvocationCount) this.instance).clearCount();
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
                    return new SolutionInvocationCount();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"bitField0_", "inputDataType_", MediaPipeLoggingEnumsProto.InputDataType.internalGetVerifier(), "count_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionInvocationCount> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionInvocationCount.class) {
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
            SolutionInvocationCount solutionInvocationCount = new SolutionInvocationCount();
            DEFAULT_INSTANCE = solutionInvocationCount;
            GeneratedMessageLite.registerDefaultInstance(SolutionInvocationCount.class, solutionInvocationCount);
        }

        public static SolutionInvocationCount getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionInvocationCount> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionSessionStart extends GeneratedMessageLite<SolutionSessionStart, Builder> implements SolutionSessionStartOrBuilder {
        private static final SolutionSessionStart DEFAULT_INSTANCE;
        public static final int GRAPH_NAME_FIELD_NUMBER = 2;
        public static final int INIT_LATENCY_MS_FIELD_NUMBER = 3;
        public static final int MODE_FIELD_NUMBER = 1;
        private static volatile Parser<SolutionSessionStart> PARSER;
        private int bitField0_;
        private String graphName_ = "";
        private long initLatencyMs_;
        private int mode_;

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

        private SolutionSessionStart() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public boolean hasMode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public MediaPipeLoggingEnumsProto.SolutionMode getMode() {
            MediaPipeLoggingEnumsProto.SolutionMode solutionModeForNumber = MediaPipeLoggingEnumsProto.SolutionMode.forNumber(this.mode_);
            return solutionModeForNumber == null ? MediaPipeLoggingEnumsProto.SolutionMode.MODE_UNKNOWN : solutionModeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMode(MediaPipeLoggingEnumsProto.SolutionMode value) {
            this.mode_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMode() {
            this.bitField0_ &= -2;
            this.mode_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public boolean hasGraphName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public String getGraphName() {
            return this.graphName_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public ByteString getGraphNameBytes() {
            return ByteString.copyFromUtf8(this.graphName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGraphName(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.graphName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGraphName() {
            this.bitField0_ &= -3;
            this.graphName_ = getDefaultInstance().getGraphName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGraphNameBytes(ByteString value) {
            this.graphName_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public boolean hasInitLatencyMs() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
        public long getInitLatencyMs() {
            return this.initLatencyMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInitLatencyMs(long value) {
            this.bitField0_ |= 4;
            this.initLatencyMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInitLatencyMs() {
            this.bitField0_ &= -5;
            this.initLatencyMs_ = 0L;
        }

        public static SolutionSessionStart parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionStart parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionStart parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionStart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionStart parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionStart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionStart parseFrom(InputStream input) throws IOException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionStart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionSessionStart parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionSessionStart) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionStart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionStart) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionSessionStart parseFrom(CodedInputStream input) throws IOException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionStart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionStart) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionSessionStart prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionSessionStart, Builder> implements SolutionSessionStartOrBuilder {
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
                super(SolutionSessionStart.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public boolean hasMode() {
                return ((SolutionSessionStart) this.instance).hasMode();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public MediaPipeLoggingEnumsProto.SolutionMode getMode() {
                return ((SolutionSessionStart) this.instance).getMode();
            }

            public Builder setMode(MediaPipeLoggingEnumsProto.SolutionMode value) {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).setMode(value);
                return this;
            }

            public Builder clearMode() {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).clearMode();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public boolean hasGraphName() {
                return ((SolutionSessionStart) this.instance).hasGraphName();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public String getGraphName() {
                return ((SolutionSessionStart) this.instance).getGraphName();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public ByteString getGraphNameBytes() {
                return ((SolutionSessionStart) this.instance).getGraphNameBytes();
            }

            public Builder setGraphName(String value) {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).setGraphName(value);
                return this;
            }

            public Builder clearGraphName() {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).clearGraphName();
                return this;
            }

            public Builder setGraphNameBytes(ByteString value) {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).setGraphNameBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public boolean hasInitLatencyMs() {
                return ((SolutionSessionStart) this.instance).hasInitLatencyMs();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionStartOrBuilder
            public long getInitLatencyMs() {
                return ((SolutionSessionStart) this.instance).getInitLatencyMs();
            }

            public Builder setInitLatencyMs(long value) {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).setInitLatencyMs(value);
                return this;
            }

            public Builder clearInitLatencyMs() {
                copyOnWrite();
                ((SolutionSessionStart) this.instance).clearInitLatencyMs();
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
                    return new SolutionSessionStart();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဃ\u0002", new Object[]{"bitField0_", "mode_", MediaPipeLoggingEnumsProto.SolutionMode.internalGetVerifier(), "graphName_", "initLatencyMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionSessionStart> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionSessionStart.class) {
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
            SolutionSessionStart solutionSessionStart = new SolutionSessionStart();
            DEFAULT_INSTANCE = solutionSessionStart;
            GeneratedMessageLite.registerDefaultInstance(SolutionSessionStart.class, solutionSessionStart);
        }

        public static SolutionSessionStart getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionSessionStart> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionSessionClone extends GeneratedMessageLite<SolutionSessionClone, Builder> implements SolutionSessionCloneOrBuilder {
        private static final SolutionSessionClone DEFAULT_INSTANCE;
        public static final int GRAPH_NAME_FIELD_NUMBER = 2;
        public static final int INIT_LATENCY_MS_FIELD_NUMBER = 3;
        public static final int MODE_FIELD_NUMBER = 1;
        private static volatile Parser<SolutionSessionClone> PARSER;
        private int bitField0_;
        private String graphName_ = "";
        private long initLatencyMs_;
        private int mode_;

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

        private SolutionSessionClone() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public boolean hasMode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public MediaPipeLoggingEnumsProto.SolutionMode getMode() {
            MediaPipeLoggingEnumsProto.SolutionMode solutionModeForNumber = MediaPipeLoggingEnumsProto.SolutionMode.forNumber(this.mode_);
            return solutionModeForNumber == null ? MediaPipeLoggingEnumsProto.SolutionMode.MODE_UNKNOWN : solutionModeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMode(MediaPipeLoggingEnumsProto.SolutionMode value) {
            this.mode_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMode() {
            this.bitField0_ &= -2;
            this.mode_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public boolean hasGraphName() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public String getGraphName() {
            return this.graphName_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public ByteString getGraphNameBytes() {
            return ByteString.copyFromUtf8(this.graphName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGraphName(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.graphName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGraphName() {
            this.bitField0_ &= -3;
            this.graphName_ = getDefaultInstance().getGraphName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGraphNameBytes(ByteString value) {
            this.graphName_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public boolean hasInitLatencyMs() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
        public long getInitLatencyMs() {
            return this.initLatencyMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInitLatencyMs(long value) {
            this.bitField0_ |= 4;
            this.initLatencyMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInitLatencyMs() {
            this.bitField0_ &= -5;
            this.initLatencyMs_ = 0L;
        }

        public static SolutionSessionClone parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionClone parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionClone parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionClone parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionClone parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionClone parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionClone parseFrom(InputStream input) throws IOException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionClone parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionSessionClone parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionSessionClone) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionClone parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionClone) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionSessionClone parseFrom(CodedInputStream input) throws IOException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionClone parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionClone) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionSessionClone prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionSessionClone, Builder> implements SolutionSessionCloneOrBuilder {
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
                super(SolutionSessionClone.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public boolean hasMode() {
                return ((SolutionSessionClone) this.instance).hasMode();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public MediaPipeLoggingEnumsProto.SolutionMode getMode() {
                return ((SolutionSessionClone) this.instance).getMode();
            }

            public Builder setMode(MediaPipeLoggingEnumsProto.SolutionMode value) {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).setMode(value);
                return this;
            }

            public Builder clearMode() {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).clearMode();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public boolean hasGraphName() {
                return ((SolutionSessionClone) this.instance).hasGraphName();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public String getGraphName() {
                return ((SolutionSessionClone) this.instance).getGraphName();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public ByteString getGraphNameBytes() {
                return ((SolutionSessionClone) this.instance).getGraphNameBytes();
            }

            public Builder setGraphName(String value) {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).setGraphName(value);
                return this;
            }

            public Builder clearGraphName() {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).clearGraphName();
                return this;
            }

            public Builder setGraphNameBytes(ByteString value) {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).setGraphNameBytes(value);
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public boolean hasInitLatencyMs() {
                return ((SolutionSessionClone) this.instance).hasInitLatencyMs();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionCloneOrBuilder
            public long getInitLatencyMs() {
                return ((SolutionSessionClone) this.instance).getInitLatencyMs();
            }

            public Builder setInitLatencyMs(long value) {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).setInitLatencyMs(value);
                return this;
            }

            public Builder clearInitLatencyMs() {
                copyOnWrite();
                ((SolutionSessionClone) this.instance).clearInitLatencyMs();
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
                    return new SolutionSessionClone();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဃ\u0002", new Object[]{"bitField0_", "mode_", MediaPipeLoggingEnumsProto.SolutionMode.internalGetVerifier(), "graphName_", "initLatencyMs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionSessionClone> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionSessionClone.class) {
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
            SolutionSessionClone solutionSessionClone = new SolutionSessionClone();
            DEFAULT_INSTANCE = solutionSessionClone;
            GeneratedMessageLite.registerDefaultInstance(SolutionSessionClone.class, solutionSessionClone);
        }

        public static SolutionSessionClone getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionSessionClone> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionInvocationReport extends GeneratedMessageLite<SolutionInvocationReport, Builder> implements SolutionInvocationReportOrBuilder {
        private static final SolutionInvocationReport DEFAULT_INSTANCE;
        public static final int DROPPED_FIELD_NUMBER = 7;
        public static final int ELAPSED_TIME_MS_FIELD_NUMBER = 6;
        public static final int INVOCATION_COUNT_FIELD_NUMBER = 8;
        public static final int MODE_FIELD_NUMBER = 1;
        private static volatile Parser<SolutionInvocationReport> PARSER = null;
        public static final int PIPELINE_AVERAGE_LATENCY_MS_FIELD_NUMBER = 4;
        public static final int PIPELINE_PEAK_LATENCY_MS_FIELD_NUMBER = 5;
        private int bitField0_;
        private long dropped_;
        private long elapsedTimeMs_;
        private Internal.ProtobufList<SolutionInvocationCount> invocationCount_ = emptyProtobufList();
        private int mode_;
        private long pipelineAverageLatencyMs_;
        private long pipelinePeakLatencyMs_;

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

        private SolutionInvocationReport() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public boolean hasMode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public MediaPipeLoggingEnumsProto.SolutionMode getMode() {
            MediaPipeLoggingEnumsProto.SolutionMode solutionModeForNumber = MediaPipeLoggingEnumsProto.SolutionMode.forNumber(this.mode_);
            return solutionModeForNumber == null ? MediaPipeLoggingEnumsProto.SolutionMode.MODE_UNKNOWN : solutionModeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMode(MediaPipeLoggingEnumsProto.SolutionMode value) {
            this.mode_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMode() {
            this.bitField0_ &= -2;
            this.mode_ = 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public boolean hasPipelineAverageLatencyMs() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public long getPipelineAverageLatencyMs() {
            return this.pipelineAverageLatencyMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPipelineAverageLatencyMs(long value) {
            this.bitField0_ |= 2;
            this.pipelineAverageLatencyMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPipelineAverageLatencyMs() {
            this.bitField0_ &= -3;
            this.pipelineAverageLatencyMs_ = 0L;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public boolean hasPipelinePeakLatencyMs() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public long getPipelinePeakLatencyMs() {
            return this.pipelinePeakLatencyMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPipelinePeakLatencyMs(long value) {
            this.bitField0_ |= 4;
            this.pipelinePeakLatencyMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPipelinePeakLatencyMs() {
            this.bitField0_ &= -5;
            this.pipelinePeakLatencyMs_ = 0L;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public boolean hasElapsedTimeMs() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public long getElapsedTimeMs() {
            return this.elapsedTimeMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setElapsedTimeMs(long value) {
            this.bitField0_ |= 8;
            this.elapsedTimeMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearElapsedTimeMs() {
            this.bitField0_ &= -9;
            this.elapsedTimeMs_ = 0L;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public boolean hasDropped() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public long getDropped() {
            return this.dropped_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDropped(long value) {
            this.bitField0_ |= 16;
            this.dropped_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDropped() {
            this.bitField0_ &= -17;
            this.dropped_ = 0L;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public List<SolutionInvocationCount> getInvocationCountList() {
            return this.invocationCount_;
        }

        public List<? extends SolutionInvocationCountOrBuilder> getInvocationCountOrBuilderList() {
            return this.invocationCount_;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public int getInvocationCountCount() {
            return this.invocationCount_.size();
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
        public SolutionInvocationCount getInvocationCount(int index) {
            return this.invocationCount_.get(index);
        }

        public SolutionInvocationCountOrBuilder getInvocationCountOrBuilder(int index) {
            return this.invocationCount_.get(index);
        }

        private void ensureInvocationCountIsMutable() {
            Internal.ProtobufList<SolutionInvocationCount> protobufList = this.invocationCount_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.invocationCount_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInvocationCount(int index, SolutionInvocationCount value) {
            value.getClass();
            ensureInvocationCountIsMutable();
            this.invocationCount_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInvocationCount(SolutionInvocationCount value) {
            value.getClass();
            ensureInvocationCountIsMutable();
            this.invocationCount_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addInvocationCount(int index, SolutionInvocationCount value) {
            value.getClass();
            ensureInvocationCountIsMutable();
            this.invocationCount_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllInvocationCount(Iterable<? extends SolutionInvocationCount> values) {
            ensureInvocationCountIsMutable();
            AbstractMessageLite.addAll(values, this.invocationCount_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInvocationCount() {
            this.invocationCount_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeInvocationCount(int index) {
            ensureInvocationCountIsMutable();
            this.invocationCount_.remove(index);
        }

        public static SolutionInvocationReport parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionInvocationReport parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionInvocationReport parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionInvocationReport parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionInvocationReport parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionInvocationReport parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionInvocationReport parseFrom(InputStream input) throws IOException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionInvocationReport parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionInvocationReport parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionInvocationReport) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionInvocationReport parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionInvocationReport) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionInvocationReport parseFrom(CodedInputStream input) throws IOException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionInvocationReport parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionInvocationReport) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionInvocationReport prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionInvocationReport, Builder> implements SolutionInvocationReportOrBuilder {
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
                super(SolutionInvocationReport.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public boolean hasMode() {
                return ((SolutionInvocationReport) this.instance).hasMode();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public MediaPipeLoggingEnumsProto.SolutionMode getMode() {
                return ((SolutionInvocationReport) this.instance).getMode();
            }

            public Builder setMode(MediaPipeLoggingEnumsProto.SolutionMode value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setMode(value);
                return this;
            }

            public Builder clearMode() {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).clearMode();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public boolean hasPipelineAverageLatencyMs() {
                return ((SolutionInvocationReport) this.instance).hasPipelineAverageLatencyMs();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public long getPipelineAverageLatencyMs() {
                return ((SolutionInvocationReport) this.instance).getPipelineAverageLatencyMs();
            }

            public Builder setPipelineAverageLatencyMs(long value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setPipelineAverageLatencyMs(value);
                return this;
            }

            public Builder clearPipelineAverageLatencyMs() {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).clearPipelineAverageLatencyMs();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public boolean hasPipelinePeakLatencyMs() {
                return ((SolutionInvocationReport) this.instance).hasPipelinePeakLatencyMs();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public long getPipelinePeakLatencyMs() {
                return ((SolutionInvocationReport) this.instance).getPipelinePeakLatencyMs();
            }

            public Builder setPipelinePeakLatencyMs(long value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setPipelinePeakLatencyMs(value);
                return this;
            }

            public Builder clearPipelinePeakLatencyMs() {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).clearPipelinePeakLatencyMs();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public boolean hasElapsedTimeMs() {
                return ((SolutionInvocationReport) this.instance).hasElapsedTimeMs();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public long getElapsedTimeMs() {
                return ((SolutionInvocationReport) this.instance).getElapsedTimeMs();
            }

            public Builder setElapsedTimeMs(long value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setElapsedTimeMs(value);
                return this;
            }

            public Builder clearElapsedTimeMs() {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).clearElapsedTimeMs();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public boolean hasDropped() {
                return ((SolutionInvocationReport) this.instance).hasDropped();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public long getDropped() {
                return ((SolutionInvocationReport) this.instance).getDropped();
            }

            public Builder setDropped(long value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setDropped(value);
                return this;
            }

            public Builder clearDropped() {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).clearDropped();
                return this;
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public List<SolutionInvocationCount> getInvocationCountList() {
                return Collections.unmodifiableList(((SolutionInvocationReport) this.instance).getInvocationCountList());
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public int getInvocationCountCount() {
                return ((SolutionInvocationReport) this.instance).getInvocationCountCount();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionInvocationReportOrBuilder
            public SolutionInvocationCount getInvocationCount(int index) {
                return ((SolutionInvocationReport) this.instance).getInvocationCount(index);
            }

            public Builder setInvocationCount(int index, SolutionInvocationCount value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setInvocationCount(index, value);
                return this;
            }

            public Builder setInvocationCount(int index, SolutionInvocationCount.Builder builderForValue) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).setInvocationCount(index, (SolutionInvocationCount) builderForValue.build());
                return this;
            }

            public Builder addInvocationCount(SolutionInvocationCount value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).addInvocationCount(value);
                return this;
            }

            public Builder addInvocationCount(int index, SolutionInvocationCount value) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).addInvocationCount(index, value);
                return this;
            }

            public Builder addInvocationCount(SolutionInvocationCount.Builder builderForValue) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).addInvocationCount((SolutionInvocationCount) builderForValue.build());
                return this;
            }

            public Builder addInvocationCount(int index, SolutionInvocationCount.Builder builderForValue) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).addInvocationCount(index, (SolutionInvocationCount) builderForValue.build());
                return this;
            }

            public Builder addAllInvocationCount(Iterable<? extends SolutionInvocationCount> values) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).addAllInvocationCount(values);
                return this;
            }

            public Builder clearInvocationCount() {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).clearInvocationCount();
                return this;
            }

            public Builder removeInvocationCount(int index) {
                copyOnWrite();
                ((SolutionInvocationReport) this.instance).removeInvocationCount(index);
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
                    return new SolutionInvocationReport();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\b\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0004ဃ\u0001\u0005ဃ\u0002\u0006ဃ\u0003\u0007ဂ\u0004\b\u001b", new Object[]{"bitField0_", "mode_", MediaPipeLoggingEnumsProto.SolutionMode.internalGetVerifier(), "pipelineAverageLatencyMs_", "pipelinePeakLatencyMs_", "elapsedTimeMs_", "dropped_", "invocationCount_", SolutionInvocationCount.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionInvocationReport> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionInvocationReport.class) {
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
            SolutionInvocationReport solutionInvocationReport = new SolutionInvocationReport();
            DEFAULT_INSTANCE = solutionInvocationReport;
            GeneratedMessageLite.registerDefaultInstance(SolutionInvocationReport.class, solutionInvocationReport);
        }

        public static SolutionInvocationReport getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionInvocationReport> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionSessionEnd extends GeneratedMessageLite<SolutionSessionEnd, Builder> implements SolutionSessionEndOrBuilder {
        private static final SolutionSessionEnd DEFAULT_INSTANCE;
        public static final int INVOCATION_REPORT_FIELD_NUMBER = 2;
        private static volatile Parser<SolutionSessionEnd> PARSER;
        private int bitField0_;
        private SolutionInvocationReport invocationReport_;

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

        private SolutionSessionEnd() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionEndOrBuilder
        public boolean hasInvocationReport() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionEndOrBuilder
        public SolutionInvocationReport getInvocationReport() {
            SolutionInvocationReport solutionInvocationReport = this.invocationReport_;
            return solutionInvocationReport == null ? SolutionInvocationReport.getDefaultInstance() : solutionInvocationReport;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInvocationReport(SolutionInvocationReport value) {
            value.getClass();
            this.invocationReport_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeInvocationReport(SolutionInvocationReport value) {
            value.getClass();
            SolutionInvocationReport solutionInvocationReport = this.invocationReport_;
            if (solutionInvocationReport != null && solutionInvocationReport != SolutionInvocationReport.getDefaultInstance()) {
                this.invocationReport_ = (SolutionInvocationReport) SolutionInvocationReport.newBuilder(this.invocationReport_).mergeFrom(value).buildPartial();
            } else {
                this.invocationReport_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInvocationReport() {
            this.invocationReport_ = null;
            this.bitField0_ &= -2;
        }

        public static SolutionSessionEnd parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionEnd parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionEnd parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionEnd parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionEnd parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionSessionEnd parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionSessionEnd parseFrom(InputStream input) throws IOException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionEnd parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionSessionEnd parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionSessionEnd) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionEnd parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionEnd) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionSessionEnd parseFrom(CodedInputStream input) throws IOException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionSessionEnd parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionSessionEnd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionSessionEnd prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionSessionEnd, Builder> implements SolutionSessionEndOrBuilder {
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
                super(SolutionSessionEnd.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionEndOrBuilder
            public boolean hasInvocationReport() {
                return ((SolutionSessionEnd) this.instance).hasInvocationReport();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionSessionEndOrBuilder
            public SolutionInvocationReport getInvocationReport() {
                return ((SolutionSessionEnd) this.instance).getInvocationReport();
            }

            public Builder setInvocationReport(SolutionInvocationReport value) {
                copyOnWrite();
                ((SolutionSessionEnd) this.instance).setInvocationReport(value);
                return this;
            }

            public Builder setInvocationReport(SolutionInvocationReport.Builder builderForValue) {
                copyOnWrite();
                ((SolutionSessionEnd) this.instance).setInvocationReport((SolutionInvocationReport) builderForValue.build());
                return this;
            }

            public Builder mergeInvocationReport(SolutionInvocationReport value) {
                copyOnWrite();
                ((SolutionSessionEnd) this.instance).mergeInvocationReport(value);
                return this;
            }

            public Builder clearInvocationReport() {
                copyOnWrite();
                ((SolutionSessionEnd) this.instance).clearInvocationReport();
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
                    return new SolutionSessionEnd();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"bitField0_", "invocationReport_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionSessionEnd> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionSessionEnd.class) {
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
            SolutionSessionEnd solutionSessionEnd = new SolutionSessionEnd();
            DEFAULT_INSTANCE = solutionSessionEnd;
            GeneratedMessageLite.registerDefaultInstance(SolutionSessionEnd.class, solutionSessionEnd);
        }

        public static SolutionSessionEnd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionSessionEnd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SolutionError extends GeneratedMessageLite<SolutionError, Builder> implements SolutionErrorOrBuilder {
        private static final SolutionError DEFAULT_INSTANCE;
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        private static volatile Parser<SolutionError> PARSER;
        private int bitField0_;
        private int errorCode_;

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

        private SolutionError() {
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionErrorOrBuilder
        public boolean hasErrorCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionErrorOrBuilder
        public MediaPipeLoggingEnumsProto.ErrorCode getErrorCode() {
            MediaPipeLoggingEnumsProto.ErrorCode errorCodeForNumber = MediaPipeLoggingEnumsProto.ErrorCode.forNumber(this.errorCode_);
            return errorCodeForNumber == null ? MediaPipeLoggingEnumsProto.ErrorCode.ERROR_UNKNOWN : errorCodeForNumber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorCode(MediaPipeLoggingEnumsProto.ErrorCode value) {
            this.errorCode_ = value.getNumber();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorCode() {
            this.bitField0_ &= -2;
            this.errorCode_ = 0;
        }

        public static SolutionError parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionError parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionError parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionError parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionError parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SolutionError parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SolutionError parseFrom(InputStream input) throws IOException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionError parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionError parseDelimitedFrom(InputStream input) throws IOException {
            return (SolutionError) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionError parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionError) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SolutionError parseFrom(CodedInputStream input) throws IOException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SolutionError parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SolutionError) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SolutionError prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SolutionError, Builder> implements SolutionErrorOrBuilder {
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
                super(SolutionError.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionErrorOrBuilder
            public boolean hasErrorCode() {
                return ((SolutionError) this.instance).hasErrorCode();
            }

            @Override // com.google.mediapipe.proto.MediaPipeLoggingProto.SolutionErrorOrBuilder
            public MediaPipeLoggingEnumsProto.ErrorCode getErrorCode() {
                return ((SolutionError) this.instance).getErrorCode();
            }

            public Builder setErrorCode(MediaPipeLoggingEnumsProto.ErrorCode value) {
                copyOnWrite();
                ((SolutionError) this.instance).setErrorCode(value);
                return this;
            }

            public Builder clearErrorCode() {
                copyOnWrite();
                ((SolutionError) this.instance).clearErrorCode();
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
                    return new SolutionError();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"bitField0_", "errorCode_", MediaPipeLoggingEnumsProto.ErrorCode.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<SolutionError> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (SolutionError.class) {
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
            SolutionError solutionError = new SolutionError();
            DEFAULT_INSTANCE = solutionError;
            GeneratedMessageLite.registerDefaultInstance(SolutionError.class, solutionError);
        }

        public static SolutionError getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SolutionError> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
