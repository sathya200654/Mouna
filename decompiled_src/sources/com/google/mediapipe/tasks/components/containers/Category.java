package com.google.mediapipe.tasks.components.containers;

import com.google.mediapipe.formats.proto.ClassificationProto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class Category {
    private static final float TOLERANCE = 1.0E-6f;

    public abstract String categoryName();

    public abstract String displayName();

    public abstract int index();

    public abstract float score();

    public static Category create(float score, int index, String categoryName, String displayName) {
        return new AutoValue_Category(score, index, categoryName, displayName);
    }

    public static Category createFromProto(ClassificationProto.Classification proto) {
        return create(proto.getScore(), proto.getIndex(), proto.getLabel(), proto.getDisplayName());
    }

    public static List<Category> createListFromProto(ClassificationProto.ClassificationList classificationListProto) {
        ArrayList arrayList = new ArrayList();
        Iterator<ClassificationProto.Classification> it = classificationListProto.getClassificationList().iterator();
        while (it.hasNext()) {
            arrayList.add(createFromProto(it.next()));
        }
        return arrayList;
    }

    public final boolean equals(Object o) {
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return Math.abs(category.score() - score()) < TOLERANCE && category.index() == index() && category.categoryName().equals(categoryName()) && category.displayName().equals(displayName());
    }

    public final int hashCode() {
        return Objects.hash(categoryName(), displayName(), Float.valueOf(score()), Integer.valueOf(index()));
    }

    public final String toString() {
        return "<Category \"" + categoryName() + "\" (displayName=" + displayName() + " score=" + score() + " index=" + index() + ")>";
    }
}
