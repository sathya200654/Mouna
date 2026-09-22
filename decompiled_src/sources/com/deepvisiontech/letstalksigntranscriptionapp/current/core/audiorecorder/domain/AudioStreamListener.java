package com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.domain;

import kotlin.Metadata;

/* JADX INFO: compiled from: AudioStreamListener.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/domain/AudioStreamListener;", "", "onAudioData", "", "audioData", "", "size", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AudioStreamListener {
    void onAudioData(byte[] audioData, int size);
}
