package com.google.mediapipe.tasks.components.containers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_Connection extends Connection {
    private final int end;
    private final int start;

    AutoValue_Connection(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Connection
    public int start() {
        return this.start;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Connection
    public int end() {
        return this.end;
    }

    public String toString() {
        return "Connection{start=" + this.start + ", end=" + this.end + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Connection) {
            Connection connection = (Connection) o;
            if (this.start == connection.start() && this.end == connection.end()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.end ^ ((this.start ^ 1000003) * 1000003);
    }
}
