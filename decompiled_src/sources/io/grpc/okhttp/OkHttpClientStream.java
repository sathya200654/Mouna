package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Http2ClientStreamTransportState;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import java.util.List;
import okio.Buffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
class OkHttpClientStream extends AbstractClientStream {
    public static final int ABSENT_ID = -1;
    private static final Buffer EMPTY_BUFFER = new Buffer();
    private final Attributes attributes;
    private String authority;
    private final MethodDescriptor<?, ?> method;
    private final Sink sink;
    private final TransportState state;
    private final StatsTraceContext statsTraceCtx;
    private boolean useGet;
    private final String userAgent;

    OkHttpClientStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OkHttpClientTransport okHttpClientTransport, OutboundFlowController outboundFlowController, Object obj, int i, int i2, String str, String str2, StatsTraceContext statsTraceContext, TransportTracer transportTracer, CallOptions callOptions, boolean z) {
        super(new OkHttpWritableBufferAllocator(), statsTraceContext, transportTracer, metadata, callOptions, z && methodDescriptor.isSafe());
        this.sink = new Sink();
        this.useGet = false;
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        this.method = methodDescriptor;
        this.authority = str;
        this.userAgent = str2;
        this.attributes = okHttpClientTransport.getAttributes();
        this.state = new TransportState(i, statsTraceContext, obj, exceptionHandlingFrameWriter, outboundFlowController, okHttpClientTransport, i2, methodDescriptor.getFullMethodName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractClientStream, io.grpc.internal.AbstractStream
    public TransportState transportState() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractClientStream
    public Sink abstractClientStreamSink() {
        return this.sink;
    }

    public MethodDescriptor.MethodType getType() {
        return this.method.getType();
    }

    boolean useGet() {
        return this.useGet;
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        this.authority = (String) Preconditions.checkNotNull(str, "authority");
    }

    @Override // io.grpc.internal.ClientStream
    public Attributes getAttributes() {
        return this.attributes;
    }

    class Sink implements AbstractClientStream.Sink {
        Sink() {
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void writeHeaders(Metadata metadata, byte[] bArr) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("OkHttpClientStream$Sink.writeHeaders");
            try {
                String str = RemoteSettings.FORWARD_SLASH_STRING + OkHttpClientStream.this.method.getFullMethodName();
                if (bArr != null) {
                    OkHttpClientStream.this.useGet = true;
                    str = str + "?" + BaseEncoding.base64().encode(bArr);
                }
                synchronized (OkHttpClientStream.this.state.lock) {
                    try {
                        OkHttpClientStream.this.state.streamReady(metadata, str);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th2) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0046 */
        @Override // io.grpc.internal.AbstractClientStream.Sink
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void writeFrame(io.grpc.internal.WritableBuffer r4, boolean r5, boolean r6, int r7) {
            /*
                r3 = this;
                java.lang.String r0 = "OkHttpClientStream$Sink.writeFrame"
                io.perfmark.TaskCloseable r0 = io.perfmark.PerfMark.traceTask(r0)
                if (r4 != 0) goto Ld
                okio.Buffer r4 = io.grpc.okhttp.OkHttpClientStream.access$500()     // Catch: java.lang.Throwable -> L46
                goto L1f
            Ld:
                io.grpc.okhttp.OkHttpWritableBuffer r4 = (io.grpc.okhttp.OkHttpWritableBuffer) r4     // Catch: java.lang.Throwable -> L46
                okio.Buffer r4 = r4.buffer()     // Catch: java.lang.Throwable -> L46
                long r1 = r4.size()     // Catch: java.lang.Throwable -> L46
                int r1 = (int) r1     // Catch: java.lang.Throwable -> L46
                if (r1 <= 0) goto L1f
                io.grpc.okhttp.OkHttpClientStream r2 = io.grpc.okhttp.OkHttpClientStream.this     // Catch: java.lang.Throwable -> L46
                io.grpc.okhttp.OkHttpClientStream.access$600(r2, r1)     // Catch: java.lang.Throwable -> L46
            L1f:
                io.grpc.okhttp.OkHttpClientStream r1 = io.grpc.okhttp.OkHttpClientStream.this     // Catch: java.lang.Throwable -> L46
                io.grpc.okhttp.OkHttpClientStream$TransportState r1 = io.grpc.okhttp.OkHttpClientStream.access$200(r1)     // Catch: java.lang.Throwable -> L46
                java.lang.Object r1 = io.grpc.okhttp.OkHttpClientStream.TransportState.access$300(r1)     // Catch: java.lang.Throwable -> L46
                monitor-enter(r1)     // Catch: java.lang.Throwable -> L46
                io.grpc.okhttp.OkHttpClientStream r2 = io.grpc.okhttp.OkHttpClientStream.this     // Catch: java.lang.Throwable -> L43
                io.grpc.okhttp.OkHttpClientStream$TransportState r2 = io.grpc.okhttp.OkHttpClientStream.access$200(r2)     // Catch: java.lang.Throwable -> L43
                io.grpc.okhttp.OkHttpClientStream.TransportState.access$700(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L43
                io.grpc.okhttp.OkHttpClientStream r3 = io.grpc.okhttp.OkHttpClientStream.this     // Catch: java.lang.Throwable -> L43
                io.grpc.internal.TransportTracer r3 = io.grpc.okhttp.OkHttpClientStream.access$800(r3)     // Catch: java.lang.Throwable -> L43
                r3.reportMessageSent(r7)     // Catch: java.lang.Throwable -> L43
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L43
                if (r0 == 0) goto L42
                r0.close()
            L42:
                return
            L43:
                r3 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L43
                throw r3     // Catch: java.lang.Throwable -> L46
            L46:
                r3 = move-exception
                if (r0 == 0) goto L51
                r0.close()     // Catch: java.lang.Throwable -> L4d
                goto L51
            L4d:
                r4 = move-exception
                r3.addSuppressed(r4)
            L51:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.OkHttpClientStream.Sink.writeFrame(io.grpc.internal.WritableBuffer, boolean, boolean, int):void");
        }

        @Override // io.grpc.internal.AbstractClientStream.Sink
        public void cancel(Status status) {
            TaskCloseable taskCloseableTraceTask = PerfMark.traceTask("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (OkHttpClientStream.this.state.lock) {
                    try {
                        OkHttpClientStream.this.state.cancel(status, true, null);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (taskCloseableTraceTask != null) {
                    taskCloseableTraceTask.close();
                }
            } catch (Throwable th2) {
                if (taskCloseableTraceTask != null) {
                    try {
                        taskCloseableTraceTask.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    class TransportState extends Http2ClientStreamTransportState implements OutboundFlowController.Stream {
        private boolean canStart;
        private boolean cancelSent;
        private boolean flushPendingData;
        private final ExceptionHandlingFrameWriter frameWriter;
        private int id;
        private final int initialWindowSize;
        private final Object lock;
        private final OutboundFlowController outboundFlow;
        private OutboundFlowController.StreamState outboundFlowState;
        private Buffer pendingData;
        private boolean pendingDataHasEndOfStream;
        private int processedWindow;
        private List<Header> requestHeaders;
        private final Tag tag;
        private final OkHttpClientTransport transport;
        private int window;

        public TransportState(int i, StatsTraceContext statsTraceContext, Object obj, ExceptionHandlingFrameWriter exceptionHandlingFrameWriter, OutboundFlowController outboundFlowController, OkHttpClientTransport okHttpClientTransport, int i2, String str) {
            super(i, statsTraceContext, OkHttpClientStream.this.getTransportTracer());
            this.pendingData = new Buffer();
            this.pendingDataHasEndOfStream = false;
            this.flushPendingData = false;
            this.cancelSent = false;
            this.canStart = true;
            this.id = -1;
            this.lock = Preconditions.checkNotNull(obj, "lock");
            this.frameWriter = exceptionHandlingFrameWriter;
            this.outboundFlow = outboundFlowController;
            this.transport = okHttpClientTransport;
            this.window = i2;
            this.processedWindow = i2;
            this.initialWindowSize = i2;
            this.tag = PerfMark.createTag(str);
        }

        public void start(int i) {
            Preconditions.checkState(this.id == -1, "the stream has been started with id %s", i);
            this.id = i;
            this.outboundFlowState = this.outboundFlow.createState(this, i);
            OkHttpClientStream.this.state.onStreamAllocated();
            if (this.canStart) {
                this.frameWriter.synStream(OkHttpClientStream.this.useGet, false, this.id, 0, this.requestHeaders);
                OkHttpClientStream.this.statsTraceCtx.clientOutboundHeaders();
                this.requestHeaders = null;
                if (this.pendingData.size() > 0) {
                    this.outboundFlow.data(this.pendingDataHasEndOfStream, this.outboundFlowState, this.pendingData, this.flushPendingData);
                }
                this.canStart = false;
            }
        }

        @Override // io.grpc.internal.AbstractStream.TransportState
        protected void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportLocalStreamStarted();
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState
        protected void http2ProcessingFailed(Status status, boolean z, Metadata metadata) {
            cancel(status, z, metadata);
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void deframeFailed(Throwable th) {
            http2ProcessingFailed(Status.fromThrowable(th), true, new Metadata());
        }

        @Override // io.grpc.internal.MessageDeframer.Listener
        public void bytesRead(int i) {
            int i2 = this.processedWindow - i;
            this.processedWindow = i2;
            float f = i2;
            int i3 = this.initialWindowSize;
            if (f <= i3 * 0.5f) {
                int i4 = i3 - i2;
                this.window += i4;
                this.processedWindow = i2 + i4;
                this.frameWriter.windowUpdate(id(), i4);
            }
        }

        @Override // io.grpc.internal.Http2ClientStreamTransportState, io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
        public void deframerClosed(boolean z) {
            onEndOfStream();
            super.deframerClosed(z);
        }

        @Override // io.grpc.internal.ApplicationThreadDeframerListener.TransportExecutor
        public void runOnTransportThread(Runnable runnable) {
            synchronized (this.lock) {
                runnable.run();
            }
        }

        public void transportHeadersReceived(List<Header> list, boolean z) {
            if (z) {
                transportTrailersReceived(Utils.convertTrailers(list));
            } else {
                transportHeadersReceived(Utils.convertHeaders(list));
            }
        }

        public void transportDataReceived(Buffer buffer, boolean z, int i) {
            int size = this.window - (((int) buffer.size()) + i);
            this.window = size;
            this.processedWindow -= i;
            if (size < 0) {
                this.frameWriter.rstStream(id(), ErrorCode.FLOW_CONTROL_ERROR);
                this.transport.finishStream(id(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            } else {
                super.transportDataReceived(new OkHttpReadableBuffer(buffer), z);
            }
        }

        private void onEndOfStream() {
            if (!isOutboundClosed()) {
                this.transport.finishStream(id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, ErrorCode.CANCEL, null);
            } else {
                this.transport.finishStream(id(), null, ClientStreamListener.RpcProgress.PROCESSED, false, null, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancel(Status status, boolean z, Metadata metadata) {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            if (this.canStart) {
                this.transport.removePendingStream(OkHttpClientStream.this);
                this.requestHeaders = null;
                this.pendingData.clear();
                this.canStart = false;
                if (metadata == null) {
                    metadata = new Metadata();
                }
                transportReportStatus(status, true, metadata);
                return;
            }
            this.transport.finishStream(id(), status, ClientStreamListener.RpcProgress.PROCESSED, z, ErrorCode.CANCEL, metadata);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void sendBuffer(Buffer buffer, boolean z, boolean z2) {
            if (this.cancelSent) {
                return;
            }
            if (this.canStart) {
                this.pendingData.write(buffer, (int) buffer.size());
                this.pendingDataHasEndOfStream |= z;
                this.flushPendingData |= z2;
            } else {
                Preconditions.checkState(id() != -1, "streamId should be set");
                this.outboundFlow.data(z, this.outboundFlowState, buffer, z2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void streamReady(Metadata metadata, String str) {
            this.requestHeaders = Headers.createRequestHeaders(metadata, str, OkHttpClientStream.this.authority, OkHttpClientStream.this.userAgent, OkHttpClientStream.this.useGet, this.transport.isUsingPlaintext());
            this.transport.streamReadyToStart(OkHttpClientStream.this);
        }

        Tag tag() {
            return this.tag;
        }

        int id() {
            return this.id;
        }

        OutboundFlowController.StreamState getOutboundFlowState() {
            OutboundFlowController.StreamState streamState;
            synchronized (this.lock) {
                streamState = this.outboundFlowState;
            }
            return streamState;
        }
    }
}
