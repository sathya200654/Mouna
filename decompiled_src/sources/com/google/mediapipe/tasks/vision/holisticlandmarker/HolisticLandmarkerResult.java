package com.google.mediapipe.tasks.vision.holisticlandmarker;

import com.google.mediapipe.formats.proto.ClassificationProto;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.components.containers.Landmark;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class HolisticLandmarkerResult implements TaskResult {
    public abstract Optional<List<Category>> faceBlendshapes();

    public abstract List<NormalizedLandmark> faceLandmarks();

    public abstract List<NormalizedLandmark> leftHandLandmarks();

    public abstract List<Landmark> leftHandWorldLandmarks();

    public abstract List<NormalizedLandmark> poseLandmarks();

    public abstract List<Landmark> poseWorldLandmarks();

    public abstract List<NormalizedLandmark> rightHandLandmarks();

    public abstract List<Landmark> rightHandWorldLandmarks();

    public abstract Optional<MPImage> segmentationMask();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    static HolisticLandmarkerResult create(LandmarkProto.NormalizedLandmarkList faceLandmarkListProto, Optional<ClassificationProto.ClassificationList> faceBlendshapeProtos, LandmarkProto.NormalizedLandmarkList poseLandmarkListProtos, LandmarkProto.LandmarkList poseWorldLandmarkListProto, Optional<MPImage> segmentationMask, LandmarkProto.NormalizedLandmarkList leftHandLandmarkListProto, LandmarkProto.LandmarkList leftHandWorldLandmarkListProto, LandmarkProto.NormalizedLandmarkList rightHandLandmarkListProto, LandmarkProto.LandmarkList rightHandWorldLandmarkListProto, long timestampMs) {
        List<NormalizedLandmark> listCreateListFromProto = NormalizedLandmark.createListFromProto(faceLandmarkListProto);
        return new AutoValue_HolisticLandmarkerResult(timestampMs, Collections.unmodifiableList(listCreateListFromProto), faceBlendshapeProtos.map(new Function() { // from class: com.google.mediapipe.tasks.vision.holisticlandmarker.HolisticLandmarkerResult$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Category.createListFromProto((ClassificationProto.ClassificationList) obj);
            }
        }), Collections.unmodifiableList(NormalizedLandmark.createListFromProto(poseLandmarkListProtos)), Collections.unmodifiableList(Landmark.createListFromProto(poseWorldLandmarkListProto)), segmentationMask, Collections.unmodifiableList(NormalizedLandmark.createListFromProto(leftHandLandmarkListProto)), Collections.unmodifiableList(Landmark.createListFromProto(leftHandWorldLandmarkListProto)), Collections.unmodifiableList(NormalizedLandmark.createListFromProto(rightHandLandmarkListProto)), Collections.unmodifiableList(Landmark.createListFromProto(rightHandWorldLandmarkListProto)));
    }

    static HolisticLandmarkerResult createEmpty(long timestampMs) {
        return new AutoValue_HolisticLandmarkerResult(timestampMs, Collections.emptyList(), Optional.empty(), Collections.emptyList(), Collections.emptyList(), Optional.empty(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }
}
