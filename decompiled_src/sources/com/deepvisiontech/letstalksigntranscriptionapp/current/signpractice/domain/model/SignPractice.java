package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model;

import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPractice.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0013HÆ\u0003J\t\u00108\u001a\u00020\u0015HÆ\u0003J\u0081\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010:\u001a\u00020\u00152\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010*\"\u0004\b+\u0010,¨\u0006>"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPractice;", "", "id", "", "practiceName", "", "domain", "topic", "content", "complexity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "uri", "Landroid/net/Uri;", "opens", "timeCreated", "", "isSelected", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;Landroid/net/Uri;IJZ)V", "getId", "()I", "getPracticeName", "()Ljava/lang/String;", "getDomain", "getTopic", "getContent", "getComplexity", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "getUri", "()Landroid/net/Uri;", "getOpens", "getTimeCreated", "()J", "()Z", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SignPractice {
    public static final int $stable = 8;
    private final SignPracticeComplexity complexity;
    private final String content;
    private final String domain;
    private final int id;
    private boolean isSelected;
    private final LanguageEnum language;
    private final int opens;
    private final String practiceName;
    private final long timeCreated;
    private final String topic;
    private final SignPracticeType type;
    private final Uri uri;

    public static /* synthetic */ SignPractice copy$default(SignPractice signPractice, int i, String str, String str2, String str3, String str4, SignPracticeComplexity signPracticeComplexity, LanguageEnum languageEnum, SignPracticeType signPracticeType, Uri uri, int i2, long j, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = signPractice.id;
        }
        return signPractice.copy(i, (i3 & 2) != 0 ? signPractice.practiceName : str, (i3 & 4) != 0 ? signPractice.domain : str2, (i3 & 8) != 0 ? signPractice.topic : str3, (i3 & 16) != 0 ? signPractice.content : str4, (i3 & 32) != 0 ? signPractice.complexity : signPracticeComplexity, (i3 & 64) != 0 ? signPractice.language : languageEnum, (i3 & 128) != 0 ? signPractice.type : signPracticeType, (i3 & 256) != 0 ? signPractice.uri : uri, (i3 & 512) != 0 ? signPractice.opens : i2, (i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? signPractice.timeCreated : j, (i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? signPractice.isSelected : z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getOpens() {
        return this.opens;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getTimeCreated() {
        return this.timeCreated;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPracticeName() {
        return this.practiceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final SignPracticeComplexity getComplexity() {
        return this.complexity;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final LanguageEnum getLanguage() {
        return this.language;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final SignPracticeType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    public final SignPractice copy(int id, String practiceName, String domain, String topic, String content, SignPracticeComplexity complexity, LanguageEnum language, SignPracticeType type, Uri uri, int opens, long timeCreated, boolean isSelected) {
        Intrinsics.checkNotNullParameter(practiceName, "practiceName");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(complexity, "complexity");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new SignPractice(id, practiceName, domain, topic, content, complexity, language, type, uri, opens, timeCreated, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPractice)) {
            return false;
        }
        SignPractice signPractice = (SignPractice) other;
        return this.id == signPractice.id && Intrinsics.areEqual(this.practiceName, signPractice.practiceName) && Intrinsics.areEqual(this.domain, signPractice.domain) && Intrinsics.areEqual(this.topic, signPractice.topic) && Intrinsics.areEqual(this.content, signPractice.content) && this.complexity == signPractice.complexity && this.language == signPractice.language && this.type == signPractice.type && Intrinsics.areEqual(this.uri, signPractice.uri) && this.opens == signPractice.opens && this.timeCreated == signPractice.timeCreated && this.isSelected == signPractice.isSelected;
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.id) * 31) + this.practiceName.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.topic.hashCode()) * 31) + this.content.hashCode()) * 31) + this.complexity.hashCode()) * 31) + this.language.hashCode()) * 31) + this.type.hashCode()) * 31) + this.uri.hashCode()) * 31) + Integer.hashCode(this.opens)) * 31) + Long.hashCode(this.timeCreated)) * 31) + Boolean.hashCode(this.isSelected);
    }

    public String toString() {
        return "SignPractice(id=" + this.id + ", practiceName=" + this.practiceName + ", domain=" + this.domain + ", topic=" + this.topic + ", content=" + this.content + ", complexity=" + this.complexity + ", language=" + this.language + ", type=" + this.type + ", uri=" + this.uri + ", opens=" + this.opens + ", timeCreated=" + this.timeCreated + ", isSelected=" + this.isSelected + ")";
    }

    public SignPractice(int i, String str, String str2, String str3, String str4, SignPracticeComplexity signPracticeComplexity, LanguageEnum languageEnum, SignPracticeType signPracticeType, Uri uri, int i2, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "practiceName");
        Intrinsics.checkNotNullParameter(str2, "domain");
        Intrinsics.checkNotNullParameter(str3, "topic");
        Intrinsics.checkNotNullParameter(str4, "content");
        Intrinsics.checkNotNullParameter(signPracticeComplexity, "complexity");
        Intrinsics.checkNotNullParameter(languageEnum, "language");
        Intrinsics.checkNotNullParameter(signPracticeType, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.id = i;
        this.practiceName = str;
        this.domain = str2;
        this.topic = str3;
        this.content = str4;
        this.complexity = signPracticeComplexity;
        this.language = languageEnum;
        this.type = signPracticeType;
        this.uri = uri;
        this.opens = i2;
        this.timeCreated = j;
        this.isSelected = z;
    }

    public /* synthetic */ SignPractice(int i, String str, String str2, String str3, String str4, SignPracticeComplexity signPracticeComplexity, LanguageEnum languageEnum, SignPracticeType signPracticeType, Uri uri, int i2, long j, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, str, str2, str3, str4, signPracticeComplexity, languageEnum, signPracticeType, uri, (i3 & 512) != 0 ? 0 : i2, j, (i3 & RecyclerView.ItemAnimator.FLAG_MOVED) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final String getPracticeName() {
        return this.practiceName;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final String getContent() {
        return this.content;
    }

    public final SignPracticeComplexity getComplexity() {
        return this.complexity;
    }

    public final LanguageEnum getLanguage() {
        return this.language;
    }

    public final SignPracticeType getType() {
        return this.type;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getOpens() {
        return this.opens;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
