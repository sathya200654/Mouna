package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.local.entity;

import androidx.recyclerview.widget.RecyclerView;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageInputType;
import com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.MessageType;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationMessageEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\t\u00105\u001a\u00020\u0012HÆ\u0003J\t\u00106\u001a\u00020\u0014HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u008d\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020\u00142\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u000eHÖ\u0001J\t\u0010<\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010)R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019¨\u0006="}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/local/entity/ConversationMessageEntity;", "", "id", "", "conversationIdFk", "userName", "", ResponseKeys.KEY_MESSAGE, "processedMessage", "processedMessageLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "messageLanguage", "signGloss", "sequenceId", "", "messageInputType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "messageType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;", "isProcessed", "", "timeCreated", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;ILcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;ZJ)V", "getId", "()J", "getConversationIdFk", "getUserName", "()Ljava/lang/String;", "getMessage", "getProcessedMessage", "getProcessedMessageLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getMessageLanguage", "getSignGloss", "getSequenceId", "()I", "getMessageInputType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "getMessageType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;", "()Z", "getTimeCreated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationMessageEntity {
    public static final int $stable = 0;
    private final long conversationIdFk;
    private final long id;
    private final boolean isProcessed;
    private final String message;
    private final MessageInputType messageInputType;
    private final LanguageEnum messageLanguage;
    private final MessageType messageType;
    private final String processedMessage;
    private final LanguageEnum processedMessageLanguage;
    private final int sequenceId;
    private final String signGloss;
    private final long timeCreated;
    private final String userName;

    public static /* synthetic */ ConversationMessageEntity copy$default(ConversationMessageEntity conversationMessageEntity, long j, long j2, String str, String str2, String str3, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str4, int i, MessageInputType messageInputType, MessageType messageType, boolean z, long j3, int i2, Object obj) {
        long j4;
        long j5;
        long j6 = (i2 & 1) != 0 ? conversationMessageEntity.id : j;
        long j7 = (i2 & 2) != 0 ? conversationMessageEntity.conversationIdFk : j2;
        String str5 = (i2 & 4) != 0 ? conversationMessageEntity.userName : str;
        String str6 = (i2 & 8) != 0 ? conversationMessageEntity.message : str2;
        String str7 = (i2 & 16) != 0 ? conversationMessageEntity.processedMessage : str3;
        LanguageEnum languageEnum3 = (i2 & 32) != 0 ? conversationMessageEntity.processedMessageLanguage : languageEnum;
        LanguageEnum languageEnum4 = (i2 & 64) != 0 ? conversationMessageEntity.messageLanguage : languageEnum2;
        String str8 = (i2 & 128) != 0 ? conversationMessageEntity.signGloss : str4;
        int i3 = (i2 & 256) != 0 ? conversationMessageEntity.sequenceId : i;
        MessageInputType messageInputType2 = (i2 & 512) != 0 ? conversationMessageEntity.messageInputType : messageInputType;
        MessageType messageType2 = (i2 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? conversationMessageEntity.messageType : messageType;
        boolean z2 = (i2 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? conversationMessageEntity.isProcessed : z;
        if ((i2 & 4096) != 0) {
            j4 = conversationMessageEntity.timeCreated;
            j5 = j6;
        } else {
            j4 = j3;
            j5 = j6;
        }
        return conversationMessageEntity.copy(j5, j7, str5, str6, str7, languageEnum3, languageEnum4, str8, i3, messageInputType2, messageType2, z2, j4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final MessageInputType getMessageInputType() {
        return this.messageInputType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final MessageType getMessageType() {
        return this.messageType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsProcessed() {
        return this.isProcessed;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final long getTimeCreated() {
        return this.timeCreated;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getConversationIdFk() {
        return this.conversationIdFk;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getProcessedMessage() {
        return this.processedMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final LanguageEnum getProcessedMessageLanguage() {
        return this.processedMessageLanguage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final LanguageEnum getMessageLanguage() {
        return this.messageLanguage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSignGloss() {
        return this.signGloss;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getSequenceId() {
        return this.sequenceId;
    }

    public final ConversationMessageEntity copy(long id, long conversationIdFk, String userName, String message, String processedMessage, LanguageEnum processedMessageLanguage, LanguageEnum messageLanguage, String signGloss, int sequenceId, MessageInputType messageInputType, MessageType messageType, boolean isProcessed, long timeCreated) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(processedMessage, "processedMessage");
        Intrinsics.checkNotNullParameter(processedMessageLanguage, "processedMessageLanguage");
        Intrinsics.checkNotNullParameter(messageLanguage, "messageLanguage");
        Intrinsics.checkNotNullParameter(messageInputType, "messageInputType");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        return new ConversationMessageEntity(id, conversationIdFk, userName, message, processedMessage, processedMessageLanguage, messageLanguage, signGloss, sequenceId, messageInputType, messageType, isProcessed, timeCreated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationMessageEntity)) {
            return false;
        }
        ConversationMessageEntity conversationMessageEntity = (ConversationMessageEntity) other;
        return this.id == conversationMessageEntity.id && this.conversationIdFk == conversationMessageEntity.conversationIdFk && Intrinsics.areEqual(this.userName, conversationMessageEntity.userName) && Intrinsics.areEqual(this.message, conversationMessageEntity.message) && Intrinsics.areEqual(this.processedMessage, conversationMessageEntity.processedMessage) && this.processedMessageLanguage == conversationMessageEntity.processedMessageLanguage && this.messageLanguage == conversationMessageEntity.messageLanguage && Intrinsics.areEqual(this.signGloss, conversationMessageEntity.signGloss) && this.sequenceId == conversationMessageEntity.sequenceId && this.messageInputType == conversationMessageEntity.messageInputType && this.messageType == conversationMessageEntity.messageType && this.isProcessed == conversationMessageEntity.isProcessed && this.timeCreated == conversationMessageEntity.timeCreated;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.conversationIdFk)) * 31) + this.userName.hashCode()) * 31) + this.message.hashCode()) * 31) + this.processedMessage.hashCode()) * 31) + this.processedMessageLanguage.hashCode()) * 31) + this.messageLanguage.hashCode()) * 31;
        String str = this.signGloss;
        return ((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.sequenceId)) * 31) + this.messageInputType.hashCode()) * 31) + this.messageType.hashCode()) * 31) + Boolean.hashCode(this.isProcessed)) * 31) + Long.hashCode(this.timeCreated);
    }

    public String toString() {
        return "ConversationMessageEntity(id=" + this.id + ", conversationIdFk=" + this.conversationIdFk + ", userName=" + this.userName + ", message=" + this.message + ", processedMessage=" + this.processedMessage + ", processedMessageLanguage=" + this.processedMessageLanguage + ", messageLanguage=" + this.messageLanguage + ", signGloss=" + this.signGloss + ", sequenceId=" + this.sequenceId + ", messageInputType=" + this.messageInputType + ", messageType=" + this.messageType + ", isProcessed=" + this.isProcessed + ", timeCreated=" + this.timeCreated + ")";
    }

    public ConversationMessageEntity(long j, long j2, String str, String str2, String str3, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str4, int i, MessageInputType messageInputType, MessageType messageType, boolean z, long j3) {
        Intrinsics.checkNotNullParameter(str, "userName");
        Intrinsics.checkNotNullParameter(str2, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(str3, "processedMessage");
        Intrinsics.checkNotNullParameter(languageEnum, "processedMessageLanguage");
        Intrinsics.checkNotNullParameter(languageEnum2, "messageLanguage");
        Intrinsics.checkNotNullParameter(messageInputType, "messageInputType");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        this.id = j;
        this.conversationIdFk = j2;
        this.userName = str;
        this.message = str2;
        this.processedMessage = str3;
        this.processedMessageLanguage = languageEnum;
        this.messageLanguage = languageEnum2;
        this.signGloss = str4;
        this.sequenceId = i;
        this.messageInputType = messageInputType;
        this.messageType = messageType;
        this.isProcessed = z;
        this.timeCreated = j3;
    }

    public final long getId() {
        return this.id;
    }

    public final long getConversationIdFk() {
        return this.conversationIdFk;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getProcessedMessage() {
        return this.processedMessage;
    }

    public final LanguageEnum getProcessedMessageLanguage() {
        return this.processedMessageLanguage;
    }

    public final LanguageEnum getMessageLanguage() {
        return this.messageLanguage;
    }

    public final String getSignGloss() {
        return this.signGloss;
    }

    public final int getSequenceId() {
        return this.sequenceId;
    }

    public final MessageInputType getMessageInputType() {
        return this.messageInputType;
    }

    public /* synthetic */ ConversationMessageEntity(long j, long j2, String str, String str2, String str3, LanguageEnum languageEnum, LanguageEnum languageEnum2, String str4, int i, MessageInputType messageInputType, MessageType messageType, boolean z, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, j2, str, str2, str3, languageEnum, languageEnum2, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? 0 : i, (i2 & 512) != 0 ? MessageInputType.TYPED : messageInputType, (i2 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? MessageType.INTERPRETATION : messageType, (i2 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? false : z, j3);
    }

    public final MessageType getMessageType() {
        return this.messageType;
    }

    public final boolean isProcessed() {
        return this.isProcessed;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }
}
