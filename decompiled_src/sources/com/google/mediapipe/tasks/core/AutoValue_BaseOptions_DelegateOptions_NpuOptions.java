package com.google.mediapipe.tasks.core;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_BaseOptions_DelegateOptions_NpuOptions extends BaseOptions.DelegateOptions.NpuOptions {
    private final String compilerPluginLibraryDirectory;
    private final String dispatchLibraryDirectory;

    private AutoValue_BaseOptions_DelegateOptions_NpuOptions(String dispatchLibraryDirectory, String compilerPluginLibraryDirectory) {
        this.dispatchLibraryDirectory = dispatchLibraryDirectory;
        this.compilerPluginLibraryDirectory = compilerPluginLibraryDirectory;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.NpuOptions
    String dispatchLibraryDirectory() {
        return this.dispatchLibraryDirectory;
    }

    @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.NpuOptions
    String compilerPluginLibraryDirectory() {
        return this.compilerPluginLibraryDirectory;
    }

    public String toString() {
        return "NpuOptions{dispatchLibraryDirectory=" + this.dispatchLibraryDirectory + ", compilerPluginLibraryDirectory=" + this.compilerPluginLibraryDirectory + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof BaseOptions.DelegateOptions.NpuOptions) {
            BaseOptions.DelegateOptions.NpuOptions npuOptions = (BaseOptions.DelegateOptions.NpuOptions) o;
            if (this.dispatchLibraryDirectory.equals(npuOptions.dispatchLibraryDirectory()) && this.compilerPluginLibraryDirectory.equals(npuOptions.compilerPluginLibraryDirectory())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.compilerPluginLibraryDirectory.hashCode() ^ ((this.dispatchLibraryDirectory.hashCode() ^ 1000003) * 1000003);
    }

    static final class Builder extends BaseOptions.DelegateOptions.NpuOptions.Builder {
        private String compilerPluginLibraryDirectory;
        private String dispatchLibraryDirectory;

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.NpuOptions.Builder
        public BaseOptions.DelegateOptions.NpuOptions.Builder setDispatchLibraryDirectory(String dispatchLibraryDirectory) {
            if (dispatchLibraryDirectory == null) {
                throw new NullPointerException("Null dispatchLibraryDirectory");
            }
            this.dispatchLibraryDirectory = dispatchLibraryDirectory;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.NpuOptions.Builder
        public BaseOptions.DelegateOptions.NpuOptions.Builder setCompilerPluginLibraryDirectory(String compilerPluginLibraryDirectory) {
            if (compilerPluginLibraryDirectory == null) {
                throw new NullPointerException("Null compilerPluginLibraryDirectory");
            }
            this.compilerPluginLibraryDirectory = compilerPluginLibraryDirectory;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.BaseOptions.DelegateOptions.NpuOptions.Builder
        public BaseOptions.DelegateOptions.NpuOptions build() {
            String str;
            if (this.dispatchLibraryDirectory != null) {
                str = "";
            } else {
                str = " dispatchLibraryDirectory";
            }
            if (this.compilerPluginLibraryDirectory == null) {
                str = str + " compilerPluginLibraryDirectory";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_BaseOptions_DelegateOptions_NpuOptions(this.dispatchLibraryDirectory, this.compilerPluginLibraryDirectory);
        }
    }
}
