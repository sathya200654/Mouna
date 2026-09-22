package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class SchedulerModule_ProvidesComputeSchedulerFactory implements Factory<Scheduler> {
    private final SchedulerModule module;

    public SchedulerModule_ProvidesComputeSchedulerFactory(SchedulerModule schedulerModule) {
        this.module = schedulerModule;
    }

    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public Scheduler m2094get() {
        return providesComputeScheduler(this.module);
    }

    public static SchedulerModule_ProvidesComputeSchedulerFactory create(SchedulerModule schedulerModule) {
        return new SchedulerModule_ProvidesComputeSchedulerFactory(schedulerModule);
    }

    public static Scheduler providesComputeScheduler(SchedulerModule schedulerModule) {
        return (Scheduler) Preconditions.checkNotNullFromProvides(schedulerModule.providesComputeScheduler());
    }
}
