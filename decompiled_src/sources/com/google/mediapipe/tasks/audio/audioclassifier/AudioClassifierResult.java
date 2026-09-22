package com.google.mediapipe.tasks.audio.audioclassifier;

import com.google.mediapipe.tasks.components.containers.ClassificationResult;
import com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class AudioClassifierResult implements TaskResult {
    public abstract List<ClassificationResult> classificationResults();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    static AudioClassifierResult createFromProtoList(List<ClassificationsProto.ClassificationResult> protoList, long timestampMs) {
        ArrayList arrayList = new ArrayList();
        Iterator<ClassificationsProto.ClassificationResult> it = protoList.iterator();
        while (it.hasNext()) {
            arrayList.add(ClassificationResult.createFromProto(it.next()));
        }
        return new AutoValue_AudioClassifierResult(arrayList, timestampMs);
    }

    static AudioClassifierResult createFromProto(ClassificationsProto.ClassificationResult proto, long timestampMs) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ClassificationResult.createFromProto(proto));
        return new AutoValue_AudioClassifierResult(arrayList, timestampMs);
    }
}
