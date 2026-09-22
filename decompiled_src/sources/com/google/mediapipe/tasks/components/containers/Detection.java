package com.google.mediapipe.tasks.components.containers;

import android.graphics.RectF;
import com.google.mediapipe.formats.proto.DetectionProto;
import com.google.mediapipe.formats.proto.LocationDataProto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class Detection {
    private static final int DEFAULT_CATEGORY_INDEX = -1;

    public abstract RectF boundingBox();

    public abstract List<Category> categories();

    public abstract Optional<List<NormalizedKeypoint>> keypoints();

    public static Detection create(List<Category> categories, RectF boundingBox) {
        return new AutoValue_Detection(Collections.unmodifiableList(categories), boundingBox, Optional.empty());
    }

    public static Detection create(List<Category> categories, RectF boundingBox, Optional<List<NormalizedKeypoint>> keypoints) {
        return new AutoValue_Detection(Collections.unmodifiableList(categories), boundingBox, keypoints);
    }

    public static Detection createFromProto(DetectionProto.Detection detectionProto) {
        Optional optionalEmpty;
        Optional optionalEmpty2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < detectionProto.getScoreCount()) {
            float score = detectionProto.getScore(i);
            int labelId = detectionProto.getLabelIdCount() > i ? detectionProto.getLabelId(i) : -1;
            String displayName = "";
            String label = detectionProto.getLabelCount() > i ? detectionProto.getLabel(i) : "";
            if (detectionProto.getDisplayNameCount() > i) {
                displayName = detectionProto.getDisplayName(i);
            }
            arrayList.add(Category.create(score, labelId, label, displayName));
            i++;
        }
        RectF rectF = new RectF();
        if (detectionProto.getLocationData().hasBoundingBox()) {
            LocationDataProto.LocationData.BoundingBox boundingBox = detectionProto.getLocationData().getBoundingBox();
            rectF.set(boundingBox.getXmin(), boundingBox.getYmin(), boundingBox.getXmin() + boundingBox.getWidth(), boundingBox.getYmin() + boundingBox.getHeight());
        }
        Optional optionalEmpty3 = Optional.empty();
        if (!detectionProto.getLocationData().getRelativeKeypointsList().isEmpty()) {
            optionalEmpty3 = Optional.of(new ArrayList());
            for (LocationDataProto.LocationData.RelativeKeypoint relativeKeypoint : detectionProto.getLocationData().getRelativeKeypointsList()) {
                List list = (List) optionalEmpty3.get();
                float x = relativeKeypoint.getX();
                float y = relativeKeypoint.getY();
                if (relativeKeypoint.hasKeypointLabel()) {
                    optionalEmpty = Optional.of(relativeKeypoint.getKeypointLabel());
                } else {
                    optionalEmpty = Optional.empty();
                }
                if (relativeKeypoint.hasScore()) {
                    optionalEmpty2 = Optional.of(Float.valueOf(relativeKeypoint.getScore()));
                } else {
                    optionalEmpty2 = Optional.empty();
                }
                list.add(NormalizedKeypoint.create(x, y, optionalEmpty, optionalEmpty2));
            }
        }
        return create(arrayList, rectF, optionalEmpty3);
    }
}
