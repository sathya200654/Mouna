package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeDomain.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeDomain;", "", "id", "", "domainName", "isSelected", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getDomainName", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SignPracticeDomain {
    public static final int $stable = 0;
    private final String domainName;
    private final String id;
    private final boolean isSelected;

    public static /* synthetic */ SignPracticeDomain copy$default(SignPracticeDomain signPracticeDomain, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signPracticeDomain.id;
        }
        if ((i & 2) != 0) {
            str2 = signPracticeDomain.domainName;
        }
        if ((i & 4) != 0) {
            z = signPracticeDomain.isSelected;
        }
        return signPracticeDomain.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDomainName() {
        return this.domainName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final SignPracticeDomain copy(String id, String domainName, boolean isSelected) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        return new SignPracticeDomain(id, domainName, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPracticeDomain)) {
            return false;
        }
        SignPracticeDomain signPracticeDomain = (SignPracticeDomain) other;
        return Intrinsics.areEqual(this.id, signPracticeDomain.id) && Intrinsics.areEqual(this.domainName, signPracticeDomain.domainName) && this.isSelected == signPracticeDomain.isSelected;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.domainName.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "SignPracticeDomain(id=" + this.id + ", domainName=" + this.domainName + ", isSelected=" + this.isSelected + ")";
    }

    public SignPracticeDomain(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "domainName");
        this.id = str;
        this.domainName = str2;
        this.isSelected = z;
    }

    public /* synthetic */ SignPracticeDomain(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDomainName() {
        return this.domainName;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
