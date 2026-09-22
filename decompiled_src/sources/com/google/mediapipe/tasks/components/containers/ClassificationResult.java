package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ClassificationResult {
    public abstract List<Classifications> classifications();

    public abstract Optional<Long> timestampMs();

    public static ClassificationResult create(List<Classifications> classifications, Optional<Long> timestampMs) {
        return new AutoValue_ClassificationResult(Collections.unmodifiableList(classifications), timestampMs);
    }

    public static ClassificationResult createFromProto(ClassificationsProto.ClassificationResult proto) {
        ArrayList arrayList = new ArrayList();
        Iterator<ClassificationsProto.Classifications> it = proto.getClassificationsList().iterator();
        while (it.hasNext()) {
            arrayList.add(Classifications.createFromProto(it.next()));
        }
        return create(arrayList, proto.hasTimestampMs() ? Optional.of(Long.valueOf(proto.getTimestampMs())) : Optional.empty());
    }
}
