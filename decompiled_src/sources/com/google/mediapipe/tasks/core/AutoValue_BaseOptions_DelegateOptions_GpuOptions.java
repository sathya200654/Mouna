package com.google.mediapipe.tasks.core;

import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_BaseOptions_DelegateOptions_GpuOptions extends BaseOptions.DelegateOptions.GpuOptions {
    private final Optional<String> cachedKernelPath;
    private final Optional<String> modelToken;
    private final Optional<String> serializedModelDir;

    private AutoValue_BaseOptions_DelegateOptions_GpuOptions(Optional<String> cachedKernelPath, Optional<String> serializedModelDir, Optional<String> modelToken) {
        this.cachedKernelPath = cachedKernelPath;
        this.serializedModelDir = serializedModelDir;
        this.modelToken = modelToken;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions
    Optional<String> cachedKernelPath() {
        return this.cachedKernelPath;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions
    Optional<String> serializedModelDir() {
        return this.serializedModelDir;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions
    Optional<String> modelToken() {
        return this.modelToken;
    }

    public String toString() {
        return "GpuOptions{cachedKernelPath=" + this.cachedKernelPath + ", serializedModelDir=" + this.serializedModelDir + ", modelToken=" + this.modelToken + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof BaseOptions.DelegateOptions.GpuOptions) {
            BaseOptions.DelegateOptions.GpuOptions gpuOptions = (BaseOptions.DelegateOptions.GpuOptions) o;
            if (this.cachedKernelPath.equals(gpuOptions.cachedKernelPath()) && this.serializedModelDir.equals(gpuOptions.serializedModelDir()) && this.modelToken.equals(gpuOptions.modelToken())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.modelToken.hashCode() ^ ((((this.cachedKernelPath.hashCode() ^ 1000003) * 1000003) ^ this.serializedModelDir.hashCode()) * 1000003);
    }

    static final class Builder extends BaseOptions.DelegateOptions.GpuOptions.Builder {
        private Optional<String> cachedKernelPath = Optional.empty();
        private Optional<String> serializedModelDir = Optional.empty();
        private Optional<String> modelToken = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions.Builder
        public BaseOptions.DelegateOptions.GpuOptions.Builder setCachedKernelPath(String cachedKernelPath) {
            this.cachedKernelPath = Optional.of(cachedKernelPath);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions.Builder
        public BaseOptions.DelegateOptions.GpuOptions.Builder setSerializedModelDir(String serializedModelDir) {
            this.serializedModelDir = Optional.of(serializedModelDir);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions.Builder
        public BaseOptions.DelegateOptions.GpuOptions.Builder setModelToken(String modelToken) {
            this.modelToken = Optional.of(modelToken);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.GpuOptions.Builder
        public BaseOptions.DelegateOptions.GpuOptions build() {
            return new AutoValue_BaseOptions_DelegateOptions_GpuOptions(this.cachedKernelPath, this.serializedModelDir, this.modelToken);
        }
    }
}
