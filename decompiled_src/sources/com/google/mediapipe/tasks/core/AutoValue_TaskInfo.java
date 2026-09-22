package com.google.mediapipe.tasks.core;

import com.google.mediapipe.tasks.core.TaskOptions;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_TaskInfo<T extends TaskOptions> extends TaskInfo<T> {
    private final boolean enableFlowLimiting;
    private final List<String> inputStreams;
    private final List<String> outputStreams;
    private final String taskGraphName;
    private final String taskName;
    private final T taskOptions;
    private final String taskRunningModeName;

    private AutoValue_TaskInfo(String taskName, String taskRunningModeName, String taskGraphName, T taskOptions, List<String> inputStreams, List<String> outputStreams, boolean enableFlowLimiting) {
        this.taskName = taskName;
        this.taskRunningModeName = taskRunningModeName;
        this.taskGraphName = taskGraphName;
        this.taskOptions = taskOptions;
        this.inputStreams = inputStreams;
        this.outputStreams = outputStreams;
        this.enableFlowLimiting = enableFlowLimiting;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    String taskName() {
        return this.taskName;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    String taskRunningModeName() {
        return this.taskRunningModeName;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    String taskGraphName() {
        return this.taskGraphName;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    T taskOptions() {
        return this.taskOptions;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    List<String> inputStreams() {
        return this.inputStreams;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    List<String> outputStreams() {
        return this.outputStreams;
    }

    @Override // com.google.mediapipe.tasks.core.TaskInfo
    boolean enableFlowLimiting() {
        return this.enableFlowLimiting;
    }

    public String toString() {
        return "TaskInfo{taskName=" + this.taskName + ", taskRunningModeName=" + this.taskRunningModeName + ", taskGraphName=" + this.taskGraphName + ", taskOptions=" + this.taskOptions + ", inputStreams=" + this.inputStreams + ", outputStreams=" + this.outputStreams + ", enableFlowLimiting=" + this.enableFlowLimiting + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof TaskInfo) {
            TaskInfo taskInfo = (TaskInfo) o;
            if (this.taskName.equals(taskInfo.taskName()) && this.taskRunningModeName.equals(taskInfo.taskRunningModeName()) && this.taskGraphName.equals(taskInfo.taskGraphName()) && this.taskOptions.equals(taskInfo.taskOptions()) && this.inputStreams.equals(taskInfo.inputStreams()) && this.outputStreams.equals(taskInfo.outputStreams()) && this.enableFlowLimiting == taskInfo.enableFlowLimiting()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.enableFlowLimiting ? 1231 : 1237) ^ ((((((((((((this.taskName.hashCode() ^ 1000003) * 1000003) ^ this.taskRunningModeName.hashCode()) * 1000003) ^ this.taskGraphName.hashCode()) * 1000003) ^ this.taskOptions.hashCode()) * 1000003) ^ this.inputStreams.hashCode()) * 1000003) ^ this.outputStreams.hashCode()) * 1000003);
    }

    static final class Builder<T extends TaskOptions> extends TaskInfo.Builder<T> {
        private Boolean enableFlowLimiting;
        private List<String> inputStreams;
        private List<String> outputStreams;
        private String taskGraphName;
        private String taskName;
        private T taskOptions;
        private String taskRunningModeName;

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setTaskName(String taskName) {
            if (taskName == null) {
                throw new NullPointerException("Null taskName");
            }
            this.taskName = taskName;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setTaskRunningModeName(String taskRunningModeName) {
            if (taskRunningModeName == null) {
                throw new NullPointerException("Null taskRunningModeName");
            }
            this.taskRunningModeName = taskRunningModeName;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setTaskGraphName(String taskGraphName) {
            if (taskGraphName == null) {
                throw new NullPointerException("Null taskGraphName");
            }
            this.taskGraphName = taskGraphName;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setTaskOptions(T taskOptions) {
            if (taskOptions == null) {
                throw new NullPointerException("Null taskOptions");
            }
            this.taskOptions = taskOptions;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setInputStreams(List<String> inputStreams) {
            if (inputStreams == null) {
                throw new NullPointerException("Null inputStreams");
            }
            this.inputStreams = inputStreams;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setOutputStreams(List<String> outputStreams) {
            if (outputStreams == null) {
                throw new NullPointerException("Null outputStreams");
            }
            this.outputStreams = outputStreams;
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo.Builder<T> setEnableFlowLimiting(boolean enableFlowLimiting) {
            this.enableFlowLimiting = Boolean.valueOf(enableFlowLimiting);
            return this;
        }

        @Override // com.google.mediapipe.tasks.core.TaskInfo.Builder
        public TaskInfo<T> autoBuild() {
            String str;
            if (this.taskName != null) {
                str = "";
            } else {
                str = " taskName";
            }
            if (this.taskRunningModeName == null) {
                str = str + " taskRunningModeName";
            }
            if (this.taskGraphName == null) {
                str = str + " taskGraphName";
            }
            if (this.taskOptions == null) {
                str = str + " taskOptions";
            }
            if (this.inputStreams == null) {
                str = str + " inputStreams";
            }
            if (this.outputStreams == null) {
                str = str + " outputStreams";
            }
            if (this.enableFlowLimiting == null) {
                str = str + " enableFlowLimiting";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_TaskInfo(this.taskName, this.taskRunningModeName, this.taskGraphName, this.taskOptions, this.inputStreams, this.outputStreams, this.enableFlowLimiting.booleanValue());
        }
    }
}
