package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model;

import com.deepvisiontech.letstalksigntranscriptionapp.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: SignPracticeComplexity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "", "displayNameRes", "", "<init>", "(Ljava/lang/String;II)V", "getDisplayNameRes", "()I", "EASY", "MEDIUM", "HARD", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum SignPracticeComplexity {
    EASY(R.string.sign_practice_complexity_easy),
    MEDIUM(R.string.sign_practice_complexity_medium),
    HARD(R.string.sign_practice_complexity_hard);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int displayNameRes;

    public static EnumEntries<SignPracticeComplexity> getEntries() {
        return $ENTRIES;
    }

    SignPracticeComplexity(int i) {
        this.displayNameRes = i;
    }

    public final int getDisplayNameRes() {
        return this.displayNameRes;
    }
}
