package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model;

import androidx.recyclerview.widget.RecyclerView;
import androidx.tracing.perfetto.handshake.protocol.ResponseKeys;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationMessage.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0014HÆ\u0003J\t\u00108\u001a\u00020\u0014HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\u0097\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\rHÖ\u0001J\t\u0010>\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010*R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010*R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001a¨\u0006?"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/ConversationMessage;", "", "id", "", "conversationIdFk", "userName", "", ResponseKeys.KEY_MESSAGE, "processedMessage", "processedMessageLanguage", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "signGloss", "sequenceId", "", "messageLanguage", "messageInputType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "messageType", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;", "isProcessed", "", "isGettingInterpreted", "timeCreated", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Ljava/lang/String;ILcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;ZZJ)V", "getId", "()J", "getConversationIdFk", "getUserName", "()Ljava/lang/String;", "getMessage", "getProcessedMessage", "getProcessedMessageLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getSignGloss", "getSequenceId", "()I", "getMessageLanguage", "getMessageInputType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageInputType;", "getMessageType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/MessageType;", "()Z", "getTimeCreated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationMessage {
    public static final int $stable = 0;
    private final long conversationIdFk;
    private final long id;
    private final boolean isGettingInterpreted;
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

    public static /* synthetic */ ConversationMessage copy$default(ConversationMessage conversationMessage, long j, long j2, String str, String str2, String str3, LanguageEnum languageEnum, String str4, int i, LanguageEnum languageEnum2, MessageInputType messageInputType, MessageType messageType, boolean z, boolean z2, long j3, int i2, Object obj) {
        long j4;
        boolean z3;
        long j5 = (i2 & 1) != 0 ? conversationMessage.id : j;
        long j6 = (i2 & 2) != 0 ? conversationMessage.conversationIdFk : j2;
        String str5 = (i2 & 4) != 0 ? conversationMessage.userName : str;
        String str6 = (i2 & 8) != 0 ? conversationMessage.message : str2;
        String str7 = (i2 & 16) != 0 ? conversationMessage.processedMessage : str3;
        LanguageEnum languageEnum3 = (i2 & 32) != 0 ? conversationMessage.processedMessageLanguage : languageEnum;
        String str8 = (i2 & 64) != 0 ? conversationMessage.signGloss : str4;
        int i3 = (i2 & 128) != 0 ? conversationMessage.sequenceId : i;
        LanguageEnum languageEnum4 = (i2 & 256) != 0 ? conversationMessage.messageLanguage : languageEnum2;
        MessageInputType messageInputType2 = (i2 & 512) != 0 ? conversationMessage.messageInputType : messageInputType;
        MessageType messageType2 = (i2 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? conversationMessage.messageType : messageType;
        boolean z4 = (i2 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? conversationMessage.isProcessed : z;
        long j7 = j5;
        boolean z5 = (i2 & 4096) != 0 ? conversationMessage.isGettingInterpreted : z2;
        if ((i2 & 8192) != 0) {
            z3 = z5;
            j4 = conversationMessage.timeCreated;
        } else {
            j4 = j3;
            z3 = z5;
        }
        return conversationMessage.copy(j7, j6, str5, str6, str7, languageEnum3, str8, i3, languageEnum4, messageInputType2, messageType2, z4, z3, j4);
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
    public final boolean getIsGettingInterpreted() {
        return this.isGettingInterpreted;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
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
    public final String getSignGloss() {
        return this.signGloss;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getSequenceId() {
        return this.sequenceId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final LanguageEnum getMessageLanguage() {
        return this.messageLanguage;
    }

    public final ConversationMessage copy(long id, long conversationIdFk, String userName, String message, String processedMessage, LanguageEnum processedMessageLanguage, String signGloss, int sequenceId, LanguageEnum messageLanguage, MessageInputType messageInputType, MessageType messageType, boolean isProcessed, boolean isGettingInterpreted, long timeCreated) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(message, ResponseKeys.KEY_MESSAGE);
        Intrinsics.checkNotNullParameter(processedMessage, "processedMessage");
        Intrinsics.checkNotNullParameter(processedMessageLanguage, "processedMessageLanguage");
        Intrinsics.checkNotNullParameter(messageLanguage, "messageLanguage");
        Intrinsics.checkNotNullParameter(messageInputType, "messageInputType");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        return new ConversationMessage(id, conversationIdFk, userName, message, processedMessage, processedMessageLanguage, signGloss, sequenceId, messageLanguage, messageInputType, messageType, isProcessed, isGettingInterpreted, timeCreated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationMessage)) {
            return false;
        }
        ConversationMessage conversationMessage = (ConversationMessage) other;
        return this.id == conversationMessage.id && this.conversationIdFk == conversationMessage.conversationIdFk && Intrinsics.areEqual(this.userName, conversationMessage.userName) && Intrinsics.areEqual(this.message, conversationMessage.message) && Intrinsics.areEqual(this.processedMessage, conversationMessage.processedMessage) && this.processedMessageLanguage == conversationMessage.processedMessageLanguage && Intrinsics.areEqual(this.signGloss, conversationMessage.signGloss) && this.sequenceId == conversationMessage.sequenceId && this.messageLanguage == conversationMessage.messageLanguage && this.messageInputType == conversationMessage.messageInputType && this.messageType == conversationMessage.messageType && this.isProcessed == conversationMessage.isProcessed && this.isGettingInterpreted == conversationMessage.isGettingInterpreted && this.timeCreated == conversationMessage.timeCreated;
    }

    public int hashCode() {
        int iHashCode = ((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.conversationIdFk)) * 31) + this.userName.hashCode()) * 31) + this.message.hashCode()) * 31) + this.processedMessage.hashCode()) * 31) + this.processedMessageLanguage.hashCode()) * 31;
        String str = this.signGloss;
        return ((((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.sequenceId)) * 31) + this.messageLanguage.hashCode()) * 31) + this.messageInputType.hashCode()) * 31) + this.messageType.hashCode()) * 31) + Boolean.hashCode(this.isProcessed)) * 31) + Boolean.hashCode(this.isGettingInterpreted)) * 31) + Long.hashCode(this.timeCreated);
    }

    public String toString() {
        return "ConversationMessage(id=" + this.id + ", conversationIdFk=" + this.conversationIdFk + ", userName=" + this.userName + ", message=" + this.message + ", processedMessage=" + this.processedMessage + ", processedMessageLanguage=" + this.processedMessageLanguage + ", signGloss=" + this.signGloss + ", sequenceId=" + this.sequenceId + ", messageLanguage=" + this.messageLanguage + ", messageInputType=" + this.messageInputType + ", messageType=" + this.messageType + ", isProcessed=" + this.isProcessed + ", isGettingInterpreted=" + this.isGettingInterpreted + ", timeCreated=" + this.timeCreated + ")";
    }

    public ConversationMessage(long j, long j2, String str, String str2, String str3, LanguageEnum languageEnum, String str4, int i, LanguageEnum languageEnum2, MessageInputType messageInputType, MessageType messageType, boolean z, boolean z2, long j3) {
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
        this.signGloss = str4;
        this.sequenceId = i;
        this.messageLanguage = languageEnum2;
        this.messageInputType = messageInputType;
        this.messageType = messageType;
        this.isProcessed = z;
        this.isGettingInterpreted = z2;
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

    public final String getSignGloss() {
        return this.signGloss;
    }

    public final int getSequenceId() {
        return this.sequenceId;
    }

    public final LanguageEnum getMessageLanguage() {
        return this.messageLanguage;
    }

    public /* synthetic */ ConversationMessage(long j, long j2, String str, String str2, String str3, LanguageEnum languageEnum, String str4, int i, LanguageEnum languageEnum2, MessageInputType messageInputType, MessageType messageType, boolean z, boolean z2, long j3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, j2, str, str2, str3, languageEnum, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? 0 : i, languageEnum2, (i2 & 512) != 0 ? MessageInputType.TYPED : messageInputType, (i2 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? MessageType.INTERPRETATION : messageType, (i2 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? false : z, (i2 & 4096) != 0 ? false : z2, j3);
    }

    public final MessageInputType getMessageInputType() {
        return this.messageInputType;
    }

    public final MessageType getMessageType() {
        return this.messageType;
    }

    public final boolean isProcessed() {
        return this.isProcessed;
    }

    public final boolean isGettingInterpreted() {
        return this.isGettingInterpreted;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }
}
