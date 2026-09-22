package com.azure.core.implementation;

import com.azure.core.util.logging.ClientLogger;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.MonoSink;
import reactor.core.publisher.Operators;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class OutputStreamWriteSubscriber implements Subscriber<ByteBuffer> {
    private final MonoSink<Void> emitter;
    private final ClientLogger logger;
    private final OutputStream stream;
    private Subscription subscription;

    public OutputStreamWriteSubscriber(MonoSink<Void> monoSink, OutputStream outputStream, ClientLogger clientLogger) {
        this.emitter = monoSink;
        this.stream = outputStream;
        this.logger = clientLogger;
    }

    public void onSubscribe(Subscription subscription) {
        if (Operators.validate(this.subscription, subscription)) {
            this.subscription = subscription;
            subscription.request(1L);
        }
    }

    public void onNext(ByteBuffer byteBuffer) {
        try {
            ImplUtils.writeByteBufferToStream(byteBuffer, this.stream);
            this.subscription.request(1L);
        } catch (IOException e) {
            onError(new UncheckedIOException(e));
        }
    }

    public void onError(Throwable th) {
        this.subscription.cancel();
        this.emitter.error(this.logger.logThrowableAsError(th));
    }

    public void onComplete() {
        this.emitter.success();
    }
}
