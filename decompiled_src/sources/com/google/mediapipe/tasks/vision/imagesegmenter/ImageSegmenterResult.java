package com.google.mediapipe.tasks.vision.imagesegmenter;

import com.google.mediapipe.framework.image.MPImage;
import com.google.mediapipe.tasks.core.TaskResult;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public abstract class ImageSegmenterResult implements TaskResult {
    public abstract Optional<MPImage> categoryMask();

    public abstract Optional<List<MPImage>> confidenceMasks();

    public abstract List<Float> qualityScores();

    @Override // com.google.mediapipe.tasks.core.TaskResult
    public abstract long timestampMs();

    public static ImageSegmenterResult create(Optional<List<MPImage>> confidenceMasks, Optional<MPImage> categoryMask, List<Float> qualityScores, long timestampMs) {
        return new AutoValue_ImageSegmenterResult(confidenceMasks.map(new Function() { // from class: com.google.mediapipe.tasks.vision.imagesegmenter.ImageSegmenterResult$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collections.unmodifiableList((List) obj);
            }
        }), categoryMask, Collections.unmodifiableList(qualityScores), timestampMs);
    }
}
