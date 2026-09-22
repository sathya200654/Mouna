package com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.user;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: User.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J/\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/user/User;", "", "id", "", "personaId", "roleIds", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getPersonaId", "getRoleIds", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class User {
    public static final int $stable = 8;
    private final String id;
    private final String personaId;
    private final List<String> roleIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ User copy$default(User user, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = user.id;
        }
        if ((i & 2) != 0) {
            str2 = user.personaId;
        }
        if ((i & 4) != 0) {
            list = user.roleIds;
        }
        return user.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPersonaId() {
        return this.personaId;
    }

    public final List<String> component3() {
        return this.roleIds;
    }

    public final User copy(String id, String personaId, List<String> roleIds) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(personaId, "personaId");
        return new User(id, personaId, roleIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return Intrinsics.areEqual(this.id, user.id) && Intrinsics.areEqual(this.personaId, user.personaId) && Intrinsics.areEqual(this.roleIds, user.roleIds);
    }

    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.personaId.hashCode()) * 31;
        List<String> list = this.roleIds;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "User(id=" + this.id + ", personaId=" + this.personaId + ", roleIds=" + this.roleIds + ")";
    }

    public User(String str, String str2, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "personaId");
        this.id = str;
        this.personaId = str2;
        this.roleIds = list;
    }

    public /* synthetic */ User(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : list);
    }

    public final String getId() {
        return this.id;
    }

    public final String getPersonaId() {
        return this.personaId;
    }

    public final List<String> getRoleIds() {
        return this.roleIds;
    }
}
