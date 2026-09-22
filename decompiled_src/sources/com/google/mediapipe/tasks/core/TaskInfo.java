package com.google.mediapipe.tasks.core;

import com.google.mediapipe.calculator.proto.FlowLimiterCalculatorProto;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.proto.CalculatorOptionsProto;
import com.google.mediapipe.proto.CalculatorProto;
import com.google.mediapipe.tasks.core.TaskOptions;
import com.google.protobuf.Any;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class TaskInfo<T extends TaskOptions> {
    abstract boolean enableFlowLimiting();

    abstract List<String> inputStreams();

    abstract List<String> outputStreams();

    abstract String taskGraphName();

    abstract String taskName();

    abstract T taskOptions();

    abstract String taskRunningModeName();

    public static abstract class Builder<T extends TaskOptions> {
        public abstract TaskInfo<T> autoBuild();

        public abstract Builder<T> setEnableFlowLimiting(boolean value);

        public abstract Builder<T> setInputStreams(List<String> value);

        public abstract Builder<T> setOutputStreams(List<String> value);

        public abstract Builder<T> setTaskGraphName(String value);

        public abstract Builder<T> setTaskName(String value);

        public abstract Builder<T> setTaskOptions(T value);

        public abstract Builder<T> setTaskRunningModeName(String value);

        public final TaskInfo<T> build() {
            TaskInfo<T> taskInfoAutoBuild = autoBuild();
            if (taskInfoAutoBuild.taskGraphName().isEmpty() || taskInfoAutoBuild.inputStreams().isEmpty() || taskInfoAutoBuild.outputStreams().isEmpty()) {
                throw new IllegalArgumentException("Task graph's name, input streams, and output streams should be non-empty.");
            }
            return taskInfoAutoBuild;
        }
    }

    public static <T extends TaskOptions> Builder<T> builder() {
        return new AutoValue_TaskInfo.Builder().setTaskName("").setTaskRunningModeName("");
    }

    List<String> outputStreamNames() {
        ArrayList arrayList = new ArrayList(outputStreams().size());
        for (String str : outputStreams()) {
            arrayList.add(str.substring(str.lastIndexOf(58) + 1));
        }
        return arrayList;
    }

    CalculatorProto.CalculatorGraphConfig generateGraphConfig() {
        CalculatorProto.CalculatorGraphConfig.Builder builderNewBuilder = CalculatorProto.CalculatorGraphConfig.newBuilder();
        CalculatorOptionsProto.CalculatorOptions calculatorOptionsConvertToCalculatorOptionsProto = taskOptions().convertToCalculatorOptionsProto();
        Any anyConvertToAnyProto = taskOptions().convertToAnyProto();
        if (!((calculatorOptionsConvertToCalculatorOptionsProto == null) ^ (anyConvertToAnyProto == null))) {
            throw new MediaPipeException(MediaPipeException.StatusCode.INVALID_ARGUMENT.ordinal(), "Only one of convertTo*Proto() method should be implemented for " + taskOptions().getClass());
        }
        CalculatorProto.CalculatorGraphConfig.Node.Builder calculator = CalculatorProto.CalculatorGraphConfig.Node.newBuilder().setCalculator(taskGraphName());
        if (calculatorOptionsConvertToCalculatorOptionsProto != null) {
            calculator.setOptions(calculatorOptionsConvertToCalculatorOptionsProto);
        }
        if (anyConvertToAnyProto != null) {
            calculator.addNodeOptions(anyConvertToAnyProto);
        }
        for (String str : outputStreams()) {
            calculator.addOutputStream(str);
            builderNewBuilder.addOutputStream(str);
        }
        if (!enableFlowLimiting()) {
            for (String str2 : inputStreams()) {
                calculator.addInputStream(str2);
                builderNewBuilder.addInputStream(str2);
            }
            builderNewBuilder.addNode((CalculatorProto.CalculatorGraphConfig.Node) calculator.build());
            return (CalculatorProto.CalculatorGraphConfig) builderNewBuilder.build();
        }
        CalculatorProto.CalculatorGraphConfig.Node.Builder options = CalculatorProto.CalculatorGraphConfig.Node.newBuilder().setCalculator("FlowLimiterCalculator").addInputStreamInfo((CalculatorProto.InputStreamInfo) CalculatorProto.InputStreamInfo.newBuilder().setTagIndex("FINISHED").setBackEdge(true).build()).setOptions((CalculatorOptionsProto.CalculatorOptions) CalculatorOptionsProto.CalculatorOptions.newBuilder().setExtension(FlowLimiterCalculatorProto.FlowLimiterCalculatorOptions.ext, (FlowLimiterCalculatorProto.FlowLimiterCalculatorOptions) FlowLimiterCalculatorProto.FlowLimiterCalculatorOptions.newBuilder().setMaxInFlight(1).setMaxInQueue(1).build()).build());
        for (String str3 : inputStreams()) {
            builderNewBuilder.addInputStream(str3);
            options.addInputStream(stripTagIndex(str3));
            String strAddStreamNamePrefix = addStreamNamePrefix(str3);
            options.addOutputStream(stripTagIndex(strAddStreamNamePrefix));
            calculator.addInputStream(strAddStreamNamePrefix);
        }
        options.addInputStream("FINISHED:" + stripTagIndex(outputStreams().get(0)));
        builderNewBuilder.addNode((CalculatorProto.CalculatorGraphConfig.Node) options.build());
        builderNewBuilder.addNode((CalculatorProto.CalculatorGraphConfig.Node) calculator.build());
        return (CalculatorProto.CalculatorGraphConfig) builderNewBuilder.build();
    }

    private String stripTagIndex(String tagIndexName) {
        return tagIndexName.substring(tagIndexName.lastIndexOf(58) + 1);
    }

    private String addStreamNamePrefix(String tagIndexName) {
        return tagIndexName.substring(0, tagIndexName.lastIndexOf(58) + 1) + "throttled_" + stripTagIndex(tagIndexName);
    }
}
