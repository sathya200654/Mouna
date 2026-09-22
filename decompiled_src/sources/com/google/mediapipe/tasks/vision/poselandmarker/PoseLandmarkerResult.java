package com.google.mediapipe.tasks.vision.poselandmarker;

import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.components.containers.Landmark;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class PoseLandmarkerResult implements TaskResult {
    public abstract List<List<NormalizedLandmark>> landmarks();

    public abstract Optional<List<MPImage>> segmentationMasks();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    public abstract List<List<Landmark>> worldLandmarks();

    static PoseLandmarkerResult create(List<LandmarkProto.NormalizedLandmarkList> landmarksProto, List<LandmarkProto.LandmarkList> worldLandmarksProto, Optional<List<MPImage>> segmentationMasksData, long timestampMs) {
        Optional optionalEmpty = Optional.empty();
        if (segmentationMasksData.isPresent()) {
            optionalEmpty = Optional.of(Collections.unmodifiableList(segmentationMasksData.get()));
        }
        Optional optional = optionalEmpty;
        ArrayList arrayList = new ArrayList();
        Iterator<LandmarkProto.NormalizedLandmarkList> it = landmarksProto.iterator();
        while (it.hasNext()) {
            arrayList.add(Collections.unmodifiableList(NormalizedLandmark.createListFromProto(it.next())));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<LandmarkProto.LandmarkList> it2 = worldLandmarksProto.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Collections.unmodifiableList(Landmark.createListFromProto(it2.next())));
        }
        return new AutoValue_PoseLandmarkerResult(timestampMs, Collections.unmodifiableList(arrayList), Collections.unmodifiableList(arrayList2), optional);
    }
}
