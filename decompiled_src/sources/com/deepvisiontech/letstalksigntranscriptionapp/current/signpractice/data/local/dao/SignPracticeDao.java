package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.dao;

import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.entity.SignPracticeEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: SignPracticeDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000b\u001a\u00020\u0003H'J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H'J\u001c\u0010\r\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/dao/SignPracticeDao;", "", "insertPractice", "", "practiceEntity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/entity/SignPracticeEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/entity/SignPracticeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPractices", "Lkotlinx/coroutines/flow/Flow;", "", "getPracticeFlow", "id", "getPractice", "deletePractice", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePractice", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SignPracticeDao {
    Object deletePractice(List<SignPracticeEntity> list, Continuation<? super Unit> continuation);

    Flow<List<SignPracticeEntity>> getAllPractices();

    SignPracticeEntity getPractice(long id);

    Flow<SignPracticeEntity> getPracticeFlow(long id);

    Object insertPractice(SignPracticeEntity signPracticeEntity, Continuation<? super Long> continuation);

    Object updatePractice(SignPracticeEntity signPracticeEntity, Continuation<? super Unit> continuation);
}
