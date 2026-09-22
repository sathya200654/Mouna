package com.google.mediapipe.framework.image;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_ByteBufferExtractor_Result extends ByteBufferExtractor.Result {
    private final ByteBuffer buffer;
    private final int format;

    AutoValue_ByteBufferExtractor_Result(ByteBuffer buffer, int format) {
        if (buffer == null) {
            throw new NullPointerException("Null buffer");
        }
        this.buffer = buffer;
        this.format = format;
    }

    @Override // com.google.mediapipe.framework.image.ByteBufferExtractor.Result
    public ByteBuffer buffer() {
        return this.buffer;
    }

    @Override // com.google.mediapipe.framework.image.ByteBufferExtractor.Result
    public int format() {
        return this.format;
    }

    public String toString() {
        return "Result{buffer=" + this.buffer + ", format=" + this.format + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ByteBufferExtractor.Result) {
            ByteBufferExtractor.Result result = (ByteBufferExtractor.Result) o;
            if (this.buffer.equals(result.buffer()) && this.format == result.format()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.format ^ ((this.buffer.hashCode() ^ 1000003) * 1000003);
    }
}
