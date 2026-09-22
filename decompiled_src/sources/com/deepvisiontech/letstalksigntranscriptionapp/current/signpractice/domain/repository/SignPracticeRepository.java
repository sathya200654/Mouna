package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPractice;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeDomain;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeEssay;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: SignPracticeRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH¦@¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\f0\u0003H¦@¢\u0006\u0002\u0010\u0010Jd\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0!H&J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u0010#\u001a\u00020\u0004H&¨\u0006$À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/repository/SignPracticeRepository;", "", "insertPracticeAndGetId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "signPractice", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePractice", "", "deletePractices", "signPractices", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSignPracticeDomains", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generatePracticeEssay", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeEssay;", "customerId", "", "deviceId", "gmailId", "token", "domain", "language", "topic", "complexity", "length", "", "intType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPractices", "Lkotlinx/coroutines/flow/Flow;", "getPracticeFlow", "id", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignPracticeRepository {
    Object deletePractices(List<SignPractice> list, Continuation<? super ResponseResource<Unit>> continuation);

    Object generatePracticeEssay(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, Continuation<? super ResponseResource<SignPracticeEssay>> continuation);

    Flow<List<SignPractice>> getAllPractices();

    Flow<SignPractice> getPracticeFlow(long id);

    Object getSignPracticeDomains(Continuation<? super ResponseResource<? extends List<SignPracticeDomain>>> continuation);

    Object insertPracticeAndGetId(SignPractice signPractice, Continuation<? super ResponseResource<Long>> continuation);

    Object updatePractice(SignPractice signPractice, Continuation<? super ResponseResource<Unit>> continuation);
}
