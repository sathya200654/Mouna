package com.deepvisiontech.letstalksigntranscriptionapp.current;

import com.deepvisiontech.letstalksigntranscriptionapp.current.common.di.ApplicationLifeCycleObserver;
import com.deepvisiontech.letstalksigntranscriptionapp.current.core.audiorecorder.data.local.AudioOrchestrator;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
public final class MyApp_MembersInjector implements MembersInjector<MyApp> {
    private final Provider<AudioOrchestrator> audioOrchestratorProvider;
    private final Provider<ApplicationLifeCycleObserver> lifeCycleObserverProvider;

    private MyApp_MembersInjector(Provider<ApplicationLifeCycleObserver> lifeCycleObserverProvider, Provider<AudioOrchestrator> audioOrchestratorProvider) {
        this.lifeCycleObserverProvider = lifeCycleObserverProvider;
        this.audioOrchestratorProvider = audioOrchestratorProvider;
    }

    public static MembersInjector<MyApp> create(Provider<ApplicationLifeCycleObserver> lifeCycleObserverProvider, Provider<AudioOrchestrator> audioOrchestratorProvider) {
        return new MyApp_MembersInjector(lifeCycleObserverProvider, audioOrchestratorProvider);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyApp instance) {
        injectLifeCycleObserver(instance, (ApplicationLifeCycleObserver) this.lifeCycleObserverProvider.get());
        injectAudioOrchestrator(instance, (AudioOrchestrator) this.audioOrchestratorProvider.get());
    }

    public static void injectLifeCycleObserver(MyApp instance, ApplicationLifeCycleObserver lifeCycleObserver) {
        instance.lifeCycleObserver = lifeCycleObserver;
    }

    public static void injectAudioOrchestrator(MyApp instance, AudioOrchestrator audioOrchestrator) {
        instance.audioOrchestrator = audioOrchestrator;
    }
}
