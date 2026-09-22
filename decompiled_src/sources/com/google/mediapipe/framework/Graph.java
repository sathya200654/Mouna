package com.google.mediapipe.framework;

import com.google.common.base.Preconditions;
import com.google.common.flogger.FluentLogger;
import com.google.mediapipe.proto.CalculatorProto;
import com.google.mediapipe.proto.GraphTemplateProto;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class Graph {
    private static final int MAX_BUFFER_SIZE = 20;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private final List<Object> callbacks = new ArrayList();
    private Map<String, Packet> sidePackets = new HashMap();
    private Map<String, Packet> streamHeaders = new HashMap();
    private boolean stepMode = false;
    private boolean startRunningGraphCalled = false;
    private boolean graphRunning = false;
    private Map<String, ArrayList<PacketBufferItem>> packetBuffers = new HashMap();
    private final Object terminationLock = new Object();
    private long nativeGraphHandle = nativeCreateGraph();

    private native void nativeAddMultiStreamCallback(long context, List<String> streamName, PacketListCallback callback, boolean observeTimestampBounds);

    private native void nativeAddPacketCallback(long context, String streamName, PacketCallback callback);

    private native void nativeAddPacketToInputStream(long context, String streamName, long packet, long timestamp);

    private native long nativeAddSurfaceOutput(long context, String streamName);

    private native void nativeCancelGraph(long context);

    private native void nativeCloseAllInputStreams(long context);

    private native void nativeCloseAllPacketSources(long context);

    private native void nativeCloseInputStream(long context, String streamName);

    private native long nativeCreateGraph();

    private native byte[] nativeGetCalculatorGraphConfig(long context);

    private native long nativeGetProfiler(long context);

    private native void nativeLoadBinaryGraph(long context, String path);

    private native void nativeLoadBinaryGraphBytes(long context, byte[] data);

    private native void nativeLoadBinaryGraphTemplate(long context, byte[] data);

    private native void nativeMovePacketToInputStream(long context, String streamName, long packet, long timestamp);

    private native void nativeReleaseGraph(long context);

    private native void nativeRunGraphUntilClose(long context, String[] streamNames, long[] packets);

    private native void nativeSetGraphInputStreamBlockingMode(long context, boolean mode);

    private native void nativeSetGraphOptions(long context, byte[] data);

    private native void nativeSetGraphType(long context, String graphType);

    private native void nativeSetParentGlContext(long context, long javaGlContext);

    private native void nativeStartRunningGraph(long context, String[] sidePacketNames, long[] sidePacketHandles, String[] streamNamesWithHeader, long[] streamHeaderHandles);

    private native void nativeUpdatePacketReference(long referencePacket, long newPacket);

    private native void nativeWaitUntilGraphDone(long context);

    private native void nativeWaitUntilGraphIdle(long context);

    private static class PacketBufferItem {
        final Packet packet;
        final Long timestamp;

        private PacketBufferItem(Packet packet, Long timestamp) {
            this.packet = packet;
            this.timestamp = timestamp;
        }
    }

    public synchronized long getNativeHandle() {
        return this.nativeGraphHandle;
    }

    public synchronized void setStepMode(boolean stepMode) {
        this.stepMode = stepMode;
    }

    public synchronized boolean getStepMode() {
        return this.stepMode;
    }

    public synchronized void loadBinaryGraph(String path) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        nativeLoadBinaryGraph(this.nativeGraphHandle, path);
    }

    public synchronized void loadBinaryGraph(byte[] data) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        nativeLoadBinaryGraphBytes(this.nativeGraphHandle, data);
    }

    public synchronized void loadBinaryGraph(CalculatorProto.CalculatorGraphConfig config) {
        loadBinaryGraph(config.toByteArray());
    }

    public synchronized void loadBinaryGraphTemplate(GraphTemplateProto.CalculatorGraphTemplate template) {
        nativeLoadBinaryGraphTemplate(this.nativeGraphHandle, template.toByteArray());
    }

    public synchronized void loadBinaryGraphTemplate(byte[] data) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        nativeLoadBinaryGraphTemplate(this.nativeGraphHandle, data);
    }

    public synchronized void setGraphType(String graphType) {
        nativeSetGraphType(this.nativeGraphHandle, graphType);
    }

    public synchronized void setGraphOptions(CalculatorProto.CalculatorGraphConfig.Node options) {
        nativeSetGraphOptions(this.nativeGraphHandle, options.toByteArray());
    }

    public synchronized CalculatorProto.CalculatorGraphConfig getCalculatorGraphConfig(ExtensionRegistryLite registry) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        byte[] bArrNativeGetCalculatorGraphConfig = nativeGetCalculatorGraphConfig(this.nativeGraphHandle);
        if (bArrNativeGetCalculatorGraphConfig == null) {
            return null;
        }
        try {
            return CalculatorProto.CalculatorGraphConfig.parseFrom(bArrNativeGetCalculatorGraphConfig, registry);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized CalculatorProto.CalculatorGraphConfig getCalculatorGraphConfig() {
        return getCalculatorGraphConfig(ProtoUtil.getExtensionRegistry());
    }

    public synchronized void addPacketCallback(String streamName, PacketCallback callback) {
        boolean z = true;
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        Preconditions.checkNotNull(streamName);
        Preconditions.checkNotNull(callback);
        if (this.graphRunning || this.startRunningGraphCalled) {
            z = false;
        }
        Preconditions.checkState(z);
        this.callbacks.add(callback);
        nativeAddPacketCallback(this.nativeGraphHandle, streamName, callback);
    }

    public synchronized void addMultiStreamCallback(List<String> streamNames, PacketListCallback callback) {
        addMultiStreamCallback(streamNames, callback, false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0026  */
    public synchronized void addMultiStreamCallback(List<String> streamNames, PacketListCallback callback, boolean observeTimestampBounds) throws Throwable {
        Throwable th;
        boolean z;
        try {
            try {
                Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
                Preconditions.checkNotNull(streamNames);
                Preconditions.checkNotNull(callback);
                if (!this.graphRunning) {
                    try {
                        z = this.startRunningGraphCalled ? false : true;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                Preconditions.checkState(z);
                this.callbacks.add(callback);
                nativeAddMultiStreamCallback(this.nativeGraphHandle, streamNames, callback, observeTimestampBounds);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized SurfaceOutput addSurfaceOutput(String streamName) {
        boolean z = true;
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        Preconditions.checkNotNull(streamName);
        if (this.graphRunning || this.startRunningGraphCalled) {
            z = false;
        }
        Preconditions.checkState(z);
        return new SurfaceOutput(this, Packet.create(nativeAddSurfaceOutput(this.nativeGraphHandle, streamName)));
    }

    public synchronized void setInputSidePackets(Map<String, Packet> sidePackets) {
        boolean z = true;
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        if (this.graphRunning || this.startRunningGraphCalled) {
            z = false;
        }
        Preconditions.checkState(z);
        for (Map.Entry<String, Packet> entry : sidePackets.entrySet()) {
            this.sidePackets.put(entry.getKey(), entry.getValue().copy());
        }
    }

    public synchronized <T> void setServiceObject(GraphService<T> service, T object) {
        service.installServiceObject(this.nativeGraphHandle, object);
    }

    public synchronized void addStreamNameExpectingHeader(String streamName) {
        Preconditions.checkState((this.graphRunning || this.startRunningGraphCalled) ? false : true);
        this.streamHeaders.put(streamName, null);
    }

    public synchronized void setStreamHeader(String streamName, Packet streamHeader) {
        setStreamHeader(streamName, streamHeader, false);
    }

    public synchronized void setStreamHeader(String streamName, Packet streamHeader, boolean override) {
        Packet packet = this.streamHeaders.get(streamName);
        if (packet != null) {
            if (!override) {
                return;
            }
            if (this.graphRunning) {
                throw new IllegalArgumentException("Can't override an existing stream header, after graph started running.");
            }
            packet.release();
        }
        this.streamHeaders.put(streamName, streamHeader.copy());
        if (!this.graphRunning && this.startRunningGraphCalled && hasAllStreamHeaders()) {
            startRunningGraph();
        }
    }

    public synchronized void runGraphUntilClose() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        Preconditions.checkNotNull(this.sidePackets);
        String[] strArr = new String[this.sidePackets.size()];
        long[] jArr = new long[this.sidePackets.size()];
        splitStreamNamePacketMap(this.sidePackets, strArr, jArr);
        nativeRunGraphUntilClose(this.nativeGraphHandle, strArr, jArr);
    }

    public synchronized void startRunningGraph() throws Throwable {
        try {
            try {
                Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
                this.startRunningGraphCalled = true;
                if (!hasAllStreamHeaders()) {
                    logger.atInfo().log("MediaPipe graph won't start until all stream headers are available.");
                    return;
                }
                String[] strArr = new String[this.sidePackets.size()];
                long[] jArr = new long[this.sidePackets.size()];
                splitStreamNamePacketMap(this.sidePackets, strArr, jArr);
                String[] strArr2 = new String[this.streamHeaders.size()];
                long[] jArr2 = new long[this.streamHeaders.size()];
                splitStreamNamePacketMap(this.streamHeaders, strArr2, jArr2);
                nativeStartRunningGraph(this.nativeGraphHandle, strArr, jArr, strArr2, jArr2);
                this.graphRunning = true;
                moveBufferedPacketsToInputStream();
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public synchronized void setGraphInputStreamBlockingMode(boolean mode) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        Preconditions.checkState(!this.graphRunning);
        nativeSetGraphInputStreamBlockingMode(this.nativeGraphHandle, mode);
    }

    public synchronized void addPacketToInputStream(String streamName, Packet packet, long timestamp) throws Throwable {
        Throwable th;
        Graph graph;
        try {
            try {
                Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
                if (!this.graphRunning) {
                    try {
                        addPacketToBuffer(streamName, packet.copy(), timestamp);
                        graph = this;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    graph = this;
                    graph.nativeAddPacketToInputStream(this.nativeGraphHandle, streamName, packet.getNativeHandle(), timestamp);
                }
                return;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    public synchronized void addConsumablePacketToInputStream(String streamName, Packet packet, long timestamp) throws Throwable {
        Throwable th;
        Graph graph;
        try {
            try {
                Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
                if (!this.graphRunning) {
                    try {
                        addPacketToBuffer(streamName, packet.copy(), timestamp);
                        packet.release();
                        graph = this;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    graph = this;
                    graph.nativeMovePacketToInputStream(this.nativeGraphHandle, streamName, packet.getNativeHandle(), timestamp);
                    packet.release();
                }
                return;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        throw th;
    }

    public synchronized void closeInputStream(String streamName) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        nativeCloseInputStream(this.nativeGraphHandle, streamName);
    }

    public synchronized void closeAllInputStreams() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        nativeCloseAllInputStreams(this.nativeGraphHandle);
    }

    public synchronized void closeAllPacketSources() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        nativeCloseAllPacketSources(this.nativeGraphHandle);
    }

    public synchronized void waitUntilGraphDone() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        nativeWaitUntilGraphDone(this.nativeGraphHandle);
    }

    public synchronized void waitUntilGraphIdle() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called.");
        nativeWaitUntilGraphIdle(this.nativeGraphHandle);
    }

    public synchronized void tearDown() {
        try {
            Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
            Iterator<Map.Entry<String, Packet>> it = this.sidePackets.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().release();
            }
            this.sidePackets.clear();
            for (Map.Entry<String, Packet> entry : this.streamHeaders.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().release();
                }
            }
            this.streamHeaders.clear();
            Iterator<Map.Entry<String, ArrayList<PacketBufferItem>>> it2 = this.packetBuffers.entrySet().iterator();
            while (it2.hasNext()) {
                Iterator<PacketBufferItem> it3 = it2.next().getValue().iterator();
                while (it3.hasNext()) {
                    it3.next().packet.release();
                }
            }
            this.packetBuffers.clear();
            synchronized (this.terminationLock) {
                long j = this.nativeGraphHandle;
                if (j != 0) {
                    nativeReleaseGraph(j);
                    this.nativeGraphHandle = 0L;
                }
            }
            this.callbacks.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void updatePacketReference(Packet referencePacket, Packet newPacket) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        nativeUpdatePacketReference(referencePacket.getNativeHandle(), newPacket.getNativeHandle());
    }

    @Deprecated
    public synchronized void createGlRunner(String name, long javaGlContext) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        Preconditions.checkArgument(name.equals("gpu_shared"));
        setParentGlContext(javaGlContext);
    }

    public synchronized void setParentGlContext(long javaGlContext) {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        Preconditions.checkState(!this.graphRunning);
        nativeSetParentGlContext(this.nativeGraphHandle, javaGlContext);
    }

    public synchronized void cancelGraph() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        nativeCancelGraph(this.nativeGraphHandle);
    }

    public GraphProfiler getProfiler() {
        Preconditions.checkState(this.nativeGraphHandle != 0, "Invalid context, tearDown() might have been called already.");
        return new GraphProfiler(nativeGetProfiler(this.nativeGraphHandle), this);
    }

    private boolean addPacketToBuffer(String streamName, Packet packet, long timestamp) {
        if (!this.packetBuffers.containsKey(streamName)) {
            this.packetBuffers.put(streamName, new ArrayList<>());
        }
        ArrayList<PacketBufferItem> arrayList = this.packetBuffers.get(streamName);
        if (arrayList.size() > 20) {
            for (Map.Entry<String, Packet> entry : this.streamHeaders.entrySet()) {
                if (entry.getValue() == null) {
                    logger.atSevere().log("Stream: %s might be missing.", entry.getKey());
                }
            }
            throw new RuntimeException("Graph is not started because of missing streams");
        }
        arrayList.add(new PacketBufferItem(packet, Long.valueOf(timestamp)));
        return true;
    }

    private void moveBufferedPacketsToInputStream() {
        if (this.packetBuffers.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ArrayList<PacketBufferItem>> entry : this.packetBuffers.entrySet()) {
            for (PacketBufferItem packetBufferItem : entry.getValue()) {
                try {
                    Graph graph = this;
                    graph.nativeMovePacketToInputStream(this.nativeGraphHandle, entry.getKey(), packetBufferItem.packet.getNativeHandle(), packetBufferItem.timestamp.longValue());
                    packetBufferItem.packet.release();
                    this = graph;
                } catch (MediaPipeException e) {
                    logger.atSevere().log("AddPacket for stream: %s failed: %s.", entry.getKey(), e.getMessage());
                    throw e;
                }
            }
        }
        this.packetBuffers.clear();
    }

    private static void splitStreamNamePacketMap(Map<String, Packet> namePacketMap, String[] streamNames, long[] packets) {
        if (namePacketMap.size() != streamNames.length || namePacketMap.size() != packets.length) {
            throw new RuntimeException("Input array length doesn't match the map size!");
        }
        int i = 0;
        for (Map.Entry<String, Packet> entry : namePacketMap.entrySet()) {
            streamNames[i] = entry.getKey();
            packets[i] = entry.getValue().getNativeHandle();
            i++;
        }
    }

    private boolean hasAllStreamHeaders() {
        Iterator<Map.Entry<String, Packet>> it = this.streamHeaders.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == null) {
                return false;
            }
        }
        return true;
    }
}
