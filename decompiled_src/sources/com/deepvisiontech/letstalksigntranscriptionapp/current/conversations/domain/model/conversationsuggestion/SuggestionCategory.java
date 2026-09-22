package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsuggestion;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SuggestionCategory.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsuggestion/SuggestionCategory;", "", "id", "", "name", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class SuggestionCategory {
    public static final int $stable = 0;
    private final long id;
    private final String name;

    public static /* synthetic */ SuggestionCategory copy$default(SuggestionCategory suggestionCategory, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = suggestionCategory.id;
        }
        if ((i & 2) != 0) {
            str = suggestionCategory.name;
        }
        return suggestionCategory.copy(j, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final SuggestionCategory copy(long id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SuggestionCategory(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SuggestionCategory)) {
            return false;
        }
        SuggestionCategory suggestionCategory = (SuggestionCategory) other;
        return this.id == suggestionCategory.id && Intrinsics.areEqual(this.name, suggestionCategory.name);
    }

    public int hashCode() {
        return (Long.hashCode(this.id) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "SuggestionCategory(id=" + this.id + ", name=" + this.name + ")";
    }

    public SuggestionCategory(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.id = j;
        this.name = str;
    }

    public /* synthetic */ SuggestionCategory(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}
