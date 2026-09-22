package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ConversationUsageRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J4\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u001b\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\u001eJ\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\u001eJ\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\u001eJ\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\u001eJ\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fH¦@¢\u0006\u0002\u0010\u001e¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/repository/ConversationUsageRepository;", "", "getAllowedTranscriptionMsLimit", "Lkotlinx/coroutines/flow/Flow;", "", "getAllowedConversationSummaryLimit", "", "getAllowedArticleSummaryLimit", "getAllowedScanLimit", "getAllowedTtsLimit", "getAllowedTypedInterpretationLimit", "syncAllowedLimitsWithNetwork", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "deviceId", "", "gmailId", "customerId", "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentTranscriptionMs", "getCurrentConversationSummary", "getCurrentArticleSummary", "getCurrentScan", "getCurrentTts", "getCurrentTypedInterpretation", "incrementTranscriptionMs", "usedMs", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementConversationSummary", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementArticleSummary", "incrementScan", "incrementTts", "incrementTypedInterpretation", "checkAndResetDailyUsageIfNeeded", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ConversationUsageRepository {
    Object checkAndResetDailyUsageIfNeeded(Continuation<? super ResponseResource<Unit>> continuation);

    Flow<Integer> getAllowedArticleSummaryLimit();

    Flow<Integer> getAllowedConversationSummaryLimit();

    Flow<Integer> getAllowedScanLimit();

    Flow<Float> getAllowedTranscriptionMsLimit();

    Flow<Integer> getAllowedTtsLimit();

    Flow<Integer> getAllowedTypedInterpretationLimit();

    Flow<Integer> getCurrentArticleSummary();

    Flow<Integer> getCurrentConversationSummary();

    Flow<Integer> getCurrentScan();

    Flow<Float> getCurrentTranscriptionMs();

    Flow<Integer> getCurrentTts();

    Flow<Integer> getCurrentTypedInterpretation();

    Object incrementArticleSummary(Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementConversationSummary(Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementScan(Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementTranscriptionMs(float f, Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementTts(Continuation<? super ResponseResource<Unit>> continuation);

    Object incrementTypedInterpretation(Continuation<? super ResponseResource<Unit>> continuation);

    Object syncAllowedLimitsWithNetwork(String str, String str2, String str3, String str4, Continuation<? super ResponseResource<Unit>> continuation);
}
