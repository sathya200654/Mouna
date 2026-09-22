package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.data.remote.dto.ocr;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OcrDataDto.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/data/remote/dto/ocr/OcrDataDto;", "", "extractedText", "", "<init>", "(Ljava/lang/String;)V", "getExtractedText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class OcrDataDto {
    public static final int $stable = 0;

    @SerializedName("extracted_text")
    private final String extractedText;

    public static /* synthetic */ OcrDataDto copy$default(OcrDataDto ocrDataDto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ocrDataDto.extractedText;
        }
        return ocrDataDto.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getExtractedText() {
        return this.extractedText;
    }

    public final OcrDataDto copy(String extractedText) {
        return new OcrDataDto(extractedText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof OcrDataDto) && Intrinsics.areEqual(this.extractedText, ((OcrDataDto) other).extractedText);
    }

    public int hashCode() {
        String str = this.extractedText;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "OcrDataDto(extractedText=" + this.extractedText + ")";
    }

    public OcrDataDto(String str) {
        this.extractedText = str;
    }

    public final String getExtractedText() {
        return this.extractedText;
    }
}
