package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: PersonaSurveyRepository.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H&J\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H¦@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H¦@¢\u0006\u0002\u0010\tJ\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0006H¦@¢\u0006\u0002\u0010\tJ\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00110\u0006H¦@¢\u0006\u0002\u0010\tJ`\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H¦@¢\u0006\u0002\u0010\u001c¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "", "getUserPersona", "Lkotlinx/coroutines/flow/Flow;", "", "getSurveyData", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUserPersonaLocally", "", "personaId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetUserPersonaData", "saveUserRolesLocally", "roleIds", "", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavedPersonaId", "getSavedRoleIds", "saveUserPersonaInfoToServer", "customerId", "deviceId", "gmailId", "token", "personaName", "roles", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PersonaSurveyRepository {
    Object getSavedPersonaId(Continuation<? super ResponseResource<String>> continuation);

    Object getSavedRoleIds(Continuation<? super ResponseResource<? extends Set<String>>> continuation);

    Object getSurveyData(Continuation<? super ResponseResource<? extends List<Persona>>> continuation);

    Flow<String> getUserPersona();

    Object resetUserPersonaData(Continuation<? super ResponseResource<Unit>> continuation);

    Object saveUserPersonaInfoToServer(String str, String str2, String str3, String str4, String str5, String str6, Set<String> set, Set<String> set2, Continuation<? super ResponseResource<Unit>> continuation);

    Object saveUserPersonaLocally(String str, Continuation<? super ResponseResource<Unit>> continuation);

    Object saveUserRolesLocally(Set<String> set, Continuation<? super ResponseResource<Unit>> continuation);
}
