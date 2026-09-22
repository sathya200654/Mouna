package com.deepvisiontech.letstalksigntranscriptionapp.current.conversations.domain.model.conversationsettings;

import android.speech.tts.Voice;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoiceObject.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/conversations/domain/model/conversationsettings/VoiceOption;", "", "id", "", "displayNameRes", "", "displayNameArgs", "", "isSelected", "", "voice", "Landroid/speech/tts/Voice;", "<init>", "(Ljava/lang/String;ILjava/util/List;ZLandroid/speech/tts/Voice;)V", "getId", "()Ljava/lang/String;", "getDisplayNameRes", "()I", "getDisplayNameArgs", "()Ljava/util/List;", "()Z", "getVoice", "()Landroid/speech/tts/Voice;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class VoiceOption {
    public static final int $stable = 8;
    private final List<Object> displayNameArgs;
    private final int displayNameRes;
    private final String id;
    private final boolean isSelected;
    private final Voice voice;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoiceOption copy$default(VoiceOption voiceOption, String str, int i, List list, boolean z, Voice voice, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = voiceOption.id;
        }
        if ((i2 & 2) != 0) {
            i = voiceOption.displayNameRes;
        }
        if ((i2 & 4) != 0) {
            list = voiceOption.displayNameArgs;
        }
        if ((i2 & 8) != 0) {
            z = voiceOption.isSelected;
        }
        if ((i2 & 16) != 0) {
            voice = voiceOption.voice;
        }
        Voice voice2 = voice;
        List list2 = list;
        return voiceOption.copy(str, i, list2, z, voice2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDisplayNameRes() {
        return this.displayNameRes;
    }

    public final List<Object> component3() {
        return this.displayNameArgs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Voice getVoice() {
        return this.voice;
    }

    public final VoiceOption copy(String id, int displayNameRes, List<? extends Object> displayNameArgs, boolean isSelected, Voice voice) {
        Intrinsics.checkNotNullParameter(displayNameArgs, "displayNameArgs");
        return new VoiceOption(id, displayNameRes, displayNameArgs, isSelected, voice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceOption)) {
            return false;
        }
        VoiceOption voiceOption = (VoiceOption) other;
        return Intrinsics.areEqual(this.id, voiceOption.id) && this.displayNameRes == voiceOption.displayNameRes && Intrinsics.areEqual(this.displayNameArgs, voiceOption.displayNameArgs) && this.isSelected == voiceOption.isSelected && Intrinsics.areEqual(this.voice, voiceOption.voice);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.displayNameRes)) * 31) + this.displayNameArgs.hashCode()) * 31) + Boolean.hashCode(this.isSelected)) * 31;
        Voice voice = this.voice;
        return iHashCode + (voice != null ? voice.hashCode() : 0);
    }

    public String toString() {
        return "VoiceOption(id=" + this.id + ", displayNameRes=" + this.displayNameRes + ", displayNameArgs=" + this.displayNameArgs + ", isSelected=" + this.isSelected + ", voice=" + this.voice + ")";
    }

    public VoiceOption(String str, int i, List<? extends Object> list, boolean z, Voice voice) {
        Intrinsics.checkNotNullParameter(list, "displayNameArgs");
        this.id = str;
        this.displayNameRes = i;
        this.displayNameArgs = list;
        this.isSelected = z;
        this.voice = voice;
    }

    public final String getId() {
        return this.id;
    }

    public final int getDisplayNameRes() {
        return this.displayNameRes;
    }

    public /* synthetic */ VoiceOption(String str, int i, List list, boolean z, Voice voice, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, z, voice);
    }

    public final List<Object> getDisplayNameArgs() {
        return this.displayNameArgs;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final Voice getVoice() {
        return this.voice;
    }
}
