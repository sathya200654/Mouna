package com.deepvisiontech.letstalksigntranscriptionapp.current.personasurvey.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Role.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/personasurvey/domain/model/Role;", "", "id", "", "displayText", "isSelected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getDisplayText", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Role {
    public static final int $stable = 0;
    private final String displayText;
    private final String id;
    private final boolean isSelected;

    public static /* synthetic */ Role copy$default(Role role, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = role.id;
        }
        if ((i & 2) != 0) {
            str2 = role.displayText;
        }
        if ((i & 4) != 0) {
            z = role.isSelected;
        }
        return role.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayText() {
        return this.displayText;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final Role copy(String id, String displayText, boolean isSelected) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        return new Role(id, displayText, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Role)) {
            return false;
        }
        Role role = (Role) other;
        return Intrinsics.areEqual(this.id, role.id) && Intrinsics.areEqual(this.displayText, role.displayText) && this.isSelected == role.isSelected;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.displayText.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "Role(id=" + this.id + ", displayText=" + this.displayText + ", isSelected=" + this.isSelected + ")";
    }

    public Role(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "displayText");
        this.id = str;
        this.displayText = str2;
        this.isSelected = z;
    }

    public /* synthetic */ Role(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
