package com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: EngagementRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H¦@¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H¦@¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H¦@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0016\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0019\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001c\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u001c\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u001aR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "", "shareAppDialogUsageCount", "Lkotlinx/coroutines/flow/Flow;", "", "getShareAppDialogUsageCount", "()Lkotlinx/coroutines/flow/Flow;", "shareAppDialogLastUsageDate", "Ljava/time/LocalDate;", "getShareAppDialogLastUsageDate", "isPersonaSurveySubmitted", "", "onBoardingShownState", "getOnBoardingShownState", "isEnvSoundRecognitionStateSubmitted", "incrementShareAppDialogUsageCount", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementShareAppDialogShareCount", "incrementShareAppDialogDismissCount", "setShareAppDialogLastUsageDate", "date", "(Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOnboardingShownState", RemoteConfigConstants.ResponseFieldKey.STATE, "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPersonaSurveySubmitted", "isSubmitted", "setEnvSoundRecognitionSubmittedState", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EngagementRepository {
    Flow<Boolean> getOnBoardingShownState();

    Flow<LocalDate> getShareAppDialogLastUsageDate();

    Flow<Integer> getShareAppDialogUsageCount();

    Object incrementShareAppDialogDismissCount(Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementShareAppDialogShareCount(Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementShareAppDialogUsageCount(Continuation<? super ResponseResource<Unit>> continuation);

    Flow<Boolean> isEnvSoundRecognitionStateSubmitted();

    Flow<Boolean> isPersonaSurveySubmitted();

    Object setEnvSoundRecognitionSubmittedState(boolean z, Continuation<? super ResponseResource<Unit>> continuation);

    Object setOnboardingShownState(boolean z, Continuation<? super ResponseResource<Unit>> continuation);

    Object setPersonaSurveySubmitted(boolean z, Continuation<? super ResponseResource<Unit>> continuation);

    Object setShareAppDialogLastUsageDate(LocalDate localDate, Continuation<? super ResponseResource<Unit>> continuation);
}
