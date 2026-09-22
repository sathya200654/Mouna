package io.grpc.internal;

import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public interface StreamListener {

    public interface MessageProducer {
        @Nullable
        InputStream next();
    }

    void messagesAvailable(MessageProducer messageProducer);

    void onReady();
}
