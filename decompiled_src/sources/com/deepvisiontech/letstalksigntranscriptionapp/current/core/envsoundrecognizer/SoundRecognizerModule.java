package com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer;

import android.content.Context;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.SharedAudioEngine;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.data.services.EnvSoundRecognizerServiceImpl;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.envsoundrecognizer.domain.services.EnvSoundRecognizerService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SoundRecognizerModule.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/SoundRecognizerModule;", "", "<init>", "()V", "providesSoundRecognizerService", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/envsoundrecognizer/domain/services/EnvSoundRecognizerService;", "context", "Landroid/content/Context;", "sharedAudioEngine", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/SharedAudioEngine;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class SoundRecognizerModule {
    public static final int $stable = 0;
    public static final SoundRecognizerModule INSTANCE = new SoundRecognizerModule();

    private SoundRecognizerModule() {
    }

    @Provides
    @Singleton
    public final EnvSoundRecognizerService providesSoundRecognizerService(@ApplicationContext Context context, SharedAudioEngine sharedAudioEngine) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedAudioEngine, "sharedAudioEngine");
        return new EnvSoundRecognizerServiceImpl(context, sharedAudioEngine);
    }
}
