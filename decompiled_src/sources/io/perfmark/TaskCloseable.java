package io.perfmark;

import java.io.Closeable;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class TaskCloseable implements Closeable {
    static final TaskCloseable INSTANCE = new TaskCloseable();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        PerfMark.stopTask();
    }

    private TaskCloseable() {
    }
}
