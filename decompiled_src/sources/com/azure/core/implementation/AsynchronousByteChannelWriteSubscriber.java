package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousByteChannel;
import java.util.concurrent.ExecutionException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.Operators;
import reactor.util.context.Context;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class AsynchronousByteChannelWriteSubscriber implements Subscriber<ByteBuffer> {
    private static final ClientLogger LOGGER = new ClientLogger((Class<?>) AsynchronousByteChannelWriteSubscriber.class);
    private final AsynchronousByteChannel channel;
    private boolean done = false;
    private final MonoSink<Void> emitter;
    private Subscription subscription;

    public AsynchronousByteChannelWriteSubscriber(AsynchronousByteChannel asynchronousByteChannel, MonoSink<Void> monoSink) {
        this.channel = asynchronousByteChannel;
        this.emitter = monoSink;
    }

    public void onSubscribe(Subscription subscription) {
        if (Operators.validate(this.subscription, subscription)) {
            this.subscription = subscription;
            subscription.request(1L);
        }
    }

    public void onNext(ByteBuffer byteBuffer) {
        if (this.done) {
            Operators.onNextDropped(byteBuffer, Context.of(this.emitter.contextView()));
            return;
        }
        if (!byteBuffer.hasRemaining()) {
            this.subscription.request(1L);
            return;
        }
        write(byteBuffer);
        if (this.done) {
            return;
        }
        this.subscription.request(1L);
    }

    private void write(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            try {
                this.channel.write(byteBuffer).get();
            } catch (Exception e) {
                if (e instanceof ExecutionException) {
                    onError(e.getCause());
                    return;
                } else {
                    onError(e);
                    return;
                }
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            Operators.onErrorDropped(th, Context.of(this.emitter.contextView()));
            return;
        }
        this.done = true;
        this.subscription.cancel();
        this.emitter.error(LOGGER.logThrowableAsError(th));
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.emitter.success();
    }
}
