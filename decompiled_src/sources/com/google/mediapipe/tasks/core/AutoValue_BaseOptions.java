package com.google.mediapipe.tasks.core;

import java.nio.ByteBuffer;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_BaseOptions extends BaseOptions {
    private final Delegate delegate;
    private final Optional<BaseOptions.DelegateOptions> delegateOptions;
    private final Optional<ByteBuffer> modelAssetBuffer;
    private final Optional<Integer> modelAssetFileDescriptor;
    private final Optional<String> modelAssetPath;

    private AutoValue_BaseOptions(Optional<String> modelAssetPath, Optional<Integer> modelAssetFileDescriptor, Optional<ByteBuffer> modelAssetBuffer, Delegate delegate, Optional<BaseOptions.DelegateOptions> delegateOptions) {
        this.modelAssetPath = modelAssetPath;
        this.modelAssetFileDescriptor = modelAssetFileDescriptor;
        this.modelAssetBuffer = modelAssetBuffer;
        this.delegate = delegate;
        this.delegateOptions = delegateOptions;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions
    Optional<String> modelAssetPath() {
        return this.modelAssetPath;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions
    Optional<Integer> modelAssetFileDescriptor() {
        return this.modelAssetFileDescriptor;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions
    Optional<ByteBuffer> modelAssetBuffer() {
        return this.modelAssetBuffer;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions
    Delegate delegate() {
        return this.delegate;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions
    Optional<BaseOptions.DelegateOptions> delegateOptions() {
        return this.delegateOptions;
    }

    public String toString() {
        return "BaseOptions{modelAssetPath=" + this.modelAssetPath + ", modelAssetFileDescriptor=" + this.modelAssetFileDescriptor + ", modelAssetBuffer=" + this.modelAssetBuffer + ", delegate=" + this.delegate + ", delegateOptions=" + this.delegateOptions + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof BaseOptions) {
            BaseOptions baseOptions = (BaseOptions) o;
            if (this.modelAssetPath.equals(baseOptions.modelAssetPath()) && this.modelAssetFileDescriptor.equals(baseOptions.modelAssetFileDescriptor()) && this.modelAssetBuffer.equals(baseOptions.modelAssetBuffer()) && this.delegate.equals(baseOptions.delegate()) && this.delegateOptions.equals(baseOptions.delegateOptions())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.delegateOptions.hashCode() ^ ((((((((this.modelAssetPath.hashCode() ^ 1000003) * 1000003) ^ this.modelAssetFileDescriptor.hashCode()) * 1000003) ^ this.modelAssetBuffer.hashCode()) * 1000003) ^ this.delegate.hashCode()) * 1000003);
    }

    static final class Builder extends BaseOptions.Builder {
        private Delegate delegate;
        private Optional<String> modelAssetPath = Optional.empty();
        private Optional<Integer> modelAssetFileDescriptor = Optional.empty();
        private Optional<ByteBuffer> modelAssetBuffer = Optional.empty();
        private Optional<BaseOptions.DelegateOptions> delegateOptions = Optional.empty();

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.Builder
        public BaseOptions.Builder setModelAssetPath(String modelAssetPath) {
            this.modelAssetPath = Optional.of(modelAssetPath);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.Builder
        public BaseOptions.Builder setModelAssetFileDescriptor(Integer modelAssetFileDescriptor) {
            this.modelAssetFileDescriptor = Optional.of(modelAssetFileDescriptor);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.Builder
        public BaseOptions.Builder setModelAssetBuffer(ByteBuffer modelAssetBuffer) {
            this.modelAssetBuffer = Optional.of(modelAssetBuffer);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.Builder
        public BaseOptions.Builder setDelegate(Delegate delegate) {
            if (delegate == null) {
                throw new NullPointerException("Null delegate");
            }
            this.delegate = delegate;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.Builder
        public BaseOptions.Builder setDelegateOptions(BaseOptions.DelegateOptions delegateOptions) {
            this.delegateOptions = Optional.of(delegateOptions);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.Builder
        BaseOptions autoBuild() {
            String str;
            if (this.delegate != null) {
                str = "";
            } else {
                str = " delegate";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_BaseOptions(this.modelAssetPath, this.modelAssetFileDescriptor, this.modelAssetBuffer, this.delegate, this.delegateOptions);
        }
    }
}
