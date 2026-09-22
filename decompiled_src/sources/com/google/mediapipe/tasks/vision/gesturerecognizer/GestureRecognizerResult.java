package com.google.mediapipe.tasks.vision.gesturerecognizer;

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
public abstract class GestureRecognizerResult implements TaskResult {
    private static final int kGestureDefaultIndex = -1;

    public abstract List<List<Category>> gestures();

    public abstract List<List<Category>> handedness();

    public abstract List<List<NormalizedLandmark>> landmarks();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    public abstract List<List<Landmark>> worldLandmarks();

    static GestureRecognizerResult create(List<LandmarkProto.NormalizedLandmarkList> landmarksProto, List<LandmarkProto.LandmarkList> worldLandmarksProto, List<ClassificationProto.ClassificationList> handednessesProto, List<ClassificationProto.ClassificationList> gesturesProto, long timestampMs) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (LandmarkProto.NormalizedLandmarkList normalizedLandmarkList : landmarksProto) {
            ArrayList arrayList5 = new ArrayList();
            arrayList.add(arrayList5);
            for (LandmarkProto.NormalizedLandmark normalizedLandmark : normalizedLandmarkList.getLandmarkList()) {
                arrayList5.add(NormalizedLandmark.create(normalizedLandmark.getX(), normalizedLandmark.getY(), normalizedLandmark.getZ()));
            }
        }
        for (LandmarkProto.LandmarkList landmarkList : worldLandmarksProto) {
            ArrayList arrayList6 = new ArrayList();
            arrayList2.add(arrayList6);
            for (LandmarkProto.Landmark landmark : landmarkList.getLandmarkList()) {
                arrayList6.add(Landmark.create(landmark.getX(), landmark.getY(), landmark.getZ()));
            }
        }
        Iterator<ClassificationProto.ClassificationList> it = handednessesProto.iterator();
        while (it.hasNext()) {
            arrayList3.add(Collections.unmodifiableList(Category.createListFromProto(it.next())));
        }
        for (ClassificationProto.ClassificationList classificationList : gesturesProto) {
            ArrayList arrayList7 = new ArrayList();
            arrayList4.add(arrayList7);
            for (ClassificationProto.Classification classification : classificationList.getClassificationList()) {
                arrayList7.add(Category.create(classification.getScore(), -1, classification.getLabel(), classification.getDisplayName()));
            }
        }
        return new AutoValue_GestureRecognizerResult(timestampMs, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList3), Collections.unmodifiableList(arrayList4));
    }

    @Deprecated
    public List<List<Category>> handednesses() {
        return handedness();
    }
}
