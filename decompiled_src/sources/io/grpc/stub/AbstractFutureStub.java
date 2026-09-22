package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.stub.AbstractFutureStub;
import javax.annotation.CheckReturnValue;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@CheckReturnValue
public abstract class AbstractFutureStub<S extends AbstractFutureStub<S>> extends AbstractStub<S> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    protected AbstractFutureStub(Channel channel, CallOptions callOptions) {
        super(channel, callOptions);
    }

    public static <T extends AbstractStub<T>> T newStub(AbstractStub.StubFactory<T> stubFactory, Channel channel) {
        return (T) newStub(stubFactory, channel, CallOptions.DEFAULT);
    }

    public static <T extends AbstractStub<T>> T newStub(AbstractStub.StubFactory<T> stubFactory, Channel channel, CallOptions callOptions) {
        return (T) stubFactory.newStub(channel, callOptions.withOption(ClientCalls.STUB_TYPE_OPTION, ClientCalls.StubType.FUTURE));
    }
}
