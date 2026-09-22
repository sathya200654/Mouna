package io.grpc;

import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InternalMethodDescriptor {
    private final InternalKnownTransport transport;

    public InternalMethodDescriptor(InternalKnownTransport internalKnownTransport) {
        this.transport = (InternalKnownTransport) Preconditions.checkNotNull(internalKnownTransport, "transport");
    }

    public Object geRawMethodName(MethodDescriptor<?, ?> methodDescriptor) {
        return methodDescriptor.getRawMethodName(this.transport.ordinal());
    }

    public void setRawMethodName(MethodDescriptor<?, ?> methodDescriptor, Object obj) {
        methodDescriptor.setRawMethodName(this.transport.ordinal(), obj);
    }
}
