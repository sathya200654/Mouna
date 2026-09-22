package com.deepvisiontech.letstalksigntranscriptionapp.current.data.local.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001dJr\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u000bHÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/data/local/entity/MessageEntity;", "", "messageId", "", "sessionIdFk", "", "userName", "messageText", "messageTransText", "messageTimeStamp", "sequenceId", "", "typeMode", "interpreted", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)V", "getMessageId", "()J", "getSessionIdFk", "()Ljava/lang/String;", "getUserName", "getMessageText", "getMessageTransText", "getMessageTimeStamp", "getSequenceId", "()I", "getTypeMode", "getInterpreted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Boolean;)Lcom/deepvisiontech/letstalksigntranscriptionapp/current/data/local/entity/MessageEntity;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MessageEntity {
    public static final int $stable = 0;
    private final Boolean interpreted;
    private final long messageId;
    private final String messageText;
    private final String messageTimeStamp;
    private final String messageTransText;
    private final int sequenceId;
    private final String sessionIdFk;
    private final String typeMode;
    private final String userName;

    public static /* synthetic */ MessageEntity copy$default(MessageEntity messageEntity, long j, String str, String str2, String str3, String str4, String str5, int i, String str6, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = messageEntity.messageId;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = messageEntity.sessionIdFk;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = messageEntity.userName;
        }
        return messageEntity.copy(j2, str7, str2, (i2 & 8) != 0 ? messageEntity.messageText : str3, (i2 & 16) != 0 ? messageEntity.messageTransText : str4, (i2 & 32) != 0 ? messageEntity.messageTimeStamp : str5, (i2 & 64) != 0 ? messageEntity.sequenceId : i, (i2 & 128) != 0 ? messageEntity.typeMode : str6, (i2 & 256) != 0 ? messageEntity.interpreted : bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSessionIdFk() {
        return this.sessionIdFk;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMessageText() {
        return this.messageText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessageTransText() {
        return this.messageTransText;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMessageTimeStamp() {
        return this.messageTimeStamp;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSequenceId() {
        return this.sequenceId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTypeMode() {
        return this.typeMode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Boolean getInterpreted() {
        return this.interpreted;
    }

    public final MessageEntity copy(long messageId, String sessionIdFk, String userName, String messageText, String messageTransText, String messageTimeStamp, int sequenceId, String typeMode, Boolean interpreted) {
        Intrinsics.checkNotNullParameter(sessionIdFk, "sessionIdFk");
        Intrinsics.checkNotNullParameter(messageText, "messageText");
        return new MessageEntity(messageId, sessionIdFk, userName, messageText, messageTransText, messageTimeStamp, sequenceId, typeMode, interpreted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageEntity)) {
            return false;
        }
        MessageEntity messageEntity = (MessageEntity) other;
        return this.messageId == messageEntity.messageId && Intrinsics.areEqual(this.sessionIdFk, messageEntity.sessionIdFk) && Intrinsics.areEqual(this.userName, messageEntity.userName) && Intrinsics.areEqual(this.messageText, messageEntity.messageText) && Intrinsics.areEqual(this.messageTransText, messageEntity.messageTransText) && Intrinsics.areEqual(this.messageTimeStamp, messageEntity.messageTimeStamp) && this.sequenceId == messageEntity.sequenceId && Intrinsics.areEqual(this.typeMode, messageEntity.typeMode) && Intrinsics.areEqual(this.interpreted, messageEntity.interpreted);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.messageId) * 31) + this.sessionIdFk.hashCode()) * 31;
        String str = this.userName;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.messageText.hashCode()) * 31;
        String str2 = this.messageTransText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.messageTimeStamp;
        int iHashCode4 = (((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Integer.hashCode(this.sequenceId)) * 31;
        String str4 = this.typeMode;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.interpreted;
        return iHashCode5 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "MessageEntity(messageId=" + this.messageId + ", sessionIdFk=" + this.sessionIdFk + ", userName=" + this.userName + ", messageText=" + this.messageText + ", messageTransText=" + this.messageTransText + ", messageTimeStamp=" + this.messageTimeStamp + ", sequenceId=" + this.sequenceId + ", typeMode=" + this.typeMode + ", interpreted=" + this.interpreted + ")";
    }

    public MessageEntity(long j, String str, String str2, String str3, String str4, String str5, int i, String str6, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "sessionIdFk");
        Intrinsics.checkNotNullParameter(str3, "messageText");
        this.messageId = j;
        this.sessionIdFk = str;
        this.userName = str2;
        this.messageText = str3;
        this.messageTransText = str4;
        this.messageTimeStamp = str5;
        this.sequenceId = i;
        this.typeMode = str6;
        this.interpreted = bool;
    }

    public /* synthetic */ MessageEntity(long j, String str, String str2, String str3, String str4, String str5, int i, String str6, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, str, str2, str3, str4, str5, i, str6, bool);
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final String getSessionIdFk() {
        return this.sessionIdFk;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getMessageText() {
        return this.messageText;
    }

    public final String getMessageTransText() {
        return this.messageTransText;
    }

    public final String getMessageTimeStamp() {
        return this.messageTimeStamp;
    }

    public final int getSequenceId() {
        return this.sequenceId;
    }

    public final String getTypeMode() {
        return this.typeMode;
    }

    public final Boolean getInterpreted() {
        return this.interpreted;
    }
}
