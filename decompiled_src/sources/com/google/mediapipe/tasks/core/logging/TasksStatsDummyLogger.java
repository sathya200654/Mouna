package com.google.mediapipe.tasks.core.logging;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TasksStatsDummyLogger implements TasksStatsLogger {
    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logInitError() {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logInvocationReport(TasksStatsLogger.StatsSnapshot stats) {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logSessionClone() {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logSessionEnd() {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logSessionStart() {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void recordCpuInputArrival(long packetTimestamp) {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void recordGpuInputArrival(long packetTimestamp) {
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void recordInvocationEnd(long packetTimestamp) {
    }

    public static TasksStatsDummyLogger create(Context context, String taskNameStr, String taskRunningModeStr) {
        return new TasksStatsDummyLogger();
    }

    private TasksStatsDummyLogger() {
    }
}
