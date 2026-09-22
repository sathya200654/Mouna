package com.deepvisiontech.letstalksigntranscriptionapp.current;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.deepvisiontech.letstalksigntranscriptionapp.current.common.di.ApplicationLifeCycleObserver;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyApp.kt */
/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/deepvisiontech/letstalksigntranscriptionapp/current/MyApp;", "Landroid/app/Application;", "<init>", "()V", "lifeCycleObserver", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/di/ApplicationLifeCycleObserver;", "getLifeCycleObserver", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/di/ApplicationLifeCycleObserver;", "setLifeCycleObserver", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/common/di/ApplicationLifeCycleObserver;)V", "audioOrchestrator", "Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/AudioOrchestrator;", "getAudioOrchestrator", "()Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/AudioOrchestrator;", "setAudioOrchestrator", "(Lcom/deepvisiontech/letstalksigntranscriptionapp/current/core/audiorecorder/data/local/AudioOrchestrator;)V", "onCreate", "", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@HiltAndroidApp
public class MyApp extends Hilt_MyApp {
    public static final int $stable = 8;

    @Inject
    public AudioOrchestrator audioOrchestrator;

    @Inject
    public ApplicationLifeCycleObserver lifeCycleObserver;

    public final ApplicationLifeCycleObserver getLifeCycleObserver() {
        ApplicationLifeCycleObserver applicationLifeCycleObserver = this.lifeCycleObserver;
        if (applicationLifeCycleObserver != null) {
            return applicationLifeCycleObserver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleObserver");
        return null;
    }

    public final void setLifeCycleObserver(ApplicationLifeCycleObserver applicationLifeCycleObserver) {
        Intrinsics.checkNotNullParameter(applicationLifeCycleObserver, "<set-?>");
        this.lifeCycleObserver = applicationLifeCycleObserver;
    }

    public final AudioOrchestrator getAudioOrchestrator() {
        AudioOrchestrator audioOrchestrator = this.audioOrchestrator;
        if (audioOrchestrator != null) {
            return audioOrchestrator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioOrchestrator");
        return null;
    }

    public final void setAudioOrchestrator(AudioOrchestrator audioOrchestrator) {
        Intrinsics.checkNotNullParameter(audioOrchestrator, "<set-?>");
        this.audioOrchestrator = audioOrchestrator;
    }

    @Override // com.deepvisiontech.letstalksigntranscriptionapp.current.Hilt_MyApp, android.app.Application
    public void onCreate() {
        super.onCreate();
        LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.Companion.get();
        lifecycleOwner.getLifecycle().addObserver(getLifeCycleObserver());
        lifecycleOwner.getLifecycle().addObserver(getAudioOrchestrator());
    }
}
