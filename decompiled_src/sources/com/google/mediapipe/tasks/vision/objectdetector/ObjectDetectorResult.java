package com.google.mediapipe.tasks.vision.objectdetector;

import com.google.mediapipe.formats.proto.DetectionProto;
import com.google.mediapipe.tasks.components.containers.Detection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ObjectDetectorResult extends ObjectDetectionResult {
    public static ObjectDetectorResult create(List<DetectionProto.Detection> detectionList, long timestampMs) {
        ArrayList arrayList = new ArrayList();
        Iterator<DetectionProto.Detection> it = detectionList.iterator();
        while (it.hasNext()) {
            arrayList.add(Detection.createFromProto(it.next()));
        }
        return new AutoValue_ObjectDetectorResult(timestampMs, Collections.unmodifiableList(arrayList));
    }
}
