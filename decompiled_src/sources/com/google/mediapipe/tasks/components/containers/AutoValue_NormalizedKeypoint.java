package com.google.mediapipe.tasks.components.containers;

import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_NormalizedKeypoint extends NormalizedKeypoint {
    private final Optional<String> label;
    private final Optional<Float> score;
    private final float x;
    private final float y;

    AutoValue_NormalizedKeypoint(float x, float y, Optional<String> label, Optional<Float> score) {
        this.x = x;
        this.y = y;
        if (label == null) {
            throw new NullPointerException("Null label");
        }
        this.label = label;
        if (score == null) {
            throw new NullPointerException("Null score");
        }
        this.score = score;
    }

    @Override // com.google.mediapipe.tasks.components.containers.NormalizedKeypoint
    public float x() {
        return this.x;
    }

    @Override // com.google.mediapipe.tasks.components.containers.NormalizedKeypoint
    public float y() {
        return this.y;
    }

    @Override // com.google.mediapipe.tasks.components.containers.NormalizedKeypoint
    public Optional<String> label() {
        return this.label;
    }

    @Override // com.google.mediapipe.tasks.components.containers.NormalizedKeypoint
    public Optional<Float> score() {
        return this.score;
    }
}
