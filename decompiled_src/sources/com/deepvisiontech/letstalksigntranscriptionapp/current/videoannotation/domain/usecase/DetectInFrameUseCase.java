package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.usecase;

import androidx.camera.core.ImageProxy;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.DetectionResult;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository.VisionDetectionRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: DetectInFrameUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/usecase/DetectInFrameUseCase;", "", "repository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VisionDetectionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VisionDetectionRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;", "imageProxy", "Landroidx/camera/core/ImageProxy;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DetectInFrameUseCase {
    public static final int $stable = 8;
    private final VisionDetectionRepository repository;

    @Inject
    public DetectInFrameUseCase(VisionDetectionRepository visionDetectionRepository) {
        Intrinsics.checkNotNullParameter(visionDetectionRepository, "repository");
        this.repository = visionDetectionRepository;
    }

    public final Flow<DetectionResult> invoke(ImageProxy imageProxy) {
        Intrinsics.checkNotNullParameter(imageProxy, "imageProxy");
        return this.repository.detectInImage(imageProxy);
    }
}
