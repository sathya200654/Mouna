package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.formats.proto.LandmarkProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class NormalizedLandmark {
    private static final float TOLERANCE = 1.0E-6f;

    public abstract Optional<Float> presence();

    public abstract Optional<Float> visibility();

    public abstract float x();

    public abstract float y();

    public abstract float z();

    public static NormalizedLandmark create(float x, float y, float z) {
        return new AutoValue_NormalizedLandmark(x, y, z, Optional.empty(), Optional.empty());
    }

    public static NormalizedLandmark create(float x, float y, float z, Optional<Float> visibility, Optional<Float> presence) {
        return new AutoValue_NormalizedLandmark(x, y, z, visibility, presence);
    }

    public static NormalizedLandmark createFromProto(LandmarkProto.NormalizedLandmark landmarkProto) {
        Optional optionalEmpty;
        float x = landmarkProto.getX();
        float y = landmarkProto.getY();
        float z = landmarkProto.getZ();
        if (landmarkProto.hasVisibility()) {
            optionalEmpty = Optional.of(Float.valueOf(landmarkProto.getVisibility()));
        } else {
            optionalEmpty = Optional.empty();
        }
        return create(x, y, z, optionalEmpty, landmarkProto.hasPresence() ? Optional.of(Float.valueOf(landmarkProto.getPresence())) : Optional.empty());
    }

    public static List<NormalizedLandmark> createListFromProto(LandmarkProto.NormalizedLandmarkList landmarkListProto) {
        ArrayList arrayList = new ArrayList();
        Iterator<LandmarkProto.NormalizedLandmark> it = landmarkListProto.getLandmarkList().iterator();
        while (it.hasNext()) {
            arrayList.add(createFromProto(it.next()));
        }
        return arrayList;
    }

    public final boolean equals(Object o) {
        if (!(o instanceof NormalizedLandmark)) {
            return false;
        }
        NormalizedLandmark normalizedLandmark = (NormalizedLandmark) o;
        return Math.abs(normalizedLandmark.x() - x()) < TOLERANCE && Math.abs(normalizedLandmark.x() - y()) < TOLERANCE && Math.abs(normalizedLandmark.x() - z()) < TOLERANCE;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(x()), Float.valueOf(y()), Float.valueOf(z()));
    }

    public final String toString() {
        return "<Normalized Landmark (x=" + x() + " y=" + y() + " z=" + z() + " visibility= " + visibility() + " presence=" + presence() + ")>";
    }
}
