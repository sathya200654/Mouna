package com.google.mediapipe.tasks.components.containers;

import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_Landmark extends Landmark {
    private final Optional<Float> presence;
    private final Optional<Float> visibility;
    private final float x;
    private final float y;
    private final float z;

    AutoValue_Landmark(float x, float y, float z, Optional<Float> visibility, Optional<Float> presence) {
        this.x = x;
        this.y = y;
        this.z = z;
        if (visibility == null) {
            throw new NullPointerException("Null visibility");
        }
        this.visibility = visibility;
        if (presence == null) {
            throw new NullPointerException("Null presence");
        }
        this.presence = presence;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Landmark
    public float x() {
        return this.x;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Landmark
    public float y() {
        return this.y;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Landmark
    public float z() {
        return this.z;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Landmark
    public Optional<Float> visibility() {
        return this.visibility;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Landmark
    public Optional<Float> presence() {
        return this.presence;
    }
}
