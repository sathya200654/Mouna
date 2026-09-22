package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.daos;

import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.local.entities.EnvironmentSoundHistoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: EnvironmentSoundHistoryDao.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH'¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/daos/EnvironmentSoundHistoryDao;", "", "insert", "", "entity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/data/local/entities/EnvironmentSoundHistoryEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keepOnlyLast1000", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHistory", "Lkotlinx/coroutines/flow/Flow;", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface EnvironmentSoundHistoryDao {
    Flow<List<EnvironmentSoundHistoryEntity>> getHistory();

    Object insert(EnvironmentSoundHistoryEntity environmentSoundHistoryEntity, Continuation<? super Unit> continuation);

    Object keepOnlyLast1000(Continuation<? super Unit> continuation);
}
