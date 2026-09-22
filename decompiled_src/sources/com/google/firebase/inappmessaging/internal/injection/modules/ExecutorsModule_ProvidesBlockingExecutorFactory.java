package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public final class ExecutorsModule_ProvidesBlockingExecutorFactory implements Factory<Executor> {
    private final ExecutorsModule module;

    public ExecutorsModule_ProvidesBlockingExecutorFactory(ExecutorsModule executorsModule) {
        this.module = executorsModule;
    }

    public Executor get() {
        return providesBlockingExecutor(this.module);
    }

    public static ExecutorsModule_ProvidesBlockingExecutorFactory create(ExecutorsModule executorsModule) {
        return new ExecutorsModule_ProvidesBlockingExecutorFactory(executorsModule);
    }

    public static Executor providesBlockingExecutor(ExecutorsModule executorsModule) {
        return (Executor) Preconditions.checkNotNullFromProvides(executorsModule.providesBlockingExecutor());
    }
}
