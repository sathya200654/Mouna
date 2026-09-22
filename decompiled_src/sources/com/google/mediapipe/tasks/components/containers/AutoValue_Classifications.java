package com.google.mediapipe.tasks.components.containers;

import java.util.List;
import java.util.Optional;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_Classifications extends Classifications {
    private final List<Category> categories;
    private final int headIndex;
    private final Optional<String> headName;

    AutoValue_Classifications(List<Category> categories, int headIndex, Optional<String> headName) {
        if (categories == null) {
            throw new NullPointerException("Null categories");
        }
        this.categories = categories;
        this.headIndex = headIndex;
        if (headName == null) {
            throw new NullPointerException("Null headName");
        }
        this.headName = headName;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Classifications
    public List<Category> categories() {
        return this.categories;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Classifications
    public int headIndex() {
        return this.headIndex;
    }

    @Override // com.google.mediapipe.tasks.components.containers.Classifications
    public Optional<String> headName() {
        return this.headName;
    }

    public String toString() {
        return "Classifications{categories=" + this.categories + ", headIndex=" + this.headIndex + ", headName=" + this.headName + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Classifications) {
            Classifications classifications = (Classifications) o;
            if (this.categories.equals(classifications.categories()) && this.headIndex == classifications.headIndex() && this.headName.equals(classifications.headName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.headName.hashCode() ^ ((((this.categories.hashCode() ^ 1000003) * 1000003) ^ this.headIndex) * 1000003);
    }
}
