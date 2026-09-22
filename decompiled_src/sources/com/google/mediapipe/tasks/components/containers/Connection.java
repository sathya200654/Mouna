package com.google.mediapipe.tasks.components.containers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class Connection {
    public abstract int end();

    public abstract int start();

    public static Connection create(int start, int end) {
        return new AutoValue_Connection(start, end);
    }
}
