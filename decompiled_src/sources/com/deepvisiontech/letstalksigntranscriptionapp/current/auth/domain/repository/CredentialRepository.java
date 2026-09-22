package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CredentialRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/CredentialRepository;", "", "fetchMailId", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCredentialManagerCredentials", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CredentialRepository {
    Object clearCredentialManagerCredentials(Continuation<? super ResponseResource<Unit>> continuation);

    Object fetchMailId(Context context, Continuation<? super ResponseResource<String>> continuation);
}
