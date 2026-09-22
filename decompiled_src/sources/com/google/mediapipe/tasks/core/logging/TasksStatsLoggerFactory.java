package com.google.mediapipe.tasks.core.logging;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class TasksStatsLoggerFactory {
    public static TasksStatsLogger create(Context context, String taskNameStr, String taskRunningModeStr) {
        return TasksStatsProtoLogger.create(context, taskNameStr, taskRunningModeStr);
    }
}
