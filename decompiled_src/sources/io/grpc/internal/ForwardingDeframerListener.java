package io.grpc.internal;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
abstract class ForwardingDeframerListener implements MessageDeframer.Listener {
    protected abstract MessageDeframer.Listener delegate();

    ForwardingDeframerListener() {
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void bytesRead(int i) {
        delegate().bytesRead(i);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
        delegate().messagesAvailable(messageProducer);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframerClosed(boolean z) {
        delegate().deframerClosed(z);
    }

    @Override // io.grpc.internal.MessageDeframer.Listener
    public void deframeFailed(Throwable th) {
        delegate().deframeFailed(th);
    }
}
