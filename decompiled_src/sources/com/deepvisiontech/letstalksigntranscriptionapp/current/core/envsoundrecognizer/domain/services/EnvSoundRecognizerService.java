package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services;

import com.google.mediapipe.tasks.components.containers.Category;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: EnvSoundRecognizerService.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/services/EnvSoundRecognizerService;", "", "startListening", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/google/mediapipe/tasks/components/containers/Category;", "stopListening", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EnvSoundRecognizerService {
    Flow<List<Category>> startListening();

    void stopListening();
}
