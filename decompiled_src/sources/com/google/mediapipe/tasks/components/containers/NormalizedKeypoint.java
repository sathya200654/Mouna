package com.google.mediapipe.tasks.components.containers;

import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class NormalizedKeypoint {
    private static final float TOLERANCE = 1.0E-6f;

    public abstract Optional<String> label();

    public abstract Optional<Float> score();

    public abstract float x();

    public abstract float y();

    public static NormalizedKeypoint create(float x, float y) {
        return new AutoValue_NormalizedKeypoint(x, y, Optional.empty(), Optional.empty());
    }

    public static NormalizedKeypoint create(float x, float y, Optional<String> label, Optional<Float> score) {
        return new AutoValue_NormalizedKeypoint(x, y, label, score);
    }

    public final boolean equals(Object o) {
        if (!(o instanceof NormalizedKeypoint)) {
            return false;
        }
        NormalizedKeypoint normalizedKeypoint = (NormalizedKeypoint) o;
        return Math.abs(normalizedKeypoint.x() - x()) < TOLERANCE && Math.abs(normalizedKeypoint.x() - y()) < TOLERANCE;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(x()), Float.valueOf(y()), label(), score());
    }

    public final String toString() {
        return "<Normalized Keypoint (x=" + x() + " y=" + y() + " label= " + label().orElse("null") + " score=" + (score().isPresent() ? score().get() : "null") + ")>";
    }
}
