package com.google.mediapipe.tasks.core.proto;

import com.google.mediapipe.calculator.proto.InferenceCalculatorProto;
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
public final class AccelerationProto {

    public interface AccelerationOrBuilder extends MessageLiteOrBuilder {
        Acceleration.DelegateCase getDelegateCase();

        InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu getGpu();

        InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi getNnapi();

        InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite getTflite();

        InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack getXnnpack();

        boolean hasGpu();

        boolean hasNnapi();

        boolean hasTflite();

        boolean hasXnnpack();
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    private AccelerationProto() {
    }

    public static final class Acceleration extends GeneratedMessageLite<Acceleration, Builder> implements AccelerationOrBuilder {
        private static final Acceleration DEFAULT_INSTANCE;
        public static final int GPU_FIELD_NUMBER = 2;
        public static final int NNAPI_FIELD_NUMBER = 5;
        private static volatile Parser<Acceleration> PARSER = null;
        public static final int TFLITE_FIELD_NUMBER = 4;
        public static final int XNNPACK_FIELD_NUMBER = 1;
        private int delegateCase_ = 0;
        private Object delegate_;

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

        private Acceleration() {
        }

        public enum DelegateCase {
            XNNPACK(1),
            GPU(2),
            TFLITE(4),
            NNAPI(5),
            DELEGATE_NOT_SET(0);

            private final int value;

            DelegateCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DelegateCase valueOf(int value) {
                return forNumber(value);
            }

