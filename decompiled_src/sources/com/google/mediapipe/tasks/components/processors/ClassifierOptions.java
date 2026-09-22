package com.google.mediapipe.tasks.components.processors;

import com.google.mediapipe.tasks.components.processors.proto.ClassifierOptionsProto;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ClassifierOptions {
    public abstract List<String> categoryAllowlist();

    public abstract List<String> categoryDenylist();

    public abstract Optional<String> displayNamesLocale();

    public abstract Optional<Integer> maxResults();

    public abstract Optional<Float> scoreThreshold();

    public static abstract class Builder {
        abstract ClassifierOptions autoBuild();

        public abstract Builder setCategoryAllowlist(List<String> categoryAllowlist);

        public abstract Builder setCategoryDenylist(List<String> categoryDenylist);

        public abstract Builder setDisplayNamesLocale(String locale);

        public abstract Builder setMaxResults(Integer maxResults);

        public abstract Builder setScoreThreshold(Float scoreThreshold);

        public final ClassifierOptions build() {
            ClassifierOptions classifierOptionsAutoBuild = autoBuild();
            if (!classifierOptionsAutoBuild.maxResults().isPresent() || classifierOptionsAutoBuild.maxResults().get().intValue() > 0) {
                return classifierOptionsAutoBuild;
            }
            throw new IllegalArgumentException("If specified, maxResults must be > 0");
        }
    }

    public static Builder builder() {
        return new AutoValue_ClassifierOptions.Builder().setCategoryAllowlist(Collections.emptyList()).setCategoryDenylist(Collections.emptyList());
    }

    public ClassifierOptionsProto.ClassifierOptions convertToProto() {
        final ClassifierOptionsProto.ClassifierOptions.Builder builderNewBuilder = ClassifierOptionsProto.ClassifierOptions.newBuilder();
        Optional<String> optionalDisplayNamesLocale = displayNamesLocale();
        Objects.requireNonNull(builderNewBuilder);
        optionalDisplayNamesLocale.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.components.processors.ClassifierOptions$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                builderNewBuilder.setDisplayNamesLocale((String) obj);
            }
        });
        Optional<Integer> optionalMaxResults = maxResults();
        Objects.requireNonNull(builderNewBuilder);
        optionalMaxResults.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.components.processors.ClassifierOptions$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                builderNewBuilder.setMaxResults(((Integer) obj).intValue());
            }
        });
        Optional<Float> optionalScoreThreshold = scoreThreshold();
        Objects.requireNonNull(builderNewBuilder);
        optionalScoreThreshold.ifPresent(new Consumer() { // from class: com.google.mediapipe.tasks.components.processors.ClassifierOptions$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                builderNewBuilder.setScoreThreshold(((Float) obj).floatValue());
            }
        });
        if (!categoryAllowlist().isEmpty()) {
            builderNewBuilder.addAllCategoryAllowlist(categoryAllowlist());
        }
        if (!categoryDenylist().isEmpty()) {
            builderNewBuilder.addAllCategoryDenylist(categoryDenylist());
        }
        return (ClassifierOptionsProto.ClassifierOptions) builderNewBuilder.build();
    }
}
