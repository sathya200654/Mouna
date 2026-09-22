package com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.data.local.entity;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.domain.model.LanguageEnum;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeComplexity;
import com.deepvisiontech.letstalksigntranscriptionapp.current.signpractice.domain.model.SignPracticeType;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignPracticeEntity.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003Jw\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\t\u00106\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u00067"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/data/local/entity/SignPracticeEntity;", "", "id", "", "practiceName", "", "domain", "content", "topic", "complexity", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "language", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "uri", "opens", "timeCreated", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;Ljava/lang/String;IJ)V", "getId", "()I", "getPracticeName", "()Ljava/lang/String;", "getDomain", "getContent", "getTopic", "getComplexity", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeComplexity;", "getLanguage", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/domain/model/LanguageEnum;", "getType", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/signpractice/domain/model/SignPracticeType;", "getUri", "getOpens", "getTimeCreated", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SignPracticeEntity {
    public static final int $stable = 0;
    private final SignPracticeComplexity complexity;
    private final String content;
    private final String domain;
    private final int id;
    private final LanguageEnum language;
    private final int opens;
    private final String practiceName;
    private final long timeCreated;
    private final String topic;
    private final SignPracticeType type;
    private final String uri;

    public static /* synthetic */ SignPracticeEntity copy$default(SignPracticeEntity signPracticeEntity, int i, String str, String str2, String str3, String str4, SignPracticeComplexity signPracticeComplexity, LanguageEnum languageEnum, SignPracticeType signPracticeType, String str5, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = signPracticeEntity.id;
        }
        if ((i3 & 2) != 0) {
            str = signPracticeEntity.practiceName;
        }
        if ((i3 & 4) != 0) {
            str2 = signPracticeEntity.domain;
        }
        if ((i3 & 8) != 0) {
            str3 = signPracticeEntity.content;
        }
        if ((i3 & 16) != 0) {
            str4 = signPracticeEntity.topic;
        }
        if ((i3 & 32) != 0) {
            signPracticeComplexity = signPracticeEntity.complexity;
        }
        if ((i3 & 64) != 0) {
            languageEnum = signPracticeEntity.language;
        }
        if ((i3 & 128) != 0) {
            signPracticeType = signPracticeEntity.type;
        }
        if ((i3 & 256) != 0) {
            str5 = signPracticeEntity.uri;
        }
        if ((i3 & 512) != 0) {
            i2 = signPracticeEntity.opens;
        }
        if ((i3 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0) {
            j = signPracticeEntity.timeCreated;
        }
        long j2 = j;
        String str6 = str5;
        int i4 = i2;
        LanguageEnum languageEnum2 = languageEnum;
        SignPracticeType signPracticeType2 = signPracticeType;
        String str7 = str4;
        SignPracticeComplexity signPracticeComplexity2 = signPracticeComplexity;
        return signPracticeEntity.copy(i, str, str2, str3, str7, signPracticeComplexity2, languageEnum2, signPracticeType2, str6, i4, j2);
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

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPracticeName() {
        return this.practiceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTopic() {
        return this.topic;
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
    public final String getUri() {
        return this.uri;
    }

    public final SignPracticeEntity copy(int id, String practiceName, String domain, String content, String topic, SignPracticeComplexity complexity, LanguageEnum language, SignPracticeType type, String uri, int opens, long timeCreated) {
        Intrinsics.checkNotNullParameter(practiceName, "practiceName");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(complexity, "complexity");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(type, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new SignPracticeEntity(id, practiceName, domain, content, topic, complexity, language, type, uri, opens, timeCreated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignPracticeEntity)) {
            return false;
        }
        SignPracticeEntity signPracticeEntity = (SignPracticeEntity) other;
        return this.id == signPracticeEntity.id && Intrinsics.areEqual(this.practiceName, signPracticeEntity.practiceName) && Intrinsics.areEqual(this.domain, signPracticeEntity.domain) && Intrinsics.areEqual(this.content, signPracticeEntity.content) && Intrinsics.areEqual(this.topic, signPracticeEntity.topic) && this.complexity == signPracticeEntity.complexity && this.language == signPracticeEntity.language && this.type == signPracticeEntity.type && Intrinsics.areEqual(this.uri, signPracticeEntity.uri) && this.opens == signPracticeEntity.opens && this.timeCreated == signPracticeEntity.timeCreated;
    }

    public int hashCode() {
        return (((((((((((((((((((Integer.hashCode(this.id) * 31) + this.practiceName.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.content.hashCode()) * 31) + this.topic.hashCode()) * 31) + this.complexity.hashCode()) * 31) + this.language.hashCode()) * 31) + this.type.hashCode()) * 31) + this.uri.hashCode()) * 31) + Integer.hashCode(this.opens)) * 31) + Long.hashCode(this.timeCreated);
    }

    public String toString() {
        return "SignPracticeEntity(id=" + this.id + ", practiceName=" + this.practiceName + ", domain=" + this.domain + ", content=" + this.content + ", topic=" + this.topic + ", complexity=" + this.complexity + ", language=" + this.language + ", type=" + this.type + ", uri=" + this.uri + ", opens=" + this.opens + ", timeCreated=" + this.timeCreated + ")";
    }

    public SignPracticeEntity(int i, String str, String str2, String str3, String str4, SignPracticeComplexity signPracticeComplexity, LanguageEnum languageEnum, SignPracticeType signPracticeType, String str5, int i2, long j) {
        Intrinsics.checkNotNullParameter(str, "practiceName");
        Intrinsics.checkNotNullParameter(str2, "domain");
        Intrinsics.checkNotNullParameter(str3, "content");
        Intrinsics.checkNotNullParameter(str4, "topic");
        Intrinsics.checkNotNullParameter(signPracticeComplexity, "complexity");
        Intrinsics.checkNotNullParameter(languageEnum, "language");
        Intrinsics.checkNotNullParameter(signPracticeType, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        Intrinsics.checkNotNullParameter(str5, "uri");
        this.id = i;
        this.practiceName = str;
        this.domain = str2;
        this.content = str3;
        this.topic = str4;
        this.complexity = signPracticeComplexity;
        this.language = languageEnum;
        this.type = signPracticeType;
        this.uri = str5;
        this.opens = i2;
        this.timeCreated = j;
    }

    public /* synthetic */ SignPracticeEntity(int i, String str, String str2, String str3, String str4, SignPracticeComplexity signPracticeComplexity, LanguageEnum languageEnum, SignPracticeType signPracticeType, String str5, int i2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, str, str2, str3, str4, signPracticeComplexity, languageEnum, signPracticeType, str5, i2, j);
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

    public final String getContent() {
        return this.content;
    }

    public final String getTopic() {
        return this.topic;
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

    public final String getUri() {
        return this.uri;
    }

    public final int getOpens() {
        return this.opens;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }
}
