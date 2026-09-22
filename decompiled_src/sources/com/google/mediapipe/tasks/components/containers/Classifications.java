package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.tasks.components.containers.proto.ClassificationsProto;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class Classifications {
    public abstract List<Category> categories();

    public abstract int headIndex();

    public abstract Optional<String> headName();

    public static Classifications create(List<Category> categories, int headIndex, Optional<String> headName) {
        return new AutoValue_Classifications(Collections.unmodifiableList(categories), headIndex, headName);
    }

    public static Classifications createFromProto(ClassificationsProto.Classifications proto) {
        return create(Category.createListFromProto(proto.getClassificationList()), proto.getHeadIndex(), proto.hasHeadName() ? Optional.of(proto.getHeadName()) : Optional.empty());
    }
}
