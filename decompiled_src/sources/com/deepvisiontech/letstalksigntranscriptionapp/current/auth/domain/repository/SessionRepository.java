package com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: SessionRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0002\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0015\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0015\u001a\u00020\fH¦@¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH¦@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH&J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH¦@¢\u0006\u0002\u0010\u0019J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH¦@¢\u0006\u0002\u0010\u0019J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH¦@¢\u0006\u0002\u0010\u0019R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006¨\u0006\u001bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "", "token", "Lkotlinx/coroutines/flow/Flow;", "", "getToken", "()Lkotlinx/coroutines/flow/Flow;", "gmailId", "getGmailId", "deviceId", "getDeviceId", "activeConversationId", "", "getActiveConversationId", "setToken", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMailId", "mailId", "setDeviceId", "id", "setActiveConversation", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearMailId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomerId", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionRepository {
    Object clearMailId(Continuation<? super ResponseResource<Unit>> continuation);

    Flow<Long> getActiveConversationId();

    ResponseResource<String> getCustomerId();

    Object getDeviceId(Continuation<? super ResponseResource<String>> continuation);

    Flow<String> getDeviceId();

    Object getGmailId(Continuation<? super ResponseResource<String>> continuation);

    Flow<String> getGmailId();

    Object getToken(Continuation<? super ResponseResource<String>> continuation);

    Flow<String> getToken();

    Object setActiveConversation(long j, Continuation<? super ResponseResource<Unit>> continuation);

    Object setDeviceId(String str, Continuation<? super ResponseResource<Unit>> continuation);

    Object setMailId(String str, Continuation<? super ResponseResource<Unit>> continuation);

    Object setToken(String str, Continuation<? super ResponseResource<Unit>> continuation);
}
