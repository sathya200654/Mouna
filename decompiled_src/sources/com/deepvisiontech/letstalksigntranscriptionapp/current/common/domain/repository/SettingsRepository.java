package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationMode;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.webview.domain.model.InterpretationSpeed;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: SettingsRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0012\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/repository/SettingsRepository;", "", "interpretationMode", "Lkotlinx/coroutines/flow/Flow;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;", "getInterpretationMode", "()Lkotlinx/coroutines/flow/Flow;", "interpretationSpeed", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;", "getInterpretationSpeed", "isEnvSoundRecognizerEnabled", "", "setInterpretationMode", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "mode", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInterpretationSpeed", "speed", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/webview/domain/model/InterpretationSpeed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEnvironmentStateRecognizerState", RemoteConfigConstants.ResponseFieldKey.STATE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingsRepository {
    Flow<InterpretationMode> getInterpretationMode();

    Flow<InterpretationSpeed> getInterpretationSpeed();

    Flow<Boolean> isEnvSoundRecognizerEnabled();

    Object setEnvironmentStateRecognizerState(boolean z, Continuation<? super ResponseResource<Unit>> continuation);

    Object setInterpretationMode(InterpretationMode interpretationMode, Continuation<? super ResponseResource<Unit>> continuation);

    Object setInterpretationSpeed(InterpretationSpeed interpretationSpeed, Continuation<? super ResponseResource<Unit>> continuation);
}
