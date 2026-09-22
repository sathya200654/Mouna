package com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.domain.repository;

import androidx.camera.core.ImageProxy;
import com.deepvisiontech.letstalksigntranscriptionapp.current.videoannotation.data.vision.DetectionResult;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: VisionDetectionRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/domain/repository/VisionDetectionRepository;", "", "detectInImage", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/videoannotation/data/vision/DetectionResult;", "imageProxy", "Landroidx/camera/core/ImageProxy;", "closeDetector", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VisionDetectionRepository {
    void closeDetector();

    Flow<DetectionResult> detectInImage(ImageProxy imageProxy);
}
