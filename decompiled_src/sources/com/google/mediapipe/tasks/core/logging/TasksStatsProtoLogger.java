package com.google.mediapipe.tasks.core.logging;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.mediapipe.proto.MediaPipeLoggingEnumsProto;
import com.google.mediapipe.proto.MediaPipeLoggingProto;
import java.time.Instant;
import java.util.Locale;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TasksStatsProtoLogger implements TasksStatsLogger {
    private static final String TAG = "TasksStatsProtoLogger";
    private static final String TASKS_MODE_PREFIX = "MODE_TASKS_";
    private static final String TASKS_NAME_PREFIX = "TASKS_";
    private final LoggingClient loggingClient;
    private long reportStartTimeMs;
    private TasksStatsLogger.StatsSnapshot statsSnapshot;
    private final MediaPipeLoggingProto.SystemInfo systemInfo;
    private final MediaPipeLoggingEnumsProto.SolutionName taskName;
    private final MediaPipeLoggingEnumsProto.SolutionMode taskRunningMode;
    private static final Long REPORT_INTERVAL_MS = 30000L;
    private static final Long LATENCY_TIMEOUT_THRESHOLD_MS = 3000L;
    private final AtomicInteger cpuInputCount = new AtomicInteger(0);
    private final AtomicInteger gpuInputCount = new AtomicInteger(0);
    private final AtomicInteger finishedCount = new AtomicInteger(0);
    private final AtomicInteger droppedCount = new AtomicInteger(0);
    private final AtomicLong totalLatencyMs = new AtomicLong(0);
    private final AtomicLong latestPeakLatencyMs = new AtomicLong(0);
    private final AtomicLong lifetimePeakLatencyMs = new AtomicLong(0);
    private final ConcurrentNavigableMap<Long, Long> startTimeMap = new ConcurrentSkipListMap();
    private final long taskInitTimeMs = System.currentTimeMillis();

    public static TasksStatsProtoLogger create(Context context, String taskNameStr, String taskRunningModeStr) {
        String strValueOf;
        MediaPipeLoggingEnumsProto.SolutionName solutionName;
        MediaPipeLoggingEnumsProto.SolutionMode solutionMode;
        try {
            strValueOf = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Exception thrown when trying to get app version " + e);
            strValueOf = "";
        }
        try {
            solutionName = (MediaPipeLoggingEnumsProto.SolutionName) MediaPipeLoggingEnumsProto.SolutionName.valueOf(MediaPipeLoggingEnumsProto.SolutionName.class, TASKS_NAME_PREFIX + taskNameStr.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException unused) {
            solutionName = MediaPipeLoggingEnumsProto.SolutionName.SOLUTION_UNKNOWN;
        }
        try {
            solutionMode = (MediaPipeLoggingEnumsProto.SolutionMode) MediaPipeLoggingEnumsProto.SolutionMode.valueOf(MediaPipeLoggingEnumsProto.SolutionMode.class, TASKS_MODE_PREFIX + taskRunningModeStr.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException unused2) {
            solutionMode = MediaPipeLoggingEnumsProto.SolutionMode.MODE_TASKS_UNSPECIFIED;
        }
        return new TasksStatsProtoLogger(context, solutionName, solutionMode, (MediaPipeLoggingProto.SystemInfo) MediaPipeLoggingProto.SystemInfo.newBuilder().setPlatform(MediaPipeLoggingEnumsProto.Platform.PLATFORM_ANDROID).setAppId(context.getPackageName()).setAppVersion(strValueOf).build());
    }

    private TasksStatsProtoLogger(Context context, MediaPipeLoggingEnumsProto.SolutionName taskName, MediaPipeLoggingEnumsProto.SolutionMode taskRunningMode, MediaPipeLoggingProto.SystemInfo systemInfo) {
        this.loggingClient = new RemoteLoggingClient(context);
        this.taskName = taskName;
        this.taskRunningMode = taskRunningMode;
        this.systemInfo = systemInfo;
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logSessionStart() {
        logTaskEvent((MediaPipeLoggingProto.SolutionEvent) MediaPipeLoggingProto.SolutionEvent.newBuilder().setSolutionName(this.taskName).setEventName(MediaPipeLoggingEnumsProto.EventName.EVENT_START).setSessionStart((MediaPipeLoggingProto.SolutionSessionStart) MediaPipeLoggingProto.SolutionSessionStart.newBuilder().setMode(this.taskRunningMode).setInitLatencyMs(Instant.now().minusMillis(this.taskInitTimeMs).toEpochMilli()).build()).build());
        this.reportStartTimeMs = System.currentTimeMillis();
        this.statsSnapshot = TasksStatsLogger.StatsSnapshot.createDefault();
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logSessionClone() {
        logTaskEvent((MediaPipeLoggingProto.SolutionEvent) MediaPipeLoggingProto.SolutionEvent.newBuilder().setSolutionName(this.taskName).setEventName(MediaPipeLoggingEnumsProto.EventName.EVENT_START).setSessionClone((MediaPipeLoggingProto.SolutionSessionClone) MediaPipeLoggingProto.SolutionSessionClone.newBuilder().setMode(this.taskRunningMode).setInitLatencyMs(Instant.now().minusMillis(this.taskInitTimeMs).toEpochMilli()).build()).build());
        this.reportStartTimeMs = System.currentTimeMillis();
        this.statsSnapshot = TasksStatsLogger.StatsSnapshot.createDefault();
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void recordCpuInputArrival(long packetTimestamp) {
        this.cpuInputCount.incrementAndGet();
        this.startTimeMap.put(Long.valueOf(packetTimestamp), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void recordGpuInputArrival(long packetTimestamp) {
        this.gpuInputCount.incrementAndGet();
        this.startTimeMap.put(Long.valueOf(packetTimestamp), Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void recordInvocationEnd(long packetTimestamp) {
        boolean z;
        if (this.startTimeMap.containsKey(Long.valueOf(packetTimestamp))) {
            long jCurrentTimeMillis = System.currentTimeMillis() - ((Long) this.startTimeMap.remove(Long.valueOf(packetTimestamp))).longValue();
            this.finishedCount.incrementAndGet();
            if (jCurrentTimeMillis > LATENCY_TIMEOUT_THRESHOLD_MS.longValue()) {
                return;
            }
            this.totalLatencyMs.addAndGet(jCurrentTimeMillis);
            AtomicLong atomicLong = this.latestPeakLatencyMs;
            atomicLong.set(Math.max(atomicLong.get(), jCurrentTimeMillis));
            AtomicLong atomicLong2 = this.lifetimePeakLatencyMs;
            atomicLong2.set(Math.max(atomicLong2.get(), jCurrentTimeMillis));
            TasksStatsLogger.StatsSnapshot statsSnapshotCreateDefault = TasksStatsLogger.StatsSnapshot.createDefault();
            synchronized (this) {
                if (System.currentTimeMillis() > this.reportStartTimeMs + REPORT_INTERVAL_MS.longValue()) {
                    this.droppedCount.addAndGet(this.startTimeMap.headMap(Long.valueOf(packetTimestamp)).size());
                    this.startTimeMap.headMap(Long.valueOf(packetTimestamp)).clear();
                    statsSnapshotCreateDefault = TasksStatsLogger.StatsSnapshot.create(this.cpuInputCount.get(), this.gpuInputCount.get(), this.finishedCount.get(), this.droppedCount.get(), this.totalLatencyMs.get(), this.latestPeakLatencyMs.getAndSet(0L), System.currentTimeMillis() - this.reportStartTimeMs);
                    this.reportStartTimeMs = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                logInvocationReport(TasksStatsLogger.StatsSnapshot.create(statsSnapshotCreateDefault.cpuInputCount() - this.statsSnapshot.cpuInputCount(), statsSnapshotCreateDefault.gpuInputCount() - this.statsSnapshot.gpuInputCount(), statsSnapshotCreateDefault.finishedCount() - this.statsSnapshot.finishedCount(), statsSnapshotCreateDefault.droppedCount() - this.statsSnapshot.droppedCount(), statsSnapshotCreateDefault.totalLatencyMs() - this.statsSnapshot.totalLatencyMs(), statsSnapshotCreateDefault.peakLatencyMs(), statsSnapshotCreateDefault.elapsedTimeMs()));
                this.statsSnapshot = statsSnapshotCreateDefault;
            }
        }
    }

    private MediaPipeLoggingProto.SolutionInvocationReport produceInvocationReport(TasksStatsLogger.StatsSnapshot stats) {
        MediaPipeLoggingProto.SolutionInvocationReport.Builder elapsedTimeMs = MediaPipeLoggingProto.SolutionInvocationReport.newBuilder().setMode(this.taskRunningMode).setDropped(stats.droppedCount()).setPipelinePeakLatencyMs(stats.peakLatencyMs()).setPipelineAverageLatencyMs(stats.totalLatencyMs() / ((long) Math.max(1, stats.finishedCount()))).setElapsedTimeMs(stats.elapsedTimeMs());
        if (stats.cpuInputCount() != 0) {
            elapsedTimeMs.addInvocationCount((MediaPipeLoggingProto.SolutionInvocationCount) MediaPipeLoggingProto.SolutionInvocationCount.newBuilder().setInputDataType(MediaPipeLoggingEnumsProto.InputDataType.INPUT_TYPE_TASKS_CPU).setCount(stats.cpuInputCount()).build());
        }
        if (stats.gpuInputCount() != 0) {
            elapsedTimeMs.addInvocationCount((MediaPipeLoggingProto.SolutionInvocationCount) MediaPipeLoggingProto.SolutionInvocationCount.newBuilder().setInputDataType(MediaPipeLoggingEnumsProto.InputDataType.INPUT_TYPE_TASKS_GPU).setCount(stats.gpuInputCount()).build());
        }
        return (MediaPipeLoggingProto.SolutionInvocationReport) elapsedTimeMs.build();
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logInvocationReport(TasksStatsLogger.StatsSnapshot stats) {
        logTaskEvent((MediaPipeLoggingProto.SolutionEvent) MediaPipeLoggingProto.SolutionEvent.newBuilder().setSolutionName(this.taskName).setEventName(MediaPipeLoggingEnumsProto.EventName.EVENT_INVOCATONS).setInvocationReport(produceInvocationReport(stats)).build());
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logSessionEnd() {
        logTaskEvent((MediaPipeLoggingProto.SolutionEvent) MediaPipeLoggingProto.SolutionEvent.newBuilder().setSolutionName(this.taskName).setEventName(MediaPipeLoggingEnumsProto.EventName.EVENT_END).setSessionEnd((MediaPipeLoggingProto.SolutionSessionEnd) MediaPipeLoggingProto.SolutionSessionEnd.newBuilder().setInvocationReport(produceInvocationReport(TasksStatsLogger.StatsSnapshot.create(this.cpuInputCount.get(), this.gpuInputCount.get(), this.finishedCount.get(), this.startTimeMap.size() + this.droppedCount.get(), this.totalLatencyMs.get(), this.lifetimePeakLatencyMs.get(), System.currentTimeMillis() - this.taskInitTimeMs))).build()).build());
    }

    @Override // com.google.mediapipe.tasks.core.logging.TasksStatsLogger
    public void logInitError() {
        logTaskEvent((MediaPipeLoggingProto.SolutionEvent) MediaPipeLoggingProto.SolutionEvent.newBuilder().setSolutionName(this.taskName).setEventName(MediaPipeLoggingEnumsProto.EventName.EVENT_ERROR).setErrorDetails((MediaPipeLoggingProto.SolutionError) MediaPipeLoggingProto.SolutionError.newBuilder().setErrorCode(MediaPipeLoggingEnumsProto.ErrorCode.ERROR_INIT).build()).build());
    }

    private void logTaskEvent(MediaPipeLoggingProto.SolutionEvent event) {
        this.loggingClient.logEvent((MediaPipeLoggingProto.MediaPipeLogExtension) MediaPipeLoggingProto.MediaPipeLogExtension.newBuilder().setSystemInfo(this.systemInfo).setSolutionEvent(event).build());
    }
}
