package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeEssay.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeEssay;", "", "content", "", "tokenSize", "", "<init>", "(Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getTokenSize", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SignPracticeEssay {
    public static final int $stable = 0;
    private final String content;
    private final int tokenSize;

    public static /* synthetic */ SignPracticeEssay copy$default(SignPracticeEssay signPracticeEssay, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = signPracticeEssay.content;
        }
        if ((i2 & 2) != 0) {
            i = signPracticeEssay.tokenSize;
        }
        return signPracticeEssay.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTokenSize() {
        return this.tokenSize;
    }

    public final SignPracticeEssay copy(String content, int tokenSize) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new SignPracticeEssay(content, tokenSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPracticeEssay)) {
            return false;
        }
        SignPracticeEssay signPracticeEssay = (SignPracticeEssay) other;
        return Intrinsics.areEqual(this.content, signPracticeEssay.content) && this.tokenSize == signPracticeEssay.tokenSize;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + Integer.hashCode(this.tokenSize);
    }

    public String toString() {
        return "SignPracticeEssay(content=" + this.content + ", tokenSize=" + this.tokenSize + ")";
    }

    public SignPracticeEssay(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "content");
        this.content = str;
        this.tokenSize = i;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getTokenSize() {
        return this.tokenSize;
    }
}
