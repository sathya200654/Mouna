package com.google.mediapipe.framework;

import com.google.common.base.Preconditions;
import com.google.mediapipe.proto.CalculatorProfileProto;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class GraphProfiler {
    private final Graph mediapipeGraph;
    private final long nativeProfilerHandle;

    private native byte[][] nativeGetCalculatorProfiles(long profilingContextHandle);

    private native void nativePause(long profilingContextHandle);

    private native void nativeReset(long profilingContextHandle);

    private native void nativeResume(long profilingContextHandle);

    GraphProfiler(long nativeProfilerHandle, Graph mediapipeGraph) {
        Preconditions.checkState(nativeProfilerHandle != 0, "Invalid profiler, tearDown() might have been called already.");
        this.nativeProfilerHandle = nativeProfilerHandle;
        this.mediapipeGraph = mediapipeGraph;
    }

    public void reset() {
        synchronized (this.mediapipeGraph) {
            checkContext();
            nativeReset(this.nativeProfilerHandle);
        }
    }

    public void resume() {
        synchronized (this.mediapipeGraph) {
            checkContext();
            nativeResume(this.nativeProfilerHandle);
        }
    }

    public void pause() {
        synchronized (this.mediapipeGraph) {
            checkContext();
            nativePause(this.nativeProfilerHandle);
        }
    }

    public List<CalculatorProfileProto.CalculatorProfile> getCalculatorProfiles() {
        synchronized (this.mediapipeGraph) {
            checkContext();
            byte[][] bArrNativeGetCalculatorProfiles = nativeGetCalculatorProfiles(this.nativeProfilerHandle);
            ArrayList arrayList = new ArrayList();
            if (bArrNativeGetCalculatorProfiles == null) {
                return arrayList;
            }
            for (byte[] bArr : bArrNativeGetCalculatorProfiles) {
                try {
                    arrayList.add(CalculatorProfileProto.CalculatorProfile.parseFrom(bArr));
                } catch (InvalidProtocolBufferException e) {
                    throw new RuntimeException(e);
                }
            }
            return arrayList;
        }
    }

    private void checkContext() {
        Preconditions.checkState(this.mediapipeGraph.getNativeHandle() != 0, "Invalid context, tearDown() might have been called already.");
    }
}
