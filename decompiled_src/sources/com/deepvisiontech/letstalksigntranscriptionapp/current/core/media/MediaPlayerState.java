package com.deepvisiontech.letstalksigntranscriptionapp.current.core.media;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaPlayerManager.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerState;", "", "playerState", "", "isPlaying", "", "playbackSpeed", "", "currentPosition", "", "duration", "error", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", "<init>", "(IZFJJLcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;)V", "getPlayerState", "()I", "()Z", "getPlaybackSpeed", "()F", "getCurrentPosition", "()J", "getDuration", "getError", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/media/MediaPlayerEvent$Error;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MediaPlayerState {
    public static final int $stable = 8;
    private final long currentPosition;
    private final long duration;
    private final MediaPlayerEvent.Error error;
    private final boolean isPlaying;
    private final float playbackSpeed;
    private final int playerState;

    public MediaPlayerState() {
        this(0, false, 0.0f, 0L, 0L, null, 63, null);
    }

    public static /* synthetic */ MediaPlayerState copy$default(MediaPlayerState mediaPlayerState, int i, boolean z, float f, long j, long j2, MediaPlayerEvent.Error error, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mediaPlayerState.playerState;
        }
        if ((i2 & 2) != 0) {
            z = mediaPlayerState.isPlaying;
        }
        if ((i2 & 4) != 0) {
            f = mediaPlayerState.playbackSpeed;
        }
        if ((i2 & 8) != 0) {
            j = mediaPlayerState.currentPosition;
        }
        if ((i2 & 16) != 0) {
            j2 = mediaPlayerState.duration;
        }
        if ((i2 & 32) != 0) {
            error = mediaPlayerState.error;
        }
        MediaPlayerEvent.Error error2 = error;
        long j3 = j2;
        float f2 = f;
        return mediaPlayerState.copy(i, z, f2, j, j3, error2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getPlayerState() {
        return this.playerState;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MediaPlayerEvent.Error getError() {
        return this.error;
    }

    public final MediaPlayerState copy(int playerState, boolean isPlaying, float playbackSpeed, long currentPosition, long duration, MediaPlayerEvent.Error error) {
        return new MediaPlayerState(playerState, isPlaying, playbackSpeed, currentPosition, duration, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaPlayerState)) {
            return false;
        }
        MediaPlayerState mediaPlayerState = (MediaPlayerState) other;
        return this.playerState == mediaPlayerState.playerState && this.isPlaying == mediaPlayerState.isPlaying && Float.compare(this.playbackSpeed, mediaPlayerState.playbackSpeed) == 0 && this.currentPosition == mediaPlayerState.currentPosition && this.duration == mediaPlayerState.duration && Intrinsics.areEqual(this.error, mediaPlayerState.error);
    }

    public int hashCode() {
        int iHashCode = ((((((((Integer.hashCode(this.playerState) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Float.hashCode(this.playbackSpeed)) * 31) + Long.hashCode(this.currentPosition)) * 31) + Long.hashCode(this.duration)) * 31;
        MediaPlayerEvent.Error error = this.error;
        return iHashCode + (error == null ? 0 : error.hashCode());
    }

    public String toString() {
        return "MediaPlayerState(playerState=" + this.playerState + ", isPlaying=" + this.isPlaying + ", playbackSpeed=" + this.playbackSpeed + ", currentPosition=" + this.currentPosition + ", duration=" + this.duration + ", error=" + this.error + ")";
    }

    public MediaPlayerState(int i, boolean z, float f, long j, long j2, MediaPlayerEvent.Error error) {
        this.playerState = i;
        this.isPlaying = z;
        this.playbackSpeed = f;
        this.currentPosition = j;
        this.duration = j2;
        this.error = error;
    }

    public /* synthetic */ MediaPlayerState(int i, boolean z, float f, long j, long j2, MediaPlayerEvent.Error error, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? 0L : j2, (i2 & 32) != 0 ? null : error);
    }

    public final int getPlayerState() {
        return this.playerState;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final float getPlaybackSpeed() {
        return this.playbackSpeed;
    }

    public final long getCurrentPosition() {
        return this.currentPosition;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final MediaPlayerEvent.Error getError() {
        return this.error;
    }
}
