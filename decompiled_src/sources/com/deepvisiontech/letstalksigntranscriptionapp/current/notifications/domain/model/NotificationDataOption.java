package com.deepvisiontech.letstalksigntranscriptionapp.current.notifications.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationDataOption.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/notifications/domain/model/NotificationDataOption;", "", "id", "", "name", "", "isSelected", "", "<init>", "(ILjava/lang/String;Z)V", "getId", "()I", "getName", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class NotificationDataOption {
    public static final int $stable = 0;
    private final int id;
    private final boolean isSelected;
    private final String name;

    public static /* synthetic */ NotificationDataOption copy$default(NotificationDataOption notificationDataOption, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = notificationDataOption.id;
        }
        if ((i2 & 2) != 0) {
            str = notificationDataOption.name;
        }
        if ((i2 & 4) != 0) {
            z = notificationDataOption.isSelected;
        }
        return notificationDataOption.copy(i, str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final NotificationDataOption copy(int id, String name, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new NotificationDataOption(id, name, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationDataOption)) {
            return false;
        }
        NotificationDataOption notificationDataOption = (NotificationDataOption) other;
        return this.id == notificationDataOption.id && Intrinsics.areEqual(this.name, notificationDataOption.name) && this.isSelected == notificationDataOption.isSelected;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "NotificationDataOption(id=" + this.id + ", name=" + this.name + ", isSelected=" + this.isSelected + ")";
    }

    public NotificationDataOption(int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.id = i;
        this.name = str;
        this.isSelected = z;
    }

    public /* synthetic */ NotificationDataOption(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
