package io.grpc.internal;

import com.azure.core.implementation.logging.LoggingKeys;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class PickSubchannelArgsImpl extends LoadBalancer.PickSubchannelArgs {
    private final CallOptions callOptions;
    private final Metadata headers;
    private final MethodDescriptor<?, ?> method;

    public PickSubchannelArgsImpl(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        this.method = (MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, LoggingKeys.HTTP_METHOD_KEY);
        this.headers = (Metadata) Preconditions.checkNotNull(metadata, "headers");
        this.callOptions = (CallOptions) Preconditions.checkNotNull(callOptions, "callOptions");
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public Metadata getHeaders() {
        return this.headers;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public CallOptions getCallOptions() {
        return this.callOptions;
    }

    @Override // io.grpc.LoadBalancer.PickSubchannelArgs
    public MethodDescriptor<?, ?> getMethodDescriptor() {
        return this.method;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PickSubchannelArgsImpl pickSubchannelArgsImpl = (PickSubchannelArgsImpl) obj;
            if (Objects.equal(this.callOptions, pickSubchannelArgsImpl.callOptions) && Objects.equal(this.headers, pickSubchannelArgsImpl.headers) && Objects.equal(this.method, pickSubchannelArgsImpl.method)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.callOptions, this.headers, this.method});
    }

    public final String toString() {
        return "[method=" + this.method + " headers=" + this.headers + " callOptions=" + this.callOptions + "]";
    }
}