            public static DelegateCase forNumber(int value) {
                if (value == 0) {
                    return DELEGATE_NOT_SET;
                }
                if (value == 1) {
                    return XNNPACK;
                }
                if (value == 2) {
                    return GPU;
                }
                if (value == 4) {
                    return TFLITE;
                }
                if (value != 5) {
                    return null;
                }
                return NNAPI;
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public DelegateCase getDelegateCase() {
            return DelegateCase.forNumber(this.delegateCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDelegate() {
            this.delegateCase_ = 0;
            this.delegate_ = null;
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public boolean hasXnnpack() {
            return this.delegateCase_ == 1;
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack getXnnpack() {
            if (this.delegateCase_ == 1) {
                return (InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack) this.delegate_;
            }
            return InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXnnpack(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack value) {
            value.getClass();
            this.delegate_ = value;
            this.delegateCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeXnnpack(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack value) {
            value.getClass();
            if (this.delegateCase_ == 1 && this.delegate_ != InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack.getDefaultInstance()) {
                this.delegate_ = InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack.newBuilder((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack) this.delegate_).mergeFrom(value).buildPartial();
            } else {
                this.delegate_ = value;
            }
            this.delegateCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXnnpack() {
            if (this.delegateCase_ == 1) {
                this.delegateCase_ = 0;
                this.delegate_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public boolean hasGpu() {
            return this.delegateCase_ == 2;
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu getGpu() {
            if (this.delegateCase_ == 2) {
                return (InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu) this.delegate_;
            }
            return InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setGpu(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu value) {
            value.getClass();
            this.delegate_ = value;
            this.delegateCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeGpu(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu value) {
            value.getClass();
            if (this.delegateCase_ == 2 && this.delegate_ != InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.getDefaultInstance()) {
                this.delegate_ = InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.newBuilder((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu) this.delegate_).mergeFrom(value).buildPartial();
            } else {
                this.delegate_ = value;
            }
            this.delegateCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearGpu() {
            if (this.delegateCase_ == 2) {
                this.delegateCase_ = 0;
                this.delegate_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public boolean hasTflite() {
            return this.delegateCase_ == 4;
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite getTflite() {
            if (this.delegateCase_ == 4) {
                return (InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite) this.delegate_;
            }
            return InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite value) {
            value.getClass();
            this.delegate_ = value;
            this.delegateCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite value) {
            value.getClass();
            if (this.delegateCase_ == 4 && this.delegate_ != InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.getDefaultInstance()) {
                this.delegate_ = InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.newBuilder((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite) this.delegate_).mergeFrom(value).buildPartial();
            } else {
                this.delegate_ = value;
            }
            this.delegateCase_ = 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTflite() {
            if (this.delegateCase_ == 4) {
                this.delegateCase_ = 0;
                this.delegate_ = null;
            }
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public boolean hasNnapi() {
            return this.delegateCase_ == 5;
        }

        @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
        public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi getNnapi() {
            if (this.delegateCase_ == 5) {
                return (InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi) this.delegate_;
            }
            return InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNnapi(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi value) {
            value.getClass();
            this.delegate_ = value;
            this.delegateCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeNnapi(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi value) {
            value.getClass();
            if (this.delegateCase_ == 5 && this.delegate_ != InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi.getDefaultInstance()) {
                this.delegate_ = InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi.newBuilder((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi) this.delegate_).mergeFrom(value).buildPartial();
            } else {
                this.delegate_ = value;
            }
            this.delegateCase_ = 5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNnapi() {
            if (this.delegateCase_ == 5) {
                this.delegateCase_ = 0;
                this.delegate_ = null;
            }
        }

        public static Acceleration parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Acceleration parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Acceleration parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Acceleration parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Acceleration parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Acceleration parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Acceleration parseFrom(InputStream input) throws IOException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Acceleration parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Acceleration parseDelimitedFrom(InputStream input) throws IOException {
            return (Acceleration) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Acceleration parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Acceleration) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Acceleration parseFrom(CodedInputStream input) throws IOException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Acceleration parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Acceleration) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Acceleration prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Acceleration, Builder> implements AccelerationOrBuilder {
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
                super(Acceleration.DEFAULT_INSTANCE);
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public DelegateCase getDelegateCase() {
                return ((Acceleration) this.instance).getDelegateCase();
            }

            public Builder clearDelegate() {
                copyOnWrite();
                ((Acceleration) this.instance).clearDelegate();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public boolean hasXnnpack() {
                return ((Acceleration) this.instance).hasXnnpack();
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack getXnnpack() {
                return ((Acceleration) this.instance).getXnnpack();
            }

            public Builder setXnnpack(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack value) {
                copyOnWrite();
                ((Acceleration) this.instance).setXnnpack(value);
                return this;
            }

            public Builder setXnnpack(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack.Builder builderForValue) {
                copyOnWrite();
                ((Acceleration) this.instance).setXnnpack((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack) builderForValue.build());
                return this;
            }

            public Builder mergeXnnpack(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack value) {
                copyOnWrite();
                ((Acceleration) this.instance).mergeXnnpack(value);
                return this;
            }

            public Builder clearXnnpack() {
                copyOnWrite();
                ((Acceleration) this.instance).clearXnnpack();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public boolean hasGpu() {
                return ((Acceleration) this.instance).hasGpu();
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu getGpu() {
                return ((Acceleration) this.instance).getGpu();
            }

            public Builder setGpu(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu value) {
                copyOnWrite();
                ((Acceleration) this.instance).setGpu(value);
                return this;
            }

            public Builder setGpu(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.Builder builderForValue) {
                copyOnWrite();
                ((Acceleration) this.instance).setGpu((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu) builderForValue.build());
                return this;
            }

            public Builder mergeGpu(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu value) {
                copyOnWrite();
                ((Acceleration) this.instance).mergeGpu(value);
                return this;
            }

            public Builder clearGpu() {
                copyOnWrite();
                ((Acceleration) this.instance).clearGpu();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public boolean hasTflite() {
                return ((Acceleration) this.instance).hasTflite();
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite getTflite() {
                return ((Acceleration) this.instance).getTflite();
            }

            public Builder setTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite value) {
                copyOnWrite();
                ((Acceleration) this.instance).setTflite(value);
                return this;
            }

            public Builder setTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.Builder builderForValue) {
                copyOnWrite();
                ((Acceleration) this.instance).setTflite((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite) builderForValue.build());
                return this;
            }

            public Builder mergeTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite value) {
                copyOnWrite();
                ((Acceleration) this.instance).mergeTflite(value);
                return this;
            }

            public Builder clearTflite() {
                copyOnWrite();
                ((Acceleration) this.instance).clearTflite();
                return this;
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public boolean hasNnapi() {
                return ((Acceleration) this.instance).hasNnapi();
            }

            @Override // com.google.mediapipe.tasks.core.proto.AccelerationProto.AccelerationOrBuilder
            public InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi getNnapi() {
                return ((Acceleration) this.instance).getNnapi();
            }

            public Builder setNnapi(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi value) {
                copyOnWrite();
                ((Acceleration) this.instance).setNnapi(value);
                return this;
            }

            public Builder setNnapi(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi.Builder builderForValue) {
                copyOnWrite();
                ((Acceleration) this.instance).setNnapi((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi) builderForValue.build());
                return this;
            }

            public Builder mergeNnapi(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi value) {
                copyOnWrite();
                ((Acceleration) this.instance).mergeNnapi(value);
                return this;
            }

            public Builder clearNnapi() {
                copyOnWrite();
                ((Acceleration) this.instance).clearNnapi();
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
                    return new Acceleration();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0001\u0000\u0001\u0005\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"delegate_", "delegateCase_", InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Xnnpack.class, InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.class, InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.class, InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Nnapi.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Acceleration> parser = PARSER;
                    if (parser != null) {
                        return parser;
                    }
                    synchronized (Acceleration.class) {
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
            Acceleration acceleration = new Acceleration();
            DEFAULT_INSTANCE = acceleration;
            GeneratedMessageLite.registerDefaultInstance(Acceleration.class, acceleration);
        }

        public static Acceleration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Acceleration> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.core.proto.AccelerationProto$1, reason: invalid class name */
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
