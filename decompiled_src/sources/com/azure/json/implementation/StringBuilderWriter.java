package com.azure.json.implementation;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class StringBuilderWriter extends Writer {
    private final StringBuilder builder;
    private boolean closed;

    public StringBuilderWriter() {
        this.closed = false;
        this.builder = new StringBuilder();
    }

    public StringBuilderWriter(StringBuilder sb) {
        this.closed = false;
        this.builder = (StringBuilder) Objects.requireNonNull(sb, "'builder' cannot be null.");
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        ensureOpen();
        this.builder.append((char) i);
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        ensureOpen();
        this.builder.append(cArr);
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        ensureOpen();
        this.builder.append(str);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        ensureOpen();
        this.builder.append((CharSequence) str, i, i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        ensureOpen();
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
        ensureOpen();
        this.builder.append(charSequence, i, i2);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c) throws IOException {
        ensureOpen();
        this.builder.append(c);
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        ensureOpen();
        this.builder.append(cArr, i, i2);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        ensureOpen();
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public String toString() {
        return this.builder.toString();
    }

    private void ensureOpen() throws IOException {
        if (this.closed) {
            throw new IOException("Writer has been closed.");
        }
    }
}
