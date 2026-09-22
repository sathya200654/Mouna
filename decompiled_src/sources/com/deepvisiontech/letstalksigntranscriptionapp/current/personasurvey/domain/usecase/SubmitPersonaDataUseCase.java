package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.presentation.viewmodels.SignPracticeCreationViewModel;
import com.google.flatbuffers.FlexBuffers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SavePersonaDataUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0086B¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/SubmitPersonaDataUseCase;", "", "personaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "persona", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "roles", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Role;", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SubmitPersonaDataUseCase {
    public static final int $stable = 0;
    private final EngagementRepository engagementRepository;
    private final PersonaSurveyRepository personaSurveyRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SubmitPersonaDataUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SavePersonaDataUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SubmitPersonaDataUseCase", f = "SavePersonaDataUseCase.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {22, 23, FlexBuffers.FBT_VECTOR_FLOAT4, 29, SignPracticeCreationViewModel.PRACTICE_NAME_MAX_CHAR_LIMIT, 32, 47}, m = "invoke", n = {"persona", "roles", "customerId", "persona", "roles", "customerId", "gmailId", "persona", "roles", "customerId", "gmailId", "deviceId", "persona", "roles", "customerId", "gmailId", "deviceId", "token", "roleIds", "roleNames", "persona", "roles", "customerId", "gmailId", "deviceId", "token", "roleIds", "roleNames", "persona", "roles", "customerId", "gmailId", "deviceId", "token", "roleIds", "roleNames", "persona", "roles", "customerId", "gmailId", "deviceId", "token", "roleIds", "roleNames", "response"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SubmitPersonaDataUseCase.this.invoke(null, null, (Continuation) this);
        }
    }

    @Inject
    public SubmitPersonaDataUseCase(PersonaSurveyRepository personaSurveyRepository, SessionRepository sessionRepository, EngagementRepository engagementRepository) {
        Intrinsics.checkNotNullParameter(personaSurveyRepository, "personaSurveyRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        this.personaSurveyRepository = personaSurveyRepository;
        this.sessionRepository = sessionRepository;
        this.engagementRepository = engagementRepository;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x033f  */
    /* JADX WARN: Code duplicated, block: B:16:0x00a2 A[PHI: r3 r4 r5 r6 r7 r8 r9 r10
  0x00a2: PHI (r3v19 java.util.Set<java.lang.String>) = (r3v16 java.util.Set<java.lang.String>), (r3v24 java.util.Set<java.lang.String>) binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r4v17 java.util.Set<java.lang.String>) = (r4v14 java.util.Set<java.lang.String>), (r4v21 java.util.Set<java.lang.String>) binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r5v16 java.lang.String) = (r5v13 java.lang.String), (r5v20 java.lang.String) binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r6v18 java.lang.String) = (r6v15 java.lang.String), (r6v22 java.lang.String) binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r7v15 java.lang.String) = (r7v12 java.lang.String), (r7v19 java.lang.String) binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r8v15 java.lang.String) = (r8v12 java.lang.String), (r8v20 java.lang.String) binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r9v6 java.util.Set<com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role>) = 
  (r9v3 java.util.Set<com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role>)
  (r9v10 java.util.Set<com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role>)
 binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]
  0x00a2: PHI (r10v6 com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona) = 
  (r10v3 com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona)
  (r10v10 com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona)
 binds: [B:53:0x024e, B:15:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x014e  */
    /* JADX WARN: Code duplicated, block: B:31:0x016b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0177  */
    /* JADX WARN: Code duplicated, block: B:37:0x0196  */
    /* JADX WARN: Code duplicated, block: B:40:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:43:0x01c3 A[LOOP:0: B:41:0x01bd->B:43:0x01c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:47:0x01ee A[LOOP:1: B:45:0x01e8->B:47:0x01ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:51:0x0229  */
    /* JADX WARN: Code duplicated, block: B:58:0x0296  */
    /* JADX WARN: Code duplicated, block: B:61:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:65:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:72:0x02f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:75:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:77:0x0301 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x0302  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x030a  */
    /* JADX WARN: Code duplicated, block: B:82:0x030f  */
    /* JADX WARN: Code duplicated, block: B:84:0x0315  */
    /* JADX WARN: Code duplicated, block: B:86:0x0319 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x031a  */
    /* JADX WARN: Code duplicated, block: B:89:0x0322  */
    /* JADX WARN: Code duplicated, block: B:91:0x0327  */
    /* JADX WARN: Code duplicated, block: B:93:0x032d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0331 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:96:0x0332  */
    /* JADX WARN: Code duplicated, block: B:98:0x033a  */
    public final Object invoke(Persona persona, Set<Role> set, Continuation<? super ResponseResource<Unit>> continuation) {
        AnonymousClass1 anonymousClass1;
        String str;
        Persona persona2;
        Set<Role> set2;
        ResponseResource responseResource;
        String str2;
        Object deviceId;
        String str3;
        Persona persona3;
        ResponseResource responseResource2;
        String str4;
        Object token;
        Set<Role> set3;
        Persona persona4;
        String str5;
        String str6;
        ResponseResource responseResource3;
        String str7;
        ArrayList arrayList;
        Iterator<T> it;
        Set<String> set4;
        ArrayList arrayList2;
        Iterator<T> it2;
        Set<String> set5;
        PersonaSurveyRepository personaSurveyRepository;
        String id;
        String str8;
        Set<String> set6;
        String str9;
        Set<String> set7;
        String str10;
        String str11;
        PersonaSurveyRepository personaSurveyRepository2;
        String str12;
        String str13;
        String str14;
        Set<String> set8;
        Set<Role> set9;
        Persona persona5;
        Set<String> set10;
        String str15;
        Object objSaveUserPersonaInfoToServer;
        String str16;
        String str17;
        String str18;
        Set<Role> set11;
        String str19;
        Set<String> set12;
        Set<String> set13;
        Persona persona6;
        ResponseResource responseResource4;
        EngagementRepository engagementRepository;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object gmailId = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure(gmailId);
                ResponseResource<String> customerId = this.sessionRepository.getCustomerId();
                if (!(customerId instanceof ResponseResource.Success)) {
                    if (customerId instanceof ResponseResource.Error) {
                        return customerId;
                    }
                    if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str = (String) ((ResponseResource.Success) customerId).getData();
                SessionRepository sessionRepository = this.sessionRepository;
                persona2 = persona;
                anonymousClass2.L$0 = persona2;
                set2 = set;
                anonymousClass2.L$1 = set2;
                anonymousClass2.L$2 = str;
                anonymousClass2.label = 1;
                gmailId = sessionRepository.getGmailId(anonymousClass2);
                if (gmailId != coroutine_suspended) {
                    responseResource = (ResponseResource) gmailId;
                    if (responseResource instanceof ResponseResource.Success) {
                        if (responseResource instanceof ResponseResource.Error) {
                            return responseResource;
                        }
                        if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str2 = (String) ((ResponseResource.Success) responseResource).getData();
                    SessionRepository sessionRepository2 = this.sessionRepository;
                    anonymousClass2.L$0 = persona2;
                    anonymousClass2.L$1 = set2;
                    anonymousClass2.L$2 = str;
                    anonymousClass2.L$3 = str2;
                    anonymousClass2.label = 2;
                    deviceId = sessionRepository2.getDeviceId(anonymousClass2);
                    if (deviceId != coroutine_suspended) {
                        Persona persona7 = persona2;
                        str3 = str2;
                        gmailId = deviceId;
                        persona3 = persona7;
                        responseResource2 = (ResponseResource) gmailId;
                        if (!(responseResource2 instanceof ResponseResource.Success)) {
                            if (responseResource2 instanceof ResponseResource.Error) {
                                return responseResource2;
                            }
                            if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str4 = (String) ((ResponseResource.Success) responseResource2).getData();
                        SessionRepository sessionRepository3 = this.sessionRepository;
                        anonymousClass2.L$0 = persona3;
                        anonymousClass2.L$1 = set2;
                        anonymousClass2.L$2 = str;
                        anonymousClass2.L$3 = str3;
                        anonymousClass2.L$4 = str4;
                        anonymousClass2.label = 3;
                        token = sessionRepository3.getToken(anonymousClass2);
                        if (token != coroutine_suspended) {
                            set3 = set2;
                            persona4 = persona3;
                            str5 = str;
                            str6 = str4;
                            gmailId = token;
                            responseResource3 = (ResponseResource) gmailId;
                            if (responseResource3 instanceof ResponseResource.Success) {
                                if (responseResource3 instanceof ResponseResource.Error) {
                                    return responseResource3;
                                }
                                if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str7 = (String) ((ResponseResource.Success) responseResource3).getData();
                            Set<Role> set14 = set3;
                            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set14, 10));
                            it = set14.iterator();
                            while (it.hasNext()) {
                                arrayList.add(((Role) it.next()).getId());
                            }
                            set4 = CollectionsKt.toSet(arrayList);
                            arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set14, 10));
                            it2 = set14.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(((Role) it2.next()).getDisplayText());
                            }
                            set5 = CollectionsKt.toSet(arrayList2);
                            personaSurveyRepository = this.personaSurveyRepository;
                            id = persona4.getId();
                            anonymousClass2.L$0 = persona4;
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                            anonymousClass2.L$2 = str5;
                            anonymousClass2.L$3 = str3;
                            anonymousClass2.L$4 = str6;
                            anonymousClass2.L$5 = str7;
                            anonymousClass2.L$6 = set4;
                            anonymousClass2.L$7 = set5;
                            anonymousClass2.label = 4;
                            if (personaSurveyRepository.saveUserPersonaLocally(id, anonymousClass2) != coroutine_suspended) {
                                str8 = str6;
                                set6 = set5;
                                str9 = str3;
                                set7 = set4;
                                str10 = str5;
                                str11 = str7;
                                personaSurveyRepository2 = this.personaSurveyRepository;
                                anonymousClass2.L$0 = persona4;
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                anonymousClass2.L$2 = str10;
                                anonymousClass2.L$3 = str9;
                                anonymousClass2.L$4 = str8;
                                anonymousClass2.L$5 = str11;
                                anonymousClass2.L$6 = set7;
                                anonymousClass2.L$7 = set6;
                                anonymousClass2.label = 5;
                                if (personaSurveyRepository2.saveUserRolesLocally(set7, anonymousClass2) != coroutine_suspended) {
                                    str12 = str9;
                                    str13 = str11;
                                    str14 = str8;
                                    set8 = set6;
                                    set9 = set3;
                                    persona5 = persona4;
                                    set10 = set7;
                                    str15 = str10;
                                    PersonaSurveyRepository personaSurveyRepository3 = this.personaSurveyRepository;
                                    String id2 = persona5.getId();
                                    String displayText = persona5.getDisplayText();
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona5);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set9);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str15);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str12);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str13);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set10);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set8);
                                    anonymousClass2.label = 6;
                                    objSaveUserPersonaInfoToServer = personaSurveyRepository3.saveUserPersonaInfoToServer(str15, str14, str12, str13, id2, displayText, set10, set8, anonymousClass2);
                                    if (objSaveUserPersonaInfoToServer != coroutine_suspended) {
                                        str16 = str14;
                                        str17 = str13;
                                        str18 = str12;
                                        set11 = set9;
                                        gmailId = objSaveUserPersonaInfoToServer;
                                        str19 = str15;
                                        set12 = set10;
                                        set13 = set8;
                                        persona6 = persona5;
                                        responseResource4 = (ResponseResource) gmailId;
                                        if (responseResource4 instanceof ResponseResource.Error) {
                                            Unit unit = Unit.INSTANCE;
                                            return responseResource4;
                                        }
                                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                            Unit unit2 = Unit.INSTANCE;
                                            return responseResource4;
                                        }
                                        if (!(responseResource4 instanceof ResponseResource.Success)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        engagementRepository = this.engagementRepository;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                                        anonymousClass2.L$8 = responseResource4;
                                        anonymousClass2.label = 7;
                                        if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                            return responseResource4;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                str = (String) anonymousClass2.L$2;
                Set<Role> set15 = (Set) anonymousClass2.L$1;
                Persona persona8 = (Persona) anonymousClass2.L$0;
                ResultKt.throwOnFailure(gmailId);
                set2 = set15;
                persona2 = persona8;
                responseResource = (ResponseResource) gmailId;
                if (responseResource instanceof ResponseResource.Success) {
                    if (responseResource instanceof ResponseResource.Error) {
                        return responseResource;
                    }
                    if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str2 = (String) ((ResponseResource.Success) responseResource).getData();
                SessionRepository sessionRepository4 = this.sessionRepository;
                anonymousClass2.L$0 = persona2;
                anonymousClass2.L$1 = set2;
                anonymousClass2.L$2 = str;
                anonymousClass2.L$3 = str2;
                anonymousClass2.label = 2;
                deviceId = sessionRepository4.getDeviceId(anonymousClass2);
                if (deviceId != coroutine_suspended) {
                    Persona persona9 = persona2;
                    str3 = str2;
                    gmailId = deviceId;
                    persona3 = persona9;
                    responseResource2 = (ResponseResource) gmailId;
                    if (!(responseResource2 instanceof ResponseResource.Success)) {
                        if (responseResource2 instanceof ResponseResource.Error) {
                            return responseResource2;
                        }
                        if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str4 = (String) ((ResponseResource.Success) responseResource2).getData();
                    SessionRepository sessionRepository5 = this.sessionRepository;
                    anonymousClass2.L$0 = persona3;
                    anonymousClass2.L$1 = set2;
                    anonymousClass2.L$2 = str;
                    anonymousClass2.L$3 = str3;
                    anonymousClass2.L$4 = str4;
                    anonymousClass2.label = 3;
                    token = sessionRepository5.getToken(anonymousClass2);
                    if (token != coroutine_suspended) {
                        set3 = set2;
                        persona4 = persona3;
                        str5 = str;
                        str6 = str4;
                        gmailId = token;
                        responseResource3 = (ResponseResource) gmailId;
                        if (responseResource3 instanceof ResponseResource.Success) {
                            if (responseResource3 instanceof ResponseResource.Error) {
                                return responseResource3;
                            }
                            if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str7 = (String) ((ResponseResource.Success) responseResource3).getData();
                        Set<Role> set16 = set3;
                        arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set16, 10));
                        it = set16.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((Role) it.next()).getId());
                        }
                        set4 = CollectionsKt.toSet(arrayList);
                        arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set16, 10));
                        it2 = set16.iterator();
                        while (it2.hasNext()) {
                            arrayList2.add(((Role) it2.next()).getDisplayText());
                        }
                        set5 = CollectionsKt.toSet(arrayList2);
                        personaSurveyRepository = this.personaSurveyRepository;
                        id = persona4.getId();
                        anonymousClass2.L$0 = persona4;
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                        anonymousClass2.L$2 = str5;
                        anonymousClass2.L$3 = str3;
                        anonymousClass2.L$4 = str6;
                        anonymousClass2.L$5 = str7;
                        anonymousClass2.L$6 = set4;
                        anonymousClass2.L$7 = set5;
                        anonymousClass2.label = 4;
                        if (personaSurveyRepository.saveUserPersonaLocally(id, anonymousClass2) != coroutine_suspended) {
                            str8 = str6;
                            set6 = set5;
                            str9 = str3;
                            set7 = set4;
                            str10 = str5;
                            str11 = str7;
                            personaSurveyRepository2 = this.personaSurveyRepository;
                            anonymousClass2.L$0 = persona4;
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                            anonymousClass2.L$2 = str10;
                            anonymousClass2.L$3 = str9;
                            anonymousClass2.L$4 = str8;
                            anonymousClass2.L$5 = str11;
                            anonymousClass2.L$6 = set7;
                            anonymousClass2.L$7 = set6;
                            anonymousClass2.label = 5;
                            if (personaSurveyRepository2.saveUserRolesLocally(set7, anonymousClass2) != coroutine_suspended) {
                                str12 = str9;
                                str13 = str11;
                                str14 = str8;
                                set8 = set6;
                                set9 = set3;
                                persona5 = persona4;
                                set10 = set7;
                                str15 = str10;
                                PersonaSurveyRepository personaSurveyRepository4 = this.personaSurveyRepository;
                                String id3 = persona5.getId();
                                String displayText2 = persona5.getDisplayText();
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona5);
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set9);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str15);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str12);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str13);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set10);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set8);
                                anonymousClass2.label = 6;
                                objSaveUserPersonaInfoToServer = personaSurveyRepository4.saveUserPersonaInfoToServer(str15, str14, str12, str13, id3, displayText2, set10, set8, anonymousClass2);
                                if (objSaveUserPersonaInfoToServer != coroutine_suspended) {
                                    str16 = str14;
                                    str17 = str13;
                                    str18 = str12;
                                    set11 = set9;
                                    gmailId = objSaveUserPersonaInfoToServer;
                                    str19 = str15;
                                    set12 = set10;
                                    set13 = set8;
                                    persona6 = persona5;
                                    responseResource4 = (ResponseResource) gmailId;
                                    if (responseResource4 instanceof ResponseResource.Error) {
                                        Unit unit3 = Unit.INSTANCE;
                                        return responseResource4;
                                    }
                                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                        Unit unit4 = Unit.INSTANCE;
                                        return responseResource4;
                                    }
                                    if (!(responseResource4 instanceof ResponseResource.Success)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    engagementRepository = this.engagementRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                                    anonymousClass2.L$8 = responseResource4;
                                    anonymousClass2.label = 7;
                                    if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                        return responseResource4;
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                String str20 = (String) anonymousClass2.L$3;
                String str21 = (String) anonymousClass2.L$2;
                set2 = (Set) anonymousClass2.L$1;
                persona3 = (Persona) anonymousClass2.L$0;
                ResultKt.throwOnFailure(gmailId);
                str3 = str20;
                str = str21;
                responseResource2 = (ResponseResource) gmailId;
                if (!(responseResource2 instanceof ResponseResource.Success)) {
                    if (responseResource2 instanceof ResponseResource.Error) {
                        return responseResource2;
                    }
                    if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str4 = (String) ((ResponseResource.Success) responseResource2).getData();
                SessionRepository sessionRepository6 = this.sessionRepository;
                anonymousClass2.L$0 = persona3;
                anonymousClass2.L$1 = set2;
                anonymousClass2.L$2 = str;
                anonymousClass2.L$3 = str3;
                anonymousClass2.L$4 = str4;
                anonymousClass2.label = 3;
                token = sessionRepository6.getToken(anonymousClass2);
                if (token != coroutine_suspended) {
                    set3 = set2;
                    persona4 = persona3;
                    str5 = str;
                    str6 = str4;
                    gmailId = token;
                    responseResource3 = (ResponseResource) gmailId;
                    if (responseResource3 instanceof ResponseResource.Success) {
                        if (responseResource3 instanceof ResponseResource.Error) {
                            return responseResource3;
                        }
                        if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str7 = (String) ((ResponseResource.Success) responseResource3).getData();
                    Set<Role> set17 = set3;
                    arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set17, 10));
                    it = set17.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Role) it.next()).getId());
                    }
                    set4 = CollectionsKt.toSet(arrayList);
                    arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set17, 10));
                    it2 = set17.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((Role) it2.next()).getDisplayText());
                    }
                    set5 = CollectionsKt.toSet(arrayList2);
                    personaSurveyRepository = this.personaSurveyRepository;
                    id = persona4.getId();
                    anonymousClass2.L$0 = persona4;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                    anonymousClass2.L$2 = str5;
                    anonymousClass2.L$3 = str3;
                    anonymousClass2.L$4 = str6;
                    anonymousClass2.L$5 = str7;
                    anonymousClass2.L$6 = set4;
                    anonymousClass2.L$7 = set5;
                    anonymousClass2.label = 4;
                    if (personaSurveyRepository.saveUserPersonaLocally(id, anonymousClass2) != coroutine_suspended) {
                        str8 = str6;
                        set6 = set5;
                        str9 = str3;
                        set7 = set4;
                        str10 = str5;
                        str11 = str7;
                        personaSurveyRepository2 = this.personaSurveyRepository;
                        anonymousClass2.L$0 = persona4;
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                        anonymousClass2.L$2 = str10;
                        anonymousClass2.L$3 = str9;
                        anonymousClass2.L$4 = str8;
                        anonymousClass2.L$5 = str11;
                        anonymousClass2.L$6 = set7;
                        anonymousClass2.L$7 = set6;
                        anonymousClass2.label = 5;
                        if (personaSurveyRepository2.saveUserRolesLocally(set7, anonymousClass2) != coroutine_suspended) {
                            str12 = str9;
                            str13 = str11;
                            str14 = str8;
                            set8 = set6;
                            set9 = set3;
                            persona5 = persona4;
                            set10 = set7;
                            str15 = str10;
                            PersonaSurveyRepository personaSurveyRepository5 = this.personaSurveyRepository;
                            String id4 = persona5.getId();
                            String displayText3 = persona5.getDisplayText();
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona5);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set9);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str15);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str12);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str13);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set10);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set8);
                            anonymousClass2.label = 6;
                            objSaveUserPersonaInfoToServer = personaSurveyRepository5.saveUserPersonaInfoToServer(str15, str14, str12, str13, id4, displayText3, set10, set8, anonymousClass2);
                            if (objSaveUserPersonaInfoToServer != coroutine_suspended) {
                                str16 = str14;
                                str17 = str13;
                                str18 = str12;
                                set11 = set9;
                                gmailId = objSaveUserPersonaInfoToServer;
                                str19 = str15;
                                set12 = set10;
                                set13 = set8;
                                persona6 = persona5;
                                responseResource4 = (ResponseResource) gmailId;
                                if (responseResource4 instanceof ResponseResource.Error) {
                                    Unit unit5 = Unit.INSTANCE;
                                    return responseResource4;
                                }
                                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                    Unit unit6 = Unit.INSTANCE;
                                    return responseResource4;
                                }
                                if (!(responseResource4 instanceof ResponseResource.Success)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                engagementRepository = this.engagementRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                                anonymousClass2.L$8 = responseResource4;
                                anonymousClass2.label = 7;
                                if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                    return responseResource4;
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 3:
                str6 = (String) anonymousClass2.L$4;
                str3 = (String) anonymousClass2.L$3;
                str5 = (String) anonymousClass2.L$2;
                Set<Role> set18 = (Set) anonymousClass2.L$1;
                Persona persona10 = (Persona) anonymousClass2.L$0;
                ResultKt.throwOnFailure(gmailId);
                set3 = set18;
                persona4 = persona10;
                responseResource3 = (ResponseResource) gmailId;
                if (responseResource3 instanceof ResponseResource.Success) {
                    if (responseResource3 instanceof ResponseResource.Error) {
                        return responseResource3;
                    }
                    if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str7 = (String) ((ResponseResource.Success) responseResource3).getData();
                Set<Role> set19 = set3;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set19, 10));
                it = set19.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Role) it.next()).getId());
                }
                set4 = CollectionsKt.toSet(arrayList);
                arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set19, 10));
                it2 = set19.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((Role) it2.next()).getDisplayText());
                }
                set5 = CollectionsKt.toSet(arrayList2);
                personaSurveyRepository = this.personaSurveyRepository;
                id = persona4.getId();
                anonymousClass2.L$0 = persona4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                anonymousClass2.L$2 = str5;
                anonymousClass2.L$3 = str3;
                anonymousClass2.L$4 = str6;
                anonymousClass2.L$5 = str7;
                anonymousClass2.L$6 = set4;
                anonymousClass2.L$7 = set5;
                anonymousClass2.label = 4;
                if (personaSurveyRepository.saveUserPersonaLocally(id, anonymousClass2) != coroutine_suspended) {
                    str8 = str6;
                    set6 = set5;
                    str9 = str3;
                    set7 = set4;
                    str10 = str5;
                    str11 = str7;
                    personaSurveyRepository2 = this.personaSurveyRepository;
                    anonymousClass2.L$0 = persona4;
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                    anonymousClass2.L$2 = str10;
                    anonymousClass2.L$3 = str9;
                    anonymousClass2.L$4 = str8;
                    anonymousClass2.L$5 = str11;
                    anonymousClass2.L$6 = set7;
                    anonymousClass2.L$7 = set6;
                    anonymousClass2.label = 5;
                    if (personaSurveyRepository2.saveUserRolesLocally(set7, anonymousClass2) != coroutine_suspended) {
                        str12 = str9;
                        str13 = str11;
                        str14 = str8;
                        set8 = set6;
                        set9 = set3;
                        persona5 = persona4;
                        set10 = set7;
                        str15 = str10;
                        PersonaSurveyRepository personaSurveyRepository6 = this.personaSurveyRepository;
                        String id5 = persona5.getId();
                        String displayText4 = persona5.getDisplayText();
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona5);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set9);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str15);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str12);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str13);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set10);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set8);
                        anonymousClass2.label = 6;
                        objSaveUserPersonaInfoToServer = personaSurveyRepository6.saveUserPersonaInfoToServer(str15, str14, str12, str13, id5, displayText4, set10, set8, anonymousClass2);
                        if (objSaveUserPersonaInfoToServer != coroutine_suspended) {
                            str16 = str14;
                            str17 = str13;
                            str18 = str12;
                            set11 = set9;
                            gmailId = objSaveUserPersonaInfoToServer;
                            str19 = str15;
                            set12 = set10;
                            set13 = set8;
                            persona6 = persona5;
                            responseResource4 = (ResponseResource) gmailId;
                            if (responseResource4 instanceof ResponseResource.Error) {
                                Unit unit7 = Unit.INSTANCE;
                                return responseResource4;
                            }
                            if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                Unit unit8 = Unit.INSTANCE;
                                return responseResource4;
                            }
                            if (!(responseResource4 instanceof ResponseResource.Success)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            engagementRepository = this.engagementRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                            anonymousClass2.L$8 = responseResource4;
                            anonymousClass2.label = 7;
                            if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                return responseResource4;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 4:
                set6 = (Set) anonymousClass2.L$7;
                set7 = (Set) anonymousClass2.L$6;
                str11 = (String) anonymousClass2.L$5;
                str8 = (String) anonymousClass2.L$4;
                str9 = (String) anonymousClass2.L$3;
                str10 = (String) anonymousClass2.L$2;
                set3 = (Set) anonymousClass2.L$1;
                persona4 = (Persona) anonymousClass2.L$0;
                ResultKt.throwOnFailure(gmailId);
                personaSurveyRepository2 = this.personaSurveyRepository;
                anonymousClass2.L$0 = persona4;
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                anonymousClass2.L$2 = str10;
                anonymousClass2.L$3 = str9;
                anonymousClass2.L$4 = str8;
                anonymousClass2.L$5 = str11;
                anonymousClass2.L$6 = set7;
                anonymousClass2.L$7 = set6;
                anonymousClass2.label = 5;
                if (personaSurveyRepository2.saveUserRolesLocally(set7, anonymousClass2) != coroutine_suspended) {
                    str12 = str9;
                    str13 = str11;
                    str14 = str8;
                    set8 = set6;
                    set9 = set3;
                    persona5 = persona4;
                    set10 = set7;
                    str15 = str10;
                    PersonaSurveyRepository personaSurveyRepository7 = this.personaSurveyRepository;
                    String id6 = persona5.getId();
                    String displayText5 = persona5.getDisplayText();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona5);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set9);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str15);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str12);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str13);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set10);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set8);
                    anonymousClass2.label = 6;
                    objSaveUserPersonaInfoToServer = personaSurveyRepository7.saveUserPersonaInfoToServer(str15, str14, str12, str13, id6, displayText5, set10, set8, anonymousClass2);
                    if (objSaveUserPersonaInfoToServer != coroutine_suspended) {
                        str16 = str14;
                        str17 = str13;
                        str18 = str12;
                        set11 = set9;
                        gmailId = objSaveUserPersonaInfoToServer;
                        str19 = str15;
                        set12 = set10;
                        set13 = set8;
                        persona6 = persona5;
                        responseResource4 = (ResponseResource) gmailId;
                        if (responseResource4 instanceof ResponseResource.Error) {
                            Unit unit9 = Unit.INSTANCE;
                            return responseResource4;
                        }
                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                            Unit unit10 = Unit.INSTANCE;
                            return responseResource4;
                        }
                        if (!(responseResource4 instanceof ResponseResource.Success)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        engagementRepository = this.engagementRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                        anonymousClass2.L$8 = responseResource4;
                        anonymousClass2.label = 7;
                        if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                            return responseResource4;
                        }
                    }
                }
                return coroutine_suspended;
            case 5:
                set6 = (Set) anonymousClass2.L$7;
                set7 = (Set) anonymousClass2.L$6;
                str11 = (String) anonymousClass2.L$5;
                str8 = (String) anonymousClass2.L$4;
                str9 = (String) anonymousClass2.L$3;
                str10 = (String) anonymousClass2.L$2;
                set3 = (Set) anonymousClass2.L$1;
                persona4 = (Persona) anonymousClass2.L$0;
                ResultKt.throwOnFailure(gmailId);
                str12 = str9;
                str13 = str11;
                str14 = str8;
                set8 = set6;
                set9 = set3;
                persona5 = persona4;
                set10 = set7;
                str15 = str10;
                PersonaSurveyRepository personaSurveyRepository8 = this.personaSurveyRepository;
                String id7 = persona5.getId();
                String displayText6 = persona5.getDisplayText();
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona5);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set9);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str15);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str12);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str14);
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str13);
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set10);
                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set8);
                anonymousClass2.label = 6;
                objSaveUserPersonaInfoToServer = personaSurveyRepository8.saveUserPersonaInfoToServer(str15, str14, str12, str13, id7, displayText6, set10, set8, anonymousClass2);
                if (objSaveUserPersonaInfoToServer != coroutine_suspended) {
                    str16 = str14;
                    str17 = str13;
                    str18 = str12;
                    set11 = set9;
                    gmailId = objSaveUserPersonaInfoToServer;
                    str19 = str15;
                    set12 = set10;
                    set13 = set8;
                    persona6 = persona5;
                    responseResource4 = (ResponseResource) gmailId;
                    if (responseResource4 instanceof ResponseResource.Error) {
                        Unit unit11 = Unit.INSTANCE;
                        return responseResource4;
                    }
                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                        Unit unit12 = Unit.INSTANCE;
                        return responseResource4;
                    }
                    if (!(responseResource4 instanceof ResponseResource.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    engagementRepository = this.engagementRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                    anonymousClass2.L$8 = responseResource4;
                    anonymousClass2.label = 7;
                    if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                        return responseResource4;
                    }
                }
                return coroutine_suspended;
            case 6:
                set13 = (Set) anonymousClass2.L$7;
                set12 = (Set) anonymousClass2.L$6;
                str17 = (String) anonymousClass2.L$5;
                str16 = (String) anonymousClass2.L$4;
                str18 = (String) anonymousClass2.L$3;
                str19 = (String) anonymousClass2.L$2;
                set11 = (Set) anonymousClass2.L$1;
                persona6 = (Persona) anonymousClass2.L$0;
                ResultKt.throwOnFailure(gmailId);
                responseResource4 = (ResponseResource) gmailId;
                if (responseResource4 instanceof ResponseResource.Error) {
                    Unit unit13 = Unit.INSTANCE;
                    return responseResource4;
                }
                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                    Unit unit14 = Unit.INSTANCE;
                    return responseResource4;
                }
                if (!(responseResource4 instanceof ResponseResource.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                engagementRepository = this.engagementRepository;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(persona6);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set11);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(str19);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(str18);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(str16);
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(str17);
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(set12);
                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(set13);
                anonymousClass2.L$8 = responseResource4;
                anonymousClass2.label = 7;
                if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return responseResource4;
            case 7:
                ResponseResource responseResource5 = (ResponseResource) anonymousClass2.L$8;
                ResultKt.throwOnFailure(gmailId);
                return responseResource5;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
