package com.google.mediapipe.tasks.components.containers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_Category extends Category {
    private final String categoryName;
    private final String displayName;
    private final int index;
    private final float score;

    AutoValue_Category(float score, int index, String categoryName, String displayName) {
        this.score = score;
        this.index = index;
        if (categoryName == null) {
            throw new NullPointerException("Null categoryName");
        }
        this.categoryName = categoryName;
        if (displayName == null) {
            throw new NullPointerException("Null displayName");
        }
        this.displayName = displayName;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Category
    public float score() {
        return this.score;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Category
    public int index() {
        return this.index;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Category
    public String categoryName() {
        return this.categoryName;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Category
    public String displayName() {
        return this.displayName;
    }
}
