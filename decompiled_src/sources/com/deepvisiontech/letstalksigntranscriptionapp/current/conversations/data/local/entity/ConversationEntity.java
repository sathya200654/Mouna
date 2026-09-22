package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationEntity;", "", "id", "", "conversationName", "", "timeCreated", "<init>", "(JLjava/lang/String;J)V", "getId", "()J", "getConversationName", "()Ljava/lang/String;", "getTimeCreated", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationEntity {
    public static final int $stable = 0;
    private final String conversationName;
    private final long id;
    private final long timeCreated;

    public static /* synthetic */ ConversationEntity copy$default(ConversationEntity conversationEntity, long j, String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = conversationEntity.id;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            str = conversationEntity.conversationName;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j2 = conversationEntity.timeCreated;
        }
        return conversationEntity.copy(j3, str2, j2);
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
    public final long getTimeCreated() {
        return this.timeCreated;
    }

    public final ConversationEntity copy(long id, String conversationName, long timeCreated) {
        Intrinsics.checkNotNullParameter(conversationName, "conversationName");
        return new ConversationEntity(id, conversationName, timeCreated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationEntity)) {
            return false;
        }
        ConversationEntity conversationEntity = (ConversationEntity) other;
        return this.id == conversationEntity.id && Intrinsics.areEqual(this.conversationName, conversationEntity.conversationName) && this.timeCreated == conversationEntity.timeCreated;
    }

    public int hashCode() {
        return (((Long.hashCode(this.id) * 31) + this.conversationName.hashCode()) * 31) + Long.hashCode(this.timeCreated);
    }

    public String toString() {
        return "ConversationEntity(id=" + this.id + ", conversationName=" + this.conversationName + ", timeCreated=" + this.timeCreated + ")";
    }

    public ConversationEntity(long j, String str, long j2) {
        Intrinsics.checkNotNullParameter(str, "conversationName");
        this.id = j;
        this.conversationName = str;
        this.timeCreated = j2;
    }

    public /* synthetic */ ConversationEntity(long j, String str, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, j2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getConversationName() {
        return this.conversationName;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }
}
