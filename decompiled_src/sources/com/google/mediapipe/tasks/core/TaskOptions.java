package com.google.mediapipe.tasks.core;

import com.google.mediapipe.calculator.proto.InferenceCalculatorProto;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.tasks.core.proto.AccelerationProto;
import com.google.mediapipe.tasks.core.proto.BaseOptionsProto;
import com.google.mediapipe.tasks.core.proto.ExternalFileProto;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class TaskOptions {
    public Any convertToAnyProto() {
        return null;
    }

    public CalculatorOptionsProto.CalculatorOptions convertToCalculatorOptionsProto() {
        return null;
    }

    protected BaseOptionsProto.BaseOptions convertBaseOptionsToProto(BaseOptions options) {
        final ExternalFileProto.ExternalFile.Builder builderNewBuilder = ExternalFileProto.ExternalFile.newBuilder();
        Optional<String> optionalModelAssetPath = options.modelAssetPath();
        Objects.requireNonNull(builderNewBuilder);
        optionalModelAssetPath.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                builderNewBuilder.setFileName((String) obj);
            }
        });
        options.modelAssetFileDescriptor().ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                builderNewBuilder.setFileDescriptorMeta((ExternalFileProto.FileDescriptorMeta) ExternalFileProto.FileDescriptorMeta.newBuilder().setFd(((Integer) obj).intValue()).build());
            }
        });
        options.modelAssetBuffer().ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                TaskOptions.lambda$convertBaseOptionsToProto$1(builderNewBuilder, (ByteBuffer) obj);
            }
        });
        final AccelerationProto.Acceleration.Builder builderNewBuilder2 = AccelerationProto.Acceleration.newBuilder();
        int i = AnonymousClass1.$SwitchMap$com$google$mediapipe$tasks$core$Delegate[options.delegate().ordinal()];
        if (i == 1) {
            builderNewBuilder2.setTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.getDefaultInstance());
            options.delegateOptions().ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m2197x4403718d(builderNewBuilder2, (BaseOptions.DelegateOptions) obj);
                }
            });
        } else if (i == 2) {
            builderNewBuilder2.setGpu((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu) InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.newBuilder().setUseAdvancedGpuApi(true).build());
            options.delegateOptions().ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m2198xdea4340e(builderNewBuilder2, (BaseOptions.DelegateOptions) obj);
                }
            });
        }
        return (BaseOptionsProto.BaseOptions) BaseOptionsProto.BaseOptions.newBuilder().setModelAsset((ExternalFileProto.ExternalFile) builderNewBuilder.build()).setAcceleration((AccelerationProto.Acceleration) builderNewBuilder2.build()).build();
    }

    static /* synthetic */ void lambda$convertBaseOptionsToProto$1(ExternalFileProto.ExternalFile.Builder builder, ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        builder.setFileContent(ByteString.copyFrom(byteBuffer));
    }

    /* JADX INFO: renamed from: com.google.mediapipe.tasks.core.TaskOptions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$mediapipe$tasks$core$Delegate;

        static {
            int[] iArr = new int[Delegate.values().length];
            $SwitchMap$com$google$mediapipe$tasks$core$Delegate = iArr;
            try {
                iArr[Delegate.CPU.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$mediapipe$tasks$core$Delegate[Delegate.GPU.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDelegateOptions, reason: merged with bridge method [inline-methods] */
    public void m2197x4403718d(AccelerationProto.Acceleration.Builder accelerationBuilder, BaseOptions.DelegateOptions.CpuOptions options) {
        accelerationBuilder.setTflite(InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.TfLite.getDefaultInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setDelegateOptions, reason: merged with bridge method [inline-methods] */
    public void m2198xdea4340e(AccelerationProto.Acceleration.Builder accelerationBuilder, BaseOptions.DelegateOptions.GpuOptions options) {
        final InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.Builder useAdvancedGpuApi = InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu.newBuilder().setUseAdvancedGpuApi(true);
        Optional<String> optionalCachedKernelPath = options.cachedKernelPath();
        Objects.requireNonNull(useAdvancedGpuApi);
        optionalCachedKernelPath.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                useAdvancedGpuApi.setCachedKernelPath((String) obj);
            }
        });
        Optional<String> optionalSerializedModelDir = options.serializedModelDir();
        Objects.requireNonNull(useAdvancedGpuApi);
        optionalSerializedModelDir.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                useAdvancedGpuApi.setSerializedModelDir((String) obj);
            }
        });
        Optional<String> optionalModelToken = options.modelToken();
        Objects.requireNonNull(useAdvancedGpuApi);
        optionalModelToken.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.core.TaskOptions$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                useAdvancedGpuApi.setModelToken((String) obj);
            }
        });
        accelerationBuilder.setGpu((InferenceCalculatorProto.InferenceCalculatorOptions.Delegate.Gpu) useAdvancedGpuApi.build());
    }
}
