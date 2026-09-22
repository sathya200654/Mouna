package com.google.mediapipe.tasks.vision.facelandmarker;

import com.google.mediapipe.formats.proto.ClassificationProto;
import com.google.mediapipe.formats.proto.LandmarkProto;
import com.google.mediapipe.formats.proto.MatrixDataProto;
import com.google.mediapipe.tasks.components.containers.Category;
import com.google.mediapipe.tasks.components.containers.NormalizedLandmark;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class FaceLandmarkerResult implements TaskResult {
    public abstract Optional<List<List<Category>>> faceBlendshapes();

    public abstract List<List<NormalizedLandmark>> faceLandmarks();

    public abstract Optional<List<float[]>> facialTransformationMatrixes();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    static FaceLandmarkerResult create(List<LandmarkProto.NormalizedLandmarkList> multiFaceLandmarksProto, Optional<List<ClassificationProto.ClassificationList>> multiFaceBendshapesProto, Optional<List<MatrixDataProto.MatrixData>> multiFaceTransformationMatrixesProto, long timestampMs) {
        ArrayList arrayList = new ArrayList();
        Iterator<LandmarkProto.NormalizedLandmarkList> it = multiFaceLandmarksProto.iterator();
        while (it.hasNext()) {
            arrayList.add(Collections.unmodifiableList(NormalizedLandmark.createListFromProto(it.next())));
        }
        Optional optionalEmpty = Optional.empty();
        if (multiFaceBendshapesProto.isPresent()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ClassificationProto.ClassificationList> it2 = multiFaceBendshapesProto.get().iterator();
            while (it2.hasNext()) {
                arrayList2.add(Collections.unmodifiableList(Category.createListFromProto(it2.next())));
            }
            optionalEmpty = Optional.of(Collections.unmodifiableList(arrayList2));
        }
        Optional optional = optionalEmpty;
        Optional optionalEmpty2 = Optional.empty();
        if (multiFaceTransformationMatrixesProto.isPresent()) {
            ArrayList arrayList3 = new ArrayList();
            for (MatrixDataProto.MatrixData matrixData : multiFaceTransformationMatrixesProto.get()) {
                if (matrixData.getPackedDataCount() != 16) {
                    throw new IllegalArgumentException("MatrixData must contain 4x4 matrix as a size 16 float array, but get size " + matrixData.getPackedDataCount() + " float array.");
                }
                int packedDataCount = matrixData.getPackedDataCount();
                float[] fArr = new float[packedDataCount];
                for (int i = 0; i < packedDataCount; i++) {
                    fArr[i] = matrixData.getPackedData(i);
                }
                arrayList3.add(fArr);
            }
            optionalEmpty2 = Optional.of(Collections.unmodifiableList(arrayList3));
        }
        return new AutoValue_FaceLandmarkerResult(timestampMs, Collections.unmodifiableList(arrayList), optional, optionalEmpty2);
    }
}
