package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.formats.proto.LandmarkProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class Landmark {
    private static final float TOLERANCE = 1.0E-6f;

    public abstract Optional<Float> presence();

    public abstract Optional<Float> visibility();

    public abstract float x();

    public abstract float y();

    public abstract float z();

    public static Landmark create(float x, float y, float z) {
        return new AutoValue_Landmark(x, y, z, Optional.empty(), Optional.empty());
    }

    public static Landmark create(float x, float y, float z, Optional<Float> visibility, Optional<Float> presence) {
        return new AutoValue_Landmark(x, y, z, visibility, presence);
    }

    public static Landmark createFromProto(LandmarkProto.Landmark landmarkProto) {
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

    public static List<Landmark> createListFromProto(LandmarkProto.LandmarkList landmarkListProto) {
        ArrayList arrayList = new ArrayList();
        Iterator<LandmarkProto.Landmark> it = landmarkListProto.getLandmarkList().iterator();
        while (it.hasNext()) {
            arrayList.add(createFromProto(it.next()));
        }
        return arrayList;
    }

    public final boolean equals(Object o) {
        if (!(o instanceof Landmark)) {
            return false;
        }
        Landmark landmark = (Landmark) o;
        return Math.abs(landmark.x() - x()) < TOLERANCE && Math.abs(landmark.x() - y()) < TOLERANCE && Math.abs(landmark.x() - z()) < TOLERANCE;
    }

    public final int hashCode() {
        return Objects.hash(Float.valueOf(x()), Float.valueOf(y()), Float.valueOf(z()));
    }

    public final String toString() {
        return "<Landmark (x=" + x() + " y=" + y() + " z=" + z() + " visibility= " + visibility() + " presence=" + presence() + ")>";
    }
}
