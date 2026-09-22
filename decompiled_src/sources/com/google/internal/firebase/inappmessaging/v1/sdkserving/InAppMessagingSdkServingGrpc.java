package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.grpc.stub.AbstractAsyncStub;
import io.grpc.stub.AbstractBlockingStub;
import io.grpc.stub.AbstractFutureStub;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class InAppMessagingSdkServingGrpc {
    private static final int METHODID_FETCH_ELIGIBLE_CAMPAIGNS = 0;
    public static final String SERVICE_NAME = "google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing";
    private static volatile MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod;
    private static volatile ServiceDescriptor serviceDescriptor;

    private InAppMessagingSdkServingGrpc() {
    }

    public static MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod() {
        MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> methodDescriptorBuild;
        MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> methodDescriptor = getFetchEligibleCampaignsMethod;
        if (methodDescriptor != null) {
            return methodDescriptor;
        }
        synchronized (InAppMessagingSdkServingGrpc.class) {
            methodDescriptorBuild = getFetchEligibleCampaignsMethod;
            if (methodDescriptorBuild == null) {
                methodDescriptorBuild = MethodDescriptor.newBuilder().setType(MethodDescriptor.MethodType.UNARY).setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "FetchEligibleCampaigns")).setSampledToLocalTracing(true).setRequestMarshaller(ProtoLiteUtils.marshaller(FetchEligibleCampaignsRequest.getDefaultInstance())).setResponseMarshaller(ProtoLiteUtils.marshaller(FetchEligibleCampaignsResponse.getDefaultInstance())).build();
                getFetchEligibleCampaignsMethod = methodDescriptorBuild;
            }
        }
        return methodDescriptorBuild;
    }

    public static InAppMessagingSdkServingStub newStub(Channel channel) {
        return (InAppMessagingSdkServingStub) InAppMessagingSdkServingStub.newStub(new AbstractStub.StubFactory<InAppMessagingSdkServingStub>() { // from class: com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc.1
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public InAppMessagingSdkServingStub newStub(Channel channel2, CallOptions callOptions) {
                return new InAppMessagingSdkServingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static InAppMessagingSdkServingBlockingStub newBlockingStub(Channel channel) {
        return (InAppMessagingSdkServingBlockingStub) InAppMessagingSdkServingBlockingStub.newStub(new AbstractStub.StubFactory<InAppMessagingSdkServingBlockingStub>() { // from class: com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc.2
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public InAppMessagingSdkServingBlockingStub newStub(Channel channel2, CallOptions callOptions) {
                return new InAppMessagingSdkServingBlockingStub(channel2, callOptions);
            }
        }, channel);
    }

    public static InAppMessagingSdkServingFutureStub newFutureStub(Channel channel) {
        return (InAppMessagingSdkServingFutureStub) InAppMessagingSdkServingFutureStub.newStub(new AbstractStub.StubFactory<InAppMessagingSdkServingFutureStub>() { // from class: com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc.3
            @Override // io.grpc.stub.AbstractStub.StubFactory
            public InAppMessagingSdkServingFutureStub newStub(Channel channel2, CallOptions callOptions) {
                return new InAppMessagingSdkServingFutureStub(channel2, callOptions);
            }
        }, channel);
    }

    public interface AsyncService {
        default void fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest, StreamObserver<FetchEligibleCampaignsResponse> streamObserver) {
            ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), streamObserver);
        }
    }

    public static abstract class InAppMessagingSdkServingImplBase implements BindableService, AsyncService {
        @Override // io.grpc.BindableService
        public final ServerServiceDefinition bindService() {
            return InAppMessagingSdkServingGrpc.bindService(this);
        }
    }

    public static final class InAppMessagingSdkServingStub extends AbstractAsyncStub<InAppMessagingSdkServingStub> {
        private InAppMessagingSdkServingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingStub build(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingStub(channel, callOptions);
        }

        public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest, StreamObserver<FetchEligibleCampaignsResponse> streamObserver) {
            ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions()), fetchEligibleCampaignsRequest, streamObserver);
        }
    }

    public static final class InAppMessagingSdkServingBlockingStub extends AbstractBlockingStub<InAppMessagingSdkServingBlockingStub> {
        private InAppMessagingSdkServingBlockingStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingBlockingStub build(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingBlockingStub(channel, callOptions);
        }

        public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return (FetchEligibleCampaignsResponse) ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions(), fetchEligibleCampaignsRequest);
        }
    }

    public static final class InAppMessagingSdkServingFutureStub extends AbstractFutureStub<InAppMessagingSdkServingFutureStub> {
        private InAppMessagingSdkServingFutureStub(Channel channel, CallOptions callOptions) {
            super(channel, callOptions);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.stub.AbstractStub
        public InAppMessagingSdkServingFutureStub build(Channel channel, CallOptions callOptions) {
            return new InAppMessagingSdkServingFutureStub(channel, callOptions);
        }

        public ListenableFuture<FetchEligibleCampaignsResponse> fetchEligibleCampaigns(FetchEligibleCampaignsRequest fetchEligibleCampaignsRequest) {
            return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod(), getCallOptions()), fetchEligibleCampaignsRequest);
        }
    }

    private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final int methodId;
        private final AsyncService serviceImpl;

        MethodHandlers(AsyncService asyncService, int i) {
            this.serviceImpl = asyncService;
            this.methodId = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.grpc.stub.ServerCalls.UnaryMethod, io.grpc.stub.ServerCalls.UnaryRequestMethod, io.grpc.stub.ServerCalls.ServerStreamingMethod
        public void invoke(Req req, StreamObserver<Resp> streamObserver) {
            if (this.methodId == 0) {
                this.serviceImpl.fetchEligibleCampaigns((FetchEligibleCampaignsRequest) req, streamObserver);
                return;
            }
            throw new AssertionError();
        }

        @Override // io.grpc.stub.ServerCalls.ClientStreamingMethod, io.grpc.stub.ServerCalls.StreamingRequestMethod, io.grpc.stub.ServerCalls.BidiStreamingMethod
        public StreamObserver<Req> invoke(StreamObserver<Resp> streamObserver) {
            throw new AssertionError();
        }
    }

    public static final ServerServiceDefinition bindService(AsyncService asyncService) {
        return ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getFetchEligibleCampaignsMethod(), ServerCalls.asyncUnaryCall(new MethodHandlers(asyncService, 0))).build();
    }

    public static ServiceDescriptor getServiceDescriptor() {
        ServiceDescriptor serviceDescriptorBuild;
        ServiceDescriptor serviceDescriptor2 = serviceDescriptor;
        if (serviceDescriptor2 != null) {
            return serviceDescriptor2;
        }
        synchronized (InAppMessagingSdkServingGrpc.class) {
            serviceDescriptorBuild = serviceDescriptor;
            if (serviceDescriptorBuild == null) {
                serviceDescriptorBuild = ServiceDescriptor.newBuilder(SERVICE_NAME).addMethod(getFetchEligibleCampaignsMethod()).build();
                serviceDescriptor = serviceDescriptorBuild;
            }
        }
        return serviceDescriptorBuild;
    }
}
