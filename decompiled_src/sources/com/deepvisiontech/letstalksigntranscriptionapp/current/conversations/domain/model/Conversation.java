package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Conversation.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/Conversation;", "", "id", "", "conversationName", "", "isSelected", "", "timeCreated", "<init>", "(JLjava/lang/String;ZJ)V", "getId", "()J", "getConversationName", "()Ljava/lang/String;", "()Z", "getTimeCreated", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class Conversation {
    public static final int $stable = 0;
    private final String conversationName;
    private final long id;
    private final boolean isSelected;
    private final long timeCreated;

    public static /* synthetic */ Conversation copy$default(Conversation conversation, long j, String str, boolean z, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = conversation.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = conversation.conversationName;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            z = conversation.isSelected;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j2 = conversation.timeCreated;
        }
        return conversation.copy(j3, str2, z2, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getConversationName() {
        return this.conversationName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimeCreated() {
        return this.timeCreated;
    }

    public final Conversation copy(long id, String conversationName, boolean isSelected, long timeCreated) {
        Intrinsics.checkNotNullParameter(conversationName, "conversationName");
        return new Conversation(id, conversationName, isSelected, timeCreated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Conversation)) {
            return false;
        }
        Conversation conversation = (Conversation) other;
        return this.id == conversation.id && Intrinsics.areEqual(this.conversationName, conversation.conversationName) && this.isSelected == conversation.isSelected && this.timeCreated == conversation.timeCreated;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.conversationName.hashCode()) * 31) + Boolean.hashCode(this.isSelected)) * 31) + Long.hashCode(this.timeCreated);
    }

    public String toString() {
        return "Conversation(id=" + this.id + ", conversationName=" + this.conversationName + ", isSelected=" + this.isSelected + ", timeCreated=" + this.timeCreated + ")";
    }

    public Conversation(long j, String str, boolean z, long j2) {
        Intrinsics.checkNotNullParameter(str, "conversationName");
        this.id = j;
        this.conversationName = str;
        this.isSelected = z;
        this.timeCreated = j2;
    }

    public /* synthetic */ Conversation(long j, String str, boolean z, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, (i & 4) != 0 ? false : z, j2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getConversationName() {
        return this.conversationName;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }
}
