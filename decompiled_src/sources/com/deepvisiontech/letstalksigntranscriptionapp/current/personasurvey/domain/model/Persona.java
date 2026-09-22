package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Persona.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Persona;", "", "id", "", "displayText", "roles", "", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Role;", "isSelected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getId", "()Ljava/lang/String;", "getDisplayText", "getRoles", "()Ljava/util/List;", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Persona {
    public static final int $stable = 8;
    private final String displayText;
    private final String id;
    private final boolean isSelected;
    private final List<Role> roles;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Persona copy$default(Persona persona, String str, String str2, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = persona.id;
        }
        if ((i & 2) != 0) {
            str2 = persona.displayText;
        }
        if ((i & 4) != 0) {
            list = persona.roles;
        }
        if ((i & 8) != 0) {
            z = persona.isSelected;
        }
        return persona.copy(str, str2, list, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayText() {
        return this.displayText;
    }

    public final List<Role> component3() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final Persona copy(String id, String displayText, List<Role> roles, boolean isSelected) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(roles, "roles");
        return new Persona(id, displayText, roles, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) other;
        return Intrinsics.areEqual(this.id, persona.id) && Intrinsics.areEqual(this.displayText, persona.displayText) && Intrinsics.areEqual(this.roles, persona.roles) && this.isSelected == persona.isSelected;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.displayText.hashCode()) * 31) + this.roles.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "Persona(id=" + this.id + ", displayText=" + this.displayText + ", roles=" + this.roles + ", isSelected=" + this.isSelected + ")";
    }

    public Persona(String str, String str2, List<Role> list, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "displayText");
        Intrinsics.checkNotNullParameter(list, "roles");
        this.id = str;
        this.displayText = str2;
        this.roles = list;
        this.isSelected = z;
    }

    public /* synthetic */ Persona(String str, String str2, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, (i & 8) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final List<Role> getRoles() {
        return this.roles;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
