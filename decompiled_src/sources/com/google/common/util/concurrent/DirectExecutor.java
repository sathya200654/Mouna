package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes5.dex */
@ElementTypesAreNonnullByDefault
enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        command.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
