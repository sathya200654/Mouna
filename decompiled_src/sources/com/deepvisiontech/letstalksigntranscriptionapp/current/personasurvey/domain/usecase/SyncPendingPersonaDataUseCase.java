package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase;

import com.deepvisiontech.letstalksigntranscriptionapp.current.auth.domain.repository.SessionRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.AppError;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ResponseResource;
import com.deepvisiontech.letstalksigntranscriptionapp.current.engagement.domain.repository.EngagementRepository;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.local.stores.PersonaSurveyLocalDataStore;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Persona;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model.Role;
import com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.repository.PersonaSurveyRepository;
import com.google.flatbuffers.FlexBuffers;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: SyncPendingPersonaDataUseCase.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086B¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/usecase/SyncPendingPersonaDataUseCase;", "", "engagementRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;", "personaSurveyRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;", "sessionRepository", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;", "<init>", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/engagement/domain/repository/EngagementRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/repository/PersonaSurveyRepository;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/auth/domain/repository/SessionRepository;)V", "invoke", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ResponseResource;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SyncPendingPersonaDataUseCase {
    public static final int $stable = 0;
    private final EngagementRepository engagementRepository;
    private final PersonaSurveyRepository personaSurveyRepository;
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SyncPendingPersonaDataUseCase$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: SyncPendingPersonaDataUseCase.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.usecase.SyncPendingPersonaDataUseCase", f = "SyncPendingPersonaDataUseCase.kt", i = {1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {19, FlexBuffers.FBT_VECTOR_FLOAT4, 25, 40, DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER, DescriptorProtos.FileOptions.PHP_GENERIC_SERVICES_FIELD_NUMBER, DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER, 56}, m = "invoke", n = {"isAlreadySubmitted", "savedPersonaId", "isAlreadySubmitted", "savedPersonaId", "savedRoleIds", "allPersonas", "selectedPersona", "selectedRoles", "roleNames", "customerId", "isAlreadySubmitted", "savedPersonaId", "savedRoleIds", "allPersonas", "selectedPersona", "selectedRoles", "roleNames", "customerId", "gmailId", "isAlreadySubmitted", "savedPersonaId", "savedRoleIds", "allPersonas", "selectedPersona", "selectedRoles", "roleNames", "customerId", "gmailId", "deviceId", "isAlreadySubmitted", "savedPersonaId", "savedRoleIds", "allPersonas", "selectedPersona", "selectedRoles", "roleNames", "customerId", "gmailId", "deviceId", "token", "isAlreadySubmitted", "savedPersonaId", "savedRoleIds", "allPersonas", "selectedPersona", "selectedRoles", "roleNames", "customerId", "gmailId", "deviceId", "token", "response", "isAlreadySubmitted"}, s = {"Z$0", "L$0", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SyncPendingPersonaDataUseCase.this.invoke((Continuation) this);
        }
    }

    @Inject
    public SyncPendingPersonaDataUseCase(EngagementRepository engagementRepository, PersonaSurveyRepository personaSurveyRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(engagementRepository, "engagementRepository");
        Intrinsics.checkNotNullParameter(personaSurveyRepository, "personaSurveyRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.engagementRepository = engagementRepository;
        this.personaSurveyRepository = personaSurveyRepository;
        this.sessionRepository = sessionRepository;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    /* JADX WARN: Code duplicated, block: B:100:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:102:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:104:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:106:0x03e1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:109:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:111:0x03ef  */
    /* JADX WARN: Code duplicated, block: B:113:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:115:0x03f9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:116:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:118:0x0402  */
    /* JADX WARN: Code duplicated, block: B:120:0x0407  */
    /* JADX WARN: Code duplicated, block: B:122:0x040d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0411 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:125:0x0412  */
    /* JADX WARN: Code duplicated, block: B:127:0x041a  */
    /* JADX WARN: Code duplicated, block: B:129:0x041f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0425  */
    /* JADX WARN: Code duplicated, block: B:133:0x0429 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:134:0x042a  */
    /* JADX WARN: Code duplicated, block: B:136:0x0432  */
    /* JADX WARN: Code duplicated, block: B:138:0x0437  */
    /* JADX WARN: Code duplicated, block: B:140:0x043d  */
    /* JADX WARN: Code duplicated, block: B:142:0x0441 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:143:0x0442  */
    /* JADX WARN: Code duplicated, block: B:145:0x044a  */
    /* JADX WARN: Code duplicated, block: B:147:0x044f  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0150  */
    /* JADX WARN: Code duplicated, block: B:29:0x0158  */
    /* JADX WARN: Code duplicated, block: B:32:0x0167  */
    /* JADX WARN: Code duplicated, block: B:35:0x0172  */
    /* JADX WARN: Code duplicated, block: B:38:0x018c A[PHI: r1 r3 r4
  0x018c: PHI (r1v16 java.lang.Object) = (r1v15 java.lang.Object), (r1v1 java.lang.Object) binds: [B:36:0x0188, B:19:0x0121] A[DONT_GENERATE, DONT_INLINE]
  0x018c: PHI (r3v6 boolean) = (r3v4 boolean), (r3v7 boolean) binds: [B:36:0x0188, B:19:0x0121] A[DONT_GENERATE, DONT_INLINE]
  0x018c: PHI (r4v4 java.lang.String) = (r4v3 java.lang.String), (r4v7 java.lang.String) binds: [B:36:0x0188, B:19:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x0192  */
    /* JADX WARN: Code duplicated, block: B:42:0x019d  */
    /* JADX WARN: Code duplicated, block: B:44:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:47:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:53:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:55:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:58:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:64:0x0221 A[LOOP:2: B:62:0x021b->B:64:0x0221, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x0241  */
    /* JADX WARN: Code duplicated, block: B:70:0x0272  */
    /* JADX WARN: Code duplicated, block: B:73:0x027d  */
    /* JADX WARN: Code duplicated, block: B:76:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:79:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x0308  */
    /* JADX WARN: Code duplicated, block: B:88:0x0363  */
    /* JADX WARN: Code duplicated, block: B:91:0x0376  */
    /* JADX WARN: Code duplicated, block: B:95:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:97:0x03c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x03ca  */
    public final Object invoke(Continuation<? super ResponseResource<Unit>> continuation) throws NoWhenBranchMatchedException {
        AnonymousClass1 anonymousClass1;
        boolean zBooleanValue;
        Object savedPersonaId;
        boolean z;
        ResponseResource responseResource;
        String str;
        ResponseResource responseResource2;
        Set<String> set;
        List<Persona> personaSurveyData;
        Iterator<T> it;
        Object next;
        Persona persona;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Iterator it2;
        Set<String> set2;
        ResponseResource<String> customerId;
        String str2;
        Object gmailId;
        String str3;
        String str4;
        Persona persona2;
        List<Persona> list;
        ResponseResource responseResource3;
        String str5;
        Object deviceId;
        String str6;
        Set<String> set3;
        List<Persona> list2;
        String str7;
        Set<String> set4;
        ResponseResource responseResource4;
        String str8;
        Object token;
        List list3;
        Persona persona3;
        List<Persona> list4;
        String str9;
        Set<String> set5;
        String str10;
        String str11;
        String str12;
        boolean z2;
        ResponseResource responseResource5;
        String str13;
        String str14;
        String str15;
        Set<String> set6;
        boolean z3;
        List list5;
        List<Persona> list6;
        String str16;
        Set<String> set7;
        Persona persona4;
        ResponseResource responseResource6;
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
        Object objFirst = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass2.label) {
            case 0:
                ResultKt.throwOnFailure(objFirst);
                Flow<Boolean> flowIsPersonaSurveySubmitted = this.engagementRepository.isPersonaSurveySubmitted();
                anonymousClass2.label = 1;
                objFirst = FlowKt.first(flowIsPersonaSurveySubmitted, anonymousClass2);
                if (objFirst != coroutine_suspended) {
                    zBooleanValue = ((Boolean) objFirst).booleanValue();
                    if (zBooleanValue) {
                        return new ResponseResource.Success(Unit.INSTANCE);
                    }
                    PersonaSurveyRepository personaSurveyRepository = this.personaSurveyRepository;
                    anonymousClass2.Z$0 = zBooleanValue;
                    anonymousClass2.label = 2;
                    savedPersonaId = personaSurveyRepository.getSavedPersonaId(anonymousClass2);
                    if (savedPersonaId != coroutine_suspended) {
                        z = zBooleanValue;
                        objFirst = savedPersonaId;
                        responseResource = (ResponseResource) objFirst;
                        if (!(responseResource instanceof ResponseResource.Success)) {
                            if (responseResource instanceof ResponseResource.Error) {
                                return responseResource;
                            }
                            if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str = (String) ((ResponseResource.Success) responseResource).getData();
                        PersonaSurveyRepository personaSurveyRepository2 = this.personaSurveyRepository;
                        anonymousClass2.L$0 = str;
                        anonymousClass2.Z$0 = z;
                        anonymousClass2.label = 3;
                        objFirst = personaSurveyRepository2.getSavedRoleIds(anonymousClass2);
                        if (objFirst != coroutine_suspended) {
                            responseResource2 = (ResponseResource) objFirst;
                            if (responseResource2 instanceof ResponseResource.Success) {
                                if (responseResource2 instanceof ResponseResource.Error) {
                                    return responseResource2;
                                }
                                if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            set = (Set) ((ResponseResource.Success) responseResource2).getData();
                            if (str == null) {
                                return new ResponseResource.Success(Unit.INSTANCE);
                            }
                            personaSurveyData = PersonaSurveyLocalDataStore.INSTANCE.getPersonaSurveyData();
                            it = personaSurveyData.iterator();
                            do {
                                if (it.hasNext()) {
                                    next = it.next();
                                } else {
                                    next = null;
                                }
                                persona = (Persona) next;
                                if (persona == null) {
                                    return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                                }
                                List<Role> roles = persona.getRoles();
                                arrayList = new ArrayList();
                                for (Object obj : roles) {
                                    if (set.contains(((Role) obj).getId())) {
                                        arrayList.add(obj);
                                    }
                                }
                                arrayList2 = arrayList;
                                ArrayList arrayList4 = arrayList2;
                                arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                                it2 = arrayList4.iterator();
                                while (it2.hasNext()) {
                                    arrayList3.add(((Role) it2.next()).getDisplayText());
                                }
                                set2 = CollectionsKt.toSet(arrayList3);
                                customerId = this.sessionRepository.getCustomerId();
                                if (customerId instanceof ResponseResource.Success) {
                                    if (customerId instanceof ResponseResource.Error) {
                                        return customerId;
                                    }
                                    if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str2 = (String) ((ResponseResource.Success) customerId).getData();
                                SessionRepository sessionRepository = this.sessionRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                                anonymousClass2.L$1 = set;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                                anonymousClass2.L$3 = persona;
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                anonymousClass2.L$5 = set2;
                                anonymousClass2.L$6 = str2;
                                anonymousClass2.Z$0 = z;
                                anonymousClass2.label = 4;
                                gmailId = sessionRepository.getGmailId(anonymousClass2);
                                if (gmailId != coroutine_suspended) {
                                    str3 = str;
                                    str4 = str2;
                                    persona2 = persona;
                                    list = personaSurveyData;
                                    objFirst = gmailId;
                                    responseResource3 = (ResponseResource) objFirst;
                                    if (!(responseResource3 instanceof ResponseResource.Success)) {
                                        if (responseResource3 instanceof ResponseResource.Error) {
                                            return responseResource3;
                                        }
                                        if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                                    SessionRepository sessionRepository2 = this.sessionRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$1 = set;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                    anonymousClass2.L$3 = persona2;
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                    anonymousClass2.L$5 = set2;
                                    anonymousClass2.L$6 = str4;
                                    anonymousClass2.L$7 = str5;
                                    anonymousClass2.Z$0 = z;
                                    anonymousClass2.label = 5;
                                    deviceId = sessionRepository2.getDeviceId(anonymousClass2);
                                    if (deviceId != coroutine_suspended) {
                                        Set<String> set8 = set2;
                                        str6 = str5;
                                        objFirst = deviceId;
                                        set3 = set;
                                        list2 = list;
                                        str7 = str4;
                                        set4 = set8;
                                        responseResource4 = (ResponseResource) objFirst;
                                        if (responseResource4 instanceof ResponseResource.Success) {
                                            if (responseResource4 instanceof ResponseResource.Error) {
                                                return responseResource4;
                                            }
                                            if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                                return ResponseResource.Loading.INSTANCE;
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                                        SessionRepository sessionRepository3 = this.sessionRepository;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                        anonymousClass2.L$1 = set3;
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                                        anonymousClass2.L$3 = persona2;
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                        anonymousClass2.L$5 = set4;
                                        anonymousClass2.L$6 = str7;
                                        anonymousClass2.L$7 = str6;
                                        anonymousClass2.L$8 = str8;
                                        anonymousClass2.Z$0 = z;
                                        anonymousClass2.label = 6;
                                        token = sessionRepository3.getToken(anonymousClass2);
                                        if (token != coroutine_suspended) {
                                            list3 = arrayList2;
                                            persona3 = persona2;
                                            list4 = list2;
                                            str9 = str3;
                                            set5 = set4;
                                            str10 = str7;
                                            str11 = str6;
                                            str12 = str8;
                                            objFirst = token;
                                            z2 = z;
                                            responseResource5 = (ResponseResource) objFirst;
                                            if (!(responseResource5 instanceof ResponseResource.Success)) {
                                                if (responseResource5 instanceof ResponseResource.Error) {
                                                    return responseResource5;
                                                }
                                                if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                                    return ResponseResource.Loading.INSTANCE;
                                                }
                                                throw new NoWhenBranchMatchedException();
                                            }
                                            str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                            PersonaSurveyRepository personaSurveyRepository3 = this.personaSurveyRepository;
                                            String id = persona3.getId();
                                            String displayText = persona3.getDisplayText();
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                            anonymousClass2.Z$0 = z2;
                                            anonymousClass2.label = 7;
                                            objFirst = personaSurveyRepository3.saveUserPersonaInfoToServer(str10, str12, str11, str13, id, displayText, set3, set5, anonymousClass2);
                                            if (objFirst != coroutine_suspended) {
                                                str14 = str10;
                                                str15 = str13;
                                                set6 = set5;
                                                z3 = z2;
                                                list5 = list3;
                                                list6 = list4;
                                                str16 = str9;
                                                set7 = set3;
                                                persona4 = persona3;
                                                responseResource6 = (ResponseResource) objFirst;
                                                if (responseResource6 instanceof ResponseResource.Success) {
                                                    engagementRepository = this.engagementRepository;
                                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                                    anonymousClass2.L$10 = responseResource6;
                                                    anonymousClass2.Z$0 = z3;
                                                    anonymousClass2.label = 8;
                                                    if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                                    }
                                                }
                                                return responseResource6;
                                            }
                                        }
                                    }
                                }
                            } while (!Intrinsics.areEqual(((Persona) next).getId(), str));
                            persona = (Persona) next;
                            if (persona == null) {
                                return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                            }
                            List<Role> roles2 = persona.getRoles();
                            arrayList = new ArrayList();
                            while (r5.hasNext()) {
                                if (set.contains(((Role) obj).getId())) {
                                    arrayList.add(obj);
                                }
                            }
                            arrayList2 = arrayList;
                            ArrayList arrayList5 = arrayList2;
                            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                            it2 = arrayList5.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(((Role) it2.next()).getDisplayText());
                            }
                            set2 = CollectionsKt.toSet(arrayList3);
                            customerId = this.sessionRepository.getCustomerId();
                            if (customerId instanceof ResponseResource.Success) {
                                if (customerId instanceof ResponseResource.Error) {
                                    return customerId;
                                }
                                if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str2 = (String) ((ResponseResource.Success) customerId).getData();
                            SessionRepository sessionRepository4 = this.sessionRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                            anonymousClass2.L$1 = set;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                            anonymousClass2.L$3 = persona;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            anonymousClass2.L$5 = set2;
                            anonymousClass2.L$6 = str2;
                            anonymousClass2.Z$0 = z;
                            anonymousClass2.label = 4;
                            gmailId = sessionRepository4.getGmailId(anonymousClass2);
                            if (gmailId != coroutine_suspended) {
                                str3 = str;
                                str4 = str2;
                                persona2 = persona;
                                list = personaSurveyData;
                                objFirst = gmailId;
                                responseResource3 = (ResponseResource) objFirst;
                                if (!(responseResource3 instanceof ResponseResource.Success)) {
                                    if (responseResource3 instanceof ResponseResource.Error) {
                                        return responseResource3;
                                    }
                                    if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                                SessionRepository sessionRepository5 = this.sessionRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass2.L$1 = set;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                anonymousClass2.L$3 = persona2;
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                anonymousClass2.L$5 = set2;
                                anonymousClass2.L$6 = str4;
                                anonymousClass2.L$7 = str5;
                                anonymousClass2.Z$0 = z;
                                anonymousClass2.label = 5;
                                deviceId = sessionRepository5.getDeviceId(anonymousClass2);
                                if (deviceId != coroutine_suspended) {
                                    Set<String> set9 = set2;
                                    str6 = str5;
                                    objFirst = deviceId;
                                    set3 = set;
                                    list2 = list;
                                    str7 = str4;
                                    set4 = set9;
                                    responseResource4 = (ResponseResource) objFirst;
                                    if (responseResource4 instanceof ResponseResource.Success) {
                                        if (responseResource4 instanceof ResponseResource.Error) {
                                            return responseResource4;
                                        }
                                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                                    SessionRepository sessionRepository6 = this.sessionRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$1 = set3;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                                    anonymousClass2.L$3 = persona2;
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                    anonymousClass2.L$5 = set4;
                                    anonymousClass2.L$6 = str7;
                                    anonymousClass2.L$7 = str6;
                                    anonymousClass2.L$8 = str8;
                                    anonymousClass2.Z$0 = z;
                                    anonymousClass2.label = 6;
                                    token = sessionRepository6.getToken(anonymousClass2);
                                    if (token != coroutine_suspended) {
                                        list3 = arrayList2;
                                        persona3 = persona2;
                                        list4 = list2;
                                        str9 = str3;
                                        set5 = set4;
                                        str10 = str7;
                                        str11 = str6;
                                        str12 = str8;
                                        objFirst = token;
                                        z2 = z;
                                        responseResource5 = (ResponseResource) objFirst;
                                        if (!(responseResource5 instanceof ResponseResource.Success)) {
                                            if (responseResource5 instanceof ResponseResource.Error) {
                                                return responseResource5;
                                            }
                                            if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                                return ResponseResource.Loading.INSTANCE;
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                        PersonaSurveyRepository personaSurveyRepository4 = this.personaSurveyRepository;
                                        String id2 = persona3.getId();
                                        String displayText2 = persona3.getDisplayText();
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                        anonymousClass2.Z$0 = z2;
                                        anonymousClass2.label = 7;
                                        objFirst = personaSurveyRepository4.saveUserPersonaInfoToServer(str10, str12, str11, str13, id2, displayText2, set3, set5, anonymousClass2);
                                        if (objFirst != coroutine_suspended) {
                                            str14 = str10;
                                            str15 = str13;
                                            set6 = set5;
                                            z3 = z2;
                                            list5 = list3;
                                            list6 = list4;
                                            str16 = str9;
                                            set7 = set3;
                                            persona4 = persona3;
                                            responseResource6 = (ResponseResource) objFirst;
                                            if (responseResource6 instanceof ResponseResource.Success) {
                                                engagementRepository = this.engagementRepository;
                                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                                anonymousClass2.L$10 = responseResource6;
                                                anonymousClass2.Z$0 = z3;
                                                anonymousClass2.label = 8;
                                                if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                                }
                                            }
                                            return responseResource6;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 1:
                ResultKt.throwOnFailure(objFirst);
                zBooleanValue = ((Boolean) objFirst).booleanValue();
                if (zBooleanValue) {
                    return new ResponseResource.Success(Unit.INSTANCE);
                }
                PersonaSurveyRepository personaSurveyRepository5 = this.personaSurveyRepository;
                anonymousClass2.Z$0 = zBooleanValue;
                anonymousClass2.label = 2;
                savedPersonaId = personaSurveyRepository5.getSavedPersonaId(anonymousClass2);
                if (savedPersonaId != coroutine_suspended) {
                    z = zBooleanValue;
                    objFirst = savedPersonaId;
                    responseResource = (ResponseResource) objFirst;
                    if (!(responseResource instanceof ResponseResource.Success)) {
                        if (responseResource instanceof ResponseResource.Error) {
                            return responseResource;
                        }
                        if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str = (String) ((ResponseResource.Success) responseResource).getData();
                    PersonaSurveyRepository personaSurveyRepository6 = this.personaSurveyRepository;
                    anonymousClass2.L$0 = str;
                    anonymousClass2.Z$0 = z;
                    anonymousClass2.label = 3;
                    objFirst = personaSurveyRepository6.getSavedRoleIds(anonymousClass2);
                    if (objFirst != coroutine_suspended) {
                        responseResource2 = (ResponseResource) objFirst;
                        if (responseResource2 instanceof ResponseResource.Success) {
                            if (responseResource2 instanceof ResponseResource.Error) {
                                return responseResource2;
                            }
                            if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        set = (Set) ((ResponseResource.Success) responseResource2).getData();
                        if (str == null) {
                            return new ResponseResource.Success(Unit.INSTANCE);
                        }
                        personaSurveyData = PersonaSurveyLocalDataStore.INSTANCE.getPersonaSurveyData();
                        it = personaSurveyData.iterator();
                        do {
                            if (it.hasNext()) {
                                next = it.next();
                            } else {
                                next = null;
                            }
                            persona = (Persona) next;
                            if (persona == null) {
                                return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                            }
                            List<Role> roles3 = persona.getRoles();
                            arrayList = new ArrayList();
                            while (r5.hasNext()) {
                                if (set.contains(((Role) obj).getId())) {
                                    arrayList.add(obj);
                                }
                            }
                            arrayList2 = arrayList;
                            ArrayList arrayList6 = arrayList2;
                            arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                            it2 = arrayList6.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add(((Role) it2.next()).getDisplayText());
                            }
                            set2 = CollectionsKt.toSet(arrayList3);
                            customerId = this.sessionRepository.getCustomerId();
                            if (customerId instanceof ResponseResource.Success) {
                                if (customerId instanceof ResponseResource.Error) {
                                    return customerId;
                                }
                                if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str2 = (String) ((ResponseResource.Success) customerId).getData();
                            SessionRepository sessionRepository7 = this.sessionRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                            anonymousClass2.L$1 = set;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                            anonymousClass2.L$3 = persona;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            anonymousClass2.L$5 = set2;
                            anonymousClass2.L$6 = str2;
                            anonymousClass2.Z$0 = z;
                            anonymousClass2.label = 4;
                            gmailId = sessionRepository7.getGmailId(anonymousClass2);
                            if (gmailId != coroutine_suspended) {
                                str3 = str;
                                str4 = str2;
                                persona2 = persona;
                                list = personaSurveyData;
                                objFirst = gmailId;
                                responseResource3 = (ResponseResource) objFirst;
                                if (!(responseResource3 instanceof ResponseResource.Success)) {
                                    if (responseResource3 instanceof ResponseResource.Error) {
                                        return responseResource3;
                                    }
                                    if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                                SessionRepository sessionRepository8 = this.sessionRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass2.L$1 = set;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                                anonymousClass2.L$3 = persona2;
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                anonymousClass2.L$5 = set2;
                                anonymousClass2.L$6 = str4;
                                anonymousClass2.L$7 = str5;
                                anonymousClass2.Z$0 = z;
                                anonymousClass2.label = 5;
                                deviceId = sessionRepository8.getDeviceId(anonymousClass2);
                                if (deviceId != coroutine_suspended) {
                                    Set<String> set10 = set2;
                                    str6 = str5;
                                    objFirst = deviceId;
                                    set3 = set;
                                    list2 = list;
                                    str7 = str4;
                                    set4 = set10;
                                    responseResource4 = (ResponseResource) objFirst;
                                    if (responseResource4 instanceof ResponseResource.Success) {
                                        if (responseResource4 instanceof ResponseResource.Error) {
                                            return responseResource4;
                                        }
                                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                                    SessionRepository sessionRepository9 = this.sessionRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                    anonymousClass2.L$1 = set3;
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                                    anonymousClass2.L$3 = persona2;
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                    anonymousClass2.L$5 = set4;
                                    anonymousClass2.L$6 = str7;
                                    anonymousClass2.L$7 = str6;
                                    anonymousClass2.L$8 = str8;
                                    anonymousClass2.Z$0 = z;
                                    anonymousClass2.label = 6;
                                    token = sessionRepository9.getToken(anonymousClass2);
                                    if (token != coroutine_suspended) {
                                        list3 = arrayList2;
                                        persona3 = persona2;
                                        list4 = list2;
                                        str9 = str3;
                                        set5 = set4;
                                        str10 = str7;
                                        str11 = str6;
                                        str12 = str8;
                                        objFirst = token;
                                        z2 = z;
                                        responseResource5 = (ResponseResource) objFirst;
                                        if (!(responseResource5 instanceof ResponseResource.Success)) {
                                            if (responseResource5 instanceof ResponseResource.Error) {
                                                return responseResource5;
                                            }
                                            if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                                return ResponseResource.Loading.INSTANCE;
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                        PersonaSurveyRepository personaSurveyRepository7 = this.personaSurveyRepository;
                                        String id3 = persona3.getId();
                                        String displayText3 = persona3.getDisplayText();
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                        anonymousClass2.Z$0 = z2;
                                        anonymousClass2.label = 7;
                                        objFirst = personaSurveyRepository7.saveUserPersonaInfoToServer(str10, str12, str11, str13, id3, displayText3, set3, set5, anonymousClass2);
                                        if (objFirst != coroutine_suspended) {
                                            str14 = str10;
                                            str15 = str13;
                                            set6 = set5;
                                            z3 = z2;
                                            list5 = list3;
                                            list6 = list4;
                                            str16 = str9;
                                            set7 = set3;
                                            persona4 = persona3;
                                            responseResource6 = (ResponseResource) objFirst;
                                            if (responseResource6 instanceof ResponseResource.Success) {
                                                engagementRepository = this.engagementRepository;
                                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                                anonymousClass2.L$10 = responseResource6;
                                                anonymousClass2.Z$0 = z3;
                                                anonymousClass2.label = 8;
                                                if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                                }
                                            }
                                            return responseResource6;
                                        }
                                    }
                                }
                            }
                        } while (!Intrinsics.areEqual(((Persona) next).getId(), str));
                        persona = (Persona) next;
                        if (persona == null) {
                            return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                        }
                        List<Role> roles4 = persona.getRoles();
                        arrayList = new ArrayList();
                        while (r5.hasNext()) {
                            if (set.contains(((Role) obj).getId())) {
                                arrayList.add(obj);
                            }
                        }
                        arrayList2 = arrayList;
                        ArrayList arrayList7 = arrayList2;
                        arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                        it2 = arrayList7.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(((Role) it2.next()).getDisplayText());
                        }
                        set2 = CollectionsKt.toSet(arrayList3);
                        customerId = this.sessionRepository.getCustomerId();
                        if (customerId instanceof ResponseResource.Success) {
                            if (customerId instanceof ResponseResource.Error) {
                                return customerId;
                            }
                            if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str2 = (String) ((ResponseResource.Success) customerId).getData();
                        SessionRepository sessionRepository10 = this.sessionRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        anonymousClass2.L$1 = set;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                        anonymousClass2.L$3 = persona;
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                        anonymousClass2.L$5 = set2;
                        anonymousClass2.L$6 = str2;
                        anonymousClass2.Z$0 = z;
                        anonymousClass2.label = 4;
                        gmailId = sessionRepository10.getGmailId(anonymousClass2);
                        if (gmailId != coroutine_suspended) {
                            str3 = str;
                            str4 = str2;
                            persona2 = persona;
                            list = personaSurveyData;
                            objFirst = gmailId;
                            responseResource3 = (ResponseResource) objFirst;
                            if (!(responseResource3 instanceof ResponseResource.Success)) {
                                if (responseResource3 instanceof ResponseResource.Error) {
                                    return responseResource3;
                                }
                                if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                            SessionRepository sessionRepository11 = this.sessionRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$1 = set;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            anonymousClass2.L$3 = persona2;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            anonymousClass2.L$5 = set2;
                            anonymousClass2.L$6 = str4;
                            anonymousClass2.L$7 = str5;
                            anonymousClass2.Z$0 = z;
                            anonymousClass2.label = 5;
                            deviceId = sessionRepository11.getDeviceId(anonymousClass2);
                            if (deviceId != coroutine_suspended) {
                                Set<String> set11 = set2;
                                str6 = str5;
                                objFirst = deviceId;
                                set3 = set;
                                list2 = list;
                                str7 = str4;
                                set4 = set11;
                                responseResource4 = (ResponseResource) objFirst;
                                if (responseResource4 instanceof ResponseResource.Success) {
                                    if (responseResource4 instanceof ResponseResource.Error) {
                                        return responseResource4;
                                    }
                                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                                SessionRepository sessionRepository12 = this.sessionRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass2.L$1 = set3;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                                anonymousClass2.L$3 = persona2;
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                anonymousClass2.L$5 = set4;
                                anonymousClass2.L$6 = str7;
                                anonymousClass2.L$7 = str6;
                                anonymousClass2.L$8 = str8;
                                anonymousClass2.Z$0 = z;
                                anonymousClass2.label = 6;
                                token = sessionRepository12.getToken(anonymousClass2);
                                if (token != coroutine_suspended) {
                                    list3 = arrayList2;
                                    persona3 = persona2;
                                    list4 = list2;
                                    str9 = str3;
                                    set5 = set4;
                                    str10 = str7;
                                    str11 = str6;
                                    str12 = str8;
                                    objFirst = token;
                                    z2 = z;
                                    responseResource5 = (ResponseResource) objFirst;
                                    if (!(responseResource5 instanceof ResponseResource.Success)) {
                                        if (responseResource5 instanceof ResponseResource.Error) {
                                            return responseResource5;
                                        }
                                        if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                    PersonaSurveyRepository personaSurveyRepository8 = this.personaSurveyRepository;
                                    String id4 = persona3.getId();
                                    String displayText4 = persona3.getDisplayText();
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                    anonymousClass2.Z$0 = z2;
                                    anonymousClass2.label = 7;
                                    objFirst = personaSurveyRepository8.saveUserPersonaInfoToServer(str10, str12, str11, str13, id4, displayText4, set3, set5, anonymousClass2);
                                    if (objFirst != coroutine_suspended) {
                                        str14 = str10;
                                        str15 = str13;
                                        set6 = set5;
                                        z3 = z2;
                                        list5 = list3;
                                        list6 = list4;
                                        str16 = str9;
                                        set7 = set3;
                                        persona4 = persona3;
                                        responseResource6 = (ResponseResource) objFirst;
                                        if (responseResource6 instanceof ResponseResource.Success) {
                                            engagementRepository = this.engagementRepository;
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                            anonymousClass2.L$10 = responseResource6;
                                            anonymousClass2.Z$0 = z3;
                                            anonymousClass2.label = 8;
                                            if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                            }
                                        }
                                        return responseResource6;
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 2:
                z = anonymousClass2.Z$0;
                ResultKt.throwOnFailure(objFirst);
                responseResource = (ResponseResource) objFirst;
                if (!(responseResource instanceof ResponseResource.Success)) {
                    if (responseResource instanceof ResponseResource.Error) {
                        return responseResource;
                    }
                    if (Intrinsics.areEqual(responseResource, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str = (String) ((ResponseResource.Success) responseResource).getData();
                PersonaSurveyRepository personaSurveyRepository9 = this.personaSurveyRepository;
                anonymousClass2.L$0 = str;
                anonymousClass2.Z$0 = z;
                anonymousClass2.label = 3;
                objFirst = personaSurveyRepository9.getSavedRoleIds(anonymousClass2);
                if (objFirst != coroutine_suspended) {
                    responseResource2 = (ResponseResource) objFirst;
                    if (responseResource2 instanceof ResponseResource.Success) {
                        if (responseResource2 instanceof ResponseResource.Error) {
                            return responseResource2;
                        }
                        if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    set = (Set) ((ResponseResource.Success) responseResource2).getData();
                    if (str == null) {
                        return new ResponseResource.Success(Unit.INSTANCE);
                    }
                    personaSurveyData = PersonaSurveyLocalDataStore.INSTANCE.getPersonaSurveyData();
                    it = personaSurveyData.iterator();
                    do {
                        if (it.hasNext()) {
                            next = it.next();
                        } else {
                            next = null;
                        }
                        persona = (Persona) next;
                        if (persona == null) {
                            return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                        }
                        List<Role> roles5 = persona.getRoles();
                        arrayList = new ArrayList();
                        while (r5.hasNext()) {
                            if (set.contains(((Role) obj).getId())) {
                                arrayList.add(obj);
                            }
                        }
                        arrayList2 = arrayList;
                        ArrayList arrayList8 = arrayList2;
                        arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
                        it2 = arrayList8.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(((Role) it2.next()).getDisplayText());
                        }
                        set2 = CollectionsKt.toSet(arrayList3);
                        customerId = this.sessionRepository.getCustomerId();
                        if (customerId instanceof ResponseResource.Success) {
                            if (customerId instanceof ResponseResource.Error) {
                                return customerId;
                            }
                            if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str2 = (String) ((ResponseResource.Success) customerId).getData();
                        SessionRepository sessionRepository13 = this.sessionRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        anonymousClass2.L$1 = set;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                        anonymousClass2.L$3 = persona;
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                        anonymousClass2.L$5 = set2;
                        anonymousClass2.L$6 = str2;
                        anonymousClass2.Z$0 = z;
                        anonymousClass2.label = 4;
                        gmailId = sessionRepository13.getGmailId(anonymousClass2);
                        if (gmailId != coroutine_suspended) {
                            str3 = str;
                            str4 = str2;
                            persona2 = persona;
                            list = personaSurveyData;
                            objFirst = gmailId;
                            responseResource3 = (ResponseResource) objFirst;
                            if (!(responseResource3 instanceof ResponseResource.Success)) {
                                if (responseResource3 instanceof ResponseResource.Error) {
                                    return responseResource3;
                                }
                                if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                            SessionRepository sessionRepository14 = this.sessionRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$1 = set;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                            anonymousClass2.L$3 = persona2;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            anonymousClass2.L$5 = set2;
                            anonymousClass2.L$6 = str4;
                            anonymousClass2.L$7 = str5;
                            anonymousClass2.Z$0 = z;
                            anonymousClass2.label = 5;
                            deviceId = sessionRepository14.getDeviceId(anonymousClass2);
                            if (deviceId != coroutine_suspended) {
                                Set<String> set12 = set2;
                                str6 = str5;
                                objFirst = deviceId;
                                set3 = set;
                                list2 = list;
                                str7 = str4;
                                set4 = set12;
                                responseResource4 = (ResponseResource) objFirst;
                                if (responseResource4 instanceof ResponseResource.Success) {
                                    if (responseResource4 instanceof ResponseResource.Error) {
                                        return responseResource4;
                                    }
                                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                                SessionRepository sessionRepository15 = this.sessionRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                anonymousClass2.L$1 = set3;
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                                anonymousClass2.L$3 = persona2;
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                                anonymousClass2.L$5 = set4;
                                anonymousClass2.L$6 = str7;
                                anonymousClass2.L$7 = str6;
                                anonymousClass2.L$8 = str8;
                                anonymousClass2.Z$0 = z;
                                anonymousClass2.label = 6;
                                token = sessionRepository15.getToken(anonymousClass2);
                                if (token != coroutine_suspended) {
                                    list3 = arrayList2;
                                    persona3 = persona2;
                                    list4 = list2;
                                    str9 = str3;
                                    set5 = set4;
                                    str10 = str7;
                                    str11 = str6;
                                    str12 = str8;
                                    objFirst = token;
                                    z2 = z;
                                    responseResource5 = (ResponseResource) objFirst;
                                    if (!(responseResource5 instanceof ResponseResource.Success)) {
                                        if (responseResource5 instanceof ResponseResource.Error) {
                                            return responseResource5;
                                        }
                                        if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                            return ResponseResource.Loading.INSTANCE;
                                        }
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                    PersonaSurveyRepository personaSurveyRepository10 = this.personaSurveyRepository;
                                    String id5 = persona3.getId();
                                    String displayText5 = persona3.getDisplayText();
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                    anonymousClass2.Z$0 = z2;
                                    anonymousClass2.label = 7;
                                    objFirst = personaSurveyRepository10.saveUserPersonaInfoToServer(str10, str12, str11, str13, id5, displayText5, set3, set5, anonymousClass2);
                                    if (objFirst != coroutine_suspended) {
                                        str14 = str10;
                                        str15 = str13;
                                        set6 = set5;
                                        z3 = z2;
                                        list5 = list3;
                                        list6 = list4;
                                        str16 = str9;
                                        set7 = set3;
                                        persona4 = persona3;
                                        responseResource6 = (ResponseResource) objFirst;
                                        if (responseResource6 instanceof ResponseResource.Success) {
                                            engagementRepository = this.engagementRepository;
                                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                            anonymousClass2.L$10 = responseResource6;
                                            anonymousClass2.Z$0 = z3;
                                            anonymousClass2.label = 8;
                                            if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                            }
                                        }
                                        return responseResource6;
                                    }
                                }
                            }
                        }
                    } while (!Intrinsics.areEqual(((Persona) next).getId(), str));
                    persona = (Persona) next;
                    if (persona == null) {
                        return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                    }
                    List<Role> roles6 = persona.getRoles();
                    arrayList = new ArrayList();
                    while (r5.hasNext()) {
                        if (set.contains(((Role) obj).getId())) {
                            arrayList.add(obj);
                        }
                    }
                    arrayList2 = arrayList;
                    ArrayList arrayList9 = arrayList2;
                    arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList9, 10));
                    it2 = arrayList9.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((Role) it2.next()).getDisplayText());
                    }
                    set2 = CollectionsKt.toSet(arrayList3);
                    customerId = this.sessionRepository.getCustomerId();
                    if (customerId instanceof ResponseResource.Success) {
                        if (customerId instanceof ResponseResource.Error) {
                            return customerId;
                        }
                        if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str2 = (String) ((ResponseResource.Success) customerId).getData();
                    SessionRepository sessionRepository16 = this.sessionRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass2.L$1 = set;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                    anonymousClass2.L$3 = persona;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    anonymousClass2.L$5 = set2;
                    anonymousClass2.L$6 = str2;
                    anonymousClass2.Z$0 = z;
                    anonymousClass2.label = 4;
                    gmailId = sessionRepository16.getGmailId(anonymousClass2);
                    if (gmailId != coroutine_suspended) {
                        str3 = str;
                        str4 = str2;
                        persona2 = persona;
                        list = personaSurveyData;
                        objFirst = gmailId;
                        responseResource3 = (ResponseResource) objFirst;
                        if (!(responseResource3 instanceof ResponseResource.Success)) {
                            if (responseResource3 instanceof ResponseResource.Error) {
                                return responseResource3;
                            }
                            if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                        SessionRepository sessionRepository17 = this.sessionRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass2.L$1 = set;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                        anonymousClass2.L$3 = persona2;
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                        anonymousClass2.L$5 = set2;
                        anonymousClass2.L$6 = str4;
                        anonymousClass2.L$7 = str5;
                        anonymousClass2.Z$0 = z;
                        anonymousClass2.label = 5;
                        deviceId = sessionRepository17.getDeviceId(anonymousClass2);
                        if (deviceId != coroutine_suspended) {
                            Set<String> set13 = set2;
                            str6 = str5;
                            objFirst = deviceId;
                            set3 = set;
                            list2 = list;
                            str7 = str4;
                            set4 = set13;
                            responseResource4 = (ResponseResource) objFirst;
                            if (responseResource4 instanceof ResponseResource.Success) {
                                if (responseResource4 instanceof ResponseResource.Error) {
                                    return responseResource4;
                                }
                                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                            SessionRepository sessionRepository18 = this.sessionRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$1 = set3;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                            anonymousClass2.L$3 = persona2;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            anonymousClass2.L$5 = set4;
                            anonymousClass2.L$6 = str7;
                            anonymousClass2.L$7 = str6;
                            anonymousClass2.L$8 = str8;
                            anonymousClass2.Z$0 = z;
                            anonymousClass2.label = 6;
                            token = sessionRepository18.getToken(anonymousClass2);
                            if (token != coroutine_suspended) {
                                list3 = arrayList2;
                                persona3 = persona2;
                                list4 = list2;
                                str9 = str3;
                                set5 = set4;
                                str10 = str7;
                                str11 = str6;
                                str12 = str8;
                                objFirst = token;
                                z2 = z;
                                responseResource5 = (ResponseResource) objFirst;
                                if (!(responseResource5 instanceof ResponseResource.Success)) {
                                    if (responseResource5 instanceof ResponseResource.Error) {
                                        return responseResource5;
                                    }
                                    if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                PersonaSurveyRepository personaSurveyRepository11 = this.personaSurveyRepository;
                                String id6 = persona3.getId();
                                String displayText6 = persona3.getDisplayText();
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                anonymousClass2.Z$0 = z2;
                                anonymousClass2.label = 7;
                                objFirst = personaSurveyRepository11.saveUserPersonaInfoToServer(str10, str12, str11, str13, id6, displayText6, set3, set5, anonymousClass2);
                                if (objFirst != coroutine_suspended) {
                                    str14 = str10;
                                    str15 = str13;
                                    set6 = set5;
                                    z3 = z2;
                                    list5 = list3;
                                    list6 = list4;
                                    str16 = str9;
                                    set7 = set3;
                                    persona4 = persona3;
                                    responseResource6 = (ResponseResource) objFirst;
                                    if (responseResource6 instanceof ResponseResource.Success) {
                                        engagementRepository = this.engagementRepository;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                        anonymousClass2.L$10 = responseResource6;
                                        anonymousClass2.Z$0 = z3;
                                        anonymousClass2.label = 8;
                                        if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                        }
                                    }
                                    return responseResource6;
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 3:
                z = anonymousClass2.Z$0;
                str = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFirst);
                responseResource2 = (ResponseResource) objFirst;
                if (responseResource2 instanceof ResponseResource.Success) {
                    if (responseResource2 instanceof ResponseResource.Error) {
                        return responseResource2;
                    }
                    if (Intrinsics.areEqual(responseResource2, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                set = (Set) ((ResponseResource.Success) responseResource2).getData();
                if (str == null) {
                    return new ResponseResource.Success(Unit.INSTANCE);
                }
                personaSurveyData = PersonaSurveyLocalDataStore.INSTANCE.getPersonaSurveyData();
                it = personaSurveyData.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                    } else {
                        next = null;
                    }
                    persona = (Persona) next;
                    if (persona == null) {
                        return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                    }
                    List<Role> roles7 = persona.getRoles();
                    arrayList = new ArrayList();
                    while (r5.hasNext()) {
                        if (set.contains(((Role) obj).getId())) {
                            arrayList.add(obj);
                        }
                    }
                    arrayList2 = arrayList;
                    ArrayList arrayList10 = arrayList2;
                    arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
                    it2 = arrayList10.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((Role) it2.next()).getDisplayText());
                    }
                    set2 = CollectionsKt.toSet(arrayList3);
                    customerId = this.sessionRepository.getCustomerId();
                    if (customerId instanceof ResponseResource.Success) {
                        if (customerId instanceof ResponseResource.Error) {
                            return customerId;
                        }
                        if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str2 = (String) ((ResponseResource.Success) customerId).getData();
                    SessionRepository sessionRepository19 = this.sessionRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass2.L$1 = set;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                    anonymousClass2.L$3 = persona;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    anonymousClass2.L$5 = set2;
                    anonymousClass2.L$6 = str2;
                    anonymousClass2.Z$0 = z;
                    anonymousClass2.label = 4;
                    gmailId = sessionRepository19.getGmailId(anonymousClass2);
                    if (gmailId != coroutine_suspended) {
                        str3 = str;
                        str4 = str2;
                        persona2 = persona;
                        list = personaSurveyData;
                        objFirst = gmailId;
                        responseResource3 = (ResponseResource) objFirst;
                        if (!(responseResource3 instanceof ResponseResource.Success)) {
                            if (responseResource3 instanceof ResponseResource.Error) {
                                return responseResource3;
                            }
                            if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                        SessionRepository sessionRepository110 = this.sessionRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass2.L$1 = set;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                        anonymousClass2.L$3 = persona2;
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                        anonymousClass2.L$5 = set2;
                        anonymousClass2.L$6 = str4;
                        anonymousClass2.L$7 = str5;
                        anonymousClass2.Z$0 = z;
                        anonymousClass2.label = 5;
                        deviceId = sessionRepository110.getDeviceId(anonymousClass2);
                        if (deviceId != coroutine_suspended) {
                            Set<String> set14 = set2;
                            str6 = str5;
                            objFirst = deviceId;
                            set3 = set;
                            list2 = list;
                            str7 = str4;
                            set4 = set14;
                            responseResource4 = (ResponseResource) objFirst;
                            if (responseResource4 instanceof ResponseResource.Success) {
                                if (responseResource4 instanceof ResponseResource.Error) {
                                    return responseResource4;
                                }
                                if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                            SessionRepository sessionRepository111 = this.sessionRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                            anonymousClass2.L$1 = set3;
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                            anonymousClass2.L$3 = persona2;
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                            anonymousClass2.L$5 = set4;
                            anonymousClass2.L$6 = str7;
                            anonymousClass2.L$7 = str6;
                            anonymousClass2.L$8 = str8;
                            anonymousClass2.Z$0 = z;
                            anonymousClass2.label = 6;
                            token = sessionRepository111.getToken(anonymousClass2);
                            if (token != coroutine_suspended) {
                                list3 = arrayList2;
                                persona3 = persona2;
                                list4 = list2;
                                str9 = str3;
                                set5 = set4;
                                str10 = str7;
                                str11 = str6;
                                str12 = str8;
                                objFirst = token;
                                z2 = z;
                                responseResource5 = (ResponseResource) objFirst;
                                if (!(responseResource5 instanceof ResponseResource.Success)) {
                                    if (responseResource5 instanceof ResponseResource.Error) {
                                        return responseResource5;
                                    }
                                    if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                        return ResponseResource.Loading.INSTANCE;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                                PersonaSurveyRepository personaSurveyRepository12 = this.personaSurveyRepository;
                                String id7 = persona3.getId();
                                String displayText7 = persona3.getDisplayText();
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                                anonymousClass2.Z$0 = z2;
                                anonymousClass2.label = 7;
                                objFirst = personaSurveyRepository12.saveUserPersonaInfoToServer(str10, str12, str11, str13, id7, displayText7, set3, set5, anonymousClass2);
                                if (objFirst != coroutine_suspended) {
                                    str14 = str10;
                                    str15 = str13;
                                    set6 = set5;
                                    z3 = z2;
                                    list5 = list3;
                                    list6 = list4;
                                    str16 = str9;
                                    set7 = set3;
                                    persona4 = persona3;
                                    responseResource6 = (ResponseResource) objFirst;
                                    if (responseResource6 instanceof ResponseResource.Success) {
                                        engagementRepository = this.engagementRepository;
                                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                        anonymousClass2.L$10 = responseResource6;
                                        anonymousClass2.Z$0 = z3;
                                        anonymousClass2.label = 8;
                                        if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                        }
                                    }
                                    return responseResource6;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                } while (!Intrinsics.areEqual(((Persona) next).getId(), str));
                persona = (Persona) next;
                if (persona == null) {
                    return new ResponseResource.Error(AppError.ResourceMissing.INSTANCE);
                }
                List<Role> roles8 = persona.getRoles();
                arrayList = new ArrayList();
                while (r5.hasNext()) {
                    if (set.contains(((Role) obj).getId())) {
                        arrayList.add(obj);
                    }
                }
                arrayList2 = arrayList;
                ArrayList arrayList11 = arrayList2;
                arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList11, 10));
                it2 = arrayList11.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(((Role) it2.next()).getDisplayText());
                }
                set2 = CollectionsKt.toSet(arrayList3);
                customerId = this.sessionRepository.getCustomerId();
                if (customerId instanceof ResponseResource.Success) {
                    if (customerId instanceof ResponseResource.Error) {
                        return customerId;
                    }
                    if (Intrinsics.areEqual(customerId, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str2 = (String) ((ResponseResource.Success) customerId).getData();
                SessionRepository sessionRepository112 = this.sessionRepository;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$1 = set;
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(personaSurveyData);
                anonymousClass2.L$3 = persona;
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                anonymousClass2.L$5 = set2;
                anonymousClass2.L$6 = str2;
                anonymousClass2.Z$0 = z;
                anonymousClass2.label = 4;
                gmailId = sessionRepository112.getGmailId(anonymousClass2);
                if (gmailId != coroutine_suspended) {
                    str3 = str;
                    str4 = str2;
                    persona2 = persona;
                    list = personaSurveyData;
                    objFirst = gmailId;
                    responseResource3 = (ResponseResource) objFirst;
                    if (!(responseResource3 instanceof ResponseResource.Success)) {
                        if (responseResource3 instanceof ResponseResource.Error) {
                            return responseResource3;
                        }
                        if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                    SessionRepository sessionRepository113 = this.sessionRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass2.L$1 = set;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                    anonymousClass2.L$3 = persona2;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    anonymousClass2.L$5 = set2;
                    anonymousClass2.L$6 = str4;
                    anonymousClass2.L$7 = str5;
                    anonymousClass2.Z$0 = z;
                    anonymousClass2.label = 5;
                    deviceId = sessionRepository113.getDeviceId(anonymousClass2);
                    if (deviceId != coroutine_suspended) {
                        Set<String> set15 = set2;
                        str6 = str5;
                        objFirst = deviceId;
                        set3 = set;
                        list2 = list;
                        str7 = str4;
                        set4 = set15;
                        responseResource4 = (ResponseResource) objFirst;
                        if (responseResource4 instanceof ResponseResource.Success) {
                            if (responseResource4 instanceof ResponseResource.Error) {
                                return responseResource4;
                            }
                            if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                        SessionRepository sessionRepository114 = this.sessionRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                        anonymousClass2.L$1 = set3;
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                        anonymousClass2.L$3 = persona2;
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                        anonymousClass2.L$5 = set4;
                        anonymousClass2.L$6 = str7;
                        anonymousClass2.L$7 = str6;
                        anonymousClass2.L$8 = str8;
                        anonymousClass2.Z$0 = z;
                        anonymousClass2.label = 6;
                        token = sessionRepository114.getToken(anonymousClass2);
                        if (token != coroutine_suspended) {
                            list3 = arrayList2;
                            persona3 = persona2;
                            list4 = list2;
                            str9 = str3;
                            set5 = set4;
                            str10 = str7;
                            str11 = str6;
                            str12 = str8;
                            objFirst = token;
                            z2 = z;
                            responseResource5 = (ResponseResource) objFirst;
                            if (!(responseResource5 instanceof ResponseResource.Success)) {
                                if (responseResource5 instanceof ResponseResource.Error) {
                                    return responseResource5;
                                }
                                if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                    return ResponseResource.Loading.INSTANCE;
                                }
                                throw new NoWhenBranchMatchedException();
                            }
                            str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                            PersonaSurveyRepository personaSurveyRepository13 = this.personaSurveyRepository;
                            String id8 = persona3.getId();
                            String displayText8 = persona3.getDisplayText();
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                            anonymousClass2.Z$0 = z2;
                            anonymousClass2.label = 7;
                            objFirst = personaSurveyRepository13.saveUserPersonaInfoToServer(str10, str12, str11, str13, id8, displayText8, set3, set5, anonymousClass2);
                            if (objFirst != coroutine_suspended) {
                                str14 = str10;
                                str15 = str13;
                                set6 = set5;
                                z3 = z2;
                                list5 = list3;
                                list6 = list4;
                                str16 = str9;
                                set7 = set3;
                                persona4 = persona3;
                                responseResource6 = (ResponseResource) objFirst;
                                if (responseResource6 instanceof ResponseResource.Success) {
                                    engagementRepository = this.engagementRepository;
                                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                    anonymousClass2.L$10 = responseResource6;
                                    anonymousClass2.Z$0 = z3;
                                    anonymousClass2.label = 8;
                                    if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                    }
                                }
                                return responseResource6;
                            }
                        }
                    }
                }
                return coroutine_suspended;
            case 4:
                z = anonymousClass2.Z$0;
                str4 = (String) anonymousClass2.L$6;
                set2 = (Set) anonymousClass2.L$5;
                List list7 = (List) anonymousClass2.L$4;
                Persona persona5 = (Persona) anonymousClass2.L$3;
                List<Persona> list8 = (List) anonymousClass2.L$2;
                set = (Set) anonymousClass2.L$1;
                String str17 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFirst);
                arrayList2 = list7;
                list = list8;
                persona2 = persona5;
                str3 = str17;
                responseResource3 = (ResponseResource) objFirst;
                if (!(responseResource3 instanceof ResponseResource.Success)) {
                    if (responseResource3 instanceof ResponseResource.Error) {
                        return responseResource3;
                    }
                    if (Intrinsics.areEqual(responseResource3, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str5 = (String) ((ResponseResource.Success) responseResource3).getData();
                SessionRepository sessionRepository115 = this.sessionRepository;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                anonymousClass2.L$1 = set;
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass2.L$3 = persona2;
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                anonymousClass2.L$5 = set2;
                anonymousClass2.L$6 = str4;
                anonymousClass2.L$7 = str5;
                anonymousClass2.Z$0 = z;
                anonymousClass2.label = 5;
                deviceId = sessionRepository115.getDeviceId(anonymousClass2);
                if (deviceId != coroutine_suspended) {
                    Set<String> set16 = set2;
                    str6 = str5;
                    objFirst = deviceId;
                    set3 = set;
                    list2 = list;
                    str7 = str4;
                    set4 = set16;
                    responseResource4 = (ResponseResource) objFirst;
                    if (responseResource4 instanceof ResponseResource.Success) {
                        if (responseResource4 instanceof ResponseResource.Error) {
                            return responseResource4;
                        }
                        if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                    SessionRepository sessionRepository116 = this.sessionRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                    anonymousClass2.L$1 = set3;
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                    anonymousClass2.L$3 = persona2;
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                    anonymousClass2.L$5 = set4;
                    anonymousClass2.L$6 = str7;
                    anonymousClass2.L$7 = str6;
                    anonymousClass2.L$8 = str8;
                    anonymousClass2.Z$0 = z;
                    anonymousClass2.label = 6;
                    token = sessionRepository116.getToken(anonymousClass2);
                    if (token != coroutine_suspended) {
                        list3 = arrayList2;
                        persona3 = persona2;
                        list4 = list2;
                        str9 = str3;
                        set5 = set4;
                        str10 = str7;
                        str11 = str6;
                        str12 = str8;
                        objFirst = token;
                        z2 = z;
                        responseResource5 = (ResponseResource) objFirst;
                        if (!(responseResource5 instanceof ResponseResource.Success)) {
                            if (responseResource5 instanceof ResponseResource.Error) {
                                return responseResource5;
                            }
                            if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                                return ResponseResource.Loading.INSTANCE;
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                        PersonaSurveyRepository personaSurveyRepository14 = this.personaSurveyRepository;
                        String id9 = persona3.getId();
                        String displayText9 = persona3.getDisplayText();
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                        anonymousClass2.Z$0 = z2;
                        anonymousClass2.label = 7;
                        objFirst = personaSurveyRepository14.saveUserPersonaInfoToServer(str10, str12, str11, str13, id9, displayText9, set3, set5, anonymousClass2);
                        if (objFirst != coroutine_suspended) {
                            str14 = str10;
                            str15 = str13;
                            set6 = set5;
                            z3 = z2;
                            list5 = list3;
                            list6 = list4;
                            str16 = str9;
                            set7 = set3;
                            persona4 = persona3;
                            responseResource6 = (ResponseResource) objFirst;
                            if (responseResource6 instanceof ResponseResource.Success) {
                                engagementRepository = this.engagementRepository;
                                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                                anonymousClass2.L$10 = responseResource6;
                                anonymousClass2.Z$0 = z3;
                                anonymousClass2.label = 8;
                                if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                                }
                            }
                            return responseResource6;
                        }
                    }
                }
                return coroutine_suspended;
            case 5:
                z = anonymousClass2.Z$0;
                String str18 = (String) anonymousClass2.L$7;
                String str19 = (String) anonymousClass2.L$6;
                Set<String> set17 = (Set) anonymousClass2.L$5;
                arrayList2 = (List) anonymousClass2.L$4;
                persona2 = (Persona) anonymousClass2.L$3;
                list2 = (List) anonymousClass2.L$2;
                set3 = (Set) anonymousClass2.L$1;
                str3 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFirst);
                str6 = str18;
                set4 = set17;
                str7 = str19;
                responseResource4 = (ResponseResource) objFirst;
                if (responseResource4 instanceof ResponseResource.Success) {
                    if (responseResource4 instanceof ResponseResource.Error) {
                        return responseResource4;
                    }
                    if (Intrinsics.areEqual(responseResource4, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str8 = (String) ((ResponseResource.Success) responseResource4).getData();
                SessionRepository sessionRepository117 = this.sessionRepository;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                anonymousClass2.L$1 = set3;
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list2);
                anonymousClass2.L$3 = persona2;
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(arrayList2);
                anonymousClass2.L$5 = set4;
                anonymousClass2.L$6 = str7;
                anonymousClass2.L$7 = str6;
                anonymousClass2.L$8 = str8;
                anonymousClass2.Z$0 = z;
                anonymousClass2.label = 6;
                token = sessionRepository117.getToken(anonymousClass2);
                if (token != coroutine_suspended) {
                    list3 = arrayList2;
                    persona3 = persona2;
                    list4 = list2;
                    str9 = str3;
                    set5 = set4;
                    str10 = str7;
                    str11 = str6;
                    str12 = str8;
                    objFirst = token;
                    z2 = z;
                    responseResource5 = (ResponseResource) objFirst;
                    if (!(responseResource5 instanceof ResponseResource.Success)) {
                        if (responseResource5 instanceof ResponseResource.Error) {
                            return responseResource5;
                        }
                        if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                            return ResponseResource.Loading.INSTANCE;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                    PersonaSurveyRepository personaSurveyRepository15 = this.personaSurveyRepository;
                    String id10 = persona3.getId();
                    String displayText10 = persona3.getDisplayText();
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                    anonymousClass2.Z$0 = z2;
                    anonymousClass2.label = 7;
                    objFirst = personaSurveyRepository15.saveUserPersonaInfoToServer(str10, str12, str11, str13, id10, displayText10, set3, set5, anonymousClass2);
                    if (objFirst != coroutine_suspended) {
                        str14 = str10;
                        str15 = str13;
                        set6 = set5;
                        z3 = z2;
                        list5 = list3;
                        list6 = list4;
                        str16 = str9;
                        set7 = set3;
                        persona4 = persona3;
                        responseResource6 = (ResponseResource) objFirst;
                        if (responseResource6 instanceof ResponseResource.Success) {
                            engagementRepository = this.engagementRepository;
                            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                            anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                            anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                            anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                            anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                            anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                            anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                            anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                            anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                            anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                            anonymousClass2.L$10 = responseResource6;
                            anonymousClass2.Z$0 = z3;
                            anonymousClass2.label = 8;
                            if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                            }
                        }
                        return responseResource6;
                    }
                }
                return coroutine_suspended;
            case 6:
                z = anonymousClass2.Z$0;
                String str20 = (String) anonymousClass2.L$8;
                String str21 = (String) anonymousClass2.L$7;
                String str22 = (String) anonymousClass2.L$6;
                Set<String> set18 = (Set) anonymousClass2.L$5;
                List list9 = (List) anonymousClass2.L$4;
                Persona persona6 = (Persona) anonymousClass2.L$3;
                List<Persona> list10 = (List) anonymousClass2.L$2;
                Set<String> set19 = (Set) anonymousClass2.L$1;
                String str23 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFirst);
                str12 = str20;
                str10 = str22;
                str11 = str21;
                list3 = list9;
                persona3 = persona6;
                list4 = list10;
                set3 = set19;
                str9 = str23;
                set5 = set18;
                z2 = z;
                responseResource5 = (ResponseResource) objFirst;
                if (!(responseResource5 instanceof ResponseResource.Success)) {
                    if (responseResource5 instanceof ResponseResource.Error) {
                        return responseResource5;
                    }
                    if (Intrinsics.areEqual(responseResource5, ResponseResource.Loading.INSTANCE)) {
                        return ResponseResource.Loading.INSTANCE;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                str13 = (String) ((ResponseResource.Success) responseResource5).getData();
                PersonaSurveyRepository personaSurveyRepository16 = this.personaSurveyRepository;
                String id11 = persona3.getId();
                String displayText11 = persona3.getDisplayText();
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str9);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set3);
                anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list4);
                anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona3);
                anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list3);
                anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set5);
                anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str10);
                anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str13);
                anonymousClass2.Z$0 = z2;
                anonymousClass2.label = 7;
                objFirst = personaSurveyRepository16.saveUserPersonaInfoToServer(str10, str12, str11, str13, id11, displayText11, set3, set5, anonymousClass2);
                if (objFirst != coroutine_suspended) {
                    str14 = str10;
                    str15 = str13;
                    set6 = set5;
                    z3 = z2;
                    list5 = list3;
                    list6 = list4;
                    str16 = str9;
                    set7 = set3;
                    persona4 = persona3;
                    responseResource6 = (ResponseResource) objFirst;
                    if (responseResource6 instanceof ResponseResource.Success) {
                        engagementRepository = this.engagementRepository;
                        anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                        anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                        anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                        anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                        anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                        anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                        anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                        anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                        anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                        anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                        anonymousClass2.L$10 = responseResource6;
                        anonymousClass2.Z$0 = z3;
                        anonymousClass2.label = 8;
                        if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                        }
                    }
                    return responseResource6;
                }
                return coroutine_suspended;
            case 7:
                z3 = anonymousClass2.Z$0;
                str15 = (String) anonymousClass2.L$9;
                str12 = (String) anonymousClass2.L$8;
                str11 = (String) anonymousClass2.L$7;
                str14 = (String) anonymousClass2.L$6;
                set6 = (Set) anonymousClass2.L$5;
                list5 = (List) anonymousClass2.L$4;
                persona4 = (Persona) anonymousClass2.L$3;
                list6 = (List) anonymousClass2.L$2;
                set7 = (Set) anonymousClass2.L$1;
                str16 = (String) anonymousClass2.L$0;
                ResultKt.throwOnFailure(objFirst);
                responseResource6 = (ResponseResource) objFirst;
                if (responseResource6 instanceof ResponseResource.Success) {
                    engagementRepository = this.engagementRepository;
                    anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str16);
                    anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(set7);
                    anonymousClass2.L$2 = SpillingKt.nullOutSpilledVariable(list6);
                    anonymousClass2.L$3 = SpillingKt.nullOutSpilledVariable(persona4);
                    anonymousClass2.L$4 = SpillingKt.nullOutSpilledVariable(list5);
                    anonymousClass2.L$5 = SpillingKt.nullOutSpilledVariable(set6);
                    anonymousClass2.L$6 = SpillingKt.nullOutSpilledVariable(str14);
                    anonymousClass2.L$7 = SpillingKt.nullOutSpilledVariable(str11);
                    anonymousClass2.L$8 = SpillingKt.nullOutSpilledVariable(str12);
                    anonymousClass2.L$9 = SpillingKt.nullOutSpilledVariable(str15);
                    anonymousClass2.L$10 = responseResource6;
                    anonymousClass2.Z$0 = z3;
                    anonymousClass2.label = 8;
                    if (engagementRepository.setPersonaSurveySubmitted(true, anonymousClass2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return responseResource6;
            case 8:
                boolean z4 = anonymousClass2.Z$0;
                ResponseResource responseResource7 = (ResponseResource) anonymousClass2.L$10;
                ResultKt.throwOnFailure(objFirst);
                return responseResource7;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
