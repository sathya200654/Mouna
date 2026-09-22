package com.google.mediapipe.tasks.core;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_BaseOptions_DelegateOptions_CpuOptions extends BaseOptions.DelegateOptions.CpuOptions {
    public int hashCode() {
        return 1;
    }

    private AutoValue_BaseOptions_DelegateOptions_CpuOptions() {
    }

    public String toString() {
        return "CpuOptions{}";
    }

    public boolean equals(Object o) {
        return o == this || (o instanceof BaseOptions.DelegateOptions.CpuOptions);
    }

    static final class Builder extends BaseOptions.DelegateOptions.CpuOptions.Builder {
        Builder() {
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.CpuOptions.Builder
        public BaseOptions.DelegateOptions.CpuOptions build() {
            return new AutoValue_BaseOptions_DelegateOptions_CpuOptions();
        }
    }
}
