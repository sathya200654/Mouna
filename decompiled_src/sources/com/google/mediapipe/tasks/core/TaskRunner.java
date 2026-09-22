package com.google.mediapipe.tasks.core;

import android.content.Context;
import android.util.Log;
import com.google.mediapipe.framework.AndroidAssetUtil;
import com.google.mediapipe.framework.AndroidPacketCreator;
import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketListCallback;
import com.google.mediapipe.proto.CalculatorProto;
import com.google.mediapipe.tasks.core.logging.TasksStatsLogger;
import com.google.mediapipe.tasks.core.logging.TasksStatsLoggerFactory;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class TaskRunner implements AutoCloseable {
    private static final String TAG = "TaskRunner";
    private static final long TIMESATMP_UNITS_PER_SECOND = 1000000;
    private ErrorListener errorListener;
    private final Graph graph;
    private final AtomicBoolean graphStarted;
    private long lastSeenTimestamp;
    private final ModelResourcesCache modelResourcesCache;
    private final OutputHandler<? extends TaskResult, ?> outputHandler;
    private final AndroidPacketCreator packetCreator;
    private final TasksStatsLogger statsLogger;

    public static TaskRunner create(Context context, TaskInfo<? extends TaskOptions> taskInfo, final OutputHandler<? extends TaskResult, ?> outputHandler) throws Throwable {
        final TasksStatsLogger tasksStatsLoggerCreate = TasksStatsLoggerFactory.create(context, taskInfo.taskName(), taskInfo.taskRunningModeName());
        AndroidAssetUtil.initializeNativeAssetManager(context);
        Graph graph = new Graph();
        graph.loadBinaryGraph(taskInfo.generateGraphConfig());
        ModelResourcesCache modelResourcesCache = new ModelResourcesCache();
        graph.setServiceObject(new ModelResourcesCacheService(), modelResourcesCache);
        graph.addMultiStreamCallback(taskInfo.outputStreamNames(), new PacketListCallback() { // from class: com.google.mediapipe.tasks.core.TaskRunner$$ExternalSyntheticLambda0
            @Override // com.google.mediapipe.framework.PacketListCallback
            public final void process(List list) {
                TaskRunner.lambda$create$0(outputHandler, tasksStatsLoggerCreate, list);
            }
        }, outputHandler.handleTimestampBoundChanges());
        graph.startRunningGraph();
        graph.waitUntilGraphIdle();
        return new TaskRunner(graph, modelResourcesCache, outputHandler, tasksStatsLoggerCreate);
    }

    static /* synthetic */ void lambda$create$0(OutputHandler outputHandler, TasksStatsLogger tasksStatsLogger, List list) {
        outputHandler.run(list);
        tasksStatsLogger.recordInvocationEnd(((Packet) list.get(0)).getTimestamp());
    }

    public void setErrorListener(ErrorListener listener) {
        this.errorListener = listener;
    }

    public AndroidPacketCreator getPacketCreator() {
        return this.packetCreator;
    }

    public synchronized TaskResult process(Map<String, Packet> inputs) {
        long jGenerateSyntheticTimestamp = generateSyntheticTimestamp();
        this.statsLogger.recordCpuInputArrival(jGenerateSyntheticTimestamp);
        addPackets(inputs, jGenerateSyntheticTimestamp);
        this.graph.waitUntilGraphIdle();
        this.lastSeenTimestamp = this.outputHandler.getLatestOutputTimestamp();
        return this.outputHandler.retrieveCachedTaskResult();
    }

    public synchronized TaskResult process(Map<String, Packet> inputs, long inputTimestamp) {
        validateInputTimstamp(inputTimestamp);
        this.statsLogger.recordCpuInputArrival(inputTimestamp);
        addPackets(inputs, inputTimestamp);
        this.graph.waitUntilGraphIdle();
        return this.outputHandler.retrieveCachedTaskResult();
    }

    public synchronized void send(Map<String, Packet> inputs, long inputTimestamp) {
        validateInputTimstamp(inputTimestamp);
        this.statsLogger.recordCpuInputArrival(inputTimestamp);
        addPackets(inputs, inputTimestamp);
    }

    public void restart() throws Throwable {
        if (this.graphStarted.get()) {
            try {
                this.graphStarted.set(false);
                this.graph.closeAllPacketSources();
                this.graph.waitUntilGraphDone();
                this.statsLogger.logSessionEnd();
            } catch (MediaPipeException e) {
                reportError(e);
            }
        }
        try {
            this.graph.startRunningGraph();
            this.graph.waitUntilGraphIdle();
            this.graphStarted.set(true);
            this.statsLogger.logSessionStart();
        } catch (MediaPipeException e2) {
            reportError(e2);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.graphStarted.get()) {
            try {
                this.graphStarted.set(false);
                this.graph.closeAllPacketSources();
                this.graph.waitUntilGraphDone();
                this.statsLogger.logSessionEnd();
                ModelResourcesCache modelResourcesCache = this.modelResourcesCache;
                if (modelResourcesCache != null) {
                    modelResourcesCache.release();
                }
            } catch (MediaPipeException e) {
                reportError(e);
            }
            try {
                this.graph.tearDown();
            } catch (MediaPipeException e2) {
                reportError(e2);
            }
        }
    }

    public CalculatorProto.CalculatorGraphConfig getCalculatorGraphConfig() {
        return this.graph.getCalculatorGraphConfig();
    }

    private synchronized void addPackets(Map<String, Packet> inputs, long inputTimestamp) {
        try {
            if (!this.graphStarted.get()) {
                reportError(new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "The task graph hasn't been successfully started or error occurs during graph initializaton."));
            }
            try {
                try {
                    for (Map.Entry<String, Packet> entry : inputs.entrySet()) {
                        this.graph.addConsumablePacketToInputStream(entry.getKey(), entry.getValue(), inputTimestamp);
                        entry.setValue(null);
                    }
                    for (Packet packet : inputs.values()) {
                        if (packet != null) {
                            packet.release();
                        }
                    }
                } catch (MediaPipeException e) {
                    if (this.errorListener == null) {
                        Log.e(TAG, "Mediapipe error: ", e);
                        for (Packet packet2 : inputs.values()) {
                            if (packet2 != null) {
                                packet2.release();
                            }
                        }
                    } else {
                        throw e;
                    }
                }
            } catch (Throwable th) {
                for (Packet packet3 : inputs.values()) {
                    if (packet3 != null) {
                        packet3.release();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void validateInputTimstamp(long inputTimestamp) {
        if (this.lastSeenTimestamp >= inputTimestamp) {
            reportError(new MediaPipeException(MediaPipeException.StatusCode.FAILED_PRECONDITION.ordinal(), "The received packets having a smaller timestamp than the processed timestamp."));
        }
        this.lastSeenTimestamp = inputTimestamp;
    }

    private long generateSyntheticTimestamp() {
        long j = this.lastSeenTimestamp;
        long j2 = j == Long.MIN_VALUE ? 0L : j + TIMESATMP_UNITS_PER_SECOND;
        this.lastSeenTimestamp = j2;
        return j2;
    }

    private TaskRunner(Graph graph, ModelResourcesCache modelResourcesCache, OutputHandler<? extends TaskResult, ?> outputHandler, TasksStatsLogger statsLogger) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.graphStarted = atomicBoolean;
        this.lastSeenTimestamp = Long.MIN_VALUE;
        this.outputHandler = outputHandler;
        this.graph = graph;
        this.modelResourcesCache = modelResourcesCache;
        this.packetCreator = new AndroidPacketCreator(graph);
        this.statsLogger = statsLogger;
        atomicBoolean.set(true);
        statsLogger.logSessionStart();
    }

    private void reportError(MediaPipeException e) {
        ErrorListener errorListener = this.errorListener;
        if (errorListener != null) {
            errorListener.onError(e);
            return;
        }
        throw e;
    }
}
