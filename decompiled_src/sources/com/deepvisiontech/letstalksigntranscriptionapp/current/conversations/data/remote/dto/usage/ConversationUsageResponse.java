package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.usage;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConversationUsageResponse.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJl\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0016\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c¨\u0006/"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageResponse;", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/response/ApiContract;", "status", "", "errorCode", "sessionTimeHours", "", "summaryLimit", "", "articleSummaryLimit", "scanLimit", "ttsLimit", "typedInterpretationLimit", "sessionCount", "<init>", "(Ljava/lang/String;Ljava/lang/String;FIIIIILjava/lang/Integer;)V", "getStatus", "()Ljava/lang/String;", "getErrorCode", "getSessionTimeHours", "()F", "getSummaryLimit", "()I", "getArticleSummaryLimit", "getScanLimit", "getTtsLimit", "getTypedInterpretationLimit", "getSessionCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;FIIIIILjava/lang/Integer;)Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/usage/ConversationUsageResponse;", "equals", "", "other", "", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ConversationUsageResponse implements ApiContract {
    public static final int $stable = 0;

    @SerializedName("article_summary")
    private final int articleSummaryLimit;

    @SerializedName("error_code")
    private final String errorCode;

    @SerializedName("scan")
    private final int scanLimit;

    @SerializedName("session_count")
    private final Integer sessionCount;

    @SerializedName("session_time")
    private final float sessionTimeHours;
    private final String status;

    @SerializedName("summary")
    private final int summaryLimit;

    @SerializedName("text_to_speech")
    private final int ttsLimit;

    @SerializedName(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)
    private final int typedInterpretationLimit;

    public static /* synthetic */ ConversationUsageResponse copy$default(ConversationUsageResponse conversationUsageResponse, String str, String str2, float f, int i, int i2, int i3, int i4, int i5, Integer num, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = conversationUsageResponse.status;
        }
        if ((i6 & 2) != 0) {
            str2 = conversationUsageResponse.errorCode;
        }
        if ((i6 & 4) != 0) {
            f = conversationUsageResponse.sessionTimeHours;
        }
        if ((i6 & 8) != 0) {
            i = conversationUsageResponse.summaryLimit;
        }
        if ((i6 & 16) != 0) {
            i2 = conversationUsageResponse.articleSummaryLimit;
        }
        if ((i6 & 32) != 0) {
            i3 = conversationUsageResponse.scanLimit;
        }
        if ((i6 & 64) != 0) {
            i4 = conversationUsageResponse.ttsLimit;
        }
        if ((i6 & 128) != 0) {
            i5 = conversationUsageResponse.typedInterpretationLimit;
        }
        if ((i6 & 256) != 0) {
            num = conversationUsageResponse.sessionCount;
        }
        int i7 = i5;
        Integer num2 = num;
        int i8 = i3;
        int i9 = i4;
        int i10 = i2;
        float f2 = f;
        return conversationUsageResponse.copy(str, str2, f2, i, i10, i8, i9, i7, num2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getSessionTimeHours() {
        return this.sessionTimeHours;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSummaryLimit() {
        return this.summaryLimit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getArticleSummaryLimit() {
        return this.articleSummaryLimit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getScanLimit() {
        return this.scanLimit;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTtsLimit() {
        return this.ttsLimit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getTypedInterpretationLimit() {
        return this.typedInterpretationLimit;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getSessionCount() {
        return this.sessionCount;
    }

    public final ConversationUsageResponse copy(String status, String errorCode, float sessionTimeHours, int summaryLimit, int articleSummaryLimit, int scanLimit, int ttsLimit, int typedInterpretationLimit, Integer sessionCount) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new ConversationUsageResponse(status, errorCode, sessionTimeHours, summaryLimit, articleSummaryLimit, scanLimit, ttsLimit, typedInterpretationLimit, sessionCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationUsageResponse)) {
            return false;
        }
        ConversationUsageResponse conversationUsageResponse = (ConversationUsageResponse) other;
        return Intrinsics.areEqual(this.status, conversationUsageResponse.status) && Intrinsics.areEqual(this.errorCode, conversationUsageResponse.errorCode) && Float.compare(this.sessionTimeHours, conversationUsageResponse.sessionTimeHours) == 0 && this.summaryLimit == conversationUsageResponse.summaryLimit && this.articleSummaryLimit == conversationUsageResponse.articleSummaryLimit && this.scanLimit == conversationUsageResponse.scanLimit && this.ttsLimit == conversationUsageResponse.ttsLimit && this.typedInterpretationLimit == conversationUsageResponse.typedInterpretationLimit && Intrinsics.areEqual(this.sessionCount, conversationUsageResponse.sessionCount);
    }

    public int hashCode() {
        int iHashCode = this.status.hashCode() * 31;
        String str = this.errorCode;
        int iHashCode2 = (((((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.hashCode(this.sessionTimeHours)) * 31) + Integer.hashCode(this.summaryLimit)) * 31) + Integer.hashCode(this.articleSummaryLimit)) * 31) + Integer.hashCode(this.scanLimit)) * 31) + Integer.hashCode(this.ttsLimit)) * 31) + Integer.hashCode(this.typedInterpretationLimit)) * 31;
        Integer num = this.sessionCount;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ConversationUsageResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", sessionTimeHours=" + this.sessionTimeHours + ", summaryLimit=" + this.summaryLimit + ", articleSummaryLimit=" + this.articleSummaryLimit + ", scanLimit=" + this.scanLimit + ", ttsLimit=" + this.ttsLimit + ", typedInterpretationLimit=" + this.typedInterpretationLimit + ", sessionCount=" + this.sessionCount + ")";
    }

    public ConversationUsageResponse(String str, String str2, float f, int i, int i2, int i3, int i4, int i5, Integer num) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.status = str;
        this.errorCode = str2;
        this.sessionTimeHours = f;
        this.summaryLimit = i;
        this.articleSummaryLimit = i2;
        this.scanLimit = i3;
        this.ttsLimit = i4;
        this.typedInterpretationLimit = i5;
        this.sessionCount = num;
    }

    public /* synthetic */ ConversationUsageResponse(String str, String str2, float f, int i, int i2, int i3, int i4, int i5, Integer num, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, f, i, i2, i3, i4, i5, (i6 & 256) != 0 ? null : num);
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getStatus() {
        return this.status;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.response.ApiContract
    public String getErrorCode() {
        return this.errorCode;
    }

    public final float getSessionTimeHours() {
        return this.sessionTimeHours;
    }

    public final int getSummaryLimit() {
        return this.summaryLimit;
    }

    public final int getArticleSummaryLimit() {
        return this.articleSummaryLimit;
    }

    public final int getScanLimit() {
        return this.scanLimit;
    }

    public final int getTtsLimit() {
        return this.ttsLimit;
    }

    public final int getTypedInterpretationLimit() {
        return this.typedInterpretationLimit;
    }

    public final Integer getSessionCount() {
        return this.sessionCount;
    }
}
