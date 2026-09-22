package com.google.mediapipe.tasks.vision.handlandmarker;

import com.google.mediapipe.formats.proto.ClassificationProto;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.components.containers.Landmark;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class HandLandmarkerResult implements TaskResult {
    public abstract List<List<Category>> handedness();

    public abstract List<List<NormalizedLandmark>> landmarks();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    public abstract List<List<Landmark>> worldLandmarks();

    static HandLandmarkerResult create(List<LandmarkProto.NormalizedLandmarkList> landmarksProtos, List<LandmarkProto.LandmarkList> worldLandmarksProtos, List<ClassificationProto.ClassificationList> handednessesProtos, long timestampMs) {
        ArrayList arrayList = new ArrayList();
        Iterator<LandmarkProto.NormalizedLandmarkList> it = landmarksProtos.iterator();
        while (it.hasNext()) {
            arrayList.add(Collections.unmodifiableList(NormalizedLandmark.createListFromProto(it.next())));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<LandmarkProto.LandmarkList> it2 = worldLandmarksProtos.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Collections.unmodifiableList(Landmark.createListFromProto(it2.next())));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<ClassificationProto.ClassificationList> it3 = handednessesProtos.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Collections.unmodifiableList(Category.createListFromProto(it3.next())));
        }
        return new AutoValue_HandLandmarkerResult(timestampMs, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList3));
    }

    @Deprecated
    public List<List<Category>> handednesses() {
        return handedness();
    }
}
