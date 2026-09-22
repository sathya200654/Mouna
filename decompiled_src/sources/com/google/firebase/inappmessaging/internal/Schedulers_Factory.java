package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import io.reactivex.Scheduler;
import javax.inject.Provider;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class Schedulers_Factory implements Factory<Schedulers> {
    private final Provider<Scheduler> computeSchedulerProvider;
    private final Provider<Scheduler> ioSchedulerProvider;
    private final Provider<Scheduler> mainThreadSchedulerProvider;

    public Schedulers_Factory(Provider<Scheduler> provider, Provider<Scheduler> provider2, Provider<Scheduler> provider3) {
        this.ioSchedulerProvider = provider;
        this.computeSchedulerProvider = provider2;
        this.mainThreadSchedulerProvider = provider3;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Schedulers m2046get() {
        return newInstance((Scheduler) this.ioSchedulerProvider.get(), (Scheduler) this.computeSchedulerProvider.get(), (Scheduler) this.mainThreadSchedulerProvider.get());
    }

    public static Schedulers_Factory create(Provider<Scheduler> provider, Provider<Scheduler> provider2, Provider<Scheduler> provider3) {
        return new Schedulers_Factory(provider, provider2, provider3);
    }

    public static Schedulers newInstance(Scheduler scheduler, Scheduler scheduler2, Scheduler scheduler3) {
        return new Schedulers(scheduler, scheduler2, scheduler3);
    }
}
