package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ExecutorsModule_ProvidesLightWeightExecutorFactory implements Factory<Executor> {
    private final ExecutorsModule module;

    public ExecutorsModule_ProvidesLightWeightExecutorFactory(ExecutorsModule executorsModule) {
        this.module = executorsModule;
    }

    public Executor get() {
        return providesLightWeightExecutor(this.module);
    }

    public static ExecutorsModule_ProvidesLightWeightExecutorFactory create(ExecutorsModule executorsModule) {
        return new ExecutorsModule_ProvidesLightWeightExecutorFactory(executorsModule);
    }

    public static Executor providesLightWeightExecutor(ExecutorsModule executorsModule) {
        return (Executor) Preconditions.checkNotNullFromProvides(executorsModule.providesLightWeightExecutor());
    }
}
