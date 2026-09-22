package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersonaSurveySubmissionRequest.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003Je\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006'"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/data/remote/dto/PersonaSurveySubmissionRequest;", "", "customerId", "", "deviceId", "gmailId", "token", "personaId", "personaName", "roleIds", "", "roles", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "getCustomerId", "()Ljava/lang/String;", "getDeviceId", "getGmailId", "getToken", "getPersonaId", "getPersonaName", "getRoleIds", "()Ljava/util/Set;", "getRoles", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class PersonaSurveySubmissionRequest {
    public static final int $stable = 8;

    @SerializedName("customer_id")
    private final String customerId;

    @SerializedName("device_id")
    private final String deviceId;

    @SerializedName("gmail_id")
    private final String gmailId;

    @SerializedName("persona_id")
    private final String personaId;

    @SerializedName("persona_name")
    private final String personaName;

    @SerializedName("role_ids")
    private final Set<String> roleIds;

    @SerializedName("roles")
    private final Set<String> roles;

    @SerializedName("token")
    private final String token;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PersonaSurveySubmissionRequest copy$default(PersonaSurveySubmissionRequest personaSurveySubmissionRequest, String str, String str2, String str3, String str4, String str5, String str6, Set set, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = personaSurveySubmissionRequest.customerId;
        }
        if ((i & 2) != 0) {
            str2 = personaSurveySubmissionRequest.deviceId;
        }
        if ((i & 4) != 0) {
            str3 = personaSurveySubmissionRequest.gmailId;
        }
        if ((i & 8) != 0) {
            str4 = personaSurveySubmissionRequest.token;
        }
        if ((i & 16) != 0) {
            str5 = personaSurveySubmissionRequest.personaId;
        }
        if ((i & 32) != 0) {
            str6 = personaSurveySubmissionRequest.personaName;
        }
        if ((i & 64) != 0) {
            set = personaSurveySubmissionRequest.roleIds;
        }
        if ((i & 128) != 0) {
            set2 = personaSurveySubmissionRequest.roles;
        }
        Set set3 = set;
        Set set4 = set2;
        String str7 = str5;
        String str8 = str6;
        return personaSurveySubmissionRequest.copy(str, str2, str3, str4, str7, str8, set3, set4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCustomerId() {
        return this.customerId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGmailId() {
        return this.gmailId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPersonaId() {
        return this.personaId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPersonaName() {
        return this.personaName;
    }

    public final Set<String> component7() {
        return this.roleIds;
    }

    public final Set<String> component8() {
        return this.roles;
    }

    public final PersonaSurveySubmissionRequest copy(String customerId, String deviceId, String gmailId, String token, String personaId, String personaName, Set<String> roleIds, Set<String> roles) {
        Intrinsics.checkNotNullParameter(customerId, "customerId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(gmailId, "gmailId");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(personaId, "personaId");
        Intrinsics.checkNotNullParameter(personaName, "personaName");
        Intrinsics.checkNotNullParameter(roleIds, "roleIds");
        Intrinsics.checkNotNullParameter(roles, "roles");
        return new PersonaSurveySubmissionRequest(customerId, deviceId, gmailId, token, personaId, personaName, roleIds, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonaSurveySubmissionRequest)) {
            return false;
        }
        PersonaSurveySubmissionRequest personaSurveySubmissionRequest = (PersonaSurveySubmissionRequest) other;
        return Intrinsics.areEqual(this.customerId, personaSurveySubmissionRequest.customerId) && Intrinsics.areEqual(this.deviceId, personaSurveySubmissionRequest.deviceId) && Intrinsics.areEqual(this.gmailId, personaSurveySubmissionRequest.gmailId) && Intrinsics.areEqual(this.token, personaSurveySubmissionRequest.token) && Intrinsics.areEqual(this.personaId, personaSurveySubmissionRequest.personaId) && Intrinsics.areEqual(this.personaName, personaSurveySubmissionRequest.personaName) && Intrinsics.areEqual(this.roleIds, personaSurveySubmissionRequest.roleIds) && Intrinsics.areEqual(this.roles, personaSurveySubmissionRequest.roles);
    }

    public int hashCode() {
        return (((((((((((((this.customerId.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.gmailId.hashCode()) * 31) + this.token.hashCode()) * 31) + this.personaId.hashCode()) * 31) + this.personaName.hashCode()) * 31) + this.roleIds.hashCode()) * 31) + this.roles.hashCode();
    }

    public String toString() {
        return "PersonaSurveySubmissionRequest(customerId=" + this.customerId + ", deviceId=" + this.deviceId + ", gmailId=" + this.gmailId + ", token=" + this.token + ", personaId=" + this.personaId + ", personaName=" + this.personaName + ", roleIds=" + this.roleIds + ", roles=" + this.roles + ")";
    }

    public PersonaSurveySubmissionRequest(String str, String str2, String str3, String str4, String str5, String str6, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        Intrinsics.checkNotNullParameter(str3, "gmailId");
        Intrinsics.checkNotNullParameter(str4, "token");
        Intrinsics.checkNotNullParameter(str5, "personaId");
        Intrinsics.checkNotNullParameter(str6, "personaName");
        Intrinsics.checkNotNullParameter(set, "roleIds");
        Intrinsics.checkNotNullParameter(set2, "roles");
        this.customerId = str;
        this.deviceId = str2;
        this.gmailId = str3;
        this.token = str4;
        this.personaId = str5;
        this.personaName = str6;
        this.roleIds = set;
        this.roles = set2;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getGmailId() {
        return this.gmailId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getPersonaId() {
        return this.personaId;
    }

    public final String getPersonaName() {
        return this.personaName;
    }

    public final Set<String> getRoleIds() {
        return this.roleIds;
    }

    public final Set<String> getRoles() {
        return this.roles;
    }
}
