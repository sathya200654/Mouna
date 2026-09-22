package com.squareup.wire;

import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: compiled from: MessageSink.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lcom/squareup/wire/MessageSink;", "T", "", "Ljava/io/Closeable;", "cancel", "", "write", ResponseKeys.KEY_MESSAGE, "(Ljava/lang/Object;)V", "wire-runtime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MessageSink<T> extends Closeable {
    void cancel() throws IOException;

    void write(T message) throws IOException;
}
