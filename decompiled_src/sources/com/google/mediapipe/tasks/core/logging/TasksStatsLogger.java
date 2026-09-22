package com.google.mediapipe.tasks.core.logging;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface TasksStatsLogger {
    void logInitError();

    void logInvocationReport(StatsSnapshot stats);

    void logSessionClone();

    void logSessionEnd();

    void logSessionStart();

    void recordCpuInputArrival(long packetTimestamp);

    void recordGpuInputArrival(long packetTimestamp);

    void recordInvocationEnd(long packetTimestamp);

    public static abstract class StatsSnapshot {
        abstract int cpuInputCount();

        abstract int droppedCount();

        abstract long elapsedTimeMs();

        abstract int finishedCount();

        abstract int gpuInputCount();

        abstract long peakLatencyMs();

        abstract long totalLatencyMs();

        static StatsSnapshot create(int cpuInputCount, int gpuInputCount, int finishedCount, int droppedCount, long totalLatencyMs, long peakLatencyMs, long elapsedTimeMs) {
            return new AutoValue_TasksStatsLogger_StatsSnapshot(cpuInputCount, gpuInputCount, finishedCount, droppedCount, totalLatencyMs, peakLatencyMs, elapsedTimeMs);
        }

        static StatsSnapshot createDefault() {
            return new AutoValue_TasksStatsLogger_StatsSnapshot(0, 0, 0, 0, 0L, 0L, 0L);
        }
    }
}
