package com.google.mediapipe.tasks.core;

import android.util.Log;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class OutputHandler<OutputT extends TaskResult, InputT> {
    private static final String TAG = "OutputHandler";
    protected OutputT cachedTaskResult;
    protected ErrorListener errorListener;
    private OutputPacketConverter<OutputT, InputT> outputPacketConverter;
    private ResultListener<OutputT, InputT> resultListener;
    private MediaPipeException cachedException = null;
    protected long latestOutputTimestamp = -1;
    private boolean handleTimestampBoundChanges = false;

    public interface OutputPacketConverter<OutputT extends TaskResult, InputT> {
        InputT convertToTaskInput(List<Packet> packets);

        OutputT convertToTaskResult(List<Packet> packets);
    }

    public interface ProgressListener<OutputT> {
        void run(OutputT partialResult, boolean done);
    }

    public interface PureResultListener<OutputT extends TaskResult> {
        void run(OutputT result);
    }

    public interface ResultListener<OutputT extends TaskResult, InputT> {
        void run(OutputT result, InputT input);
    }

    public interface ValueListener<OutputT> {
        void run(OutputT result);
    }

    public void setOutputPacketConverter(OutputPacketConverter<OutputT, InputT> converter) {
        this.outputPacketConverter = converter;
    }

    public void setResultListener(ResultListener<OutputT, InputT> listener) {
        this.resultListener = listener;
    }

    public void setErrorListener(ErrorListener listener) {
        this.errorListener = listener;
    }

    public void setHandleTimestampBoundChanges(boolean handleTimestampBoundChanges) {
        this.handleTimestampBoundChanges = handleTimestampBoundChanges;
    }

    boolean handleTimestampBoundChanges() {
        return this.handleTimestampBoundChanges;
    }

    public OutputT retrieveCachedTaskResult() {
        MediaPipeException mediaPipeException = this.cachedException;
        if (mediaPipeException != null) {
            this.cachedException = null;
            throw mediaPipeException;
        }
        OutputT outputt = this.cachedTaskResult;
        this.cachedTaskResult = null;
        return outputt;
    }

    public long getLatestOutputTimestamp() {
        return this.latestOutputTimestamp;
    }

    void run(List<Packet> list) {
        try {
            OutputT outputt = (OutputT) this.outputPacketConverter.convertToTaskResult(list);
            if (this.resultListener == null) {
                this.cachedTaskResult = outputt;
                this.latestOutputTimestamp = list.get(0).getTimestamp();
            } else {
                this.resultListener.run(outputt, this.outputPacketConverter.convertToTaskInput(list));
            }
        } catch (MediaPipeException e) {
            this.cachedException = e;
            ErrorListener errorListener = this.errorListener;
            if (errorListener != null) {
                errorListener.onError(e);
            } else {
                Log.e(TAG, "Error occurs when getting MediaPipe task result. " + e);
            }
        }
    }
}
